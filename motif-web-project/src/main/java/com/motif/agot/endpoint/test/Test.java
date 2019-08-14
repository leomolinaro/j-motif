package com.motif.agot.endpoint.test;

import io.leangen.graphql.annotations.types.GraphQLInterface;

public class Test {

	@GraphQLInterface(name = "Zero")
    public interface Zero {}

    @GraphQLInterface(name = "One")
    public interface One {}

    @GraphQLInterface(name = "Two")
    public interface Two extends One {}

    @GraphQLInterface(name = "Three")
    public interface Three extends Zero, Two {}

    @GraphQLInterface(name = "Four")
    public interface Four {}

    @GraphQLInterface(name = "Parent")
    public static abstract class Parent implements Four {}

    public static class Child extends Parent implements Zero, Three {}
	
}
