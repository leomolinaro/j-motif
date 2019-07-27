package com.motif.brit.endpoint;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.motif.brit.ang.enums.AngPhase;
import com.motif.brit.logic.flow.BritRequest;
import com.motif.brit.state.BritArea;
import com.motif.brit.state.BritBattle;
import com.motif.brit.state.BritGame;
import com.motif.brit.state.BritGameLog;
import com.motif.brit.state.BritNation;
import com.motif.brit.state.BritUnit;
import com.motif.shared.action.MotifReduxAction;
import com.motif.shared.action.MotifReduxActionData;

import lombok.RequiredArgsConstructor;

public class BritReduxActionList {

	private static class BritReduxActionData extends MotifReduxActionData {
	}
	
	private static class BritReduxAction<D extends BritReduxActionData> extends MotifReduxAction<D> {
		public BritReduxAction(String type, D data) {
			super(type, data);
		}
	}
	
	public static final String ADD_LOG = "[Brit] Add Log";
	public static final String INIT_STATE = "[Brit] Init State";
	public static final String REQUEST = "[Brit] Request";
	public static final String SET_GAME_STARTED = "[Brit] Set Game Started";
	public static final String SET_PHASE = "[Brit] Set Phase";
	public static final String UPDATE_AREA = "[Brit] Update Area";
	public static final String UPDATE_BATTLE = "[Brit] Update Battle";
	public static final String UPDATE_NATION = "[Brit] Update Nation";
	public static final String UPDATE_UNIT = "[Brit] Update Unit";
	
	@Expose private ArrayList<BritReduxAction<?>> actions = new ArrayList<BritReduxAction<?>> ();
	
	public void addLog(BritGameLog.MotifGameLogRow logRow) { actions.add(new BritReduxAction<>(ADD_LOG, new AddLogData(logRow))); }
	public void initState(BritGame game, List<String> userPlayerIds, BritRequest<?> request) { actions.add(new BritReduxAction<>(INIT_STATE, new InitStateData(game, userPlayerIds, request))); }
	public void request(BritRequest<?> request) { actions.add(new BritReduxAction<>(REQUEST, new RequestData(request))); }
	public void setPhase(String round, String nationId, AngPhase phase) { actions.add(new BritReduxAction<>(SET_PHASE, new SetPhaseData(round, nationId, phase == null ? null : phase.getLabel()))); }
	public void updateNation(BritNation nation) { actions.add(new BritReduxAction<>(UPDATE_NATION, new UpdateNationData(nation))); }
	public void updateArea(BritArea area) { actions.add(new BritReduxAction<>(UPDATE_AREA, new UpdateAreaData(area))); }
	public void updateBattle(BritBattle battle) { actions.add(new BritReduxAction<>(UPDATE_BATTLE, new UpdateBattle(battle))); }
	public void updateUnit(BritUnit unit) { actions.add(new BritReduxAction<>(UPDATE_UNIT, new UpdateUnitData(unit))); }
	public void setGameStarted(boolean started) { actions.add(new BritReduxAction<>(SET_GAME_STARTED, new SetGameStarted(started))); }
	
	public void removeLast() {
		actions.remove (actions.size () - 1);
	}
	
	@RequiredArgsConstructor
	public static class AddLogData extends BritReduxActionData {
		@Expose private final BritGameLog.MotifGameLogRow logRow;
	}
	
	public static class InitStateData extends BritReduxActionData {
		private static class BritState {
			@Expose private BritGame game;
			@Expose private List<String> userPlayerIds;
			@Expose private BritRequest<?> request;
		}
		@Expose private BritState state = new BritState();
		public InitStateData(BritGame game, List<String> userPlayerIds, BritRequest<?> request) {
			state.game = game;
			state.userPlayerIds = userPlayerIds;
			state.request = request;
		}
	}
	
	@RequiredArgsConstructor
	public static class RequestData extends BritReduxActionData {
		@Expose public final BritRequest<?> request;
	}
	
	@RequiredArgsConstructor
	public static class SetGameStarted extends BritReduxActionData {
		@Expose private final boolean started;
	}
	
	@RequiredArgsConstructor
	public static class SetPhaseData extends BritReduxActionData {
		@Expose private final String round;
		@Expose private final String nationId;
		@Expose private final String phase;
	}
	
	@RequiredArgsConstructor
	public static class UpdateAreaData extends BritReduxActionData {
		@Expose private final BritArea area;
	}

	@RequiredArgsConstructor
	public static class UpdateBattle extends BritReduxActionData {
		@Expose private final BritBattle battle;
	}

	@RequiredArgsConstructor
	public static class UpdateNationData extends BritReduxActionData {
		@Expose private final BritNation nation;
	}

	@RequiredArgsConstructor
	public static class UpdateUnitData extends BritReduxActionData {
		@Expose private final BritUnit unit;
	}
	
}
