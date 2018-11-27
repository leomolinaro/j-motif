package motif.shared.endpoint;

import java.lang.reflect.Type;

//import javax.json.Json;
//import javax.json.JsonArrayBuilder;
//import javax.json.JsonObject;
//import javax.json.JsonObjectBuilder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import motif.shared.endpoint.sessions.MotifSession;
import motif.shared.endpoint.sessions.MotifUser;

public class MotifGson {

	private static MotifGson instance;
	
	protected MotifGson () {
		GsonBuilder gsonBuilder = new GsonBuilder ();
		registerTypeAdapters (gsonBuilder);
		gson = gsonBuilder.excludeFieldsWithoutExposeAnnotation ().create ();
	} // MotifGson

	public static MotifGson instance () {
		if (instance == null) { instance = new MotifGson (); }
		return instance;
	} // instance
	
	protected void registerTypeAdapters (GsonBuilder gsonBuilder) {
		gsonBuilder.registerTypeAdapter (MotifUser.class, new MotifUserSerializer ());
		gsonBuilder.registerTypeAdapter (MotifSession.class, new MotifSessionSerializer ());
	} // registerTypeAdapters

	protected Gson gson;
	public static Gson g () { return instance ().gson; }
	
	private static class MotifUserSerializer implements JsonSerializer<MotifUser> {

		@Override
		public JsonElement serialize (MotifUser user, Type arg1, JsonSerializationContext arg2) {
			JsonObject jUser = new JsonObject ();
			jUser.addProperty ("username", user.getUsername ());
			return jUser;
		} // serialize
		
	} // MotifUserSerializer

	private static class MotifSessionSerializer implements JsonSerializer<MotifSession> {
		
		@Override
		public JsonElement serialize (MotifSession session, Type arg1, JsonSerializationContext context) {
			JsonObject jSession = new JsonObject ();
			jSession.addProperty ("id", session.getId ());
			jSession.add ("user", context.serialize (session.getUser ()));
			return jSession;
		} // serialize
		
	} // MotifUserSerializer
	
} // AgotGson
