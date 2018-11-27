package motif.agot.flow.request;

import java.util.ArrayList;
import java.util.stream.Stream;

import com.google.gson.annotations.Expose;

import lombok.Getter;
import motif.agot.config.AgotConfig;
import motif.agot.state.AgotPlayer;
import motif.shared.exceptions.MotifUnexpectedError;
import motif.shared.flow.request.MotifClientRequest;

public class AgotRequest<T extends IAgotModel> extends MotifClientRequest<AgotResponse> {
	
	@Expose @Getter private String title;
	@Getter private AgotPlayer player;
	@Getter private AgotRequestCod requestCod;
	@Getter private AgotOption<T> passOption = null;
	@Getter private AgotOption<T> continueOption = null;
	public boolean hasPassOption () { return passOption != null; }
	private ArrayList<T> models;
	@Expose private ArrayList<AgotOption<T>> options = new ArrayList<AgotOption<T>> ();
	public Stream<AgotOption<T>> options () { return options.stream (); }
	public AgotOption<T> getOptionByModel (T model) { return options ().filter (o -> o.model == model).findFirst ().get (); }
	
	@Override public String toString () {
		StringBuilder s = new StringBuilder (title).append ("\n");
		options ().forEach (o -> s.append (o.key + " " + o.label).append ("\n"));
		return s.toString ();
	} // toString
	
	protected AgotRequest (AgotRequestCod requestCod, AgotPlayer player, String title, Stream<? extends T> models) {
		this.requestCod = requestCod;
		this.player = player;
		this.title = title;
		addOptions (models);
	} // AgotRequest

	private void addOptions (Stream<? extends T> models) {
		this.models = new ArrayList<T> ();
		int[] counter = new int[] { 1 };
		models.forEach (model -> {
			this.models.add (model);
			addOption (counter[0]++ + "", model);			
		});
	} // addOptions
	
	private void addOption (String key, T model) {
		options.add (new AgotOption<T> (key, model));
	} // addOption
	
	public void addPassOption () { passOption = new AgotOption<T> ("-", "Pass"); options.add (passOption);}
	public void addContinueOption () { continueOption = new AgotOption<T> (">", "Continue"); options.add (continueOption);}
	
	public AgotChoice<T> getChoice (AgotResponse response) {
		String command = response.getCommand ();
		T choice = null;
		if (models != null && command.matches ("\\d+")) { choice = models.get (Integer.parseInt (command) - 1); }
		return new AgotChoice<T> (command, choice);
	} // getChoice
	
	public static class AgotOption<M extends IAgotModel> {
		@Expose @Getter private String key;
		@Expose @Getter private String label;
		@Getter private M model;
		protected AgotOption (String key, M model) {
			this.key = key;
			this.label = model.getLabel ();
			this.model = model;
		} // ModelOption
		protected AgotOption (String key, String label) {
			this.key = key;
			this.label = label;
			this.model = null;
		} // ModelOption
		@Override public String toString () { return key + ": " + label; }
	} // AgotOption
	
	public static class AgotChoice<M extends IAgotModel> {
		@Getter private M model;
		public AgotChoice (String key, M model) {
			this.key = key;
			this.model = model;
		} // Choice
		private String key;
		public boolean is (String key) { return this.key.equals (key); }
		public boolean isPass () { return is ("-"); }
	} // Choice
	
	public enum AgotRequestCod {
		SELECT_ACTION_TO_PERFORM ("selectActionToPerform"),
		SELECT_REACTION_TO_PERFORM ("selectReactionToPerform"),
		SELECT_INTERRUPT_TO_PERFORM ("selectInterruptToPerform"),
		SELECT_CHARACTER_TO_KILL ("selectCharacterToKill"),
		SELECT_CHARACTER_TO_DEFEND ("selectCharacterToDefend"),
		SELECT_CHALLENGE_TO_INITIATE ("selectChallengeToInitiate"),
		SELECT_CHARACTER_TO_ATTACK ("selectCharacterToAttack"),
		SELECT_CHARACTER_TO_BYPASS ("selectCharacterToBypass"),
		SELECT_DEFENDER ("selectDefender"),
		SELECT_PLOT_TO_REVEAL ("selectPlotToReveal"),
		SELECT_FIRST_PLAYER ("selectFirstPlayer"),
		SELECT_CARD_TO_ATTACH ("selectCardToAttach"),
		SELECT_CARD_TO_DISCARD ("selectCardToDiscard"),
		CHOOSE_CARD ("chooseCard"),
		CONTINUE ("continue");
		@Getter private String cod;
		private AgotRequestCod (String cod) { this.cod = cod; }
	} // AgotRequestCod
	
	public static <T extends IAgotModel> AgotRequest<T> createRequest (AgotRequestCod requestCod, AgotPlayer player, Stream<? extends T> choices, String requestMessage) {
		return new AgotRequest<T> (requestCod, player, requestMessage, choices);
	} // createModelRequest
	
	@Override
	public AgotResponse getAutoResponse () {
		int numOptions = options.size ();
		if (numOptions == 0) {
			throw new MotifUnexpectedError ("Request without options.");
		} else if (numOptions == 1) {
			if (AgotConfig.AUTO_RESPOND_IF_NO_CHOICES && !(AgotConfig.AUTO_RESPOND_IF_NO_CHOICES_EXCEPT_CONTINUE && requestCod.equals (AgotRequestCod.CONTINUE))) {
				return new AgotResponse (options.get (0).getKey ());
			} else {
				return null;
			} // if - else
		} else {
			return null;
		} // if - else
	} // getAutoResponse

} // AgotClientModelRequest
