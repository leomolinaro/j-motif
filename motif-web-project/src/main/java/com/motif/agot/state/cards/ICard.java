package com.motif.agot.state.cards;

import java.util.ArrayList;

import com.motif.agot.ang.sets.AgotCardSeed;

import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.annotations.types.GraphQLType;

@GraphQLType(name = "Card")
public interface ICard {

	@GraphQLQuery public long id ();
	@GraphQLQuery public String imageSource ();
	@GraphQLQuery public AgotCardSeed seed ();
	@GraphQLQuery public int power ();
	@GraphQLQuery public boolean kneeling ();
	@GraphQLQuery public boolean revealed ();
	@GraphQLQuery public default ArrayList<Long> attachmentIds () { return null; }
	@GraphQLQuery public default ArrayList<Long> duplicateIds () { return null; }
	
}
