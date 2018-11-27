package motif.agot.logic.act;

import motif.agot.ang.enums.AngPhase;
import motif.agot.ang.text.AngAction;
import motif.agot.ang.text.AngAction.AngActionType;
import motif.agot.flow.request.IAgotModelVisitor;
import motif.agot.logic.other.AbilityContext;
import motif.agot.state.AgotGame;
import motif.agot.state.AgotPlayer;
import motif.agot.state.cards.TextCard;
import motif.shared.util.MotifConsole;

public final class ActionAct extends TrigAbilityAct<AngAction> {

	private AngPhase phase;
	private AngActionType actionType;
	
	public ActionAct (AngPhase phase, AngAction action, TextCard<?> actingCard, AgotPlayer actingPlayer, AgotGame game) {
		super (action, new AbilityContext (actingCard, actingPlayer), game);
		this.phase = phase;
		this.actionType = action.getType ();
	} // ActionAct

	@Override
	public String getLabel () { return MotifConsole.format ("Action {0}", ac.thisCard.getTitle ()); }

	@Override
	public void accept (IAgotModelVisitor visitor) { visitor.visit (this); }

	@Override
	public boolean canBeInitiated () {
		boolean canBeInitiated = super.canBeInitiated ();
		if (!canBeInitiated) { return false; }
		if (!actionType.equals (AngActionType.ACTION)) {
			switch (phase) {
				case CHALLENGES: if (!actionType.equals (AngActionType.CHALLENGES_ACTION)) { return false; }
				case DOMINANCE: if (!actionType.equals (AngActionType.DOMINANCE_ACTION)) { return false; }
				case DRAW: if (!actionType.equals (AngActionType.DRAW_ACTION)) { return false; }
				case MARSHALLING: if (!actionType.equals (AngActionType.MARSHALLING_ACTION)) { return false; }
				case PLOT: if (!actionType.equals (AngActionType.PLOT_ACTION)) { return false; }
				case STANDING: if (!actionType.equals (AngActionType.STANDING_ACTION)) { return false; }
				case TAXATION: if (!actionType.equals (AngActionType.TAXATION_ACTION)) { return false; }
			} // switch
		} // if
		return true;
	} // canBeInitiated

} // ActingActStep
