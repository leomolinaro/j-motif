package com.motif.test.graphql.model;

import java.util.HashMap;

import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.Getter;

public class Link {
    
	@Getter private final String id;
	@Getter private final String url;
	@Getter(onMethod=@__(@GraphQLQuery(name = "description")))
	private final String description;
	@Getter private final String userId;
	@Getter(onMethod=@__(@GraphQLQuery(name = "map")))
	private final HashMap<Integer, String> map = new HashMap<Integer, String>();
	
    public Link(String url, String description, String userId) {
    	this(null, url, description, userId);
    }
    
    public Link(String id, String url, String description, String userId) {
    	this.id = id;
        this.url = url;
        this.description = description;
        this.userId = userId;
        this.map.put(1, "Uno");
        this.map.put(2, "Due");
    }

//    @GraphQLQuery(name = "description")
//	public String getDescription() {
//		return description;
//	}
    
    

}
