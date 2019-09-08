package com.motif.agot.endpoint;

import java.util.ArrayList;

import com.google.gson.annotations.Expose;
import com.motif.agot.ang.enums.AngArea;
import com.motif.agot.ang.enums.AngPhase;
import com.motif.agot.state.AgotPlayer;
import com.motif.agot.state.GameLog.GameLogRow;
import com.motif.agot.state.cards.Card;
import com.motif.shared.action.MotifReduxAction;
import com.motif.shared.action.MotifReduxActionData;

import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.annotations.types.GraphQLUnion;
import lombok.RequiredArgsConstructor;

public class AgotReduxActionList {

	@GraphQLUnion (name = "AgotReduxActionData", possibleTypeAutoDiscovery = true)
	public interface AgotReduxActionData extends MotifReduxActionData {
	} // AgotReduxActionData
	
	public class AgotReduxAction<D extends AgotReduxActionData> extends MotifReduxAction<AgotReduxActionType, D> {
		
		public AgotReduxAction(AgotReduxActionType type, D data) {
			super(type, data);
		} // AgotReduxAction
		
		@GraphQLQuery (name = "type")
		public AgotReduxActionType getType () { return this.type; }
		
		@GraphQLQuery (name = "payload")
		public D getPayload () { return this.payload; }
		
	} // AgotReduxAction
	
	public enum AgotReduxActionType {
		ADD_ATTACHMENT,
		ADD_CARD,
		ADD_DUPLICATE,
		ADD_LOG,
		EMPTY_DRAW_DECK,
		REMOVE_ATTACHMENT,
		REMOVE_CARD,
		REMOVE_DUPLICATE,
		SET_CARD_KNEELING,
		SET_CARD_POWER,
		SET_CARD_REVEALED,
		SET_FIRST_PLAYER,
		SET_GAME_STARTED,
		SET_GOLD,
		SET_PHASE
	} // AgotReduxActionType
	
	@Expose private ArrayList<AgotReduxAction<AgotReduxActionData>> actions = new ArrayList<AgotReduxAction<AgotReduxActionData>> ();
	@GraphQLQuery (name = "actions") public ArrayList<AgotReduxAction<AgotReduxActionData>> getActions () { return this.actions; }
	
	public void addAttachment(Card<?> card, Card<?> attachTo) { actions.add(new AgotReduxAction<>(AgotReduxActionType.ADD_ATTACHMENT, new AddAttachmentData(card, attachTo))); }
	public void addCard(Card<?> card, AgotPlayer toPlayer, AngArea toArea) { addCard (card, toPlayer, toArea, AngArea.END_LIST); }
	public void addCard(Card<?> card, AgotPlayer toPlayer, AngArea toArea, int index) { actions.add(new AgotReduxAction<>(AgotReduxActionType.ADD_CARD, new AddCardData(card, toPlayer, toArea, index))); }
	public void addDuplicate(Card<?> card, Card<?> duplicateTo) { actions.add(new AgotReduxAction<>(AgotReduxActionType.ADD_DUPLICATE, new AddDuplicateData(card, duplicateTo))); }
	public void addLog(GameLogRow logRow) { actions.add(new AgotReduxAction<>(AgotReduxActionType.ADD_LOG, new AddLogData(logRow))); }
	public void emptyDrawDeck(AgotPlayer player) { actions.add(new AgotReduxAction<>(AgotReduxActionType.EMPTY_DRAW_DECK, new EmptyDrawDeckData(player))); }
	public void removeAttachment(Card<?> card, Card<?> fromCard) { actions.add(new AgotReduxAction<>(AgotReduxActionType.REMOVE_ATTACHMENT, new RemoveAttachmentData(card, fromCard))); }
	public void removeCard(Card<?> card, AgotPlayer fromPlayer, AngArea fromArea) { actions.add(new AgotReduxAction<>(AgotReduxActionType.REMOVE_CARD, new RemoveCardData(card, fromPlayer, fromArea))); }
	public void removeDuplicate(Card<?> card, Card<?> fromCard) { actions.add(new AgotReduxAction<>(AgotReduxActionType.REMOVE_DUPLICATE, new RemoveDuplicateData(card, fromCard))); }
	public void setCardKneeling(boolean kneeling, Card<?> card) { actions.add(new AgotReduxAction<>(AgotReduxActionType.SET_CARD_KNEELING, new SetCardKneelingData(kneeling, card))); }
	public void setCardPower(int power, Card<?> card) { actions.add(new AgotReduxAction<>(AgotReduxActionType.SET_CARD_POWER, new SetCardPowerData(power, card))); }
	public void setCardRevealed(boolean revealed, Card<?> card) { actions.add(new AgotReduxAction<>(AgotReduxActionType.SET_CARD_REVEALED, new SetCardRevealedData(revealed, card))); }
	public void setFirstPlayer(AgotPlayer firstPlayer) { actions.add(new AgotReduxAction<>(AgotReduxActionType.SET_FIRST_PLAYER, new SetFirstPlayerData(firstPlayer))); }
	public void setGameStarted(boolean started) { actions.add(new AgotReduxAction<>(AgotReduxActionType.SET_GAME_STARTED, new SetGameStartedData(started))); }
	public void setGold(int gold, AgotPlayer player) { actions.add(new AgotReduxAction<>(AgotReduxActionType.SET_GOLD, new SetGoldData(gold, player))); }
	public void setPhase(String round, AngPhase phase, String step) { actions.add(new AgotReduxAction<>(AgotReduxActionType.SET_PHASE, new SetPhaseData(round, phase, step))); }
	
	public class AddCardData implements AgotReduxActionData {
		
		@Expose private long cardId;
		@GraphQLQuery public long cardId () { return this.cardId; }
		@Expose private String toPlayer;
		@GraphQLQuery public String toPlayer () { return this.toPlayer; }
		@Expose private AngArea toArea;
		@GraphQLQuery public AngArea toArea () { return this.toArea; }
		@Expose private int index;
		@GraphQLQuery public int index () { return this.index; }
		
		public AddCardData (Card<?> card, AgotPlayer toPlayer, AngArea toArea, int index) {
			super ();
			this.cardId = card.id();
			this.toPlayer = toPlayer.id ();
			this.toArea = toArea;
			this.index = index;
		} // AddCardData

	} // AddCardData
	
	public static class AddLogData implements AgotReduxActionData {
		
		@Expose private GameLogRow log;
		@GraphQLQuery public GameLogRow log () { return this.log; }
		
		public AddLogData (GameLogRow log) {
			super ();
			this.log = log;
		} // AddLogData

	} // AddLogData
	
	public static class EmptyDrawDeckData implements AgotReduxActionData {
		
		@Expose private String player;
		@GraphQLQuery public String player () { return this.player; }
		
		public EmptyDrawDeckData (AgotPlayer player) {
			super ();
			this.player = player.id ();
		} // EmptyDrawDeckData
		
	} // EmptyDrawDeckData
	
	public static class RemoveCardData implements AgotReduxActionData {
		
		@Expose private long cardId;
		@GraphQLQuery public long cardId () { return this.cardId; }
		@Expose private String fromPlayer;
		@GraphQLQuery public String fromPlayer () { return this.fromPlayer; }
		@Expose private AngArea fromArea;
		@GraphQLQuery public AngArea fromArea () { return this.fromArea; }
		
		public RemoveCardData (Card<?> card, AgotPlayer fromPlayer, AngArea fromArea) {
			super ();
			this.cardId = card.id ();
			this.fromPlayer = fromPlayer.id ();
			this.fromArea = fromArea;
		} // InitGameData
		
	} // RemoveCardData
	
	public static class SetFirstPlayerData implements AgotReduxActionData {
		
		@Expose private String player;
		@GraphQLQuery public String player () { return this.player; }
		
		public SetFirstPlayerData (AgotPlayer player) {
			super ();
			this.player = player.id ();
		} // SetPhaseData
		
	} // SetFirstPlayerData
	
	public static class SetGoldData implements AgotReduxActionData {
		
		@Expose private int gold;
		@GraphQLQuery public int gold () { return this.gold; }
		@Expose private String player;
		@GraphQLQuery public String player () { return this.player; }
		
		public SetGoldData (int gold, AgotPlayer player) {
			super ();
			this.gold = gold;
			this.player = player.id ();
		} // SetPhaseData
		
	} // SetGoldData
	
	public static class SetPhaseData implements AgotReduxActionData {
		
		@Expose private String round;
		@GraphQLQuery public String round () { return this.round; }
		@Expose private String phase;
		@GraphQLQuery public String phase () { return this.phase; }
		@Expose private String step;
		@GraphQLQuery public String step () { return this.step; }
		
		public SetPhaseData (String round, AngPhase phase, String step) {
			super ();
			this.round = round;
			this.phase = phase == null ? "" : phase.getLabel ();
			this.step = step;
		} // SetPhaseData
		
	} // SetPhaseData
	
	public static class SetCardKneelingData implements AgotReduxActionData {
		
		@Expose private boolean kneeling;
		@GraphQLQuery public boolean kneeling () { return this.kneeling; }
		@Expose private long cardId;
		@GraphQLQuery public long cardId () { return this.cardId; }
		
		public SetCardKneelingData (boolean kneeling, Card<?> card) {
			super ();
			this.kneeling = kneeling;
			this.cardId = card.id ();
		} // SetCardKneelingData
		
	} // SetCardKneelingData
	
	public static class SetCardPowerData implements AgotReduxActionData {
		
		@Expose private int power;
		@GraphQLQuery public int power () { return this.power; }
		@Expose private long cardId;
		@GraphQLQuery public long cardId () { return this.cardId; }
		
		public SetCardPowerData (int power, Card<?> card) {
			super ();
			this.power = power;
			this.cardId = card.id ();
		} // SetCardPowerData
		
	} // SetCardPowerData

	public static class SetCardRevealedData implements AgotReduxActionData {
		
		@Expose private boolean revealed;
		@GraphQLQuery public boolean revealed () { return this.revealed; }
		@Expose private long cardId;
		@GraphQLQuery public long cardId () { return this.cardId; }
		
		public SetCardRevealedData (boolean revealed, Card<?> card) {
			super ();
			this.revealed = revealed;
			this.cardId = card.id ();
		} // SetCardRevealedData
		
	} // SetCardRevealedData
	
	public static class AddAttachmentData implements AgotReduxActionData {
		
		@Expose private long cardId;
		@GraphQLQuery public long cardId () { return this.cardId; }
		@Expose private long toCard;
		@GraphQLQuery public long toCard () { return this.toCard; }
		
		public AddAttachmentData (Card<?> card, Card<?> attachTo) {
			super ();
			this.cardId = card.id ();
			this.toCard = attachTo.id ();
		} // AddAttachmentData
		
	} // AddAttachmentData
	
	public static class RemoveAttachmentData implements AgotReduxActionData {
		
		@Expose private long cardId;
		@GraphQLQuery public long cardId () { return this.cardId; }
		@Expose private long fromCard;
		@GraphQLQuery public long fromCard () { return this.fromCard; }
		
		public RemoveAttachmentData (Card<?> card, Card<?> fromCard) {
			super ();
			this.cardId = card.id ();
			this.fromCard = fromCard.id ();
		} // RemoveAttachmentData
		
	} // RemoveAttachmentData
	
	public static class RemoveDuplicateData implements AgotReduxActionData {
		
		@Expose private long cardId;
		@GraphQLQuery public long cardId () { return this.cardId; }
		@Expose private long fromCard;
		@GraphQLQuery public long fromCard () { return this.fromCard; }
		
		public RemoveDuplicateData (Card<?> card, Card<?> fromCard) {
			super ();
			this.cardId = card.id ();
			this.fromCard = fromCard.id ();
		} // RemoveDuplicateData
		
	} // RemoveDuplicateData
	
	public static class AddDuplicateData implements AgotReduxActionData {
		
		@Expose private long cardId;
		@GraphQLQuery public long cardId () { return this.cardId; }
		@Expose private long toCard;
		@GraphQLQuery public long toCard () { return this.toCard; }
		
		public AddDuplicateData (Card<?> card, Card<?> toCard) {
			super ();
			this.cardId = card.id ();
			this.toCard = toCard.id ();
		} // AddDuplicateData
		
	} // AddDuplicateData
	
	@RequiredArgsConstructor
	public static class SetGameStartedData implements AgotReduxActionData {
		@Expose private final boolean started;
		@GraphQLQuery public boolean started () { return this.started; }
	} // SetGameStartedData
	
} // AgotReduxActionList
