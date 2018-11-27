package motif.agot.ang.enums;

import lombok.Getter;

public enum AngToken {
	STAND ("Stand"),
	POISON ("Poison");
	@Getter private String label;
	private AngToken (String label) { this.label = label; }
} // AngToken
