package com.motif.brit.logic.requests;

import com.motif.brit.endpoint.BritContext;
import com.motif.brit.logic.flow.BritRequest;
import com.motif.brit.logic.flow.BritResponse;
import com.motif.brit.logic.flow.IBritFlowDecision;
import com.motif.brit.state.BritPlayer;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class BritContinueRequest implements IBritFlowDecision {

	private final String text;
	private final BritPlayer player;
	
	@Override
	public BritRequest<?> request(BritContext context) {
		BritRequest<?> pendingRequest = BritRequest.createContinueRequest(this.player, this.text);
		pendingRequest.addContinueOption ();
		return pendingRequest;
	}

	public void response (BritResponse response, BritContext context) {
	}

}
