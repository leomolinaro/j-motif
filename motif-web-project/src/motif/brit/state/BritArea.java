package motif.brit.state;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.gson.annotations.Expose;

import lombok.Getter;
import lombok.ToString;
import motif.brit.endpoint.BritContext;
import motif.brit.logic.flow.IBritModel;

@ToString(onlyExplicitlyIncluded = true)
public abstract class BritArea implements IBritModel {
	
	public enum BritAreaType {
		NORMAL_LAND, DIFFICUL_LAND, SEA 
	} // BritAreaType
	
	@Expose @Getter private String id;
	
	@Expose @Getter @ToString.Include private String name;
	@Override public String getLabel () { return name; }
	
	@Expose private String svgD;
	
	private BritAreaType areaType;
	public boolean isSea () { return areaType.equals (BritAreaType.SEA); }
	public boolean isLand () { return !isSea (); }
	public boolean isNormalLand () { return areaType.equals (BritAreaType.NORMAL_LAND); }
	public boolean isDifficultLand () { return areaType.equals (BritAreaType.DIFFICUL_LAND); }

	private ArrayList<BritUnit> units = new ArrayList<>();
	@Expose private ArrayList<String> unitIds = new ArrayList<>();
	public Stream<BritUnit> units() { return units.stream(); }
	public Stream<BritUnit> movingUnits() { return units().filter(unit -> !unit.isBuilding()); }
	public Stream<BritArmy> armies() { return units().filter(unit -> unit.isArmy()).map(unit -> (BritArmy) unit); }
	public Stream<BritInfantry> infantries() { return units().filter(unit -> unit.isInfantry()).map(unit -> (BritInfantry) unit); }
	public Stream<BritCavalry> cavalries() { return units().filter(unit -> unit.isCavalry()).map(unit -> (BritCavalry) unit); }
	public Stream<BritBuilding> buildings() { return units().filter (unit -> unit.isBuilding()).map (unit -> (BritBuilding) unit); }
	public Stream<BritLeader> leaders() { return units().filter(unit -> unit.isLeader()).map(unit -> (BritLeader) unit); }
	public Stream<BritUnit> unitsOfNation(BritNation nation) { return units().filter(army -> army.isControlledBy(nation)); }
	public Stream<BritUnit> movingUnitsOfNation(BritNation nation) { return movingUnits().filter(unit -> unit.isControlledBy(nation)); }
	public Stream<BritArmy> armiesOfNation(BritNation nation) { return armies().filter(army -> army.isControlledBy(nation)); }
	public Stream<BritInfantry> infantriesOfNation(BritNation nation) { return infantries().filter(infantry -> infantry.isControlledBy(nation)); }
	public Stream<BritCavalry> cavalriesOfNation(BritNation nation) { return cavalries().filter(cavalry -> cavalry.isControlledBy(nation)); }
	public BritBuilding getBuilding() { return units().filter(unit -> unit.isBuilding()).map(buil -> (BritBuilding) buil).findAny().orElse(null); }
	public Stream<BritLeader> leadersOfNation(BritNation nation) { return leaders().filter(leader -> leader.isControlledBy(nation)); }
	public int getNumArmiesOfNation(BritNation nation) { return (int) (long) armiesOfNation(nation).collect(Collectors.counting()); }
	public boolean hasUnits() { return units().findAny().isPresent(); }
	public boolean hasUnitsOfNation(BritNation nation) { return units().anyMatch(unit -> unit.isControlledBy(nation)); }
	public boolean hasUnitsOfOtherNations(BritNation nation) { return units().anyMatch(unit -> !unit.isControlledBy(nation)); }
	public void addUnit(BritUnit unit, double svgX, double svgY, BritContext context) {
		unit.setSvg(svgX, svgY, context);
		units.add(unit);
		unitIds.add(unit.getId());
		context.actions().updateArea(this);
	}
	public void removeUnit(BritUnit unit, BritContext context) {
		units.remove(unit);
		unitIds.remove(unit.getId());
		context.actions().updateArea(this);
	}
	
	private ArrayList<BritBorder> borders = new ArrayList<BritBorder> ();
	public void initBorder (BritBorder border) { borders.add (border); }
	public Stream<BritBorder> borders () { return borders.stream (); }
	public Stream<BritLandArea> adjacentLands() { return borders().map(b -> b.getTo()).filter(a -> a.isLand()).map (a -> (BritLandArea) a); }
	
	public BritArea (String id, String name, BritAreaType areaType, String svgD) {
		super ();
		this.id = id;
		this.name = name;
		this.areaType = areaType;
		this.svgD = svgD;
	} // BritArea
	
	public static final String AVALON = "avalon";
	public static final String DOWNLANDS = "downlands";
	public static final String WESSEX = "wessex";
	public static final String SUSSEX = "sussex";
	public static final String KENT = "kent";
	public static final String ESSEX = "essex";
	public static final String LINDSEY = "lindsey";
	public static final String SUFFOLK = "suffolk";
	public static final String NORFOLK = "norfolk";
	public static final String SOUTH_MERCIA = "south_mercia";
	public static final String NORTH_MERCIA = "north_mercia";
	public static final String HWICCE = "hwicce";
	public static final String DEVON = "devon";
	public static final String CORNWALL = "cornwall";
	public static final String GWENT = "gwent";
	public static final String DYFED = "dyfed";
	public static final String POWYS = "powys";
	public static final String GWYNEDD = "gwynedd";
	public static final String CLWYD = "clwyd";
	public static final String MARCH = "march";
	public static final String CHESHIRE = "cheshire";
	public static final String YORK = "york";
	public static final String BERNICIA = "bernicia";
	public static final String PENNINES = "pennines";
	public static final String CUMBRIA = "cumbria";
	public static final String LOTHIAN = "lothian";
	public static final String GALLOWAY = "galloway";
	public static final String DUNEDIN = "dunedin";
	public static final String STRATHCLYDE = "strathclyde";
	public static final String DALRIADA = "dalriada";
	public static final String ALBAN = "alban";
	public static final String MAR = "mar";
	public static final String MORAY = "moray";
	public static final String SKYE = "skye";
	public static final String CAITHNESS = "caithness";
	public static final String ORKNEYS = "orkneys";
	public static final String HEBRIDES = "hebrides";
	public static final String ICELANDIC_SEA = "icelandic_sea";
	public static final String NORTH_SEA = "north_sea";
	public static final String FRISIAN_SEA = "frisian_sea";
	public static final String ENGLISH_CHANNEL = "english_channel";
	public static final String IRISH_SEA = "irish_sea";
	public static final String ATLANTIC_OCEAN = "atlantic_ocean";
	
} // BritArea
