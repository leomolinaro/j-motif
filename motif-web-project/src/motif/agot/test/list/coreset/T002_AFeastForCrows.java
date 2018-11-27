package motif.agot.test.list.coreset;

import motif.agot.ang.enums.AngFaction;
import motif.agot.ang.sets.CoreSet;
import motif.agot.state.AgotGame;
import motif.agot.state.AgotPlayer;
import motif.agot.state.cards.CharacterCard;
import motif.agot.state.cards.FactionCard;
import motif.agot.state.cards.PlotCard;
import motif.agot.state.cards.TextCard;
import motif.agot.test.Test;

public class T002_AFeastForCrows extends Test {

	private FactionCard targaryen;
	private FactionCard baratheon;
	private PlotCard aNobleCause;
	private CharacterCard targaryenLoyalist;
	private PlotCard aFeastForCrows;
	private CharacterCard bastardInHiding;
	private AgotPlayer leo;
	private AgotPlayer fede;
	
	@Override
	public void execute () throws AgotTestException {
		selectPlot (aFeastForCrows, leo);
		selectPlot (aNobleCause, fede);
		selectFirstPlayer (leo, leo);
		endPlotPhase ();
		endDrawPhase ();
		marshall (bastardInHiding, leo);
		marshall (targaryenLoyalist, fede);
		endMarshallingPhase ();
		assertEqual (baratheon.getPower (), 0);
		assertEqual (targaryen.getPower (), 0);
		endChallengesPhase ();
		reaction (aFeastForCrows, leo);
		endDominancePhase ();
		assertEqual (baratheon.getPower (), 3);
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
		c = game.initCard (fede, CoreSet.TARGARYEN_LOYALIST, 9);
		targaryenLoyalist = (CharacterCard) c[0];

		baratheon = game.initFaction (leo, AngFaction.BARATHEON);
		c = game.initCard (leo, CoreSet.A_FEAST_FOR_CROWS, 7);
		aFeastForCrows = (PlotCard) c[0];
		c = game.initCard (leo, CoreSet.BASTARD_IN_HIDING, 9);
		bastardInHiding = (CharacterCard) c[0];
		
		return game;
	} // init

}
