package motif.brit.state;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.stream.Stream;

import com.google.gson.annotations.Expose;

import lombok.Getter;
import motif.brit.ang.enums.AngPhase;
import motif.brit.endpoint.BritContext;

public class BritGame {
	
	@Expose private HashMap<String, BritPlayer> playerMap = new HashMap<> ();
	public BritPlayer getPlayer (String playerId) { return this.playerMap.get (playerId); }
	public void initPlayer (BritPlayer player) { playerMap.put (player.getId (), player); }
	public Stream<BritPlayer> players () { return playerMap.values ().stream (); }
	public Stream<BritPlayer> opponents (BritPlayer player) { return players ().filter (p -> p != player); }
	
	@Expose private HashMap<String, BritNation> nationMap = new HashMap<> ();
	@Expose private ArrayList<String> nationIds = new ArrayList<> ();
	public void initNation (BritNation nation) { nationMap.put (nation.getId (), nation); nationIds.add (nation.getId ()); }
	public BritNation getNation (String nationId) { return this.nationMap.get (nationId); }
	public Iterator<BritNation> getNationIt () {
		return new Iterator<BritNation> () {
			private Iterator<String> nationIdIt = nationIds.iterator ();
			@Override public boolean hasNext () { return nationIdIt.hasNext (); }
			@Override public BritNation next () { return getNation (nationIdIt.next ()); }
		};
	} // getNationIt

	@Expose private HashMap<String, BritArea> areaMap = new HashMap<> ();
	public Stream<BritArea> areas () { return areaMap.values ().stream (); }
	public Stream<BritLandArea> landAreas () { return areas ().filter (area -> area.isLand ()).map (area -> (BritLandArea) area); }
	public BritArea getArea (String areaId) { return this.areaMap.get (areaId); }
	public BritLandArea getLandArea (String areaId) { return (BritLandArea) getArea (areaId); }
	public BritSeaArea getSeaArea (String areaId) { return (BritSeaArea) getArea (areaId); }
	@Expose private ArrayList<String> areaIds = new ArrayList<> ();
	public void initArea (BritArea area) {
		areaIds.add (area.getId ());
		areaMap.put (area.getId (), area);
	} // initArea
	
	@Expose private HashMap<String, BritUnit> unitMap = new HashMap<> ();
	public void initUnit (BritUnit unit) { unitMap.put (unit.getId (), unit); }
	
	@Expose private BritBattle battle = null;
	public Stream<BritDie> attDice() { return battle.attDice(); }
	public Stream<BritDie> defDice() { return battle.defDice(); }
	public int getNAttDice() { return battle.getNAttDice(); }
	public int getNDefDice() { return battle.getNDefDice(); }
	public BritLandArea getBattleLand() { return battle.getBattleLand(); }
	public BritNation getAttNation() { return battle.getAttNation(); }
	public BritNation getDefNation() { return battle.getDefNation(); }
	public BritPlayer getAttPlayer() { return battle.getAttPlayer(); }
	public BritPlayer getDefPlayer() { return battle.getDefPlayer(); }
	public void newBattle(BritNation attNation, BritNation defNation, BritLandArea battleLand, BritContext context) {
		this.battle = new BritBattle(attNation, defNation, battleLand);
		context.actions().updateBattle(this.battle);
	}
	public void addAttDie(BritUnit unit, BritContext context) {
		this.battle.addAttDie(unit);
		context.actions().updateBattle(this.battle);
	}
	public void addDefDie(BritUnit unit, BritContext context) {
		this.battle.addDefDie(unit);
		context.actions().updateBattle(this.battle);
	}
	public void setDieResult(int result, BritDie die, BritContext context) {
		die.setResult(result);
		context.actions().updateBattle(this.battle);
	}
	public void resetBattleRound(BritContext context) {
		this.battle.resetDice();
		context.actions().updateBattle(null);
	}
	public void endBattle(BritContext context) {
		this.battle = null;
		context.actions().updateBattle(null);
	}
	
	@Expose private ArrayList<BritGameLog.MotifGameLogRow> log = new ArrayList<> ();
	private BritGameLog logManager = new BritGameLog (log);
	public BritGameLog log () { return logManager; }
	
	private ArrayList<ArrayList<BritTimelineElement>> timeline = new ArrayList<> (16);
	public void initTimelineRound (ArrayList<BritTimelineElement> timelineRound) { timeline.add (timelineRound); }
	public BritTimelineElement getTimelineElement (int round, BritNation nation) {
		return timeline.get (round - 1).stream ()
				.filter (e -> e.getNation () == nation)
				.findAny ()
				.orElse (null);
	} // getTimelineElement
	
	@Expose private String round;
	public void setRound (String round, BritContext context) {
		this.round = round;
		context.actions ().setPhase (round, nationId, phase);
	} // setRound
	
	@Expose private String nationId;
	public void setNationId (String nationId, BritContext context) {
		this.nationId = nationId;
		context.actions ().setPhase (round, nationId, phase);
	} // setNationId
	
	@Expose @Getter private AngPhase phase;
	public void setPhase (AngPhase phase, BritContext context) {
		this.phase = phase;
		context.actions ().setPhase (round, nationId, phase);
	} // setPhase
	
	@Expose @Getter private boolean started = false;
	public void setStarted (boolean started, BritContext context) {
		this.started = started;
		context.actions ().setGameStarted (started);
	}
	
}
