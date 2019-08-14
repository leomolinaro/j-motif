package com.motif.ws;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.websocket.CloseReason;
import javax.websocket.EndpointConfig;
import javax.websocket.HandshakeResponse;
import javax.websocket.MessageHandler;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpoint;
import javax.websocket.server.ServerEndpointConfig;
import javax.websocket.server.ServerEndpointConfig.Configurator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import graphql.servlet.GraphQLWebsocketServlet;
import graphql.servlet.core.GraphQLObjectMapper;
import graphql.servlet.core.GraphQLQueryInvoker;
import graphql.servlet.core.SubscriptionConnectionListener;
import graphql.servlet.core.internal.ApolloSubscriptionProtocolFactory;
import graphql.servlet.core.internal.FallbackSubscriptionProtocolFactory;
import graphql.servlet.core.internal.SubscriptionHandlerInput;
import graphql.servlet.core.internal.SubscriptionProtocolFactory;
import graphql.servlet.core.internal.SubscriptionProtocolHandler;
import graphql.servlet.core.internal.WsSessionSubscriptions;
import graphql.servlet.input.GraphQLInvocationInputFactory;

//import graphql.servlet.GraphQLInvocationInputFactory;
//import graphql.servlet.GraphQLObjectMapper;
//import graphql.servlet.GraphQLQueryInvoker;
//import graphql.servlet.GraphQLWebsocketServlet;
//import graphql.servlet.SubscriptionConnectionListener;
//import graphql.servlet.internal.ApolloSubscriptionProtocolFactory;
//import graphql.servlet.internal.FallbackSubscriptionProtocolFactory;
//import graphql.servlet.internal.SubscriptionHandlerInput;
//import graphql.servlet.internal.SubscriptionProtocolFactory;
//import graphql.servlet.internal.SubscriptionProtocolHandler;
//import graphql.servlet.internal.WsSessionSubscriptions;

@ServerEndpoint(
	value = "/motif/graphql-ws",
	configurator = MotifGraphQLEndpoint.class
)
public class MotifGraphQLEndpoint extends Configurator {

	public MotifGraphQLEndpoint () {
		this (
				MotifGraphQLConfigurator.getConfiguration ().getQueryInvoker (),
				MotifGraphQLConfigurator.getConfiguration ().getInvocationInputFactory (),
				MotifGraphQLConfigurator.getConfiguration ().getObjectMapper (),
				null
		);
	}
	
	
	private static final Logger log = LoggerFactory.getLogger(GraphQLWebsocketServlet.class);

    private static final String HANDSHAKE_REQUEST_KEY = HandshakeRequest.class.getName();
    private static final String PROTOCOL_HANDLER_REQUEST_KEY = SubscriptionProtocolHandler.class.getName();
    private static final CloseReason ERROR_CLOSE_REASON = new CloseReason(CloseReason.CloseCodes.UNEXPECTED_CONDITION, "Internal Server Error");
    private static final CloseReason SHUTDOWN_CLOSE_REASON = new CloseReason(CloseReason.CloseCodes.UNEXPECTED_CONDITION, "Server Shut Down");

    private final List<SubscriptionProtocolFactory> subscriptionProtocolFactories;
    private final SubscriptionProtocolFactory fallbackSubscriptionProtocolFactory;
    private final List<String> allSubscriptionProtocols;

    private final Map<Session, WsSessionSubscriptions> sessionSubscriptionCache = new ConcurrentHashMap<>();
    private final SubscriptionHandlerInput subscriptionHandlerInput;
    private final AtomicBoolean isShuttingDown = new AtomicBoolean(false);
    private final AtomicBoolean isShutDown = new AtomicBoolean(false);
    private final Object cacheLock = new Object();


    public MotifGraphQLEndpoint(GraphQLQueryInvoker queryInvoker, GraphQLInvocationInputFactory invocationInputFactory, GraphQLObjectMapper graphQLObjectMapper, SubscriptionConnectionListener subscriptionConnectionListener) {
        this.subscriptionHandlerInput = new SubscriptionHandlerInput(invocationInputFactory, queryInvoker, graphQLObjectMapper, subscriptionConnectionListener);

        subscriptionProtocolFactories = Collections.singletonList(new ApolloSubscriptionProtocolFactory(subscriptionHandlerInput));
        fallbackSubscriptionProtocolFactory = new FallbackSubscriptionProtocolFactory(subscriptionHandlerInput);
        allSubscriptionProtocols = Stream.concat(subscriptionProtocolFactories.stream(), Stream.of(fallbackSubscriptionProtocolFactory))
                                         .map(SubscriptionProtocolFactory::getProtocol)
                                         .collect(Collectors.toList());
    }

    @OnOpen
    public void onOpen(Session session, EndpointConfig endpointConfig) {
        final WsSessionSubscriptions subscriptions = new WsSessionSubscriptions();
        final HandshakeRequest request = (HandshakeRequest) session.getUserProperties().get(HANDSHAKE_REQUEST_KEY);
        final SubscriptionProtocolHandler subscriptionProtocolHandler = (SubscriptionProtocolHandler) session.getUserProperties().get(PROTOCOL_HANDLER_REQUEST_KEY);

        synchronized (cacheLock) {
            if (isShuttingDown.get()) {
                throw new IllegalStateException("Server is shutting down!");
            }

            sessionSubscriptionCache.put(session, subscriptions);
        }

        log.debug("Session opened: {}, {}", session.getId(), endpointConfig);

        // This *cannot* be a lambda because of the way undertow checks the class...
        session.addMessageHandler(new MessageHandler.Whole<String>() {
            @Override
            public void onMessage(String text) {
                try {
                    subscriptionProtocolHandler.onMessage(request, session, subscriptions, text);
                } catch (Throwable t) {
                    log.error("Error executing websocket query for session: {}", session.getId(), t);
                    closeUnexpectedly(session, t);
                }
            }
        });
    }

    @OnClose
    public void onClose(Session session, CloseReason closeReason) {
        log.debug("Session closed: {}, {}", session.getId(), closeReason);
        WsSessionSubscriptions subscriptions;
        synchronized (cacheLock) {
            subscriptions = sessionSubscriptionCache.remove(session);
        }
        if (subscriptions != null) {
            subscriptions.close();
        }
    }

    @OnError
    public void onError(Session session, Throwable thr) {
        log.error("Error in websocket session: {}", session.getId(), thr);
        closeUnexpectedly(session, thr);
    }

    private void closeUnexpectedly(Session session, Throwable t) {
        try {
            session.close(ERROR_CLOSE_REASON);
        } catch (IOException e) {
            log.error("Error closing websocket session for session: {}", session.getId(), t);
        }
    }

    public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
        sec.getUserProperties().put(HANDSHAKE_REQUEST_KEY, request);

        List<String> protocol = request.getHeaders().get(HandshakeRequest.SEC_WEBSOCKET_PROTOCOL);
        if (protocol == null) {
            protocol = Collections.emptyList();
        }

        SubscriptionProtocolFactory subscriptionProtocolFactory = getSubscriptionProtocolFactory(protocol);
        sec.getUserProperties().put(PROTOCOL_HANDLER_REQUEST_KEY, subscriptionProtocolFactory.createHandler());

        if (request.getHeaders().get(HandshakeResponse.SEC_WEBSOCKET_ACCEPT) != null) {
            response.getHeaders().put(HandshakeResponse.SEC_WEBSOCKET_ACCEPT, allSubscriptionProtocols);
        }
        if (!protocol.isEmpty()) {
            response.getHeaders().put(HandshakeRequest.SEC_WEBSOCKET_PROTOCOL, Collections.singletonList(subscriptionProtocolFactory.getProtocol()));
        }
    }

    /**
     * Stops accepting connections and closes all existing connections
     */
    public void beginShutDown() {
        synchronized (cacheLock) {
            isShuttingDown.set(true);
            Map<Session, WsSessionSubscriptions> copy = new HashMap<>(sessionSubscriptionCache);

            // Prevent comodification exception since #onClose() is called during session.close(), but we can't necessarily rely on that happening so we close subscriptions here anyway.
            copy.forEach((session, wsSessionSubscriptions) -> {
                wsSessionSubscriptions.close();
                try {
                    session.close(SHUTDOWN_CLOSE_REASON);
                } catch (IOException e) {
                    log.error("Error closing websocket session!", e);
                }
            });

            copy.clear();

            if(!sessionSubscriptionCache.isEmpty()) {
                log.error("GraphQLWebsocketServlet did not shut down cleanly!");
                sessionSubscriptionCache.clear();
            }
        }

        isShutDown.set(true);
    }

    /**
     * @return true when shutdown is complete
     */
    public boolean isShutDown() {
        return isShutDown.get();
    }

    private SubscriptionProtocolFactory getSubscriptionProtocolFactory(List<String> accept) {
        for (String protocol : accept) {
            for (SubscriptionProtocolFactory subscriptionProtocolFactory : subscriptionProtocolFactories) {
                if (subscriptionProtocolFactory.getProtocol().equals(protocol)) {
                    return subscriptionProtocolFactory;
                }
            }
        }

        return fallbackSubscriptionProtocolFactory;
    }

    public int getSessionCount() {
        return sessionSubscriptionCache.size();
    }
	
}
