package motif.agot.logic.events.list;

import motif.agot.endpoint.AgotContext;
import motif.agot.flow.task.IAgotTask;
import motif.agot.logic.events.Event;
import motif.agot.logic.events.IEventVisitor;
import motif.agot.state.Challenge;
import motif.agot.state.AgotGame;

public class InitiateAChallengeEvent extends Event {

	private Challenge challenge;
	public Challenge getChallenge () { return challenge; }
	
	public InitiateAChallengeEvent (Challenge challenge, AgotGame game) {
		super (game);
		this.challenge = challenge;	
	} // InitiateAChallengeEvent
	
	@Override public boolean accept (IEventVisitor visitor) { return visitor.visit (this); }

	@Override
	public IAgotTask resolveEffect (AgotContext context) {
		// TODO Auto-generated method stub
		return null;
	}
	
} // InitiateAChallengeEvent
