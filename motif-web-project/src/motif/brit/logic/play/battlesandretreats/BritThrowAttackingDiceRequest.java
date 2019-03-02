package motif.brit.logic.play.battlesandretreats;

import lombok.Getter;
import motif.brit.endpoint.BritContext;
import motif.brit.logic.flow.IBritFlowProcess;
import motif.brit.logic.flow.IBritFlowStep;
import motif.brit.logic.requests.BritContinueRequest;
import motif.brit.state.BritPlayer;

public class BritThrowAttackingDiceRequest extends BritContinueRequest {
	
	public BritThrowAttackingDiceRequest(String text, BritPlayer player, IBritAfterThrowAttackingDice parent) {
		super(text, player);
		this.parent = parent;
	}

	public interface IBritAfterThrowAttackingDice extends IBritFlowProcess { public IBritFlowStep after(BritThrowAttackingDiceRequest throwAttackingDice, BritContext context); }
	@Getter private final IBritAfterThrowAttackingDice parent;
	@Override public IBritFlowStep next(BritContext context) { return this.parent.after(this, context); }
	
}
