package motif.agot.state;

import motif.agot.ang.text.AngConsAbility;
import motif.agot.ang.text.conseffects.IAngConsAlignEffect;
import motif.agot.state.cards.TextCard;

public class ConsAlignAbility extends ConsAbility {

	public ConsAlignAbility (AngConsAbility ang, TextCard<?> card) {
		super (ang, card);
	} // ConsAlignAbility

	@Override
	public IAngConsAlignEffect getConsEffect () { return (IAngConsAlignEffect) super.getConsEffect (); }
	
} // ConsAlignAbility
