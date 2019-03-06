package com.motif.agot.ang.text.effects;

import com.motif.agot.ang.text.instants.AngChooseACard;
import com.motif.agot.ang.text.instants.AngDrawNCards;
import com.motif.agot.ang.text.instants.AngGainNGold;
import com.motif.agot.ang.text.instants.AngLastingEffect;
import com.motif.agot.ang.text.instants.AngMovePowersFromAFactionToAFaction;
import com.motif.agot.ang.text.instants.AngPutThatIntoPlayUnderYourControl;
import com.motif.agot.ang.text.instants.AngReduceTheCostOTheNextCardYouMarshallThisPhaseByN;
import com.motif.agot.ang.text.instants.AngReturnThisToYourHand;
import com.motif.agot.ang.text.instants.AngInstants.AngDiscardFromPlayEach;
import com.motif.agot.ang.text.instants.AngInstants.AngDiscardFromPlayThat;
import com.motif.agot.ang.text.instants.AngInstants.AngDiscardNCardsAtRandomFromEachPlayerHand;
import com.motif.agot.ang.text.instants.AngInstants.AngDiscardNPowerFromThat;
import com.motif.agot.ang.text.instants.AngInstants.AngGainNPowerOnThis;
import com.motif.agot.ang.text.instants.AngInstants.AngGainNPowerOnYourFaction;
import com.motif.agot.ang.text.instants.AngInstants.AngKillThat;
import com.motif.agot.ang.text.instants.AngInstants.AngKneelAttached;
import com.motif.agot.ang.text.instants.AngInstants.AngKneelEach;
import com.motif.agot.ang.text.instants.AngInstants.AngKneelThat;
import com.motif.agot.ang.text.instants.AngInstants.AngKneelThis;
import com.motif.agot.ang.text.instants.AngInstants.AngPlaceOneTokenOnThis;
import com.motif.agot.ang.text.instants.AngInstants.AngSaveAttached;
import com.motif.agot.ang.text.instants.AngInstants.AngSaveThat;
import com.motif.agot.ang.text.instants.AngInstants.AngSaveThis;
import com.motif.agot.ang.text.instants.AngInstants.AngShuffleThatBackIntoYourDeck;
import com.motif.agot.ang.text.instants.AngInstants.AngStandAttached;
import com.motif.agot.ang.text.instants.AngInstants.AngStandEach;
import com.motif.agot.ang.text.instants.AngInstants.AngStandThat;
import com.motif.agot.ang.text.instants.AngInstants.AngStandThis;
import com.motif.agot.ang.text.instants.AngInstants.AngTakeControlOfThat;

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
