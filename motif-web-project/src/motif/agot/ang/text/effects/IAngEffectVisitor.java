package motif.agot.ang.text.effects;

import motif.agot.ang.text.instants.AngChooseACard;
import motif.agot.ang.text.instants.AngDrawNCards;
import motif.agot.ang.text.instants.AngGainNGold;
import motif.agot.ang.text.instants.AngInstants.AngDiscardFromPlayEach;
import motif.agot.ang.text.instants.AngInstants.AngDiscardFromPlayThat;
import motif.agot.ang.text.instants.AngInstants.AngDiscardNCardsAtRandomFromEachPlayerHand;
import motif.agot.ang.text.instants.AngInstants.AngDiscardNPowerFromThat;
import motif.agot.ang.text.instants.AngInstants.AngGainNPowerOnThis;
import motif.agot.ang.text.instants.AngInstants.AngGainNPowerOnYourFaction;
import motif.agot.ang.text.instants.AngInstants.AngKillThat;
import motif.agot.ang.text.instants.AngInstants.AngKneelAttached;
import motif.agot.ang.text.instants.AngInstants.AngKneelEach;
import motif.agot.ang.text.instants.AngInstants.AngKneelThat;
import motif.agot.ang.text.instants.AngInstants.AngKneelThis;
import motif.agot.ang.text.instants.AngInstants.AngPlaceOneTokenOnThis;
import motif.agot.ang.text.instants.AngInstants.AngSaveAttached;
import motif.agot.ang.text.instants.AngInstants.AngSaveThat;
import motif.agot.ang.text.instants.AngInstants.AngSaveThis;
import motif.agot.ang.text.instants.AngInstants.AngShuffleThatBackIntoYourDeck;
import motif.agot.ang.text.instants.AngInstants.AngStandAttached;
import motif.agot.ang.text.instants.AngInstants.AngStandEach;
import motif.agot.ang.text.instants.AngInstants.AngStandThat;
import motif.agot.ang.text.instants.AngInstants.AngStandThis;
import motif.agot.ang.text.instants.AngInstants.AngTakeControlOfThat;
import motif.agot.ang.text.instants.AngLastingEffect;
import motif.agot.ang.text.instants.AngMovePowersFromAFactionToAFaction;
import motif.agot.ang.text.instants.AngPutThatIntoPlayUnderYourControl;
import motif.agot.ang.text.instants.AngReduceTheCostOTheNextCardYouMarshallThisPhaseByN;
import motif.agot.ang.text.instants.AngReturnThisToYourHand;

public interface IAngEffectVisitor {

	public boolean visit (AngChooseACard effect);
	public boolean visit (AngGainNGold effect);
	public boolean visit (AngReduceTheCostOTheNextCardYouMarshallThisPhaseByN effect);
	public boolean visit (AngDrawNCards effect);
	
	public boolean visit (AngStandThis effect);
	public boolean visit (AngStandThat effect);
	public boolean visit (AngStandAttached effect);
	public boolean visit (AngStandEach effect);
	
	public boolean visit (AngKneelThis effect);
	public boolean visit (AngKneelThat effect);
	public boolean visit (AngKneelAttached effect);
	public boolean visit (AngKneelEach effect);
	
	public boolean visit (AngKillThat effect);
	public boolean visit (AngDiscardNPowerFromThat effect);
	
	public boolean visit (AngGainNPowerOnThis effect);
	public boolean visit (AngGainNPowerOnYourFaction effect);

	public boolean visit (AngDiscardFromPlayThat effect);
	public boolean visit (AngDiscardFromPlayEach effect);

	public boolean visit (AngSaveThis effect);
	public boolean visit (AngSaveThat effect);
	public boolean visit (AngSaveAttached effect);

	public boolean visit (AngShuffleThatBackIntoYourDeck effect);
	public boolean visit (AngReturnThisToYourHand effect);
	public boolean visit (AngPutThatIntoPlayUnderYourControl effect);
	public boolean visit (AngLastingEffect effect);
	public boolean visit (AngMovePowersFromAFactionToAFaction effect);
	public boolean visit (AngPlaceOneTokenOnThis effect);
	public boolean visit (AngDiscardNCardsAtRandomFromEachPlayerHand effect);
	public boolean visit (AngTakeControlOfThat effect);

} // IAngEffectVisitor
