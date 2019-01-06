package motif.brit.flow;

import motif.brit.endpoint.BritContext;
import motif.brit.logic.battlesandretreats.BritPhaseBattlesAndRetreats;
import motif.brit.logic.battlesandretreats.BritResolveAttackingDie;
import motif.brit.logic.battlesandretreats.BritResolveDefendingDie;
import motif.brit.logic.battlesandretreats.BritPhaseBattlesAndRetreats.ABritPhaseBattlesAndRetreatsIO;
import motif.brit.logic.battlesandretreats.BritResolveAttackingDie.ABritResolveAttackingDieIO;
import motif.brit.logic.battlesandretreats.BritResolveDefendingDie.ABritResolveDefendingDieIO;
import motif.brit.logic.game.ABritPlayIO;
import motif.brit.logic.game.BritPlay;
import motif.brit.logic.movement.BritPhaseMovement;
import motif.brit.logic.movement.BritPhaseMovement.ABritPhaseMovementIO;
import motif.brit.logic.nationTurn.BritNationTurn;
import motif.brit.logic.nationTurn.BritNationTurn.ABritNationTurnIO;
import motif.brit.logic.phase.BritPhaseOverpopulation;
import motif.brit.logic.phase.BritPhaseRaiderWithdrawal;
import motif.brit.logic.phase.BritPhaseOverpopulation.ABritPhaseOverpopulationIO;
import motif.brit.logic.phase.BritPhaseRaiderWithdrawal.ABritPhaseRaiderWithdrawalIO;
import motif.brit.logic.populationincrease.BritPhasePopulationIncrease;
import motif.brit.logic.populationincrease.BritPhasePopulationIncrease.ABritPhasePopulationIncreaseIO;
import motif.brit.logic.requests.BritSelectUnitAreaSvgRequests;
import motif.brit.logic.requests.BritSelectUnitAreaSvgRequests.ABritSelectUnitAreaSvgRequestsIO;
import motif.brit.logic.round.BritRound;
import motif.brit.logic.round.BritRound.ABritRoundIO;
import motif.brit.state.BritArea;
import motif.brit.state.BritUnit;

public class BritAutoIOStarter implements IBritAutoIOVisitor {

	public static IBritIO start(IBritAutoIO IO, BritContext context) {
		BritAutoIOStarter starter = new BritAutoIOStarter(context);
		IO.accept(starter);
		return starter.next;		
	}
	
	private BritContext context;
	private IBritIO next;
	
	private BritAutoIOStarter(BritContext context) {
		this.context = context;
	}
	
	@Override public void visit(ABritPhaseBattlesAndRetreatsIO IO) { next = new BritPhaseBattlesAndRetreats().start(IO, context); }
	@Override public void visit(ABritResolveAttackingDieIO IO) { next = new BritResolveAttackingDie().start(IO, context); }
	@Override public void visit(ABritResolveDefendingDieIO IO) { next = new BritResolveDefendingDie().start(IO, context); }
	@Override public <U extends BritUnit, A extends BritArea> void visit(ABritSelectUnitAreaSvgRequestsIO<U, A> IO) { next = new BritSelectUnitAreaSvgRequests<U, A>().start(IO, context); }
	@Override public void visit(ABritPhaseMovementIO IO) { next = new BritPhaseMovement().start(IO, context); }
	@Override public void visit(ABritNationTurnIO IO) { next = new BritNationTurn().start(IO, context); }
	@Override public void visit(ABritPhaseRaiderWithdrawalIO IO) { next = new BritPhaseRaiderWithdrawal().start(IO, context); }
	@Override public void visit(ABritPhaseOverpopulationIO IO) { next = new BritPhaseOverpopulation().start(IO, context); }
	@Override public void visit(ABritPlayIO IO) { next = new BritPlay().start(IO, context); }
	@Override public void visit(ABritRoundIO IO) { next = new BritRound().start(IO, context); }
	@Override public void visit(ABritPhasePopulationIncreaseIO IO) { next = new BritPhasePopulationIncrease().start(IO, context); }

}
