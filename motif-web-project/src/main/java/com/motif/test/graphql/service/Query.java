package com.motif.test.graphql.service;

import java.util.List;

import com.motif.test.graphql.model.Link;
import com.motif.test.graphql.model.LinkRepository;
import com.motif.test.graphql.model.User;
import com.motif.test.graphql.model.UserRepository;

import io.leangen.graphql.annotations.GraphQLQuery;

public class Query {
    
    private final LinkRepository linkRepository;
    private final UserRepository userRepository;

    public Query(LinkRepository linkRepository, UserRepository userRepository) {
        this.linkRepository = linkRepository;
        this.userRepository = userRepository;
    }

    @GraphQLQuery(name = "links")
    public List<Link> getAllLinks() {
        return linkRepository.getAllLinks();
    }
    
    @GraphQLQuery(name = "users")
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }
}