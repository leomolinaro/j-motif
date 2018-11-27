package motif.agot.flow.request;

import motif.agot.ang.enums.AngIcon;
import motif.agot.logic.act.ActionAct;
import motif.agot.logic.act.InterruptAct;
import motif.agot.logic.act.MarshallingAct;
import motif.agot.logic.act.ReactionAct;
import motif.agot.logic.round.phases.challenges.InitiateChallengeStep.AvailableChallenge;
import motif.agot.state.AgotPlayer;
import motif.agot.state.cards.Card;

public interface IAgotModelVisitor {

	public void visit (MarshallingAct marshallingTrigger);
	public void visit (AngIcon angIcon);
	public void visit (AvailableChallenge availableChallenge);
	public void visit (Card<?> card);
	public void visit (AgotPlayer player);
	public void visit (ReactionAct reactionAct);
	public void visit (InterruptAct interruptAct);
	public void visit (ActionAct actionAct);

} // IAgotModelVisitor
