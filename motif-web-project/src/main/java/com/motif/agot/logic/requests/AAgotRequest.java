package com.motif.agot.logic.requests;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.motif.agot.logic.flow.AgotResponse;
import com.motif.agot.logic.flow.IAgotFlowRequest;
import com.motif.agot.state.AgotPlayer;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class AAgotRequest implements IAgotFlowRequest {

	public static final String SELECT_ACTION_TO_PERFORM = "selectActionToPerform";
	public static final String SELECT_REACTION_TO_PERFORM = "selectReactionToPerform";
	public static final String SELECT_INTERRUPT_TO_PERFORM = "selectInterruptToPerform";
	public static final String SELECT_CHARACTER_TO_KILL = "selectCharacterToKill";
	public static final String SELECT_CHARACTER_TO_DEFEND = "selectCharacterToDefend";
	public static final String SELECT_CHALLENGE_TO_INITIATE = "selectChallengeToInitiate";
	public static final String SELECT_CHARACTER_TO_ATTACK = "selectCharacterToAttack";
	public static final String SELECT_CHARACTER_TO_BYPASS = "selectCharacterToBypass";
	public static final String SELECT_DEFENDER = "selectDefender";
	public static final String SELECT_PLOT_TO_REVEAL = "selectPlotToReveal";
	public static final String SELECT_FIRST_PLAYER = "selectFirstPlayer";
	public static final String SELECT_CARD_TO_ATTACH = "selectCardToAttach";
	public static final String SELECT_CARD_TO_DISCARD = "selectCardToDiscard";
	public static final String CHOOSE_CARD = "chooseCard";
	public static final String CONTINUE = "continue";
	
	@Getter @Expose protected final String type;
	@Getter protected final AgotPlayer player;
	@Expose protected final String instruction;
	
	@Expose protected final List<AAgotOption> options = new ArrayList<>();
	
	public abstract boolean isValidResponse (AgotResponse response);
	
	@RequiredArgsConstructor
	protected static abstract class AAgotOption {
		@Expose private final String key;
		@Expose private final String label;
	}
	
	protected static class AgotCardOption extends AAgotOption {
		public AgotCardOption(String key, long cardId, String label) {
			super(key, label);
			this.cardId = cardId;
		}
		@Expose private final long cardId;
	}
	
	protected static class AgotGenericOption extends AAgotOption {
		public AgotGenericOption(String key, String label) {
			super(key, label);
		}
	}
	
	@Override public String toString () {
		StringBuilder s = new StringBuilder(this.instruction).append ("\n");
		for (var option : this.options) {
			s.append (option.key + " " + option.label).append ("\n");
		}
		return s.toString();
	}
	
}
