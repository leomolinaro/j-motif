package com.motif.agot.logic.flow;

import com.google.gson.annotations.Expose;
import com.motif.agot.logic.requests.AgotChoice;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AgotResponse {

	@Expose @Getter private final String playerId;
	
	@Expose @Getter private final AgotChoice choice;

}
