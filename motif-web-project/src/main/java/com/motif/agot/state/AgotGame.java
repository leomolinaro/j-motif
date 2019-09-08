package com.motif.agot.state;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.stream.Stream;

import javax.annotation.Nonnull;

import com.motif.agot.ang.cards.AngAgendaCard;
import com.motif.agot.ang.cards.AngAttachmentCard;
import com.motif.agot.ang.cards.AngCharacterCard;
import com.motif.agot.ang.cards.AngEventCard;
import com.motif.agot.ang.cards.AngLocationCard;
import com.motif.agot.ang.cards.AngPlotCard;
import com.motif.agot.ang.cards.AngTextCard.AngTextCardVisitor;
import com.motif.agot.ang.enums.AngFaction;
import com.motif.agot.ang.enums.AngIcon;
import com.motif.agot.ang.enums.AngPhase;
import com.motif.agot.ang.sets.AgotCardCreator;
import com.motif.agot.ang.sets.AgotCardSeed;
import com.motif.agot.ang.text.AngConsAbility;
import com.motif.agot.ang.text.AngTrigAbility;
import com.motif.agot.ang.text.conseffects.IAngConsAlignEffect;
import com.motif.agot.ang.text.conseffects.IAngConsEffect;
import com.motif.agot.ang.text.instants.AngLastingEffect;
import com.motif.agot.endpoint.AgotContext;
import com.motif.agot.logic.other.AbilityContext;
import com.motif.agot.state.GameLog.GameLogRow;
import com.motif.agot.state.abilities.DelayedEffect;
import com.motif.agot.state.cards.AgendaCard;
import com.motif.agot.state.cards.AttachmentCard;
import com.motif.agot.state.cards.Card;
import com.motif.agot.state.cards.CharacterCard;
import com.motif.agot.state.cards.EventCard;
import com.motif.agot.state.cards.FactionCard;
import com.motif.agot.state.cards.ICard;
import com.motif.agot.state.cards.LocationCard;
import com.motif.agot.state.cards.MarshallCard;
import com.motif.agot.state.cards.PlotCard;
import com.motif.agot.state.cards.TextCard;
import com.motif.shared.game.MotifGame;
import com.motif.shared.util.ListUtil;

import io.leangen.graphql.annotations.GraphQLQuery;

public class AgotGame extends MotifGame<AgotPlayer> {
	
	public AgotGame (String name) {
		this.id = ++idSequence;
		this.name = name;
	} // AgotGame
	
	private static long idSequence = 0;
	
	private final long id;
	@GraphQLQuery public long id () { return this.id; }
	
	private String name;
	@GraphQLQuery @Nonnull public String name () { return this.name; }
	
	private HashMap<Long, Card<?>> cardMap = new HashMap<Long, Card<?>> ();
	@GraphQLQuery public Collection<? extends ICard> allCards() { return this.cardMap.values (); }
	public Card<?> getCard (long cardId) { return this.cardMap.get (cardId); }

	private HashMap<String, AgotPlayer> playerMap = new HashMap<String, AgotPlayer> ();
	@GraphQLQuery public Collection<AgotPlayer> allPlayers() { return this.playerMap.values (); }
	public AgotPlayer getPlayer (String username) { return this.playerMap.get (username); }
	
	private AgotPlayer firstPlayer;
	@GraphQLQuery public AgotPlayer firstPlayer() { return firstPlayer; }
	public void setFirstPlayer (AgotPlayer firstPlayer, AgotContext context) {
		this.firstPlayer = firstPlayer;
		context.actions().setFirstPlayer(firstPlayer);
	}

	private ArrayList<AgotPlayer> players = new ArrayList<AgotPlayer> ();
	@Override public Stream<AgotPlayer> players () { return players.stream (); }
	public void forEachPlayer (Consumer<? super AgotPlayer> action) { players ().forEach (action); }
	public int getNumPlayers () { return players.size (); }
	public AgotPlayer initPlayer (AgotPlayer player) { players.add (player); playerMap.put (player.id(), player); return player; }
	public AgotPlayer getRandomPlayer () { return ListUtil.getRandom (players); }
	public Stream<TextCard<?>> inPlayTextCards () { return players ().flatMap (p -> p.inPlayTextCards ()); }
	public Stream<Card<?>> inPlayCards () { return players ().flatMap (p -> p.inPlayCards ()); }
	
	private ArrayList<GameLogRow> log = new ArrayList<GameLogRow> ();
	@GraphQLQuery public ArrayList<GameLogRow> log() { return this.log; }
	private GameLog logManager = new GameLog (log);
	public GameLog logManager() { return this.logManager; }
	
	private ArrayList<DelayedEffect> delayedEffects = new ArrayList<DelayedEffect> ();
	public void add (DelayedEffect delayedEffect) { delayedEffects.add (delayedEffect); }
	public Stream<DelayedEffect> delayedEffects () { return delayedEffects.stream (); }
	public void removeDelayedEffects () {
		Iterator<DelayedEffect> it = delayedEffects.iterator ();
		while (it.hasNext ()) {
			it.next ();
			// TODO conditions?
			it.remove ();
		} // while
	} // removeDelayedEffects
	public void removeDelayedEffect (DelayedEffect delEff) { delayedEffects.remove (delEff); }
	
	public AgotPlayer getNextPlayer (AgotPlayer activePlayer) { return activePlayer.getNextPlayer (); }
	
	private String round;
	@GraphQLQuery public String round() { return this.round; }
	public void setRound (String round, AgotContext context) { this.round = round; context.actions ().setPhase (round, phase, step); }
	
	private AngPhase phase;
	@GraphQLQuery public AngPhase phase() { return this.phase; }
	public void setPhase (AngPhase phase, AgotContext context) { this.phase = phase; context.actions ().setPhase (round, phase, step); }
	
	private String step;
	@GraphQLQuery public String step() { return this.step; }
	public void setStep (String step, AgotContext context) { this.step = step; context.actions ().setPhase (round, phase, step); }
	
	private Challenge challenge = null;
	public Challenge getChallenge () { return challenge; }
	public void setChallenge (Challenge challenge) { this.challenge = challenge; }
	public boolean isDuringChallenge () { return this.challenge != null; }
	
	private ArrayList<AngIcon> remainingChallenges;
	public Stream<AngIcon> remainingChallenges () { return remainingChallenges.stream (); }
	public void setRemainingChallenges (ArrayList<AngIcon> remainingChallenges) { this.remainingChallenges = remainingChallenges; }
	public boolean firstPlayerChallenge () { return remainingChallenges == null; }
	public void removeRemainingChallenge (AngIcon challenge) { remainingChallenges.remove (challenge); }
	
	/********************************************************************************/
	/****  LASTING ABILITIES  *******************************************************/
	/********************************************************************************/
	
	private ArrayList<LastingEffect> lastingEffects = new ArrayList<LastingEffect> ();
	
	public Stream<LastingEffect> lastingEffects () { return lastingEffects.stream (); }
	
	public void subscribe (AngLastingEffect angLastingEffect, AbilityContext ac) {
		lastingEffects.add (new LastingEffect (angLastingEffect, ac));
	} // subscribe
	
	public void unsubscribe (LastingEffect lastingEffect) {
		lastingEffects.remove (lastingEffect);
	} // unsubscribe
	
	/********************************************************************************/
	/****  CONS ABILITIES  **********************************************************/
	/********************************************************************************/
	
	private ArrayList<ConsAbility> consAbilities = new ArrayList<ConsAbility> ();
	private ArrayList<ConsAlignAbility> consAlignAbilities = new ArrayList<ConsAlignAbility> ();
	
	public Stream<ConsAbility> consAbilities () { return consAbilities.stream (); }
	public Stream<ConsAlignAbility> consAlignAbilities () { return consAlignAbilities.stream (); }
	
	public ConsAbility subscribe (AngConsAbility angConsAbility, TextCard<?> card) {
		IAngConsEffect effect = angConsAbility.getConsEffect ();
		ConsAbility consAbility;
		if (effect instanceof IAngConsAlignEffect) {
			ConsAlignAbility consAlignAbility = new ConsAlignAbility (angConsAbility, card);
			consAlignAbilities.add (consAlignAbility);
			consAbility = consAlignAbility;
		} else {
			consAbility = new ConsAbility (angConsAbility, card);
		} // if - else
		consAbilities.add (consAbility);
		return consAbility;
	} // subscribe
	
	public ConsAbility unsubscribe (AngConsAbility angConsAbility, TextCard<?> card) {
		Iterator<ConsAbility> consAbilityIt = consAbilities.iterator ();
		ConsAbility toReturn = null;
		while (toReturn == null) {
			ConsAbility ca = consAbilityIt.next ();
			if (ca.getAng () == angConsAbility && ca.getCard () == card) {
				consAbilityIt.remove ();
				toReturn = ca;
			} // if
		} // while
		return toReturn;
	} // unsubscribe
	
	/********************************************************************************/
	/****  ABILITY COUNTERS  ********************************************************/
	/********************************************************************************/
	
	private HashMap<Long, HashMap<Long, Integer>> roundAbilityMap = null;
	private HashMap<Long, HashMap<Long, Integer>> phaseAbilityMap = null;
	private HashMap<String, HashMap<Long, Integer>> roundEventMap = null;
	private HashMap<String, HashMap<Long, Integer>> phaseEventMap = null;
	
	public void resetRoundAbilityCounter () { roundAbilityMap = null; }
	public void resetRoundEventCounter () { roundEventMap = null; }
	
	public void initPhaseCounters () { phaseAbilityMap = null; phaseEventMap = null; }
	
	public void registerAbility (AngTrigAbility trigAbility, MarshallCard<?> card) {
		{
			if (roundAbilityMap == null) { roundAbilityMap = new HashMap<Long, HashMap<Long, Integer>> (); }
			HashMap<Long, Integer> cardAbilities = roundAbilityMap.get (card.id ());
			if (cardAbilities == null) { cardAbilities = new HashMap<Long, Integer> (); roundAbilityMap.put (card.id (), cardAbilities); }
			int counter = cardAbilities.getOrDefault (trigAbility.getId (), 0);
			cardAbilities.put (trigAbility.getId (), counter + 1);
		}
		{
			if (phaseAbilityMap == null) { phaseAbilityMap = new HashMap<Long, HashMap<Long, Integer>> (); }
			HashMap<Long, Integer> cardAbilities = phaseAbilityMap.get (card.id ());
			if (cardAbilities == null) { cardAbilities = new HashMap<Long, Integer> (); phaseAbilityMap.put (card.id (), cardAbilities); }
			int counter = cardAbilities.getOrDefault (trigAbility.getId (), 0);
			cardAbilities.put (trigAbility.getId (), counter + 1);
		}
	} // registerAbility

	public void registerEvent (AngEventCard event, AgotPlayer player) {
		{
			if (roundEventMap == null) { roundEventMap = new HashMap<String, HashMap<Long, Integer>> (); }
			HashMap<Long, Integer> playerEvents = roundEventMap.get (player.id ());
			if (playerEvents == null) { playerEvents = new HashMap<Long, Integer> (); roundEventMap.put (player.id (), playerEvents); }
			int counter = playerEvents.getOrDefault (event.getId (), 0);
			playerEvents.put (event.getId (), counter + 1);
		}
		{
			if (phaseEventMap == null) { phaseEventMap = new HashMap<String, HashMap<Long, Integer>> (); }
			HashMap<Long, Integer> playerEvents = phaseEventMap.get (player.id ());
			if (playerEvents == null) { playerEvents = new HashMap<Long, Integer> (); phaseEventMap.put (player.id (), playerEvents); }
			int counter = playerEvents.getOrDefault (event.getId (), 0);
			playerEvents.put (event.getId (), counter + 1);
		}
	} // registerAbility
	
	public int getRoundCounter (AngTrigAbility trigAbility, MarshallCard<?> card) {
		if (roundAbilityMap == null) { return 0; }
		HashMap<Long, Integer> cardAbilities = roundAbilityMap.get (card.id ());
		if (cardAbilities == null) { return 0; }
		return cardAbilities.getOrDefault (trigAbility.getId (), 0);
	} // getRoundCounter

	public int getPhaseCounter (AngTrigAbility trigAbility, MarshallCard<?> card) {
		if (phaseAbilityMap == null) { return 0; }
		HashMap<Long, Integer> cardAbilities = phaseAbilityMap.get (card.id ());
		if (cardAbilities == null) { return 0; }
		return cardAbilities.getOrDefault (trigAbility.getId (), 0);
	} // getPhaseCounter

	public int getRoundCounter (AngEventCard event, AgotPlayer player) {
		if (roundEventMap == null) { return 0; }
		HashMap<Long, Integer> cardAbilities = roundEventMap.get (player.id ());
		if (cardAbilities == null) { return 0; }
		return cardAbilities.getOrDefault (event.getId (), 0);
	} // getRoundCounter
	
	public int getPhaseCounter (AngEventCard event, AgotPlayer player) {
		if (phaseEventMap == null) { return 0; }
		HashMap<Long, Integer> cardAbilities = phaseEventMap.get (player.id ());
		if (cardAbilities == null) { return 0; }
		return cardAbilities.getOrDefault (event.getId (), 0);
	} // getPhaseCounter
	
	/********************************************************************************/
	/****  PREPARATION  *************************************************************/
	/********************************************************************************/
	
	public void prepare (AgotContext context) {
		Iterator<AgotPlayer> plaIt = players ().iterator ();
		AgotPlayer firstPlayer = plaIt.next ();
		AgotPlayer player = firstPlayer;
		while (plaIt.hasNext ()) {
			AgotPlayer nextPlayer = plaIt.next ();
			player.setNextPlayer (nextPlayer);
			player.shuffleDeck ();
			player = nextPlayer;
		} // while
		player.setNextPlayer (firstPlayer);
		setFirstPlayer (getRandomPlayer (), context);
	} // prepareGame
	
	public FactionCard initFaction (AgotPlayer player, AngFaction faction) {
		var card = new FactionCard (AngFaction.init (faction), player);
		this.cardMap.put (card.id (), card);
		return card;
	}
	
	public TextCard<?>[] initCard (AgotPlayer player, AgotCardSeed init, int qty) {
		var initializer = new CardInitializer (player);
		var toReturn = new TextCard<?>[qty];
		for (int i = 0; i < qty; i++) {
			var ang = AgotCardCreator.init(init);
			ang.accept (initializer);
			var card = initializer.card;
			this.cardMap.put (card.id (), card);
			toReturn[i] = card;
		}
		return toReturn;
	}
	
	private static class CardInitializer implements AngTextCardVisitor {
		private AgotPlayer player;
		private TextCard<?> card;
		public CardInitializer (AgotPlayer player) {
			this.player = player;
		} // CardInitializer
		@Override public void visit (AngPlotCard ang) { card = new PlotCard (ang, player); }
		@Override public void visit (AngAgendaCard ang) { card = new AgendaCard (ang, player); }
		@Override public void visit (AngEventCard ang) { card = new EventCard (ang, player); }
		@Override public void visit (AngAttachmentCard ang) { card = new AttachmentCard (ang, player); }
		@Override public void visit (AngLocationCard ang) { card = new LocationCard (ang, player); }
		@Override public void visit (AngCharacterCard ang) { card = new CharacterCard (ang, player); }
	} // CardInitializer

	private boolean started = false;
	@GraphQLQuery public boolean started() { return this.started; }
	public void setStarted(boolean started, AgotContext context) {
		this.started = started;
		context.actions().setGameStarted(started);
	}
	
} // Game
