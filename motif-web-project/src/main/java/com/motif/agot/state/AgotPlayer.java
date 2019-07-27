package com.motif.agot.state;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.gson.annotations.Expose;
import com.motif.agot.ang.enums.AngArea;
import com.motif.agot.ang.enums.AngType;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.flow.IAgotModelChoice;
import com.motif.agot.logic.requests.AgotChoice;
import com.motif.agot.state.cards.AgendaCard;
import com.motif.agot.state.cards.AttachmentCard;
import com.motif.agot.state.cards.Card;
import com.motif.agot.state.cards.CharacterCard;
import com.motif.agot.state.cards.DrawCard;
import com.motif.agot.state.cards.EventCard;
import com.motif.agot.state.cards.FactionCard;
import com.motif.agot.state.cards.LocationCard;
import com.motif.agot.state.cards.MarshallCard;
import com.motif.agot.state.cards.PlotCard;
import com.motif.agot.state.cards.TextCard;
import com.motif.shared.endpoint.MotifUser;
import com.motif.shared.game.MotifPlayer;
import com.motif.shared.util.ListUtil;
import com.motif.shared.util.ModelPile;
import com.motif.shared.util.SB;
import com.motif.shared.util.StreamUtil;

import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.Getter;

public class AgotPlayer extends MotifPlayer implements IAgotModelChoice {
	
	/********************************************************************************/
	/****  PLAYER BASE  *************************************************************/
	/********************************************************************************/
	
	public AgotPlayer(String id, String playerName, MotifUser user) {
		super(user);
		this.id = id;
		this.name = playerName;
	}

	@Expose private String id;
	@GraphQLQuery public String id() { return id; }
	
	@Expose private String name;
	public String getName() { return name; }
	
	private AgotPlayer nextPlayer;
	public void setNextPlayer (AgotPlayer nextPlayer) { this.nextPlayer = nextPlayer; }
	public AgotPlayer getNextPlayer () { return nextPlayer; }
	
	/********************************************************************************/
	/****  PLAYER GOLD  *************************************************************/
	/********************************************************************************/
	
	@Expose private int gold = 0;
	public int getGold () { return gold; }
	public void gainGold (int goldGained, AgotContext context) {
		this.gold += goldGained;
		context.actions ().setGold (this.gold, this);
	} // collectGold
	public void payGold (int goldPaid, AgotContext context) {
		this.gold -= goldPaid;
		context.actions ().setGold (this.gold, this);
	} // payGold
	public int resetGold (AgotContext context) {
		int gold = this.gold;
		this.gold = 0;
		context.actions ().setGold (this.gold, this);
		return gold;
	} // resetGold
	
	/********************************************************************************/
	/****  PLAYER AREA  *************************************************************/
	/********************************************************************************/
	
	private transient FactionCard faction;
	@Expose private long factionId;
	public FactionCard getFaction () { return faction; }
	public void setFaction (FactionCard factionCard) { this.faction = factionCard; this.factionId = factionCard.id(); }
	
	private AgendaCard agenda;
	@Expose private Long agendaId = null;
	public AgendaCard getAgenda () { return agenda; }
	public void setAgenda (AgendaCard agendaCard) { this.agenda = agendaCard; this.agendaId = agendaCard == null ? null : agendaCard.id (); }
	public boolean hasAgenda () { return agenda != null; }
	
	private ModelPile<DrawCard<?>> drawDeck = new ModelPile<DrawCard<?>> ();
	@Expose private boolean drawDeckEmpty = false;
	public void addDrawCard (DrawCard<?> card) { drawDeckEmpty = false; drawDeck.addLast (card); }
	public void shuffleDeck () { Collections.shuffle (drawDeck); }
	public int drawDeckSize () { return drawDeck.size (); }
	public boolean canDraw () { return !drawDeckEmpty; }
	public boolean hasInDeck (DrawCard<?> card) { return drawDeck != null && drawDeck.contains (card); }
	public boolean getDrawDeckEmpty () { return drawDeckEmpty; }
	private DrawCard<?> drawDeckRemoveTop () { DrawCard<?> card = drawDeck.removeLast (); if (drawDeck.isEmpty ()) { drawDeckEmpty = true; } return card; }
	
	private ModelPile<DrawCard<?>> discardPile = new ModelPile<DrawCard<?>> ();
	@Expose private ModelPile<Long> discardPileIds = new ModelPile<Long> ();
	public Stream<DrawCard<?>> discardPile () { return discardPile.stream (); }
	private void discardPilePutTop (DrawCard<?> card) { discardPile.putTop (card); discardPileIds.putTop (card.id ()); }

	private ModelPile<CharacterCard> deadPile = new ModelPile<CharacterCard> ();
	@Expose private ModelPile<Long> deadPileIds = new ModelPile<Long> ();
	public Stream<CharacterCard> deadPile () { return deadPile.stream (); }
	private void deadPilePutTop (CharacterCard card) { deadPile.putTop (card); deadPileIds.putTop (card.id ()); }
	
	private ArrayList<PlotCard> plotDeck = new ArrayList<PlotCard> ();
	@Expose private ArrayList<Long> plotDeckIds = new ArrayList<Long> ();
	public void addPlotCard (PlotCard card) { plotDeck.add (card); plotDeckIds.add (card.id ()); }
	public Stream<PlotCard> plotDeck () { return plotDeck.stream (); }
	public boolean emptyPlotDeck () { return plotDeck.isEmpty (); }
	private void plotDeckAdd (PlotCard card) { plotDeck.add (card); plotDeckIds.add (card.id ()); }
	private void plotDeckRemove (PlotCard card) { plotDeck.remove (card); plotDeckIds.remove (card.id ()); }
	
	private PlotCard revealedPlot = null;
	@Expose private Long revealedPlotId = null;
	private void setRevealedPlot (PlotCard card) { revealedPlot = card; revealedPlotId = card == null ? null : card.id (); }
	public PlotCard revealedPlot () { return revealedPlot; }
	public int getInitiative () {  return revealedPlot.getInitiative (); }
	public int getIncome () { return revealedPlot.getIncome (); }
	public int getReserve () { return revealedPlot.getReserve (); }
	
	private ModelPile<PlotCard> usedPlotPile = new ModelPile<PlotCard> ();
	@Expose private ModelPile<Long> usedPlotPileIds = new ModelPile<Long> ();
	public Stream<PlotCard> usedPlotPile () { return usedPlotPile.stream (); }
	private void usedPlotPilePutTop (PlotCard card) { usedPlotPile.putTop (card); usedPlotPileIds.putTop (card.id ()); }
	private PlotCard usedPlotPileRemoveTop () { usedPlotPileIds.removeLast (); return usedPlotPile.removeLast (); }
	
	private LinkedList<DrawCard<?>> hand = new LinkedList<DrawCard<?>> ();
	@Expose private LinkedList<Long> handIds = new LinkedList<Long> ();
	public Stream<DrawCard<?>> hand () { return hand.stream (); }
	public boolean hasInHand (DrawCard<?> card) { return hand.contains (card); }
	public int handSize () { return hand.size (); }
	private void handAdd (DrawCard<?> card) { hand.add (card); handIds.add (card.id ()); }
	private void handRemove (DrawCard<?> card) { hand.remove (card); handIds.remove (card.id ()); }
	
	private LinkedList<CharacterCard> characters = new LinkedList<CharacterCard> ();
	@Expose private LinkedList<Long> charactersIds = new LinkedList<Long> ();
	public Stream<CharacterCard> characters () { return characters.stream (); }
	public void forEachCharacter (Consumer<? super CharacterCard> action) { characters ().forEach (action); }
	public boolean hasCharacter (CharacterCard card) { return characters.contains (card); }
	public boolean hasCharacters () { return !characters.isEmpty (); }
	public int charactersSize () { return characters.size (); }
	private void charactersAdd (CharacterCard card) { characters.add (card); charactersIds.add (card.id ()); }
	private void charactersRemove (CharacterCard card) { characters.remove (card); charactersIds.remove (card.id ()); }
	
	private LinkedList<LocationCard> locations = new LinkedList<LocationCard> ();
	@Expose private LinkedList<Long> locationsIds = new LinkedList<Long> ();
	public Stream<LocationCard> locations () { return locations.stream (); }
	public boolean hasLocation (LocationCard card) { return locations.contains (card); }
	public boolean hasLocations () { return !locations.isEmpty (); }
	private void locationsAdd (LocationCard card) { locations.add (card); locationsIds.add (card.id ()); }
	private void locationsRemove (LocationCard card) { locations.remove (card); locationsIds.remove (card.id ()); }
	
	private LinkedList<AttachmentCard> attachments = new LinkedList<AttachmentCard> ();
	public Stream<AttachmentCard> attachments () { return attachments.stream (); }
	public boolean hasAttachment (AttachmentCard card) { return attachments.contains (card); }
	public boolean hasAttachments () { return !attachments.isEmpty (); }
	
	public boolean hasInteracting (TextCard<?> card) {
		switch (card.getType ()) {
			case AGENDA: return agenda == card;
			case ATTACHMENT: return hasAttachment ((AttachmentCard) card);
			case CHARACTER: return hasCharacter ((CharacterCard) card);
			case EVENT: return hasInHand ((EventCard) card);
			case FACTION: return false;
			case LOCATION: return hasLocation ((LocationCard) card);
			case PLOT: return revealedPlot == card;
		} // switch
		return false;
	} // hasInteracting
	
	/********************************************************************************/
	/****  PLAYER AREA INTERACTIONS  ************************************************/
	/********************************************************************************/
	
	public void resetPlotDeck (AgotContext context) {
		usedPlotPile ().forEach (plot -> {
			plotDeckAdd (plot);
			context.actions ().addCard (plot, this, AngArea.PLOT_DECK);
		});
		while (usedPlotPile.hasElements ()) {
			PlotCard plot = usedPlotPileRemoveTop ();
			context.actions ().removeCard (plot, this, AngArea.USED_PLOT_PILE);
		} // while
	} // resetPlotDeck
	
	public void choosePlot (PlotCard plot, AgotContext context) {
		plotDeckRemove (plot);
		context.actions ().removeCard (plot, this, AngArea.PLOT_DECK);
		if (revealedPlot != null) {
			context.actions ().removeCard (revealedPlot, this, AngArea.REVEALED_PLOT);			
			usedPlotPilePutTop (revealedPlot);
			context.actions ().addCard (revealedPlot, this, AngArea.USED_PLOT_PILE, AngArea.TOP_PILE);			
		} // if
		setRevealedPlot (plot);
		revealedPlot.hide (context);
		context.actions ().addCard (revealedPlot, this, AngArea.REVEALED_PLOT);
	} // revealPlot
	
	public void draw (int qty, AgotContext context) {
		for (int i = 0; i < qty; i++) { draw (context); }
	} // draw
	
	public DrawCard<?> draw (AgotContext context) {
		DrawCard<?> card = drawDeckRemoveTop ();
		context.actions ().addCard (card, this, AngArea.HAND);
		handAdd (card);
		if (!drawDeck.hasElements ()) { context.actions ().emptyDrawDeck (this); }
		return card;
	} // draw
	
	public void discardFromHand (DrawCard<?> card, AgotContext context) {
		handRemove (card);
		context.actions ().removeCard (card, this, AngArea.HAND);
		discardPilePutTop (card);
		context.actions ().addCard (card, this, AngArea.DISCARD_PILE, AngArea.TOP_PILE);
	} // discardFromHand
	
	public void discardDuplicate (MarshallCard<?> dup, MarshallCard<?> card, AgotContext context) {
		card.removeDuplicate (dup);
		context.actions ().removeDuplicate (dup, card);
		AgotPlayer owner = dup.getOwner ();
		owner.discardPilePutTop (dup);
		context.actions ().addCard (dup, owner, AngArea.DISCARD_PILE, AngArea.TOP_PILE);
	} // discardDuplicate
	
	public void discardAttachment (AttachmentCard att, MarshallCard<?> attachTo, AgotContext context) {
		attachTo.removeAttachment (att);
		att.setAttachTo (null);
		context.actions ().removeAttachment (att, attachTo);
		AgotPlayer controller = att.getController ();
		controller.attachments.remove (att);
		AgotPlayer owner = att.getOwner ();
		owner.discardPilePutTop (att);
		context.actions ().addCard (att, owner, AngArea.DISCARD_PILE, AngArea.TOP_PILE);
	} // discardDuplicate
	
	public void discardCharacter (CharacterCard cha, AgotContext context) {
		AgotPlayer controller = cha.getController ();
		controller.charactersRemove (cha);
		context.actions ().removeCard (cha, controller, AngArea.CHARACTERS);
		AgotPlayer owner = cha.getOwner ();
		owner.discardPilePutTop (cha);
		context.actions ().addCard (cha, owner, AngArea.DISCARD_PILE, AngArea.TOP_PILE);
	} // discardCharacter
	
	public void discardLocation (LocationCard loc, AgotContext context) {
		AgotPlayer controller = loc.getController ();
		controller.locationsRemove (loc);
		context.actions ().removeCard (loc, controller, AngArea.LOCATIONS);
		AgotPlayer owner = loc.getOwner ();
		owner.discardPilePutTop (loc);
		context.actions ().addCard (loc, owner, AngArea.DISCARD_PILE, AngArea.TOP_PILE);
	} // discardLocation
	
	public void returnAttachmentToHand (AttachmentCard att, MarshallCard<?> card, AgotContext context) {
		card.removeAttachment (att);
		att.setAttachTo (null);
		context.actions ().removeAttachment (att, card);
		AgotPlayer controller = att.getController ();
		controller.attachments.remove (att);
		AgotPlayer owner = att.getOwner ();
		owner.handAdd (att);
		context.actions ().addCard (att, owner, AngArea.HAND);
	} // returnAttachmentToHand
	
	public DrawCard<?> randomDiscardFromHand (AgotContext context) {
		DrawCard<?> card = ListUtil.getRandom (hand);
		handRemove (card);
		context.actions ().removeCard (card, this, AngArea.HAND);
		discardPilePutTop (card);
		context.actions ().addCard (card, this, AngArea.DISCARD_PILE, AngArea.TOP_PILE);
		return card;
	} // randomDiscardFromHand
	
	public void kill (CharacterCard card, AgotContext context) {
		AgotPlayer owner = card.getOwner ();
		charactersRemove (card);
		context.actions ().removeCard (card, this, AngArea.CHARACTERS);
		owner.deadPilePutTop (card);
		context.actions ().addCard (card, owner, AngArea.DEAD_PILE, AngArea.TOP_PILE);
	} // kill
	
	public void play (CharacterCard card, AgotContext context) {
		handRemove (card);
		context.actions ().removeCard (card, this, AngArea.HAND);
		charactersAdd (card);
		context.actions ().addCard (card, this, AngArea.CHARACTERS);
	} // play
	
	public void play (LocationCard card, AgotContext context) {
		handRemove (card);
		context.actions ().removeCard (card, this, AngArea.HAND);
		locationsAdd (card);
		context.actions ().addCard (card, this, AngArea.LOCATIONS);
	} // play
	
	public void play (AttachmentCard card, MarshallCard<?> attachTo, AgotContext context) {
		handRemove (card);
		attachTo.addAttachment (card);
		card.setAttachTo (attachTo);
		attachments.add (card);
		context.actions ().removeCard (card, this, AngArea.HAND);
		context.actions ().addAttachment (card, attachTo);
	} // play
	
	public void play (EventCard card, AgotContext context) {
		handRemove (card);
		context.actions ().removeCard (card, this, AngArea.HAND);
		discardPilePutTop (card);
		context.actions ().addCard (card, this, AngArea.DISCARD_PILE, AngArea.TOP_PILE);
	} // play
	
	public <C extends MarshallCard<?>> void playAsDuplicate (C card, C duplicateTo, AgotContext context) {
		handRemove (card);
		duplicateTo.addDuplicate (card);
		context.actions ().removeCard (card, this, AngArea.HAND);
		context.actions ().addDuplicate (card, duplicateTo);
	} // playAsDuplicate
	
	/********************************************************************************/
	/****  CARD STREAMS  ************************************************************/
	/********************************************************************************/
	
	/**
	 * @return characters and their attachments, locations and their attachments, the revealed plot, 
	 * the agenda card and the events in hand.
	 */
	public Stream<TextCard<?>> interactingCards () {
		return StreamUtil.concat (
				StreamUtil.ofNotNull (agenda, revealedPlot),
				eventsInHand (),
				characters (),
				locations (),
				attachments ()
		); // concat
	} // interactingCards
	
	/**
	 * @return characters and their attachments, locations and their attachments, the revealed plot and the faction card.
	 */
	public Stream<Card<?>> inPlayCards () {
		return StreamUtil.concat (
				StreamUtil.ofNotNull (faction, revealedPlot),
				characters (),
				locations (),
				attachments ()
		); // concat
	} // getInPlayCards
	
	/**
	 * @return characters and their attachments, locations and their attachments and the revealed plot.
	 */
	public Stream<TextCard<?>> inPlayTextCards () {
		return StreamUtil.concat (
				StreamUtil.ofNotNull (revealedPlot),
				characters (),
				locations (),
				attachments ()
		); // concat
	} // getInPlayTextCards
	
	public Stream<MarshallCard<?>> charactersLocationsAndAttachments () {
		return StreamUtil.concat (
				characters (),
				locations (),
				attachments ()
		); // concat
	} // getCharactersAndAttachments
	
	public Stream<EventCard> eventsInHand () {		
		return this.hand ()
		.filter (e -> e.isType (AngType.EVENT))
		.map (e -> (EventCard) e);
	} // getEventsInHand
	
	/********************************************************************************/
	/****  COMPUTED PROPERTIES  *****************************************************/
	/********************************************************************************/
	
	public int getPower () {
		int power = faction.power ();
		power += characters ().collect (Collectors.summingInt (cha -> cha.power ()));
		return power;
	} // getPower
	
	public void gainPowerOnTheFactionCard (AgotContext context) {
		gainPowerOnTheFactionCard (1, context);
	} // gainPowerOnTheFactionCard
	
	public void gainPowerOnTheFactionCard (int gainPower, AgotContext context) {
		faction.gainPower (gainPower, context);
	} // gainPowerOnTheFactionCard
	
	public void kneelFactionCard (AgotContext context) {
		faction.kneel (context);
	} // kneelFactionCard
	
	public boolean factionCardIsStanding () {
		return faction.isStanding ();
	} // factionCardIsStanding
	
	public int getDominance () {
		int dominance = getGold ();
		dominance += characters ()
				.filter (CharacterCard::isStanding)
				.collect (Collectors.summingInt (cha -> cha.getStrength ()));
		dominance += modDominanceStrength;
		return dominance;
	} // getDominance
	
	/********************************************************************************/
	/****  MODIFIERS  ***************************************************************/
	/********************************************************************************/
	
	private int modDominanceStrength = 0;
	public void increaseDominanceStrength (int strength) { modDominanceStrength += strength; }
	
	/********************************************************************************/
	/****  COUNTERS  ****************************************************************/
	/********************************************************************************/
	
	@Getter private int marshalledLimited = 0;
	public void registerMarshalledLimited () { marshalledLimited++; }
	public void resetLimitedCounter () { marshalledLimited = 0; }
	
	/********************************************************************************/
	/****  ACTIVE FLAG  *************************************************************/
	/********************************************************************************/
	
	@Getter private boolean active = false;
	public void setActive() { this.active = true; }
	public void setInactive() { this.active = false; }
	
	/********************************************************************************/
	/****  TO STRING  ***************************************************************/
	/********************************************************************************/
	
	public String toView (int t) {
		int tt = t + 1;
		SB s = new SB ();
		s.t (t).a (name, "(", id, ")").n ();
		s.t (t).a ("Gold: ", gold).n ();
		s.t (t).a ("Faction card").n ();
		s.t (tt).a (faction.toView ()).n ();
		s.t (t).a ("Hand").n ();
		hand ().forEach (card -> s.t (tt).a (card.toView ()).n ());
		s.t (t).a ("Characters").n ();
		characters ().forEach (card -> s.t (tt).a (card.toView ()).n ());
		s.t (t).a ("Locations").n ();
		locations ().forEach (card -> s.t (tt).a (card.toView ()).n ());
		s.t (t).a ("Plot deck").n ();
		plotDeck ().forEach (card -> s.t (tt).a (card.toView ()).n ());
		return s.toString ();
	} // toView
	
	@Override public String toString () { return name; }
	
	@Override
	public AgotChoice getChoice() {
		return AgotChoice.selectPlayerChoice(this);
	}
		
}
