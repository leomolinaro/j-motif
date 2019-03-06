package com.motif.brit.logic.play.battlesandretreats;

import java.util.ArrayList;
import java.util.stream.Collectors;

import com.motif.brit.ang.enums.AngPhase;
import com.motif.brit.ang.enums.BritText;
import com.motif.brit.endpoint.BritContext;
import com.motif.brit.logic.flow.IBritFlowProcess;
import com.motif.brit.logic.flow.IBritFlowStep;
import com.motif.brit.logic.play.ABritPhase;
import com.motif.brit.logic.play.battlesandretreats.BritBattleAndRetreats.IBritAfterBattleAndRetreats;
import com.motif.brit.logic.requests.BritSelectAreaRequest;
import com.motif.brit.logic.requests.BritSelectAreaRequest.IBritAfterSelectArea;
import com.motif.brit.state.BritGame;
import com.motif.brit.state.BritLandArea;
import com.motif.brit.state.BritNation;

import lombok.Getter;

public class BritPhaseBattlesAndRetreats extends ABritPhase implements 
		IBritAfterSelectArea<BritLandArea>,
		IBritAfterBattleAndRetreats {
	
	public BritPhaseBattlesAndRetreats(AngPhase phase, BritNation nation, BritGame game, IBritFlowWithBattlesAndRetreats parent) {
		super(phase, nation, game);
		this.parent = parent;
	}

	public interface IBritFlowWithBattlesAndRetreats extends IBritFlowProcess { public IBritFlowStep after(BritPhaseBattlesAndRetreats battlesAndRetreats, BritContext context); }
	@Getter private final IBritFlowWithBattlesAndRetreats parent;
	@Override public IBritFlowStep next(BritContext context) { return this.parent.after(this, context); }

	@Override
	public IBritFlowStep start(BritContext context) {
		return selectBattle(context);
	}
	
	private IBritFlowStep selectBattle(BritContext context) {
		// Compute all the battles to be resolved.
		var battleLands = this.nation.inPlayUnits()
		.map(unit -> unit.getArea())
		.filter(area -> area.isLand())
		.map(area -> (BritLandArea) area)
		.filter(land -> land.isControlled() && !land.isControlledBy(this.nation))
		.collect(Collectors.toSet());
		if (battleLands.isEmpty()) {
			// No battle to fight. The phase ends.
			return null;
		} else {
			// Request the battle to resolve.
			return new BritSelectAreaRequest<BritLandArea>(
					new ArrayList<BritLandArea>(battleLands),
					BritText.request().selectAreaToResolveBattle(this.player),
					this.player,
					false,
					this
			);
		}
	}
	
	@Override
	public IBritFlowStep after(BritSelectAreaRequest<BritLandArea> selectArea, BritContext context) {
		return new BritBattleAndRetreats(
				selectArea.getArea(),
				this.nation,
				this.game,
				this
		);
	}
	
	@Override
	public IBritFlowStep after(BritBattleAndRetreats battleAndRetreats, BritContext context) {
		this.game.endBattle(context);
		return selectBattle(context);
	}

}
