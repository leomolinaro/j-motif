package com.motif.agot.endpoint.test;

import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.annotations.types.GraphQLType;

@GraphQLType ()
public class A implements IA {

	@GraphQLQuery public String asd () { return "ASD"; }
	
}
