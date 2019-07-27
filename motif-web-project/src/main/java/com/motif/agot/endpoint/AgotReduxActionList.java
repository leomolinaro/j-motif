package com.motif.agot.endpoint;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.motif.agot.ang.enums.AngArea;
import com.motif.agot.ang.enums.AngPhase;
import com.motif.agot.logic.flow.IAgotFlowRequest;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.AgotPlayer;
import com.motif.agot.state.GameLog.GameLogRow;
import com.motif.agot.state.cards.Card;
import com.motif.shared.action.MotifReduxAction;
import com.motif.shared.action.MotifReduxActionData;

import lombok.RequiredArgsConstructor;

public class AgotReduxActionList {

	private static class AgotReduxActionData extends MotifReduxActionData {
	}
	
	private static class AgotReduxAction<D extends AgotReduxActionData> extends MotifReduxAction<D> {
		public AgotReduxAction(String type, D data) {
			super(type, data);
		}
	}
	
	public static final String ADD_ATTACHMENT = "ADD_ATTACHMENT";
	public static final String ADD_CARD = "ADD_CARD";
	public static final String ADD_DUPLICATE = "ADD_DUPLICATE";
	public static final String ADD_LOG = "ADD_LOG";
	public static final String EMPTY_DRAW_DECK = "EMPTY_DRAW_DECK";
	public static final String INIT_STATE = "INIT_STATE";
	public static final String REMOVE_ATTACHMENT = "REMOVE_ATTACHMENT";
	public static final String REMOVE_CARD = "REMOVE_CARD";
	public static final String REMOVE_DUPLICATE = "REMOVE_DUPLICATE";
	public static final String REQUEST = "REQUEST";
	public static final String SET_CARD_KNEELING = "SET_CARD_KNEELING";
	public static final String SET_CARD_POWER = "SET_CARD_POWER";
	public static final String SET_CARD_REVEALED = "SET_CARD_REVEALED";
	public static final String SET_FIRST_PLAYER = "SET_FIRST_PLAYER";
	public static final String SET_GAME_STARTED = "SET_GAME_STARTED";
	public static final String SET_GOLD = "SET_GOLD";
	public static final String SET_PHASE = "SET_PHASE";

	@Expose private ArrayList<AgotReduxAction<?>> actions = new ArrayList<AgotReduxAction<?>> ();
	
	public void addAttachment(Card<?> card, Card<?> attachTo) { actions.add(new AgotReduxAction<>(ADD_ATTACHMENT, new AddAttachmentData(card, attachTo))); }
	public void addCard(Card<?> card, AgotPlayer toPlayer, AngArea toArea) { addCard (card, toPlayer, toArea, AngArea.END_LIST); }
	public void addCard(Card<?> card, AgotPlayer toPlayer, AngArea toArea, int index) { actions.add(new AgotReduxAction<>(ADD_CARD, new AddCardData(card, toPlayer, toArea, index))); }
	public void addDuplicate(Card<?> card, Card<?> duplicateTo) { actions.add(new AgotReduxAction<>(ADD_DUPLICATE, new AddDuplicateData(card, duplicateTo))); }
	public void addLog(GameLogRow logRow) { actions.add(new AgotReduxAction<>(ADD_LOG, new AddLogData(logRow))); }
	public void emptyDrawDeck(AgotPlayer player) { actions.add(new AgotReduxAction<>(EMPTY_DRAW_DECK, new EmptyDrawDeckData(player))); }
	public void initState(AgotGame game, List<String> userPlayerIds, IAgotFlowRequest request) { actions.add(new AgotReduxAction<>(INIT_STATE, new InitStateData(game, userPlayerIds, request))); }
	public void removeAttachment(Card<?> card, Card<?> fromCard) { actions.add(new AgotReduxAction<>(REMOVE_ATTACHMENT, new RemoveAttachmentData(card, fromCard))); }
	public void removeCard(Card<?> card, AgotPlayer fromPlayer, AngArea fromArea) { actions.add(new AgotReduxAction<>(REMOVE_CARD, new RemoveCardData(card, fromPlayer, fromArea))); }
	public void removeDuplicate(Card<?> card, Card<?> fromCard) { actions.add(new AgotReduxAction<>(REMOVE_DUPLICATE, new RemoveDuplicateData(card, fromCard))); }
	public void request(IAgotFlowRequest request) { actions.add(new AgotReduxAction<>(REQUEST, new RequestData(request))); }
	public void setCardKneeling(boolean kneeling, Card<?> card) { actions.add(new AgotReduxAction<>(SET_CARD_KNEELING, new SetCardKneelingData(kneeling, card))); }
	public void setCardPower(int power, Card<?> card) { actions.add(new AgotReduxAction<>(SET_CARD_POWER, new SetCardPowerData(power, card))); }
	public void setCardRevealed(boolean revealed, Card<?> card) { actions.add(new AgotReduxAction<>(SET_CARD_REVEALED, new SetCardRevealedData(revealed, card))); }
	public void setFirstPlayer(AgotPlayer firstPlayer) { actions.add(new AgotReduxAction<>(SET_FIRST_PLAYER, new SetFirstPlayerData(firstPlayer))); }
	public void setGameStarted(boolean started) { actions.add(new AgotReduxAction<>(SET_GAME_STARTED, new SetGameStarted(started))); }
	public void setGold(int gold, AgotPlayer player) { actions.add(new AgotReduxAction<>(SET_GOLD, new SetGoldData(gold, player))); }
	public void setPhase(String round, AngPhase phase, String step) { actions.add(new AgotReduxAction<>(SET_PHASE, new SetPhaseData(round, phase, step))); }
	
	public void removeLast () {
		actions.remove (actions.size () - 1);
	}
	
	public static class AddCardData extends AgotReduxActionData {
		
		@Expose private long cardId;
		@Expose private String toPlayer;
		@Expose private String toArea;
		@Expose private int index;
		
		public AddCardData (Card<?> card, AgotPlayer toPlayer, AngArea toArea, int index) {
			super ();
			this.cardId = card.id();
			this.toPlayer = toPlayer.id ();
			this.toArea = toArea.getLabel ();
			this.index = index;
		} // InitGameData

	} // AddCardData

	public static class AddLogData extends AgotReduxActionData {
		
		@Expose private GameLogRow log;
		
		public AddLogData (GameLogRow log) {
			super ();
			this.log = log;
		} // AddLogData

	} // AddLogData
	
	public static class EmptyDrawDeckData extends AgotReduxActionData {
		
		@Expose private String player;
		
		public EmptyDrawDeckData (AgotPlayer player) {
			super ();
			this.player = player.id ();
		} // EmptyDrawDeckData
		
	} // EmptyDrawDeckData
	
	public static class InitStateData extends AgotReduxActionData {
		
		private static class AgotState {
			@Expose private AgotGame game;
			@Expose private List<String> userPlayerIds;
			@Expose private IAgotFlowRequest request;
		}
		
		@Expose private AgotState state = new AgotState ();
		
		public InitStateData (AgotGame game, List<String> userPlayerIds, IAgotFlowRequest request) {
			super ();
			state.game = game;
			state.userPlayerIds = userPlayerIds;
			state.request = request;
		}
		
	}
	
	public static class RemoveCardData extends AgotReduxActionData {
		
		@Expose private long cardId;
		@Expose private String fromPlayer;
		@Expose private String fromArea;
		
		public RemoveCardData (Card<?> card, AgotPlayer fromPlayer, AngArea fromArea) {
			super ();
			this.cardId = card.id ();
			this.fromPlayer = fromPlayer.id ();
			this.fromArea = fromArea.getLabel ();
		} // InitGameData
		
	} // RemoveCardData
	
	public static class RequestData extends AgotReduxActionData {
		
		@Expose private IAgotFlowRequest request;
		
		public RequestData (IAgotFlowRequest request) {
			super ();
			this.request = request;
		} // RequestData

	} // SetRoundData
	
	public static class SetFirstPlayerData extends AgotReduxActionData {
		
		@Expose private String player;
		
		public SetFirstPlayerData (AgotPlayer player) {
			super ();
			this.player = player.id ();
		} // SetPhaseData
		
	} // SetFirstPlayerData
	
	public static class SetGoldData extends AgotReduxActionData {
		
		@Expose private int gold;
		@Expose private String player;
		
		public SetGoldData (int gold, AgotPlayer player) {
			super ();
			this.gold = gold;
			this.player = player.id ();
		} // SetPhaseData
		
	} // SetGoldData
	
	public static class SetPhaseData extends AgotReduxActionData {
		
		@Expose private String round;
		@Expose private String phase;
		@Expose private String step;
		
		public SetPhaseData (String round, AngPhase phase, String step) {
			super ();
			this.round = round;
			this.phase = phase == null ? "" : phase.getLabel ();
			this.step = step;
		} // SetPhaseData
		
	} // SetPhaseData
	
	public static class SetCardKneelingData extends AgotReduxActionData {
		
		@Expose private boolean kneeling;
		@Expose private long cardId;
		
		public SetCardKneelingData (boolean kneeling, Card<?> card) {
			super ();
			this.kneeling = kneeling;
			this.cardId = card.id ();
		} // SetCardKneelingData
		
	} // SetCardKneelingData
	
	public static class SetCardPowerData extends AgotReduxActionData {
		
		@Expose private int power;
		@Expose private long cardId;
		
		public SetCardPowerData (int power, Card<?> card) {
			super ();
			this.power = power;
			this.cardId = card.id ();
		} // SetCardPowerData
		
	} // SetCardPowerData

	public static class SetCardRevealedData extends AgotReduxActionData {
		
		@Expose private boolean revealed;
		@Expose private long cardId;
		
		public SetCardRevealedData (boolean revealed, Card<?> card) {
			super ();
			this.revealed = revealed;
			this.cardId = card.id ();
		} // SetCardRevealedData
		
	} // SetCardRevealedData
	
	public static class AddAttachmentData extends AgotReduxActionData {
		
		@Expose private long cardId;
		@Expose private long toCard;
		
		public AddAttachmentData (Card<?> card, Card<?> attachTo) {
			super ();
			this.cardId = card.id ();
			this.toCard = attachTo.id ();
		} // AddAttachmentData
		
	} // AddAttachmentData
	
	public static class RemoveAttachmentData extends AgotReduxActionData {
		
		@Expose private long cardId;
		@Expose private long fromCard;
		
		public RemoveAttachmentData (Card<?> card, Card<?> fromCard) {
			super ();
			this.cardId = card.id ();
			this.fromCard = fromCard.id ();
		} // RemoveAttachmentData
		
	} // RemoveAttachmentData
	
	public static class RemoveDuplicateData extends AgotReduxActionData {
		
		@Expose private long cardId;
		@Expose private long fromCard;
		
		public RemoveDuplicateData (Card<?> card, Card<?> fromCard) {
			super ();
			this.cardId = card.id ();
			this.fromCard = fromCard.id ();
		} // RemoveDuplicateData
		
	} // RemoveDuplicateData
	
	public static class AddDuplicateData extends AgotReduxActionData {
		
		@Expose private long cardId;
		@Expose private long toCard;
		
		public AddDuplicateData (Card<?> card, Card<?> toCard) {
			super ();
			this.cardId = card.id ();
			this.toCard = toCard.id ();
		} // AddDuplicateData
		
	} // AddDuplicateData
	
	@RequiredArgsConstructor
	public static class SetGameStarted extends AgotReduxActionData {
		@Expose private final boolean started;
	}
	
}
