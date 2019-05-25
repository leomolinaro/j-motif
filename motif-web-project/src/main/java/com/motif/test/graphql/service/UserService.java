package com.motif.test.graphql.service;

import java.util.List;

import com.motif.test.graphql.model.AuthData;
import com.motif.test.graphql.model.SigninPayload;
import com.motif.test.graphql.model.User;
import com.motif.test.graphql.model.UserRepository;

import graphql.GraphQLException;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;

public class UserService {
    
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @GraphQLQuery(name = "users")
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
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
    
    @GraphQLQuery
	public User user(SigninPayload payload) {
        return payload.getUser();
    }
    
}