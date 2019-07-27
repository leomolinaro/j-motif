package com.motif.agot.test.list.coreset;

import com.motif.agot.ang.enums.AngFaction;
import com.motif.agot.ang.sets.AgotCardSeed;
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
		assertEqual(baratheon.power(), 0);
		assertEqual(targaryen.power(), 0);
		endChallengesPhase();
		leo.reaction(aFeastForCrows);
		endDominancePhase();
		assertEqual(baratheon.power(), 3);
		assertEqual(targaryen.power(), 0);
	}

	@Override
	protected AgotGame init() {
		AgotGame game = new AgotGame();
		TextCard<?>[] c;

		var leo = game.initPlayer(new AgotPlayer("leo", "Leo", this.testUser));
		var fede = game.initPlayer(new AgotPlayer("fede", "Fede", this.testUser));
		this.leo = new TPlayer(leo, this);
		this.fede = new TPlayer(fede, this);

		targaryen = game.initFaction(fede, AngFaction.TARGARYEN);
		c = game.initCard(fede, AgotCardSeed.A_NOBLE_CAUSE_Core, 7);
		aNobleCause = (PlotCard) c[0];
		c = game.initCard(fede, AgotCardSeed.TARGARYEN_LOYALIST_Core, 9);
		targaryenLoyalist = (CharacterCard) c[0];

		baratheon = game.initFaction(leo, AngFaction.BARATHEON);
		c = game.initCard(leo, AgotCardSeed.A_FEAST_FOR_CROWS_Core, 7);
		aFeastForCrows = (PlotCard) c[0];
		c = game.initCard(leo, AgotCardSeed.BASTARD_IN_HIDING_Core, 9);
		bastardInHiding = (CharacterCard) c[0];

		return game;
	}

}
