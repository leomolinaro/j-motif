package com.motif.agot.ang.enums;

import lombok.Getter;

public enum AngPhase {
	CHALLENGES ("Challenges phase"),
	DOMINANCE ("Dominance phase"),
	DRAW ("Draw phase"),
	MARSHALLING ("Marshalling phase"),
	PLOT ("Plot phase"),
	STANDING ("Standing phase"),
	TAXATION ("Taxation phase");
	
	@Getter private String label;

	private AngPhase (String label) {
		this.label = label;
	} // AngPhase
	
} // AngPhase
