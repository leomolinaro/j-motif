package motif.agot.ang.enums;

import motif.agot.flow.request.IAgotModel;
import motif.agot.flow.request.IAgotModelVisitor;

public enum AngIcon implements IAgotModel {
	MILITARY ("Military"),
	POWER ("Power"),
	INTRIGUE ("Intrigue");

	private String label;
	
	private AngIcon (String label) {
		this.label = label;
	} // AngIcon
	
	@Override
	public String getLabel () { return label; }

	@Override public void accept (IAgotModelVisitor visitor) { visitor.visit (this); }
	
} // AngIcon
