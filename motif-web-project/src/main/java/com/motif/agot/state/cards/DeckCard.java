package com.motif.agot.state.cards;

import java.util.ArrayList;

import com.motif.agot.ang.cards.AngDeckCard;
import com.motif.agot.ang.enums.AngToken;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.state.AgotPlayer;

public abstract class DeckCard<A extends AngDeckCard> extends TextCard<A> {

	public DeckCard (A ang, AgotPlayer owner) {
		super (ang, owner);
	} // DeckCard
	
	/********************************************************************************/
	/****  TOKENS  ******************************************************************/
	/********************************************************************************/
	
	private ArrayList<AngToken> tokens = null;
	
	public void addToken (AngToken token, AgotContext context) {
		if (tokens == null) { tokens = new ArrayList<AngToken> (); }
		tokens.add (token);
	} // addToken
	
	public void removeToken (AngToken token, AgotContext context) {
		tokens.remove (token);
		if (tokens.isEmpty ()) { tokens = null; }
	} // removeToken
	
	public boolean hasToken (AngToken token) {
		return tokens != null && tokens.contains (token);
	} // hasToken
	
} // DeckCard
