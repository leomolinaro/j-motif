package com.motif.agot.logic.requests;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.flow.AgotResponse;
import com.motif.agot.logic.flow.IAgotFlowRequest;
import com.motif.agot.state.AgotPlayer;

import lombok.Getter;

public abstract class AAgotRequest implements IAgotFlowRequest {

	public enum AgotRequestType {
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
		SELECT_FIRST_PLAYER,
		SELECT_CARD_TO_ATTACH,
		SELECT_CARD_TO_DISCARD,
		CHOOSE_CARD,
		CONTINUE
	}
	
	@Getter @Expose private final AgotRequestType type;
	@Getter private final AgotPlayer player;
	@Expose private final String playerId;
	@Expose private final String instruction;
	
	public AAgotRequest(AgotRequestType type, AgotPlayer player, String instruction) {
		this.type = type;
		this.player = player;
		this.playerId = player.id();
		this.instruction = instruction;
	}
	
	@Expose private final List<AgotChoice> choices = new ArrayList<>();
	protected void addChoice(AgotChoice choice) {
		choice.setRequestType(this.type);
		this.choices.add(choice);
	}
	
	@Getter @Expose private boolean repeated;
	@Override public void setRepeated() { this.repeated = true; }
	
	@Override public String toString () {
		StringBuilder s = new StringBuilder(this.instruction).append ("\n");
		for (var choice : this.choices) {
			s.append(choice).append ("\n");
		}
		return s.toString();
	}
	
	@Override
	public boolean accept(AgotResponse response, AgotContext context) {
		if (!response.getPlayerId().equals(this.player.id())) { return false; }
		var choice = response.getChoice();
		if (!choice.getRequestType().equals(this.type)) { return false; }
		if (!this.choices.contains(choice)) { return false; }
		return this.accept(choice, context);
	}

	protected abstract boolean accept(AgotChoice choice, AgotContext context);
	
}
