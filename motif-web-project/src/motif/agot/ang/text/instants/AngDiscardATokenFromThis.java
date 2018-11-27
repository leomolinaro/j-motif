package motif.agot.ang.text.instants;

import lombok.Getter;
import motif.agot.ang.enums.AngToken;
import motif.agot.ang.text.costs.IAngCost;
import motif.agot.ang.text.costs.IAngCostVisitor;

public class AngDiscardATokenFromThis implements IAngCost {

	@Getter private AngToken token;

	public AngDiscardATokenFromThis (AngToken token) {
		this.token = token;
	} // AngDiscardATokenFromThis

	@Override public boolean accept (IAngCostVisitor visitor) { return visitor.visit (this); }
	
} // AngDiscardATokenFromThis
