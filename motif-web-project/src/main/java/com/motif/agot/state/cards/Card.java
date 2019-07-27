package com.motif.agot.state.cards;

import com.google.gson.annotations.Expose;
import com.motif.agot.ang.cards.AngCard;
import com.motif.agot.ang.enums.AngFaction;
import com.motif.agot.ang.enums.AngType;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.flow.IAgotModelChoice;
import com.motif.agot.logic.requests.AgotChoice;
import com.motif.agot.state.AgotPlayer;
import com.motif.shared.util.SB;

import io.leangen.graphql.annotations.GraphQLQuery;

public abstract class Card<A extends AngCard> implements IAgotModelChoice, ICard {
	
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
	public long id() { return id; }

	@Expose private String imageSource;
	public String imageSource() { return this.imageSource; }
	
	protected A ang;
	public A getAngCard () { return ang; }
	public final String getTitle () { return ang.getTitle (); }
	public final AngType getType () { return ang.getType (); }
	public boolean isFaction (AngFaction faction) { return ang.isFaction (faction); }
	public final boolean isType (AngType type) { return ang.isType (type); }
	
	@Override public String toString() { return getTitle (); }
	
	@Override
	public AgotChoice getChoice() {
		return AgotChoice.selectCardChoice(this);
	}
	
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
	@GraphQLQuery public boolean kneeling() { return this.kneeling; }
	public boolean isStanding () { return !kneeling; }
	public boolean isKneeling () { return kneeling; }
	
	private void setKneeling (boolean kneeling, AgotContext context) {
		this.kneeling = kneeling;
		context.actions ().setCardKneeling (kneeling, this);
	}
	
	public void kneel (AgotContext context) {
		setKneeling (true, context);
	}
	
	public void stand (AgotContext context) {
		setKneeling (false, context);
	}
	
	/********************************************************************************/
	/****  POWER  *******************************************************************/
	/********************************************************************************/
	
	@Expose private int power = 0;
	@GraphQLQuery public int power() { return power; }
	
	private void setPower(int power, AgotContext context) {
		this.power = power;
		context.actions ().setCardPower (power, this);
	}
	
	public void gainPower (AgotContext context) { gainPower (1, context); }
	public void gainPower (int powerToGain, AgotContext context) { setPower (power + powerToGain, context); }
	public void losePower (int powerToLose, AgotContext context) { setPower (power - powerToLose, context); }
	
	/********************************************************************************/
	/****  REVEAL  ******************************************************************/
	/********************************************************************************/
	
	@Expose private boolean revealed = true;
	@GraphQLQuery public boolean revealed() { return revealed; }
	public boolean isRevealed() { return revealed; }
	
	private void setRevealed(boolean revealed, AgotContext context) {
		this.revealed = revealed;
		context.actions().setCardRevealed(revealed, this);
	}
	
	public void hide(AgotContext context) { setRevealed(false, context); }
	public void reveal(AgotContext context) { setRevealed(true, context); }
	
	/********************************************************************************/
	/****  TO STRING  ***************************************************************/
	/********************************************************************************/
	
	public String toView () {
		SB s = new SB ();
		s.a (getTitle ()).a (" (").a (kneeling ? "kneeling" : "standing");
		s.a (", powers: ").a (power).a (")");
		return s.toString ();
	} // toView
	
} // Card
