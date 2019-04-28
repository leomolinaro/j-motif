package com.motif.test.graphql.service;

import com.motif.test.graphql.app.AuthContext;
import com.motif.test.graphql.model.AuthData;
import com.motif.test.graphql.model.Link;
import com.motif.test.graphql.model.LinkRepository;
import com.motif.test.graphql.model.SigninPayload;
import com.motif.test.graphql.model.User;
import com.motif.test.graphql.model.UserRepository;

import graphql.GraphQLException;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLRootContext;

public class Mutation {
    
    private final LinkRepository linkRepository;
    private final UserRepository userRepository;

    public Mutation(LinkRepository linkRepository, UserRepository userRepository) {
        this.linkRepository = linkRepository;
        this.userRepository = userRepository;
    }
    
    @GraphQLMutation
    public Link createLink(String url, String description, @GraphQLRootContext AuthContext context) {
        Link newLink = new Link(url, description, context.getUser().getId());
        linkRepository.saveLink(newLink);
        return newLink;
    }
    
    @GraphQLMutation
    public User createUser(String name, AuthData auth) {
        User newUser = new User(name, auth.getEmail(), auth.getPassword());
        return userRepository.saveUser(newUser);
    }
    
    @GraphQLMutation
    public User deleteUser(String id) {
    	return userRepository.deleteUser(id);
    }
    
    @GraphQLMutation
    public SigninPayload signinUser(AuthData auth) throws IllegalAccessException {
        User user = userRepository.findByEmail(auth.getEmail());
        if (user.getPassword().equals(auth.getPassword())) {
            return new SigninPayload(user.getId(), user);
        }
        throw new GraphQLException("Invalid credentials");
    }
    
}