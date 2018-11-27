package motif.agot.state;

import lombok.Getter;
import motif.agot.ang.text.conseffects.IAngConsEffect;
import motif.agot.ang.text.instants.AngLastingEffect;
import motif.agot.ang.text.untilconditions.IAngUntilCondition;
import motif.agot.logic.other.AbilityContext;

public class LastingEffect {

	@Getter private AngLastingEffect ang;
	public IAngUntilCondition getUntil () { return ang.getUntil (); }
	public IAngConsEffect getConsEffect () { return ang.getConsEffect (); }

	@Getter private AbilityContext abilityContext;

	public LastingEffect (AngLastingEffect ang, AbilityContext abilityContext) {
		this.ang = ang;
		this.abilityContext = abilityContext;
	}
	
} // LastingEffect
