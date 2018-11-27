package motif.agot.endpoint.clientstate;

import com.google.gson.annotations.Expose;

import motif.agot.ang.enums.AngArea;
import motif.agot.ang.enums.AngPhase;
import motif.agot.endpoint.AgotContext;
import motif.agot.endpoint.clientstate.AgotReduxAction.ActionData;
import motif.agot.flow.request.AgotRequest;
import motif.agot.state.AgotGame;
import motif.agot.state.GameLog.GameLogRow;
import motif.agot.state.AgotPlayer;
import motif.agot.state.cards.Card;

public class AgotReduxAction<D extends ActionData> {

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
	public static final String SET_GOLD = "SET_GOLD";
	public static final String SET_PHASE = "SET_PHASE";
	
	@Expose private String type;
	@Expose private D payload;
	
	public AgotReduxAction (String type, D data) {
		super ();
		this.type = type;
		this.payload = data;
	} // AgotReduxAction

	public static AgotReduxAction<AddAttachmentData> addAttachment (Card<?> card, Card<?> toCard) { return new AgotReduxAction<AddAttachmentData> (ADD_ATTACHMENT, new AddAttachmentData (card, toCard)); }
	public static AgotReduxAction<AddCardData> addCard (Card<?> card, AgotPlayer toPlayer, AngArea toArea, int index) { return new AgotReduxAction<AddCardData> (ADD_CARD, new AddCardData (card, toPlayer, toArea, index)); }
	public static AgotReduxAction<AddDuplicateData> addDuplicate (Card<?> card, Card<?> toCard) { return new AgotReduxAction<AddDuplicateData> (ADD_DUPLICATE, new AddDuplicateData (card, toCard)); }
	public static AgotReduxAction<AddLogData> addLog (GameLogRow logRow) { return new AgotReduxAction<AddLogData> (ADD_LOG, new AddLogData (logRow)); }
	public static AgotReduxAction<EmptyDrawDeckData> emptyDrawDeck (AgotPlayer player) { return new AgotReduxAction<EmptyDrawDeckData> (EMPTY_DRAW_DECK, new EmptyDrawDeckData (player)); }
	public static AgotReduxAction<InitStateData> initState (AgotGame game, AgotContext context, AgotRequest<?> request) { return new AgotReduxAction<InitStateData> (INIT_STATE, new InitStateData (game, context, request)); }
	public static AgotReduxAction<RemoveAttachmentData> removeAttachment (Card<?> card, Card<?> fromCard) { return new AgotReduxAction<RemoveAttachmentData> (REMOVE_ATTACHMENT, new RemoveAttachmentData (card, fromCard)); }
	public static AgotReduxAction<RemoveCardData> removeCard (Card<?> card, AgotPlayer fromPlayer, AngArea fromArea) { return new AgotReduxAction<RemoveCardData> (REMOVE_CARD, new RemoveCardData (card, fromPlayer, fromArea)); }
	public static AgotReduxAction<RemoveDuplicateData> removeDuplicate (Card<?> card, Card<?> fromCard) { return new AgotReduxAction<RemoveDuplicateData> (REMOVE_DUPLICATE, new RemoveDuplicateData (card, fromCard)); }
	public static AgotReduxAction<RequestData> request (AgotRequest<?> request) { return new AgotReduxAction<RequestData> (REQUEST, new RequestData (request)); }
	public static AgotReduxAction<SetCardKneelingData> setCardKneeling (boolean kneeling, Card<?> card) { return new AgotReduxAction<SetCardKneelingData> (SET_CARD_KNEELING, new SetCardKneelingData (kneeling, card)); }
	public static AgotReduxAction<SetCardPowerData> setCardPower (int power, Card<?> card) { return new AgotReduxAction<SetCardPowerData> (SET_CARD_POWER, new SetCardPowerData (power, card)); }
	public static AgotReduxAction<SetCardRevealedData> setCardRevealed (boolean revealed, Card<?> card) { return new AgotReduxAction<SetCardRevealedData> (SET_CARD_REVEALED, new SetCardRevealedData (revealed, card)); }
	public static AgotReduxAction<SetFirstPlayerData> setFirstPlayer (AgotPlayer firstPlayer) { return new AgotReduxAction<SetFirstPlayerData> (SET_FIRST_PLAYER, new SetFirstPlayerData (firstPlayer)); }
	public static AgotReduxAction<SetGoldData> setGold (int gold, AgotPlayer player) { return new AgotReduxAction<SetGoldData> (SET_GOLD, new SetGoldData (gold, player)); }
	public static AgotReduxAction<SetPhaseData> setPhase (String round, AngPhase phase, String step) { return new AgotReduxAction<SetPhaseData> (SET_PHASE, new SetPhaseData (round, phase, step)); }

	public static abstract class ActionData {
		
	} // IActionData
	
	public static class AddCardData extends ActionData {
		
		@Expose private long cardId;
		@Expose private String toPlayer;
		@Expose private String toArea;
		@Expose private int index;
		
		public AddCardData (Card<?> card, AgotPlayer toPlayer, AngArea toArea, int index) {
			super ();
			this.cardId = card.getId ();
			this.toPlayer = toPlayer.getUsername ();
			this.toArea = toArea.getLabel ();
			this.index = index;
		} // InitGameData

	} // AddCardData

	public static class AddLogData extends ActionData {
		
		@Expose private GameLogRow log;
		
		public AddLogData (GameLogRow log) {
			super ();
			this.log = log;
		} // AddLogData

	} // AddLogData
	
	public static class EmptyDrawDeckData extends ActionData {
		
		@Expose private String player;
		
		public EmptyDrawDeckData (AgotPlayer player) {
			super ();
			this.player = player.getUsername ();
		} // EmptyDrawDeckData
		
	} // EmptyDrawDeckData
	
	public static class InitStateData extends ActionData {
		
		private static class AgotState {
			@Expose private AgotGame game;
			@Expose private AgotContext context;
			@Expose private AgotRequest<?> request;
		} // AgotState
		
		@Expose private AgotState state = new AgotState ();
		
		public InitStateData (AgotGame game, AgotContext context, AgotRequest<?> request) {
			super ();
			state.game = game;
			state.context = context;
			state.request = request;
		} // InitStateData
		
	} // InitStateData
	
	public static class RemoveCardData extends ActionData {
		
		@Expose private long cardId;
		@Expose private String fromPlayer;
		@Expose private String fromArea;
		
		public RemoveCardData (Card<?> card, AgotPlayer fromPlayer, AngArea fromArea) {
			super ();
			this.cardId = card.getId ();
			this.fromPlayer = fromPlayer.getUsername ();
			this.fromArea = fromArea.getLabel ();
		} // InitGameData
		
	} // RemoveCardData
	
	public static class RequestData extends ActionData {
		
		@Expose private AgotRequest<?> request;
		
		public RequestData (AgotRequest<?> request) {
			super ();
			this.request = request;
		} // RequestData

	} // SetRoundData
	
	public static class SetFirstPlayerData extends ActionData {
		
		@Expose private String player;
		
		public SetFirstPlayerData (AgotPlayer player) {
			super ();
			this.player = player.getUsername ();
		} // SetPhaseData
		
	} // SetFirstPlayerData
	
	public static class SetGoldData extends ActionData {
		
		@Expose private int gold;
		@Expose private String player;
		
		public SetGoldData (int gold, AgotPlayer player) {
			super ();
			this.gold = gold;
			this.player = player.getUsername ();
		} // SetPhaseData
		
	} // SetGoldData
	
	public static class SetPhaseData extends ActionData {
		
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
	
	public static class SetCardKneelingData extends ActionData {
		
		@Expose private boolean kneeling;
		@Expose private long cardId;
		
		public SetCardKneelingData (boolean kneeling, Card<?> card) {
			super ();
			this.kneeling = kneeling;
			this.cardId = card.getId ();
		} // SetCardKneelingData
		
	} // SetCardKneelingData
	
	public static class SetCardPowerData extends ActionData {
		
		@Expose private int power;
		@Expose private long cardId;
		
		public SetCardPowerData (int power, Card<?> card) {
			super ();
			this.power = power;
			this.cardId = card.getId ();
		} // SetCardPowerData
		
	} // SetCardPowerData

	public static class SetCardRevealedData extends ActionData {
		
		@Expose private boolean revealed;
		@Expose private long cardId;
		
		public SetCardRevealedData (boolean revealed, Card<?> card) {
			super ();
			this.revealed = revealed;
			this.cardId = card.getId ();
		} // SetCardRevealedData
		
	} // SetCardRevealedData
	
	public static class AddAttachmentData extends ActionData {
		
		@Expose private long cardId;
		@Expose private long toCard;
		
		public AddAttachmentData (Card<?> card, Card<?> attachTo) {
			super ();
			this.cardId = card.getId ();
			this.toCard = attachTo.getId ();
		} // AddAttachmentData
		
	} // AddAttachmentData
	
	public static class RemoveAttachmentData extends ActionData {
		
		@Expose private long cardId;
		@Expose private long fromCard;
		
		public RemoveAttachmentData (Card<?> card, Card<?> fromCard) {
			super ();
			this.cardId = card.getId ();
			this.fromCard = fromCard.getId ();
		} // RemoveAttachmentData
		
	} // RemoveAttachmentData
	
	public static class RemoveDuplicateData extends ActionData {
		
		@Expose private long cardId;
		@Expose private long fromCard;
		
		public RemoveDuplicateData (Card<?> card, Card<?> fromCard) {
			super ();
			this.cardId = card.getId ();
			this.fromCard = fromCard.getId ();
		} // RemoveDuplicateData
		
	} // RemoveDuplicateData
	
	public static class AddDuplicateData extends ActionData {
		
		@Expose private long cardId;
		@Expose private long toCard;
		
		public AddDuplicateData (Card<?> card, Card<?> toCard) {
			super ();
			this.cardId = card.getId ();
			this.toCard = toCard.getId ();
		} // AddDuplicateData
		
	} // AddDuplicateData
	
} // AgotReduxAction
