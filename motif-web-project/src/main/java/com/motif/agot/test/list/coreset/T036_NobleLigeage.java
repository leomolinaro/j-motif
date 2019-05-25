package com.motif.agot.test.list.coreset;

import com.motif.agot.ang.enums.AngFaction;
import com.motif.agot.ang.enums.AngIcon;
import com.motif.agot.ang.sets.CoreSet;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.AgotPlayer;
import com.motif.agot.state.cards.AttachmentCard;
import com.motif.agot.state.cards.CharacterCard;
import com.motif.agot.state.cards.FactionCard;
import com.motif.agot.state.cards.PlotCard;
import com.motif.agot.state.cards.TextCard;
import com.motif.agot.test.TPlayer;
import com.motif.agot.test.Test;

public class T036_NobleLigeage extends Test {

	private FactionCard targaryen;
	private FactionCard baratheon;
	private PlotCard aNobleCause;
	private CharacterCard targaryenLoyalist1;
	private CharacterCard targaryenLoyalist2;
	private PlotCard aFeastForCrows;
	private CharacterCard fieryFollowers;
	private TPlayer leo;
	private TPlayer fede;
	private AttachmentCard nobleLineage;
	
	@Override
	public void execute() throws AgotTestException {
		leo.selectPlot(aFeastForCrows);
		fede.selectPlot(aNobleCause);
		leo.selectFirstPlayer(fede);
		endPlotPhase();
		endDrawPhase();
		fede.marshall(targaryenLoyalist1);
		fede.marshall(targaryenLoyalist2);
		leo.marshall(fieryFollowers);
		leo.attach(nobleLineage, fieryFollowers);
		assertEqual(fieryFollowers.hasIcon(AngIcon.POWER), true);
		endMarshallingPhase();
		fede.initiateChallenge(AngIcon.POWER, leo, targaryenLoyalist1);
		fede.endChallenge();
		assertEqual(targaryen.getPower(), 1);
		leo.initiateChallenge(AngIcon.POWER, fede, fieryFollowers);
		fede.defend(targaryenLoyalist2);
		endChallengesPhase();
		endDominancePhase();
		assertEqual(baratheon.getPower(), 1);
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
		targaryenLoyalist1 = (CharacterCard) c[0];
		targaryenLoyalist2 = (CharacterCard) c[1];

		baratheon = game.initFaction(leo, AngFaction.BARATHEON);
		c = game.initCard(leo, CoreSet.A_FEAST_FOR_CROWS, 7);
		aFeastForCrows = (PlotCard) c[0];
		c = game.initCard(leo, CoreSet.FIERY_FOLLOWERS, 8);
		fieryFollowers = (CharacterCard) c[0];
		nobleLineage = (AttachmentCard) game.initCard(leo, CoreSet.NOBLE_LINEAGE, 1)[0];

		return game;
	}

}
