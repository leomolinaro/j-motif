package motif.brit.flow;

import motif.brit.endpoint.BritEndpoint.BritGameIO;
import motif.brit.logic.battlesandretreats.BritPhaseBattlesAndRetreats.BritAttackerSelectRetreatIO;
import motif.brit.logic.battlesandretreats.BritPhaseBattlesAndRetreats.BritDefenderSelectRetreatIO;
import motif.brit.logic.battlesandretreats.BritPhaseBattlesAndRetreats.BritResolveAttackingDieIO;
import motif.brit.logic.battlesandretreats.BritPhaseBattlesAndRetreats.BritResolveDefendingDieIO;
import motif.brit.logic.battlesandretreats.BritPhaseBattlesAndRetreats.BritSelectAreaToResolveBattleRequestIO;
import motif.brit.logic.battlesandretreats.BritPhaseBattlesAndRetreats.BritThrowAttackingDiceRequestIO;
import motif.brit.logic.battlesandretreats.BritPhaseBattlesAndRetreats.BritThrowDefendingDiceRequestIO;
import motif.brit.logic.battlesandretreats.BritResolveAttackingDie.BritSelectAttackingUnitToEliminateRequestIO;
import motif.brit.logic.battlesandretreats.BritResolveDefendingDie.BritSelectDefendingUnitToEliminateRequestIO;
import motif.brit.logic.game.BritPlay.BritRoundIO;
import motif.brit.logic.movement.BritPhaseMovement.BritSelectAreaToMoveUnitRequestIO;
import motif.brit.logic.movement.BritPhaseMovement.BritSelectUnitToMoveRequestIO;
import motif.brit.logic.nationTurn.BritNationTurn.BritPhaseBattlesAndRetreatsIO;
import motif.brit.logic.nationTurn.BritNationTurn.BritPhaseMovementIO;
import motif.brit.logic.nationTurn.BritNationTurn.BritPhaseOverpopulationIO;
import motif.brit.logic.nationTurn.BritNationTurn.BritPhasePopulationIncreaseIO;
import motif.brit.logic.nationTurn.BritNationTurn.BritPhaseRaiderWithdrawalIO;
import motif.brit.logic.populationincrease.BritPhasePopulationIncrease.BritSelectAreaToPlaceUnitRequestIO;
import motif.brit.logic.requests.BritSelectUnitAreaSvgRequests;
import motif.brit.logic.round.BritRound.BritNationTurnIO;
import motif.brit.state.BritArea;
import motif.brit.state.BritUnit;

public interface IBritIOVisitor {

	public void visit(BritSelectAreaToMoveUnitRequestIO IO);
	public void visit(BritNationTurnIO IO);
	public void visit(BritRoundIO IO);
	public <U extends BritUnit, A extends BritArea> void visit(BritSelectUnitAreaSvgRequests<U, A>.BritSelectUnitRequestIO IO);
	public <U extends BritUnit, A extends BritArea> void visit(BritSelectUnitAreaSvgRequests<U, A>.BritSelectAreaSvgRequestIO IO);
	public void visit(BritPhasePopulationIncreaseIO IO);
	public void visit(BritPhaseMovementIO IO);
	public void visit(BritPhaseBattlesAndRetreatsIO IO);
	public void visit(BritPhaseRaiderWithdrawalIO IO);
	public void visit(BritPhaseOverpopulationIO IO);
	public void visit(BritSelectAreaToResolveBattleRequestIO IO);
	public void visit(BritThrowAttackingDiceRequestIO IO);
	public void visit(BritThrowDefendingDiceRequestIO IO);
	public void visit(BritDefenderSelectRetreatIO IO);
	public void visit(BritAttackerSelectRetreatIO IO);
	public void visit(BritResolveDefendingDieIO IO);
	public void visit(BritResolveAttackingDieIO IO);
	public void visit(BritSelectAttackingUnitToEliminateRequestIO IO);
	public void visit(BritSelectDefendingUnitToEliminateRequestIO IO);
	public void visit(BritSelectUnitToMoveRequestIO IO);
	public void visit(BritSelectAreaToPlaceUnitRequestIO IO);
	public void visit(BritGameIO IO);

}
