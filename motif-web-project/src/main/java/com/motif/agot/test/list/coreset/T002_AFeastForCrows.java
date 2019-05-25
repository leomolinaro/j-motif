package com.motif.agot.test.list.coreset;

import com.motif.agot.ang.enums.AngFaction;
import com.motif.agot.ang.sets.CoreSet;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.AgotPlayer;
import com.motif.agot.state.cards.CharacterCard;
import com.motif.agot.state.cards.FactionCard;
import com.motif.agot.state.cards.PlotCard;
import com.motif.agot.state.cards.TextCard;
import com.motif.agot.test.TPlayer;
import com.motif.agot.test.Test;

public class T002_AFeastForCrows extends Test {

	private FactionCard targaryen;
	private FactionCard baratheon;
	private PlotCard aNobleCause;
	private CharacterCard targaryenLoyalist;
	private PlotCard aFeastForCrows;
	private CharacterCard bastardInHiding;
	private TPlayer leo;
	private TPlayer fede;
	
	@Override
	public void execute() throws AgotTestException {
		leo.selectPlot(aFeastForCrows);
		fede.selectPlot(aNobleCause);
		leo.selectFirstPlayer(leo);
		endPlotPhase();
		endDrawPhase();
		leo.marshall(bastardInHiding);
		fede.marshall(targaryenLoyalist);
		endMarshallingPhase();
		assertEqual(baratheon.getPower(), 0);
		assertEqual(targaryen.getPower(), 0);
		endChallengesPhase();
		leo.reaction(aFeastForCrows);
		endDominancePhase();
		assertEqual(baratheon.getPower(), 3);
		assertEqual(targaryen.getPower(), 0);
	}

	@Override
	protected AgotGame init() {
		AgotGame game = new AgotGame();
		TextCard<?>[] c;

		var leo = game.initPlayer(new AgotPlayer("leo", "Leo"));
		var fede = game.initPlayer(new AgotPlayer("fede", "Fede"));
		this.leo = new TPlayer(leo, this);
		this.fede = new TPlayer(fede, this);

		targaryen = game.initFaction(fede, AngFaction.TARGARYEN);
		c = game.initCard(fede, CoreSet.A_NOBLE_CAUSE, 7);
		aNobleCause = (PlotCard) c[0];
		c = game.initCard(fede, CoreSet.TARGARYEN_LOYALIST, 9);
		targaryenLoyalist = (CharacterCard) c[0];

		baratheon = game.initFaction(leo, AngFaction.BARATHEON);
		c = game.initCard(leo, CoreSet.A_FEAST_FOR_CROWS, 7);
		aFeastForCrows = (PlotCard) c[0];
		c = game.initCard(leo, CoreSet.BASTARD_IN_HIDING, 9);
		bastardInHiding = (CharacterCard) c[0];

		return game;
	}

}
