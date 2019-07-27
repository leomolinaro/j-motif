package com.motif.agot.ang.sets;

import java.util.HashMap;

import com.motif.agot.ang.cards.AngAgendaCard;
import com.motif.agot.ang.cards.AngAttachmentCard;
import com.motif.agot.ang.cards.AngCharacterCard;
import com.motif.agot.ang.cards.AngCharacterCard.IcB;
import com.motif.agot.ang.cards.AngEventCard;
import com.motif.agot.ang.cards.AngLocationCard;
import com.motif.agot.ang.cards.AngPlotCard;
import com.motif.agot.ang.cards.AngTextCard;
import com.motif.agot.ang.enums.AngArea;
import com.motif.agot.ang.enums.AngFaction;
import com.motif.agot.ang.enums.AngIcon;
import com.motif.agot.ang.enums.AngKeyword;
import com.motif.agot.ang.enums.AngPhase;
import com.motif.agot.ang.enums.AngToken;
import com.motif.agot.ang.enums.AngTrait;
import com.motif.agot.ang.text.AngAction.AB;
import com.motif.agot.ang.text.AngConsAbility.CAB;
import com.motif.agot.ang.text.AngInterrupt.IB;
import com.motif.agot.ang.text.AngReaction.RB;
import com.motif.agot.ang.text.AngText.TB;
import com.motif.agot.ang.text.AngTextKeyword;
import com.motif.agot.ang.text.AngWhenRevealed.WRB;
import com.motif.agot.ang.text.consconditions.AngAPlayerControls;
import com.motif.agot.ang.text.consconditions.AngYouAreTheFirstPlayer;
import com.motif.agot.ang.text.conseffects.AngConsEffects;
import com.motif.agot.ang.text.conseffects.AngConsEffects.AngThisDoesNotKneelWhenDeclared;
import com.motif.agot.ang.text.conseffects.AngConsEffects.AngThisGainsAnIcon;
import com.motif.agot.ang.text.conseffects.AngConsEffects.AngThisGetsStrength;
import com.motif.agot.ang.text.filters.AngCardFilter.CFB;
import com.motif.agot.ang.text.filters.AngChallengeFilter.ChFB;
import com.motif.agot.ang.text.filters.AngPlayerFilter.PFB;

public class AgotCardCreator {
	
	public static HashMap<AgotCardSeed, AngTextCard> cardCache = new HashMap<AgotCardSeed, AngTextCard> ();
	
	public static AngTextCard init (AgotCardSeed cardSeed) {
		var card = cardCache.get (cardSeed);
		if (card == null) {
			card = AgotCardCreator.create (cardSeed);
			cardCache.put (cardSeed, card);
		}
		return card;
	}
	
	private static AngTextCard create (AgotCardSeed cardSeed) {
		boolean loyal = true;
		boolean noLoy = false;
		boolean unique = true;
		boolean noUniq = false;
		switch (cardSeed) {
			/* DONE */case A_CLASH_OF_KINGS_Core: return new AngPlotCard (AgotPack.CORE_SET, 1, "A Clash of Kings", AngFaction.NEUTRAL, noLoy, 4, 9, 1, 6,
				        TB.i().traits(AngTrait.NOBLE).reaction(RB.i().afterYouWinAChallenge(ChFB.i().power()).movePowersFromAFactionToAFaction(1, PFB.i().theLoosingOpponent(), PFB.i().you())));
			/* DONE */case A_FEAST_FOR_CROWS_Core: return new AngPlotCard (AgotPack.CORE_SET, 2, "A Feast for Crows", AngFaction.NEUTRAL, noLoy, 6, 1, 1, 4, 
						TB.i().traits (AngTrait.EDICT).reaction (RB.i ().afterYouWinDominance ().gainPowerForYourFaction (2)));
			case A_GAME_OF_THRONES_Core: return new AngPlotCard (AgotPack.CORE_SET, 3, "A Game of Thrones", AngFaction.NEUTRAL, noLoy, 4, 2, 1, 6, TB.i ());
			case A_NOBLE_CAUSE_Core: return new AngPlotCard (AgotPack.CORE_SET, 4, "A Noble Cause", AngFaction.NEUTRAL, noLoy, 5, 0, 1, 6, TB.i ());
			/*DONE*/case A_STORM_OF_SWORDS_Core: return new AngPlotCard (AgotPack.CORE_SET, 5, "A Storm of Swords", AngFaction.NEUTRAL, noLoy, 3, 8, 1, 5,
					TB.i ().traits (AngTrait.WAR).consAbility (CAB.i ().youMayInitiateAnAdditionalChallengeDuringTheChallengePhase (AngIcon.MILITARY)));
			case BUILDING_ORDERS_Core: return new AngPlotCard (AgotPack.CORE_SET, 6, "Building Orders", AngFaction.NEUTRAL, noLoy, 4, 1, 1, 7, TB.i ());
			case CALLING_THE_BANNERS_Core: return new AngPlotCard (AgotPack.CORE_SET, 7, "Calling the Banners", AngFaction.NEUTRAL, noLoy, 3, 6, 1, 6,
					TB.i ().traits (AngTrait.KINGDOM).whenRevealed (WRB.i ().chooseAPlayer (PFB.i ().anOpponent ()).andGainNGold (1, CFB.i ().character ().targetControl ())));
			case CALM_OVER_WESTEROS_Core: return new AngPlotCard (AgotPack.CORE_SET, 8, "Calm Over Westeros", AngFaction.NEUTRAL, noLoy, 5, 3, 1, 6, TB.i ());
			case CONFISCATION_Core: return new AngPlotCard (AgotPack.CORE_SET, 9, "Confiscation", AngFaction.NEUTRAL, noLoy, 4, 5, 1, 6, TB.i ());
			/*DONE*/case COUNTING_COPPERS_Core: return new AngPlotCard (AgotPack.CORE_SET, 10, "Counting Coppers", AngFaction.NEUTRAL, noLoy, 2, 3, 1, 10,
					TB.i ().traits (AngTrait.KINGDOM).whenRevealed (WRB.i ().drawNCards (3)));
			/*DONE*/case FILTHY_ACCUSATIONS_Core: return new AngPlotCard (AgotPack.CORE_SET, 11, "Filthy Accusations", AngFaction.NEUTRAL, noLoy, 4, 4, 1, 6,
					TB.i ().traits (AngTrait.SCHEME).whenRevealed (WRB.i ().chooseACard (CFB.i ().character ()).andKneelIt ()));
			/*DONE*/case FORTIFIED_POSITION_Core: return new AngPlotCard (AgotPack.CORE_SET, 12, "Fortified Position", AngFaction.NEUTRAL, noLoy, 5, 1, 1, 5,
					TB.i ().traits (AngTrait.SIEGE, AngTrait.WAR).consAbility (CAB.i ().treatEachCardAsIfItsPrintedTextBoxWereBlackExceptForTrait (CFB.i ().character ())) );
			case HEADS_ON_SPIKES_Core: return new AngPlotCard (AgotPack.CORE_SET, 13, "Heads on Spikes", AngFaction.NEUTRAL, noLoy, 4, 6, 1, 6, TB.i ());
			/*DONE*/case JOUSTING_CONTEST_Core: return new AngPlotCard (AgotPack.CORE_SET, 14, "Jousting Contest", AngFaction.NEUTRAL, noLoy, 4, 3, 1, 6,
					TB.i ().traits (AngTrait.WAR).consAbility (CAB.i ().eachPlayerCannotDeclareMoreThanNCharactersInEachChallenge (1, PFB.i (), null)));
			case MARCHED_TO_THE_WALL_Core: return new AngPlotCard (AgotPack.CORE_SET, 15, "Marched to the Wall", AngFaction.NEUTRAL, noLoy, 4, 8, 1, 5,
					TB.i ().traits (AngTrait.EDICT));
			/*DONE*/case MARCHING_ORDERS_Core: return new AngPlotCard (AgotPack.CORE_SET, 16, "Marching Orders", AngFaction.NEUTRAL, noLoy, 9, 3, 1, 4,
					TB.i ().traits (AngTrait.EDICT, AngTrait.WAR).consAbility (CAB.i ().youCannotMarshallOrPlay (CFB.i ().attachment ().location ().event ())));
			/*DONE*/case NAVAL_SUPERIORITY_Core: return new AngPlotCard (AgotPack.CORE_SET, 17, "Naval Superiority", AngFaction.NEUTRAL, noLoy, 2, 7, 1, 6,
					TB.i ().traits (AngTrait.SIEGE, AngTrait.WAR).consAbility (CAB.i ().treatTheBaseGoldValueOfEachCardAsIfItWereN (CFB.i ().revealed ().plot ().traits (AngTrait.KINGDOM, AngTrait.EDICT), 0)));
			/*DONE*/case POWER_BEHIND_THE_THRONE_Core: return new AngPlotCard (AgotPack.CORE_SET, 18, "Power Behind the Throne", AngFaction.NEUTRAL, noLoy, 3, 1, 1, 6,
					TB.i ().traits (AngTrait.NOBLE, AngTrait.SCHEME).whenRevealed (WRB.i ().placeOneTokenOnThis (AngToken.STAND)).action (AB.i ().discardATokenFromThisTo (AngToken.STAND).chooseACard (CFB.i ().character ()).andStandIt ()));
			case REBUILDING_Core: return new AngPlotCard (AgotPack.CORE_SET, 19, "Rebuilding", AngFaction.NEUTRAL, noLoy, 5, 5, 1, 6, TB.i ());
			/*DONE*/case REINFORCEMENTS_Core: return new AngPlotCard (AgotPack.CORE_SET, 20, "Reinforcements", AngFaction.NEUTRAL, noLoy, 1, 0, 1, 6,
					TB.i ().traits (AngTrait.KINGDOM, AngTrait.WAR).whenRevealed (WRB.i ().chooseACard (CFB.i ().character ().withPrintedCostOrLower (5).inYourArea (AngArea.HAND, AngArea.DISCARD_PILE)).andPutItIntoPlay ()));
			/*DONE*/case SNEAK_ATTACK_Core: return new AngPlotCard (AgotPack.CORE_SET, 21, "Sneak Attack", AngFaction.NEUTRAL, noLoy, 5, 11, 2, 5,
					TB.i ().traits (AngTrait.SCHEME).consAbility (CAB.i ().youCannotInitiateMoreThanNChallengesDuringTheChallengePhase (1)));
			case SUMMONS_Core: return new AngPlotCard (AgotPack.CORE_SET, 22, "Summons", AngFaction.NEUTRAL, noLoy, 4, 0, 1, 7, TB.i ());
			case SUPPORTING_THE_FAITH_Core: return new AngPlotCard (AgotPack.CORE_SET, 23, "Supporting the Faith", AngFaction.NEUTRAL, noLoy, 6, 2, 1, 4, TB.i ());
			case TAXATION_Core: return new AngPlotCard (AgotPack.CORE_SET, 24, "Taxation", AngFaction.NEUTRAL, noLoy, 5, 6, 1, 6, TB.i ());
			/*DONE*/case THE_WINDS_OF_WINTER_Core: return new AngPlotCard (AgotPack.CORE_SET, 25, "The Winds of Winter", AngFaction.NEUTRAL, noLoy, 3, 4, 2, 5,
					TB.i ().traits (AngTrait.WINTER));
			case WILDFIRE_ASSAULT_Core: return new AngPlotCard (AgotPack.CORE_SET, 26, "Wildfire Assault", AngFaction.NEUTRAL, noLoy, 4, 7, 1, 6, TB.i ());
			case FEALTY_Core: return new AngAgendaCard (AgotPack.CORE_SET, 27, "Fealty", AngFaction.NEUTRAL, TB.i ());
			/*DONE*/case LITTLEFINGER_Core: return new AngCharacterCard (AgotPack.CORE_SET, 28, "Littlefinger", AngFaction.NEUTRAL, noLoy, 5, unique, new IcB ().intrigue ().power (), 4,
					TB.i ().traits (AngTrait.ALLY, AngTrait.LORD, AngTrait.SMALL_COUNCIL).gold (1).reaction (RB.i ().afterYouMarshallThis ().drawNCards (2)));
			/*DONE*/case VARYS_Core: return new AngCharacterCard (AgotPack.CORE_SET, 29, "Varys", AngFaction.NEUTRAL, noLoy, 6, unique, new IcB ().intrigue (), 3,
					TB.i ().traits (AngTrait.LORD, AngTrait.SMALL_COUNCIL, AngTrait.SPY).stealth ().interrupt (new IB ().whenThePhaseEnds (AngPhase.DOMINANCE).removeThisFromTheGameTo ().discardEachFromPlay (CFB.i ().character ())));
			case RATTLESHIRTS_RAIDERS_Core: return new AngCharacterCard (AgotPack.CORE_SET, 30, "Rattleshirt's Raiders", AngFaction.NEUTRAL, noLoy, 4, noUniq, new IcB ().military (), 3,
					TB.i ().noAttachments ());
			case WILDLING_HORDE_Core: return new AngCharacterCard (AgotPack.CORE_SET, 31, "Wildling Horde", AngFaction.NEUTRAL, noLoy, 5, noUniq, new IcB ().military ().power (), 5,
					TB.i ().noAttachments ().pillage ());
			/*DONE*/case SEAL_OF_THE_HAND_Core: return new AngAttachmentCard (AgotPack.CORE_SET, 32, "Seal of the Hand", AngFaction.NEUTRAL, noLoy, 3, unique,
					TB.i ().traits (AngTrait.ITEM).only (CFB.i ().character ().traits (AngTrait.LADY, AngTrait.LORD)).action (AB.i ().kneelThisTo ().standAttached ()));
			/*DONE*/case BODYGUARD_Core: return new AngAttachmentCard (AgotPack.CORE_SET, 33, "Bodyguard", AngFaction.NEUTRAL, noLoy, 1, noUniq,
					TB.i ().traits (AngTrait.CONDITION).only (CFB.i ().character ().traits (AngTrait.LADY, AngTrait.LORD)).interrupt (new IB ().whenAttachedWouldBeKilledOrDiscardFromPlay ().sacrificeThisTo ().saveIt ()));
			/*DONE*/case LITTLE_BIRD_Core: return new AngAttachmentCard (AgotPack.CORE_SET, 34, "Little Bird", AngFaction.NEUTRAL, noLoy, 1, noUniq,
					TB.i ().traits (AngTrait.CONDITION).consAbility (CAB.i ().attachedGainsAnIcon (AngIcon.INTRIGUE)));
			case MILK_OF_THE_POPPY_Core: return new AngAttachmentCard (AgotPack.CORE_SET, 35, "Milk of the Poppy", AngFaction.NEUTRAL, noLoy, 1, noUniq,
					TB.i ().terminal ());
			/*DONE*/case NOBLE_LINEAGE_Core: return new AngAttachmentCard (AgotPack.CORE_SET, 36, "Noble Lineage", AngFaction.NEUTRAL, noLoy, 0, noUniq,
					TB.i ().traits (AngTrait.CONDITION).consAbility (CAB.i ().attachedGainsAnIcon (AngIcon.POWER)));
			/*DONE*/case SYRIOS_TRAINING_Core: return new AngAttachmentCard (AgotPack.CORE_SET, 37, "Syrio's Training", AngFaction.NEUTRAL, noLoy, 1, noUniq,
					TB.i ().traits (AngTrait.CONDITION).consAbility (CAB.i ().attachedGainsAnIcon (AngIcon.MILITARY)));
			/*DONE*/case THE_IRON_THRONE_Core: return new AngLocationCard (AgotPack.CORE_SET, 38, "The Iron Throne", AngFaction.NEUTRAL, noLoy, 2, unique,
					TB.i ().reserve (1).consAbility (CAB.i ().addStrengthToYourTotalForDominance (8)));
			case THE_KINGSROAD_Core: return new AngLocationCard (AgotPack.CORE_SET, 39, "The Kingsroad", AngFaction.NEUTRAL, noLoy, 1, noUniq, TB.i ().limited ().initiative (1));
			/*DONE*/case THE_ROSEROAD_Core: return new AngLocationCard (AgotPack.CORE_SET, 40, "The Roseroad", AngFaction.NEUTRAL, noLoy, 0, noUniq,
					TB.i ().traits (AngTrait.WESTEROS).limited ().gold (1));
			case PUT_TO_THE_SWORD_Core: return new AngEventCard (AgotPack.CORE_SET, 41, "Put to the Sword", AngFaction.NEUTRAL, noLoy, 2, TB.i ());
			case PUT_TO_THE_TORCH_Core: return new AngEventCard (AgotPack.CORE_SET, 42, "Put to the Torch", AngFaction.NEUTRAL, noLoy, 1, TB.i ());
			case SUPERIOR_CLAIM_Core: return new AngEventCard (AgotPack.CORE_SET, 43, "Superior Claim", AngFaction.NEUTRAL, noLoy, 0, TB.i ());
			case TEARS_OF_LYS_Core: return new AngEventCard (AgotPack.CORE_SET, 44, "Tears of Lys", AngFaction.NEUTRAL, noLoy, 1, TB.i ());
			case THE_HANDS_JUDGMENT_Core: return new AngEventCard (AgotPack.CORE_SET, 45, "The Hand's Judgment", AngFaction.NEUTRAL, noLoy, null, TB.i ());
			case MAESTER_CRESSEN_Core: return new AngCharacterCard (AgotPack.CORE_SET, 46, "Maester Cressen", AngFaction.BARATHEON, noLoy, 3, unique, new IcB ().power (), 3, TB.i ());
			/*DONE*/case MELISANDRE_Core: return new AngCharacterCard (AgotPack.CORE_SET, 47, "Melisandre", AngFaction.BARATHEON, noLoy, 5, unique, new IcB ().intrigue ().power (), 4,
					TB.i ().traits (AngTrait.LADY, AngTrait.RHLLOR).reaction (RB.i ().afterYouMarshallOrPlayACard (CFB.i ().traits (AngTrait.RHLLOR)).chooseACard (CFB.i ().character ()).andKneelIt ().limitPerRound (1)));
			case ROBERT_BARATHEON_Core: return new AngCharacterCard (AgotPack.CORE_SET, 48, "Robert Baratheon", AngFaction.BARATHEON, loyal, 7, unique, new IcB ().military ().power (), 5, TB.i ().intimidate ().renown ());
			case SELYSE_BARATHEON_Core: return new AngCharacterCard (AgotPack.CORE_SET, 49, "Selyse Baratheon", AngFaction.BARATHEON, noLoy, 3, unique, new IcB ().intrigue ().power (), 2, TB.i ());
			/*DONE*/case SER_DAVOS_SEAWORTH_Core: return new AngCharacterCard (AgotPack.CORE_SET, 50, "Ser Davos Seaworth", AngFaction.BARATHEON, noLoy, 4, unique, new IcB ().military ().power (), 3,
					TB.i ().traits (AngTrait.KNIGHT, AngTrait.SMUGGLER).stealth ().interrupt (new IB ().whenThisIsKilled ().returnThisToYourHand ().insteadOfPlacingThisInYourDeadPile ()));
			/*DONE*/case SHIREEN_BARATHEON_Core: return new AngCharacterCard (AgotPack.CORE_SET, 51, "Shireen Baratheon", AngFaction.BARATHEON, noLoy, 2, unique, new IcB ().power (), 1,
					TB.i ().traits (AngTrait.LADY).interrupt (new IB ().whenThisIsKilled ().chooseACard (CFB.i ().character ()).andKneelIt ()));
			/*DONE*/case STANNIS_BARATHEON_Core: return new AngCharacterCard (AgotPack.CORE_SET, 52, "Stannis Baratheon", AngFaction.BARATHEON, loyal, 6, unique, new IcB ().military ().power (), 5,
					TB.i ().traits (AngTrait.LORD, AngTrait.SMALL_COUNCIL).consAbility (CAB.i ().eachPlayerCannotStandMoreThanNCardsDuringTheStandingPhase (2, CFB.i ().character ())));
			/*DONE*/case BASTARD_IN_HIDING_Core: return new AngCharacterCard (AgotPack.CORE_SET, 53, "Bastard in Hiding", AngFaction.BARATHEON, noLoy, 2, noUniq, new IcB ().military ().power (), 2,
					TB.i ().traits (AngTrait.BASTARD));
			/*DONE*/case FIERY_FOLLOWERS_Core: return new AngCharacterCard (AgotPack.CORE_SET, 54, "Fiery Followers", AngFaction.BARATHEON, noLoy, 3, noUniq, new IcB ().military ().intrigue (), 2,
					TB.i ().traits (AngTrait.RHLLOR).reaction (RB.i ().afterPhaseBegins (AngPhase.DOMINANCE).standThis ()));
			/*DONE*/case KINGS_HUNTING_PARTY_Core: return new AngCharacterCard (AgotPack.CORE_SET, 55, "King's Hunting Party", AngFaction.BARATHEON, noLoy, 4, noUniq, new IcB ().military (), 6,
					TB.i ().traits (AngTrait.ARMY).noAttachments ().consAbility (CAB.i ().whileAnOpponentControls (CFB.i ().traits (AngTrait.KING).character ()).thisGainsAnIcon (AngIcon.INTRIGUE)));
			/*DONE*/case DRAGONSTONE_FAITHFUL_Core: return new AngCharacterCard (AgotPack.CORE_SET, 56, "Dragonstone Faithful", AngFaction.BARATHEON, noLoy, 1, noUniq, new IcB ().power (), 1,
					TB.i ().traits (AngTrait.ALLY).limited ().marshallingAction (AB.i ().kneelThisTo ().reduceTheCostOfTheNextCardYouMarshallThisPhaseByN (CFB.i ().baratheon ().character (), 1)));
			/*DONE*/case VANGUARD_LANCER_Core: return new AngCharacterCard (AgotPack.CORE_SET, 57, "Vanguard Lancer", AngFaction.BARATHEON, noLoy, 2, noUniq, new IcB ().military ().power (), 1,
					TB.i ().traits (AngTrait.HOUSE_FLORENT, AngTrait.KNIGHT).reaction (RB.i ().afterThisEntersPlay ().chooseACard (CFB.i ().opponent ().character ().faction ()).andDiscardNPowerFromThatCard (1)));
			/*DONE*/case LIGHTBRINGER_Core: return new AngAttachmentCard (AgotPack.CORE_SET, 58, "Lightbringer", AngFaction.BARATHEON, loyal, 2, unique,
					TB.i ().traits (AngTrait.RHLLOR, AngTrait.WEAPON).only (CFB.i ().baratheon ().character ()).consAbility (CAB.i ().ifAttachedIs (CFB.i ().title ("Stannis Baratheon")).attachedGains (AngKeyword.RENOWN)).reaction (RB.i ().afterAttachedGainsOneOrMorePower ().standAttached ().limitPerPhase (1)));
			/*DONE*/case DRAGONSTONE_PORT_Core: return new AngLocationCard (AgotPack.CORE_SET, 59, "Dragonstone Port", AngFaction.BARATHEON, noLoy, 0, noUniq,
					TB.i ().traits (AngTrait.DRAGONSTONE).limited ().marshallingAction (AB.i ().kneelThisTo ().reduceTheCostOfTheNextCardYouMarshallThisPhaseByN (CFB.i ().baratheon (), 1)));
			case CHAMBER_OF_THE_PAINTED_TABLE_Core: return new AngLocationCard (AgotPack.CORE_SET, 60, "Chamber of the Painted Table", AngFaction.BARATHEON, noLoy, 2, unique, TB.i ());
			case THE_RED_KEEP_Core: return new AngLocationCard (AgotPack.CORE_SET, 61, "The Red Keep", AngFaction.BARATHEON, loyal, 3, unique, TB.i ());
			case CONSOLIDATION_OF_POWER_Core: return new AngEventCard (AgotPack.CORE_SET, 62, "Consolidation of Power", AngFaction.BARATHEON, loyal, 1, TB.i ());
			case OURS_IS_THE_FURY_Core: return new AngEventCard (AgotPack.CORE_SET, 63, "Ours is the Fury", AngFaction.BARATHEON, loyal, 2, TB.i ());
			case SEEN_IN_FLAMES_Core: return new AngEventCard (AgotPack.CORE_SET, 64, "Seen In Flames", AngFaction.BARATHEON, noLoy, 1, TB.i ());
			case AERON_DAMPHAIR_Core: return new AngCharacterCard (AgotPack.CORE_SET, 65, "Aeron Damphair", AngFaction.GREYJOY, noLoy, 3, unique, new IcB ().power (), 3, TB.i ());
			case ALANNYS_GREYJOY_Core: return new AngCharacterCard (AgotPack.CORE_SET, 66, "Alannys Greyjoy", AngFaction.GREYJOY, noLoy, 3, unique, new IcB ().intrigue ().power (), 2, TB.i ());
			/*DONE*/case ASHA_GREYJOY_Core: return new AngCharacterCard (AgotPack.CORE_SET, 67, "Asha Greyjoy", AngFaction.GREYJOY, noLoy, 5, unique, new IcB ().military ().power (), 4,
					TB.i ().traits (AngTrait.IRONBORN, AngTrait.LADY).stealth ().reaction (RB.i ().afterYouWinAChallenge (ChFB.i ().unopposed ().inWhichThisIsPartecipating ()).standThis ()));
			case BALON_GREYJOY_Core: return new AngCharacterCard (AgotPack.CORE_SET, 68, "Balon Greyjoy", AngFaction.GREYJOY, loyal, 6, unique, new IcB ().military ().power (), 5,
					TB.i ().traits (AngTrait.IRONBORN, AngTrait.LORD).renown ());
			case EURON_CROWS_EYE_Core: return new AngCharacterCard (AgotPack.CORE_SET, 69, "Euron Crow's Eye", AngFaction.GREYJOY, loyal, 7, unique, new IcB ().military ().intrigue ().power (), 6, TB.i ());
			/*DONE*/case MAESTER_WENDAMYR_Core: return new AngCharacterCard (AgotPack.CORE_SET, 70, "Maester Wendamyr", AngFaction.GREYJOY, noLoy, 2, unique, new IcB ().power (), 2,
					TB.i ().traits (AngTrait.MAESTER).stealth ());
			/*DONE*/case THEON_GREYJOY_Core: return new AngCharacterCard (AgotPack.CORE_SET, 71, "Theon Greyjoy", AngFaction.GREYJOY, noLoy, 4, unique, new IcB ().military ().power (), 3,
					TB.i ().traits (AngTrait.ALLY, AngTrait.IRONBORN, AngTrait.LORD).stealth ().reaction (RB.i ().afterYouWinAChallenge (ChFB.i ().unopposed ().inWhichThisIsPartecipating ()).thisGainsNPower (1)));
			/*DONE*/case BLACK_WINDS_CREW_Core: return new AngCharacterCard (AgotPack.CORE_SET, 72, "Black Wind's Crew", AngFaction.GREYJOY, noLoy, 3, noUniq, new IcB ().military ().power (), 3,
					TB.i ().traits (AngTrait.IRONBORN, AngTrait.RAIDERS).pillage ());
			/*DONE*/case DROWNED_MEN_Core: return new AngCharacterCard (AgotPack.CORE_SET, 73, "Drowned Men", AngFaction.GREYJOY, noLoy, 4, noUniq, new IcB ().military ().power (), 3,
					TB.i ().traits (AngTrait.ARMY, AngTrait.DROWNED_GOD).noAttachments ().consAbility (CAB.i ().thisGetsStrength (1).forEach (CFB.i ().traits (AngTrait.WARSHIP).location ().youControl ())));
			/*DONE*/case IRON_ISLANDS_FISHMONGER_Core: return new AngCharacterCard (AgotPack.CORE_SET, 74, "Iron Islands Fishmonger", AngFaction.GREYJOY, noLoy, 1, noUniq, new IcB ().power (), 1,
					TB.i ().traits (AngTrait.ALLY, AngTrait.MERCHANT).marshallingAction (AB.i ().kneelThisTo ().reduceTheCostOfTheNextCardYouMarshallThisPhaseByN (CFB.i ().greyjoy ().character (), 1)));
			/*DONE*/case LORDSPORT_SHIPWRIGHT_Core: return new AngCharacterCard (AgotPack.CORE_SET, 75, "Lordsport Shipwright", AngFaction.GREYJOY, noLoy, 2, noUniq, new IcB ().intrigue (), 1,
					TB.i ().traits (AngTrait.ALLY, AngTrait.IRONBORN).marshallingAction (AB.i ().kneelThisTo ().chooseACard (CFB.i ().location ().withPrintedCostOrLower (2, new AngYouAreTheFirstPlayer (true), 3)).andKneelIt ()));
			/*DONE*/case SALTY_NAVIGATOR_Core: return new AngCharacterCard (AgotPack.CORE_SET, 76, "Salty Navigator", AngFaction.GREYJOY, noLoy, 2, noUniq, new IcB ().military (), 2,
					TB.i ().traits (AngTrait.IRONBORN).initiative (1));
			/*DONE*/case THROWING_AXE_Core: return new AngAttachmentCard (AgotPack.CORE_SET, 77, "Throwing Axe", AngFaction.GREYJOY, noLoy, 1, noUniq,
					TB.i ().traits (AngTrait.WEAPON).only (CFB.i ().character ().traits (AngTrait.IRONBORN)).reaction (RB.i ().afterYouWinAChallenge (ChFB.i ().inWhichAttachedIsPartecipatingAsAttacker ()).sacrificeThisTo ().chooseACard (CFB.i ().defending ().character ()).andKillIt ()));
			case GREAT_KRAKEN_Core: return new AngLocationCard (AgotPack.CORE_SET, 78, "Great Kraken", AngFaction.GREYJOY, loyal, 3, unique,
					TB.i ());
			/*DONE*/case IRON_FLEET_SCOUT_Core: return new AngLocationCard (AgotPack.CORE_SET, 79, "Iron Fleet Scout", AngFaction.GREYJOY, noLoy, 0, noUniq,
					TB.i ().traits (AngTrait.WARSHIP).challengesAction (AB.i ().kneelThisTo ().chooseACard (CFB.i ().greyjoy ().character ().partecipating ())
							.untilTheEndOfTheChallenge ().thatCardGetsStrength (1, 2, new AngYouAreTheFirstPlayer (true))));
			/*DONE*/case SEA_TOWER_Core: return new AngLocationCard (AgotPack.CORE_SET, 80, "Sea Tower", AngFaction.GREYJOY, noLoy, 0, noUniq,
					TB.i ().traits (AngTrait.IRON_ISLANDS).limited ().marshallingAction (AB.i ().kneelThisTo ().reduceTheCostOfTheNextCardYouMarshallThisPhaseByN (CFB.i ().greyjoy (), 1)));
			case RISEN_FROM_THE_SEA_Core: return new AngEventCard (AgotPack.CORE_SET, 81, "Risen from the Sea", AngFaction.GREYJOY, noLoy, 0,
					TB.i ());
			case THE_KRAKENS_GRASP_Core: return new AngEventCard (AgotPack.CORE_SET, 82, "The Kraken's Grasp", AngFaction.GREYJOY, loyal, 0,
					TB.i ());
			/*DONE*/case WE_DO_NOT_SOW_Core: return new AngEventCard (AgotPack.CORE_SET, 83, "We Do Not Sow", AngFaction.GREYJOY, loyal, 1,
					TB.i ().reaction (RB.i ().afterYouWinAChallenge (ChFB.i ().unopposed ()).chooseACard (CFB.i ().attachment ().location ().controlledByTheLosingOpponent ()).andDiscardItFromPlay ().maxPerChallenge (1)));
			case CERSEI_LANNISTER_Core: return new AngCharacterCard (AgotPack.CORE_SET, 84, "Cersei Lannister", AngFaction.LANNISTER, loyal, 4, unique, new IcB ().intrigue ().power (), 4, TB.i ());
			case GRAND_MAESTER_PYCELLE_Core: return new AngCharacterCard (AgotPack.CORE_SET, 85, "Grand Maester Pycelle", AngFaction.LANNISTER, loyal, 3, unique, new IcB ().intrigue ().power (), 2, TB.i ());
			case JOFFREY_BARATHEON_Core: return new AngCharacterCard (AgotPack.CORE_SET, 86, "Joffrey Baratheon", AngFaction.LANNISTER, noLoy, 3, unique, new IcB ().power (), 3, TB.i ());
			case SER_JAIME_LANNISTER_Core: return new AngCharacterCard (AgotPack.CORE_SET, 87, "Ser Jaime Lannister", AngFaction.LANNISTER, noLoy, 6, unique, new IcB ().military ().intrigue (), 5, TB.i ());
			case THE_TICKLER_Core: return new AngCharacterCard (AgotPack.CORE_SET, 88, "The Tickler", AngFaction.LANNISTER, noLoy, 2, unique, new IcB ().military ().intrigue (), 2, TB.i ());
			/*DONE*/case TYRION_LANNISTER_Core: return new AngCharacterCard (AgotPack.CORE_SET, 89, "Tyrion Lannister", AngFaction.LANNISTER, noLoy, 5, unique, new IcB ().intrigue ().power (), 4,
					TB.i ().traits (AngTrait.LORD).stealth ().reaction (RB.i ().afterAChallengeIsInitiated (ChFB.i ().intrigue ()).gainNGold (2, null)));
			case TYWIN_LANNISTER_Core: return new AngCharacterCard (AgotPack.CORE_SET, 90, "Tywin Lannister", AngFaction.LANNISTER, loyal, 7, unique, new IcB ().military ().intrigue ().power (), 6, TB.i ().traits (AngTrait.LORD).renown ().gold (2));
			/*DONE*/case BURNED_MEN_Core: return new AngCharacterCard (AgotPack.CORE_SET, 91, "Burned Men", AngFaction.LANNISTER, noLoy, 2, noUniq, new IcB ().military (), 2, TB.i ().traits (AngTrait.CLANSMAN).ambush (2));
			case GOLD_CLOAKS_Core: return new AngCharacterCard (AgotPack.CORE_SET, 92, "Gold Cloaks", AngFaction.LANNISTER, noLoy, 4, noUniq, new IcB ().military ().power (), 3, TB.i ());
			case LANNISPORT_MONEYLENDER_Core: return new AngCharacterCard (AgotPack.CORE_SET, 93, "Lannisport Moneylender", AngFaction.LANNISTER, noLoy, 2, noUniq, new IcB ().intrigue (), 2, TB.i ());
			/*DONE*/case LANNISPORT_MERCHANT_Core: return new AngCharacterCard (AgotPack.CORE_SET, 94, "Lannisport Merchant", AngFaction.LANNISTER, noLoy, 1, noUniq, new IcB ().power (), 1,
					TB.i ().traits (AngTrait.MERCHANT).limited ().gold (1));
			case THE_QUEENS_ASSASSIN_Core: return new AngCharacterCard (AgotPack.CORE_SET, 95, "The Queen's Assassin", AngFaction.LANNISTER, loyal, 2, noUniq, new IcB ().intrigue (), 2, TB.i ());
			case WIDOWS_WAIL_Core: return new AngAttachmentCard (AgotPack.CORE_SET, 96, "Widow's Wail", AngFaction.LANNISTER, noLoy, 1, unique, TB.i ());
			/*DONE*/case CASTERLY_ROCK_Core: return new AngLocationCard (AgotPack.CORE_SET, 97, "Casterly Rock", AngFaction.LANNISTER, loyal, 2, unique,
					TB.i ().traits (AngTrait.STRONGHOLD, AngTrait.THE_WESTERLANDS).consAbility (CAB.i ().youMayInitiateAnAdditionalChallengeDuringTheChallengePhase (AngIcon.INTRIGUE)));
			/*DONE*/case LANNISPORT_Core: return new AngLocationCard (AgotPack.CORE_SET, 98, "Lannisport", AngFaction.LANNISTER, loyal, 3, unique,
					TB.i ().traits (AngTrait.THE_WESTERLANDS).reaction (RB.i ().afterYouWinAChallenge (ChFB.i ().intrigue ()).drawNCards (1)));
			case WESTERN_FIEFDOM_Core: return new AngLocationCard (AgotPack.CORE_SET, 99, "Western Fiefdom", AngFaction.LANNISTER, noLoy, 0, noUniq, TB.i ());
			case HEAR_ME_ROAR_Core: return new AngEventCard (AgotPack.CORE_SET, 100, "Hear Me Roar!", AngFaction.LANNISTER, loyal, 1, TB.i ());
			case THE_THINGS_I_DO_FOR_LOVE_Core: return new AngEventCard (AgotPack.CORE_SET, 101, "The Things I Do For Love", AngFaction.LANNISTER, noLoy, null, TB.i ());
			case TREACHERY_Core: return new AngEventCard (AgotPack.CORE_SET, 102, "Treachery", AngFaction.LANNISTER, noLoy, 1, TB.i ());
			case AREO_HOTAH_Core: return new AngCharacterCard (AgotPack.CORE_SET, 103, "Areo Hotah", AngFaction.MARTELL, loyal, 3, unique, new IcB ().military (), 5, TB.i ());
			case ARIANNE_MARTELL_Core: return new AngCharacterCard (AgotPack.CORE_SET, 104, "Arianne Martell", AngFaction.MARTELL, noLoy, 5, unique, new IcB ().intrigue ().power (), 4, TB.i ());
			case DORAN_MARTELL_Core: return new AngCharacterCard (AgotPack.CORE_SET, 105, "Doran Martell", AngFaction.MARTELL, loyal, 6, unique, new IcB ().intrigue ().power (), 4, TB.i ());
			case EDRIC_DAYNE_Core: return new AngCharacterCard (AgotPack.CORE_SET, 106, "Edric Dayne", AngFaction.MARTELL, noLoy, 2, unique, new IcB (), 1, TB.i ());
			case MAESTER_CALEOTTE_Core: return new AngCharacterCard (AgotPack.CORE_SET, 107, "Maester Caleotte", AngFaction.MARTELL, noLoy, 3, unique, new IcB ().intrigue ().power (), 2, TB.i ());
			case OBARA_SAND_Core: return new AngCharacterCard (AgotPack.CORE_SET, 108, "Obara Sand", AngFaction.MARTELL, noLoy, 3, unique, new IcB ().military (), 3, TB.i ());
			case THE_RED_VIPER_Core: return new AngCharacterCard (AgotPack.CORE_SET, 109, "The Red Viper", AngFaction.MARTELL, loyal, 7, unique, new IcB ().military ().intrigue ().power (), 7, TB.i ());
			case DESERT_SCAVENGER_Core: return new AngCharacterCard (AgotPack.CORE_SET, 110, "Desert Scavenger", AngFaction.MARTELL, noLoy, 1, noUniq, new IcB ().power (), 1, TB.i ());
			case DORNISH_PARAMOUR_Core: return new AngCharacterCard (AgotPack.CORE_SET, 111, "Dornish Paramour", AngFaction.MARTELL, noLoy, 3, noUniq, new IcB ().intrigue (), 3, TB.i ());
			case GREENBLOOD_TRADER_Core: return new AngCharacterCard (AgotPack.CORE_SET, 112, "Greenblood Trader", AngFaction.MARTELL, loyal, 2, noUniq, new IcB ().intrigue (), 1, TB.i ());
			/*DONE*/case HOUSE_DAYNE_KNIGHT_Core: return new AngCharacterCard (AgotPack.CORE_SET, 113, "House Dayne Knight", AngFaction.MARTELL, noLoy, 2, noUniq, new IcB ().military ().intrigue (), 2,
					TB.i ().traits (AngTrait.HOUSE_DAYNE, AngTrait.KNIGHT));
			/*DONE*/case PALACE_SPEARMAN_Core: return new AngCharacterCard (AgotPack.CORE_SET, 114, "Palace Spearman", AngFaction.MARTELL, noLoy, 4, noUniq, new IcB ().military ().power (), 4,
					TB.i ().traits (AngTrait.GUARD).noAttachments ().consAbility (CAB.i ().whileYouAreNotTheFirstPlayer ().thisGainsAnIcon (AngIcon.INTRIGUE)));
			/*DONE*/case DAWN_Core: return new AngAttachmentCard (AgotPack.CORE_SET, 115, "Dawn", AngFaction.MARTELL, noLoy, 2, unique,
					TB.i ().traits (AngTrait.WEAPON).consAbility (CAB.i ().attachedGetsStrength (1).forEach (CFB.i ().inYourArea (AngArea.USED_PLOT_PILE))).consAbility (CAB.i ().whileAttachedIs (CFB.i ().traits (AngTrait.HOUSE_DAYNE)).attachedGains (AngKeyword.INTIMIDATE)));
			case GHASTON_GREY_Core: return new AngLocationCard (AgotPack.CORE_SET, 116, "Ghaston Grey", AngFaction.MARTELL, loyal, 2, unique,
					TB.i ()/*.traits (AngTrait.DORNE).reaction (RB.i ().afterYouLoseAChallenge (ChFB.i ().asDefendingPlayer ())*/);
			case SUNSPEAR_Core: return new AngLocationCard (AgotPack.CORE_SET, 117, "Sunspear", AngFaction.MARTELL, noLoy, 2, unique, TB.i ());
			/*DONE*/case BLOOD_ORANGE_GROVE_Core: return new AngLocationCard (AgotPack.CORE_SET, 118, "Blood Orange Grove", AngFaction.MARTELL, noLoy, 0, noUniq,
					TB.i ().traits (AngTrait.DORNE).limited ().marshallingAction (AB.i ().kneelThisTo ().reduceTheCostOfTheNextCardYouMarshallThisPhaseByN (CFB.i ().martell (), 1)));
			case DORANS_GAME_Core: return new AngEventCard (AgotPack.CORE_SET, 119, "Doran's Game", AngFaction.MARTELL, loyal, 1, TB.i ());
			case UNBOWED_UNBENT_UNBROKEN_Core: return new AngEventCard (AgotPack.CORE_SET, 120, "Unbowed, Unbent, Unbroken", AngFaction.MARTELL, noLoy, 0, TB.i ());
			case CONFINEMENT_Core: return new AngEventCard (AgotPack.CORE_SET, 121, "Confinement", AngFaction.MARTELL, noLoy, 1, TB.i ());
			case BENJEN_STARK_Core: return new AngCharacterCard (AgotPack.CORE_SET, 122, "Benjen Stark", AngFaction.THENIGHTSWATCH, noLoy, 5, unique, new IcB ().military ().power (), 4,
					TB.i ().traits (AngTrait.RANGER).consAbility (CAB.i ().eachCardCannotBeBypassedByStealth (CFB.i ().traits (AngTrait.RANGER).character ().youControl ()))
					.interrupt (new IB ().whenThisIsKilled ().gainPowerForYourFaction (2))); // TODO then...
			case GHOST_Core: return new AngCharacterCard (AgotPack.CORE_SET, 123, "Ghost", AngFaction.THENIGHTSWATCH, noLoy, 4, unique, new IcB ().military (), 3, TB.i ());
			case JON_SNOW_Core: return new AngCharacterCard (AgotPack.CORE_SET, 124, "Jon Snow", AngFaction.THENIGHTSWATCH, noLoy, 6, unique, new IcB ().intrigue (), 4, TB.i ());
			/*DONE*/case MAESTER_AEMON_Core: return new AngCharacterCard (AgotPack.CORE_SET, 125, "Maester Aemon", AngFaction.THENIGHTSWATCH, noLoy, 3, unique, new IcB ().intrigue (), 2,
					TB.i ().traits (AngTrait.MAESTER, AngTrait.STEWARD).noAttachments ().interrupt (new IB ().whenACharacterWouldBeKilled (CFB.i ().theNightsWatch ()).kneelThisTo ().saveIt ()));
			case OLD_BEAR_MORMONT_Core: return new AngCharacterCard (AgotPack.CORE_SET, 126, "Old Bear Mormont", AngFaction.THENIGHTSWATCH, loyal, 7, unique, new IcB ().military ().power (), 6, TB.i ());
			/*DONE*/case SAMWELL_TARLY_Core: return new AngCharacterCard (AgotPack.CORE_SET, 127, "Samwell Tarly", AngFaction.THENIGHTSWATCH, loyal, 2, unique, new IcB ().intrigue (), 1,
					TB.i ().traits (AngTrait.STEWARD).insight ().reserve (1));
			/*DONE*/case SER_WAYMAR_ROYCE_Core: return new AngCharacterCard (AgotPack.CORE_SET, 128, "Ser Waymar Royce", AngFaction.THENIGHTSWATCH, noLoy, 3, unique, new IcB ().military ().power (), 3,
					TB.i ().traits (AngTrait.KNIGHT, AngTrait.RANGER).noAttachmentsExcept (AngTrait.WEAPON)
					.interrupt (new IB ().whenThisIsKilled ().discardNCardsAtRandomFromEachPlayerHand (1, PFB.i ().eachOpponents ())));
			/*DONE*/case YOREN_Core: return new AngCharacterCard (AgotPack.CORE_SET, 129, "Yoren", AngFaction.THENIGHTSWATCH, loyal, 3, unique, new IcB ().intrigue (), 2,
					TB.i ().traits (AngTrait.WANDERING_CROW).reaction (RB.i ().afterYouMarshallThis ().chooseACard (CFB.i ().character ().withPrintedCostOrLower (3).inOpponentArea (AngArea.DISCARD_PILE)).andPutItIntoPlayUnderYourControl ()));
			/*DONE*/case MESSENGER_RAVEN_Core: return new AngCharacterCard (AgotPack.CORE_SET, 130, "Messenger Raven", AngFaction.THENIGHTSWATCH, loyal, 1, noUniq, new IcB (), 1,
					TB.i ().traits (AngTrait.RAVEN).noAttachments ().dominanceAction (AB.i ().returnThisToYourHandTo ().drawNCards (1)));
			/*DONE*/case OLD_FOREST_HUNTER_Core: return new AngCharacterCard (AgotPack.CORE_SET, 131, "Old Forest Hunter", AngFaction.THENIGHTSWATCH, loyal, 2, noUniq, new IcB ().military (), 1,
					TB.i ().traits (AngTrait.RANGER).noAttachmentsExcept (AngTrait.WEAPON).action (AB.i ().discardNCardsFromYourHandTo (1).gainNGold (1, null).limitPerPhase (1)));
			/*DONE*/case RANGING_PARTY_Core: return new AngCharacterCard (AgotPack.CORE_SET, 132, "Ranging Party", AngFaction.THENIGHTSWATCH, noLoy, 4, noUniq, new IcB ().military ().power (), 5,
					TB.i ().traits (AngTrait.ARMY, AngTrait.RANGER).noAttachmentsExcept (AngTrait.WEAPON));
			/*DONE*/case STEWARD_AT_THE_WALL_Core: return new AngCharacterCard (AgotPack.CORE_SET, 133, "Steward at the Wall", AngFaction.THENIGHTSWATCH, noLoy, 1, noUniq, new IcB ().intrigue (), 1,
					TB.i ().traits (AngTrait.ALLY, AngTrait.STEWARD).marshallingAction (AB.i ().kneelThisTo ().reduceTheCostOfTheNextCardYouMarshallThisPhaseByN (CFB.i ().theNightsWatch ().character (), 1)));
			/*DONE*/case VETERAN_BUILDER_Core: return new AngCharacterCard (AgotPack.CORE_SET, 134, "Veteran Builder", AngFaction.THENIGHTSWATCH, noLoy, 3, noUniq, new IcB ().power (), 4,
					TB.i ().traits (AngTrait.BUILDER).noAttachmentsExcept (AngTrait.WEAPON).action (AB.i ().sacrificeThisTo ().chooseACard (CFB.i ().location ()).andStandIt ()));
			/*DONE*/case LONGCLAW_Core: return new AngAttachmentCard (AgotPack.CORE_SET, 135, "Longclaw", AngFaction.THENIGHTSWATCH, noLoy, 2, unique,
					TB.i ().traits (AngTrait.VALYRIAN_STEEL, AngTrait.WEAPON).only (CFB.i ().theNightsWatch ().character ())
					.consAbility (CAB.i ().and (new AngConsEffects.AngAttachedGetsStrength (1), new AngConsEffects.AngAttachedGainsAKeyword (new AngTextKeyword (AngKeyword.RENOWN, null, null)))));
			case CASTLE_BLACK_Core: return new AngLocationCard (AgotPack.CORE_SET, 136, "Castle Black", AngFaction.THENIGHTSWATCH, noLoy, 2, unique, TB.i ());
			/*DONE*/case THE_WALL_Core: return new AngLocationCard (AgotPack.CORE_SET, 137, "The Wall", AngFaction.THENIGHTSWATCH, noLoy, 4, unique,
					TB.i ().traits (AngTrait.STRONGHOLD, AngTrait.THE_NORTH).consAbility (CAB.i ().eachCardGetsStrength (CFB.i ().theNightsWatch ().character ().youControl (), 1))
					.forcedReaction (RB.i ().afterYouLoseAChallenge (ChFB.i ().unopposed ()).kneelThis ())
					.interrupt (new IB ().whenThePhaseEnds (AngPhase.CHALLENGES).kneelThisTo ().gainPowerForYourFaction (2)));
			case A_MEAGER_CONTRIBUTION_Core: return new AngEventCard (AgotPack.CORE_SET, 138, "A Meager Contribution", AngFaction.THENIGHTSWATCH, loyal, 0, TB.i ());
			/*DONE*/case TAKE_THE_BLACK_Core: return new AngEventCard (AgotPack.CORE_SET, 139, "Take the Black", AngFaction.THENIGHTSWATCH, loyal, 3,
					TB.i ().dominanceAction (AB.i ().chooseACard (CFB.i ().nonUnique ().character ().withPrintedCostOrLower (6)).andTakeControlOfThat ().maxPerRound (1)));
			case THE_SWORD_IN_THE_DARKNESS_Core: return new AngEventCard (AgotPack.CORE_SET, 140, "The Sword in the Darkness", AngFaction.THENIGHTSWATCH, noLoy, 1, TB.i ());
			case ARYA_STARK_Core: return new AngCharacterCard (AgotPack.CORE_SET, 141, "Arya Stark", AngFaction.STARK, noLoy, 3, unique, new IcB ().power (), 2, TB.i ());
			case BRAN_STARK_Core: return new AngCharacterCard (AgotPack.CORE_SET, 142, "Bran Stark", AngFaction.STARK, noLoy, 2, unique, new IcB ().power (), 1, TB.i ());
			/*DONE*/case CATELYN_STARK_Core: return new AngCharacterCard (AgotPack.CORE_SET, 143, "Catelyn Stark", AngFaction.STARK, loyal, 4, unique, new IcB ().intrigue ().power (), 4,
					TB.i ().traits (AngTrait.HOUSE_TULLY, AngTrait.LADY, AngTrait.THE_SEVEN).consAbility (CAB.i ().whileThisIsPartecipating (ChFB.i ()).yourOpponentsCannotTriggerCardAbilities ()));
			case EDDARD_STARK_Core: return new AngCharacterCard (AgotPack.CORE_SET, 144, "Eddard Stark", AngFaction.STARK, noLoy, 7, unique, new IcB ().military ().power (), 5, TB.i ());
			/*DONE*/case GREY_WIND_Core: return new AngCharacterCard (AgotPack.CORE_SET, 145, "Grey Wind", AngFaction.STARK, loyal, 5, unique, new IcB ().military (), 4,
					TB.i ().traits (AngTrait.DIREWOLF).intimidate ().noAttachments ().challengesAction (AB.i ().kneelThisTo ()
							.chooseACard (CFB.i ().character ().withStrengthOrLower (1, new AngAPlayerControls (true, CFB.i ().title ("Robb Stark").build ()), 2)).andKillIt ()));
			/*DONE*/case ROBB_STARK_Core: return new AngCharacterCard (AgotPack.CORE_SET, 146, "Robb Stark", AngFaction.STARK, loyal, 6, unique, new IcB ().military ().power (), 5,
					TB.i ().traits (AngTrait.LORD).renown ().reaction (RB.i ().afterACardIsSacrificedOrKilled (CFB.i ().stark ().character ().youControl ()).standEachCard (CFB.i ().character ().youControl ()).limitPerRound (1)));
			case SANSA_STARK_Core: return new AngCharacterCard (AgotPack.CORE_SET, 147, "Sansa Stark", AngFaction.STARK, noLoy, 3, unique, new IcB ().intrigue ().power (), 2, TB.i ());
			case SUMMER_Core: return new AngCharacterCard (AgotPack.CORE_SET, 148, "Summer", AngFaction.STARK, loyal, 3, unique, new IcB ().military (), 3, TB.i ());
			/*DONE*/case DIREWOLF_PUP_Core: return new AngCharacterCard (AgotPack.CORE_SET, 149, "Direwolf Pup", AngFaction.STARK, noLoy, 2, noUniq, new IcB ().military (), 1,
					TB.i ().traits (AngTrait.DIREWOLF).noAttachments ().consAbility (CAB.i ().thisGetsStrength (1).forEach (CFB.i ().other ().traits (AngTrait.DIREWOLF).youControl ())));
			/*DONE*/case TUMBLESTONE_KNIGHT_Core: return new AngCharacterCard (AgotPack.CORE_SET, 150, "Tumblestone Knight", AngFaction.STARK, noLoy, 2, noUniq, new IcB ().military ().power (), 2,
					TB.i ().traits (AngTrait.HOUSE_TULLY, AngTrait.KNIGHT));
			case VANGUARD_OF_THE_NORTH_Core: return new AngCharacterCard (AgotPack.CORE_SET, 151, "Vanguard of the North", AngFaction.STARK, noLoy, 4, noUniq, new IcB ().military (), 4, TB.i ());
			case WINTERFELL_STEWARD_Core: return new AngCharacterCard (AgotPack.CORE_SET, 152, "Winterfell Steward", AngFaction.STARK, noLoy, 1, noUniq, new IcB ().power (), 1, TB.i ());
			/*DONE*/case ICE_Core: return new AngAttachmentCard (AgotPack.CORE_SET, 153, "Ice", AngFaction.STARK, loyal, 3, unique,
					TB.i ().traits (AngTrait.VALYRIAN_STEEL, AngTrait.WEAPON).only (CFB.i ().stark ().character ()).consAbility (CAB.i ().attachedGetsStrength (2))
					.reaction (RB.i ().afterYouWinAChallenge (ChFB.i ().inWhichAttachedIsPartecipating ()).sacrificeThisTo ().chooseACard (CFB.i ().character ().controlledByTheLosingOpponent ()).andKillIt ()));
			case GATES_OF_WINTERFELL_Core: return new AngLocationCard (AgotPack.CORE_SET, 154, "Gates of Winterfell", AngFaction.STARK, noLoy, 2, unique, TB.i ());
			case THE_WOLFSWOOD_Core: return new AngLocationCard (AgotPack.CORE_SET, 155, "The Wolfswood", AngFaction.STARK, noLoy, 1, unique, TB.i ());
			/*DONE*/case HEART_TREE_GROVE_Core: return new AngLocationCard (AgotPack.CORE_SET, 156, "Heart Tree Grove", AngFaction.STARK, noLoy, 0, noUniq,
					TB.i ().traits (AngTrait.OLD_GODS, AngTrait.WINTERFELL).limited ()
					.marshallingAction (AB.i ().reduceTheCostOfTheNextCardYouMarshallThisPhaseByN (CFB.i ().stark ().character (), 1)));
			case FOR_THE_NORTH_Core: return new AngEventCard (AgotPack.CORE_SET, 157, "For the North!", AngFaction.STARK, noLoy, 0, TB.i ());
			case LIKE_WARM_RAIN_Core: return new AngEventCard (AgotPack.CORE_SET, 158, "Like Warm Rain", AngFaction.STARK, noLoy, 1, TB.i ());
			case WINTER_IS_COMING_Core: return new AngEventCard (AgotPack.CORE_SET, 159, "Winter Is Coming", AngFaction.STARK, loyal, 1, TB.i ());
			case DAENERYS_TARGARYEN_Core: return new AngCharacterCard (AgotPack.CORE_SET, 160, "Daenerys Targaryen", AngFaction.TARGARYEN, loyal, 7, unique, new IcB ().intrigue ().power (), 5, TB.i ());
			/*DONE*/case DROGON_Core: return new AngCharacterCard (AgotPack.CORE_SET, 161, "Drogon", AngFaction.TARGARYEN, noLoy, 3, unique, new IcB ().military (), 4,
					TB.i ().traits (AngTrait.DRAGON, AngTrait.HATCHLING).noAttachments ().consAbility (CAB.i ().eachCardGains (CFB.i ().traits (AngTrait.STORMBORN).character ().youControl (), AngKeyword.RENOWN)));
			/*DONE*/case KHAL_DROGO_Core: return new AngCharacterCard (AgotPack.CORE_SET, 162, "Khal Drogo", AngFaction.TARGARYEN, loyal, 6, unique, new IcB ().military ().power (), 5,
					TB.i ().traits (AngTrait.DOTHRAKY, AngTrait.LORD).consAbility (CAB.i ().youMayInitiateAnAdditionalChallengeDuringTheChallengePhase (AngIcon.MILITARY)));
			/*DONE*/case MAGISTER_ILLYRIO_Core: return new AngCharacterCard (AgotPack.CORE_SET, 163, "Magister Illyrio", AngFaction.TARGARYEN, noLoy, 5, unique, new IcB ().intrigue ().power (), 4,
					TB.i ().traits (AngTrait.LORD, AngTrait.MERCHANT).action (AB.i ().payNGoldTo (2).chooseACard (CFB.i ().character ()).andStandIt ()));
			case RHAEGAL_Core: return new AngCharacterCard (AgotPack.CORE_SET, 164, "Rhaegal", AngFaction.TARGARYEN, noLoy, 3, unique, new IcB ().military ().intrigue (), 3, TB.i ());
			case SER_JORAH_MORMONT_Core: return new AngCharacterCard (AgotPack.CORE_SET, 165, "Ser Jorah Mormont", AngFaction.TARGARYEN, noLoy, 2, unique, new IcB ().military ().intrigue (), 4, TB.i ());
			/*DONE*/case VISERION_Core: return new AngCharacterCard (AgotPack.CORE_SET, 166, "Viserion", AngFaction.TARGARYEN, noLoy, 2, unique, new IcB ().military ().power (), 2,
					TB.i ().traits (AngTrait.DRAGON, AngTrait.HATCHLING).noAttachments ().consAbility (CAB.i ().eachCardGains (CFB.i ().traits (AngTrait.STORMBORN).character ().youControl (), AngKeyword.STEALTH)));
			/*DONE*/case VISERYS_TARGARYEN_Core: return new AngCharacterCard (AgotPack.CORE_SET, 167, "Viserys Targaryen", AngFaction.TARGARYEN, loyal, 1, unique, new IcB ().power (), 1,
					TB.i ().traits (AngTrait.LORD).interrupt (new IB ().whenThisLeavesPlay ().chooseACard (CFB.i ().attachment ()).andDiscardItFromPlay ()));
			/*DONE*/case BRAIDED_WARRIOR_Core: return new AngCharacterCard (AgotPack.CORE_SET, 168, "Braided Warrior", AngFaction.TARGARYEN, noLoy, 2, noUniq, new IcB ().military (), 3,
					TB.i ().traits (AngTrait.DOTHRAKY).noAttachmentsExcept (AngTrait.WEAPON));
			/*DONE*/case HANDMAIDEN_Core: return new AngCharacterCard (AgotPack.CORE_SET, 169, "Handmaiden", AngFaction.TARGARYEN, noLoy, 2, noUniq, new IcB ().intrigue ().power (), 1,
					TB.i ().traits (AngTrait.ALLY, AngTrait.COMPANION).action (AB.i ().sacrificeThisTo ().chooseACard (CFB.i ().traits (AngTrait.LADY).character ()).andStandIt ()));
			/*DONE*/case TARGARYEN_LOYALIST_Core: return new AngCharacterCard (AgotPack.CORE_SET, 170, "Targaryen Loyalist", AngFaction.TARGARYEN, noLoy, 1, noUniq, new IcB ().power (), 1,
					TB.i ().traits (AngTrait.ALLY).marshallingAction (AB.i ().kneelThisTo ().reduceTheCostOfTheNextCardYouMarshallThisPhaseByN (CFB.i ().character ().targaryen (), 1)));
			case UNSULLIED_Core: return new AngCharacterCard (AgotPack.CORE_SET, 171, "Unsullied", AngFaction.TARGARYEN, noLoy, 4, noUniq, new IcB ().military ().power (), 3, TB.i ());
			case DROGOS_ARAKH_Core: return new AngAttachmentCard (AgotPack.CORE_SET, 172, "Drogo's Arakh", AngFaction.TARGARYEN, noLoy, 2, unique, TB.i ());
			case PLAZA_OF_PUNISHMENT_Core: return new AngLocationCard (AgotPack.CORE_SET, 173, "Plaza of Punishment", AngFaction.TARGARYEN, loyal, 3, unique,
					TB.i ().traits (AngTrait.ASTAPOR).reaction (RB.i ().afterYouWinAChallenge (ChFB.i ().power ()).kneelThisTo ().chooseACard (CFB.i ().character ().withoutAttachments ())
						.untilTheEndOfThePhase ().thatCardGetsStrength (-2)));
			case DOTHRAKI_SEA_Core: return new AngLocationCard (AgotPack.CORE_SET, 174, "Dothraki Sea", AngFaction.TARGARYEN, noLoy, 1, unique, TB.i ());
			case ILLYRIOS_ESTATE_Core: return new AngLocationCard (AgotPack.CORE_SET, 175, "Illyrio's Estate", AngFaction.TARGARYEN, noLoy, 0, noUniq, TB.i ());
			case DRACARYS_Core: return new AngEventCard (AgotPack.CORE_SET, 176, "Dracarys!", AngFaction.TARGARYEN, loyal, 1,
					TB.i ()/*.action (AB.i ().kneelACardTo (CFB.i ().traits (AngTrait.DRAGON).character ()))*/);
			case FIRE_AND_BLOOD_Core: return new AngEventCard (AgotPack.CORE_SET, 177, "Fire and Blood", AngFaction.TARGARYEN, loyal, 1,
					TB.i ().challengesAction (AB.i ().chooseACard (CFB.i ().unique ().targaryen ().character ().inYourArea (AngArea.DEAD_PILE)).andShuffleItBackIntoYourDeck ()));
			case WAKING_THE_DRAGON_Core: return new AngEventCard (AgotPack.CORE_SET, 178, "Waking the Dragon", AngFaction.TARGARYEN, noLoy, 0, TB.i ());
			/*DONE*/case LEFT_Core: return new AngCharacterCard (AgotPack.CORE_SET, 179, "Left", AngFaction.TYRELL, noLoy, 2, unique, new IcB ().military (), 2,
					TB.i ().traits (AngTrait.GUARD).noAttachmentsExcept (AngTrait.WEAPON).consAbility (CAB.i ().whileYouControl (CFB.i ().title ("Right"))
							.and (new AngThisGetsStrength (1), new AngThisGainsAnIcon (AngIcon.POWER), new AngThisDoesNotKneelWhenDeclared (false))));
			case MAESTER_LOMYS_Core: return new AngCharacterCard (AgotPack.CORE_SET, 180, "Maester Lomys", AngFaction.TYRELL, noLoy, 3, unique, new IcB ().intrigue (), 3, TB.i ());
			case MARGAERY_TYRELL_Core: return new AngCharacterCard (AgotPack.CORE_SET, 181, "Margaery Tyrell", AngFaction.TYRELL, noLoy, 3, unique, new IcB ().intrigue ().power (), 3, TB.i ());
			case PAXTER_REDWYNE_Core: return new AngCharacterCard (AgotPack.CORE_SET, 182, "Paxter Redwyne", AngFaction.TYRELL, loyal, 4, unique, new IcB ().intrigue (), 3, TB.i ());
			case RANDYLL_TARLY_Core: return new AngCharacterCard (AgotPack.CORE_SET, 183, "Randyll Tarly", AngFaction.TYRELL, noLoy, 6, unique, new IcB ().military ().power (), 5, TB.i ());
			/*DONE*/case RIGHT_Core: return new AngCharacterCard (AgotPack.CORE_SET, 184, "Right", AngFaction.TYRELL, noLoy, 2, unique, new IcB ().military (), 2,
					TB.i ().traits (AngTrait.GUARD).noAttachmentsExcept (AngTrait.WEAPON).consAbility (CAB.i ().whileYouControl (CFB.i ().title ("Left"))
							.and (new AngThisGetsStrength (1), new AngThisGainsAnIcon (AngIcon.INTRIGUE), new AngThisDoesNotKneelWhenDeclared (false))));
			case THE_KNIGHT_OF_FLOWERS_Core: return new AngCharacterCard (AgotPack.CORE_SET, 185, "The Knight of Flowers", AngFaction.TYRELL, noLoy, 5, unique, new IcB ().military ().power (), 5,
					TB.i ().traits (AngTrait.KNIGHT, AngTrait.LORD).renown ()); // TODO .consAbility (CAB.i ().whileThisIsPartecipating (challengeFilterBuilder)));
			case THE_QUEEN_OF_THORNS_Core: return new AngCharacterCard (AgotPack.CORE_SET, 186, "The Queen of Thorns", AngFaction.TYRELL, loyal, 7, unique, new IcB ().intrigue ().power (), 5, TB.i ());
			/*DONE*/case COURTESAN_OF_THE_ROSE_Core: return new AngCharacterCard (AgotPack.CORE_SET, 187, "Courtesan of the Rose", AngFaction.TYRELL, noLoy, 2, noUniq, new IcB ().intrigue ().power (), 2,
					TB.i ().traits (AngTrait.COMPANION, AngTrait.SPY));
			/*DONE*/case GARDEN_CARETAKER_Core: return new AngCharacterCard (AgotPack.CORE_SET, 188, "Garden Caretaker", AngFaction.TYRELL, noLoy, 1, noUniq, new IcB ().power (), 1,
					TB.i ().traits (AngTrait.ALLY).marshallingAction (AB.i ().kneelThisTo ().reduceTheCostOfTheNextCardYouMarshallThisPhaseByN (CFB.i ().tyrell ().character (), 1)));
			case OLENNAS_INFORMANT_Core: return new AngCharacterCard (AgotPack.CORE_SET, 189, "Olenna's Informant", AngFaction.TYRELL, noLoy, 3, noUniq, new IcB ().intrigue ().power (), 2, TB.i ());
			/*DONE*/case WARDENS_OF_THE_REACH_Core: return new AngCharacterCard (AgotPack.CORE_SET, 190, "Wardens of the Reach", AngFaction.TYRELL, noLoy, 4, noUniq, new IcB ().military ().power (), 3,
					TB.i ().traits (AngTrait.ARMY).noAttachments ().consAbility (CAB.i ().thisGetsStrength (1).forEach (CFB.i ().traits (AngTrait.THE_REACH).location ().youControl ())));
			case HEARTSBANE_Core: return new AngAttachmentCard (AgotPack.CORE_SET, 191, "Heartsbane", AngFaction.TYRELL, noLoy, 1, unique, TB.i ());
			case HIGHGARDEN_Core: return new AngLocationCard (AgotPack.CORE_SET, 192, "Highgarden", AngFaction.TYRELL, loyal, 3, unique, TB.i ());
			/*DONE*/case THE_MANDER_Core: return new AngLocationCard (AgotPack.CORE_SET, 193, "The Mander", AngFaction.TYRELL, loyal, 3, unique,
					TB.i ().traits (AngTrait.THE_REACH).reaction (RB.i ().afterYouWinAChallenge (ChFB.i ().byNOrMoreSTR (5)).kneelThisTo ().drawNCards (2)));
			/*DONE*/case ROSE_GARDEN_Core: return new AngLocationCard (AgotPack.CORE_SET, 194, "Rose Garden", AngFaction.TYRELL, noLoy, 0, noUniq,
					TB.i ().traits (AngTrait.THE_REACH).limited ().marshallingAction (AB.i ().kneelThisTo ().reduceTheCostOfTheNextCardYouMarshallThisPhaseByN (CFB.i ().tyrell (), 1)));
			case GROWING_STRONG_Core: return new AngEventCard (AgotPack.CORE_SET, 195, "Growing Strong", AngFaction.TYRELL, noLoy, 1, TB.i ());
			case OLENNAS_CUNNING_Core: return new AngEventCard (AgotPack.CORE_SET, 196, "Olenna's Cunning", AngFaction.TYRELL, loyal, 2, TB.i ());
			case THE_BEAR_AND_THE_MAIDEN_FAIR_Core: return new AngEventCard (AgotPack.CORE_SET, 197, "\"The Bear and the Maiden Fair\"", AngFaction.TYRELL, noLoy, 0, TB.i ());
			case BANNER_OF_THE_STAG_Core: return new AngAgendaCard (AgotPack.CORE_SET, 198, "Banner of the Stag", AngFaction.NEUTRAL, TB.i ());
			case BANNER_OF_THE_KRAKEN_Core: return new AngAgendaCard (AgotPack.CORE_SET, 199, "Banner of the Kraken", AngFaction.NEUTRAL, TB.i ());
			case BANNER_OF_THE_LION_Core: return new AngAgendaCard (AgotPack.CORE_SET, 200, "Banner of the Lion", AngFaction.NEUTRAL, TB.i ());
			case BANNER_OF_THE_SUN_Core: return new AngAgendaCard (AgotPack.CORE_SET, 201, "Banner of the Sun", AngFaction.NEUTRAL, TB.i ());
			case BANNER_OF_THE_WATCH_Core: return new AngAgendaCard (AgotPack.CORE_SET, 202, "Banner of the Watch", AngFaction.NEUTRAL, TB.i ());
			case BANNER_OF_THE_WOLF_Core: return new AngAgendaCard (AgotPack.CORE_SET, 203, "Banner of the Wolf", AngFaction.NEUTRAL, TB.i ());
			case BANNER_OF_THE_DRAGON_Core: return new AngAgendaCard (AgotPack.CORE_SET, 204, "Banner of the Dragon", AngFaction.NEUTRAL, TB.i ());
			case BANNER_OF_THE_ROSE_Core: return new AngAgendaCard (AgotPack.CORE_SET, 205, "Banner of the Rose", AngFaction.NEUTRAL, TB.i ());
			default: return null;
		} // switch - case
	} // create
	
} // AgotCardCreator
