package motif.agot.endpoint;

import com.google.gson.annotations.Expose;

import lombok.Getter;
import motif.agot.endpoint.clientstate.AgotReduxActionList;
import motif.shared.endpoint.MotifContext;
import motif.shared.endpoint.sessions.MotifSession;

public class AgotContext extends MotifContext {

	private MotifSession session;
	@Expose @Getter private String player;
	@Expose private String opponent;
	public MotifSession getSession () { return this.session; }
	private void setSession (MotifSession session) {
		this.session = session;
		this.player = session.getUsername ();
		this.opponent = session.getUsername ().equals ("leo") ? "fede" : "leo";
	} // setSession

	private AgotReduxActionList actions;
	public AgotReduxActionList actions () {
		if (actions == null) { actions = new AgotReduxActionList (); }
		return this.actions;
	} // actions
	
	private AgotContext () {}
	
	public static AgotContext create (MotifSession session) {
		AgotContext context = new AgotContext ();
		context.setSession (session);
		return context;
	} // createAgotContext
	
} // AgotContext
