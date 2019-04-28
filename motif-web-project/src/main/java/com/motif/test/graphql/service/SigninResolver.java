package com.motif.test.graphql.service;

import com.motif.test.graphql.model.SigninPayload;
import com.motif.test.graphql.model.User;

import io.leangen.graphql.annotations.GraphQLQuery;

public class SigninResolver {
	
	@GraphQLQuery
	public User user(SigninPayload payload) {
        return payload.getUser();
    }

}
