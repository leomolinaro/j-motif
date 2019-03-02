package motif.brit.logic.play;

import lombok.Getter;
import motif.brit.ang.enums.AngPhase;
import motif.brit.endpoint.BritContext;
import motif.brit.logic.flow.IBritFlowProcess;
import motif.brit.logic.flow.IBritFlowStep;
import motif.brit.state.BritGame;
import motif.brit.state.BritNation;

public class BritPhaseRaiderWithdrawal extends ABritPhase {
	
	public BritPhaseRaiderWithdrawal(AngPhase phase, BritNation nation, BritGame game, IBritFlowWithRaiderWithdrawal parent) {
		super(phase, nation, game);
		this.parent = parent;
	}

	public interface IBritFlowWithRaiderWithdrawal extends IBritFlowProcess { public IBritFlowStep after(BritPhaseRaiderWithdrawal raiderWithdrawal, BritContext context); }
	@Getter private final IBritFlowWithRaiderWithdrawal parent;
	@Override public IBritFlowStep next(BritContext context) { return this.parent.after(this, context); }
	
	@Override
	public IBritFlowStep start(BritContext context) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
