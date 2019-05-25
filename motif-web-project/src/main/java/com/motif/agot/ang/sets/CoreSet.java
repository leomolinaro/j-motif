package com.motif.agot.ang.sets;

import java.util.HashMap;

import com.motif.agot.ang.cards.AngAgendaCard;
import com.motif.agot.ang.cards.AngAttachmentCard;
import com.motif.agot.ang.cards.AngCharacterCard;
import com.motif.agot.ang.cards.AngEventCard;
import com.motif.agot.ang.cards.AngLocationCard;
import com.motif.agot.ang.cards.AngPlotCard;
import com.motif.agot.ang.cards.AngTextCard;
import com.motif.agot.ang.cards.AngCharacterCard.IcB;
import com.motif.agot.ang.enums.AngArea;
import com.motif.agot.ang.enums.AngFaction;
import com.motif.agot.ang.enums.AngIcon;
import com.motif.agot.ang.enums.AngKeyword;
import com.motif.agot.ang.enums.AngPhase;
import com.motif.agot.ang.enums.AngToken;
import com.motif.agot.ang.enums.AngTrait;
import com.motif.agot.ang.text.AngTextKeyword;
import com.motif.agot.ang.text.AngAction.AB;
import com.motif.agot.ang.text.AngConsAbility.CAB;
import com.motif.agot.ang.text.AngInterrupt.IB;
import com.motif.agot.ang.text.AngReaction.RB;
import com.motif.agot.ang.text.AngText.TB;
import com.motif.agot.ang.text.AngWhenRevealed.WRB;
import com.motif.agot.ang.text.consconditions.AngAPlayerControls;
import com.motif.agot.ang.text.consconditions.AngYouAreTheFirstPlayer;
import com.motif.agot.ang.text.conseffects.AngConsEffects;
import com.motif.agot.ang.text.conseffects.AngConsEffects.*;
import com.motif.agot.ang.text.filters.AngCardFilter.CFB;
import com.motif.agot.ang.text.filters.AngChallengeFilter.ChFB;
import com.motif.agot.ang.text.filters.AngPlayerFilter.PFB;

public enum CoreSet implements AgotSetCard {
   /**
 	* A Clash of Kings
 	* Neutral.
 	* Plot. Income: 4. Initiative: 9. Claim: 1. Reserve: 6. Plot deck limit: 2.
 	* Noble.
 	* Reaction: After you win a  challenge, move 1 power from the losing opponent's faction card to your own.
 	* Core Set #1.
  	*/A_CLASH_OF_KINGS,
   /**
  	* A Feast for Crows
  	* Neutral.
  	* Plot. Income: 6. Initiative: 1. Claim: 1. Reserve: 4. Plot deck limit: 1.
  	* Edict.
  	* Reaction: After you win dominance, gain 2 power for your faction.
  	* Core Set #2.
  	*/A_FEAST_FOR_CROWS,
  	A_GAME_OF_THRONES, A_NOBLE_CAUSE, A_STORM_OF_SWORDS, BUILDING_ORDERS, CALLING_THE_BANNERS, CALM_OVER_WESTEROS,
	CONFISCATION, COUNTING_COPPERS, FILTHY_ACCUSATIONS, FORTIFIED_POSITION, HEADS_ON_SPIKES, JOUSTING_CONTEST, MARCHED_TO_THE_WALL, MARCHING_ORDERS, 
	NAVAL_SUPERIORITY, POWER_BEHIND_THE_THRONE, REBUILDING, REINFORCEMENTS, SNEAK_ATTACK, SUMMONS, SUPPORTING_THE_FAITH, TAXATION, 
	THE_WINDS_OF_WINTER, WILDFIRE_ASSAULT,

	LITTLEFINGER, VARYS, RATTLESHIRTS_RAIDERS, WILDLING_HORDE,
	MAESTER_CRESSEN, MELISANDRE, ROBERT_BARATHEON, SELYSE_BARATHEON, SER_DAVOS_SEAWORTH, SHIREEN_BARATHEON, STANNIS_BARATHEON,
	BASTARD_IN_HIDING, FIERY_FOLLOWERS, KINGS_HUNTING_PARTY, DRAGONSTONE_FAITHFUL, VANGUARD_LANCER,
	AERON_DAMPHAIR, ALANNYS_GREYJOY, ASHA_GREYJOY, BALON_GREYJOY, EURON_CROWS_EYE, MAESTER_WENDAMYR, THEON_GREYJOY,
	BLACK_WINDS_CREW, DROWNED_MEN, IRON_ISLANDS_FISHMONGER, LORDSPORT_SHIPWRIGHT, SALTY_NAVIGATOR,
	CERSEI_LANNISTER, GRAND_MAESTER_PYCELLE, JOFFREY_BARATHEON, SER_JAIME_LANNISTER, THE_TICKLER, TYRION_LANNISTER, TYWIN_LANNISTER,
	BURNED_MEN, GOLD_CLOAKS, LANNISPORT_MONEYLENDER, LANNISPORT_MERCHANT, THE_QUEENS_ASSASSIN,
	AREO_HOTAH, ARIANNE_MARTELL, DORAN_MARTELL, EDRIC_DAYNE, MAESTER_CALEOTTE, OBARA_SAND, THE_RED_VIPER,
	DESERT_SCAVENGER, DORNISH_PARAMOUR, GREENBLOOD_TRADER, HOUSE_DAYNE_KNIGHT, PALACE_SPEARMAN,
	BENJEN_STARK, GHOST, JON_SNOW, MAESTER_AEMON, OLD_BEAR_MORMONT, SAMWELL_TARLY, SER_WAYMAR_ROYCE, YOREN,
	MESSENGER_RAVEN, OLD_FOREST_HUNTER, RANGING_PARTY, STEWARD_AT_THE_WALL, VETERAN_BUILDER,
	ARYA_STARK, BRAN_STARK, CATELYN_STARK, EDDARD_STARK, GREY_WIND, ROBB_STARK, SANSA_STARK, SUMMER,
	DIREWOLF_PUP, TUMBLESTONE_KNIGHT, VANGUARD_OF_THE_NORTH, WINTERFELL_STEWARD,
	DAENERYS_TARGARYEN, DROGON, KHAL_DROGO, MAGISTER_ILLYRIO, RHAEGAL, SER_JORAH_MORMONT, VISERION, VISERYS_TARGARYEN,
	BRAIDED_WARRIOR, HANDMAIDEN, TARGARYEN_LOYALIST, UNSULLIED,
	LEFT, MAESTER_LOMYS, MARGAERY_TYRELL, PAXTER_REDWYNE, RANDYLL_TARLY, RIGHT, THE_KNIGHT_OF_FLOWERS, THE_QUEEN_OF_THORNS,
	COURTESAN_OF_THE_ROSE, GARDEN_CARETAKER, OLENNAS_INFORMANT, WARDENS_OF_THE_REACH,

	PUT_TO_THE_SWORD, PUT_TO_THE_TORCH, SUPERIOR_CLAIM, TEARS_OF_LYS, THE_HANDS_JUDGMENT,
	CONSOLIDATION_OF_POWER, OURS_IS_THE_FURY, SEEN_IN_FLAMES,
	RISEN_FROM_THE_SEA, THE_KRAKENS_GRASP, WE_DO_NOT_SOW,
	HEAR_ME_ROAR, THE_THINGS_I_DO_FOR_LOVE, TREACHERY,
	DORANS_GAME, UNBOWED_UNBENT_UNBROKEN, CONFINEMENT,
	A_MEAGER_CONTRIBUTION, TAKE_THE_BLACK, THE_SWORD_IN_THE_DARKNESS,
	FOR_THE_NORTH, LIKE_WARM_RAIN, WINTER_IS_COMING,
	DRACARYS, FIRE_AND_BLOOD, WAKING_THE_DRAGON,
	GROWING_STRONG, OLENNAS_CUNNING, THE_BEAR_AND_THE_MAIDEN_FAIR,

	THE_IRON_THRONE, THE_KINGSROAD, THE_ROSEROAD,
	DRAGONSTONE_PORT, CHAMBER_OF_THE_PAINTED_TABLE, THE_RED_KEEP,
	GREAT_KRAKEN, IRON_FLEET_SCOUT, SEA_TOWER,
	CASTERLY_ROCK, LANNISPORT, WESTERN_FIEFDOM,
	GHASTON_GREY, SUNSPEAR, BLOOD_ORANGE_GROVE,
	CASTLE_BLACK, THE_WALL,
	GATES_OF_WINTERFELL, THE_WOLFSWOOD, HEART_TREE_GROVE,
	PLAZA_OF_PUNISHMENT, DOTHRAKI_SEA, ILLYRIOS_ESTATE,
	HIGHGARDEN, THE_MANDER, ROSE_GARDEN,

	SEAL_OF_THE_HAND, BODYGUARD, LITTLE_BIRD, MILK_OF_THE_POPPY,
	NOBLE_LINEAGE, SYRIOS_TRAINING,
	LIGHTBRINGER, THROWING_AXE, WIDOWS_WAIL, DAWN,
	LONGCLAW, ICE, DROGOS_ARAKH, HEARTSBANE, 
	
	FEALTY, BANNER_OF_THE_STAG, BANNER_OF_THE_KRAKEN, BANNER_OF_THE_LION, BANNER_OF_THE_SUN, 
	BANNER_OF_THE_WATCH, BANNER_OF_THE_WOLF, BANNER_OF_THE_DRAGON, BANNER_OF_THE_ROSE;
	
	private static HashMap<CoreSet, AngTextCard> cardCache;
	
	public static AngTextCard init (CoreSet cardSeed) {
		if (cardCache == null) { cardCache = new HashMap<CoreSet, AngTextCard> (); }
		AngTextCard card = cardCache.get (cardSeed);
		if (card == null) {
			card = create (cardSeed);
			cardCache.put (cardSeed, card);
		} // if
		return card;
	} // init
	
	private static AngTextCard create (CoreSet card) {
		boolean loyal = true;
		boolean noLoy = false;
		boolean unique = true;
		boolean noUniq = false;
		switch (card) {
			/* DONE */case A_CLASH_OF_KINGS: return new AngPlotCard(card, 1, "A Clash of Kings", AngFaction.NEUTRAL, noLoy, 4, 9, 1, 6,
				        TB.i().traits(AngTrait.NOBLE).reaction(RB.i().afterYouWinAChallenge(ChFB.i().power()).movePowersFromAFactionToAFaction(1, PFB.i().theLoosingOpponent(), PFB.i().you())));
			/* DONE */case A_FEAST_FOR_CROWS: return new AngPlotCard(card, 2, "A Feast for Crows", AngFaction.NEUTRAL, noLoy, 6, 1, 1, 4, 
						TB.i().traits (AngTrait.EDICT).reaction (RB.i ().afterYouWinDominance ().gainPowerForYourFaction (2)));
			case A_GAME_OF_THRONES: return new AngPlotCard (card, 3, "A Game of Thrones", AngFaction.NEUTRAL, noLoy, 4, 2, 1, 6, TB.i ());
			case A_NOBLE_CAUSE: return new AngPlotCard (card, 4, "A Noble Cause", AngFaction.NEUTRAL, noLoy, 5, 0, 1, 6, TB.i ());
			/*DONE*/case A_STORM_OF_SWORDS: return new AngPlotCard (card, 5, "A Storm of Swords", AngFaction.NEUTRAL, noLoy, 3, 8, 1, 5,
					TB.i ().traits (AngTrait.WAR).consAbility (CAB.i ().youMayInitiateAnAdditionalChallengeDuringTheChallengePhase (AngIcon.MILITARY)));
			case BUILDING_ORDERS: return new AngPlotCard (card, 6, "Building Orders", AngFaction.NEUTRAL, noLoy, 4, 1, 1, 7, TB.i ());
			case CALLING_THE_BANNERS: return new AngPlotCard (card, 7, "Calling the Banners", AngFaction.NEUTRAL, noLoy, 3, 6, 1, 6,
					TB.i ().traits (AngTrait.KINGDOM).whenRevealed (WRB.i ().chooseAPlayer (PFB.i ().anOpponent ()).andGainNGold (1, CFB.i ().character ().targetControl ())));
			case CALM_OVER_WESTEROS: return new AngPlotCard (card, 8, "Calm Over Westeros", AngFaction.NEUTRAL, noLoy, 5, 3, 1, 6, TB.i ());
			case CONFISCATION: return new AngPlotCard (card, 9, "Confiscation", AngFaction.NEUTRAL, noLoy, 4, 5, 1, 6, TB.i ());
			/*DONE*/case COUNTING_COPPERS: return new AngPlotCard (card, 10, "Counting Coppers", AngFaction.NEUTRAL, noLoy, 2, 3, 1, 10,
					TB.i ().traits (AngTrait.KINGDOM).whenRevealed (WRB.i ().drawNCards (3)));
			/*DONE*/case FILTHY_ACCUSATIONS: return new AngPlotCard (card, 11, "Filthy Accusations", AngFaction.NEUTRAL, noLoy, 4, 4, 1, 6,
					TB.i ().traits (AngTrait.SCHEME).whenRevealed (WRB.i ().chooseACard (CFB.i ().character ()).andKneelIt ()));
			/*DONE*/case FORTIFIED_POSITION: return new AngPlotCard (card, 12, "Fortified Position", AngFaction.NEUTRAL, noLoy, 5, 1, 1, 5,
					TB.i ().traits (AngTrait.SIEGE, AngTrait.WAR).consAbility (CAB.i ().treatEachCardAsIfItsPrintedTextBoxWereBlackExceptForTrait (CFB.i ().character ())) );
			case HEADS_ON_SPIKES: return new AngPlotCard (card, 13, "Heads on Spikes", AngFaction.NEUTRAL, noLoy, 4, 6, 1, 6, TB.i ());
			/*DONE*/case JOUSTING_CONTEST: return new AngPlotCard (card, 14, "Jousting Contest", AngFaction.NEUTRAL, noLoy, 4, 3, 1, 6,
					TB.i ().traits (AngTrait.WAR).consAbility (CAB.i ().eachPlayerCannotDeclareMoreThanNCharactersInEachChallenge (1, PFB.i (), null)));
			case MARCHED_TO_THE_WALL: return new AngPlotCard (card, 15, "Marched to the Wall", AngFaction.NEUTRAL, noLoy, 4, 8, 1, 5,
					TB.i ().traits (AngTrait.EDICT));
			/*DONE*/case MARCHING_ORDERS: return new AngPlotCard (card, 16, "Marching Orders", AngFaction.NEUTRAL, noLoy, 9, 3, 1, 4,
					TB.i ().traits (AngTrait.EDICT, AngTrait.WAR).consAbility (CAB.i ().youCannotMarshallOrPlay (CFB.i ().attachment ().location ().event ())));
			/*DONE*/case NAVAL_SUPERIORITY: return new AngPlotCard (card, 17, "Naval Superiority", AngFaction.NEUTRAL, noLoy, 2, 7, 1, 6,
					TB.i ().traits (AngTrait.SIEGE, AngTrait.WAR).consAbility (CAB.i ().treatTheBaseGoldValueOfEachCardAsIfItWereN (CFB.i ().revealed ().plot ().traits (AngTrait.KINGDOM, AngTrait.EDICT), 0)));
			/*DONE*/case POWER_BEHIND_THE_THRONE: return new AngPlotCard (card, 18, "Power Behind the Throne", AngFaction.NEUTRAL, noLoy, 3, 1, 1, 6,
					TB.i ().traits (AngTrait.NOBLE, AngTrait.SCHEME).whenRevealed (WRB.i ().placeOneTokenOnThis (AngToken.STAND)).action (AB.i ().discardATokenFromThisTo (AngToken.STAND).chooseACard (CFB.i ().character ()).andStandIt ()));
			case REBUILDING: return new AngPlotCard (card, 19, "Rebuilding", AngFaction.NEUTRAL, noLoy, 5, 5, 1, 6, TB.i ());
			/*DONE*/case REINFORCEMENTS: return new AngPlotCard (card, 20, "Reinforcements", AngFaction.NEUTRAL, noLoy, 1, 0, 1, 6,
					TB.i ().traits (AngTrait.KINGDOM, AngTrait.WAR).whenRevealed (WRB.i ().chooseACard (CFB.i ().character ().withPrintedCostOrLower (5).inYourArea (AngArea.HAND, AngArea.DISCARD_PILE)).andPutItIntoPlay ()));
			/*DONE*/case SNEAK_ATTACK: return new AngPlotCard (card, 21, "Sneak Attack", AngFaction.NEUTRAL, noLoy, 5, 11, 2, 5,
					TB.i ().traits (AngTrait.SCHEME).consAbility (CAB.i ().youCannotInitiateMoreThanNChallengesDuringTheChallengePhase (1)));
			case SUMMONS: return new AngPlotCard (card, 22, "Summons", AngFaction.NEUTRAL, noLoy, 4, 0, 1, 7, TB.i ());
			case SUPPORTING_THE_FAITH: return new AngPlotCard (card, 23, "Supporting the Faith", AngFaction.NEUTRAL, noLoy, 6, 2, 1, 4, TB.i ());
			case TAXATION: return new AngPlotCard (card, 24, "Taxation", AngFaction.NEUTRAL, noLoy, 5, 6, 1, 6, TB.i ());
			/*DONE*/case THE_WINDS_OF_WINTER: return new AngPlotCard (card, 25, "The Winds of Winter", AngFaction.NEUTRAL, noLoy, 3, 4, 2, 5,
					TB.i ().traits (AngTrait.WINTER));
			case WILDFIRE_ASSAULT: return new AngPlotCard (card, 26, "Wildfire Assault", AngFaction.NEUTRAL, noLoy, 4, 7, 1, 6, TB.i ());
			case FEALTY: return new AngAgendaCard (card, 27, "Fealty", AngFaction.NEUTRAL, TB.i ());
			/*DONE*/case LITTLEFINGER: return new AngCharacterCard (card, 28, "Littlefinger", AngFaction.NEUTRAL, noLoy, 5, unique, new IcB ().intrigue ().power (), 4,
					TB.i ().traits (AngTrait.ALLY, AngTrait.LORD, AngTrait.SMALL_COUNCIL).gold (1).reaction (RB.i ().afterYouMarshallThis ().drawNCards (2)));
			/*DONE*/case VARYS: return new AngCharacterCard (card, 29, "Varys", AngFaction.NEUTRAL, noLoy, 6, unique, new IcB ().intrigue (), 3,
					TB.i ().traits (AngTrait.LORD, AngTrait.SMALL_COUNCIL, AngTrait.SPY).stealth ().interrupt (new IB ().whenThePhaseEnds (AngPhase.DOMINANCE).removeThisFromTheGameTo ().discardEachFromPlay (CFB.i ().character ())));
			case RATTLESHIRTS_RAIDERS: return new AngCharacterCard (card, 30, "Rattleshirt's Raiders", AngFaction.NEUTRAL, noLoy, 4, noUniq, new IcB ().military (), 3,
					TB.i ().noAttachments ());
			case WILDLING_HORDE: return new AngCharacterCard (card, 31, "Wildling Horde", AngFaction.NEUTRAL, noLoy, 5, noUniq, new IcB ().military ().power (), 5,
					TB.i ().noAttachments ().pillage ());
			/*DONE*/case SEAL_OF_THE_HAND: return new AngAttachmentCard (card, 32, "Seal of the Hand", AngFaction.NEUTRAL, noLoy, 3, unique,
					TB.i ().traits (AngTrait.ITEM).only (CFB.i ().character ().traits (AngTrait.LADY, AngTrait.LORD)).action (AB.i ().kneelThisTo ().standAttached ()));
			/*DONE*/case BODYGUARD: return new AngAttachmentCard (card, 33, "Bodyguard", AngFaction.NEUTRAL, noLoy, 1, noUniq,
					TB.i ().traits (AngTrait.CONDITION).only (CFB.i ().character ().traits (AngTrait.LADY, AngTrait.LORD)).interrupt (new IB ().whenAttachedWouldBeKilledOrDiscardFromPlay ().sacrificeThisTo ().saveIt ()));
			/*DONE*/case LITTLE_BIRD: return new AngAttachmentCard (card, 34, "Little Bird", AngFaction.NEUTRAL, noLoy, 1, noUniq,
					TB.i ().traits (AngTrait.CONDITION).consAbility (CAB.i ().attachedGainsAnIcon (AngIcon.INTRIGUE)));
			case MILK_OF_THE_POPPY: return new AngAttachmentCard (card, 35, "Milk of the Poppy", AngFaction.NEUTRAL, noLoy, 1, noUniq,
					TB.i ().terminal ());
			/*DONE*/case NOBLE_LINEAGE: return new AngAttachmentCard (card, 36, "Noble Lineage", AngFaction.NEUTRAL, noLoy, 0, noUniq,
					TB.i ().traits (AngTrait.CONDITION).consAbility (CAB.i ().attachedGainsAnIcon (AngIcon.POWER)));
			/*DONE*/case SYRIOS_TRAINING: return new AngAttachmentCard (card, 37, "Syrio's Training", AngFaction.NEUTRAL, noLoy, 1, noUniq,
					TB.i ().traits (AngTrait.CONDITION).consAbility (CAB.i ().attachedGainsAnIcon (AngIcon.MILITARY)));
			/*DONE*/case THE_IRON_THRONE: return new AngLocationCard (card, 38, "The Iron Throne", AngFaction.NEUTRAL, noLoy, 2, unique,
					TB.i ().reserve (1).consAbility (CAB.i ().addStrengthToYourTotalForDominance (8)));
			case THE_KINGSROAD: return new AngLocationCard (card, 39, "The Kingsroad", AngFaction.NEUTRAL, noLoy, 1, noUniq, TB.i ().limited ().initiative (1));
			/*DONE*/case THE_ROSEROAD: return new AngLocationCard (card, 40, "The Roseroad", AngFaction.NEUTRAL, noLoy, 0, noUniq,
					TB.i ().traits (AngTrait.WESTEROS).limited ().gold (1));
			case PUT_TO_THE_SWORD: return new AngEventCard (card, 41, "Put to the Sword", AngFaction.NEUTRAL, noLoy, 2, TB.i ());
			case PUT_TO_THE_TORCH: return new AngEventCard (card, 42, "Put to the Torch", AngFaction.NEUTRAL, noLoy, 1, TB.i ());
			case SUPERIOR_CLAIM: return new AngEventCard (card, 43, "Superior Claim", AngFaction.NEUTRAL, noLoy, 0, TB.i ());
			case TEARS_OF_LYS: return new AngEventCard (card, 44, "Tears of Lys", AngFaction.NEUTRAL, noLoy, 1, TB.i ());
			case THE_HANDS_JUDGMENT: return new AngEventCard (card, 45, "The Hand's Judgment", AngFaction.NEUTRAL, noLoy, null, TB.i ());
			case MAESTER_CRESSEN: return new AngCharacterCard (card, 46, "Maester Cressen", AngFaction.BARATHEON, noLoy, 3, unique, new IcB ().power (), 3, TB.i ());
			/*DONE*/case MELISANDRE: return new AngCharacterCard (card, 47, "Melisandre", AngFaction.BARATHEON, noLoy, 5, unique, new IcB ().intrigue ().power (), 4,
					TB.i ().traits (AngTrait.LADY, AngTrait.RHLLOR).reaction (RB.i ().afterYouMarshallOrPlayACard (CFB.i ().traits (AngTrait.RHLLOR)).chooseACard (CFB.i ().character ()).andKneelIt ().limitPerRound (1)));
			case ROBERT_BARATHEON: return new AngCharacterCard (card, 48, "Robert Baratheon", AngFaction.BARATHEON, loyal, 7, unique, new IcB ().military ().power (), 5, TB.i ().intimidate ().renown ());
			case SELYSE_BARATHEON: return new AngCharacterCard (card, 49, "Selyse Baratheon", AngFaction.BARATHEON, noLoy, 3, unique, new IcB ().intrigue ().power (), 2, TB.i ());
			/*DONE*/case SER_DAVOS_SEAWORTH: return new AngCharacterCard (card, 50, "Ser Davos Seaworth", AngFaction.BARATHEON, noLoy, 4, unique, new IcB ().military ().power (), 3,
					TB.i ().traits (AngTrait.KNIGHT, AngTrait.SMUGGLER).stealth ().interrupt (new IB ().whenThisIsKilled ().returnThisToYourHand ().insteadOfPlacingThisInYourDeadPile ()));
			/*DONE*/case SHIREEN_BARATHEON: return new AngCharacterCard (card, 51, "Shireen Baratheon", AngFaction.BARATHEON, noLoy, 2, unique, new IcB ().power (), 1,
					TB.i ().traits (AngTrait.LADY).interrupt (new IB ().whenThisIsKilled ().chooseACard (CFB.i ().character ()).andKneelIt ()));
			/*DONE*/case STANNIS_BARATHEON: return new AngCharacterCard (card, 52, "Stannis Baratheon", AngFaction.BARATHEON, loyal, 6, unique, new IcB ().military ().power (), 5,
					TB.i ().traits (AngTrait.LORD, AngTrait.SMALL_COUNCIL).consAbility (CAB.i ().eachPlayerCannotStandMoreThanNCardsDuringTheStandingPhase (2, CFB.i ().character ())));
			/*DONE*/case BASTARD_IN_HIDING: return new AngCharacterCard (card, 53, "Bastard in Hiding", AngFaction.BARATHEON, noLoy, 2, noUniq, new IcB ().military ().power (), 2,
					TB.i ().traits (AngTrait.BASTARD));
			/*DONE*/case FIERY_FOLLOWERS: return new AngCharacterCard (card, 54, "Fiery Followers", AngFaction.BARATHEON, noLoy, 3, noUniq, new IcB ().military ().intrigue (), 2,
					TB.i ().traits (AngTrait.RHLLOR).reaction (RB.i ().afterPhaseBegins (AngPhase.DOMINANCE).standThis ()));
			/*DONE*/case KINGS_HUNTING_PARTY: return new AngCharacterCard (card, 55, "King's Hunting Party", AngFaction.BARATHEON, noLoy, 4, noUniq, new IcB ().military (), 6,
					TB.i ().traits (AngTrait.ARMY).noAttachments ().consAbility (CAB.i ().whileAnOpponentControls (CFB.i ().traits (AngTrait.KING).character ()).thisGainsAnIcon (AngIcon.INTRIGUE)));
			/*DONE*/case DRAGONSTONE_FAITHFUL: return new AngCharacterCard (card, 56, "Dragonstone Faithful", AngFaction.BARATHEON, noLoy, 1, noUniq, new IcB ().power (), 1,
					TB.i ().traits (AngTrait.ALLY).limited ().marshallingAction (AB.i ().kneelThisTo ().reduceTheCostOfTheNextCardYouMarshallThisPhaseByN (CFB.i ().baratheon ().character (), 1)));
			/*DONE*/case VANGUARD_LANCER: return new AngCharacterCard (card, 57, "Vanguard Lancer", AngFaction.BARATHEON, noLoy, 2, noUniq, new IcB ().military ().power (), 1,
					TB.i ().traits (AngTrait.HOUSE_FLORENT, AngTrait.KNIGHT).reaction (RB.i ().afterThisEntersPlay ().chooseACard (CFB.i ().opponent ().character ().faction ()).andDiscardNPowerFromThatCard (1)));
			/*DONE*/case LIGHTBRINGER: return new AngAttachmentCard (card, 58, "Lightbringer", AngFaction.BARATHEON, loyal, 2, unique,
					TB.i ().traits (AngTrait.RHLLOR, AngTrait.WEAPON).only (CFB.i ().baratheon ().character ()).consAbility (CAB.i ().ifAttachedIs (CFB.i ().title ("Stannis Baratheon")).attachedGains (AngKeyword.RENOWN)).reaction (RB.i ().afterAttachedGainsOneOrMorePower ().standAttached ().limitPerPhase (1)));
			/*DONE*/case DRAGONSTONE_PORT: return new AngLocationCard (card, 59, "Dragonstone Port", AngFaction.BARATHEON, noLoy, 0, noUniq,
					TB.i ().traits (AngTrait.DRAGONSTONE).limited ().marshallingAction (AB.i ().kneelThisTo ().reduceTheCostOfTheNextCardYouMarshallThisPhaseByN (CFB.i ().baratheon (), 1)));
			case CHAMBER_OF_THE_PAINTED_TABLE: return new AngLocationCard (card, 60, "Chamber of the Painted Table", AngFaction.BARATHEON, noLoy, 2, unique, TB.i ());
			case THE_RED_KEEP: return new AngLocationCard (card, 61, "The Red Keep", AngFaction.BARATHEON, loyal, 3, unique, TB.i ());
			case CONSOLIDATION_OF_POWER: return new AngEventCard (card, 62, "Consolidation of Power", AngFaction.BARATHEON, loyal, 1, TB.i ());
			case OURS_IS_THE_FURY: return new AngEventCard (card, 63, "Ours is the Fury", AngFaction.BARATHEON, loyal, 2, TB.i ());
			case SEEN_IN_FLAMES: return new AngEventCard (card, 64, "Seen In Flames", AngFaction.BARATHEON, noLoy, 1, TB.i ());
			case AERON_DAMPHAIR: return new AngCharacterCard (card, 65, "Aeron Damphair", AngFaction.GREYJOY, noLoy, 3, unique, new IcB ().power (), 3, TB.i ());
			case ALANNYS_GREYJOY: return new AngCharacterCard (card, 66, "Alannys Greyjoy", AngFaction.GREYJOY, noLoy, 3, unique, new IcB ().intrigue ().power (), 2, TB.i ());
			/*DONE*/case ASHA_GREYJOY: return new AngCharacterCard (card, 67, "Asha Greyjoy", AngFaction.GREYJOY, noLoy, 5, unique, new IcB ().military ().power (), 4,
					TB.i ().traits (AngTrait.IRONBORN, AngTrait.LADY).stealth ().reaction (RB.i ().afterYouWinAChallenge (ChFB.i ().unopposed ().inWhichThisIsPartecipating ()).standThis ()));
			case BALON_GREYJOY: return new AngCharacterCard (card, 68, "Balon Greyjoy", AngFaction.GREYJOY, loyal, 6, unique, new IcB ().military ().power (), 5,
					TB.i ().traits (AngTrait.IRONBORN, AngTrait.LORD).renown ());
			case EURON_CROWS_EYE: return new AngCharacterCard (card, 69, "Euron Crow's Eye", AngFaction.GREYJOY, loyal, 7, unique, new IcB ().military ().intrigue ().power (), 6, TB.i ());
			/*DONE*/case MAESTER_WENDAMYR: return new AngCharacterCard (card, 70, "Maester Wendamyr", AngFaction.GREYJOY, noLoy, 2, unique, new IcB ().power (), 2,
					TB.i ().traits (AngTrait.MAESTER).stealth ());
			/*DONE*/case THEON_GREYJOY: return new AngCharacterCard (card, 71, "Theon Greyjoy", AngFaction.GREYJOY, noLoy, 4, unique, new IcB ().military ().power (), 3,
					TB.i ().traits (AngTrait.ALLY, AngTrait.IRONBORN, AngTrait.LORD).stealth ().reaction (RB.i ().afterYouWinAChallenge (ChFB.i ().unopposed ().inWhichThisIsPartecipating ()).thisGainsNPower (1)));
			/*DONE*/case BLACK_WINDS_CREW: return new AngCharacterCard (card, 72, "Black Wind's Crew", AngFaction.GREYJOY, noLoy, 3, noUniq, new IcB ().military ().power (), 3,
					TB.i ().traits (AngTrait.IRONBORN, AngTrait.RAIDERS).pillage ());
			/*DONE*/case DROWNED_MEN: return new AngCharacterCard (card, 73, "Drowned Men", AngFaction.GREYJOY, noLoy, 4, noUniq, new IcB ().military ().power (), 3,
					TB.i ().traits (AngTrait.ARMY, AngTrait.DROWNED_GOD).noAttachments ().consAbility (CAB.i ().thisGetsStrength (1).forEach (CFB.i ().traits (AngTrait.WARSHIP).location ().youControl ())));
			/*DONE*/case IRON_ISLANDS_FISHMONGER: return new AngCharacterCard (card, 74, "Iron Islands Fishmonger", AngFaction.GREYJOY, noLoy, 1, noUniq, new IcB ().power (), 1,
					TB.i ().traits (AngTrait.ALLY, AngTrait.MERCHANT).marshallingAction (AB.i ().kneelThisTo ().reduceTheCostOfTheNextCardYouMarshallThisPhaseByN (CFB.i ().greyjoy ().character (), 1)));
			/*DONE*/case LORDSPORT_SHIPWRIGHT: return new AngCharacterCard (card, 75, "Lordsport Shipwright", AngFaction.GREYJOY, noLoy, 2, noUniq, new IcB ().intrigue (), 1,
					TB.i ().traits (AngTrait.ALLY, AngTrait.IRONBORN).marshallingAction (AB.i ().kneelThisTo ().chooseACard (CFB.i ().location ().withPrintedCostOrLower (2, new AngYouAreTheFirstPlayer (true), 3)).andKneelIt ()));
			/*DONE*/case SALTY_NAVIGATOR: return new AngCharacterCard (card, 76, "Salty Navigator", AngFaction.GREYJOY, noLoy, 2, noUniq, new IcB ().military (), 2,
					TB.i ().traits (AngTrait.IRONBORN).initiative (1));
			/*DONE*/case THROWING_AXE: return new AngAttachmentCard (card, 77, "Throwing Axe", AngFaction.GREYJOY, noLoy, 1, noUniq,
					TB.i ().traits (AngTrait.WEAPON).only (CFB.i ().character ().traits (AngTrait.IRONBORN)).reaction (RB.i ().afterYouWinAChallenge (ChFB.i ().inWhichAttachedIsPartecipatingAsAttacker ()).sacrificeThisTo ().chooseACard (CFB.i ().defending ().character ()).andKillIt ()));
			case GREAT_KRAKEN: return new AngLocationCard (card, 78, "Great Kraken", AngFaction.GREYJOY, loyal, 3, unique,
					TB.i ());
			/*DONE*/case IRON_FLEET_SCOUT: return new AngLocationCard (card, 79, "Iron Fleet Scout", AngFaction.GREYJOY, noLoy, 0, noUniq,
					TB.i ().traits (AngTrait.WARSHIP).challengesAction (AB.i ().kneelThisTo ().chooseACard (CFB.i ().greyjoy ().character ().partecipating ())
							.untilTheEndOfTheChallenge ().thatCardGetsStrength (1, 2, new AngYouAreTheFirstPlayer (true))));
			/*DONE*/case SEA_TOWER: return new AngLocationCard (card, 80, "Sea Tower", AngFaction.GREYJOY, noLoy, 0, noUniq,
					TB.i ().traits (AngTrait.IRON_ISLANDS).limited ().marshallingAction (AB.i ().kneelThisTo ().reduceTheCostOfTheNextCardYouMarshallThisPhaseByN (CFB.i ().greyjoy (), 1)));
			case RISEN_FROM_THE_SEA: return new AngEventCard (card, 81, "Risen from the Sea", AngFaction.GREYJOY, noLoy, 0,
					TB.i ());
			case THE_KRAKENS_GRASP: return new AngEventCard (card, 82, "The Kraken's Grasp", AngFaction.GREYJOY, loyal, 0,
					TB.i ());
			/*DONE*/case WE_DO_NOT_SOW: return new AngEventCard (card, 83, "We Do Not Sow", AngFaction.GREYJOY, loyal, 1,
					TB.i ().reaction (RB.i ().afterYouWinAChallenge (ChFB.i ().unopposed ()).chooseACard (CFB.i ().attachment ().location ().controlledByTheLosingOpponent ()).andDiscardItFromPlay ().maxPerChallenge (1)));
			case CERSEI_LANNISTER: return new AngCharacterCard (card, 84, "Cersei Lannister", AngFaction.LANNISTER, loyal, 4, unique, new IcB ().intrigue ().power (), 4, TB.i ());
			case GRAND_MAESTER_PYCELLE: return new AngCharacterCard (card, 85, "Grand Maester Pycelle", AngFaction.LANNISTER, loyal, 3, unique, new IcB ().intrigue ().power (), 2, TB.i ());
			case JOFFREY_BARATHEON: return new AngCharacterCard (card, 86, "Joffrey Baratheon", AngFaction.LANNISTER, noLoy, 3, unique, new IcB ().power (), 3, TB.i ());
			case SER_JAIME_LANNISTER: return new AngCharacterCard (card, 87, "Ser Jaime Lannister", AngFaction.LANNISTER, noLoy, 6, unique, new IcB ().military ().intrigue (), 5, TB.i ());
			case THE_TICKLER: return new AngCharacterCard (card, 88, "The Tickler", AngFaction.LANNISTER, noLoy, 2, unique, new IcB ().military ().intrigue (), 2, TB.i ());
			/*DONE*/case TYRION_LANNISTER: return new AngCharacterCard (card, 89, "Tyrion Lannister", AngFaction.LANNISTER, noLoy, 5, unique, new IcB ().intrigue ().power (), 4,
					TB.i ().traits (AngTrait.LORD).stealth ().reaction (RB.i ().afterAChallengeIsInitiated (ChFB.i ().intrigue ()).gainNGold (2, null)));
			case TYWIN_LANNISTER: return new AngCharacterCard (card, 90, "Tywin Lannister", AngFaction.LANNISTER, loyal, 7, unique, new IcB ().military ().intrigue ().power (), 6, TB.i ().traits (AngTrait.LORD).renown ().gold (2));
			/*DONE*/case BURNED_MEN: return new AngCharacterCard (card, 91, "Burned Men", AngFaction.LANNISTER, noLoy, 2, noUniq, new IcB ().military (), 2, TB.i ().traits (AngTrait.CLANSMAN).ambush (2));
			case GOLD_CLOAKS: return new AngCharacterCard (card, 92, "Gold Cloaks", AngFaction.LANNISTER, noLoy, 4, noUniq, new IcB ().military ().power (), 3, TB.i ());
			case LANNISPORT_MONEYLENDER: return new AngCharacterCard (card, 93, "Lannisport Moneylender", AngFaction.LANNISTER, noLoy, 2, noUniq, new IcB ().intrigue (), 2, TB.i ());
			/*DONE*/case LANNISPORT_MERCHANT: return new AngCharacterCard (card, 94, "Lannisport Merchant", AngFaction.LANNISTER, noLoy, 1, noUniq, new IcB ().power (), 1,
					TB.i ().traits (AngTrait.MERCHANT).limited ().gold (1));
			case THE_QUEENS_ASSASSIN: return new AngCharacterCard (card, 95, "The Queen's Assassin", AngFaction.LANNISTER, loyal, 2, noUniq, new IcB ().intrigue (), 2, TB.i ());
			case WIDOWS_WAIL: return new AngAttachmentCard (card, 96, "Widow's Wail", AngFaction.LANNISTER, noLoy, 1, unique, TB.i ());
			/*DONE*/case CASTERLY_ROCK: return new AngLocationCard (card, 97, "Casterly Rock", AngFaction.LANNISTER, loyal, 2, unique,
					TB.i ().traits (AngTrait.STRONGHOLD, AngTrait.THE_WESTERLANDS).consAbility (CAB.i ().youMayInitiateAnAdditionalChallengeDuringTheChallengePhase (AngIcon.INTRIGUE)));
			/*DONE*/case LANNISPORT: return new AngLocationCard (card, 98, "Lannisport", AngFaction.LANNISTER, loyal, 3, unique,
					TB.i ().traits (AngTrait.THE_WESTERLANDS).reaction (RB.i ().afterYouWinAChallenge (ChFB.i ().intrigue ()).drawNCards (1)));
			case WESTERN_FIEFDOM: return new AngLocationCard (card, 99, "Western Fiefdom", AngFaction.LANNISTER, noLoy, 0, noUniq, TB.i ());
			case HEAR_ME_ROAR: return new AngEventCard (card, 100, "Hear Me Roar!", AngFaction.LANNISTER, loyal, 1, TB.i ());
			case THE_THINGS_I_DO_FOR_LOVE: return new AngEventCard (card, 101, "The Things I Do For Love", AngFaction.LANNISTER, noLoy, null, TB.i ());
			case TREACHERY: return new AngEventCard (card, 102, "Treachery", AngFaction.LANNISTER, noLoy, 1, TB.i ());
			case AREO_HOTAH: return new AngCharacterCard (card, 103, "Areo Hotah", AngFaction.MARTELL, loyal, 3, unique, new IcB ().military (), 5, TB.i ());
			case ARIANNE_MARTELL: return new AngCharacterCard (card, 104, "Arianne Martell", AngFaction.MARTELL, noLoy, 5, unique, new IcB ().intrigue ().power (), 4, TB.i ());
			case DORAN_MARTELL: return new AngCharacterCard (card, 105, "Doran Martell", AngFaction.MARTELL, loyal, 6, unique, new IcB ().intrigue ().power (), 4, TB.i ());
			case EDRIC_DAYNE: return new AngCharacterCard (card, 106, "Edric Dayne", AngFaction.MARTELL, noLoy, 2, unique, new IcB (), 1, TB.i ());
			case MAESTER_CALEOTTE: return new AngCharacterCard (card, 107, "Maester Caleotte", AngFaction.MARTELL, noLoy, 3, unique, new IcB ().intrigue ().power (), 2, TB.i ());
			case OBARA_SAND: return new AngCharacterCard (card, 108, "Obara Sand", AngFaction.MARTELL, noLoy, 3, unique, new IcB ().military (), 3, TB.i ());
			case THE_RED_VIPER: return new AngCharacterCard (card, 109, "The Red Viper", AngFaction.MARTELL, loyal, 7, unique, new IcB ().military ().intrigue ().power (), 7, TB.i ());
			case DESERT_SCAVENGER: return new AngCharacterCard (card, 110, "Desert Scavenger", AngFaction.MARTELL, noLoy, 1, noUniq, new IcB ().power (), 1, TB.i ());
			case DORNISH_PARAMOUR: return new AngCharacterCard (card, 111, "Dornish Paramour", AngFaction.MARTELL, noLoy, 3, noUniq, new IcB ().intrigue (), 3, TB.i ());
			case GREENBLOOD_TRADER: return new AngCharacterCard (card, 112, "Greenblood Trader", AngFaction.MARTELL, loyal, 2, noUniq, new IcB ().intrigue (), 1, TB.i ());
			/*DONE*/case HOUSE_DAYNE_KNIGHT: return new AngCharacterCard (card, 113, "House Dayne Knight", AngFaction.MARTELL, noLoy, 2, noUniq, new IcB ().military ().intrigue (), 2,
					TB.i ().traits (AngTrait.HOUSE_DAYNE, AngTrait.KNIGHT));
			/*DONE*/case PALACE_SPEARMAN: return new AngCharacterCard (card, 114, "Palace Spearman", AngFaction.MARTELL, noLoy, 4, noUniq, new IcB ().military ().power (), 4,
					TB.i ().traits (AngTrait.GUARD).noAttachments ().consAbility (CAB.i ().whileYouAreNotTheFirstPlayer ().thisGainsAnIcon (AngIcon.INTRIGUE)));
			/*DONE*/case DAWN: return new AngAttachmentCard (card, 115, "Dawn", AngFaction.MARTELL, noLoy, 2, unique,
					TB.i ().traits (AngTrait.WEAPON).consAbility (CAB.i ().attachedGetsStrength (1).forEach (CFB.i ().inYourArea (AngArea.USED_PLOT_PILE))).consAbility (CAB.i ().whileAttachedIs (CFB.i ().traits (AngTrait.HOUSE_DAYNE)).attachedGains (AngKeyword.INTIMIDATE)));
			case GHASTON_GREY: return new AngLocationCard (card, 116, "Ghaston Grey", AngFaction.MARTELL, loyal, 2, unique,
					TB.i ()/*.traits (AngTrait.DORNE).reaction (RB.i ().afterYouLoseAChallenge (ChFB.i ().asDefendingPlayer ())*/);
			case SUNSPEAR: return new AngLocationCard (card, 117, "Sunspear", AngFaction.MARTELL, noLoy, 2, unique, TB.i ());
			/*DONE*/case BLOOD_ORANGE_GROVE: return new AngLocationCard (card, 118, "Blood Orange Grove", AngFaction.MARTELL, noLoy, 0, noUniq,
					TB.i ().traits (AngTrait.DORNE).limited ().marshallingAction (AB.i ().kneelThisTo ().reduceTheCostOfTheNextCardYouMarshallThisPhaseByN (CFB.i ().martell (), 1)));
			case DORANS_GAME: return new AngEventCard (card, 119, "Doran's Game", AngFaction.MARTELL, loyal, 1, TB.i ());
			case UNBOWED_UNBENT_UNBROKEN: return new AngEventCard (card, 120, "Unbowed, Unbent, Unbroken", AngFaction.MARTELL, noLoy, 0, TB.i ());
			case CONFINEMENT: return new AngEventCard (card, 121, "Confinement", AngFaction.MARTELL, noLoy, 1, TB.i ());
			case BENJEN_STARK: return new AngCharacterCard (card, 122, "Benjen Stark", AngFaction.THENIGHTSWATCH, noLoy, 5, unique, new IcB ().military ().power (), 4,
					TB.i ().traits (AngTrait.RANGER).consAbility (CAB.i ().eachCardCannotBeBypassedByStealth (CFB.i ().traits (AngTrait.RANGER).character ().youControl ()))
					.interrupt (new IB ().whenThisIsKilled ().gainPowerForYourFaction (2))); // TODO then...
			case GHOST: return new AngCharacterCard (card, 123, "Ghost", AngFaction.THENIGHTSWATCH, noLoy, 4, unique, new IcB ().military (), 3, TB.i ());
			case JON_SNOW: return new AngCharacterCard (card, 124, "Jon Snow", AngFaction.THENIGHTSWATCH, noLoy, 6, unique, new IcB ().intrigue (), 4, TB.i ());
			/*DONE*/case MAESTER_AEMON: return new AngCharacterCard (card, 125, "Maester Aemon", AngFaction.THENIGHTSWATCH, noLoy, 3, unique, new IcB ().intrigue (), 2,
					TB.i ().traits (AngTrait.MAESTER, AngTrait.STEWARD).noAttachments ().interrupt (new IB ().whenACharacterWouldBeKilled (CFB.i ().theNightsWatch ()).kneelThisTo ().saveIt ()));
			case OLD_BEAR_MORMONT: return new AngCharacterCard (card, 126, "Old Bear Mormont", AngFaction.THENIGHTSWATCH, loyal, 7, unique, new IcB ().military ().power (), 6, TB.i ());
			/*DONE*/case SAMWELL_TARLY: return new AngCharacterCard (card, 127, "Samwell Tarly", AngFaction.THENIGHTSWATCH, loyal, 2, unique, new IcB ().intrigue (), 1,
					TB.i ().traits (AngTrait.STEWARD).insight ().reserve (1));
			/*DONE*/case SER_WAYMAR_ROYCE: return new AngCharacterCard (card, 128, "Ser Waymar Royce", AngFaction.THENIGHTSWATCH, noLoy, 3, unique, new IcB ().military ().power (), 3,
					TB.i ().traits (AngTrait.KNIGHT, AngTrait.RANGER).noAttachmentsExcept (AngTrait.WEAPON)
					.interrupt (new IB ().whenThisIsKilled ().discardNCardsAtRandomFromEachPlayerHand (1, PFB.i ().eachOpponents ())));
			/*DONE*/case YOREN: return new AngCharacterCard (card, 129, "Yoren", AngFaction.THENIGHTSWATCH, loyal, 3, unique, new IcB ().intrigue (), 2,
					TB.i ().traits (AngTrait.WANDERING_CROW).reaction (RB.i ().afterYouMarshallThis ().chooseACard (CFB.i ().character ().withPrintedCostOrLower (3).inOpponentArea (AngArea.DISCARD_PILE)).andPutItIntoPlayUnderYourControl ()));
			/*DONE*/case MESSENGER_RAVEN: return new AngCharacterCard (card, 130, "Messenger Raven", AngFaction.THENIGHTSWATCH, loyal, 1, noUniq, new IcB (), 1,
					TB.i ().traits (AngTrait.RAVEN).noAttachments ().dominanceAction (AB.i ().returnThisToYourHandTo ().drawNCards (1)));
			/*DONE*/case OLD_FOREST_HUNTER: return new AngCharacterCard (card, 131, "Old Forest Hunter", AngFaction.THENIGHTSWATCH, loyal, 2, noUniq, new IcB ().military (), 1,
					TB.i ().traits (AngTrait.RANGER).noAttachmentsExcept (AngTrait.WEAPON).action (AB.i ().discardNCardsFromYourHandTo (1).gainNGold (1, null).limitPerPhase (1)));
			/*DONE*/case RANGING_PARTY: return new AngCharacterCard (card, 132, "Ranging Party", AngFaction.THENIGHTSWATCH, noLoy, 4, noUniq, new IcB ().military ().power (), 5,
					TB.i ().traits (AngTrait.ARMY, AngTrait.RANGER).noAttachmentsExcept (AngTrait.WEAPON));
			/*DONE*/case STEWARD_AT_THE_WALL: return new AngCharacterCard (card, 133, "Steward at the Wall", AngFaction.THENIGHTSWATCH, noLoy, 1, noUniq, new IcB ().intrigue (), 1,
					TB.i ().traits (AngTrait.ALLY, AngTrait.STEWARD).marshallingAction (AB.i ().kneelThisTo ().reduceTheCostOfTheNextCardYouMarshallThisPhaseByN (CFB.i ().theNightsWatch ().character (), 1)));
			/*DONE*/case VETERAN_BUILDER: return new AngCharacterCard (card, 134, "Veteran Builder", AngFaction.THENIGHTSWATCH, noLoy, 3, noUniq, new IcB ().power (), 4,
					TB.i ().traits (AngTrait.BUILDER).noAttachmentsExcept (AngTrait.WEAPON).action (AB.i ().sacrificeThisTo ().chooseACard (CFB.i ().location ()).andStandIt ()));
			/*DONE*/case LONGCLAW: return new AngAttachmentCard (card, 135, "Longclaw", AngFaction.THENIGHTSWATCH, noLoy, 2, unique,
					TB.i ().traits (AngTrait.VALYRIAN_STEEL, AngTrait.WEAPON).only (CFB.i ().theNightsWatch ().character ())
					.consAbility (CAB.i ().and (new AngConsEffects.AngAttachedGetsStrength (1), new AngConsEffects.AngAttachedGainsAKeyword (new AngTextKeyword (AngKeyword.RENOWN, null, null)))));
			case CASTLE_BLACK: return new AngLocationCard (card, 136, "Castle Black", AngFaction.THENIGHTSWATCH, noLoy, 2, unique, TB.i ());
			/*DONE*/case THE_WALL: return new AngLocationCard (card, 137, "The Wall", AngFaction.THENIGHTSWATCH, noLoy, 4, unique,
					TB.i ().traits (AngTrait.STRONGHOLD, AngTrait.THE_NORTH).consAbility (CAB.i ().eachCardGetsStrength (CFB.i ().theNightsWatch ().character ().youControl (), 1))
					.forcedReaction (RB.i ().afterYouLoseAChallenge (ChFB.i ().unopposed ()).kneelThis ())
					.interrupt (new IB ().whenThePhaseEnds (AngPhase.CHALLENGES).kneelThisTo ().gainPowerForYourFaction (2)));
			case A_MEAGER_CONTRIBUTION: return new AngEventCard (card, 138, "A Meager Contribution", AngFaction.THENIGHTSWATCH, loyal, 0, TB.i ());
			/*DONE*/case TAKE_THE_BLACK: return new AngEventCard (card, 139, "Take the Black", AngFaction.THENIGHTSWATCH, loyal, 3,
					TB.i ().dominanceAction (AB.i ().chooseACard (CFB.i ().nonUnique ().character ().withPrintedCostOrLower (6)).andTakeControlOfThat ().maxPerRound (1)));
			case THE_SWORD_IN_THE_DARKNESS: return new AngEventCard (card, 140, "The Sword in the Darkness", AngFaction.THENIGHTSWATCH, noLoy, 1, TB.i ());
			case ARYA_STARK: return new AngCharacterCard (card, 141, "Arya Stark", AngFaction.STARK, noLoy, 3, unique, new IcB ().power (), 2, TB.i ());
			case BRAN_STARK: return new AngCharacterCard (card, 142, "Bran Stark", AngFaction.STARK, noLoy, 2, unique, new IcB ().power (), 1, TB.i ());
			/*DONE*/case CATELYN_STARK: return new AngCharacterCard (card, 143, "Catelyn Stark", AngFaction.STARK, loyal, 4, unique, new IcB ().intrigue ().power (), 4,
					TB.i ().traits (AngTrait.HOUSE_TULLY, AngTrait.LADY, AngTrait.THE_SEVEN).consAbility (CAB.i ().whileThisIsPartecipating (ChFB.i ()).yourOpponentsCannotTriggerCardAbilities ()));
			case EDDARD_STARK: return new AngCharacterCard (card, 144, "Eddard Stark", AngFaction.STARK, noLoy, 7, unique, new IcB ().military ().power (), 5, TB.i ());
			/*DONE*/case GREY_WIND: return new AngCharacterCard (card, 145, "Grey Wind", AngFaction.STARK, loyal, 5, unique, new IcB ().military (), 4,
					TB.i ().traits (AngTrait.DIREWOLF).intimidate ().noAttachments ().challengesAction (AB.i ().kneelThisTo ()
							.chooseACard (CFB.i ().character ().withStrengthOrLower (1, new AngAPlayerControls (true, CFB.i ().title ("Robb Stark").build ()), 2)).andKillIt ()));
			/*DONE*/case ROBB_STARK: return new AngCharacterCard (card, 146, "Robb Stark", AngFaction.STARK, loyal, 6, unique, new IcB ().military ().power (), 5,
					TB.i ().traits (AngTrait.LORD).renown ().reaction (RB.i ().afterACardIsSacrificedOrKilled (CFB.i ().stark ().character ().youControl ()).standEachCard (CFB.i ().character ().youControl ()).limitPerRound (1)));
			case SANSA_STARK: return new AngCharacterCard (card, 147, "Sansa Stark", AngFaction.STARK, noLoy, 3, unique, new IcB ().intrigue ().power (), 2, TB.i ());
			case SUMMER: return new AngCharacterCard (card, 148, "Summer", AngFaction.STARK, loyal, 3, unique, new IcB ().military (), 3, TB.i ());
			/*DONE*/case DIREWOLF_PUP: return new AngCharacterCard (card, 149, "Direwolf Pup", AngFaction.STARK, noLoy, 2, noUniq, new IcB ().military (), 1,
					TB.i ().traits (AngTrait.DIREWOLF).noAttachments ().consAbility (CAB.i ().thisGetsStrength (1).forEach (CFB.i ().other ().traits (AngTrait.DIREWOLF).youControl ())));
			/*DONE*/case TUMBLESTONE_KNIGHT: return new AngCharacterCard (card, 150, "Tumblestone Knight", AngFaction.STARK, noLoy, 2, noUniq, new IcB ().military ().power (), 2,
					TB.i ().traits (AngTrait.HOUSE_TULLY, AngTrait.KNIGHT));
			case VANGUARD_OF_THE_NORTH: return new AngCharacterCard (card, 151, "Vanguard of the North", AngFaction.STARK, noLoy, 4, noUniq, new IcB ().military (), 4, TB.i ());
			case WINTERFELL_STEWARD: return new AngCharacterCard (card, 152, "Winterfell Steward", AngFaction.STARK, noLoy, 1, noUniq, new IcB ().power (), 1, TB.i ());
			/*DONE*/case ICE: return new AngAttachmentCard (card, 153, "Ice", AngFaction.STARK, loyal, 3, unique,
					TB.i ().traits (AngTrait.VALYRIAN_STEEL, AngTrait.WEAPON).only (CFB.i ().stark ().character ()).consAbility (CAB.i ().attachedGetsStrength (2))
					.reaction (RB.i ().afterYouWinAChallenge (ChFB.i ().inWhichAttachedIsPartecipating ()).sacrificeThisTo ().chooseACard (CFB.i ().character ().controlledByTheLosingOpponent ()).andKillIt ()));
			case GATES_OF_WINTERFELL: return new AngLocationCard (card, 154, "Gates of Winterfell", AngFaction.STARK, noLoy, 2, unique, TB.i ());
			case THE_WOLFSWOOD: return new AngLocationCard (card, 155, "The Wolfswood", AngFaction.STARK, noLoy, 1, unique, TB.i ());
			/*DONE*/case HEART_TREE_GROVE: return new AngLocationCard (card, 156, "Heart Tree Grove", AngFaction.STARK, noLoy, 0, noUniq,
					TB.i ().traits (AngTrait.OLD_GODS, AngTrait.WINTERFELL).limited ()
					.marshallingAction (AB.i ().reduceTheCostOfTheNextCardYouMarshallThisPhaseByN (CFB.i ().stark ().character (), 1)));
			case FOR_THE_NORTH: return new AngEventCard (card, 157, "For the North!", AngFaction.STARK, noLoy, 0, TB.i ());
			case LIKE_WARM_RAIN: return new AngEventCard (card, 158, "Like Warm Rain", AngFaction.STARK, noLoy, 1, TB.i ());
			case WINTER_IS_COMING: return new AngEventCard (card, 159, "Winter Is Coming", AngFaction.STARK, loyal, 1, TB.i ());
			case DAENERYS_TARGARYEN: return new AngCharacterCard (card, 160, "Daenerys Targaryen", AngFaction.TARGARYEN, loyal, 7, unique, new IcB ().intrigue ().power (), 5, TB.i ());
			/*DONE*/case DROGON: return new AngCharacterCard (card, 161, "Drogon", AngFaction.TARGARYEN, noLoy, 3, unique, new IcB ().military (), 4,
					TB.i ().traits (AngTrait.DRAGON, AngTrait.HATCHLING).noAttachments ().consAbility (CAB.i ().eachCardGains (CFB.i ().traits (AngTrait.STORMBORN).character ().youControl (), AngKeyword.RENOWN)));
			/*DONE*/case KHAL_DROGO: return new AngCharacterCard (card, 162, "Khal Drogo", AngFaction.TARGARYEN, loyal, 6, unique, new IcB ().military ().power (), 5,
					TB.i ().traits (AngTrait.DOTHRAKY, AngTrait.LORD).consAbility (CAB.i ().youMayInitiateAnAdditionalChallengeDuringTheChallengePhase (AngIcon.MILITARY)));
			/*DONE*/case MAGISTER_ILLYRIO: return new AngCharacterCard (card, 163, "Magister Illyrio", AngFaction.TARGARYEN, noLoy, 5, unique, new IcB ().intrigue ().power (), 4,
					TB.i ().traits (AngTrait.LORD, AngTrait.MERCHANT).action (AB.i ().payNGoldTo (2).chooseACard (CFB.i ().character ()).andStandIt ()));
			case RHAEGAL: return new AngCharacterCard (card, 164, "Rhaegal", AngFaction.TARGARYEN, noLoy, 3, unique, new IcB ().military ().intrigue (), 3, TB.i ());
			case SER_JORAH_MORMONT: return new AngCharacterCard (card, 165, "Ser Jorah Mormont", AngFaction.TARGARYEN, noLoy, 2, unique, new IcB ().military ().intrigue (), 4, TB.i ());
			/*DONE*/case VISERION: return new AngCharacterCard (card, 166, "Viserion", AngFaction.TARGARYEN, noLoy, 2, unique, new IcB ().military ().power (), 2,
					TB.i ().traits (AngTrait.DRAGON, AngTrait.HATCHLING).noAttachments ().consAbility (CAB.i ().eachCardGains (CFB.i ().traits (AngTrait.STORMBORN).character ().youControl (), AngKeyword.STEALTH)));
			/*DONE*/case VISERYS_TARGARYEN: return new AngCharacterCard (card, 167, "Viserys Targaryen", AngFaction.TARGARYEN, loyal, 1, unique, new IcB ().power (), 1,
					TB.i ().traits (AngTrait.LORD).interrupt (new IB ().whenThisLeavesPlay ().chooseACard (CFB.i ().attachment ()).andDiscardItFromPlay ()));
			/*DONE*/case BRAIDED_WARRIOR: return new AngCharacterCard (card, 168, "Braided Warrior", AngFaction.TARGARYEN, noLoy, 2, noUniq, new IcB ().military (), 3,
					TB.i ().traits (AngTrait.DOTHRAKY).noAttachmentsExcept (AngTrait.WEAPON));
			/*DONE*/case HANDMAIDEN: return new AngCharacterCard (card, 169, "Handmaiden", AngFaction.TARGARYEN, noLoy, 2, noUniq, new IcB ().intrigue ().power (), 1,
					TB.i ().traits (AngTrait.ALLY, AngTrait.COMPANION).action (AB.i ().sacrificeThisTo ().chooseACard (CFB.i ().traits (AngTrait.LADY).character ()).andStandIt ()));
			/*DONE*/case TARGARYEN_LOYALIST: return new AngCharacterCard (card, 170, "Targaryen Loyalist", AngFaction.TARGARYEN, noLoy, 1, noUniq, new IcB ().power (), 1,
					TB.i ().traits (AngTrait.ALLY).marshallingAction (AB.i ().kneelThisTo ().reduceTheCostOfTheNextCardYouMarshallThisPhaseByN (CFB.i ().character ().targaryen (), 1)));
			case UNSULLIED: return new AngCharacterCard (card, 171, "Unsullied", AngFaction.TARGARYEN, noLoy, 4, noUniq, new IcB ().military ().power (), 3, TB.i ());
			case DROGOS_ARAKH: return new AngAttachmentCard (card, 172, "Drogo's Arakh", AngFaction.TARGARYEN, noLoy, 2, unique, TB.i ());
			case PLAZA_OF_PUNISHMENT: return new AngLocationCard (card, 173, "Plaza of Punishment", AngFaction.TARGARYEN, loyal, 3, unique,
					TB.i ().traits (AngTrait.ASTAPOR).reaction (RB.i ().afterYouWinAChallenge (ChFB.i ().power ()).kneelThisTo ().chooseACard (CFB.i ().character ().withoutAttachments ())
						.untilTheEndOfThePhase ().thatCardGetsStrength (-2)));
			case DOTHRAKI_SEA: return new AngLocationCard (card, 174, "Dothraki Sea", AngFaction.TARGARYEN, noLoy, 1, unique, TB.i ());
			case ILLYRIOS_ESTATE: return new AngLocationCard (card, 175, "Illyrio's Estate", AngFaction.TARGARYEN, noLoy, 0, noUniq, TB.i ());
			case DRACARYS: return new AngEventCard (card, 176, "Dracarys!", AngFaction.TARGARYEN, loyal, 1,
					TB.i ()/*.action (AB.i ().kneelACardTo (CFB.i ().traits (AngTrait.DRAGON).character ()))*/);
			case FIRE_AND_BLOOD: return new AngEventCard (card, 177, "Fire and Blood", AngFaction.TARGARYEN, loyal, 1,
					TB.i ().challengesAction (AB.i ().chooseACard (CFB.i ().unique ().targaryen ().character ().inYourArea (AngArea.DEAD_PILE)).andShuffleItBackIntoYourDeck ()));
			case WAKING_THE_DRAGON: return new AngEventCard (card, 178, "Waking the Dragon", AngFaction.TARGARYEN, noLoy, 0, TB.i ());
			/*DONE*/case LEFT: return new AngCharacterCard (card, 179, "Left", AngFaction.TYRELL, noLoy, 2, unique, new IcB ().military (), 2,
					TB.i ().traits (AngTrait.GUARD).noAttachmentsExcept (AngTrait.WEAPON).consAbility (CAB.i ().whileYouControl (CFB.i ().title ("Right"))
							.and (new AngThisGetsStrength (1), new AngThisGainsAnIcon (AngIcon.POWER), new AngThisDoesNotKneelWhenDeclared (false))));
			case MAESTER_LOMYS: return new AngCharacterCard (card, 180, "Maester Lomys", AngFaction.TYRELL, noLoy, 3, unique, new IcB ().intrigue (), 3, TB.i ());
			case MARGAERY_TYRELL: return new AngCharacterCard (card, 181, "Margaery Tyrell", AngFaction.TYRELL, noLoy, 3, unique, new IcB ().intrigue ().power (), 3, TB.i ());
			case PAXTER_REDWYNE: return new AngCharacterCard (card, 182, "Paxter Redwyne", AngFaction.TYRELL, loyal, 4, unique, new IcB ().intrigue (), 3, TB.i ());
			case RANDYLL_TARLY: return new AngCharacterCard (card, 183, "Randyll Tarly", AngFaction.TYRELL, noLoy, 6, unique, new IcB ().military ().power (), 5, TB.i ());
			/*DONE*/case RIGHT: return new AngCharacterCard (card, 184, "Right", AngFaction.TYRELL, noLoy, 2, unique, new IcB ().military (), 2,
					TB.i ().traits (AngTrait.GUARD).noAttachmentsExcept (AngTrait.WEAPON).consAbility (CAB.i ().whileYouControl (CFB.i ().title ("Left"))
							.and (new AngThisGetsStrength (1), new AngThisGainsAnIcon (AngIcon.INTRIGUE), new AngThisDoesNotKneelWhenDeclared (false))));
			case THE_KNIGHT_OF_FLOWERS: return new AngCharacterCard (card, 185, "The Knight of Flowers", AngFaction.TYRELL, noLoy, 5, unique, new IcB ().military ().power (), 5,
					TB.i ().traits (AngTrait.KNIGHT, AngTrait.LORD).renown ()); // TODO .consAbility (CAB.i ().whileThisIsPartecipating (challengeFilterBuilder)));
			case THE_QUEEN_OF_THORNS: return new AngCharacterCard (card, 186, "The Queen of Thorns", AngFaction.TYRELL, loyal, 7, unique, new IcB ().intrigue ().power (), 5, TB.i ());
			/*DONE*/case COURTESAN_OF_THE_ROSE: return new AngCharacterCard (card, 187, "Courtesan of the Rose", AngFaction.TYRELL, noLoy, 2, noUniq, new IcB ().intrigue ().power (), 2,
					TB.i ().traits (AngTrait.COMPANION, AngTrait.SPY));
			/*DONE*/case GARDEN_CARETAKER: return new AngCharacterCard (card, 188, "Garden Caretaker", AngFaction.TYRELL, noLoy, 1, noUniq, new IcB ().power (), 1,
					TB.i ().traits (AngTrait.ALLY).marshallingAction (AB.i ().kneelThisTo ().reduceTheCostOfTheNextCardYouMarshallThisPhaseByN (CFB.i ().tyrell ().character (), 1)));
			case OLENNAS_INFORMANT: return new AngCharacterCard (card, 189, "Olenna's Informant", AngFaction.TYRELL, noLoy, 3, noUniq, new IcB ().intrigue ().power (), 2, TB.i ());
			/*DONE*/case WARDENS_OF_THE_REACH: return new AngCharacterCard (card, 190, "Wardens of the Reach", AngFaction.TYRELL, noLoy, 4, noUniq, new IcB ().military ().power (), 3,
					TB.i ().traits (AngTrait.ARMY).noAttachments ().consAbility (CAB.i ().thisGetsStrength (1).forEach (CFB.i ().traits (AngTrait.THE_REACH).location ().youControl ())));
			case HEARTSBANE: return new AngAttachmentCard (card, 191, "Heartsbane", AngFaction.TYRELL, noLoy, 1, unique, TB.i ());
			case HIGHGARDEN: return new AngLocationCard (card, 192, "Highgarden", AngFaction.TYRELL, loyal, 3, unique, TB.i ());
			/*DONE*/case THE_MANDER: return new AngLocationCard (card, 193, "The Mander", AngFaction.TYRELL, loyal, 3, unique,
					TB.i ().traits (AngTrait.THE_REACH).reaction (RB.i ().afterYouWinAChallenge (ChFB.i ().byNOrMoreSTR (5)).kneelThisTo ().drawNCards (2)));
			/*DONE*/case ROSE_GARDEN: return new AngLocationCard (card, 194, "Rose Garden", AngFaction.TYRELL, noLoy, 0, noUniq,
					TB.i ().traits (AngTrait.THE_REACH).limited ().marshallingAction (AB.i ().kneelThisTo ().reduceTheCostOfTheNextCardYouMarshallThisPhaseByN (CFB.i ().tyrell (), 1)));
			case GROWING_STRONG: return new AngEventCard (card, 195, "Growing Strong", AngFaction.TYRELL, noLoy, 1, TB.i ());
			case OLENNAS_CUNNING: return new AngEventCard (card, 196, "Olenna's Cunning", AngFaction.TYRELL, loyal, 2, TB.i ());
			case THE_BEAR_AND_THE_MAIDEN_FAIR: return new AngEventCard (card, 197, "\"The Bear and the Maiden Fair\"", AngFaction.TYRELL, noLoy, 0, TB.i ());
			case BANNER_OF_THE_STAG: return new AngAgendaCard (card, 198, "Banner of the Stag", AngFaction.NEUTRAL, TB.i ());
			case BANNER_OF_THE_KRAKEN: return new AngAgendaCard (card, 199, "Banner of the Kraken", AngFaction.NEUTRAL, TB.i ());
			case BANNER_OF_THE_LION: return new AngAgendaCard (card, 200, "Banner of the Lion", AngFaction.NEUTRAL, TB.i ());
			case BANNER_OF_THE_SUN: return new AngAgendaCard (card, 201, "Banner of the Sun", AngFaction.NEUTRAL, TB.i ());
			case BANNER_OF_THE_WATCH: return new AngAgendaCard (card, 202, "Banner of the Watch", AngFaction.NEUTRAL, TB.i ());
			case BANNER_OF_THE_WOLF: return new AngAgendaCard (card, 203, "Banner of the Wolf", AngFaction.NEUTRAL, TB.i ());
			case BANNER_OF_THE_DRAGON: return new AngAgendaCard (card, 204, "Banner of the Dragon", AngFaction.NEUTRAL, TB.i ());
			case BANNER_OF_THE_ROSE: return new AngAgendaCard (card, 205, "Banner of the Rose", AngFaction.NEUTRAL, TB.i ());
			default: return null;
		} // switch - case
	} // init

	@Override
	public AgotSet getCardSet () { return AgotSet.CORE_SET; }
	
} // CoreSet
