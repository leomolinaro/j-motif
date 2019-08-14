package com.motif.agot.endpoint.test;

import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.annotations.types.GraphQLInterface;

@GraphQLInterface(name = "IA", implementationAutoDiscovery = true)
public interface IA {

	@GraphQLQuery public default String iii () { return "Ciao"; }
	
}
