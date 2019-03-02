package motif.brit.logic.play.battlesandretreats;

import lombok.Getter;
import motif.brit.endpoint.BritContext;
import motif.brit.logic.flow.IBritFlowProcess;
import motif.brit.logic.flow.IBritFlowStep;
import motif.brit.logic.requests.BritContinueRequest;
import motif.brit.state.BritPlayer;

public class BritThrowDefendingDiceRequest extends BritContinueRequest {
	
	public BritThrowDefendingDiceRequest(String text, BritPlayer player, IBritAfterThrowDefendingDice parent) {
		super(text, player);
		this.parent = parent;
	}

	public interface IBritAfterThrowDefendingDice extends IBritFlowProcess { public IBritFlowStep after(BritThrowDefendingDiceRequest throwDefendingDice, BritContext context); }
	@Getter private final IBritAfterThrowDefendingDice parent;
	@Override public IBritFlowStep next(BritContext context) { return this.parent.after(this, context); }
	
}
