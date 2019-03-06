package com.motif.brit.logic.play.battlesandretreats;

import com.motif.brit.endpoint.BritContext;
import com.motif.brit.logic.flow.IBritFlowProcess;
import com.motif.brit.logic.flow.IBritFlowStep;
import com.motif.brit.logic.requests.BritContinueRequest;
import com.motif.brit.state.BritPlayer;

import lombok.Getter;

public class BritThrowDefendingDiceRequest extends BritContinueRequest {
	
	public BritThrowDefendingDiceRequest(String text, BritPlayer player, IBritAfterThrowDefendingDice parent) {
		super(text, player);
		this.parent = parent;
	}

	public interface IBritAfterThrowDefendingDice extends IBritFlowProcess { public IBritFlowStep after(BritThrowDefendingDiceRequest throwDefendingDice, BritContext context); }
	@Getter private final IBritAfterThrowDefendingDice parent;
	@Override public IBritFlowStep next(BritContext context) { return this.parent.after(this, context); }
	
}
