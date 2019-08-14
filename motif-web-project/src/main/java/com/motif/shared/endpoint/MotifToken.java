package com.motif.shared.endpoint;

import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.Getter;

public class MotifToken {

	public MotifToken () {}
	
	public MotifToken (String token) {
		this.token = token;
	} // MotifToken
	
	@Getter
	@GraphQLQuery
	public String token;
	
}
