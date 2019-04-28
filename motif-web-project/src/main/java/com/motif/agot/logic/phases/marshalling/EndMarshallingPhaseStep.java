package com.motif.agot.logic.phases.marshalling;

import com.motif.agot.ang.AgotText;
import com.motif.agot.ang.enums.AngPhase;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.flow.IAgotFlowProcess;
import com.motif.agot.logic.phases.AEndPhaseStep;
import com.motif.agot.logic.phases.APhaseStep;
import com.motif.agot.state.AgotGame;

import lombok.Getter;

public class EndMarshallingPhaseStep extends AEndPhaseStep<IMarshallingPhaseStep> {

	public interface IHasEndMarshallingPhaseStep extends IAgotFlowProcess { public APhaseStep<IMarshallingPhaseStep> after(EndMarshallingPhaseStep endMarshallingPhaseStep, AgotContext context); }
	@Getter private final IHasEndMarshallingPhaseStep parent; 
	@Override public APhaseStep<IMarshallingPhaseStep> next(AgotContext context) { return this.parent.after(this, context); }
	
	public EndMarshallingPhaseStep(AgotGame game, IHasEndMarshallingPhaseStep parent) {
		super(AngPhase.MARSHALLING, game);
		this.parent = parent;
	}

	@Override
	public String getStepTitle () { return AgotText.title ().endMarshallingPhaseStep (); }
	
}
