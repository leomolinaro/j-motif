package motif.agot.state.cards;

import java.util.stream.Stream;

import motif.agot.ang.cards.AngTextCard;
import motif.agot.ang.text.AngAction;
import motif.agot.ang.text.AngConsAbility;
import motif.agot.ang.text.AngInterrupt;
import motif.agot.ang.text.AngReaction;
import motif.agot.state.AgotPlayer;

public abstract class TextCard<A extends AngTextCard> extends Card<A> {

	public TextCard (A ang, AgotPlayer owner) {
		super (ang, owner);
	} // TextCard

	public AngAction getAction () { return ang.getAction (); }
	public boolean hasAction () { return ang.hasAction (); }

	public AngInterrupt getInterrupt () { return ang.getInterrupt (); }
	public boolean hasInterrupt () { return ang.hasInterrupt (); }

	public AngReaction getReaction () { return ang.getReaction (); }
	public boolean hasReaction () { return ang.hasReaction (); }

	public boolean isInteracting () { return controller.hasInteracting (this); }

	public int getGoldModifier () { return ang.getGoldModifier (); }
	public int getReserveModifier () { return ang.getReserveModifier (); }
	public int getInitiativeModifier () { return ang.getInitiativeModifier (); }

	public boolean hasConsAbilities () { return ang.hasConsAbilities (); }
	public Stream<AngConsAbility> consAbilities () { return ang.consAbilities (); }

} // TextCard
