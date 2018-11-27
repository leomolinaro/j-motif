package motif.agot.state.cards;

import java.util.ArrayList;

import motif.agot.ang.cards.AngCharacterCard;
import motif.agot.ang.enums.AngIcon;
import motif.agot.ang.enums.AngKeyword;
import motif.agot.ang.text.AngTextKeyword;
import motif.agot.state.AgotPlayer;

public class CharacterCard extends MarshallCard<AngCharacterCard> {

	public CharacterCard (AngCharacterCard ang, AgotPlayer owner) {
		super (ang, owner);
	} // CharacterCard

	public void accept (MarshallCardVisitor visitor) { visitor.visit (this); }
	public interface CharacterCardVisitor { public void visit (CharacterCard card); }

	/********************************************************************************/
	/****  CARD ICONS  **************************************************************/
	/********************************************************************************/
	
	private int modPowerIcon = 0;
	private int modIntrigueIcon = 0;
	private int modMilitaryIcon = 0;
	public void addIcon (AngIcon icon) {
		switch (icon) {
			case INTRIGUE: modIntrigueIcon++; break;
			case MILITARY: modMilitaryIcon++; break;
			case POWER: modPowerIcon++; break;
		} // switch
	} // addIcon
	public void removeIcon (AngIcon icon) {
		switch (icon) {
			case INTRIGUE: modIntrigueIcon--; break;
			case MILITARY: modMilitaryIcon--; break;
			case POWER: modPowerIcon--; break;
		} // switch
	} // removeIcon
	public boolean hasIcon (AngIcon icon) {
		int totalIcon = ang.hasIcon (icon) ? 1 : 0;
		switch (icon) {
			case INTRIGUE: totalIcon += modIntrigueIcon; break;
			case MILITARY: totalIcon += modMilitaryIcon; break;
			case POWER: totalIcon += modPowerIcon; break;
		} // switch
		return totalIcon > 0;
	} // hasIcon

	/********************************************************************************/
	/****  CHARACTER STRENGTH  ******************************************************/
	/********************************************************************************/
	
	private int modStrength = 0;
	public void modifyStrength (int deltaStrength) { modStrength += deltaStrength; }
	public int getPrintedStrength () { return ang.getStrength (); }
	public int getStrength () { return getPrintedStrength () + modStrength; }
	
	/********************************************************************************/
	/****  CHARACTER ICONS  *********************************************************/
	/********************************************************************************/
	
	private ArrayList<AngTextKeyword> modKeywords;
	public void addKeyword (AngTextKeyword keyword) { if (modKeywords == null) { modKeywords = new ArrayList<AngTextKeyword> (); } modKeywords.add (keyword); }
	public void removeKeyword (AngTextKeyword keyword) { modKeywords.remove (keyword); if (modKeywords.isEmpty ()) { modKeywords = null; } }
	private boolean hasKeyword (AngKeyword keyword) {
		if (ang.hasKeyword (keyword)) {
			return true;
		} else {
			if (modKeywords == null) {
				return false;
			} else {
				return modKeywords.stream ()
						.anyMatch (textKey -> textKey.getKeyword ().equals (keyword));
			} // if - else
		} // if - else
	} // hasKeyword
	public boolean hasRenown () { return hasKeyword (AngKeyword.RENOWN); }
	public boolean hasStealth () { return hasKeyword (AngKeyword.STEALTH); }
	
	/********************************************************************************/
	/****  OTHER  *******************************************************************/
	/********************************************************************************/
	
	public boolean isKillable () {
		AgotPlayer controller = this.getController ();
		return controller.hasCharacter (this);
	} // isKillable
	
	/********************************************************************************/
	/****  GAINED ABILITIES  ********************************************************/
	/********************************************************************************/
	
	private int cannotBeBypassedByStealth = 0;
	public void subscribeCannotBeBypassedByStealth () { cannotBeBypassedByStealth++; }
	public void unsubscribeCannotBeBypassedByStealth () { cannotBeBypassedByStealth--; }
	public boolean canBeBypassedByStealth () { return cannotBeBypassedByStealth <= 0; }
	
} // CharacterCard
