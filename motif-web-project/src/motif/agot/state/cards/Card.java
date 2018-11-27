package motif.agot.state.cards;

import com.google.gson.annotations.Expose;

import motif.agot.ang.cards.AngCard;
import motif.agot.ang.enums.AngFaction;
import motif.agot.ang.enums.AngType;
import motif.agot.endpoint.AgotContext;
import motif.agot.flow.request.IAgotModel;
import motif.agot.flow.request.IAgotModelVisitor;
import motif.agot.state.AgotPlayer;
import motif.shared.util.SB;

public abstract class Card<A extends AngCard> implements IAgotModel {
	
	/********************************************************************************/
	/****  CARD BASE  ***************************************************************/
	/********************************************************************************/
	
	private static long idCounter = 0;
	
	public Card (A ang, AgotPlayer controller) {
		this.id = ++idCounter;
		this.ang = ang;
		this.owner = controller;
		this.controller = controller;
		this.imageSource = ang.getImageSource ();
	} // Card
	
	@Expose protected long id;
	public long getId () { return id; }

	protected A ang;
	@Expose private String imageSource;
	public A getAngCard () { return ang; }
	public final String getTitle () { return ang.getTitle (); }
	public final AngType getType () { return ang.getType (); }
	public boolean isFaction (AngFaction faction) { return ang.isFaction (faction); }
	public final boolean isType (AngType type) { return ang.isType (type); }
	
	@Override public String getLabel () { return getTitle (); }
	
	/********************************************************************************/
	/****  PLAYER REFERENCES  *******************************************************/
	/********************************************************************************/
	
	protected AgotPlayer owner;
	public final boolean isOwnedBy (AgotPlayer player) { return player == this.owner; }
	public final AgotPlayer getOwner () { return this.owner; }
	
	protected AgotPlayer controller;
	public final AgotPlayer getController () { return this.controller; }
	public final boolean isControlledBy (AgotPlayer player) { return player == this.controller; }
	
	/********************************************************************************/
	/****  KNEELING  ****************************************************************/
	/********************************************************************************/
	
	@Expose private boolean kneeling = false;
	public boolean isStanding () { return !kneeling; }
	public boolean isKneeling () { return kneeling; }
	
	private void setKneeling (boolean kneeling, AgotContext context) {
		this.kneeling = kneeling;
		context.actions ().setCardKneeling (kneeling, this);
	} // setKneeling
	
	public void kneel (AgotContext context) {
		setKneeling (true, context);
	} // kneel
	
	public void stand (AgotContext context) {
		setKneeling (false, context);
	} // stand
	
	/********************************************************************************/
	/****  POWER  *******************************************************************/
	/********************************************************************************/
	
	@Expose private int power = 0;
	public int getPower () { return power; }
	
	private void setPower (int power, AgotContext context) {
		this.power = power;
		context.actions ().setCardPower (power, this);
	} // setPower
	
	public void gainPower (AgotContext context) { gainPower (1, context); }
	public void gainPower (int powerToGain, AgotContext context) { setPower (power + powerToGain, context); }
	public void losePower (int powerToLose, AgotContext context) { setPower (power - powerToLose, context); }
	
	/********************************************************************************/
	/****  REVEAL  ******************************************************************/
	/********************************************************************************/
	
	@Expose private boolean revealed = true;
	public boolean isRevealed () { return revealed; }
	
	private void setRevealed (boolean revealed, AgotContext context) {
		this.revealed = revealed;
		context.actions ().setCardRevealed (revealed, this);
	} // setPower
	
	public void hide (AgotContext context) { setRevealed (false, context); }
	public void reveal (AgotContext context) { setRevealed (true, context); }
	
	/********************************************************************************/
	/****  TO STRING  ***************************************************************/
	/********************************************************************************/
	
	public String toView () {
		SB s = new SB ();
		s.a (getTitle ()).a (" (").a (kneeling ? "kneeling" : "standing");
		s.a (", powers: ").a (power).a (")");
		return s.toString ();
	} // toView
	
	@Override public String toString () { return ang.toString (); }
	
	@Override public void accept (IAgotModelVisitor visitor) { visitor.visit (this); }
	
} // Card
