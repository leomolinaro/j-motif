package com.motif.test.graphql.app;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.motif.test.graphql.model.LinkRepository;
import com.motif.test.graphql.model.User;
import com.motif.test.graphql.model.UserRepository;
import com.motif.test.graphql.service.LinkService;
import com.motif.test.graphql.service.UserService;

import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;
import graphql.schema.GraphQLSchema;
import graphql.servlet.GraphQLContext;
import graphql.servlet.SimpleGraphQLServlet;
import io.leangen.graphql.GraphQLSchemaGenerator;
import io.leangen.graphql.metadata.strategy.query.AnnotatedResolverBuilder;
import io.leangen.graphql.metadata.strategy.query.PublicResolverBuilder;

@WebServlet(urlPatterns = "/graphql")
public class GraphQLEndpoint extends SimpleGraphQLServlet {

	private static final long serialVersionUID = 987890217510129756L;

	private static final LinkRepository linkRepository;
	private static final UserRepository userRepository;
	
	static {
		System.out.println("CIAO");
        //Change to `new MongoClient("mongodb://<host>:<port>/hackernews")`
        //if you don't have Mongo running locally on port 27017
        @SuppressWarnings("resource")
		MongoDatabase mongo = new MongoClient("127.0.0.1", 27017).getDatabase("graphql");
        linkRepository = new LinkRepository(mongo.getCollection("links"));
        userRepository = new UserRepository(mongo.getCollection("users"));
    }
	
	public GraphQLEndpoint() {
        super(buildSchema());
    }

    private static GraphQLSchema buildSchema() {
    	var linkService = new LinkService(linkRepository, userRepository);
    	var userService = new UserService(userRepository);
        return new GraphQLSchemaGenerator()
        		.withResolverBuilders(
        				new AnnotatedResolverBuilder(),
        				new PublicResolverBuilder("com.motif.test.graphql"),
        				new PublicResolverBuilder("com.motif.agot.state")
        		)
                .withOperationsFromSingletons(linkService)
                .withOperationsFromSingletons(userService)
                .withNestedResolverBuilders(new AnnotatedResolverBuilder()) // Only the annotated stuff gets exposed (default is AnnotatedResolverBuilder + BeanResolverBuilder) 
                //.withNestedResolverBuildersForType(Link.class, new BeanResolverBuilder("com.motif.test.graphql.service"))
                //.withNestedResolverBuildersForType(Link.class, signinResolver)
                .generate();
    }

	@Override
	protected GraphQLContext createContext(Optional<HttpServletRequest> request, Optional<HttpServletResponse> response) {
		User user = request
	        .map(req -> req.getHeader("Authorization"))
	        .filter(id -> !id.isEmpty())
	        .map(id -> id.replace("Bearer ", ""))
	        .map(userRepository::findById)
	        .orElse(null);
	    return new AuthContext(user, request, response);
	}
    
	@Override
	protected List<GraphQLError> filterGraphQLErrors(List<GraphQLError> errors) {
	    return errors.stream()
            .filter(e -> e instanceof ExceptionWhileDataFetching || super.isClientError(e))
            .map(e -> e instanceof ExceptionWhileDataFetching ? new SanitizedError((ExceptionWhileDataFetching) e) : e)
            .collect(Collectors.toList());
	}

}