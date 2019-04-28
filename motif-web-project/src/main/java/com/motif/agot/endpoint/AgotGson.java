package com.motif.agot.endpoint;

import com.google.gson.Gson;
import com.motif.shared.endpoint.MotifGson;

public class AgotGson extends MotifGson {

	private static AgotGson instance;
	public static Gson g () { return instance ().gson; }
	
	protected AgotGson () {}
	
	public static AgotGson instance () {
		if (instance == null) { instance = new AgotGson (); }
		return instance;
	} // instance

//	@Override
//	protected void registerTypeAdapters (GsonBuilder gsonBuilder) {
//		super.registerTypeAdapters (gsonBuilder);
//		// gsonBuilder.registerTypeAdapter (AgotRequest.AgotChoice.class, new AgotOptionSerializer ());
//	} // registerTypeAdapters

//	private static class AgotOptionSerializer implements JsonSerializer<AgotChoice<?>> {
//
//		@Override
//		public JsonElement serialize (AgotChoice<?> option, Type arg1, JsonSerializationContext arg2) {
//			JsonObject jWrap = new JsonObject ();
//			jWrap.addProperty ("key", option.getKey ());
//			jWrap.addProperty ("label", option.getLabel ());
//			IAgotModel model = option.getModel ();
//			if (model != null) {
//				ModelSerializer ser = new ModelSerializer ();
//				model.accept (ser);
//				jWrap.add (ser.getJsonKey (), ser.getJson ());				
//			} // if
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

//	@Override
//	protected void registerTypeAdapters (GsonBuilder gsonBuilder) {
//		super.registerTypeAdapters (gsonBuilder);
//		gsonBuilder.registerTypeAdapter (AgotRequest.AgotOption.class, new AgotOptionSerializer ());
//	} // registerTypeAdapters
//
//	private static class AgotOptionSerializer implements JsonSerializer<AgotOption<?>> {
//
//		@Override
//		public JsonElement serialize (AgotOption<?> option, Type arg1, JsonSerializationContext arg2) {
//			JsonObject jWrap = new JsonObject ();
//			jWrap.addProperty ("key", option.getKey ());
//			jWrap.addProperty ("label", option.getLabel ());
//			IAgotModel model = option.getModel ();
//			if (model != null) {
//				ModelSerializer ser = new ModelSerializer ();
//				model.accept (ser);
//				jWrap.add (ser.getJsonKey (), ser.getJson ());				
//			} // if
//			return jWrap;
//		} // serialize
//		
//	} // AgotOptionSerializer
	
} // AgotGson
