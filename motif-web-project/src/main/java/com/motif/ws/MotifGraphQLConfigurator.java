package com.motif.ws;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.motif.agot.endpoint.AgotEndpoint;
import com.motif.shared.endpoint.MotifEndpoint;

import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;
import graphql.schema.GraphQLSchema;
import graphql.servlet.config.GraphQLConfiguration;
import graphql.servlet.core.GraphQLErrorHandler;
import graphql.servlet.core.GraphQLObjectMapper;
import graphql.servlet.core.GraphQLServletListener;
import io.leangen.graphql.GraphQLSchemaGenerator;
import io.leangen.graphql.metadata.strategy.query.AnnotatedResolverBuilder;
import io.leangen.graphql.metadata.strategy.value.jackson.JacksonValueMapperFactory;

public class MotifGraphQLConfigurator {

	private static MotifEndpoint motifEndpoint = MotifEndpoint.getInstance();
	private static AgotEndpoint agotEndpoint = AgotEndpoint.getInstance();
	
	private static GraphQLConfiguration configuration;
	
	public static GraphQLConfiguration getConfiguration () {
		if (configuration == null) {
			var objectMapper = GraphQLObjectMapper.newBuilder ()
				    .withGraphQLErrorHandler (new MotifGraphQLErrorHandler ())
				    .build ();
			
		    var listener = new MotifGraphQLServletListener ();
		    
			var graphqlSchema = buildSchema ();
			graphqlSchema.getAllTypesAsList ().forEach (t -> System.out.println (t.getName ()));
			
			configuration = GraphQLConfiguration
					.with (graphqlSchema)
					.with (objectMapper)
					.with (Arrays.asList(listener))
					.build ();
		}
		return configuration;
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
	
	private static class MotifGraphQLServletListener implements GraphQLServletListener {
		
		@Override
	    public RequestCallback onRequest(HttpServletRequest request, HttpServletResponse response) {	
//	        System.out.println("onRequest:" + request.getRequestURI());
	        setAccessControlHeaders (response);
	        //TODO cookies here
	        // response.addCookie(new Cookie("sample","test"));
	        
	        return new RequestCallback() {
	            @Override
	            public void onSuccess(HttpServletRequest request, HttpServletResponse response) {
	            }
	
	            @Override
	            public void onError(HttpServletRequest request, HttpServletResponse response, Throwable throwable) {
	            	System.out.println (throwable.getStackTrace ());
	            }
	            
	            @Override 
	            public void onFinally(HttpServletRequest request, HttpServletResponse response) { }
	        };
	    }
		
	}
	
	public static void setAccessControlHeaders(HttpServletResponse resp) {
		resp.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
		resp.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
		resp.setHeader("Access-Control-Max-Age", "3600");
		resp.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization, Content-Length, X-Requested-With");
	}
	
	private static GraphQLSchema buildSchema () {
        return new GraphQLSchemaGenerator ()
//        		.withBasePackages ("com.motif.agot")
        		.withResolverBuilders (
        				new AnnotatedResolverBuilder ()
        		)
                .withOperationsFromSingletons (motifEndpoint, agotEndpoint)
                .withNestedResolverBuilders(new AnnotatedResolverBuilder()) // Only the annotated stuff gets exposed (default is AnnotatedResolverBuilder + BeanResolverBuilder)
                .withValueMapperFactory (new JacksonValueMapperFactory ())
                .generate();
    }
	
}
