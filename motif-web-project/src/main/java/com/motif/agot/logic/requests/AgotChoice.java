package com.motif.agot.logic.requests;

import java.util.ArrayList;
import java.util.List;

import com.motif.agot.ang.enums.AngIcon;
import com.motif.agot.ang.sets.AgotCardSeed;
import com.motif.agot.logic.requests.AAgotRequest.AgotRequestType;
import com.motif.agot.state.AgotPlayer;
import com.motif.agot.state.cards.Card;

import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.EqualsAndHashCode;
import lombok.Setter;

@EqualsAndHashCode
public class AgotChoice {

	public AgotChoice () {}
	
	public enum AgotChoiceType {
		SELECT_CARD,
		SELECT_CARD_ACTION,
		SELECT_PLAYER,
		SELECT_ICON,
		CONTINUE,
		PASS,
		YES_NO,
		DRAW
	} // AgotChoiceType
	
	public enum AgotChoiceCardAction {
		MARSHALL,
		PLAY,
		ACTION,
		REACTION,
		INTERRUPT
	} // AgotChoiceCardAction
	
	@Setter private AgotRequestType requestType;
	@GraphQLQuery (name = "requestType") public AgotRequestType getRequestType () { return this.requestType; }
	public AgotChoice sRequestType (AgotRequestType requestType) { this.requestType = requestType; return this; }
	
	private AgotChoiceType choiceType;
	@GraphQLQuery (name = "choiceType") public AgotChoiceType getChoiceType () { return this.choiceType; }

	private Long cardId;
	@GraphQLQuery (name = "cardId") public Long getCardId () { return this.cardId; }
	private AgotChoice sCardId (long cardId) { this.cardId = cardId; return this; }
	
	private AgotChoiceCardAction cardAction;
	@GraphQLQuery (name = "cardAction") public AgotChoiceCardAction getCardAction () { return this.cardAction; }
	private AgotChoice sCardAction (AgotChoiceCardAction cardAction) { this.cardAction = cardAction; return this; }
	
	private AngIcon icon;
	@GraphQLQuery (name = "icon") public AngIcon getIcon () { return this.icon; }
	private AgotChoice sIcon (AngIcon icon) { this.icon = icon; return this; }
	
	private String player;
	@GraphQLQuery (name = "player") public String getPlayer () { return this.player; }
	private AgotChoice sPlayer (String player) { this.player = player; return this; }
	
	private Boolean yesNoAnswer;
	@GraphQLQuery (name = "yesNoAnswer") public Boolean getYesNoAnswer () { return this.yesNoAnswer; }
	private AgotChoice sYesNoAnswer (Boolean yesNoAnswer) { this.yesNoAnswer = yesNoAnswer; return this; }
	
	private String actionLabel;
	@GraphQLQuery (name = "actionLabel") public String getActionLabel () { return this.actionLabel; }
	private AgotChoice sActionLabel (String actionLabel) { this.actionLabel = actionLabel; return this; }
	
	@EqualsAndHashCode.Exclude
	private List<AgotCardSeed> drawCardSeeds;
	@GraphQLQuery (name = "drawCardSeeds") public List<AgotCardSeed> getDrawCardSeeds () { return this.drawCardSeeds; }
	public AgotChoice addCardSeed (AgotCardSeed seed, int qty) {
		if (this.drawCardSeeds == null) { this.drawCardSeeds = new ArrayList<> (); }
		for (int i = 0; i < qty; i++) {
			this.drawCardSeeds.add (seed);			
		} // for
		return this;
	} // addCardSeed
	public AgotChoice addCardSeed (AgotCardSeed seed) { return this.addCardSeed (seed, 1); }
	
	public static AgotChoice passChoice (AgotRequestType requestType) {
		return new AgotChoice (requestType, AgotChoiceType.PASS);
	}

	public static AgotChoice continueChoice (String actionLabel) {
		return new AgotChoice (AgotRequestType.CONTINUE, AgotChoiceType.CONTINUE).sActionLabel (actionLabel);
	}

	public static AgotChoice selectYesNoChoice (boolean yesNo) {
		return new AgotChoice (AgotRequestType.YES_NO, AgotChoiceType.YES_NO).sYesNoAnswer (yesNo);
	}
	
	public static AgotChoice selectPlayerChoice (AgotRequestType requestType, AgotPlayer player) {
		return new AgotChoice (requestType, AgotChoiceType.SELECT_PLAYER).sPlayer(player.id());
	}

	public static AgotChoice selectCardChoice (AgotRequestType requestType, Card<?> card) {
		return new AgotChoice (requestType, AgotChoiceType.SELECT_CARD).sCardId(card.id());
	}
	
	public static AgotChoice selectCardActionChoice (AgotRequestType requestType, Card<?> card, AgotChoiceCardAction cardAction) {
		return new AgotChoice (requestType, AgotChoiceType.SELECT_CARD_ACTION).sCardId(card.id()).sCardAction(cardAction);
	}
	
	public static AgotChoice selectIconChoice (AgotRequestType requestType, AngIcon icon) {
		return new AgotChoice (requestType, AgotChoiceType.SELECT_ICON).sIcon(icon);
	} // selectIconChoice
	
	public static AgotChoice drawChoice () {
		return new AgotChoice (AgotRequestType.DRAW, AgotChoiceType.DRAW);
	} // drawChoice
	
	@Override
	public String toString() {
		return requestType + " " + choiceType + " cardId=" + cardId
		        + " " + cardAction + " " + icon + " " + player;
	} // toString
	
	private AgotChoice (AgotRequestType requestType, AgotChoiceType choiceType) {
		super ();
		this.requestType = requestType;
		this.choiceType = choiceType;
	} // AgotChoice
	
} // AgotChoice
