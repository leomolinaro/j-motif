package com.motif.agot.logic.requests;

import java.util.ArrayList;
import java.util.List;

import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.flow.IAgotFlowRequest;
import com.motif.agot.state.AgotPlayer;

import io.leangen.graphql.annotations.GraphQLQuery;

public abstract class AAgotRequest implements IAgotFlowRequest {

	public enum AgotRequestType {
		SELECT_CARD_TO_SETUP,
		SELECT_ACTION_TO_PERFORM,
		SELECT_REACTION_TO_PERFORM,
		SELECT_INTERRUPT_TO_PERFORM,
		SELECT_CHARACTER_TO_KILL,
		SELECT_CHARACTER_TO_DEFEND,
		SELECT_CHALLENGE_TO_INITIATE,
		SELECT_CHARACTER_TO_ATTACK,
		SELECT_CHARACTER_TO_BYPASS,
		SELECT_DEFENDER,
		SELECT_PLOT_TO_REVEAL,
		SELECT_WHEN_REVEALED_TO_PERFORM,
		SELECT_FIRST_PLAYER,
		SELECT_CARD_TO_ATTACH,
		SELECT_CARD_TO_DISCARD,
		CHOOSE_CARD,
		CONTINUE,
		DRAW,
		YES_NO
	} // AgotRequestType
	
	private final AgotRequestType type;
	@GraphQLQuery (name = "type") public AgotRequestType getType () { return this.type; }
	
	private final AgotPlayer player;
	@GraphQLQuery (name = "player") public AgotPlayer getPlayer () { return this.player; }
	
	private final String instruction;
	@GraphQLQuery (name = "instruction") public String getInstruction () { return this.instruction; }
	
	public AAgotRequest (AgotRequestType type, AgotPlayer player, String instruction) {
		this.type = type;
		this.player = player;
		this.instruction = instruction;
	} // AAgotRequest
	
	private final List<AgotChoice> choices = new ArrayList<> ();
	@GraphQLQuery (name = "choices") public List<AgotChoice> getChoices () { return this.choices; }
	protected void addChoice (AgotChoice choice) {
		choice.setRequestType (this.type);
		this.choices.add (choice);
	} // addChoice
	
	@Override public String toString () {
		StringBuilder s = new StringBuilder(this.instruction).append ("\n");
		for (var choice : this.choices) {
			s.append(choice).append ("\n");
		}
		return s.toString();
	}
	
	@Override
	public boolean accept (AgotChoice choice, AgotContext context) {
		if (!this.choices.contains (choice)) { return false; }
		return this.acceptChoice (choice, context);
	}

	protected abstract boolean acceptChoice (AgotChoice choice, AgotContext context);
	
}
