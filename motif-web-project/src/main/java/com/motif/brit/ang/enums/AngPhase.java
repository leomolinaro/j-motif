package com.motif.brit.ang.enums;

import lombok.Getter;

public enum AngPhase {
	
	POPULATION_INCREASE ("Population Increase"),
	MOVEMENT ("Movement"),
	BATTLES_AND_RETREATS ("Battles/Retreats"),
	RAIDER_WITHDRAWAL ("Raider Withdrawal"),
	OVERPOPULATION ("Overpopulation");
	
	@Getter private String label;

	private AngPhase (String label) {
		this.label = label;
	} // AngPhase
	
} // AngPhase
