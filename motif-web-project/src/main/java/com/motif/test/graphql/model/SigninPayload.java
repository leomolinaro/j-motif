package com.motif.test.graphql.model;

import lombok.Getter;

public class SigninPayload {
    
    @Getter private final String token;
    @Getter private final User user;

    public SigninPayload(String token, User user) {
        this.token = token;
        this.user = user;
    }

}
