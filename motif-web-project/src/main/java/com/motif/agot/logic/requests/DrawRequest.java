package com.motif.agot.logic.requests;

import java.util.LinkedHashSet;

import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.flow.IAgotFlowProcess;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.state.AgotPlayer;

import lombok.Getter;

public class DrawRequest extends AAgotRequest {

	private final int nCards;
	
	public DrawRequest (int nCards, String instruction, AgotPlayer player, IHasDrawRequest parent) {
		super(
				AgotRequestType.DRAW,
				player,
				instruction
		);
		this.parent = parent;
		this.addChoice (AgotChoice.drawChoice ());
		this.nCards = nCards;
	} // ContinueRequest
	
	public interface IHasDrawRequest extends IAgotFlowProcess { public IAgotFlowStep after (DrawRequest drawDecision, AgotContext context); }
	@Getter private final IHasDrawRequest parent;
	@Override public IAgotFlowStep next(AgotContext context) { return this.parent.after (this, context); }
	
	@Getter private LinkedHashSet<Long> drawCardIds; 

	@Override
	protected boolean acceptChoice (AgotChoice choice, AgotContext context) {
		if (!choice.equals (AgotChoice.drawChoice ())) { return false; }
		if (choice.getDrawCardSeeds () != null) { // per test, il giocatore sceglie quali carte pescare dal mazzo di pesca
			if (choice.getDrawCardSeeds ().size () > this.nCards) { return false; }
			var drawCardIds = new LinkedHashSet<Long> ();
			for (var seed : choice.getDrawCardSeeds ()) {
				var seedFound = false;
				var drawDeckIt = this.getPlayer ().drawDeckIt ();
				while (drawDeckIt.hasNext () && !seedFound) {
					var drawCard = drawDeckIt.next ();
					if (seed == drawCard.seed ()) {
						if (drawCardIds.add (drawCard.id ())) {
							seedFound = true;
						} // if
					} // if
				} // while
				if (!seedFound) { return false; }
			} // for
			this.drawCardIds = drawCardIds;
		} // if
		return true;
	} // acceptChoice
	
	@Override
	public AgotChoice getAutoChoice () {
		return null;
	} // getAutoChoice
	
} // DrawRequest
