package com.motif.agot.logic.flow;

import com.google.gson.annotations.Expose;
import com.motif.agot.logic.requests.AgotChoice;

import lombok.Getter;
import lombok.Setter;

public class AgotResponse {

	@Expose @Getter @Setter private AgotChoice choice;

}
