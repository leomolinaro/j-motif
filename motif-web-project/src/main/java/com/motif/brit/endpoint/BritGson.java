package com.motif.brit.endpoint;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.motif.shared.endpoint.MotifGson;

public class BritGson extends MotifGson {

	private static BritGson instance;
	public static Gson g () { return instance ().gson; }
	
	protected BritGson () {}
	
	public static BritGson instance () {
		if (instance == null) { instance = new BritGson (); }
		return instance;
	} // instance

	@Override
	protected void registerTypeAdapters (GsonBuilder gsonBuilder) {
		super.registerTypeAdapters (gsonBuilder);
//		gsonBuilder.registerTypeAdapter (InitStateData.class, new InitStateDataSerializer ());
//		gsonBuilder.registerTypeAdapter (BritRequest.BritOption.class, new ModelOptionSerializer ());
	} // registerTypeAdapters

//	private static JsonArray buildCardIdArray (Stream<? extends IClientCard> cards) {
//		JsonArray jCards = new JsonArray ();
//		cards.forEach (card -> jCards.add (card.getId ()));
//		return jCards;
//	} // buildCardIdArray
	
//	private static class ModelOptionSerializer implements JsonSerializer<BritOption<?>> {
//
//		@Override
//		public JsonElement serialize (BritOption<?> option, Type arg1, JsonSerializationContext arg2) {
//			JsonObject jWrap = new JsonObject ();
//			jWrap.addProperty ("key", option.getKey ());
//			jWrap.addProperty ("label", option.getLabel ());
//			ModelSerializer ser = new ModelSerializer ();
////			option.getModel ().accept (ser); TODO
//			jWrap.add (ser.getJsonKey (), ser.getJson ());
//			return jWrap;
//		} // serialize
//		
//		private static class ModelSerializer implements IAgotModelVisitor {
//
//			private String jsonKey;
//			private String getJsonKey () { return jsonKey; }
//			
//			private JsonObject json;
//			private JsonObject getJson () { return json; }
//			
//			private void cardAction (Card<?> card, String action) {
//				this.jsonKey = "card";
//				json = new JsonObject ();
//				json.addProperty ("cardId", card.getId ());
//				json.addProperty ("action", action);
//			} // cardAction
//
//			private void player (AgotPlayer player) {
//				this.jsonKey = "player";
//				json = new JsonObject ();
//				json.addProperty ("name", player.getName ());
//			} // player
//			
//			private void icon (AngIcon angIcon) {
//				this.jsonKey = "icon";
//				json = new JsonObject ();
//				json.addProperty ("label", angIcon.getLabel ());
//			} // icon
//			
//			@Override public void visit (MarshallingAct marshallingTrigger) { cardAction (marshallingTrigger.getCard (), "Marshall"); }
//			@Override public void visit (AngIcon angIcon) { icon (angIcon); }
//			@Override public void visit (AvailableChallenge availableChallenge) { icon (availableChallenge.getChallengeType ()); }
//			@Override public void visit (Card<?> card) { cardAction (card, "Select"); }
//			@Override public void visit (AgotPlayer player) { player (player); }
//			@Override public void visit (ReactionAct reactionAct) { cardAction (reactionAct.getTrigCard (), "React"); }
//			@Override public void visit (InterruptAct interruptAct) { cardAction (interruptAct.getTrigCard (), "Interrupt"); }
//			@Override public void visit (ActionAct actionAct) { cardAction (actionAct.getTrigCard (), "Act"); }
//			
//		} // ModelSerializer
//		
//	} // ModelOptionSerializer
	
//	private static class InitStateDataSerializer implements JsonSerializer<InitStateData> {
//
//		@Override
//		public JsonElement serialize (InitStateData src, Type arg1, JsonSerializationContext jsContext) {
//				
//			IClientGame game = src.game;
//			IClientContext context = src.context;
//			AgotRequest<?> request = src.request;
//			
//			JsonObject jGame = new JsonObject ();
//			JsonObject jCardMap = new JsonObject ();
//			for (Entry<Long, ? extends IClientCard> eCard : game.getCardMap ().entrySet ()) {
//				IClientCard card = eCard.getValue ();
//				JsonObject jCard = new JsonObject ();
//				jCard.addProperty ("id", card.getId ());
//				jCard.addProperty ("imageSource", card.getImageSource ());
//				jCard.addProperty ("kneeling", card.isKneeling ());
//				jCard.addProperty ("power", card.getPower ());
//				jCard.addProperty ("revealed", card.isRevealed ());
//				if (card.attachments () != null) { jCard.add ("attachmentIds", buildCardIdArray (card.attachments ())); }
//				if (card.duplicates () != null) { jCard.add ("duplicateIds", buildCardIdArray (card.duplicates ())); }
//				jCardMap.add (eCard.getKey () + "", jCard);
//			} // for
//			JsonObject jPlayerMap = new JsonObject ();
//			for (Entry<String, ? extends IClientPlayer> ePlayer : game.getPlayerMap ().entrySet ()) {
//				IClientPlayer player = ePlayer.getValue ();
//				JsonObject jPlayer = new JsonObject ();
//				jPlayer.addProperty ("username", player.getUsername ());
//				jPlayer.addProperty ("name", player.getName ());
//				jPlayer.addProperty ("faction", player.getFaction ().getId ());
//				if (player.getAgenda () != null) { jPlayer.addProperty ("agenda", player.getAgenda ().getId ()); }
//				jPlayer.add ("hand", buildCardIdArray (player.hand ()));
//				jPlayer.add ("characters", buildCardIdArray (player.characters ()));
//				jPlayer.add ("locations", buildCardIdArray (player.locations ()));
//				jPlayer.add ("discardPile", buildCardIdArray (player.discardPile ()));
//				jPlayer.add ("plotDeck", buildCardIdArray (player.plotDeck ()));
//				jPlayer.add ("usedPlotPile", buildCardIdArray (player.usedPlotPile ()));
//				jPlayer.add ("deadPile", buildCardIdArray (player.deadPile ()));
//				if (player.revealedPlot () != null) { jPlayer.addProperty ("revealedPlot", player.revealedPlot ().getId ()); }
//				JsonObject jDrawDeck = new JsonObject ();
//				jDrawDeck.addProperty ("empty", player.getDrawDeck ().isEmpty ());
//				jPlayer.add ("drawDeck", jDrawDeck);
//				jPlayerMap.add (ePlayer.getKey (), jPlayer);
//			} // for
//			jGame.add ("cardMap", jCardMap);
//			jGame.add ("playerMap", jPlayerMap);
//			if (game.getRound () != null) { jGame.addProperty ("round", game.getRound ()); }
//			if (game.getPhase () != null) { jGame.addProperty ("phase", game.getPhase ().getLabel ()); }
//			if (game.getStep () != null) { jGame.addProperty ("step", game.getStep ()); }
//			JsonArray jPlayersArr = new JsonArray ();
//			game.players ().forEach (player -> jPlayersArr.add (player.getUsername ()));
//			jGame.add ("players", jPlayersArr);
//			JsonArray jLog = new JsonArray ();
//			for (GameLogRow log : game.getLog ()) { jLog.add (jsContext.serialize (log)); }
//			jGame.add ("log", jLog);
//
//			JsonObject jContext = new JsonObject ();
//			jContext.addProperty ("player", context.getPlayer ());
//			jContext.addProperty ("opponent", context.getOpponent ());
//
//			JsonObject jRequest = null;
//			if (request != null) {
//				JsonArray jbOptions = new JsonArray ();
//				request.options ().forEach (option -> {
//					JsonElement jOption = jsContext.serialize (option);
//					jbOptions.add (jOption);
//				});
//				jRequest = new JsonObject ();
//				jRequest.addProperty ("title", request.getTitle ());
//				jRequest.add ("options", jbOptions);
//			} // if
//			
//			JsonObject jState = new JsonObject ();
//			jState.add ("game", jGame);
//			jState.add ("context", jContext);
//			if (jRequest != null) { jState.add ("request", jRequest); }
//			
//			JsonObject jWrap = new JsonObject ();
//			jWrap.add ("state", jState);
//			
//			return jWrap;
//		} // serialize
//		
//	} // InitStateDataSerializer

} // AgotGson
