package com.motif.agot.logic.requests;

import com.google.gson.annotations.Expose;
import com.motif.agot.ang.enums.AngIcon;
import com.motif.agot.logic.requests.AAgotRequest.AgotRequestType;
import com.motif.agot.state.AgotPlayer;
import com.motif.agot.state.cards.Card;

import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.Getter;
import lombok.Setter;

public class AgotChoice {

	public enum AgotChoiceType {
		SELECT_CARD,
		SELECT_CARD_ACTION,
		SELECT_PLAYER,
		SELECT_ICON,
		CONTINUE,
		PASS
	}
	
	public enum AgotChoiceCardAction {
		MARSHALL,
		PLAY,
		ACTION,
		REACTION,
		INTERRUPT
	}
	
	@Expose @Setter private AgotRequestType requestType;
	@GraphQLQuery (name = "requestType") public AgotRequestType getRequestType () { return this.requestType; }
	
	public AgotChoice sRequestType(AgotRequestType requestType) { this.requestType = requestType; return this; }
	@Expose @Getter private AgotChoiceType choiceType;

	@Expose @Getter private Long cardId;
	private AgotChoice sCardId(long cardId) { this.cardId = cardId; return this; }
	@Expose @Getter private AgotChoiceCardAction cardAction;
	private AgotChoice sCardAction(AgotChoiceCardAction cardAction) { this.cardAction = cardAction; return this; }
	@Expose @Getter private AngIcon icon;
	private AgotChoice sIcon(AngIcon icon) { this.icon = icon; return this; }
	@Expose @Getter private String player;
	private AgotChoice sPlayer(String player) { this.player = player; return this; }
	
	private AgotChoice(AgotChoiceType choiceType) {
		this.choiceType = choiceType;
	}
	
	public static AgotChoice passChoice() {
		return new AgotChoice(AgotChoiceType.PASS);
	}

	public static AgotChoice continueChoice() {
		return new AgotChoice(AgotChoiceType.CONTINUE);
	}

	public static AgotChoice selectPlayerChoice(AgotPlayer player) {
		return new AgotChoice(AgotChoiceType.SELECT_PLAYER).sPlayer(player.id());
	}

	public static AgotChoice selectCardChoice(Card<?> card) {
		return new AgotChoice(AgotChoiceType.SELECT_CARD).sCardId(card.id());
	}
	
	public static AgotChoice selectCardActionChoice(Card<?> card, AgotChoiceCardAction cardAction) {
		return new AgotChoice(AgotChoiceType.SELECT_CARD_ACTION).sCardId(card.id()).sCardAction(cardAction);
	}
	
	public static AgotChoice selectIconChoice(AngIcon icon) {
		return new AgotChoice(AgotChoiceType.SELECT_ICON).sIcon(icon);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AgotChoice other = (AgotChoice) obj;
		if (cardAction != other.cardAction)
			return false;
		if (cardId == null) {
			if (other.cardId != null)
				return false;
		} else if (!cardId.equals(other.cardId))
			return false;
		if (choiceType != other.choiceType)
			return false;
		if (icon != other.icon)
			return false;
		if (player == null) {
			if (other.player != null)
				return false;
		} else if (!player.equals(other.player))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return requestType + " " + choiceType + " cardId=" + cardId
		        + " " + cardAction + " " + icon + " " + player;
	}

}
