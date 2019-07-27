package com.motif.ws;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.motif.agot.endpoint.AgotEndpoint;

import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;
import graphql.schema.GraphQLSchema;
import graphql.servlet.GraphQLConfiguration;
import graphql.servlet.GraphQLErrorHandler;
import graphql.servlet.GraphQLHttpServlet;
import graphql.servlet.GraphQLObjectMapper;
import graphql.servlet.GraphQLServletListener;
import io.leangen.graphql.GraphQLSchemaGenerator;
import io.leangen.graphql.metadata.strategy.query.AnnotatedResolverBuilder;
import io.leangen.graphql.metadata.strategy.value.jackson.JacksonValueMapperFactory;

@WebServlet(urlPatterns = "/motif/graphql")
public class MotifGraphQLEndpoint extends GraphQLHttpServlet {
	
	private static final long serialVersionUID = 987890217510129756L;

	private static AgotEndpoint agotEndpoint = AgotEndpoint.getInstance();
	
	static {
		System.out.println("Start MotifGraphQLEndpoint");
    }
	
	@Override
	protected GraphQLConfiguration getConfiguration () {
		
		var objectMapper = GraphQLObjectMapper.newBuilder ()
			    .withGraphQLErrorHandler (new MotifGraphQLErrorHandler ())
			    .build ();
		
	    var listener = new MotifGraphQLServletListener ();
	    
		var graphqlSchema = buildSchema ();
		
		return GraphQLConfiguration
				.with (graphqlSchema)
				.with (objectMapper)
				.with (Arrays.asList(listener))
				.build ();
	}
	
	private static class MotifGraphQLErrorHandler implements GraphQLErrorHandler {

		@Override
		public List<GraphQLError> processErrors (List<GraphQLError> errors) {
			errors.forEach (error -> {
				if (error instanceof ExceptionWhileDataFetching) {
					var exc = (ExceptionWhileDataFetching) error;
					exc.getException ().printStackTrace ();
				} else {
					System.out.println (error.getClass ());
					System.out.println (error.getMessage ());
				}
			});
			return errors;
		}
		
	}
	
	@Override
	protected void doOptions (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		setAccessControlHeaders (resp);
		super.doOptions (req, resp);
	}
	
    private static GraphQLSchema buildSchema() {
        return new GraphQLSchemaGenerator()
        		.withResolverBuilders(
        				new AnnotatedResolverBuilder()//,
        				//new PublicResolverBuilder("com.motif.test.graphql"),
        				//new PublicResolverBuilder("com.motif.agot")
        		)
                .withOperationsFromSingletons(agotEndpoint)
                //.withOperationsFromSingletons(userService)
                //.withValueMapperFactory(new JacksonValueMapperFactory())
                .withNestedResolverBuilders(new AnnotatedResolverBuilder()) // Only the annotated stuff gets exposed (default is AnnotatedResolverBuilder + BeanResolverBuilder) 
                //.withNestedResolverBuildersForType(Link.class, new BeanResolverBuilder("com.motif.test.graphql.service"))
                //.withNestedResolverBuildersForType(Link.class, signinResolver)
                .withValueMapperFactory(new JacksonValueMapperFactory())
                .generate();
    }
    
    private static class MotifGraphQLServletListener implements GraphQLServletListener {
    		
		@Override
	    public RequestCallback onRequest(HttpServletRequest request, HttpServletResponse response) {	
	        System.out.println("onRequest:" + request.getRequestURI());
	        //TODO cookies here
	        // response.addCookie(new Cookie("sample","test"));
	
	        return new RequestCallback() {
	            @Override
	            public void onSuccess(HttpServletRequest request, HttpServletResponse response) {
	            	setAccessControlHeaders (response);
	            }
	
	            @Override
	            public void onError(HttpServletRequest request, HttpServletResponse response, Throwable throwable) {
	            	System.out.println (throwable.getStackTrace ());
	            	setAccessControlHeaders (response);
	            }
	            
	            @Override 
	            public void onFinally(HttpServletRequest request, HttpServletResponse response) { }
	        };
	    }
		
	}
    
    private static void setAccessControlHeaders(HttpServletResponse resp) {
		resp.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
		resp.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
		resp.setHeader("Access-Control-Max-Age", "3600");
		resp.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization, Content-Length, X-Requested-With");
	}
    
    
//	@Override
//	protected GraphQLContext createContext(Optional<HttpServletRequest> request, Optional<HttpServletResponse> response) {
//		User user = request
//	        .map(req -> req.getHeader("Authorization"))
//	        .filter(id -> !id.isEmpty())
//	        .map(id -> id.replace("Bearer ", ""))
//	        .map(userRepository::findById)
//	        .orElse(null);
//	    return new AuthContext(user, request, response);
//	}
    
//	@Override
//	protected List<GraphQLError> filterGraphQLErrors(List<GraphQLError> errors) {
//	    return errors.stream()
//            .filter(e -> e instanceof ExceptionWhileDataFetching || super.isClientError(e))
//            .map(e -> e instanceof ExceptionWhileDataFetching ? new SanitizedError((ExceptionWhileDataFetching) e) : e)
//            .collect(Collectors.toList());
//	}

}