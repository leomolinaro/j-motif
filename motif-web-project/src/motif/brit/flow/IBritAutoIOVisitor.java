package motif.brit.flow;

import motif.brit.logic.battlesandretreats.BritPhaseBattlesAndRetreats.ABritPhaseBattlesAndRetreatsIO;
import motif.brit.logic.battlesandretreats.BritResolveAttackingDie.ABritResolveAttackingDieIO;
import motif.brit.logic.battlesandretreats.BritResolveDefendingDie.ABritResolveDefendingDieIO;
import motif.brit.logic.game.ABritPlayIO;
import motif.brit.logic.movement.BritPhaseMovement.ABritPhaseMovementIO;
import motif.brit.logic.nationTurn.BritNationTurn.ABritNationTurnIO;
import motif.brit.logic.phase.BritPhaseOverpopulation.ABritPhaseOverpopulationIO;
import motif.brit.logic.phase.BritPhaseRaiderWithdrawal.ABritPhaseRaiderWithdrawalIO;
import motif.brit.logic.populationincrease.BritPhasePopulationIncrease.ABritPhasePopulationIncreaseIO;
import motif.brit.logic.requests.BritSelectUnitAreaSvgRequests.ABritSelectUnitAreaSvgRequestsIO;
import motif.brit.logic.round.BritRound.ABritRoundIO;
import motif.brit.state.BritArea;
import motif.brit.state.BritUnit;

public interface IBritAutoIOVisitor {

	public void visit(ABritPhaseBattlesAndRetreatsIO aBritPhaseBattlesAndRetreatsIO);

	public void visit(ABritResolveAttackingDieIO aBritResolveAttackingDieIO);

	public void visit(ABritResolveDefendingDieIO aBritResolveDefendingDieIO);

	public <U extends BritUnit, A extends BritArea> void visit(ABritSelectUnitAreaSvgRequestsIO<U, A> aBritSelectUnitAreaSvgRequestsIO);

	public void visit(ABritPhaseMovementIO aBritPhaseMovementIO);

	public void visit(ABritNationTurnIO aBritNationTurnIO);

	public void visit(ABritPhaseRaiderWithdrawalIO aBritPhaseRaiderWithdrawalIO);

	public void visit(ABritPhaseOverpopulationIO aBritPhaseOverpopulationIO);

	public void visit(ABritPlayIO aBritPlayIO);

	public void visit(ABritRoundIO aBritRoundIO);

	public void visit(ABritPhasePopulationIncreaseIO aBritPhasePopulationIncreaseIO);

}
