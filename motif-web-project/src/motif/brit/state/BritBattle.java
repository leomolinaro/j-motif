package motif.brit.state;

import java.util.ArrayList;
import java.util.stream.Stream;

import com.google.gson.annotations.Expose;

import lombok.Getter;

public class BritBattle {

	public BritBattle(BritNation attNation, BritNation defNation, BritLandArea battleLand) {
		this.attNation = attNation;
		this.attNationId = attNation.getId();
		this.defNation = defNation;
		this.defNationId = defNation.getId();
		this.battleLand = battleLand;
		this.battleLandId = battleLand.getId();
	}

	@Getter private final BritNation attNation;
	@Expose private final String attNationId;
	public BritPlayer getAttPlayer() { return attNation.getController(); }

	@Getter private final  BritNation defNation;
	@Expose private final String defNationId;
	public BritPlayer getDefPlayer() { return defNation.getController(); }

	@Getter private final BritLandArea battleLand;
	@Expose private final String battleLandId;
	
	@Expose private ArrayList<BritDie> attDice = new ArrayList<BritDie>();
	public void addAttDie(BritUnit unit) { attDice.add(new BritDie(unit)); }
	public int getNAttDice() { return this.attDice.size(); }
	public Stream<BritDie> attDice() { return attDice.stream(); }
	
	@Expose private ArrayList<BritDie> defDice = new ArrayList<BritDie>();
	public void addDefDie(BritUnit unit) { defDice.add(new BritDie(unit)); }
	public int getNDefDice() { return this.defDice.size(); }
	public Stream<BritDie> defDice() { return defDice.stream(); }
	
	public void resetDice() {
		this.attDice.clear();
		this.defDice.clear();
	}
	
}
