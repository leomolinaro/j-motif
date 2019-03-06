package com.motif.brit.logic.play.battlesandretreats;

import com.motif.brit.endpoint.BritContext;
import com.motif.brit.logic.flow.IBritFlowProcess;
import com.motif.brit.logic.flow.IBritFlowStep;
import com.motif.brit.logic.requests.BritContinueRequest;
import com.motif.brit.state.BritPlayer;

import lombok.Getter;

public class BritThrowAttackingDiceRequest extends BritContinueRequest {
	
	public BritThrowAttackingDiceRequest(String text, BritPlayer player, IBritAfterThrowAttackingDice parent) {
		super(text, player);
		this.parent = parent;
	}

	public interface IBritAfterThrowAttackingDice extends IBritFlowProcess { public IBritFlowStep after(BritThrowAttackingDiceRequest throwAttackingDice, BritContext context); }
	@Getter private final IBritAfterThrowAttackingDice parent;
	@Override public IBritFlowStep next(BritContext context) { return this.parent.after(this, context); }
	
}
