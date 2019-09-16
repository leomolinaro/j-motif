package com.motif.agot.logic.act;

import com.motif.agot.ang.text.AngWhenRevealed;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.flow.IAgotFlowProcess;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.logic.other.AbilityContext;
import com.motif.agot.logic.requests.AAgotRequest.AgotRequestType;
import com.motif.agot.logic.requests.AgotChoice;
import com.motif.agot.logic.requests.AgotChoice.AgotChoiceCardAction;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.AgotPlayer;
import com.motif.agot.state.cards.PlotCard;
import com.motif.shared.util.MotifConsole;

import lombok.Getter;

public class WhenRevealedAct extends TrigAbilityAct<AngWhenRevealed> {

	public interface IHasWhenRevealedAct extends IAgotFlowProcess { public IAgotFlowStep after (WhenRevealedAct act, AgotContext context); }
	@Getter private final IHasWhenRevealedAct parent;
	@Override public IAgotFlowStep next (AgotContext context) { return this.parent.after (this, context); }
	
	public WhenRevealedAct (AngWhenRevealed whenRevealed, PlotCard plotCard, AgotPlayer player, AgotGame game, IHasWhenRevealedAct parent) {
		super (whenRevealed, new AbilityContext (plotCard, player), game);
		this.parent = parent;
	} // WhenRevealedAct
	
	@Override
	public String toString() { return MotifConsole.format ("When revealed {0}", ac.thisCard.getTitle ()); }

	@Override
	public AgotChoice getChoice (AgotRequestType requestType) {
		return AgotChoice.selectCardActionChoice (requestType, this.getTrigCard (), AgotChoiceCardAction.WHEN_REVEALED);
	} // getChoice
	
} // WhenRevealedAct
