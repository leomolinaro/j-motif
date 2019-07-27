package com.motif.agot.test.list.coreset;

import com.motif.agot.ang.enums.AngFaction;
import com.motif.agot.ang.enums.AngIcon;
import com.motif.agot.ang.sets.AgotCardSeed;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.AgotPlayer;
import com.motif.agot.state.cards.CharacterCard;
import com.motif.agot.state.cards.FactionCard;
import com.motif.agot.state.cards.PlotCard;
import com.motif.agot.test.TPlayer;
import com.motif.agot.test.Test;

///**
// *  Neutral.
// *  Plot. Income: 4. Initiative: 9. Claim: 1. Reserve: 6. Plot deck limit: 2.
// *  Noble.
// *  
// *  Reaction: After you win a POWER challenge, move 1 power from the losing opponent's faction card to your own.
// *  
// *   Smirtouille
// *  Core Set #1.
// */

/**
 *  <h1>Neutral</h1><h1>Plot</h1>
 *  <ul>
 *  	<li>Income: 4</li>
 *  	<li>Initiative: 9</li>
 *  	<li>Claim: 1</li>
 *  	<li>Reserve: 6</li>
 *  	<li>Plot deck limit: 2</li>
 *  </ul>
 *  <b><i>Noble</i></b><br>
 *  
 *  <b>Reaction:</b> After you win a POWER challenge, move 1 power from the losing opponent's faction card to your own.
 *  
 *  <i>Smirtouille</i><br>
 *  <i>Core Set #1</i>
 */
public class T001_AClashOfKings extends Test {

	private FactionCard targaryen;
	private FactionCard baratheon;
	private PlotCard aNobleCause;
	private CharacterCard targaryenLoyalist1;
	private CharacterCard targaryenLoyalist2;
	private CharacterCard handmaiden;
	private PlotCard aClashOfKings;
	private CharacterCard bastardInHiding;
	private TPlayer leo;
	private TPlayer fede;
	
	@Override
	public void execute() throws AgotTestException {
		leo.selectPlot(aClashOfKings);
		fede.selectPlot(aNobleCause);
		leo.selectFirstPlayer(fede);
		endPlotPhase();
		endDrawPhase();
		fede.marshall(targaryenLoyalist1);
		fede.marshall(targaryenLoyalist2);
		fede.marshall(handmaiden);
		leo.marshall(bastardInHiding);
		endMarshallingPhase();
		fede.initiateChallenge(AngIcon.INTRIGUE, leo, handmaiden);
		fede.endChallenge();
		assertEqual(targaryen.power(), 1);
		fede.initiateChallenge(AngIcon.POWER, leo, targaryenLoyalist1);
		fede.endChallenge();
		assertEqual(targaryen.power(), 2);
		leo.initiateChallenge(AngIcon.POWER, fede, bastardInHiding);
		fede.defend(targaryenLoyalist2);
		leo.reaction(aClashOfKings);
		fede.endChallenge();
		assertEqual(baratheon.power(), 2);
		assertEqual(targaryen.power(), 0);
	}

	@Override
	protected AgotGame init () {
		var game = new AgotGame();

		var leo = game.initPlayer(new AgotPlayer("leo", "Leo", this.testUser));
		var fede = game.initPlayer(new AgotPlayer("fede", "Fede", this.testUser));
		this.leo = new TPlayer(leo, this);
		this.fede = new TPlayer(fede, this);

		targaryen = game.initFaction(fede, AngFaction.TARGARYEN);
		var c = game.initCard(fede, AgotCardSeed.A_NOBLE_CAUSE_Core, 7);
		aNobleCause = (PlotCard) c[0];
		c = game.initCard(fede, AgotCardSeed.TARGARYEN_LOYALIST_Core, 5);
		targaryenLoyalist1 = (CharacterCard) c[0];
		targaryenLoyalist2 = (CharacterCard) c[1];
		c = game.initCard(fede, AgotCardSeed.HANDMAIDEN_Core, 4);
		handmaiden = (CharacterCard) c[0];

		baratheon = game.initFaction(leo, AngFaction.BARATHEON);
		c = game.initCard(leo, AgotCardSeed.A_CLASH_OF_KINGS_Core, 7);
		aClashOfKings = (PlotCard) c[0];
		c = game.initCard(leo, AgotCardSeed.BASTARD_IN_HIDING_Core, 9);
		bastardInHiding = (CharacterCard) c[0];

		return game;
	}

}
