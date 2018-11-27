package motif.agot.ang.text;

import motif.agot.ang.enums.AngPlotValueModifier;

public class AngTextPlotValueModifier {

	private AngPlotValueModifier modifier;
	public AngPlotValueModifier getModifier () { return modifier; }
	public boolean isModifier (AngPlotValueModifier testModifier) { return modifier.equals (testModifier); }

	private int value;
	public int getValue () { return value; }
	
	public AngTextPlotValueModifier (AngPlotValueModifier modifier, int value) {
		this.modifier = modifier;
		this.value = value;
	} // AngTextPlotValueModifier

	public static AngTextPlotValueModifier gold (int value) { return new AngTextPlotValueModifier (AngPlotValueModifier.GOLD, value); }
	public static AngTextPlotValueModifier initiative (int value) { return new AngTextPlotValueModifier (AngPlotValueModifier.INITIATIVE, value); }
	public static AngTextPlotValueModifier reserve (int value) { return new AngTextPlotValueModifier (AngPlotValueModifier.RESERVE, value); }

	
} // AngTextPlotValueModifier
