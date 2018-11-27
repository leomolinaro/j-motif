package motif.agot.test.list.coreset;

import motif.agot.ang.enums.AngFaction;
import motif.agot.ang.enums.AngIcon;
import motif.agot.ang.sets.CoreSet;
import motif.agot.state.AgotGame;
import motif.agot.state.AgotPlayer;
import motif.agot.state.cards.CharacterCard;
import motif.agot.state.cards.FactionCard;
import motif.agot.state.cards.PlotCard;
import motif.agot.state.cards.TextCard;
import motif.agot.test.Test;

/**
 *  Neutral.
 *  Plot. Income: 4. Initiative: 9. Claim: 1. Reserve: 6. Plot deck limit: 2.
 *  Noble.
 *  
 *  Reaction: After you win a POWER challenge, move 1 power from the losing opponent's faction card to your own.
 *  
 *   Smirtouille
 *  Core Set #1.
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
	private AgotPlayer leo;
	private AgotPlayer fede;
	
	@Override
	public void execute () throws AgotTestException {
		selectPlot (aClashOfKings, leo);
		selectPlot (aNobleCause, fede);
		selectFirstPlayer (fede, leo);
		endPlotPhase ();
		endDrawPhase ();
		marshall (targaryenLoyalist1, fede);
		marshall (targaryenLoyalist2, fede);
		marshall (handmaiden, fede);
		marshall (bastardInHiding, leo);
		endMarshallingPhase ();
		initiateChallenge (AngIcon.INTRIGUE, fede);
		endChallenge (fede);
		assertEqual (targaryen.getPower (), 1);
		initiateChallenge (AngIcon.POWER, fede);
		attack (targaryenLoyalist1, fede);
		endChallenge (fede);
		assertEqual (targaryen.getPower (), 2);
		initiateChallenge (AngIcon.POWER, leo);
		defend (targaryenLoyalist2, fede);
		reaction (aClashOfKings, leo);
		endChallenge (fede);
		assertEqual (baratheon.getPower (), 2);
		assertEqual (targaryen.getPower (), 0);
	} // execute

	@Override
	protected AgotGame init () {
		AgotGame game = new AgotGame ();
		TextCard<?>[] c;

		leo = game.initPlayer (new AgotPlayer ("leo", "Leo"));
		fede = game.initPlayer (new AgotPlayer ("fede", "Fede"));
		
		targaryen = game.initFaction (fede, AngFaction.TARGARYEN);
		c = game.initCard (fede, CoreSet.A_NOBLE_CAUSE, 7);
		aNobleCause = (PlotCard) c[0];
		c = game.initCard (fede, CoreSet.TARGARYEN_LOYALIST, 5);
		targaryenLoyalist1 = (CharacterCard) c[0];
		targaryenLoyalist2 = (CharacterCard) c[1];
		c = game.initCard (fede, CoreSet.HANDMAIDEN, 4);
		handmaiden = (CharacterCard) c[0];

		baratheon = game.initFaction (leo, AngFaction.BARATHEON);
		c = game.initCard (leo, CoreSet.A_CLASH_OF_KINGS, 7);
		aClashOfKings = (PlotCard) c[0];
		c = game.initCard (leo, CoreSet.BASTARD_IN_HIDING, 9);
		bastardInHiding = (CharacterCard) c[0];
		
		return game;
	} // init

}
