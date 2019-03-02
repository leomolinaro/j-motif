package motif.brit.endpoint;

import java.util.ArrayList;

import com.google.gson.annotations.Expose;

import lombok.RequiredArgsConstructor;
import motif.brit.ang.enums.AngPhase;
import motif.brit.endpoint.BritReduxAction.ActionPayload;
import motif.brit.logic.flow.BritRequest;
import motif.brit.state.BritArea;
import motif.brit.state.BritBattle;
import motif.brit.state.BritGame;
import motif.brit.state.BritGameLog;
import motif.brit.state.BritNation;
import motif.brit.state.BritUnit;

public class BritReduxActionList {

	public static final String ADD_LOG = "[Brit] Add Log";
	public static final String INIT_STATE = "[Brit] Init State";
	public static final String REQUEST = "[Brit] Request";
	public static final String SET_GAME_STARTED = "[Brit] Set Game Started";
	public static final String SET_PHASE = "[Brit] Set Phase";
	public static final String UPDATE_AREA = "[Brit] Update Area";
	public static final String UPDATE_BATTLE = "[Brit] Update Battle";
	public static final String UPDATE_NATION = "[Brit] Update Nation";
	public static final String UPDATE_UNIT = "[Brit] Update Unit";
	
	@Expose private ArrayList<BritReduxAction> actions = new ArrayList<BritReduxAction> ();
	
	public void addLog(BritGameLog.MotifGameLogRow logRow) { actions.add(new BritReduxAction(ADD_LOG, new AddLogData(logRow))); }
	public void initState(BritGame game, BritContext context, BritRequest<?> request) { actions.add(new BritReduxAction(INIT_STATE, new InitStateData(game, context, request))); }
	public void request(BritRequest<?> request) { actions.add(new BritReduxAction(REQUEST, new RequestData(request))); }
	public void setPhase(String round, String nationId, AngPhase phase) { actions.add(new BritReduxAction(SET_PHASE, new SetPhaseData(round, nationId, phase))); }
	public void updateNation(BritNation nation) { actions.add(new BritReduxAction(UPDATE_NATION, new UpdateNationData(nation))); }
	public void updateArea(BritArea area) { actions.add(new BritReduxAction(UPDATE_AREA, new UpdateAreaData(area))); }
	public void updateBattle(BritBattle battle) { actions.add(new BritReduxAction(UPDATE_BATTLE, new UpdateBattle(battle))); }
	public void updateUnit(BritUnit unit) { actions.add(new BritReduxAction(UPDATE_UNIT, new UpdateUnitData(unit))); }
	public void setGameStarted(boolean started) { actions.add(new BritReduxAction(SET_GAME_STARTED, new SetGameStarted(started))); }
	
	public void removeLast() {
		actions.remove (actions.size () - 1);
	}
	
	public static class AddLogData extends ActionPayload {
		@Expose private BritGameLog.MotifGameLogRow logRow;
		public AddLogData(BritGameLog.MotifGameLogRow logRow) { this.logRow = logRow; }
	}
	
	public static class InitStateData extends ActionPayload {
		private static class BritState {
			@Expose private BritGame game;
			@Expose private BritContext context;
			@Expose private BritRequest<?> request;
		}
		@Expose private BritState state = new BritState();
		public InitStateData(BritGame game, BritContext context, BritRequest<?> request) {
			state.game = game;
			state.context = context;
			state.request = request;
		}
	}
	
	public static class RequestData extends ActionPayload {
		@Expose public BritRequest<?> request;
		public RequestData(BritRequest<?> request) {
			super ();
			this.request = request;
		}
	}
	
	public static class SetGameStarted extends ActionPayload {
		@Expose private boolean started;
		public SetGameStarted(boolean started) { this.started = started; }
	}
	
	public static class SetPhaseData extends ActionPayload {
		@Expose String round;
		@Expose String nationId;
		@Expose String phase;
		public SetPhaseData(String round, String nationId, AngPhase phase) {
			super();
			this.round = round;
			this.nationId = nationId;
			this.phase = phase == null ? null : phase.getLabel();
		}
	}
	
	public static class UpdateAreaData extends ActionPayload {
		@Expose private BritArea area;
		public UpdateAreaData(BritArea area) { this.area = area; }
	}

	@RequiredArgsConstructor
	public static class UpdateBattle extends ActionPayload {
		@Expose private final BritBattle battle;
	}

	@RequiredArgsConstructor
	public static class UpdateNationData extends ActionPayload {
		@Expose private final BritNation nation;
	}

	@RequiredArgsConstructor
	public static class UpdateUnitData extends ActionPayload {
		@Expose private final BritUnit unit;
	}
	
}
