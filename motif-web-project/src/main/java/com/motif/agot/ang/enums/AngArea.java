package com.motif.agot.ang.enums;

public enum AngArea {

	FACTION ("FACTION"),
	AGENDA ("AGENDA"),
	HAND ("HAND"),
	CHARACTERS ("CHARACTERS"),
	LOCATIONS ("LOCATIONS"),
	DISCARD_PILE ("DISCARD_PILE"),
	DRAW_DECK ("DRAW_DECK"),
	PLOT_DECK ("PLOT_DECK"),
	USED_PLOT_PILE ("USED_PLOT_PILE"),
	REVEALED_PLOT ("REVEALED_PLOT"),
	DEAD_PILE ("DEAD_PILE");
	
	private String label;
	public String getLabel () { return label; }

	private AngArea (String label) {
		this.label = label;
	} // AngArea
	
	public static final int TOP_PILE = -1;
	public static final int BOTTOM_PILE = 0;
	public static final int END_LIST = -1;
	
} // Area
