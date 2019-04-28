package com.motif.test.graphql.model;

import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.Getter;

public class Link {
    
	@Getter private final String id;
	@Getter private final String url;
	private final String description;
	@Getter private final String userId;
	
    public Link(String url, String description, String userId) {
    	this(null, url, description, userId);
    }
    
    public Link(String id, String url, String description, String userId) {
    	this.id = id;
        this.url = url;
        this.description = description;
        this.userId = userId;
    }

    @GraphQLQuery(name = "description")
	public String getDescription() {
		return description;
	}
    
    

}
