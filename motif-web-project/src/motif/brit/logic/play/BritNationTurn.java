package motif.brit.logic.play;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import motif.brit.ang.enums.AngPhase;
import motif.brit.endpoint.BritContext;
import motif.brit.logic.flow.IBritFlowProcess;
import motif.brit.logic.flow.IBritFlowStep;
import motif.brit.logic.play.BritPhaseMovement.IBritFlowWithMovement;
import motif.brit.logic.play.BritPhaseOverpopulation.IBritFlowWithOverpopulation;
import motif.brit.logic.play.BritPhasePopulationIncrease.IBritFlowWithPopulationIncrease;
import motif.brit.logic.play.BritPhaseRaiderWithdrawal.IBritFlowWithRaiderWithdrawal;
import motif.brit.logic.play.battlesandretreats.BritPhaseBattlesAndRetreats;
import motif.brit.logic.play.battlesandretreats.BritPhaseBattlesAndRetreats.IBritFlowWithBattlesAndRetreats;
import motif.brit.state.BritGame;
import motif.brit.state.BritNation;

@RequiredArgsConstructor
public class BritNationTurn implements IBritFlowProcess, 
		IBritFlowWithPopulationIncrease,
		IBritFlowWithMovement,
		IBritFlowWithBattlesAndRetreats,
		IBritFlowWithRaiderWithdrawal,
		IBritFlowWithOverpopulation {
	
	private final BritNation nation;
	private final BritGame game;
	
	public interface IBritAfterNationTurn extends IBritFlowProcess { public IBritFlowStep after(BritNationTurn nationTurn, BritContext context); }
	@Getter private final IBritAfterNationTurn parent;
	@Override public IBritFlowStep next(BritContext context) { return this.parent.after(this, context); }

	public IBritFlowStep start(BritContext context) {
		game.setNationId(nation.getId(), context);
		game.log().nationTurn(nation, context);
		return new BritPhasePopulationIncrease(AngPhase.POPULATION_INCREASE, nation, game, this);
	}
	
	@Override
	public IBritFlowStep after(BritPhasePopulationIncrease phase, BritContext context) {
		return new BritPhaseMovement(AngPhase.MOVEMENT, nation, game, this);
	}
	
	@Override
	public IBritFlowStep after(BritPhaseMovement phase, BritContext context) {
		return new BritPhaseBattlesAndRetreats(AngPhase.BATTLES_AND_RETREATS, nation, game, this);
	}
	
	@Override
	public IBritFlowStep after(BritPhaseBattlesAndRetreats phase, BritContext context) {
		return new BritPhaseRaiderWithdrawal(AngPhase.RAIDER_WITHDRAWAL, nation, game, this);
	}
	
	@Override
	public IBritFlowStep after(BritPhaseRaiderWithdrawal phase, BritContext context) {
		return new BritPhaseOverpopulation(AngPhase.OVERPOPULATION, nation, game, this);
	}

	@Override
	public IBritFlowStep after(BritPhaseOverpopulation phase, BritContext context) {
		nation.clearPaths();
		return null;
	}
	
}
