package com.motif.test.graphql.model;

import lombok.Getter;

public class User {
    
    @Getter private final String id;
    @Getter private final String name;
    @Getter private final String email;
    @Getter private final String password;

    public User(String name, String email, String password) {
        this(null, name, email, password);
    }
    
    public User(String id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

}
