package motif.brit.flow;

import motif.brit.endpoint.BritContext;
import motif.brit.endpoint.BritEndpoint.BritGameIO;
import motif.brit.logic.battlesandretreats.BritPhaseBattlesAndRetreats;
import motif.brit.logic.battlesandretreats.BritResolveAttackingDie;
import motif.brit.logic.battlesandretreats.BritResolveDefendingDie;
import motif.brit.logic.battlesandretreats.BritPhaseBattlesAndRetreats.BritAttackerSelectRetreatIO;
import motif.brit.logic.battlesandretreats.BritPhaseBattlesAndRetreats.BritDefenderSelectRetreatIO;
import motif.brit.logic.battlesandretreats.BritPhaseBattlesAndRetreats.BritResolveAttackingDieIO;
import motif.brit.logic.battlesandretreats.BritPhaseBattlesAndRetreats.BritResolveDefendingDieIO;
import motif.brit.logic.battlesandretreats.BritPhaseBattlesAndRetreats.BritSelectAreaToResolveBattleRequestIO;
import motif.brit.logic.battlesandretreats.BritPhaseBattlesAndRetreats.BritThrowAttackingDiceRequestIO;
import motif.brit.logic.battlesandretreats.BritPhaseBattlesAndRetreats.BritThrowDefendingDiceRequestIO;
import motif.brit.logic.battlesandretreats.BritResolveAttackingDie.BritSelectAttackingUnitToEliminateRequestIO;
import motif.brit.logic.battlesandretreats.BritResolveDefendingDie.BritSelectDefendingUnitToEliminateRequestIO;
import motif.brit.logic.game.BritPlay;
import motif.brit.logic.game.BritPlay.BritRoundIO;
import motif.brit.logic.movement.BritPhaseMovement;
import motif.brit.logic.movement.BritPhaseMovement.BritSelectAreaToMoveUnitRequestIO;
import motif.brit.logic.movement.BritPhaseMovement.BritSelectUnitToMoveRequestIO;
import motif.brit.logic.nationTurn.BritNationTurn;
import motif.brit.logic.nationTurn.BritNationTurn.BritPhaseBattlesAndRetreatsIO;
import motif.brit.logic.nationTurn.BritNationTurn.BritPhaseMovementIO;
import motif.brit.logic.nationTurn.BritNationTurn.BritPhaseOverpopulationIO;
import motif.brit.logic.nationTurn.BritNationTurn.BritPhasePopulationIncreaseIO;
import motif.brit.logic.nationTurn.BritNationTurn.BritPhaseRaiderWithdrawalIO;
import motif.brit.logic.populationincrease.BritPhasePopulationIncrease;
import motif.brit.logic.populationincrease.BritPhasePopulationIncrease.BritSelectAreaToPlaceUnitRequestIO;
import motif.brit.logic.requests.BritSelectUnitAreaSvgRequests;
import motif.brit.logic.round.BritRound;
import motif.brit.logic.round.BritRound.BritNationTurnIO;
import motif.brit.state.BritArea;
import motif.brit.state.BritUnit;

public class BritIONexter implements IBritIOVisitor {

	public static IBritIO next(IBritIO IO, BritContext context) {
		BritIONexter nexter = new BritIONexter(context);
		IO.accept(nexter);
		return nexter.next;		
	}
	
	private BritContext context;
	private IBritIO next;
	
	private BritIONexter(BritContext context) {
		this.context = context;
	}
	
	@Override
	public void visit(BritSelectAreaToMoveUnitRequestIO IO) {
		next = new BritPhaseMovement().afterBritSelectAreaToMoveUnitRequest(IO.getArea(), IO.getSvgX(), IO.getSvgY(), IO.getParent(), context);
	}

	@Override
	public void visit(BritNationTurnIO IO) {
		next = new BritRound().afterBritNationTurn(IO, context);
	}

	@Override
	public void visit(BritRoundIO IO) {
		next = new BritPlay().next(IO, context);
	}

	@Override
	public <U extends BritUnit, A extends BritArea> void visit(
	        BritSelectUnitAreaSvgRequests<U, A>.BritSelectUnitRequestIO IO) {
		next = new BritSelectUnitAreaSvgRequests<U, A>().afterUnitIsSelected(IO.getUnit(), IO.getParent(), context);
	}

	@Override
	public <U extends BritUnit, A extends BritArea> void visit(
	        BritSelectUnitAreaSvgRequests<U, A>.BritSelectAreaSvgRequestIO IO) {
		next = new BritSelectUnitAreaSvgRequests<U,A>().afterAreaIsSelected(IO.getArea(), IO.getSvgX(), IO.getSvgY(), IO.getParent(), context);
	}

	@Override
	public void visit(BritPhasePopulationIncreaseIO IO) {
		next = new BritNationTurn().next(IO, context);
	}

	@Override
	public void visit(BritPhaseMovementIO IO) {
		next = new BritNationTurn().next(IO, context);
	}

	@Override
	public void visit(BritPhaseBattlesAndRetreatsIO IO) {
		next = new BritNationTurn().next(IO, context);
	}

	@Override
	public void visit(BritPhaseRaiderWithdrawalIO IO) {
		next = new BritNationTurn().next(IO, context);
	}

	@Override
	public void visit(BritPhaseOverpopulationIO IO) {
		next = new BritNationTurn().next(IO, IO.getParent(), context);
	}

	@Override
	public void visit(BritSelectAreaToResolveBattleRequestIO IO) {
		next = new BritPhaseBattlesAndRetreats().afterBattleAreaHasBeenSelected(IO.getArea(), IO.getParent(), context);
	}

	@Override
	public void visit(BritThrowAttackingDiceRequestIO IO) {
		next = new BritPhaseBattlesAndRetreats().afterAttackingDiceHaveBeenThrown(IO.getParent(), context);
	}

	@Override
	public void visit(BritThrowDefendingDiceRequestIO IO) {
		next = new BritPhaseBattlesAndRetreats().afterDefendingDiceHaveBeenThrown(IO.getParent(), context);
	}

	@Override
	public void visit(BritDefenderSelectRetreatIO IO) {
		next = new BritPhaseBattlesAndRetreats().afterDefenderHasSelectedRetreat(IO.getUnit(), IO.getArea(), IO.getSvgX(), IO.getSvgY(), IO.getParent(), context);
	}

	@Override
	public void visit(BritAttackerSelectRetreatIO IO) {
		next = new BritPhaseBattlesAndRetreats().afterAttackerHasSelectedRetreat(IO.getUnit(), IO.getArea(), IO.getSvgX(), IO.getSvgY(), IO.getParent(), context);
	}

	@Override
	public void visit(BritResolveDefendingDieIO IO) {
		next = new BritPhaseBattlesAndRetreats().afterDefendingDieHasBeenResolved(IO.getParent(), context);
	}

	@Override
	public void visit(BritResolveAttackingDieIO IO) {
		next = new BritPhaseBattlesAndRetreats().afterAttackingDieHasBeenResolved(IO.getParent(), context);
	}

	@Override
	public void visit(BritSelectAttackingUnitToEliminateRequestIO IO) {
		next = new BritResolveAttackingDie().next(IO, IO.getParent(), context);
	}

	@Override
	public void visit(BritSelectDefendingUnitToEliminateRequestIO IO) {
		next = new BritResolveDefendingDie().next(IO, IO.getParent(), context);
	}

	@Override
	public void visit(BritSelectUnitToMoveRequestIO IO) {
		next = new BritPhaseMovement().afterSelectUnitToMoveRequest(IO.getParent(), context);
	}

	@Override
	public void visit(BritSelectAreaToPlaceUnitRequestIO IO) {
		next = new BritPhasePopulationIncrease().next(IO, context);
	}

	@Override
	public void visit(BritGameIO IO) {
		next = null;
	}

}
