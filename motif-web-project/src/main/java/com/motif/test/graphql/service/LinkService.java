package com.motif.test.graphql.service;

import java.util.List;

import com.motif.test.graphql.app.AuthContext;
import com.motif.test.graphql.model.Link;
import com.motif.test.graphql.model.LinkRepository;
import com.motif.test.graphql.model.User;
import com.motif.test.graphql.model.UserRepository;

import io.leangen.graphql.annotations.GraphQLContext;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.annotations.GraphQLRootContext;

public class LinkService {
    
    private final LinkRepository linkRepository;
    private final UserRepository userRepository;

    public LinkService(LinkRepository linkRepository, UserRepository userRepository) {
        this.linkRepository = linkRepository;
        this.userRepository = userRepository;
    }

    @GraphQLQuery(name = "links")
    public List<Link> getAllLinks() {
        return linkRepository.getAllLinks();
    }
    
    @GraphQLQuery
    public User postedBy(@GraphQLContext Link link) {
        if (link.getUserId() == null) {
            return null;
        }
        return userRepository.findById(link.getUserId());
    }
    
    @GraphQLMutation
    public Link createLink(String url, String description, @GraphQLRootContext AuthContext context) {
        Link newLink = new Link(url, description, context.getUser().getId());
        linkRepository.saveLink(newLink);
        return newLink;
    }
    
}