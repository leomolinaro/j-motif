package motif.brit.logic.flow;

import java.util.Collections;
import java.util.List;

import com.google.gson.annotations.Expose;

import lombok.Getter;
import motif.brit.state.BritArea;
import motif.brit.state.BritPlayer;
import motif.brit.state.BritUnit;

public class BritRequest<T extends IBritModel> {
	
	private static final String SELECT_AREA = "selectArea";
	private static final String SELECT_UNIT = "selectUnit";
	private static final String CONTINUE = "continue";
	
	private static final String PASS_KEY = "p";
	private static final String CONTINUE_KEY = "c";
	
	public static <T extends BritArea> BritRequest<T> createSelectAreaRequest(BritPlayer player, List<T> models, String instruction) {
		return new BritRequest<T>(SELECT_AREA, player, instruction, models);
	}
	
	public static <U extends BritUnit> BritRequest<U> createSelectUnitRequest(BritPlayer player, List<U> models, String instruction) {
		return new BritRequest<U>(SELECT_UNIT, player, instruction, models);
	}
	
	public static BritRequest<IBritModel> createContinueRequest(BritPlayer player, String instruction) {
		return new BritRequest<IBritModel>(CONTINUE, player, instruction, Collections.emptyList ());
	}
	
	@Expose @Getter private String instruction;
	@Getter private BritPlayer player;
	@Expose @Getter private String type;

	@Expose @Getter private String passOption = null;
	public boolean hasPassOption () { return passOption != null; }
	
	@Expose @Getter private String continueOption = null;
	public boolean hasContinueOption () { return continueOption != null; }
	
	@Expose private List<? extends T> modelOptions;
	public String getKeyByModel (T model) { return modelOptions.indexOf (model) + ""; }
	
	@Override public String toString () {
		StringBuilder s = new StringBuilder (instruction).append ("\n");
		if (modelOptions != null) {
			int index = 0;
			for (T modelOption : modelOptions) {
				s.append (index++ + " " + modelOption.getLabel ()).append ("\n");
			} // for
		} // if
		if (hasPassOption ()) { s.append (PASS_KEY + " Pass").append ("\n"); }
		if (hasContinueOption ()) { s.append (CONTINUE_KEY + " Continue").append ("\n"); }
		return s.toString ();
	} // toString
	
	protected BritRequest (String type, BritPlayer player, String instruction, List<? extends T> models) {
		this.type = type;
		this.player = player;
		this.instruction = instruction;
		addModelOptions (models);
	} // BritRequest

	private void addModelOptions (List<? extends T> models) { this.modelOptions = models; }
	public void addPassOption () { passOption = PASS_KEY; }
	public void addContinueOption () { continueOption = CONTINUE_KEY; }
	
	public boolean isValidResponse (BritResponse response) {
		String key = response.getKey ();
		if (key == null) { return false; }
		if (key.equals (passOption)) { return true; }
		if (key.equals (continueOption)) { return true; }
		if (modelOptions != null && key.matches ("\\d+")) {
			int index = Integer.parseInt (key);
			if (index >= 0 && index < modelOptions.size ()) { return true; }
		} // if 
		return false;
	} // isValidResponse
	
	public BritChoice<T> getChoice (BritResponse response) {
		String key = response.getKey ();
		T choice = null;
		if (modelOptions != null && key.matches ("\\d+")) { choice = modelOptions.get (Integer.parseInt (key)); }
		return new BritChoice<T> (key, choice);
	} // getChoice
	
	public static class BritChoice<M extends IBritModel> {
		@Getter private M model;
		public BritChoice (String key, M model) {
			this.key = key;
			this.model = model;
		} // Choice
		private String key;
		public boolean is (String key) { return this.key.equals (key); }
		public boolean isPass () { return is (PASS_KEY); }
	} // Choice
	
	public BritResponse getAutoResponse () {
		return null;
//		int numOptions = options.size ();
//		if (numOptions == 0) {
//			throw new MotifUnexpectedError ("Request without options.");
//		} else if (numOptions == 1) {
//			if (BritConfig.AUTO_RESPOND_IF_NO_CHOICES && !(BritConfig.AUTO_RESPOND_IF_NO_CHOICES_EXCEPT_CONTINUE && type.equals (CONTINUE))) {
//				return new BritResponse (options.get (0).getKey ());
//			} else {
//				return null;
//			} // if - else
//		} else {
//			return null;
//		} // if - else
	}

} // BritClientModelRequest
