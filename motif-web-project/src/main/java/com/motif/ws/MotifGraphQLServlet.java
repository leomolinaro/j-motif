package com.motif.ws;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import graphql.servlet.GraphQLConfiguration;
import graphql.servlet.GraphQLHttpServlet;

@WebServlet(urlPatterns = "/motif/graphql")
public class MotifGraphQLServlet extends GraphQLHttpServlet {
	
	private static final long serialVersionUID = 987890217510129756L;

	static {
		System.out.println("Start MotifGraphQLEndpoint");
    }
	
	@Override
	protected GraphQLConfiguration getConfiguration () {
		return MotifGraphQLConfigurator.getConfiguration ();
	}
	
	@Override
	protected void doOptions (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MotifGraphQLConfigurator.setAccessControlHeaders (resp);
		super.doOptions (req, resp);
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