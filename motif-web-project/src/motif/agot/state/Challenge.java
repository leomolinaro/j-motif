package motif.agot.state;

import java.util.ArrayList;
import java.util.stream.Stream;

import motif.agot.ang.enums.AngIcon;
import motif.agot.state.cards.CharacterCard;

public class Challenge {

	private AngIcon type;
	public boolean isType (AngIcon icon) { return type.equals (icon); }
	public AngIcon type () { return type; }
	private AgotPlayer attacker;
	public AgotPlayer attacker () { return attacker; }
	private ArrayList<CharacterCard> attackers = new ArrayList<CharacterCard> ();
	public Stream<CharacterCard> attackers () { return attackers.stream (); }
	public boolean isAttacker (CharacterCard card) { return attackers.contains (card); }
	private ArrayList<CharacterCard> bypassed = new ArrayList<CharacterCard> ();
	public Stream<CharacterCard> bypassed () { return bypassed.stream (); }
	public boolean isBypassed (CharacterCard card) { return bypassed.contains (card); }
	public AgotPlayer defender;
	public AgotPlayer defender () { return defender; }

	private ArrayList<CharacterCard> defenders = new ArrayList<CharacterCard> ();
	public void addDefender (CharacterCard defender) { this.defenders.add (defender); }
	public boolean isDefender (CharacterCard card) { return defenders.contains (card); }
	public Stream<CharacterCard> defenders () { return defenders.stream (); }
	
	public int attStr;
	public int defStr;

	private boolean unopposed = false;
	public boolean unopposed () { return unopposed; }
	public void setUnopposed () { unopposed = true; }
	
	private boolean attackWins = false;
	private boolean defenseWins = false;
	private boolean attackLoses = false;
	private boolean defenseLoses = false;
	public void setAttackWins () { attackWins = true; }
	public void setAttackLoses () { attackLoses = true; }
	public void setDefenseWins () { defenseWins = true; }
	public void setDefenseLoses () { defenseLoses = true; }
	public boolean attackWins () { return attackWins; }
	public boolean defenseWins () { return defenseWins; }
	public boolean attackLoses () { return attackLoses; }
	public boolean defenseLoses () { return defenseLoses; }
	
	public AgotPlayer winner () { return attackWins ? attacker : (defenseWins ? defender : null); }
	public AgotPlayer loser () { return attackLoses ? attacker : (defenseLoses ? defender : null); }
	
	public static class ChallengeBuilder {
		
		private Challenge challenge = new Challenge ();
		
		public ChallengeBuilder (AgotPlayer attacker) {
			challenge.attacker = attacker;
		} // ChallengeBuilder
		
		public ChallengeBuilder type (AngIcon type) { challenge.type = type; return this; }
		public ChallengeBuilder defender (AgotPlayer defender) { challenge.defender = defender; return this; }
		public ChallengeBuilder attacker (CharacterCard attacker) { challenge.attackers.add (attacker); return this; }
		public void bypassed (CharacterCard bypassed) { challenge.bypassed.add (bypassed); }

		public Challenge build () { return challenge; }

		
	} // ChallengeBuilder

} // Challenge
