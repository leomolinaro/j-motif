package com.motif.agot.flow.request;

import com.motif.agot.ang.enums.AngIcon;
import com.motif.agot.logic.act.ActionAct;
import com.motif.agot.logic.act.InterruptAct;
import com.motif.agot.logic.act.MarshallingAct;
import com.motif.agot.logic.act.ReactionAct;
import com.motif.agot.logic.round.phases.challenges.InitiateChallengeStep.AvailableChallenge;
import com.motif.agot.state.AgotPlayer;
import com.motif.agot.state.cards.Card;

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
