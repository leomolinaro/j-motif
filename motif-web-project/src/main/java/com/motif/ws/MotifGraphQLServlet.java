package com.motif.ws;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import graphql.servlet.GraphQLHttpServlet;
import graphql.servlet.config.GraphQLConfiguration;

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
    
}