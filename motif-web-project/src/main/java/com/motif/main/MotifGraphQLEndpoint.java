package com.motif.main;

import javax.servlet.annotation.WebServlet;

import com.motif.agot.endpoint.AgotEndpoint;

import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLServlet;
import io.leangen.graphql.GraphQLSchemaGenerator;
import io.leangen.graphql.metadata.strategy.query.AnnotatedResolverBuilder;
import io.leangen.graphql.metadata.strategy.query.PublicResolverBuilder;

@WebServlet(urlPatterns = "/motif/graphql")
public class MotifGraphQLEndpoint extends SimpleGraphQLServlet {

	private static final long serialVersionUID = 987890217510129756L;

	private static AgotEndpoint agotEndpoint = AgotEndpoint.getInstance ();
	
	static {
		System.out.println("CIAO");
    }
	
	public MotifGraphQLEndpoint() {
        super(buildSchema());
    }

    private static GraphQLSchema buildSchema() {
        return new GraphQLSchemaGenerator()
        		.withResolverBuilders(
        				new AnnotatedResolverBuilder(),
        				//new PublicResolverBuilder("com.motif.test.graphql"),
        				new PublicResolverBuilder("com.motif.agot")
        		)
                .withOperationsFromSingletons(agotEndpoint)
                //.withOperationsFromSingletons(userService)
                .withNestedResolverBuilders(new AnnotatedResolverBuilder()) // Only the annotated stuff gets exposed (default is AnnotatedResolverBuilder + BeanResolverBuilder) 
                //.withNestedResolverBuildersForType(Link.class, new BeanResolverBuilder("com.motif.test.graphql.service"))
                //.withNestedResolverBuildersForType(Link.class, signinResolver)
                .generate();
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