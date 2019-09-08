package com.motif.agot.logic;

import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.flow.IAgotFlowProcess;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.logic.phases.challenges.ChallengesPhase;
import com.motif.agot.logic.phases.challenges.ChallengesPhase.IAgotHasChallengesPhase;
import com.motif.agot.logic.phases.dominance.DominancePhase;
import com.motif.agot.logic.phases.dominance.DominancePhase.IAgotHasDominancePhase;
import com.motif.agot.logic.phases.draw.DrawPhase;
import com.motif.agot.logic.phases.draw.DrawPhase.IAgotHasDrawPhase;
import com.motif.agot.logic.phases.marshalling.MarshallingPhase;
import com.motif.agot.logic.phases.marshalling.MarshallingPhase.IAgotHasMarshallingPhase;
import com.motif.agot.logic.phases.plot.PlotPhase;
import com.motif.agot.logic.phases.plot.PlotPhase.IAgotHasPlotPhase;
import com.motif.agot.logic.phases.standing.StandingPhase;
import com.motif.agot.logic.phases.standing.StandingPhase.IAgotHasStandingPhase;
import com.motif.agot.logic.phases.taxation.TaxationPhase;
import com.motif.agot.logic.phases.taxation.TaxationPhase.IAgotHasTaxationPhase;
import com.motif.agot.state.AgotGame;
import com.motif.shared.util.MotifConsole;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AgotRound implements 
		IAgotHasPlotPhase, 
		IAgotHasDrawPhase,
		IAgotHasMarshallingPhase,
		IAgotHasChallengesPhase,
		IAgotHasDominancePhase,
		IAgotHasStandingPhase,
		IAgotHasTaxationPhase {

	@Getter
	private final int roundNumber;
	private final AgotGame game;

	public interface IHasAgotRound extends IAgotFlowProcess { public IAgotFlowStep after(AgotRound round, AgotContext context); }
	@Getter private final IHasAgotRound parent;
	@Override public IAgotFlowStep next(AgotContext context) { return this.parent.after(this, context); }

	public String getRoundTitle() {
		return "Round " + roundNumber;
	}

	@Override
	public PlotPhase start(AgotContext context) {
		String roundTitle = getRoundTitle();
		MotifConsole.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		MotifConsole.println(roundTitle);
		MotifConsole.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		game.setRound(getRoundTitle(), context);
		game.logManager().round(roundTitle, context);
		return new PlotPhase(game, this);
	}

	@Override
	public IAgotFlowStep after(PlotPhase phase, AgotContext context) { return new DrawPhase(game, this); }
	@Override
	public IAgotFlowStep after(TaxationPhase phase, AgotContext context) { return null; }
	@Override
	public IAgotFlowStep after(StandingPhase phase, AgotContext context) { return new TaxationPhase(game, this); }
	@Override
	public IAgotFlowStep after(DominancePhase phase, AgotContext context) { return new StandingPhase(game, this); }
	@Override
	public IAgotFlowStep after(ChallengesPhase phase, AgotContext context) { return new DominancePhase(game, this); }
	@Override
	public IAgotFlowStep after(MarshallingPhase phase, AgotContext context) { return new ChallengesPhase(game, this); }
	@Override
	public IAgotFlowStep after(DrawPhase phase, AgotContext context) { return new MarshallingPhase(game, this); }

} // AgotRound
