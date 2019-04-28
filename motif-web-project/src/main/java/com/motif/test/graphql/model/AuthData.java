package com.motif.test.graphql.model;

import lombok.Getter;
import lombok.Setter;

public class AuthData {

    @Getter @Setter private String email;
    @Getter @Setter private String password;

    public AuthData() {
    }

    public AuthData(String email, String password) {
        this.email = email;
        this.password = password;
    }

}
