package com.motif.agot.logic.phases.dominance;

import java.util.ArrayList;
import java.util.Comparator;

import com.motif.agot.ang.AgotText;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.events.AgotEvent;
import com.motif.agot.logic.events.AgotEventProcess;
import com.motif.agot.logic.events.IAgotHasEventProcess;
import com.motif.agot.logic.events.list.WinDominanceEvent;
import com.motif.agot.logic.flow.IAgotFlowProcess;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.logic.phases.APhaseStep;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.AgotPlayer;
import com.motif.shared.util.ComparatorUtil;

import lombok.Getter;

public class DetermineDominanceStep extends APhaseStep<IDominancePhaseStep> implements IAgotHasEventProcess {
	
	public interface IHasDetermineDominanceStep extends IAgotFlowProcess { public APhaseStep<IDominancePhaseStep> after(DetermineDominanceStep step, AgotContext context); }
	@Getter private final IHasDetermineDominanceStep parent; 
	@Override public APhaseStep<IDominancePhaseStep> next(AgotContext context) { return this.parent.after(this, context); }
	
	public DetermineDominanceStep(AgotGame game, IHasDetermineDominanceStep parent) {
		super(game);
		this.parent = parent;
	}
	
	@Override
	public String getStepTitle() { return AgotText.title().determineDominanceStep(); }
	
	@Override
	protected IAgotFlowStep stepStart(AgotContext context) {
		ArrayList<AgotPlayer> dominanceWinners = ComparatorUtil.getMax(game.players(), new Comparator<AgotPlayer>() {
			@Override
			public int compare(AgotPlayer p1, AgotPlayer p2) {
				var comparison = Integer.compare(p1.getDominance(), p2.getDominance());
				if (comparison < 0) {
					DetermineDominanceStep.this.game.logManager().hasMoreDominanceThan(p2, p1, context);
				} else if (comparison > 0) {
					DetermineDominanceStep.this.game.logManager().hasMoreDominanceThan(p1, p2, context);
				} else {
					DetermineDominanceStep.this.game.logManager().haveTheSameDominance(p1, p2, context);
				}
				return comparison;
			}
		});

		if (dominanceWinners.size() > 1) {
			this.game.logManager().dominanceTie(context);
			return null;
		} else {
			AgotPlayer dominanceWinner = dominanceWinners.get(0);
			AgotEvent event = new WinDominanceEvent(dominanceWinner, this.game);
			return new AgotEventProcess(event, this.game, this);
		}
	}

	@Override
	public IAgotFlowStep after(AgotEventProcess eventProcess, AgotContext context) {
		return null;
	}

}
