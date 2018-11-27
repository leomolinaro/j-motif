package motif.brit.state;

import com.google.gson.annotations.Expose;

import lombok.Getter;
import lombok.Setter;

public class BritDie {

	@Getter private BritUnit unit;
	@Expose private String unitId;
	public boolean isRomanInfantry() { return unit.isRoman() && unit.isInfantry(); }
	public boolean isCavalry() { return unit.isCavalry(); }
	
	@Expose @Getter @Setter private Integer result;
	
	@Getter private boolean resolved = false;
	public void setResolved() { this.resolved = true; }

	public BritDie(BritUnit unit) {
		this.unit = unit;
		this.unitId = unit.getId();
	}

	
}
