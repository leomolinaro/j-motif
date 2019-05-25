package com.motif.agot.logic.requests;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.flow.AgotResponse;
import com.motif.agot.logic.flow.IAgotFlowRequest;
import com.motif.agot.state.AgotPlayer;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
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
	
//	public static final String SELECT_ACTION_TO_PERFORM = "selectActionToPerform";
//	public static final String SELECT_REACTION_TO_PERFORM = "selectReactionToPerform";
//	public static final String SELECT_INTERRUPT_TO_PERFORM = "selectInterruptToPerform";
//	public static final String SELECT_CHARACTER_TO_KILL = "selectCharacterToKill";
//	public static final String SELECT_CHARACTER_TO_DEFEND = "selectCharacterToDefend";
//	public static final String SELECT_CHALLENGE_TO_INITIATE = "selectChallengeToInitiate";
//	public static final String SELECT_CHARACTER_TO_ATTACK = "selectCharacterToAttack";
//	public static final String SELECT_CHARACTER_TO_BYPASS = "selectCharacterToBypass";
//	public static final String SELECT_DEFENDER = "selectDefender";
//	public static final String SELECT_PLOT_TO_REVEAL = "selectPlotToReveal";
//	public static final String SELECT_FIRST_PLAYER = "selectFirstPlayer";
//	public static final String SELECT_CARD_TO_ATTACH = "selectCardToAttach";
//	public static final String SELECT_CARD_TO_DISCARD = "selectCardToDiscard";
//	public static final String CHOOSE_CARD = "chooseCard";
//	public static final String CONTINUE = "continue";
	
	@Getter @Expose private final AgotRequestType type;
	@Getter private final AgotPlayer player;
	@Expose private final String instruction;
	
	@Expose private final List<AgotChoice> choices = new ArrayList<>();
	protected void addChoice(AgotChoice choice) {
		choice.setRequestType(this.type);
		this.choices.add(choice);
	}
	
	@Getter @Expose private boolean repeated;
	@Override public void setRepeated() { this.repeated = true; }
	
//	@RequiredArgsConstructor
//	protected static abstract class AAgotOption {
//		@Expose private final String key;
//		@Expose private final String label;
//	}
//	
//	protected static class AgotCardOption extends AAgotOption {
//		public AgotCardOption(String key, long cardId, String label) {
//			super(key, label);
//			this.cardId = cardId;
//		}
//		@Expose private final long cardId;
//	}
//	
//	protected static class AgotGenericOption extends AAgotOption {
//		public AgotGenericOption(String key, String label) {
//			super(key, label);
//		}
//	}
	
	@Override public String toString () {
		StringBuilder s = new StringBuilder(this.instruction).append ("\n");
		for (var choice : this.choices) {
			s.append(choice).append ("\n");
		}
		return s.toString();
	}
	
	@Override
	public boolean accept(AgotResponse response, AgotContext context) {
		if (!context.getPlayer().equals(this.player.getUsername())) { return false; }
		var choice = response.getChoice();
		if (!choice.getRequestType().equals(this.type)) { return false; }
		if (!this.choices.contains(choice)) { return false; }
		return this.accept(choice, context);
	}

	protected abstract boolean accept(AgotChoice choice, AgotContext context);
	
}
