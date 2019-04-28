package com.motif.agot.logic.phases.marshalling;

import com.motif.agot.ang.AgotText;
import com.motif.agot.ang.enums.AngPhase;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.flow.IAgotFlowProcess;
import com.motif.agot.logic.phases.APhaseStep;
import com.motif.agot.logic.phases.AStartPhaseStep;
import com.motif.agot.state.AgotGame;

import lombok.Getter;

public class StartMarhallingPhaseStep extends AStartPhaseStep<IMarshallingPhaseStep> {

	public interface IHasStartMarhallingPhaseStep extends IAgotFlowProcess { public APhaseStep<IMarshallingPhaseStep> after(StartMarhallingPhaseStep startMarhallingPhaseStep, AgotContext context); }
	@Getter private final IHasStartMarhallingPhaseStep parent; 
	@Override public APhaseStep<IMarshallingPhaseStep> next(AgotContext context) { return this.parent.after(this, context); }
	
	public StartMarhallingPhaseStep(AgotGame game, IHasStartMarhallingPhaseStep parent) {
		super(AngPhase.MARSHALLING, game);
		this.parent = parent;
	}

	@Override
	public String getStepTitle () { return AgotText.title ().startMarshallingPhaseStep (); }

}
