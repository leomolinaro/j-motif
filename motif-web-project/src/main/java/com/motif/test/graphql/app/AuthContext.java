package com.motif.test.graphql.app;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.motif.test.graphql.model.User;

import graphql.servlet.GraphQLContext;
import lombok.Getter;

public class AuthContext extends GraphQLContext {
    
    @Getter private final User user;
    
    public AuthContext(User user, Optional<HttpServletRequest> request, Optional<HttpServletResponse> response) {
        super(request, response);
        this.user = user;
    }

}
