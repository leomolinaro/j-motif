package motif.agot.state;

import lombok.Getter;
import motif.agot.ang.text.AngConsAbility;
import motif.agot.ang.text.consconditions.IAngWhileCondition;
import motif.agot.ang.text.conseffects.IAngConsEffect;
import motif.agot.state.cards.TextCard;

public class ConsAbility {

	@Getter private boolean active;
	public void activate () { this.active = true; }
	public void deactivate () { this.active = false; }

	@Getter private AngConsAbility ang;
	public IAngConsEffect getConsEffect () { return ang.getConsEffect (); }
	public IAngWhileCondition getWhileCond () { return ang.getWhileCond (); }
	public boolean hasWhileCond () { return ang.hasWhileCond (); }

	public TextCard<?> getCard () { return card; }
	public AgotPlayer getCardController () { return card.getController (); }
	private TextCard<?> card;
	
	public ConsAbility (AngConsAbility ang, TextCard<?> card) {
		super ();
		this.ang = ang;
		this.card = card;
	} // ConsAbility
	
} // ConsAbility
