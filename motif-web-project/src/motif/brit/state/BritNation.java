package motif.brit.state;

import java.util.ArrayList;
import java.util.stream.Stream;

import com.google.gson.annotations.Expose;

import lombok.Getter;
import lombok.ToString;
import motif.brit.config.BritConfig;
import motif.brit.endpoint.BritContext;

@ToString(onlyExplicitlyIncluded = true)
public class BritNation {

	public enum BritColor {
		yellow, red, green, blue
	}
	
	private ArrayList<BritUnit> reinforcements = new ArrayList<> ();
	@Expose private ArrayList<String> reinforcementIds = new ArrayList<> ();
	public void initReinforcement (BritUnit unit) { reinforcements.add (unit); reinforcementIds.add (unit.getId ()); }
	public void addReinforcement (BritUnit unit, BritContext context) {
		reinforcements.add (unit);
		reinforcementIds.add (unit.getId ());
		context.actions ().updateNation (this);
	} // addReinforcement
	public void removeReinforcement (BritUnit unit, BritContext context) {
		reinforcements.remove (unit);
		reinforcementIds.remove (unit.getId ());
		context.actions ().updateNation (this);
	} // removeReinforcement
	public Stream<BritUnit> reinforcements () { return reinforcements.stream (); }
	public Stream<BritInfantry> reinforcementInfantries () { return reinforcements ().filter (unit -> unit.isInfantry ()).map (unit -> (BritInfantry) unit); }
	public BritInfantry getInfantry () { return reinforcementInfantries ().findAny ().get (); }
	
	private ArrayList<BritUnit> units = new ArrayList<BritUnit> ();
	public void initUnit (BritUnit unit) { units.add (unit); }
	public Stream<BritUnit> units () { return units.stream (); }
	public Stream<BritUnit> inPlayUnits () { return units ().filter (unit -> unit.isInPlay ()); }
	public void clearPaths() { inPlayUnits().forEach(unit -> unit.clearPath()); } 
	
	private ArrayList<BritLandArea> lands = new ArrayList<BritLandArea>();
	public Stream<BritLandArea> lands() { return lands.stream(); }
	public Iterable<BritLandArea> landsIt() { return lands; }
	public void addLand(BritLandArea land) { this.lands.add(land); }
	public void removeLand(BritLandArea land) { this.lands.remove(land); }
	
	@Expose @Getter private String id;
	public boolean isRoman() { return id.equals (ROMANS); }
	public boolean isSaxon() { return id.equals (SAXONS); }
	
	@Expose @Getter @ToString.Include private String name;
	@Expose private BritColor color;
	private int sort;
	
	@Expose private String cardImageSource;
	
	@Getter private BritPlayer controller;
	
	public BritNation (int sort, String id, String name, BritColor color, BritPlayer controller) {
		this.sort = sort;
		this.id = id;
		this.name = name;
		this.color = color;
		this.controller = controller;
		this.cardImageSource = BritConfig.NATION_CARD_IMAGE_SOURCE.replace ("{id}", id);
		this.popMarkerImageSource = isRoman () ? "" : BritConfig.POP_MARKER_IMAGE_SOURCE.replace ("{id}", id);
	} // BritNation
	
	@Expose private int victoryPoints = 0;
	
	@Expose @Getter private int popMarker = 0;
	@Expose private String popMarkerImageSource;
	@Expose private int popMarkerSvgX;
	@Expose private int popMarkerSvgY;
	@Expose @Getter private boolean popMarkerActive = false;

	public void setPopulationMarker (int populationMarker, BritContext context) {
		this.popMarker = populationMarker;
		this.popMarkerSvgX = 242 + populationMarker * 64 + ((sort - 1) % 4) * 15;
		this.popMarkerSvgY = 1227 + ((sort - 1) / 4) * 15;
		this.popMarkerActive = true;
		context.actions ().updateNation (this);
	} // setPopulationMarker

	public static final String ROMANS = "romans";
	public static final String ROMANO_BRITISH = "romano_british";
	public static final String NORMANS = "normans";
	public static final String SAXONS = "saxons";
	public static final String DANES = "danes";
	public static final String NORWEGIANS = "norwegians";
	public static final String JUTES = "jutes";
	public static final String ANGLES = "angles";
	public static final String BELGAE = "belgae";
	public static final String WELSH = "welsh";
	public static final String BRIGANTES = "brigantes";
	public static final String CALEDONIANS = "caledonians";
	public static final String PICTS = "picts";
	public static final String IRISH = "irish";
	public static final String SCOTS = "scots";
	public static final String NORSEMEN = "norsemen";
	public static final String DUBLINERS = "dubliners";
	
}
