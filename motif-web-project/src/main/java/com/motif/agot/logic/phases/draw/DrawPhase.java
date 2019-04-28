package com.motif.agot.logic.phases.draw;

import com.motif.agot.ang.AgotText;
import com.motif.agot.ang.enums.AngPhase;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.flow.IAgotFlowProcess;
import com.motif.agot.logic.flow.IAgotFlowStep;
import com.motif.agot.logic.phases.APhase;
import com.motif.agot.logic.phases.APhaseStep;
import com.motif.agot.logic.phases.AStartPhaseStep;
import com.motif.agot.logic.phases.draw.DrawActionStep.IHasDrawActionPhaseStep;
import com.motif.agot.logic.phases.draw.DrawCardsStep.IHasDrawCardsPhaseStep;
import com.motif.agot.logic.phases.draw.EndDrawPhaseStep.IHasEndDrawPhaseStep;
import com.motif.agot.logic.phases.draw.StartDrawPhaseStep.IHasStartDrawPhaseStep;
import com.motif.agot.state.AgotGame;

import lombok.Getter;

public class DrawPhase extends APhase<IDrawPhaseStep>
        implements IHasStartDrawPhaseStep, IHasDrawCardsPhaseStep, IHasDrawActionPhaseStep, IHasEndDrawPhaseStep {

	public interface IAgotHasDrawPhase extends IAgotFlowProcess { public IAgotFlowStep after(DrawPhase phase, AgotContext context); }
	@Getter private final IAgotHasDrawPhase parent;
	@Override public IAgotFlowStep next(AgotContext context) { return this.parent.after(this, context); }
	
	public DrawPhase (AgotGame game, IAgotHasDrawPhase parent) {
		super (AngPhase.DRAW, game);
		this.parent = parent;
	}
	
	@Override
	public String getPhaseTitle () { return AgotText.title ().drawPhase (); }

	@Override
	public AStartPhaseStep<IDrawPhaseStep> startPhaseStep () { return new StartDrawPhaseStep (this.game, this); }
	@Override
	public APhaseStep<IDrawPhaseStep> after(EndDrawPhaseStep endDrawPhaseStep, AgotContext context) { return null; }
	@Override
	public APhaseStep<IDrawPhaseStep> after(DrawActionStep drawActionStep, AgotContext context) { return new EndDrawPhaseStep(this.game, this); }
	@Override
	public APhaseStep<IDrawPhaseStep> after(DrawCardsStep drawCardsStep, AgotContext context) { return new DrawActionStep(this.game, this); }
	@Override
	public APhaseStep<IDrawPhaseStep> after(StartDrawPhaseStep startPhaseStep, AgotContext context) { return new DrawCardsStep(this.game, this); }

}
