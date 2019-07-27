package com.motif.agot.ang.sets;

import io.leangen.graphql.annotations.GraphQLEnumValue;
import lombok.Getter;

public enum AgotCardSeed {
	@GraphQLEnumValue(description="" +
		"<h5>The Power of Wealth</h5>" +
		"Neutral.<br>" +
		"When you announce The Power of Wealth as your agenda, name 1 faction. You may include cards from that faction in your draw deck and plot deck.Reduce the cost of the first in-faction card you marshal or play each round by 1.<b>Draft format only.</b>.<br>" +
		"<i>Valyrian Draft Set.</i><br>"
	)
	THE_POWER_OF_WEALTH_VDS ("00001"),
	@GraphQLEnumValue(description="" +
		"<h5>Protectors of the Realm (VDS)</h5>" +
		"Neutral.<br>" +
		"You may include <i>Knight</i> and <i>Army</i> characters from any faction in your deck.<b>Action:</b> Kneel your faction card to choose a <i>Knight</i> or <i>Army</i> character. Until the end of the phase, that character gains renown.<b>Draft format only.</b>.<br>" +
		"<i>Valyrian Draft Set.</i><br>"
	)
	PROTECTORS_OF_THE_REALM_VDS ("00002"),
	@GraphQLEnumValue(description="" +
		"<h5>Treaty</h5>" +
		"Neutral.<br>" +
		"When you announce Treaty as your agenda, name 2 factions. You may include cards from those factions in your draw deck and plot deck.<b>Action:</b> Kneel your faction card to draw 1 card. Then, choose and discard 1 card from your hand.<b>Draft format only.</b>.<br>" +
		"<i>Valyrian Draft Set.</i><br>"
	)
	TREATY_VDS ("00003"),
	@GraphQLEnumValue(description="" +
		"<h5>Uniting the Seven Kingdoms</h5>" +
		"Neutral.<br>" +
		"You may include cards from any faction in your draw deck.Increase the cost of each out-of-faction card you marshal or play by 1.<b>Draft format only.</b>.<br>" +
		"<i>Valyrian Draft Set.</i><br>"
	)
	UNITING_THE_SEVEN_KINGDOMS_VDS ("00004"),
	@GraphQLEnumValue(description="" +
		"<h5>House Bannerman</h5>" +
		"Neutral.<br>" +
		"<b><i>Ally.</i></b><br>" +
		"<b>Marshaling Action:</b> Kneel House Bannerman to reduce the cost of the next in-faction character you marshal this phase by 1.<b>Draft format only.</b>.<br>" +
		"<i>Valyrian Draft Set.</i><br>"
	)
	HOUSE_BANNERMAN_VDS ("00005"),
	@GraphQLEnumValue(description="" +
		"<h5>Feast or Famine</h5>" +
		"Neutral.<br>" +
		"<b><i>Summer. Winter.</i></b><br>" +
		"<b>When Revealed:</b> You may increase the gold value on Feast or Famine by 5. If you do, reduce the claim value on Feast of Famine by 2.<b>Draft format only.</b>.<br>" +
		"<i>Valyrian Draft Set.</i><br>"
	)
	FEAST_OR_FAMINE_VDS ("00006"),
	@GraphQLEnumValue(description="" +
		"<h5>Summoned by the Conclave</h5>" +
		"Neutral.<br>" +
		"<b><i>Kingdom.</i></b><br>" +
		"<b>When Revealed:</b> Search the top 10 cards of your deck for an in-faction card, reveal it, and add it to your hand. Shuffle your deck.<b>Draft format only.</b>.<br>" +
		"<i>Valyrian Draft Set.</i><br>"
	)
	SUMMONED_BY_THE_CONCLAVE_VDS ("00007"),
	@GraphQLEnumValue(description="" +
		"<h5>The Pale Mare</h5>" +
		"Neutral.<br>" +
		"<b><i>Omen.</i></b><br>" +
		"<b>When Revealed:</b> Each player chooses any number of characters he or she controls with total printed cost 10 or lower. Kill each character not chosen (cannot be saved).<b>Draft format only.</b>.<br>" +
		"<i>Valyrian Draft Set.</i><br>"
	)
	THE_PALE_MARE_VDS ("00008"),
	@GraphQLEnumValue(description="" +
		"<h5>Compelled by the King</h5>" +
		"House Baratheon.<br>" +
		"<b>Reaction:</b> After the dominance phase begins, choose and stand a character you control. If you win dominance this phase, that character gains 1 power.<b>Draft format only.</b>.<br>" +
		"<i>Valyrian Draft Set.</i><br>"
	)
	COMPELLED_BY_THE_KING_VDS ("00009"),
	@GraphQLEnumValue(description="" +
		"<h5>Support of Saltcliffe</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Condition.</i></b><br>" +
		"[greyjoy] character only.Attached character gains stealth.<b>Reaction:</b> After you win an unopposed challenge in which attached character is attacking, stand attached character.<b>Draft format only.</b>.<br>" +
		"<i>Valyrian Draft Set.</i><br>"
	)
	SUPPORT_OF_SALTCLIFFE_VDS ("00010"),
	@GraphQLEnumValue(description="" +
		"<h5>Tyrion Lannister (VDS)</h5>" +
		"House Lannister.<br>" +
		"<b><i>Lord.</i></b><br>" +
		"Stealth.<b>Reaction:</b> After you win an [intrigue] challenge or a challenge in which Tyrion Lannister is participating, pay 1 gold to draw 1 card.<b>Draft format only.</b>.<br>" +
		"<i>Valyrian Draft Set.</i><br>"
	)
	TYRION_LANNISTER_VDS ("00011"),
	@GraphQLEnumValue(description="" +
		"<h5>The Viper's Rage</h5>" +
		"House Martell.<br>" +
		"<b>Reaction:</b> After you lose a challenge by 5 or more STR as the defending player, each character controlled by the attacking player loses a [military], an [intrigue], and a [power] icon until the end of the phase.<b>Draft format only.</b>.<br>" +
		"<i>Valyrian Draft Set.</i><br>"
	)
	THE_VIPERS_RAGE_VDS ("00012"),
	@GraphQLEnumValue(description="" +
		"<h5>The Nightfort</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>The North.</i></b><br>" +
		"<b>Challenges Action:</b> Kneel The Nightfort to choose a defending [thenightswatch] character. Until the end of the challenge, that character gets +1 STR for each attacking character.<b>Draft format only.</b>.<br>" +
		"<i>Valyrian Draft Set.</i><br>"
	)
	THE_NIGHTFORT_VDS ("00013"),
	@GraphQLEnumValue(description="" +
		"<h5>Raventree Elite</h5>" +
		"House Stark.<br>" +
		"<b><i>Army. House Tully.</i></b><br>" +
		"No attachments. Stealth.Each <i>House Tully</i> you control gains \"immune to opponents' triggered effects\" while it is participating in a challenge.<b>Draft format only.</b>.<br>" +
		"<i>Valyrian Draft Set.</i><br>"
	)
	RAVENTREE_ELITE_VDS ("00014"),
	@GraphQLEnumValue(description="" +
		"<h5>Deadly Khalasar</h5>" +
		"House Targaryen.<br>" +
		"<b>Challenges Action:</b> Choose an attacking [targaryen] character you control. Until the end of the challenge, that character gets +1 STR for each <i>Dothraki</i> character you control and gains intimidate.<b>Draft format only.</b>.<br>" +
		"<i>Valyrian Draft Set.</i><br>"
	)
	DEADLY_KHALASAR_VDS ("00015"),
	@GraphQLEnumValue(description="" +
		"<h5>Blackcrown Knights</h5>" +
		"House Tyrell.<br>" +
		"<b><i>Army. Knight.</i></b><br>" +
		"No attachments.<b>Reaction:</b> After you win a [power] challenge in which Blackcrown Knights is participating, discard 1 card from your hand to have Blackcrown Knights gain 2 power.<b>Draft format only.</b>.<br>" +
		"<i>Valyrian Draft Set.</i><br>"
	)
	BLACKCROWN_KNIGHTS_VDS ("00016"),
	@GraphQLEnumValue(description="" +
		"<h5>Lyn Corbray (VDS)</h5>" +
		"Neutral.<br>" +
		"<b><i>House Arryn. Knight.</i></b><br>" +
		"Stealth.Each non-<i>Army</i> character you control with printed cost 6 or higher gets +2 STR.<b>Draft format only.</b>.<br>" +
		"<i>Valyrian Draft Set.</i><br>"
	)
	LYN_CORBRAY_VDS ("00017"),
	@GraphQLEnumValue(description="" +
		"<h5>Hollow Hill</h5>" +
		"Neutral.<br>" +
		"<b><i>Westeros.</i></b><br>" +
		"<b>Reaction:</b> After you marshal a character with a faction affiliation that does not match any other card you control, draw 1 card.<b>Draft format only.</b>.<br>" +
		"<i>Valyrian Draft Set.</i><br>"
	)
	HOLLOW_HILL_VDS ("00018"),
	@GraphQLEnumValue(description="" +
		"<h5>Muster</h5>" +
		"Neutral.<br>" +
		"<b>Marshaling Action:</b> Kneel a <i>Knight</i> character to search your deck for a <i>Knight</i> character, reveal it, and add it to your hand. Shuffle your deck.<b>Draft format only.</b>.<br>" +
		"<i>Valyrian Draft Set.</i><br>"
	)
	MUSTER_VDS ("00019"),
	@GraphQLEnumValue(description="" +
		"<h5>Holding the Trident</h5>" +
		"Neutral.<br>" +
		"<b><i>War.</i></b><br>" +
		"While you control fewer characters than each opponent, each character you control gets +2 STR.<b>Draft format only.</b>.<br>" +
		"<i>Valyrian Draft Set.</i><br>"
	)
	HOLDING_THE_TRIDENT_VDS ("00020"),
	@GraphQLEnumValue(description="" +
		"<h5>Common Cause</h5>" +
		"Neutral.<br>" +
		"<b><i>Edict.</i></b><br>" +
		"X is the number of different faction affiliations among characters you control.<b>Draft format only.</b>.<br>" +
		"<i>Valyrian Draft Set.</i><br>"
	)
	COMMON_CAUSE_VDS ("00021"),
	@GraphQLEnumValue(description="" +
		"<h5>A Clash of Kings</h5>" +
		"Neutral.<br>" +
		"<b><i>Noble.</i></b><br>" +
		"<b>Reaction:</b> After you win a [power] challenge, move 1 power from the losing opponent's faction card to your own..<br>" +
		"<i>Core Set.</i><br>"
	)
	A_CLASH_OF_KINGS_Core ("01001"),
	@GraphQLEnumValue(description="" +
		"<h5>A Feast for Crows</h5>" +
		"Neutral.<br>" +
		"<b><i>Edict.</i></b><br>" +
		"<b>Reaction:</b> After you win dominance, gain 2 power for your faction..<br>" +
		"<i>Core Set.</i><br>"
	)
	A_FEAST_FOR_CROWS_Core ("01002"),
	@GraphQLEnumValue(description="" +
		"<h5>A Game of Thrones</h5>" +
		"Neutral.<br>" +
		"<b><i>Scheme.</i></b><br>" +
		"A player cannot initiate a [military] or [power] challenge unless he or she has won an [intrigue] challenge that phase..<br>" +
		"<i>Core Set.</i><br>"
	)
	A_GAME_OF_THRONES_Core ("01003"),
	@GraphQLEnumValue(description="" +
		"<h5>A Noble Cause</h5>" +
		"Neutral.<br>" +
		"<b><i>Kingdom. Noble.</i></b><br>" +
		"Reduce the cost of the first <i>Lord</i> or <i>Lady</i> character you marshal this round by 2..<br>" +
		"<i>Core Set.</i><br>"
	)
	A_NOBLE_CAUSE_Core ("01004"),
	@GraphQLEnumValue(description="" +
		"<h5>A Storm of Swords</h5>" +
		"Neutral.<br>" +
		"<b><i>War.</i></b><br>" +
		"You may initiate an additional [military] challenge during the challenges phase..<br>" +
		"<i>Core Set.</i><br>"
	)
	A_STORM_OF_SWORDS_Core ("01005"),
	@GraphQLEnumValue(description="" +
		"<h5>Building Orders</h5>" +
		"Neutral.<br>" +
		"<b><i>Kingdom.</i></b><br>" +
		"<b>When Revealed:</b> Search the top 10 cards of your deck for an attachment or a location, reveal it, and add it to your hand. Shuffle your deck..<br>" +
		"<i>Core Set.</i><br>"
	)
	BUILDING_ORDERS_Core ("01006"),
	@GraphQLEnumValue(description="" +
		"<h5>Calling the Banners</h5>" +
		"Neutral.<br>" +
		"<b><i>Kingdom.</i></b><br>" +
		"<b>When Revealed:</b> Choose an opponent. Gain 1 gold for each character that player controls..<br>" +
		"<i>Core Set.</i><br>"
	)
	CALLING_THE_BANNERS_Core ("01007"),
	@GraphQLEnumValue(description="" +
		"<h5>Calm Over Westeros</h5>" +
		"Neutral.<br>" +
		"<b><i>Summer.</i></b><br>" +
		"<b>When Revealed:</b> Name a challenge type. Until you reveal a new plot card, reduce the claim value on the attacking player's revealed plot card by 1 during challenges of that type in which you are the defending player..<br>" +
		"<i>Core Set.</i><br>"
	)
	CALM_OVER_WESTEROS_Core ("01008"),
	@GraphQLEnumValue(description="" +
		"<h5>Confiscation</h5>" +
		"Neutral.<br>" +
		"<b><i>Edict.</i></b><br>" +
		"<b>When Revealed:</b> Choose an attachment, and discard it from play..<br>" +
		"<i>Core Set.</i><br>"
	)
	CONFISCATION_Core ("01009"),
	@GraphQLEnumValue(description="" +
		"<h5>Counting Coppers</h5>" +
		"Neutral.<br>" +
		"<b><i>Kingdom.</i></b><br>" +
		"<b>When Revealed:</b> Draw 3 cards..<br>" +
		"<i>Core Set.</i><br>"
	)
	COUNTING_COPPERS_Core ("01010"),
	@GraphQLEnumValue(description="" +
		"<h5>Filthy Accusations</h5>" +
		"Neutral.<br>" +
		"<b><i>Scheme.</i></b><br>" +
		"<b>When Revealed:</b> Choose and kneel a character..<br>" +
		"<i>Core Set.</i><br>"
	)
	FILTHY_ACCUSATIONS_Core ("01011"),
	@GraphQLEnumValue(description="" +
		"<h5>Fortified Position</h5>" +
		"Neutral.<br>" +
		"<b><i>Siege. War.</i></b><br>" +
		"Treat each character as if its printed text box were blank (except for <i>Traits</i>)..<br>" +
		"<i>Core Set.</i><br>"
	)
	FORTIFIED_POSITION_Core ("01012"),
	@GraphQLEnumValue(description="" +
		"<h5>Heads on Spikes</h5>" +
		"Neutral.<br>" +
		"<b><i>Edict. War.</i></b><br>" +
		"<b>When Revealed:</b> Choose an opponent. Discard 1 card at random from that player's hand. If that card is a character, gain 2 power for your faction and place the discarded character in its owner's dead pile..<br>" +
		"<i>Core Set.</i><br>"
	)
	HEADS_ON_SPIKES_Core ("01013"),
	@GraphQLEnumValue(description="" +
		"<h5>Jousting Contest</h5>" +
		"Neutral.<br>" +
		"<b><i>War.</i></b><br>" +
		"Each player cannot declare more than 1 character as an attacker or defender in each challenge..<br>" +
		"<i>Core Set.</i><br>"
	)
	JOUSTING_CONTEST_Core ("01014"),
	@GraphQLEnumValue(description="" +
		"<h5>Marched to the Wall</h5>" +
		"Neutral.<br>" +
		"<b><i>Edict.</i></b><br>" +
		"<b>When Revealed:</b> Each player chooses a character he or she controls (if able), and discards it from play (cannot be saved)..<br>" +
		"<i>Core Set.</i><br>"
	)
	MARCHED_TO_THE_WALL_Core ("01015"),
	@GraphQLEnumValue(description="" +
		"<h5>Marching Orders</h5>" +
		"Neutral.<br>" +
		"<b><i>Edict. War.</i></b><br>" +
		"You cannot marshal locations or attachments, or play events..<br>" +
		"<i>Core Set.</i><br>"
	)
	MARCHING_ORDERS_Core ("01016"),
	@GraphQLEnumValue(description="" +
		"<h5>Naval Superiority</h5>" +
		"Neutral.<br>" +
		"<b><i>Siege. War.</i></b><br>" +
		"Treat the base gold value on each revealed <i>Kingdom</i> and each revealed <i>Edict</i> plot card as if it were 0..<br>" +
		"<i>Core Set.</i><br>"
	)
	NAVAL_SUPERIORITY_Core ("01017"),
	@GraphQLEnumValue(description="" +
		"<h5>Power Behind the Throne</h5>" +
		"Neutral.<br>" +
		"<b><i>Noble. Scheme.</i></b><br>" +
		"<b>When Revealed:</b> Place 1 stand token on Power Behind the Throne.<b>Action:</b> Discard 1 stand token from Power Behind the Throne to choose and stand a character..<br>" +
		"<i>Core Set.</i><br>"
	)
	POWER_BEHIND_THE_THRONE_Core ("01018"),
	@GraphQLEnumValue(description="" +
		"<h5>Rebuilding</h5>" +
		"Neutral.<br>" +
		"<b><i>Kingdom.</i></b><br>" +
		"<b>When Revealed:</b> Choose up to 3 cards in your discard pile, and shuffle them into your deck..<br>" +
		"<i>Core Set.</i><br>"
	)
	REBUILDING_Core ("01019"),
	@GraphQLEnumValue(description="" +
		"<h5>Reinforcements</h5>" +
		"Neutral.<br>" +
		"<b><i>Kingdom. War.</i></b><br>" +
		"<b>When Revealed:</b> Choose a character with printed cost 5 or lower in your hand or discard pile, and put it into play..<br>" +
		"<i>Core Set.</i><br>"
	)
	REINFORCEMENTS_Core ("01020"),
	@GraphQLEnumValue(description="" +
		"<h5>Sneak Attack</h5>" +
		"Neutral.<br>" +
		"<b><i>Scheme.</i></b><br>" +
		"You cannot initiate more than 1 challenge during the challenges phase..<br>" +
		"<i>Core Set.</i><br>"
	)
	SNEAK_ATTACK_Core ("01021"),
	@GraphQLEnumValue(description="" +
		"<h5>Summons</h5>" +
		"Neutral.<br>" +
		"<b><i>Kingdom.</i></b><br>" +
		"<b>When Revealed:</b> Search the top 10 cards of your deck for a character, reveal it, and add it to your hand. Shuffle your deck..<br>" +
		"<i>Core Set.</i><br>"
	)
	SUMMONS_Core ("01022"),
	@GraphQLEnumValue(description="" +
		"<h5>Supporting the Faith</h5>" +
		"Neutral.<br>" +
		"<b><i>Edict. The Seven.</i></b><br>" +
		"<b>Forced Reaction:</b> After the challenges phase begins, each player returns all gold in his or her gold pool to the treasury..<br>" +
		"<i>Core Set.</i><br>"
	)
	SUPPORTING_THE_FAITH_Core ("01023"),
	@GraphQLEnumValue(description="" +
		"<h5>Taxation</h5>" +
		"Neutral.<br>" +
		"<b><i>Edict. Kingdom.</i></b><br>" +
		"You may marshal or play 1 additional limited card this round..<br>" +
		"<i>Core Set.</i><br>"
	)
	TAXATION_Core ("01024"),
	@GraphQLEnumValue(description="" +
		"<h5>The Winds of Winter</h5>" +
		"Neutral.<br>" +
		"<b><i>Winter.</i></b><br>" +
		".<br>" +
		"<i>Core Set.</i><br>"
	)
	THE_WINDS_OF_WINTER_Core ("01025"),
	@GraphQLEnumValue(description="" +
		"<h5>Wildfire Assault</h5>" +
		"Neutral.<br>" +
		"<b><i>Scheme. War.</i></b><br>" +
		"<b>When Revealed:</b> Each player chooses up to 3 characters he or she controls. Kill each character not chosen (cannot be saved)..<br>" +
		"<i>Core Set.</i><br>"
	)
	WILDFIRE_ASSAULT_Core ("01026"),
	@GraphQLEnumValue(description="" +
		"<h5>Fealty</h5>" +
		"Neutral.<br>" +
		"You cannot include more than 15 neutral cards in your deck.<b>Action:</b> Kneel your faction card to reduce the cost of the next loyal card you marshal or play this phase by 1..<br>" +
		"<i>Core Set.</i><br>"
	)
	FEALTY_Core ("01027"),
	@GraphQLEnumValue(description="" +
		"<h5>Littlefinger (Core)</h5>" +
		"Neutral.<br>" +
		"<b><i>Ally. Lord. Small Council.</i></b><br>" +
		"<b>Reaction:</b> After you marshal Littlefinger, draw 2 cards.+1 Income..<br>" +
		"<i>Core Set.</i><br>"
	)
	LITTLEFINGER_Core ("01028"),
	@GraphQLEnumValue(description="" +
		"<h5>Varys (Core)</h5>" +
		"Neutral.<br>" +
		"<b><i>Lord. Small Council. Spy.</i></b><br>" +
		"Stealth.<b>Interrupt:</b> When the dominance phase ends, remove Varys from the game to discard each character from play..<br>" +
		"<i>Core Set.</i><br>"
	)
	VARYS_Core ("01029"),
	@GraphQLEnumValue(description="" +
		"<h5>Rattleshirt's Raiders</h5>" +
		"Neutral.<br>" +
		"<b><i>Raider. Wildling.</i></b><br>" +
		"No attachments.<b>Reaction:</b> After you win a challenge in which Rattleshirt's Raiders is participating as an attacker, choose an attachment controlled by the losing opponent, and discard it from play..<br>" +
		"<i>Core Set.</i><br>"
	)
	RATTLESHIRTS_RAIDERS_Core ("01030"),
	@GraphQLEnumValue(description="" +
		"<h5>Wildling Horde</h5>" +
		"Neutral.<br>" +
		"<b><i>Army. Wildling.</i></b><br>" +
		"No attachments. Pillage.<b>Challenges Action:</b> Kneel your faction card to choose a participating Wildling character you control. Until the end of the challenge, that character gets +2 STR..<br>" +
		"<i>Core Set.</i><br>"
	)
	WILDLING_HORDE_Core ("01031"),
	@GraphQLEnumValue(description="" +
		"<h5>Seal of the Hand</h5>" +
		"Neutral.<br>" +
		"<b><i>Item.</i></b><br>" +
		"<i>Lord</i> or <i>Lady</i> character only.<b>Action:</b> Kneel Seal of the Hand to stand attached character..<br>" +
		"<i>Core Set.</i><br>"
	)
	SEAL_OF_THE_HAND_Core ("01032"),
	@GraphQLEnumValue(description="" +
		"<h5>Bodyguard</h5>" +
		"Neutral.<br>" +
		"<b><i>Condition.</i></b><br>" +
		"<i>Lord</i> or <i>Lady</i> character only.<b>Interrupt:</b> When attached character would be killed or discarded from play, sacrifice Bodyguard to save that character..<br>" +
		"<i>Core Set.</i><br>"
	)
	BODYGUARD_Core ("01033"),
	@GraphQLEnumValue(description="" +
		"<h5>Little Bird</h5>" +
		"Neutral.<br>" +
		"<b><i>Condition.</i></b><br>" +
		"Attached character gains an [intrigue] icon..<br>" +
		"<i>Core Set.</i><br>"
	)
	LITTLE_BIRD_Core ("01034"),
	@GraphQLEnumValue(description="" +
		"<h5>Milk of the Poppy</h5>" +
		"Neutral.<br>" +
		"<b><i>Condition.</i></b><br>" +
		"Terminal.Treat attached character's printed text box as if it were blank (except for <i>Traits</i>)..<br>" +
		"<i>Core Set.</i><br>"
	)
	MILK_OF_THE_POPPY_Core ("01035"),
	@GraphQLEnumValue(description="" +
		"<h5>Noble Lineage</h5>" +
		"Neutral.<br>" +
		"<b><i>Condition.</i></b><br>" +
		"Attached character gains a [power] icon..<br>" +
		"<i>Core Set.</i><br>"
	)
	NOBLE_LINEAGE_Core ("01036"),
	@GraphQLEnumValue(description="" +
		"<h5>Syrio's Training</h5>" +
		"Neutral.<br>" +
		"<b><i>Condition. Skill.</i></b><br>" +
		"Attached character gains a [military] icon..<br>" +
		"<i>Core Set.</i><br>"
	)
	SYRIOS_TRAINING_Core ("01037"),
	@GraphQLEnumValue(description="" +
		"<h5>The Iron Throne</h5>" +
		"Neutral.<br>" +
		"<b><i>King's Landing.</i></b><br>" +
		"The Iron Throne contributes 8 STR to your total for dominance.+1 Reserve..<br>" +
		"<i>Core Set.</i><br>"
	)
	THE_IRON_THRONE_Core ("01038"),
	@GraphQLEnumValue(description="" +
		"<h5>The Kingsroad</h5>" +
		"Neutral.<br>" +
		"<b><i>Westeros.</i></b><br>" +
		"Limited.<b>Marshaling Action:</b> Kneel and sacrifice The Kingsroad to reduce the cost of the next character you marshal this phase by 3.+1 Initiative..<br>" +
		"<i>Core Set.</i><br>"
	)
	THE_KINGSROAD_Core ("01039"),
	@GraphQLEnumValue(description="" +
		"<h5>The Roseroad</h5>" +
		"Neutral.<br>" +
		"<b><i>Westeros.</i></b><br>" +
		"Limited.+1 Income..<br>" +
		"<i>Core Set.</i><br>"
	)
	THE_ROSEROAD_Core ("01040"),
	@GraphQLEnumValue(description="" +
		"<h5>Put to the Sword</h5>" +
		"Neutral.<br>" +
		"<b>Reaction:</b> After you win a [military] challenge by 5 or more STR as the attacking player, choose and kill a character controlled by the losing opponent. (Max 1 per challenge.).<br>" +
		"<i>Core Set.</i><br>"
	)
	PUT_TO_THE_SWORD_Core ("01041"),
	@GraphQLEnumValue(description="" +
		"<h5>Put to the Torch</h5>" +
		"Neutral.<br>" +
		"<b>Reaction:</b> After you win a [military] challenge by 5 or more STR as the attacking player, choose a location controlled by the losing opponent, and discard it from play. (Max 1 per challenge.).<br>" +
		"<i>Core Set.</i><br>"
	)
	PUT_TO_THE_TORCH_Core ("01042"),
	@GraphQLEnumValue(description="" +
		"<h5>Superior Claim</h5>" +
		"Neutral.<br>" +
		"<b>Reaction:</b> After you win a [power] challenge by 5 or more STR, gain 2 power for your faction. (Max 1 per challenge.).<br>" +
		"<i>Core Set.</i><br>"
	)
	SUPERIOR_CLAIM_Core ("01043"),
	@GraphQLEnumValue(description="" +
		"<h5>Tears of Lys</h5>" +
		"Neutral.<br>" +
		"<b><i>Poison.</i></b><br>" +
		"<b>Reaction:</b> After you win an [intrigue] challenge as the attacking player, place a poison token on a character without an [intrigue] icon controlled by the losing opponent. At the end of the phase, if that character still has the poison token, remove it and kill that character. (Max 1 per challenge.).<br>" +
		"<i>Core Set.</i><br>"
	)
	TEARS_OF_LYS_Core ("01044"),
	@GraphQLEnumValue(description="" +
		"<h5>The Hand's Judgment</h5>" +
		"Neutral.<br>" +
		"<b>Interrupt:</b> When the effects of an opponent's event would initiate, cancel those effects. X is that event's printed cost..<br>" +
		"<i>Core Set.</i><br>"
	)
	THE_HANDS_JUDGMENT_Core ("01045"),
	@GraphQLEnumValue(description="" +
		"<h5>Maester Cressen</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Maester.</i></b><br>" +
		"<b>Marshaling Action:</b> Kneel Maester Cressen to choose a <i>Condition</i> attachment, and discard it from play..<br>" +
		"<i>Core Set.</i><br>"
	)
	MAESTER_CRESSEN_Core ("01046"),
	@GraphQLEnumValue(description="" +
		"<h5>Melisandre (Core)</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Lady. R'hllor.</i></b><br>" +
		"<b>Reaction:</b> After you marshal or play a <i>R'hllor</i> card, choose and kneel a character. (Limit once per round.).<br>" +
		"<i>Core Set.</i><br>"
	)
	MELISANDRE_Core ("01047"),
	@GraphQLEnumValue(description="" +
		"<h5>Robert Baratheon (Core)</h5>" +
		"House Baratheon.<br>" +
		"<b><i>King. Lord.</i></b><br>" +
		"Intimidate. Renown.Robert Baratheon gets +1 STR for each other kneeling character in play..<br>" +
		"<i>Core Set.</i><br>"
	)
	ROBERT_BARATHEON_Core ("01048"),
	@GraphQLEnumValue(description="" +
		"<h5>Selyse Baratheon (Core)</h5>" +
		"House Baratheon.<br>" +
		"<b><i>House Florent. Lady. R'hllor.</i></b><br>" +
		"<b>Challenges Action:</b> Pay 1 gold to choose a [baratheon] character. Until the end of the phase, that character gains an [intrigue] icon..<br>" +
		"<i>Core Set.</i><br>"
	)
	SELYSE_BARATHEON_Core ("01049"),
	@GraphQLEnumValue(description="" +
		"<h5>Ser Davos Seaworth (Core)</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Knight. Smuggler.</i></b><br>" +
		"Stealth.<b>Interrupt:</b> When Ser Davos Seaworth is killed, return him to your hand instead of placing him in your dead pile..<br>" +
		"<i>Core Set.</i><br>"
	)
	SER_DAVOS_SEAWORTH_Core ("01050"),
	@GraphQLEnumValue(description="" +
		"<h5>Shireen Baratheon (Core)</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Lady.</i></b><br>" +
		"<b>Interrupt:</b> When Shireen Baratheon is killed, choose and kneel a character..<br>" +
		"<i>Core Set.</i><br>"
	)
	SHIREEN_BARATHEON_Core ("01051"),
	@GraphQLEnumValue(description="" +
		"<h5>Stannis Baratheon (Core)</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Lord. Small Council.</i></b><br>" +
		"Each player cannot stand more than 2 characters during the standing phase..<br>" +
		"<i>Core Set.</i><br>"
	)
	STANNIS_BARATHEON_Core ("01052"),
	@GraphQLEnumValue(description="" +
		"<h5>Bastard in Hiding</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Bastard.</i></b><br>" +
		".<br>" +
		"<i>Core Set.</i><br>"
	)
	BASTARD_IN_HIDING_Core ("01053"),
	@GraphQLEnumValue(description="" +
		"<h5>Fiery Followers</h5>" +
		"House Baratheon.<br>" +
		"<b><i>R'hllor.</i></b><br>" +
		"<b>Reaction:</b> After the dominance phase begins, stand Fiery Followers..<br>" +
		"<i>Core Set.</i><br>"
	)
	FIERY_FOLLOWERS_Core ("01054"),
	@GraphQLEnumValue(description="" +
		"<h5>King's Hunting Party</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Army.</i></b><br>" +
		"No attachments.While an opponent controls a <i>King</i> character, King's Hunting Party gains an [intrigue] icon ..<br>" +
		"<i>Core Set.</i><br>"
	)
	KINGS_HUNTING_PARTY_Core ("01055"),
	@GraphQLEnumValue(description="" +
		"<h5>Dragonstone Faithful</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Ally.</i></b><br>" +
		"<b>Marshaling Action:</b> Kneel Dragonstone Faithful to reduce the cost of the next [baratheon] character you marshal this phase by 1..<br>" +
		"<i>Core Set.</i><br>"
	)
	DRAGONSTONE_FAITHFUL_Core ("01056"),
	@GraphQLEnumValue(description="" +
		"<h5>Vanguard Lancer</h5>" +
		"House Baratheon.<br>" +
		"<b><i>House Florent. Knight.</i></b><br>" +
		"<b>Reaction:</b> After Vanguard Lancer enters play, choose an opponent's character or faction card, and discard 1 power from that card..<br>" +
		"<i>Core Set.</i><br>"
	)
	VANGUARD_LANCER_Core ("01057"),
	@GraphQLEnumValue(description="" +
		"<h5>Lightbringer</h5>" +
		"House Baratheon.<br>" +
		"<b><i>R'hllor. Weapon.</i></b><br>" +
		"[baratheon] character only.If attached character is Stannis Baratheon, he gains renown.<b>Reaction:</b> After attached character gains 1 or more power, stand it. (Limit once per phase.).<br>" +
		"<i>Core Set.</i><br>"
	)
	LIGHTBRINGER_Core ("01058"),
	@GraphQLEnumValue(description="" +
		"<h5>Dragonstone Port</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Dragonstone.</i></b><br>" +
		"Limited.<b>Marshaling Action:</b> Kneel Dragonstone Port to reduce the cost of the next [baratheon] card you marshal this phase by 1..<br>" +
		"<i>Core Set.</i><br>"
	)
	DRAGONSTONE_PORT_Core ("01059"),
	@GraphQLEnumValue(description="" +
		"<h5>Chamber of the Painted Table</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Dragonstone.</i></b><br>" +
		"<b>Reaction:</b> After you win dominance, kneel Chamber of the Painted Table to move 1 power from an opponent's faction card to your own..<br>" +
		"<i>Core Set.</i><br>"
	)
	CHAMBER_OF_THE_PAINTED_TABLE_Core ("01060"),
	@GraphQLEnumValue(description="" +
		"<h5>The Red Keep</h5>" +
		"House Baratheon.<br>" +
		"<b><i>King's Landing.</i></b><br>" +
		"The Red Keep contributes 2 STR to your side during any [power] challenge in which you control a participating character.<b>Interrupt:</b> When the challenges phase ends, if you have not lost a [power] challenge this round, kneel The Red Keep to draw 2 cards..<br>" +
		"<i>Core Set.</i><br>"
	)
	THE_RED_KEEP_Core ("01061"),
	@GraphQLEnumValue(description="" +
		"<h5>Consolidation of Power</h5>" +
		"House Baratheon.<br>" +
		"<b>Marshaling Action:</b> Choose and kneel up to 4 total STR worth of characters controlled by the same player. Then, choose one of those characters, and have it gain 1 power..<br>" +
		"<i>Core Set.</i><br>"
	)
	CONSOLIDATION_OF_POWER_Core ("01062"),
	@GraphQLEnumValue(description="" +
		"<h5>Ours is the Fury</h5>" +
		"House Baratheon.<br>" +
		"Play only during a challenge in which you are the defending player.<b>Action:</b> Choose a kneeling [baratheon] character you control. That character is now participating as a defender. If you win this challenge, stand that character..<br>" +
		"<i>Core Set.</i><br>"
	)
	OURS_IS_THE_FURY_Core ("01063"),
	@GraphQLEnumValue(description="" +
		"<h5>Seen In Flames</h5>" +
		"House Baratheon.<br>" +
		"<b><i>R'hllor.</i></b><br>" +
		"Play only if you control a <i>R'hllor</i> character.<b>Challenges Action:</b> Choose an opponent, and look at his or her hand. Then, choose and discard 1 card from that hand..<br>" +
		"<i>Core Set.</i><br>"
	)
	SEEN_IN_FLAMES_Core ("01064"),
	@GraphQLEnumValue(description="" +
		"<h5>Aeron Damphair (Core)</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Drowned God. Ironborn. Lord.</i></b><br>" +
		"<b>Reaction:</b> After you win dominance, put an <i>Ironborn</i> character into play from your dead pile..<br>" +
		"<i>Core Set.</i><br>"
	)
	AERON_DAMPHAIR_Core ("01065"),
	@GraphQLEnumValue(description="" +
		"<h5>Alannys Greyjoy (Core)</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>House Harlaw. Lady.</i></b><br>" +
		"While you are the first player, reduce the reserve value on each opponent's revealed plot card by 1..<br>" +
		"<i>Core Set.</i><br>"
	)
	ALANNYS_GREYJOY_Core ("01066"),
	@GraphQLEnumValue(description="" +
		"<h5>Asha Greyjoy (Core)</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Ironborn. Lady.</i></b><br>" +
		"Stealth.<b>Reaction:</b> After you win an unopposed challenge in which Asha Greyjoy is participating, stand her..<br>" +
		"<i>Core Set.</i><br>"
	)
	ASHA_GREYJOY_Core ("01067"),
	@GraphQLEnumValue(description="" +
		"<h5>Balon Greyjoy (Core)</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Ironborn. Lord.</i></b><br>" +
		"Renown.While Balon Greyjoy is attacking, each defending character with a lower STR than his does not contribute its STR to that challenge..<br>" +
		"<i>Core Set.</i><br>"
	)
	BALON_GREYJOY_Core ("01068"),
	@GraphQLEnumValue(description="" +
		"<h5>Euron Crow's Eye (Core)</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Ironborn. Lord. Raider.</i></b><br>" +
		"Pillage. Renown.<b>Reaction:</b> After Euron Crow's Eye discards a card using pillage, put a location from the losing opponent's discard pile into play under your control..<br>" +
		"<i>Core Set.</i><br>"
	)
	EURON_CROWS_EYE_Core ("01069"),
	@GraphQLEnumValue(description="" +
		"<h5>Maester Wendamyr</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Maester.</i></b><br>" +
		"Stealth..<br>" +
		"<i>Core Set.</i><br>"
	)
	MAESTER_WENDAMYR_Core ("01070"),
	@GraphQLEnumValue(description="" +
		"<h5>Theon Greyjoy (Core)</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Ally. Ironborn. Lord.</i></b><br>" +
		"Stealth.<b>Reaction:</b> After you win an unopposed challenge in which Theon Greyjoy is participating, he gains 1 power..<br>" +
		"<i>Core Set.</i><br>"
	)
	THEON_GREYJOY_Core ("01071"),
	@GraphQLEnumValue(description="" +
		"<h5>Black Wind's Crew</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Ironborn. Raider.</i></b><br>" +
		"Pillage..<br>" +
		"<i>Core Set.</i><br>"
	)
	BLACK_WINDS_CREW_Core ("01072"),
	@GraphQLEnumValue(description="" +
		"<h5>Drowned Men</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Army. Drowned God.</i></b><br>" +
		"No attachments.Drowned Men gets +1 STR for each <i>Warship</i> location you control..<br>" +
		"<i>Core Set.</i><br>"
	)
	DROWNED_MEN_Core ("01073"),
	@GraphQLEnumValue(description="" +
		"<h5>Iron Islands Fishmonger</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Ally. Merchant.</i></b><br>" +
		"<b>Marshaling Action:</b> Kneel Iron Islands Fishmonger to reduce the cost of the next [greyjoy] character you marshal this phase by 1..<br>" +
		"<i>Core Set.</i><br>"
	)
	IRON_ISLANDS_FISHMONGER_Core ("01074"),
	@GraphQLEnumValue(description="" +
		"<h5>Lordsport Shipwright</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Ally. Ironborn.</i></b><br>" +
		"<b>Marshaling Action:</b> Kneel Lordsport Shipwright to choose and kneel a location with printed cost 2 or lower. (Printed cost 3 or lower instead if you are the first player.).<br>" +
		"<i>Core Set.</i><br>"
	)
	LORDSPORT_SHIPWRIGHT_Core ("01075"),
	@GraphQLEnumValue(description="" +
		"<h5>Salty Navigator</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Ironborn.</i></b><br>" +
		"+1 Initiative..<br>" +
		"<i>Core Set.</i><br>"
	)
	SALTY_NAVIGATOR_Core ("01076"),
	@GraphQLEnumValue(description="" +
		"<h5>Throwing Axe</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Weapon.</i></b><br>" +
		"<i>Ironborn</i> character only.<b>Reaction:</b> After you win a challenge in which attached character is participating as an attacker, sacrifice Throwing Axe to choose and kill a defending character..<br>" +
		"<i>Core Set.</i><br>"
	)
	THROWING_AXE_Core ("01077"),
	@GraphQLEnumValue(description="" +
		"<h5>Great Kraken</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Warship.</i></b><br>" +
		"While you control Balon Greyjoy, he gains stealth.<b>Reaction:</b> After you win an unopposed challenge, either: draw 1 card, or gain 1 power for your faction. (Limit twice per round.).<br>" +
		"<i>Core Set.</i><br>"
	)
	GREAT_KRAKEN_Core ("01078"),
	@GraphQLEnumValue(description="" +
		"<h5>Iron Fleet Scout</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Warship.</i></b><br>" +
		"<b>Challenges Action:</b> Kneel Iron Fleet Scout to choose a participating [greyjoy] character. Until the end of the challenge, that character gets +1 STR. (+2 STR instead if you are the first player.).<br>" +
		"<i>Core Set.</i><br>"
	)
	IRON_FLEET_SCOUT_Core ("01079"),
	@GraphQLEnumValue(description="" +
		"<h5>Sea Tower</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Iron Islands.</i></b><br>" +
		"Limited.<b>Marshaling Action:</b> Kneel Sea Tower to reduce the cost of the next [greyjoy] card you marshal this phase by 1..<br>" +
		"<i>Core Set.</i><br>"
	)
	SEA_TOWER_Core ("01080"),
	@GraphQLEnumValue(description="" +
		"<h5>Risen from the Sea</h5>" +
		"House Greyjoy.<br>" +
		"<b>Interrupt:</b> When a [greyjoy] character would be killed, save it. Then, attach Risen from the Sea to that character as a <i>Condition</i> attachment with the text: \"Terminal. Attached character gets +1 STR.\".<br>" +
		"<i>Core Set.</i><br>"
	)
	RISEN_FROM_THE_SEA_Core ("01081"),
	@GraphQLEnumValue(description="" +
		"<h5>The Kraken's Grasp</h5>" +
		"House Greyjoy.<br>" +
		"Play only if you are the first player.<b>Challenges Action:</b> Choose a defending character with STR 5 or lower. That character does not contribute is STR to this challenge..<br>" +
		"<i>Core Set.</i><br>"
	)
	THE_KRAKENS_GRASP_Core ("01082"),
	@GraphQLEnumValue(description="" +
		"<h5>We Do Not Sow</h5>" +
		"House Greyjoy.<br>" +
		"<b>Reaction:</b> After you win an unopposed challenge, choose an attachment or location controlled by the losing opponent, and discard it from play. (Max 1 per challenge.).<br>" +
		"<i>Core Set.</i><br>"
	)
	WE_DO_NOT_SOW_Core ("01083"),
	@GraphQLEnumValue(description="" +
		"<h5>Cersei Lannister (Core)</h5>" +
		"House Lannister.<br>" +
		"<b><i>Lady. Queen.</i></b><br>" +
		"While Cersei Lannister is attacking during an [intrigue] challenge, raise the claim value on your revealed plot card by 1..<br>" +
		"<i>Core Set.</i><br>"
	)
	CERSEI_LANNISTER_Core ("01084"),
	@GraphQLEnumValue(description="" +
		"<h5>Grand Maester Pycelle</h5>" +
		"House Lannister.<br>" +
		"<b><i>Maester. Small Council.</i></b><br>" +
		"Insight..<br>" +
		"<i>Core Set.</i><br>"
	)
	GRAND_MAESTER_PYCELLE_Core ("01085"),
	@GraphQLEnumValue(description="" +
		"<h5>Joffrey Baratheon (Core)</h5>" +
		"House Lannister.<br>" +
		"<b><i>Lord.</i></b><br>" +
		"<b>Reaction:</b> After a <i>Lord</i> or <i>Lady</i> character is killed, Joffrey Baratheon gains 1 power. (Limit 3 times per round.).<br>" +
		"<i>Core Set.</i><br>"
	)
	JOFFREY_BARATHEON_Core ("01086"),
	@GraphQLEnumValue(description="" +
		"<h5>Ser Jaime Lannister (Core)</h5>" +
		"House Lannister.<br>" +
		"<b><i>Knight. Lord.</i></b><br>" +
		"Ser Jaime Lannister does not kneel when declared as an attacker in a [military] challenge, and gains renown while participating in a [military] challenge..<br>" +
		"<i>Core Set.</i><br>"
	)
	SER_JAIME_LANNISTER_Core ("01087"),
	@GraphQLEnumValue(description="" +
		"<h5>The Tickler</h5>" +
		"House Lannister.<br>" +
		"<b><i>Ally.</i></b><br>" +
		"<b>Dominance Action:</b> Kneel The Tickler to discard the top card of an opponent's deck. Then, you may choose 1 copy of that card, and discard it from play..<br>" +
		"<i>Core Set.</i><br>"
	)
	THE_TICKLER_Core ("01088"),
	@GraphQLEnumValue(description="" +
		"<h5>Tyrion Lannister (Core)</h5>" +
		"House Lannister.<br>" +
		"<b><i>Lord.</i></b><br>" +
		"Stealth.<b>Reaction:</b> After an [intrigue] challenge is initiated, gain 2 gold. (Limit twice per round.).<br>" +
		"<i>Core Set.</i><br>"
	)
	TYRION_LANNISTER_Core ("01089"),
	@GraphQLEnumValue(description="" +
		"<h5>Tywin Lannister (Core)</h5>" +
		"House Lannister.<br>" +
		"<b><i>Lord.</i></b><br>" +
		"Renown.Tywin Lannister gets +1 STR for each gold in your gold pool.+2 Income..<br>" +
		"<i>Core Set.</i><br>"
	)
	TYWIN_LANNISTER_Core ("01090"),
	@GraphQLEnumValue(description="" +
		"<h5>Burned Men</h5>" +
		"House Lannister.<br>" +
		"<b><i>Clansman.</i></b><br>" +
		"Ambush (2)..<br>" +
		"<i>Core Set.</i><br>"
	)
	BURNED_MEN_Core ("01091"),
	@GraphQLEnumValue(description="" +
		"<h5>Gold Cloaks</h5>" +
		"House Lannister.<br>" +
		"<b><i>Ally. Army.</i></b><br>" +
		"Ambush (2).<b>Forced Interrupt:</b> When a phase ends in which Gold Cloaks entered play using ambush, discard it from play (cannot be saved)..<br>" +
		"<i>Core Set.</i><br>"
	)
	GOLD_CLOAKS_Core ("01092"),
	@GraphQLEnumValue(description="" +
		"<h5>Lannisport Moneylender</h5>" +
		"House Lannister.<br>" +
		"<b><i>Merchant.</i></b><br>" +
		"Limited.+1 Income..<br>" +
		"<i>Core Set.</i><br>"
	)
	LANNISPORT_MONEYLENDER_Core ("01093"),
	@GraphQLEnumValue(description="" +
		"<h5>Lannisport Merchant</h5>" +
		"House Lannister.<br>" +
		"<b><i>Ally. Steward.</i></b><br>" +
		"<b>Marshaling Action:</b> Kneel Lannisport Merchant to reduce the cost of the next [lannister] character you marshal this phase by 1..<br>" +
		"<i>Core Set.</i><br>"
	)
	LANNISPORT_MERCHANT_Core ("01094"),
	@GraphQLEnumValue(description="" +
		"<h5>The Queen's Assassin</h5>" +
		"House Lannister.<br>" +
		"<b><i>Spy.</i></b><br>" +
		"Ambush (4).<b>Reaction:</b> After The Queen's Assassin enters play using ambush, choose an opponent. If you have more cards in hand than that player, he or she must choose and kill a character he or she controls..<br>" +
		"<i>Core Set.</i><br>"
	)
	THE_QUEENS_ASSASSIN_Core ("01095"),
	@GraphQLEnumValue(description="" +
		"<h5>Widow's Wail</h5>" +
		"House Lannister.<br>" +
		"<b><i>Valyrian Steel. Weapon.</i></b><br>" +
		"Ambush (1).Attached character gets +2 STR.If attached character is Joffrey Baratheon, he gains a [military] icon..<br>" +
		"<i>Core Set.</i><br>"
	)
	WIDOWS_WAIL_Core ("01096"),
	@GraphQLEnumValue(description="" +
		"<h5>Casterly Rock</h5>" +
		"House Lannister.<br>" +
		"<b><i>Stronghold. The Westerlands.</i></b><br>" +
		"You may initiate an additional [intrigue] challenge during the challenges phase..<br>" +
		"<i>Core Set.</i><br>"
	)
	CASTERLY_ROCK_Core ("01097"),
	@GraphQLEnumValue(description="" +
		"<h5>Lannisport</h5>" +
		"House Lannister.<br>" +
		"<b><i>The Westerlands.</i></b><br>" +
		"<b>Reaction:</b> After you win an [intrigue] challenge, draw 1 card..<br>" +
		"<i>Core Set.</i><br>"
	)
	LANNISPORT_Core ("01098"),
	@GraphQLEnumValue(description="" +
		"<h5>Western Fiefdom</h5>" +
		"House Lannister.<br>" +
		"<b><i>The Westerlands.</i></b><br>" +
		"Limited.<b>Marshaling Action:</b> Kneel Western Fiefdom to reduce the cost of the next [lannister] card you marshal this phase by 1..<br>" +
		"<i>Core Set.</i><br>"
	)
	WESTERN_FIEFDOM_Core ("01099"),
	@GraphQLEnumValue(description="" +
		"<h5>Hear Me Roar!</h5>" +
		"House Lannister.<br>" +
		"<b>Action:</b> Put a [lannister] character into play from your hand. At the end of the phase, if that card is still in play, discard it from play (cannot be saved)..<br>" +
		"<i>Core Set.</i><br>"
	)
	HEAR_ME_ROAR_Core ("01100"),
	@GraphQLEnumValue(description="" +
		"<h5>The Things I Do For Love</h5>" +
		"House Lannister.<br>" +
		"Play only if you control a [lannister] <i>Lord</i> or <i>Lady</i> character.<b>Challenges Action:</b> Kneel your faction card to choose a character with printed cost X or lower controlled by an opponent, and return it to its owner's hand..<br>" +
		"<i>Core Set.</i><br>"
	)
	THE_THINGS_I_DO_FOR_LOVE_Core ("01101"),
	@GraphQLEnumValue(description="" +
		"<h5>Treachery</h5>" +
		"House Lannister.<br>" +
		"Play only if you control a unique [lannister] character.<b>Interrupt:</b> When the effects of a triggered character, location, or attachment ability would initiate, cancel those effects..<br>" +
		"<i>Core Set.</i><br>"
	)
	TREACHERY_Core ("01102"),
	@GraphQLEnumValue(description="" +
		"<h5>Areo Hotah (Core)</h5>" +
		"House Martell.<br>" +
		"<b><i>Guard.</i></b><br>" +
		"Ambush (5).<b>Reaction:</b> After Areo Hotah enters play during a challenge, choose a participating character, and remove it from the challenge..<br>" +
		"<i>Core Set.</i><br>"
	)
	AREO_HOTAH_Core ("01103"),
	@GraphQLEnumValue(description="" +
		"<h5>Arianne Martell (Core)</h5>" +
		"House Martell.<br>" +
		"<b><i>Lady.</i></b><br>" +
		"<b>Action:</b> Put a character with printed cost 5 or lower into play from your hand. Then, return Arianne Martell to your hand (cannot be saved). (Limit once per phase.).<br>" +
		"<i>Core Set.</i><br>"
	)
	ARIANNE_MARTELL_Core ("01104"),
	@GraphQLEnumValue(description="" +
		"<h5>Doran Martell (Core)</h5>" +
		"House Martell.<br>" +
		"<b><i>Lord.</i></b><br>" +
		"Insight.Each other [martell] <i>Lord</i> and <i>Lady</i> character you control gets +1 STR for each plot card in your used pile..<br>" +
		"<i>Core Set.</i><br>"
	)
	DORAN_MARTELL_Core ("01105"),
	@GraphQLEnumValue(description="" +
		"<h5>Edric Dayne</h5>" +
		"House Martell.<br>" +
		"<b><i>Brotherhood. House Dayne. Lord.</i></b><br>" +
		"Stealth.<b>Action:</b> Pay 1 gold to give Edric Dayne a challenge icon of your choice until the end of the phase..<br>" +
		"<i>Core Set.</i><br>"
	)
	EDRIC_DAYNE_Core ("01106"),
	@GraphQLEnumValue(description="" +
		"<h5>Maester Caleotte</h5>" +
		"House Martell.<br>" +
		"<b><i>Maester.</i></b><br>" +
		"<b>Reaction:</b> After you lose a challenge in which Maester Caleotte is participating, choose a character. That character loses a challenge icon of your choice until the end of the phase..<br>" +
		"<i>Core Set.</i><br>"
	)
	MAESTER_CALEOTTE_Core ("01107"),
	@GraphQLEnumValue(description="" +
		"<h5>Obara Sand (Core)</h5>" +
		"House Martell.<br>" +
		"<b><i>Bastard. Sand Snake.</i></b><br>" +
		"Obara Sand may be declared as a defender during [power] challenges in which you are the defending player, even while kneeling..<br>" +
		"<i>Core Set.</i><br>"
	)
	OBARA_SAND_Core ("01108"),
	@GraphQLEnumValue(description="" +
		"<h5>The Red Viper (Core)</h5>" +
		"House Martell.<br>" +
		"<b><i>Lord.</i></b><br>" +
		"<b>Reaction:</b> After you win a challenge in which The Red Viper is participating as an attacker, he gains 1 power for every 5 STR by which you won the challenge..<br>" +
		"<i>Core Set.</i><br>"
	)
	THE_RED_VIPER_Core ("01109"),
	@GraphQLEnumValue(description="" +
		"<h5>Desert Scavenger</h5>" +
		"House Martell.<br>" +
		"<b><i>Ally.</i></b><br>" +
		"<b>Marshaling Action:</b> Kneel Desert Scavenger to reduce the cost of the next [martell] character you marshal this phase by 1..<br>" +
		"<i>Core Set.</i><br>"
	)
	DESERT_SCAVENGER_Core ("01110"),
	@GraphQLEnumValue(description="" +
		"<h5>Dornish Paramour</h5>" +
		"House Martell.<br>" +
		"<b><i>Companion.</i></b><br>" +
		"<b>Reaction:</b> After Dornish Paramour is declared as an attacker, choose a character controlled by the defending player. That character must be declared as a defender for this challenge, if able..<br>" +
		"<i>Core Set.</i><br>"
	)
	DORNISH_PARAMOUR_Core ("01111"),
	@GraphQLEnumValue(description="" +
		"<h5>Greenblood Trader</h5>" +
		"House Martell.<br>" +
		"<b><i>Ally.</i></b><br>" +
		"<b>Reaction:</b> After Greenblood Trader enters play, look at the top 2 cards of your deck. Add up to 1 of those cards to your hand, and place the others on the bottom of your deck in any order..<br>" +
		"<i>Core Set.</i><br>"
	)
	GREENBLOOD_TRADER_Core ("01112"),
	@GraphQLEnumValue(description="" +
		"<h5>House Dayne Knight</h5>" +
		"House Martell.<br>" +
		"<b><i>House Dayne. Knight.</i></b><br>" +
		".<br>" +
		"<i>Core Set.</i><br>"
	)
	HOUSE_DAYNE_KNIGHT_Core ("01113"),
	@GraphQLEnumValue(description="" +
		"<h5>Palace Spearman</h5>" +
		"House Martell.<br>" +
		"<b><i>Guard.</i></b><br>" +
		"No attachments.While you are not the first player, Palace Spearman gains an [intrigue] icon..<br>" +
		"<i>Core Set.</i><br>"
	)
	PALACE_SPEARMAN_Core ("01114"),
	@GraphQLEnumValue(description="" +
		"<h5>Dawn</h5>" +
		"House Martell.<br>" +
		"<b><i>Weapon.</i></b><br>" +
		"Attached character gets +1 STR for each plot card in your used pile.While attached character has the <i>House Dayne</i> trait, it gains intimidate..<br>" +
		"<i>Core Set.</i><br>"
	)
	DAWN_Core ("01115"),
	@GraphQLEnumValue(description="" +
		"<h5>Ghaston Grey</h5>" +
		"House Martell.<br>" +
		"<b><i>Dorne.</i></b><br>" +
		"<b>Reaction:</b> After you lose a challenge as the defending player, kneel and sacrifice Ghaston Grey to return an attacking character to its owner's hand (cannot be saved)..<br>" +
		"<i>Core Set.</i><br>"
	)
	GHASTON_GREY_Core ("01116"),
	@GraphQLEnumValue(description="" +
		"<h5>Sunspear</h5>" +
		"House Martell.<br>" +
		"<b><i>Dorne.</i></b><br>" +
		"<b>Reaction:</b> After you lose a challenge as the defending player, kneel Sunspear to raise the claim value on your revealed plot card by 1 during challenges of this same type until the end of the phase..<br>" +
		"<i>Core Set.</i><br>"
	)
	SUNSPEAR_Core ("01117"),
	@GraphQLEnumValue(description="" +
		"<h5>Blood Orange Grove</h5>" +
		"House Martell.<br>" +
		"<b><i>Dorne.</i></b><br>" +
		"Limited.<b>Marshaling Action:</b> Kneel Blood Orange Grove to reduce the cost of the next [martell] card you marshal this phase by 1..<br>" +
		"<i>Core Set.</i><br>"
	)
	BLOOD_ORANGE_GROVE_Core ("01118"),
	@GraphQLEnumValue(description="" +
		"<h5>Doran's Game</h5>" +
		"House Martell.<br>" +
		"<b>Reaction:</b> After you win an [intrigue] challenge by 5 or more STR, gain X power for your faction. X is the number of plot cards in your used pile. (Max 1 per challenge.).<br>" +
		"<i>Core Set.</i><br>"
	)
	DORANS_GAME_Core ("01119"),
	@GraphQLEnumValue(description="" +
		"<h5>Unbowed, Unbent, Unbroken</h5>" +
		"House Martell.<br>" +
		"Play only if you are not the first player.<b>Reaction:</b> After you lose a challenge as the defending player, name a challenge type. Until the end of the phase, the winner of the challenge cannot initiate challenges of that type. (Max 1 per challenge.).<br>" +
		"<i>Core Set.</i><br>"
	)
	UNBOWED_UNBENT_UNBROKEN_Core ("01120"),
	@GraphQLEnumValue(description="" +
		"<h5>Confinement</h5>" +
		"House Martell.<br>" +
		"<b>Action:</b> Choose a character with STR 4 or lower. Until the end of the phase, that character loses a [military], an [intrigue], and a [power] icon..<br>" +
		"<i>Core Set.</i><br>"
	)
	CONFINEMENT_Core ("01121"),
	@GraphQLEnumValue(description="" +
		"<h5>Benjen Stark</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Ranger.</i></b><br>" +
		"Each <i>Ranger</i> character you control cannot be bypassed by stealth.<b>Interrupt:</b> When Benjen Stark is killed, gain 2 power for your faction. Then, shuffle him back into your deck instead of placing him in your dead pile..<br>" +
		"<i>Core Set.</i><br>"
	)
	BENJEN_STARK_Core ("01122"),
	@GraphQLEnumValue(description="" +
		"<h5>Ghost (Core)</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Direwolf.</i></b><br>" +
		"No attachments. Stealth.<b>Reaction:</b> After Ghost bypasses a character using stealth, that character cannot be declared as a defender for any challenges until the end of the phase..<br>" +
		"<i>Core Set.</i><br>"
	)
	GHOST_Core ("01123"),
	@GraphQLEnumValue(description="" +
		"<h5>Jon Snow (Core)</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Bastard. Steward.</i></b><br>" +
		"No attachments except <i>Weapon</i>.While Jon Snow is standing, he is considered to be participating in each challenge in which you control another attacking [thenightswatch] character..<br>" +
		"<i>Core Set.</i><br>"
	)
	JON_SNOW_Core ("01124"),
	@GraphQLEnumValue(description="" +
		"<h5>Maester Aemon (Core)</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Maester. Steward.</i></b><br>" +
		"No attachments.<b>Interrupt:</b> When a [thenightswatch] character would be killed, kneel Master Aemon to save it..<br>" +
		"<i>Core Set.</i><br>"
	)
	MAESTER_AEMON_Core ("01125"),
	@GraphQLEnumValue(description="" +
		"<h5>Old Bear Mormont (Core)</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Commander. Lord.</i></b><br>" +
		"While you control The Wall, Old Bear Mormont does not kneel when declared as a defender.<b>Interrupt:</b> When the challenges phase ends, if you have not lost a challenge as the defending player this phase, put a [thenightswatch] card into play from your hand..<br>" +
		"<i>Core Set.</i><br>"
	)
	OLD_BEAR_MORMONT_Core ("01126"),
	@GraphQLEnumValue(description="" +
		"<h5>Samwell Tarly (Core)</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Steward.</i></b><br>" +
		"Insight.+1 Reserve..<br>" +
		"<i>Core Set.</i><br>"
	)
	SAMWELL_TARLY_Core ("01127"),
	@GraphQLEnumValue(description="" +
		"<h5>Ser Waymar Royce</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Knight. Ranger.</i></b><br>" +
		"No attachments except <i>Weapon</i>.<b>Interrupt:</b> When Ser Waymar Royce is killed, discard 1 card at random from each opponent's hand..<br>" +
		"<i>Core Set.</i><br>"
	)
	SER_WAYMAR_ROYCE_Core ("01128"),
	@GraphQLEnumValue(description="" +
		"<h5>Yoren (Core)</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Wandering Crow.</i></b><br>" +
		"<b>Reaction:</b> After you marshal Yoren, choose a character with printed cost 3 or lower in an opponent's discard pile, and put it into play under your control..<br>" +
		"<i>Core Set.</i><br>"
	)
	YOREN_Core ("01129"),
	@GraphQLEnumValue(description="" +
		"<h5>Messenger Raven</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Raven.</i></b><br>" +
		"No attachments.<b>Dominance Action:</b> Return Messenger Raven to your hand to draw 1 card..<br>" +
		"<i>Core Set.</i><br>"
	)
	MESSENGER_RAVEN_Core ("01130"),
	@GraphQLEnumValue(description="" +
		"<h5>Old Forest Hunter</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Ranger.</i></b><br>" +
		"No attachments except <i>Weapon</i>.<b>Action:</b> Discard 1 card from your hand to gain 1 gold. (Limit once per phase.).<br>" +
		"<i>Core Set.</i><br>"
	)
	OLD_FOREST_HUNTER_Core ("01131"),
	@GraphQLEnumValue(description="" +
		"<h5>Ranging Party</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Army. Ranger.</i></b><br>" +
		"No attachments except <i>Weapon</i>..<br>" +
		"<i>Core Set.</i><br>"
	)
	RANGING_PARTY_Core ("01132"),
	@GraphQLEnumValue(description="" +
		"<h5>Steward at the Wall</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Ally. Steward.</i></b><br>" +
		"<b>Marshaling Action:</b> Kneel Steward at the Wall to reduce the cost of the next [thenightswatch] character you marshal this phase by 1..<br>" +
		"<i>Core Set.</i><br>"
	)
	STEWARD_AT_THE_WALL_Core ("01133"),
	@GraphQLEnumValue(description="" +
		"<h5>Veteran Builder</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Builder.</i></b><br>" +
		"No attachments except <i>Weapon</i>.<b>Action:</b> Sacrifice Veteran Builder to choose and stand a location..<br>" +
		"<i>Core Set.</i><br>"
	)
	VETERAN_BUILDER_Core ("01134"),
	@GraphQLEnumValue(description="" +
		"<h5>Longclaw</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Valyrian Steel. Weapon.</i></b><br>" +
		"[thenightswatch] character only.Attached character gets +1 STR and gains renown..<br>" +
		"<i>Core Set.</i><br>"
	)
	LONGCLAW_Core ("01135"),
	@GraphQLEnumValue(description="" +
		"<h5>Castle Black</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>The North.</i></b><br>" +
		"<b>Action:</b> Kneel Castle Black to choose and stand a defending [thenightswatch] character. Until the end of the challenge, that character gets +2 STR..<br>" +
		"<i>Core Set.</i><br>"
	)
	CASTLE_BLACK_Core ("01136"),
	@GraphQLEnumValue(description="" +
		"<h5>The Wall (Core)</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Stronghold. The North.</i></b><br>" +
		"Each [thenightswatch] character you control gets +1 STR.<b>Forced Reaction:</b> After you lose an unopposed challenge, kneel The Wall.<b>Interrupt:</b> When the challenges phase ends, kneel The Wall to gain 2 power for your faction..<br>" +
		"<i>Core Set.</i><br>"
	)
	THE_WALL_Core ("01137"),
	@GraphQLEnumValue(description="" +
		"<h5>A Meager Contribution</h5>" +
		"The Night's Watch.<br>" +
		"<b>Reaction:</b> After an opponent collects income, move 1 gold from that player's gold pool to your own. (Max 1 per round.).<br>" +
		"<i>Core Set.</i><br>"
	)
	A_MEAGER_CONTRIBUTION_Core ("01138"),
	@GraphQLEnumValue(description="" +
		"<h5>Take the Black</h5>" +
		"The Night's Watch.<br>" +
		"<b>Dominance Action:</b> Choose a non-unique character with printed cost 6 or lower. Take control of that character. (Max 1 per round.).<br>" +
		"<i>Core Set.</i><br>"
	)
	TAKE_THE_BLACK_Core ("01139"),
	@GraphQLEnumValue(description="" +
		"<h5>The Sword in the Darkness</h5>" +
		"The Night's Watch.<br>" +
		"Play only during a challenge in which you control a participating [thenightswatch] character.<b>Reaction:</b> After you win a challenge by 5 or more STR as the defending player, the losing opponent cannot initiate challenges against you this round..<br>" +
		"<i>Core Set.</i><br>"
	)
	THE_SWORD_IN_THE_DARKNESS_Core ("01140"),
	@GraphQLEnumValue(description="" +
		"<h5>Arya Stark (Core)</h5>" +
		"House Stark.<br>" +
		"<b><i>Lady.</i></b><br>" +
		"Stealth.While Arya Stark has a duplicate, she gains a [military] icon.<b>Reaction:</b> After Arya Stark enters play, place the top card of your deck on her facedown as a duplicate..<br>" +
		"<i>Core Set.</i><br>"
	)
	ARYA_STARK_Core ("01141"),
	@GraphQLEnumValue(description="" +
		"<h5>Bran Stark (Core)</h5>" +
		"House Stark.<br>" +
		"<b><i>Lord.</i></b><br>" +
		"<b>Interrupt:</b> When the effects of an opponent's event would initiate, sacrifice Bran Stark to cancel those effects..<br>" +
		"<i>Core Set.</i><br>"
	)
	BRAN_STARK_Core ("01142"),
	@GraphQLEnumValue(description="" +
		"<h5>Catelyn Stark (Core)</h5>" +
		"House Stark.<br>" +
		"<b><i>House Tully. Lady. The Seven.</i></b><br>" +
		"While Catelyn Stark is participating in a challenge, your opponents cannot trigger card abilities..<br>" +
		"<i>Core Set.</i><br>"
	)
	CATELYN_STARK_Core ("01143"),
	@GraphQLEnumValue(description="" +
		"<h5>Eddard Stark (Core)</h5>" +
		"House Stark.<br>" +
		"<b><i>Lord. Small Council.</i></b><br>" +
		"Renown.<b>Reaction:</b> After a challenge is initiated against you, stand Eddard Stark..<br>" +
		"<i>Core Set.</i><br>"
	)
	EDDARD_STARK_Core ("01144"),
	@GraphQLEnumValue(description="" +
		"<h5>Grey Wind</h5>" +
		"House Stark.<br>" +
		"<b><i>Direwolf.</i></b><br>" +
		"Intimidate. No attachments.<b>Challenges Action:</b> Kneel Grey Wind to choose and kill a character with STR 1 or lower. (STR 2 or lower instead if you control Robb Stark)..<br>" +
		"<i>Core Set.</i><br>"
	)
	GREY_WIND_Core ("01145"),
	@GraphQLEnumValue(description="" +
		"<h5>Robb Stark (Core)</h5>" +
		"House Stark.<br>" +
		"<b><i>Lord.</i></b><br>" +
		"Renown.<b>Reaction:</b> After a [stark] character you control is sacrificed or killed, stand each character you control. (Limit once per round.).<br>" +
		"<i>Core Set.</i><br>"
	)
	ROBB_STARK_Core ("01146"),
	@GraphQLEnumValue(description="" +
		"<h5>Sansa Stark (Core)</h5>" +
		"House Stark.<br>" +
		"<b><i>Lady.</i></b><br>" +
		"Sansa Stark enters play knelt.<b>Reaction:</b> After Sansa Stark stands, gain 1 power for your faction. (Limit once per round.).<br>" +
		"<i>Core Set.</i><br>"
	)
	SANSA_STARK_Core ("01147"),
	@GraphQLEnumValue(description="" +
		"<h5>Summer (Core)</h5>" +
		"House Stark.<br>" +
		"<b><i>Direwolf.</i></b><br>" +
		"No attachments.While you control Bran Stark, he gains insight.<b>Reaction:</b> After Summer enters play, return a [stark] character with printed STR 2 or lower from your discard or dead pile to your hand..<br>" +
		"<i>Core Set.</i><br>"
	)
	SUMMER_Core ("01148"),
	@GraphQLEnumValue(description="" +
		"<h5>Direwolf Pup</h5>" +
		"House Stark.<br>" +
		"<b><i>Direwolf.</i></b><br>" +
		"No attachments.Direwolf Pup gets +1 STR for each other <i>Direwolf</i> card you control..<br>" +
		"<i>Core Set.</i><br>"
	)
	DIREWOLF_PUP_Core ("01149"),
	@GraphQLEnumValue(description="" +
		"<h5>Tumblestone Knight</h5>" +
		"House Stark.<br>" +
		"<b><i>House Tully. Knight.</i></b><br>" +
		".<br>" +
		"<i>Core Set.</i><br>"
	)
	TUMBLESTONE_KNIGHT_Core ("01150"),
	@GraphQLEnumValue(description="" +
		"<h5>Vanguard of the North</h5>" +
		"House Stark.<br>" +
		"<b><i>Army.</i></b><br>" +
		"No attachments.While a player has a <i>War</i> plot revealed, Vanguard of the North does not kneel when declared as an attacker in a [military] challenge..<br>" +
		"<i>Core Set.</i><br>"
	)
	VANGUARD_OF_THE_NORTH_Core ("01151"),
	@GraphQLEnumValue(description="" +
		"<h5>Winterfell Steward</h5>" +
		"House Stark.<br>" +
		"<b><i>Ally. Steward.</i></b><br>" +
		"<b>Marshaling Action:</b> Kneel Winterfell Steward to reduce the cost of the next [stark] character you marshal this phase by 1..<br>" +
		"<i>Core Set.</i><br>"
	)
	WINTERFELL_STEWARD_Core ("01152"),
	@GraphQLEnumValue(description="" +
		"<h5>Ice</h5>" +
		"House Stark.<br>" +
		"<b><i>Valyrian Steel. Weapon.</i></b><br>" +
		"[stark] character only. Attached character gets +2 STR.<b>Reaction:</b> After you win a [military] challenge in which attached character is participating, sacrifice Ice to choose and kill a character controlled by the losing opponent..<br>" +
		"<i>Core Set.</i><br>"
	)
	ICE_Core ("01153"),
	@GraphQLEnumValue(description="" +
		"<h5>Gates of Winterfell</h5>" +
		"House Stark.<br>" +
		"<b><i>The North. Winterfell.</i></b><br>" +
		"<b>Challenges Action:</b> Kneel Gates of Winterfell to reveal the top card of your deck. If it is a [stark] card, draw it..<br>" +
		"<i>Core Set.</i><br>"
	)
	GATES_OF_WINTERFELL_Core ("01154"),
	@GraphQLEnumValue(description="" +
		"<h5>The Wolfswood</h5>" +
		"House Stark.<br>" +
		"<b><i>The North.</i></b><br>" +
		"Each <i>Direwolf</i> card in your hand gains ambush (X). X is that card's printed cost..<br>" +
		"<i>Core Set.</i><br>"
	)
	THE_WOLFSWOOD_Core ("01155"),
	@GraphQLEnumValue(description="" +
		"<h5>Heart Tree Grove</h5>" +
		"House Stark.<br>" +
		"<b><i>Old Gods. Winterfell.</i></b><br>" +
		"Limited.<b>Marshaling Action:</b> Kneel Heart Tree Grove to reduce the cost of the next [stark] card you marshal this phase by 1..<br>" +
		"<i>Core Set.</i><br>"
	)
	HEART_TREE_GROVE_Core ("01156"),
	@GraphQLEnumValue(description="" +
		"<h5>For the North!</h5>" +
		"House Stark.<br>" +
		"Play only during a [military] challenge.<b>Action:</b> Choose a participating [stark] character. Until the end of the challenge, that character gets +2 STR. If you win the challenge, draw 1 card..<br>" +
		"<i>Core Set.</i><br>"
	)
	FOR_THE_NORTH_Core ("01157"),
	@GraphQLEnumValue(description="" +
		"<h5>Like Warm Rain</h5>" +
		"House Stark.<br>" +
		"<b>Reaction:</b> After you lose an [intrigue] challenge as the defending player, kneel a <i>Direwolf</i> character to choose and kill an attacking character. (Max 1 per challenge.).<br>" +
		"<i>Core Set.</i><br>"
	)
	LIKE_WARM_RAIN_Core ("01158"),
	@GraphQLEnumValue(description="" +
		"<h5>Winter Is Coming</h5>" +
		"House Stark.<br>" +
		"Play only during a challenge.<b>Action:</b> Until the end of the challenge, raise the claim value on your revealed plot card by 1. (Max 1 per challenge.).<br>" +
		"<i>Core Set.</i><br>"
	)
	WINTER_IS_COMING_Core ("01159"),
	@GraphQLEnumValue(description="" +
		"<h5>Daenerys Targaryen (Core)</h5>" +
		"House Targaryen.<br>" +
		"<b><i>Lady. Stormborn.</i></b><br>" +
		"Insight.While Daenerys Targaryen is standing, each character participating on an opponent's side in a challenge against you gets -1 STR..<br>" +
		"<i>Core Set.</i><br>"
	)
	DAENERYS_TARGARYEN_Core ("01160"),
	@GraphQLEnumValue(description="" +
		"<h5>Drogon (Core)</h5>" +
		"House Targaryen.<br>" +
		"<b><i>Dragon. Hatchling.</i></b><br>" +
		"No attachments.Each <i>Stormborn</i> character you control gains renown..<br>" +
		"<i>Core Set.</i><br>"
	)
	DROGON_Core ("01161"),
	@GraphQLEnumValue(description="" +
		"<h5>Khal Drogo</h5>" +
		"House Targaryen.<br>" +
		"<b><i>Dothraki. Lord.</i></b><br>" +
		"Renown.You may initiate an additional [military] challenge during the challenges phase..<br>" +
		"<i>Core Set.</i><br>"
	)
	KHAL_DROGO_Core ("01162"),
	@GraphQLEnumValue(description="" +
		"<h5>Magister Illyrio</h5>" +
		"House Targaryen.<br>" +
		"<b><i>Lord. Merchant.</i></b><br>" +
		"<b>Action:</b> Pay 2 gold to choose and stand a character. (Limit once per phase.).<br>" +
		"<i>Core Set.</i><br>"
	)
	MAGISTER_ILLYRIO_Core ("01163"),
	@GraphQLEnumValue(description="" +
		"<h5>Rhaegal (Core)</h5>" +
		"House Targaryen.<br>" +
		"<b><i>Dragon. Hatchling.</i></b><br>" +
		"No attachments.<b>Reaction:</b> After you win a challenge in which a <i>Stormborn</i> character you control is participating, choose and stand a <i>Stormborn</i> character. (Limit once per phase.).<br>" +
		"<i>Core Set.</i><br>"
	)
	RHAEGAL_Core ("01164"),
	@GraphQLEnumValue(description="" +
		"<h5>Ser Jorah Mormont (Core)</h5>" +
		"House Targaryen.<br>" +
		"<b><i>Companion. Knight.</i></b><br>" +
		"Renown.If Ser Jorah Mormont has 3 or more betrayal tokens on him, sacrifice him.<b>Forced Reaction:</b> After you win a challenge in which Ser Jorah Mormont is participating, place 1 betrayal token on him..<br>" +
		"<i>Core Set.</i><br>"
	)
	SER_JORAH_MORMONT_Core ("01165"),
	@GraphQLEnumValue(description="" +
		"<h5>Viserion (Core)</h5>" +
		"House Targaryen.<br>" +
		"<b><i>Dragon. Hatchling.</i></b><br>" +
		"No attachments.Each <i>Stormborn</i> character you control gains stealth..<br>" +
		"<i>Core Set.</i><br>"
	)
	VISERION_Core ("01166"),
	@GraphQLEnumValue(description="" +
		"<h5>Viserys Targaryen (Core)</h5>" +
		"House Targaryen.<br>" +
		"<b><i>Lord.</i></b><br>" +
		"<b>Interrupt:</b> When Viserys Targaryen leaves play, choose an attachment, and discard it from play..<br>" +
		"<i>Core Set.</i><br>"
	)
	VISERYS_TARGARYEN_Core ("01167"),
	@GraphQLEnumValue(description="" +
		"<h5>Braided Warrior</h5>" +
		"House Targaryen.<br>" +
		"<b><i>Dothraki.</i></b><br>" +
		"No attachments except <i>Weapon</i>..<br>" +
		"<i>Core Set.</i><br>"
	)
	BRAIDED_WARRIOR_Core ("01168"),
	@GraphQLEnumValue(description="" +
		"<h5>Handmaiden</h5>" +
		"House Targaryen.<br>" +
		"<b><i>Ally. Companion.</i></b><br>" +
		"<b>Action:</b> Sacrifice Handmaiden to choose and stand a <i>Lady</i> character..<br>" +
		"<i>Core Set.</i><br>"
	)
	HANDMAIDEN_Core ("01169"),
	@GraphQLEnumValue(description="" +
		"<h5>Targaryen Loyalist</h5>" +
		"House Targaryen.<br>" +
		"<b><i>Ally.</i></b><br>" +
		"<b>Marshaling Action:</b> Kneel Targaryen Loyalist to reduce the cost of the next [targaryen] character you marshal this phase by 1..<br>" +
		"<i>Core Set.</i><br>"
	)
	TARGARYEN_LOYALIST_Core ("01170"),
	@GraphQLEnumValue(description="" +
		"<h5>Unsullied</h5>" +
		"House Targaryen.<br>" +
		"<b><i>Army.</i></b><br>" +
		"No attachments except <i>Weapon</i>.While Unsullied is attacking, each defending character gets -1 STR..<br>" +
		"<i>Core Set.</i><br>"
	)
	UNSULLIED_Core ("01171"),
	@GraphQLEnumValue(description="" +
		"<h5>Drogo's Arakh</h5>" +
		"House Targaryen.<br>" +
		"<b><i>Weapon.</i></b><br>" +
		"<i>Dothraki</i> character only.Attached character gets +2 STR.If attached character is Khal Drogo, he does not kneel when declared as an attacker in the first [military] challenge you initiate each round..<br>" +
		"<i>Core Set.</i><br>"
	)
	DROGOS_ARAKH_Core ("01172"),
	@GraphQLEnumValue(description="" +
		"<h5>Plaza of Punishment</h5>" +
		"House Targaryen.<br>" +
		"<b><i>Astapor.</i></b><br>" +
		"<b>Reaction:</b> After you win a [power] challenge, kneel Plaza of Punishment to choose a character without attachments. Until the end of the phase, that character gets -2 STR and is killed if its STR is 0..<br>" +
		"<i>Core Set.</i><br>"
	)
	PLAZA_OF_PUNISHMENT_Core ("01173"),
	@GraphQLEnumValue(description="" +
		"<h5>Dothraki Sea</h5>" +
		"House Targaryen.<br>" +
		"<b><i>Essos.</i></b><br>" +
		"<b>Reaction:</b> After you win a [power] challenge, sacrifice Dothraki Sea to put a <i>Dothraki</i> character into play from your hand. At the end of the phase, if that card is still in play, return it to your hand (cannot be saved)..<br>" +
		"<i>Core Set.</i><br>"
	)
	DOTHRAKI_SEA_Core ("01174"),
	@GraphQLEnumValue(description="" +
		"<h5>Illyrio's Estate</h5>" +
		"House Targaryen.<br>" +
		"<b><i>Pentos.</i></b><br>" +
		"Limited.<b>Marshaling Action:</b> Kneel Illyrio's Estate to reduce the cost of the next [targaryen] card you marshal this phase by 1..<br>" +
		"<i>Core Set.</i><br>"
	)
	ILLYRIOS_ESTATE_Core ("01175"),
	@GraphQLEnumValue(description="" +
		"<h5>Dracarys!</h5>" +
		"House Targaryen.<br>" +
		"<b>Action:</b> Kneel a <i>Dragon</i> character or Daenerys Targaryen to choose a participating character. Until the end of the phase, that character gets -4 STR and is killed if its STR is 0..<br>" +
		"<i>Core Set.</i><br>"
	)
	DRACARYS_Core ("01176"),
	@GraphQLEnumValue(description="" +
		"<h5>Fire and Blood</h5>" +
		"House Targaryen.<br>" +
		"<b>Challenges Action:</b> Choose a unique [targaryen] character in your dead pile, and shuffle it back into your deck. If that character is a <i>Hatchling</i>, you may put it into play instead..<br>" +
		"<i>Core Set.</i><br>"
	)
	FIRE_AND_BLOOD_Core ("01177"),
	@GraphQLEnumValue(description="" +
		"<h5>Waking the Dragon</h5>" +
		"House Targaryen.<br>" +
		"<b>Action:</b> Choose and stand a unique [targaryen] character you control. At the end of the phase, if that character is still in play, return it to your hand..<br>" +
		"<i>Core Set.</i><br>"
	)
	WAKING_THE_DRAGON_Core ("01178"),
	@GraphQLEnumValue(description="" +
		"<h5>Left</h5>" +
		"House Tyrell.<br>" +
		"<b><i>Guard.</i></b><br>" +
		"No attachments except <i>Weapon</i>.While you control Right, Left gets +1 STR, gains a [power] icon, and does not kneel when declared as a defender..<br>" +
		"<i>Core Set.</i><br>"
	)
	LEFT_Core ("01179"),
	@GraphQLEnumValue(description="" +
		"<h5>Maester Lomys</h5>" +
		"House Tyrell.<br>" +
		"<b><i>Maester.</i></b><br>" +
		"<b>Reaction:</b> After you win an [intrigue] challenge as the defending player, discard 1 card at random from the attacking player's hand..<br>" +
		"<i>Core Set.</i><br>"
	)
	MAESTER_LOMYS_Core ("01180"),
	@GraphQLEnumValue(description="" +
		"<h5>Margaery Tyrell (Core)</h5>" +
		"House Tyrell.<br>" +
		"<b><i>Lady.</i></b><br>" +
		"<b>Challenges Action:</b> Kneel Margaery Tyrell to choose a character. Until the end of the phase, that character gets +3 STR..<br>" +
		"<i>Core Set.</i><br>"
	)
	MARGAERY_TYRELL_Core ("01181"),
	@GraphQLEnumValue(description="" +
		"<h5>Paxter Redwyne</h5>" +
		"House Tyrell.<br>" +
		"<b><i>House Redwyne. Lord.</i></b><br>" +
		"Reduce the cost of the first event you play each round by 1.+1 Income..<br>" +
		"<i>Core Set.</i><br>"
	)
	PAXTER_REDWYNE_Core ("01182"),
	@GraphQLEnumValue(description="" +
		"<h5>Randyll Tarly</h5>" +
		"House Tyrell.<br>" +
		"<b><i>House Tarly. Lord.</i></b><br>" +
		"Renown.<b>Reaction:</b> After Randyll Tarly's STR is increased by a card effect, stand him. (Limit twice per phase.).<br>" +
		"<i>Core Set.</i><br>"
	)
	RANDYLL_TARLY_Core ("01183"),
	@GraphQLEnumValue(description="" +
		"<h5>Right</h5>" +
		"House Tyrell.<br>" +
		"<b><i>Guard.</i></b><br>" +
		"No attachments except <i>Weapon</i>.While you control Left, Right gets +1 STR, gains an [intrigue] icon, and does not kneel when declared as a defender..<br>" +
		"<i>Core Set.</i><br>"
	)
	RIGHT_Core ("01184"),
	@GraphQLEnumValue(description="" +
		"<h5>The Knight of Flowers (Core)</h5>" +
		"House Tyrell.<br>" +
		"<b><i>Knight. Lord.</i></b><br>" +
		"Renown.While The Knight of Flowers is attacking alone, the defending player cannot declare more than 1 character as a defender..<br>" +
		"<i>Core Set.</i><br>"
	)
	THE_KNIGHT_OF_FLOWERS_Core ("01185"),
	@GraphQLEnumValue(description="" +
		"<h5>The Queen of Thorns (Core)</h5>" +
		"House Tyrell.<br>" +
		"<b><i>Lady.</i></b><br>" +
		"<b>Reaction:</b> After you win an [intrigue] challenge in which The Queen of Thorns is participating, put a [tyrell] character with printed cost 6 or lower into play from your hand..<br>" +
		"<i>Core Set.</i><br>"
	)
	THE_QUEEN_OF_THORNS_Core ("01186"),
	@GraphQLEnumValue(description="" +
		"<h5>Courtesan of the Rose</h5>" +
		"House Tyrell.<br>" +
		"<b><i>Companion. Spy.</i></b><br>" +
		".<br>" +
		"<i>Core Set.</i><br>"
	)
	COURTESAN_OF_THE_ROSE_Core ("01187"),
	@GraphQLEnumValue(description="" +
		"<h5>Garden Caretaker</h5>" +
		"House Tyrell.<br>" +
		"<b><i>Ally.</i></b><br>" +
		"<b>Marshaling Action:</b> Kneel Garden Caretaker to reduce the cost of the next [tyrell] character you marshal this phase by 1..<br>" +
		"<i>Core Set.</i><br>"
	)
	GARDEN_CARETAKER_Core ("01188"),
	@GraphQLEnumValue(description="" +
		"<h5>Olenna's Informant</h5>" +
		"House Tyrell.<br>" +
		"<b><i>Ally. Spy.</i></b><br>" +
		"Ambush (4).<b>Reaction:</b> After Olenna's Informant enters play during the challenges phase, name a challenge type. You may initiate an additional challenge of that type this phase..<br>" +
		"<i>Core Set.</i><br>"
	)
	OLENNAS_INFORMANT_Core ("01189"),
	@GraphQLEnumValue(description="" +
		"<h5>Wardens of the Reach</h5>" +
		"House Tyrell.<br>" +
		"<b><i>Army.</i></b><br>" +
		"No attachments.Wardens of the Reach gets +1 STR for each <i>The Reach</i> location you control..<br>" +
		"<i>Core Set.</i><br>"
	)
	WARDENS_OF_THE_REACH_Core ("01190"),
	@GraphQLEnumValue(description="" +
		"<h5>Heartsbane</h5>" +
		"House Tyrell.<br>" +
		"<b><i>Valyrian Steel. Weapon.</i></b><br>" +
		"[tyrell] character only.<b>Action:</b> While attached character is participating in a challenge, kneel Heartsbane to give that character +3 STR until the end of the challenge..<br>" +
		"<i>Core Set.</i><br>"
	)
	HEARTSBANE_Core ("01191"),
	@GraphQLEnumValue(description="" +
		"<h5>Highgarden</h5>" +
		"House Tyrell.<br>" +
		"<b><i>Stronghold. The Reach.</i></b><br>" +
		"<b>Challenges Action:</b> Kneel Highgarden and pay 1 gold to choose an attacking character. Stand that character and remove it from the challenge..<br>" +
		"<i>Core Set.</i><br>"
	)
	HIGHGARDEN_Core ("01192"),
	@GraphQLEnumValue(description="" +
		"<h5>The Mander</h5>" +
		"House Tyrell.<br>" +
		"<b><i>The Reach.</i></b><br>" +
		"<b>Reaction:</b> After you win a challenge by 5 or more STR, kneel The Mander to draw 2 cards..<br>" +
		"<i>Core Set.</i><br>"
	)
	THE_MANDER_Core ("01193"),
	@GraphQLEnumValue(description="" +
		"<h5>Rose Garden</h5>" +
		"House Tyrell.<br>" +
		"<b><i>The Reach.</i></b><br>" +
		"Limited.<b>Marshaling Action:</b> Kneel Rose Garden to reduce the cost of the next [tyrell] card you marshal this phase by 1..<br>" +
		"<i>Core Set.</i><br>"
	)
	ROSE_GARDEN_Core ("01194"),
	@GraphQLEnumValue(description="" +
		"<h5>Growing Strong</h5>" +
		"House Tyrell.<br>" +
		"<b>Challenges Action:</b> Choose up to three [tyrell] characters. Until the end of the phase, each of the chosen characters gets +2 STR..<br>" +
		"<i>Core Set.</i><br>"
	)
	GROWING_STRONG_Core ("01195"),
	@GraphQLEnumValue(description="" +
		"<h5>Olenna's Cunning</h5>" +
		"House Tyrell.<br>" +
		"<b>Reaction:</b> After you win an [intrigue] or [power] challenge, the losing opponent names a cardtype (character, location, attachment, or event). Search your deck for a card with a different cardtype, reveal it, and add it to your hand. Shuffle your deck..<br>" +
		"<i>Core Set.</i><br>"
	)
	OLENNAS_CUNNING_Core ("01196"),
	@GraphQLEnumValue(description="" +
		"<h5>\"The Bear and the Maiden Fair\"</h5>" +
		"House Tyrell.<br>" +
		"<b><i>Song.</i></b><br>" +
		"<b>Action:</b> Choose a player. Look at the top 5 cards of that player's deck. Place up to 3 of those cards on the bottom of that deck, and the others on top, in any order..<br>" +
		"<i>Core Set.</i><br>"
	)
	THE_BEAR_AND_THE_MAIDEN_FAIR_Core ("01197"),
	@GraphQLEnumValue(description="" +
		"<h5>Banner of the Stag</h5>" +
		"Neutral.<br>" +
		"<b><i>Banner.</i></b><br>" +
		"You may include non-loyal [baratheon] cards in your deck.You must include at least 12 [baratheon] cards in your deck..<br>" +
		"<i>Core Set.</i><br>"
	)
	BANNER_OF_THE_STAG_Core ("01198"),
	@GraphQLEnumValue(description="" +
		"<h5>Banner of the Kraken</h5>" +
		"Neutral.<br>" +
		"<b><i>Banner.</i></b><br>" +
		"You may include non-loyal [greyjoy] cards in your deck.You must include at least 12 [greyjoy] cards in your deck..<br>" +
		"<i>Core Set.</i><br>"
	)
	BANNER_OF_THE_KRAKEN_Core ("01199"),
	@GraphQLEnumValue(description="" +
		"<h5>Banner of the Lion</h5>" +
		"Neutral.<br>" +
		"<b><i>Banner.</i></b><br>" +
		"You may include non-loyal [lannister] cards in your deck.You must include at least 12 [lannister] cards in your deck..<br>" +
		"<i>Core Set.</i><br>"
	)
	BANNER_OF_THE_LION_Core ("01200"),
	@GraphQLEnumValue(description="" +
		"<h5>Banner of the Sun</h5>" +
		"Neutral.<br>" +
		"<b><i>Banner.</i></b><br>" +
		"You may include non-loyal [martell] cards in your deck.You must include at least 12 [martell] cards in your deck..<br>" +
		"<i>Core Set.</i><br>"
	)
	BANNER_OF_THE_SUN_Core ("01201"),
	@GraphQLEnumValue(description="" +
		"<h5>Banner of the Watch</h5>" +
		"Neutral.<br>" +
		"<b><i>Banner.</i></b><br>" +
		"You may include non-loyal [thenightswatch] cards in your deck.You must include at least 12 [thenightswatch] cards in your deck..<br>" +
		"<i>Core Set.</i><br>"
	)
	BANNER_OF_THE_WATCH_Core ("01202"),
	@GraphQLEnumValue(description="" +
		"<h5>Banner of the Wolf</h5>" +
		"Neutral.<br>" +
		"<b><i>Banner.</i></b><br>" +
		"You may include non-loyal [stark] cards in your deck.You must include at least 12 [stark] cards in your deck..<br>" +
		"<i>Core Set.</i><br>"
	)
	BANNER_OF_THE_WOLF_Core ("01203"),
	@GraphQLEnumValue(description="" +
		"<h5>Banner of the Dragon</h5>" +
		"Neutral.<br>" +
		"<b><i>Banner.</i></b><br>" +
		"You may include non-loyal [targaryen] cards in your deck.You must include at least 12 [targaryen] cards in your deck..<br>" +
		"<i>Core Set.</i><br>"
	)
	BANNER_OF_THE_DRAGON_Core ("01204"),
	@GraphQLEnumValue(description="" +
		"<h5>Banner of the Rose</h5>" +
		"Neutral.<br>" +
		"<b><i>Banner.</i></b><br>" +
		"You may include non-loyal [tyrell] cards in your deck.You must include at least 12 [tyrell] cards in your deck..<br>" +
		"<i>Core Set.</i><br>"
	)
	BANNER_OF_THE_ROSE_Core ("01205"),
	@GraphQLEnumValue(description="" +
		"<h5>Master of Whispers</h5>" +
		"Neutral.<br>" +
		"Supported by Master of ShipsSupports: Hand of the KingRivals: Master of Laws, Master of CoinYou may resolve your [intrigue] claim against any number of opponents of your choice.+1 STR [intrigue].<br>" +
		"<i>Core Set.</i><br>"
	)
	MASTER_OF_WHISPERS_Core ("01206"),
	@GraphQLEnumValue(description="" +
		"<h5>Master of Ships</h5>" +
		"Neutral.<br>" +
		"Supported by Master of CoinSupports: Master of WhispersRivals: Master of Laws, Hand of the KingRaise the claim value on your revealed plot card by 1 during [military] challenges in which you are attacking a rival.+1 STR [military].<br>" +
		"<i>Core Set.</i><br>"
	)
	MASTER_OF_SHIPS_Core ("01207"),
	@GraphQLEnumValue(description="" +
		"<h5>Hand of the King</h5>" +
		"Neutral.<br>" +
		"Supported by Master of Whispers.Supports: Master of Laws.Rivals: Master of Coin, Master of Ships.You may initiate an additional [power] challenge during the challenges phase, against a different opponent.+1 STR [power].<br>" +
		"<i>Core Set.</i><br>"
	)
	HAND_OF_THE_KING_Core ("01208"),
	@GraphQLEnumValue(description="" +
		"<h5>Master of Coin</h5>" +
		"Neutral.<br>" +
		"Supported by Master of Laws.Supports: Master of ShipsRivals: Hand of the King, Master of Whispers+2 Income..<br>" +
		"<i>Core Set.</i><br>"
	)
	MASTER_OF_COIN_Core ("01209"),
	@GraphQLEnumValue(description="" +
		"<h5>Master of Laws</h5>" +
		"Neutral.<br>" +
		"Supported by Hand of the KingSupports: Master of CoinRivals: Master of Whispers, Master of ShipsIncrease the number of cards you draw in the draw phase by 1.+1 Reserve..<br>" +
		"<i>Core Set.</i><br>"
	)
	MASTER_OF_LAWS_Core ("01210"),
	@GraphQLEnumValue(description="" +
		"<h5>Crown Regent</h5>" +
		"Neutral.<br>" +
		"Supported by NoneSupports: NoneRivals: NoneYou may redirect 1 challenge this round.+2 STR for Dominance.<br>" +
		"<i>Core Set.</i><br>"
	)
	CROWN_REGENT_Core ("01211"),
	@GraphQLEnumValue(description="" +
		"<h5>Will</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Ranger.</i></b><br>" +
		"Stealth. Insight.<b>Forced Reaction:</b> After you lose an unopposed challenge, sacrifice a <i>Ranger</i> character you control..<br>" +
		"<i>Taking the Black.</i><br>"
	)
	WILL_TtB ("02001"),
	@GraphQLEnumValue(description="" +
		"<h5>The Watch Has Need</h5>" +
		"The Night's Watch.<br>" +
		"<b>Action:</b> Name a trait: <i>Builder</i>, <i>Ranger</i>, or <i>Steward</i>. Search the top X cards of your deck for any number of characters with that trait, reveal them, and add them to your hand. Shuffle the other cards back into your deck. X is your reserve value..<br>" +
		"<i>Taking the Black.</i><br>"
	)
	THE_WATCH_HAS_NEED_TtB ("02002"),
	@GraphQLEnumValue(description="" +
		"<h5>Maester Luwin</h5>" +
		"House Stark.<br>" +
		"<b><i>Maester.</i></b><br>" +
		"While you control:- Robb Stark, he gains insight.- Jon Snow, he gains stealth.- Bran Stark, he gains: \"immune to opponents' plot effects.\"- Rickon Stark, he gains pillage..<br>" +
		"<i>Taking the Black.</i><br>"
	)
	MAESTER_LUWIN_TtB ("02003"),
	@GraphQLEnumValue(description="" +
		"<h5>Lady</h5>" +
		"House Stark.<br>" +
		"<b><i>Direwolf.</i></b><br>" +
		"[stark] character only. Terminal.Attached character gets +2 STR.<b>Action:</b> Pay 1 gold to attach Lady to a different character. Then, if attached character is Sansa Stark, stand her. (Limit once per phase.).<br>" +
		"<i>Taking the Black.</i><br>"
	)
	LADY_TtB ("02004"),
	@GraphQLEnumValue(description="" +
		"<h5>Arbor Knight</h5>" +
		"House Tyrell.<br>" +
		"<b><i>House Redwyne. Knight.</i></b><br>" +
		"<b>Challenges Action:</b> Pay 1 gold to choose a participating <i>House Redwyne</i> character. Until the end of the challenge, that character gets +1 STR. (Limit 3 times per phase.).<br>" +
		"<i>Taking the Black.</i><br>"
	)
	ARBOR_KNIGHT_TtB ("02005"),
	@GraphQLEnumValue(description="" +
		"<h5>Pleasure Barge</h5>" +
		"House Tyrell.<br>" +
		"<b><i>Barge.</i></b><br>" +
		"Immune to card effects.<b>Reaction:</b> After you marshal Pleasure Barge, if you have not yet drawn any cards this phase, draw 3 cards.-1 Income..<br>" +
		"<i>Taking the Black.</i><br>"
	)
	PLEASURE_BARGE_TtB ("02006"),
	@GraphQLEnumValue(description="" +
		"<h5>Renly Baratheon (TtB)</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Lord. Small Council.</i></b><br>" +
		"Reduce the cost of the first non-[baratheon] character you marshal each round by 1..<br>" +
		"<i>Taking the Black.</i><br>"
	)
	RENLY_BARATHEON_TtB ("02007"),
	@GraphQLEnumValue(description="" +
		"<h5>King Robert's Warhammer</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Weapon.</i></b><br>" +
		"Attached character gets +1 STR.<b>Reaction:</b> After you win a challenge in which attached character is participating as an attacker, choose and kneel up to X total STR worth of characters, where X is attached character's STR. Then, sacrifice King Robert's Warhammer..<br>" +
		"<i>Taking the Black.</i><br>"
	)
	KING_ROBERTS_WARHAMMER_TtB ("02008"),
	@GraphQLEnumValue(description="" +
		"<h5>The Hound (TtB)</h5>" +
		"House Lannister.<br>" +
		"<b><i>House Clegane.</i></b><br>" +
		"Ambush (4).<b>Forced Reaction:</b> After you win a challenge in which The Hound is participating, you may discard 1 card at random from your hand. If you do not, return The Hound to your hand..<br>" +
		"<i>Taking the Black.</i><br>"
	)
	THE_HOUND_TtB ("02009"),
	@GraphQLEnumValue(description="" +
		"<h5>Cersei's Wheelhouse</h5>" +
		"House Lannister.<br>" +
		"<b><i>Vehicle.</i></b><br>" +
		"<b>Reaction:</b> After you become the first player, either: gain 1 gold, or draw 1 card.-1 Initiative..<br>" +
		"<i>Taking the Black.</i><br>"
	)
	CERSEIS_WHEELHOUSE_TtB ("02010"),
	@GraphQLEnumValue(description="" +
		"<h5>The Seastone Chair</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Iron Islands.</i></b><br>" +
		"<b>Interrupt:</b> When claim is applied for an unopposed [military] challenge in which you are the attacking player, kneel your faction card to choose a character without attachments, controlled by the losing opponent. Instead of the normal claim effects, kill that character..<br>" +
		"<i>Taking the Black.</i><br>"
	)
	THE_SEASTONE_CHAIR_TtB ("02011"),
	@GraphQLEnumValue(description="" +
		"<h5>Rise of the Kraken</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>War.</i></b><br>" +
		"<b>Interrupt:</b> When you gain power for winning an unopposed challenge, gain 2 power instead..<br>" +
		"<i>Taking the Black.</i><br>"
	)
	RISE_OF_THE_KRAKEN_TtB ("02012"),
	@GraphQLEnumValue(description="" +
		"<h5>Merchant Prince</h5>" +
		"House Targaryen.<br>" +
		"<b><i>Companion.</i></b><br>" +
		"While Merchant Prince has an attachment, he gets +1 STR and gains a [military] icon..<br>" +
		"<i>Taking the Black.</i><br>"
	)
	MERCHANT_PRINCE_TtB ("02013"),
	@GraphQLEnumValue(description="" +
		"<h5>Vaes Dothrak</h5>" +
		"House Targaryen.<br>" +
		"<b><i>Essos.</i></b><br>" +
		"<b>Reaction:</b> After you reveal a plot card, discard an attachment from your hand to choose an attachment with equal or lower printed cost, and discard it from play..<br>" +
		"<i>Taking the Black.</i><br>"
	)
	VAES_DOTHRAK_TtB ("02014"),
	@GraphQLEnumValue(description="" +
		"<h5>Bastard Daughter</h5>" +
		"House Martell.<br>" +
		"<b><i>Bastard. Sand Snake.</i></b><br>" +
		"<b>Interrupt:</b> When Bastard Daughter or The Red Viper is killed, discard 1 card at random from each opponent's hand..<br>" +
		"<i>Taking the Black.</i><br>"
	)
	BASTARD_DAUGHTER_TtB ("02015"),
	@GraphQLEnumValue(description="" +
		"<h5>The Long Plan</h5>" +
		"House Martell.<br>" +
		"<b><i>Scheme.</i></b><br>" +
		"You do not return unspent gold to the treasury during the taxation phase.<b>Reaction:</b> After you lose a challenge, gain 1 gold..<br>" +
		"<i>Taking the Black.</i><br>"
	)
	THE_LONG_PLAN_TtB ("02016"),
	@GraphQLEnumValue(description="" +
		"<h5>Support of the People</h5>" +
		"Neutral.<br>" +
		"<b>Reaction:</b> After you win a [power] challenge by 5 or more STR, search your deck for a location with printed cost 3 or lower, and put it into play. Shuffle your deck. (Max 1 per challenge.).<br>" +
		"<i>Taking the Black.</i><br>"
	)
	SUPPORT_OF_THE_PEOPLE_TtB ("02017"),
	@GraphQLEnumValue(description="" +
		"<h5>Street of the Sisters</h5>" +
		"Neutral.<br>" +
		"<b><i>King's Landing.</i></b><br>" +
		"<b>Reaction:</b> After you win a [power] challenge by 5 or more STR, kneel your faction card to gain 1 power for your faction..<br>" +
		"<i>Taking the Black.</i><br>"
	)
	STREET_OF_THE_SISTERS_TtB ("02018"),
	@GraphQLEnumValue(description="" +
		"<h5>Muster the Realm</h5>" +
		"Neutral.<br>" +
		"<b><i>Edict.</i></b><br>" +
		"During a challenge in which you control an attacking <i>Army</i> character, raise the claim value on Muster the Realm by 1..<br>" +
		"<i>Taking the Black.</i><br>"
	)
	MUSTER_THE_REALM_TtB ("02019"),
	@GraphQLEnumValue(description="" +
		"<h5>Here to Serve</h5>" +
		"Neutral.<br>" +
		"<b><i>Conclave. Kingdom.</i></b><br>" +
		"<b>When Revealed:</b> Search your deck for a <i>Maester</i> character with printed cost 3 or lower, and put it into play. Shuffle your deck..<br>" +
		"<i>Taking the Black.</i><br>"
	)
	HERE_TO_SERVE_TtB ("02020"),
	@GraphQLEnumValue(description="" +
		"<h5>Winterfell Kennel Master</h5>" +
		"House Stark.<br>" +
		"<b><i>Ally.</i></b><br>" +
		"<b>Challenges Action:</b> If you control a participating [stark] character, kneel a <i>Direwolf</i> character or a character with a <i>Direwolf</i> attachment to have it participate in the current challenge on your side. (Limit once per phase.).<br>" +
		"<i>The Road to Winterfell.</i><br>"
	)
	WINTERFELL_KENNEL_MASTER_TRtW ("02021"),
	@GraphQLEnumValue(description="" +
		"<h5>Winterfell Castle</h5>" +
		"House Stark.<br>" +
		"<b><i>Stronghold. Winterfell.</i></b><br>" +
		"During a [military] or [power] challenge in which you control 2 or more unique participating [stark] characters, each of those characters gets +2 STR..<br>" +
		"<i>The Road to Winterfell.</i><br>"
	)
	WINTERFELL_CASTLE_TRtW ("02022"),
	@GraphQLEnumValue(description="" +
		"<h5>Lady-in-Waiting</h5>" +
		"House Tyrell.<br>" +
		"<b><i>Companion.</i></b><br>" +
		"Lady-in-Waiting may be marshaled as a duplicate <em>(at no cost)</em> on a <i>Lady</i> character you own and control..<br>" +
		"<i>The Road to Winterfell.</i><br>"
	)
	LADY_IN_WAITING_TRtW ("02023"),
	@GraphQLEnumValue(description="" +
		"<h5>Lady Sansa's Rose</h5>" +
		"House Tyrell.<br>" +
		"<b>Reaction:</b> After you win a challenge in which you control a <i>Knight</i> character that is attacking or defending alone, that character gains 1 power. (3 power instead if you control a <i>Lady</i> character.) (Max 1 per challenge.).<br>" +
		"<i>The Road to Winterfell.</i><br>"
	)
	LADY_SANSAS_ROSE_TRtW ("02024"),
	@GraphQLEnumValue(description="" +
		"<h5>Unsworn Apprentice</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Companion.</i></b><br>" +
		"No attachments except <i>Weapon</i>.<b>Challenges Action:</b> Unsworn Apprentice gains a challenge icon of your choice until the end of the phase. (Limit once per phase.).<br>" +
		"<i>The Road to Winterfell.</i><br>"
	)
	UNSWORN_APPRENTICE_TRtW ("02025"),
	@GraphQLEnumValue(description="" +
		"<h5>Brandon's Gift</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>The North.</i></b><br>" +
		"<b>Reaction:</b> After you marshal a <i>Builder</i> character, reduce the cost of the next [thenightswatch] card you marshal this phase by 1. (Limit 3 times per phase.).<br>" +
		"<i>The Road to Winterfell.</i><br>"
	)
	BRANDONS_GIFT_TRtW ("02026"),
	@GraphQLEnumValue(description="" +
		"<h5>Royal Entourage</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Ally.</i></b><br>" +
		"<b>Forced Reaction:</b> After you lose an [intrigue] challenge, kneel Royal Entourage..<br>" +
		"<i>The Road to Winterfell.</i><br>"
	)
	ROYAL_ENTOURAGE_TRtW ("02027"),
	@GraphQLEnumValue(description="" +
		"<h5>In the Name of Your King!</h5>" +
		"House Baratheon.<br>" +
		"Play only during a [military] challenge in which you are the defending player.<b>Action:</b> Kneel your faction card to end this challenge with no winner or loser. Until the end of the phase, you cannot initiate [military] challenges..<br>" +
		"<i>The Road to Winterfell.</i><br>"
	)
	IN_THE_NAME_OF_YOUR_KING_TRtW ("02028"),
	@GraphQLEnumValue(description="" +
		"<h5>Brothel Madame</h5>" +
		"House Lannister.<br>" +
		"<b><i>Companion.</i></b><br>" +
		"<b>Reaction:</b> After the challenges phase begins, choose a player. That player may give you 1 gold from his or her gold pool. Until the end of the phase, if that player has not given you gold this phase, he or she cannot initiate [military] challenges against you..<br>" +
		"<i>The Road to Winterfell.</i><br>"
	)
	BROTHEL_MADAME_TRtW ("02029"),
	@GraphQLEnumValue(description="" +
		"<h5>Wardens of the West</h5>" +
		"House Lannister.<br>" +
		"<b><i>Scheme.</i></b><br>" +
		"<b>Reaction:</b> After you win an [intrigue] challenge, pay 2 gold to have the losing opponent choose and discard 2 cards from his or her hand..<br>" +
		"<i>The Road to Winterfell.</i><br>"
	)
	WARDENS_OF_THE_WEST_TRtW ("02030"),
	@GraphQLEnumValue(description="" +
		"<h5>The Reader</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>House Harlaw. Lord.</i></b><br>" +
		"<b>Reaction:</b> After you win an unopposed challenge in which a unique [greyjoy] character is participating, either: draw 1 card, or discard the top 3 cards from each opponent's deck. (Limit once per phase.).<br>" +
		"<i>The Road to Winterfell.</i><br>"
	)
	THE_READER_TRtW ("02031"),
	@GraphQLEnumValue(description="" +
		"<h5>Raiding Longship</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Warship.</i></b><br>" +
		"<b>Challenges Action:</b> If you are the first player, kneel Raiding Longship to choose a defending character without attachments. That character does not contribute its STR to this challenge..<br>" +
		"<i>The Road to Winterfell.</i><br>"
	)
	RAIDING_LONGSHIP_TRtW ("02032"),
	@GraphQLEnumValue(description="" +
		"<h5>Rakharo</h5>" +
		"House Targaryen.<br>" +
		"<b><i>Bloodrider. Dothraki.</i></b><br>" +
		"While you control another <i>Bloodrider</i> character, Rakharo gains intimidate.<b>Reaction:</b> After a character is killed to satisfy claim during a challenge you initiated, Rakharo gains 1 power..<br>" +
		"<i>The Road to Winterfell.</i><br>"
	)
	RAKHARO_TRtW ("02033"),
	@GraphQLEnumValue(description="" +
		"<h5>Crown of Gold</h5>" +
		"House Targaryen.<br>" +
		"<b><i>Item.</i></b><br>" +
		"Terminal.Attached character gains the <i>King</i> trait.Attached character gets -4 STR and is killed if its STR is 0..<br>" +
		"<i>The Road to Winterfell.</i><br>"
	)
	CROWN_OF_GOLD_TRtW ("02034"),
	@GraphQLEnumValue(description="" +
		"<h5>Nymeria Sand (TRtW)</h5>" +
		"House Martell.<br>" +
		"<b><i>Bastard. Sand Snake.</i></b><br>" +
		"<b>Challenges Action:</b> Choose an opponent's character. Until the end of the phase, that character loses a challenge icon of your choice, and each <i>Sand Snake</i> character you control gains that challenge icon. (Limit once per phase.).<br>" +
		"<i>The Road to Winterfell.</i><br>"
	)
	NYMERIA_SAND_TRtW ("02035"),
	@GraphQLEnumValue(description="" +
		"<h5>In Doran's Name</h5>" +
		"House Martell.<br>" +
		"<b>Action:</b> Kneel your faction card to gain X gold. X is the number of plot cards in your used pile..<br>" +
		"<i>The Road to Winterfell.</i><br>"
	)
	IN_DORANS_NAME_TRtW ("02036"),
	@GraphQLEnumValue(description="" +
		"<h5>Syrio Forel</h5>" +
		"Neutral.<br>" +
		"<b><i>Companion.</i></b><br>" +
		"Stealth.<b>Challenges Action:</b> Choose a character. Until the end of the phase, that character gains a [military] icon and stealth. (Limit once per phase.).<br>" +
		"<i>The Road to Winterfell.</i><br>"
	)
	SYRIO_FOREL_TRtW ("02037"),
	@GraphQLEnumValue(description="" +
		"<h5>Shadowblack Lane</h5>" +
		"Neutral.<br>" +
		"<b><i>King's Landing.</i></b><br>" +
		"<b>Reaction:</b> After you win an [intrigue] challenge, kneel your faction card to search the top 10 cards of your deck for an in-faction event, reveal it, and add it to your hand. Shuffle your deck..<br>" +
		"<i>The Road to Winterfell.</i><br>"
	)
	SHADOWBLACK_LANE_TRtW ("02038"),
	@GraphQLEnumValue(description="" +
		"<h5>Trading with the Pentoshi</h5>" +
		"Neutral.<br>" +
		"<b><i>Kingdom.</i></b><br>" +
		"<b>When Revealed:</b> Each opponent gains 3 gold. (Cannot be canceled.).<br>" +
		"<i>The Road to Winterfell.</i><br>"
	)
	TRADING_WITH_THE_PENTOSHI_TRtW ("02039"),
	@GraphQLEnumValue(description="" +
		"<h5>Political Disaster</h5>" +
		"Neutral.<br>" +
		"<b><i>Edict.</i></b><br>" +
		"<b>When Revealed:</b> Each player chooses up to 2 locations he or she controls. Each location not chosen is discarded from play..<br>" +
		"<i>The Road to Winterfell.</i><br>"
	)
	POLITICAL_DISASTER_TRtW ("02040"),
	@GraphQLEnumValue(description="" +
		"<h5>Ser Rodrik Cassel</h5>" +
		"House Stark.<br>" +
		"<b><i>Knight.</i></b><br>" +
		"No attachments except <i>Weapon</i>.While Ser Rodrik Cassel is attacking in a [military] challenge, each unique [stark] character you control gains insight..<br>" +
		"<i>The King's Peace.</i><br>"
	)
	SER_RODRIK_CASSEL_TKP ("02041"),
	@GraphQLEnumValue(description="" +
		"<h5>Wolf Dreams</h5>" +
		"House Stark.<br>" +
		"<b><i>Dream.</i></b><br>" +
		"<b>Action:</b> Kneel your faction card to search your deck for a <i>Direwolf</i> card, reveal it, and add it to your hand. Shuffle your deck..<br>" +
		"<i>The King's Peace.</i><br>"
	)
	WOLF_DREAMS_TKP ("02042"),
	@GraphQLEnumValue(description="" +
		"<h5>Ser Hobber Redwyne</h5>" +
		"House Tyrell.<br>" +
		"<b><i>House Redwyne. Knight.</i></b><br>" +
		"<b>Reaction:</b> After you marshal Ser Hobber Redwyne, search your deck for a <i>Lady</i> character, reveal it, and add it to your hand. Shuffle your deck..<br>" +
		"<i>The King's Peace.</i><br>"
	)
	SER_HOBBER_REDWYNE_TKP ("02043"),
	@GraphQLEnumValue(description="" +
		"<h5>Mare in Heat</h5>" +
		"House Tyrell.<br>" +
		"<b><i>Warhorse.</i></b><br>" +
		"<i>Knight</i> character only.While attached character is attacking or defending alone, Mare in Heat gains: \"<b>Action:</b> Kneel Mare in Heat to choose a participating character with STR higher than that of attached character, and remove that character from the challenge.\".<br>" +
		"<i>The King's Peace.</i><br>"
	)
	MARE_IN_HEAT_TKP ("02044"),
	@GraphQLEnumValue(description="" +
		"<h5>Ser Alliser Thorne</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Knight. Ranger.</i></b><br>" +
		"While you are the defending player, each [thenightswatch] character you control gains a [military] icon.<b>Reaction:</b> After a [military] challenge is initiated against you, kneel your faction card and pay 4 gold to put Ser Alliser Thorne into play from your hand..<br>" +
		"<i>The King's Peace.</i><br>"
	)
	SER_ALLISER_THORNE_TKP ("02045"),
	@GraphQLEnumValue(description="" +
		"<h5>Practice Blade</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Weapon.</i></b><br>" +
		"[thenightswatch] character only. Ambush (2).Attached character gets +1 STR and gains a [military] icon..<br>" +
		"<i>The King's Peace.</i><br>"
	)
	PRACTICE_BLADE_TKP ("02046"),
	@GraphQLEnumValue(description="" +
		"<h5>Moon Boy</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Fool.</i></b><br>" +
		"Insight.<b>Forced Reaction:</b> After you lose a challenge in which Moon Boy is participating, discard 1 card at random from your hand..<br>" +
		"<i>The King's Peace.</i><br>"
	)
	MOON_BOY_TKP ("02047"),
	@GraphQLEnumValue(description="" +
		"<h5>The King's Peace</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Edict. Scheme.</i></b><br>" +
		"<b>Reaction:</b> After a [military] or [power] challenge is initiated against you, the attacking player may either: kneel his or her faction card, or move 1 power from that faction card to yours. If that player does not, the challenge immediately ends with no winner or loser..<br>" +
		"<i>The King's Peace.</i><br>"
	)
	THE_KINGS_PEACE_TKP ("02048"),
	@GraphQLEnumValue(description="" +
		"<h5>Ser Gregor Clegane (TKP)</h5>" +
		"House Lannister.<br>" +
		"<b><i>House Clegane. Knight. Lord.</i></b><br>" +
		"Pillage. Renown.<b>Reaction:</b> After Ser Gregor Clegane discards a character using pillage, place that card in its owner's dead pile. Then, you may choose and kill a character with printed cost equal to that card's printed cost..<br>" +
		"<i>The King's Peace.</i><br>"
	)
	SER_GREGOR_CLEGANE_TKP ("02049"),
	@GraphQLEnumValue(description="" +
		"<h5>I Never Bet Against My Family</h5>" +
		"House Lannister.<br>" +
		"<b>Challenges Action:</b> Kneel your faction card to reveal the bottom 5 cards of your deck. You may put 1 unique [lannister] character revealed by this effect into play; return the other cards to the bottom of your deck in any order. At the end of the phase, if that card is still in play, discard it from play (cannot be saved)..<br>" +
		"<i>The King's Peace.</i><br>"
	)
	I_NEVER_BET_AGAINST_MY_FAMILY_TKP ("02050"),
	@GraphQLEnumValue(description="" +
		"<h5>Newly-Made Lord</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Lord.</i></b><br>" +
		"<b>Reaction:</b> After you marshal Newly-Made Lord, choose a non-limited location with printed cost 3 or lower, and discard it from play..<br>" +
		"<i>The King's Peace.</i><br>"
	)
	NEWLY_MADE_LORD_TKP ("02051"),
	@GraphQLEnumValue(description="" +
		"<h5>Fishing Net</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Condition. Item. Weapon.</i></b><br>" +
		"Opponent's character only.Attached character cannot be declared as a defender..<br>" +
		"<i>The King's Peace.</i><br>"
	)
	FISHING_NET_TKP ("02052"),
	@GraphQLEnumValue(description="" +
		"<h5>Crone of Vaes Dothrak</h5>" +
		"House Targaryen.<br>" +
		"<b><i>Dothraki.</i></b><br>" +
		"<b>Reaction:</b> After a character is discarded from an opponent's hand or deck, kneel a <i>Dothraki</i> character to place that card in its owner's dead pile..<br>" +
		"<i>The King's Peace.</i><br>"
	)
	CRONE_OF_VAES_DOTHRAK_TKP ("02053"),
	@GraphQLEnumValue(description="" +
		"<h5>The Silver Steed</h5>" +
		"House Targaryen.<br>" +
		"<b><i>Warhorse.</i></b><br>" +
		"<i>Dothraki</i> character or Daenerys Targaryen only.While attached character is participating in a [power] challenge, it gains renown.<b>Reaction:</b> After attached character gains power using renown, sacrifice The Silver Steed. You may initiate an additional [power] challenge this phase..<br>" +
		"<i>The King's Peace.</i><br>"
	)
	THE_SILVER_STEED_TKP ("02054"),
	@GraphQLEnumValue(description="" +
		"<h5>Attainted</h5>" +
		"House Martell.<br>" +
		"<b><i>Condition.</i></b><br>" +
		"Opponent's character only.Attached character loses an [intrigue] icon..<br>" +
		"<i>The King's Peace.</i><br>"
	)
	ATTAINTED_TKP ("02055"),
	@GraphQLEnumValue(description="" +
		"<h5>The Boneway</h5>" +
		"House Martell.<br>" +
		"<b><i>Dorne.</i></b><br>" +
		"<b>Reaction:</b> After you lose a challenge, place 1 vengeance token on The Boneway.<b>Dominance Action:</b> Kneel The Boneway and discard 6 vengeance tokens from it to gain 3 power for your faction..<br>" +
		"<i>The King's Peace.</i><br>"
	)
	THE_BONEWAY_TKP ("02056"),
	@GraphQLEnumValue(description="" +
		"<h5>Hedge Knight</h5>" +
		"Neutral.<br>" +
		"<b><i>Knight.</i></b><br>" +
		"While you control another <i>Knight</i> character, Hedge Knight gets +1 STR and gains a [power] icon..<br>" +
		"<i>The King's Peace.</i><br>"
	)
	HEDGE_KNIGHT_TKP ("02057"),
	@GraphQLEnumValue(description="" +
		"<h5>Knighted</h5>" +
		"Neutral.<br>" +
		"<b><i>Title.</i></b><br>" +
		"Attached character gets +1 STR and gains the <i>Knight</i> trait..<br>" +
		"<i>The King's Peace.</i><br>"
	)
	KNIGHTED_TKP ("02058"),
	@GraphQLEnumValue(description="" +
		"<h5>A Tourney for the King</h5>" +
		"Neutral.<br>" +
		"<b><i>Summer.</i></b><br>" +
		"Each<i> Knight</i> character you control gains renown and \"immune to opponents' events.\".<br>" +
		"<i>The King's Peace.</i><br>"
	)
	A_TOURNEY_FOR_THE_KING_TKP ("02059"),
	@GraphQLEnumValue(description="" +
		"<h5>The Lord of the Crossing</h5>" +
		"Neutral.<br>" +
		"<b><i>House Frey.</i></b><br>" +
		"During the first challenge you initiate each phase, each of your participating characters gets -1 STR.During the third challenge you initiate each phase, each of your participating characters gets +2 STR. If you win this challenge, gain 1 power for your faction..<br>" +
		"<i>The King's Peace.</i><br>"
	)
	THE_LORD_OF_THE_CROSSING_TKP ("02060"),
	@GraphQLEnumValue(description="" +
		"<h5>Hodor</h5>" +
		"House Stark.<br>" +
		"<b><i>Companion.</i></b><br>" +
		"No attachments.Hodor cannot be declared as an attacker unless you control Bran Stark.Hodor does not contribute his STR to your total for dominance..<br>" +
		"<i>No Middle Ground.</i><br>"
	)
	HODOR_NMG ("02061"),
	@GraphQLEnumValue(description="" +
		"<h5>Wardens of the North</h5>" +
		"House Stark.<br>" +
		"<b><i>War.</i></b><br>" +
		"<b>Challenges Action:</b> During a challenge in which you control a participating [stark] character, kneel another [stark] character to have it participate in that challenge on your side. (Limit twice per round.).<br>" +
		"<i>No Middle Ground.</i><br>"
	)
	WARDENS_OF_THE_NORTH_NMG ("02062"),
	@GraphQLEnumValue(description="" +
		"<h5>Ser Horas Redwyne</h5>" +
		"House Tyrell.<br>" +
		"<b><i>House Redwyne. Knight.</i></b><br>" +
		"<b>Reaction:</b> After Ser Horas Redwyne is knelt, choose and stand a <i>Lady</i> character..<br>" +
		"<i>No Middle Ground.</i><br>"
	)
	SER_HORAS_REDWYNE_NMG ("02063"),
	@GraphQLEnumValue(description="" +
		"<h5>The Arbor</h5>" +
		"House Tyrell.<br>" +
		"<b><i>House Redwyne.</i></b><br>" +
		"Limited.+3 Income..<br>" +
		"<i>No Middle Ground.</i><br>"
	)
	THE_ARBOR_NMG ("02064"),
	@GraphQLEnumValue(description="" +
		"<h5>Halder</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Builder.</i></b><br>" +
		"No attachments except <i>Weapon</i>.<b>Action:</b> Kneel a [thenightswatch] location or attachment to choose a [thenightswatch] character. Until the end of the phase, that character gets +1 STR..<br>" +
		"<i>No Middle Ground.</i><br>"
	)
	HALDER_NMG ("02065"),
	@GraphQLEnumValue(description="" +
		"<h5>The Watcher on the Walls</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Ranger.</i></b><br>" +
		"Play only during a [military] challenge.<b>Challenges Action:</b> Kneel 2 <i>Ranger</i> characters to kill each attacking character..<br>" +
		"<i>No Middle Ground.</i><br>"
	)
	THE_WATCHER_ON_THE_WALLS_NMG ("02066"),
	@GraphQLEnumValue(description="" +
		"<h5>For the Watch!</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Siege.</i></b><br>" +
		"You cannot lose <em>(and your opponent cannot win)</em> the first challenge initiated against you each phase..<br>" +
		"<i>No Middle Ground.</i><br>"
	)
	FOR_THE_WATCH_NMG ("02067"),
	@GraphQLEnumValue(description="" +
		"<h5>Gendry</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Bastard.</i></b><br>" +
		"<b>Reaction:</b> After you win dominance, Gendry gains 1 power.<b>Forced Reaction:</b> After an opponent wins dominance, you may discard 1 power from Gendry. If you do not, sacrifice a <i>Bastard</i> character..<br>" +
		"<i>No Middle Ground.</i><br>"
	)
	GENDRY_NMG ("02068"),
	@GraphQLEnumValue(description="" +
		"<h5>Tobho Mott's Armory</h5>" +
		"House Baratheon.<br>" +
		"<b><i>King's Landing.</i></b><br>" +
		"<b>Reaction:</b> After you win dominance, kneel Tobho Mott's Armory to draw 1 card..<br>" +
		"<i>No Middle Ground.</i><br>"
	)
	TOBHO_MOTTS_ARMORY_NMG ("02069"),
	@GraphQLEnumValue(description="" +
		"<h5>Red Cloaks</h5>" +
		"House Lannister.<br>" +
		"<b><i>Army. Mercenary.</i></b><br>" +
		"During [intrigue] challenges, Red Cloaks gets +1 STR for each gold on it.<b>Action:</b> Move 1 gold from your gold pool to Red Cloaks. (Limit once per phase.).<br>" +
		"<i>No Middle Ground.</i><br>"
	)
	RED_CLOAKS_NMG ("02070"),
	@GraphQLEnumValue(description="" +
		"<h5>Paid Off</h5>" +
		"House Lannister.<br>" +
		"<b><i>Condition.</i></b><br>" +
		"Opponent's character only. Ambush (1). <b>Reaction:</b> After you win an [intrigue] challenge, kneel attached character. Then, that character's controller may give you 1 gold from his or her gold pool to stand that character..<br>" +
		"<i>No Middle Ground.</i><br>"
	)
	PAID_OFF_NMG ("02071"),
	@GraphQLEnumValue(description="" +
		"<h5>Priest of the Drowned God</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Drowned God.</i></b><br>" +
		"Each <i>Drowned God</i> character you control gets +1 STR..<br>" +
		"<i>No Middle Ground.</i><br>"
	)
	PRIEST_OF_THE_DROWNED_GOD_NMG ("02072"),
	@GraphQLEnumValue(description="" +
		"<h5>Loot</h5>" +
		"House Greyjoy.<br>" +
		"You may only use gold from the losing opponent's gold pool to pay for Loot.<b>Reaction:</b> After you win an unopposed challenge, discard the top X cards from the losing opponent's deck..<br>" +
		"<i>No Middle Ground.</i><br>"
	)
	LOOT_NMG ("02073"),
	@GraphQLEnumValue(description="" +
		"<h5>Dothraki Outriders</h5>" +
		"House Targaryen.<br>" +
		"<b><i>Army. Dothraki.</i></b><br>" +
		"No attachments. Pillage.Reduce the cost to marshal Dothraki Outriders by 1 for each <i>Dothraki</i> character you control..<br>" +
		"<i>No Middle Ground.</i><br>"
	)
	DOTHRAKI_OUTRIDERS_NMG ("02074"),
	@GraphQLEnumValue(description="" +
		"<h5>Blood of the Dragon</h5>" +
		"House Targaryen.<br>" +
		"<b><i>Legacy.</i></b><br>" +
		"Each non-<i>Dragon</i> character gets -1 STR and is killed if its STR is 0..<br>" +
		"<i>No Middle Ground.</i><br>"
	)
	BLOOD_OF_THE_DRAGON_NMG ("02075"),
	@GraphQLEnumValue(description="" +
		"<h5>Maester of Starfall</h5>" +
		"House Martell.<br>" +
		"<b><i>House Dayne. Maester.</i></b><br>" +
		"<b>Challenges Action:</b> Kneel Maester of Starfall to choose a character. Until the end of the phase, that character loses (choose one): insight, intimidate, pillage, or renown..<br>" +
		"<i>No Middle Ground.</i><br>"
	)
	MAESTER_OF_STARFALL_NMG ("02076"),
	@GraphQLEnumValue(description="" +
		"<h5>Condemned</h5>" +
		"House Martell.<br>" +
		"<b><i>Condition.</i></b><br>" +
		"Opponent's character only.Attached character loses a [power] icon..<br>" +
		"<i>No Middle Ground.</i><br>"
	)
	CONDEMNED_NMG ("02077"),
	@GraphQLEnumValue(description="" +
		"<h5>Wildling Scout</h5>" +
		"Neutral.<br>" +
		"<b><i>Wildling.</i></b><br>" +
		"<b>Action:</b> Sacrifice Wildling Scout to choose a character. Until the end of the phase, that character gains stealth..<br>" +
		"<i>No Middle Ground.</i><br>"
	)
	WILDLING_SCOUT_NMG ("02078"),
	@GraphQLEnumValue(description="" +
		"<h5>The First Snow of Winter</h5>" +
		"Neutral.<br>" +
		"<b><i>Omen. Winter.</i></b><br>" +
		"<b>Forced Reaction:</b> After the challenges phase begins, return each character with printed cost 3 or lower to its owner's hand..<br>" +
		"<i>No Middle Ground.</i><br>"
	)
	THE_FIRST_SNOW_OF_WINTER_NMG ("02079"),
	@GraphQLEnumValue(description="" +
		"<h5>Wraiths in Their Midst</h5>" +
		"Neutral.<br>" +
		"<b><i>Winter.</i></b><br>" +
		"Reduce the reserve value on each opponent's revealed plot card by 2 (to a minimum of 2)..<br>" +
		"<i>No Middle Ground.</i><br>"
	)
	WRAITHS_IN_THEIR_MIDST_NMG ("02080"),
	@GraphQLEnumValue(description="" +
		"<h5>Greatjon's Vanguard</h5>" +
		"House Stark.<br>" +
		"<b><i>Army. House Umber.</i></b><br>" +
		"No attachments.While there are fewer than 3 plots in your used pile, Greatjon's Vanguard gets +2 STR and gains renown..<br>" +
		"<i>Calm over Westeros.</i><br>"
	)
	GREATJONS_VANGUARD_CoW ("02081"),
	@GraphQLEnumValue(description="" +
		"<h5>Winterfell Crypt</h5>" +
		"House Stark.<br>" +
		"<b><i>Winterfell.</i></b><br>" +
		"<b>Reaction:</b> After a unique [stark] character you control is killed or sacrificed during the challenges phase, sacrifice Winterfell Crypt to choose a character with equal or lower printed STR. At the end of the phase, if that character is still in play, shuffle it back into its owner's deck..<br>" +
		"<i>Calm over Westeros.</i><br>"
	)
	WINTERFELL_CRYPT_CoW ("02082"),
	@GraphQLEnumValue(description="" +
		"<h5>Roseroad Patrol</h5>" +
		"House Tyrell.<br>" +
		"<b><i>Army.</i></b><br>" +
		"No attachments.While you control a character with the highest STR in play, Roseroad Patrol gains stealth..<br>" +
		"<i>Calm over Westeros.</i><br>"
	)
	ROSEROAD_PATROL_CoW ("02083"),
	@GraphQLEnumValue(description="" +
		"<h5>Pulling the Strings</h5>" +
		"House Tyrell.<br>" +
		"<b><i>Scheme.</i></b><br>" +
		"<b>When Revealed:</b> Choose an <i>Edict</i>, <i>Kingdom</i>, or <i>Scheme</i> plot card in an opponent's used pile. Initiate the when revealed ability on that card as if you had just revealed it..<br>" +
		"<i>Calm over Westeros.</i><br>"
	)
	PULLING_THE_STRINGS_CoW ("02084"),
	@GraphQLEnumValue(description="" +
		"<h5>Chett</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Steward.</i></b><br>" +
		"No attachments except <i>Weapon</i>.<b>Dominance Action:</b> Kneel a <i>Steward</i> character to return a <i>Direwolf</i> or <i>Raven</i> card from your discard pile to your hand. (Limit once per phase.).<br>" +
		"<i>Calm over Westeros.</i><br>"
	)
	CHETT_CoW ("02085"),
	@GraphQLEnumValue(description="" +
		"<h5>Northern Rookery</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>The North.</i></b><br>" +
		"<b>Reaction:</b> After you marshal Northern Rookery, draw 1 card.+1 Reserve..<br>" +
		"<i>Calm over Westeros.</i><br>"
	)
	NORTHERN_ROOKERY_CoW ("02086"),
	@GraphQLEnumValue(description="" +
		"<h5>Kingswood</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Westeros.</i></b><br>" +
		"During [power] challenges in which you are the defending player, each attacking character gets -1 STR.<b>Forced Reaction:</b> After you lose a [power] challenge, sacrifice Kingswood..<br>" +
		"<i>Calm over Westeros.</i><br>"
	)
	KINGSWOOD_CoW ("02087"),
	@GraphQLEnumValue(description="" +
		"<h5>Stinking Drunk</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Condition.</i></b><br>" +
		"Opponent's character only.<b>Reaction:</b> After attached character stands, sacrifice Stinking Drunk to kneel that character..<br>" +
		"<i>Calm over Westeros.</i><br>"
	)
	STINKING_DRUNK_CoW ("02088"),
	@GraphQLEnumValue(description="" +
		"<h5>Bronn</h5>" +
		"House Lannister.<br>" +
		"<b><i>Mercenary.</i></b><br>" +
		"During a challenge in which you are the defending player, Bronn gains a [military], an [intrigue], and a [power] icon.<b>Marshaling Action:</b> Pay 1 gold to take control of Bronn. (Any player may initiate this ability.).<br>" +
		"<i>Calm over Westeros.</i><br>"
	)
	BRONN_CoW ("02089"),
	@GraphQLEnumValue(description="" +
		"<h5>Trial by Combat</h5>" +
		"House Lannister.<br>" +
		"<b>Interrupt:</b> When claim is applied for an [intrigue] challenge, apply [military] claim instead..<br>" +
		"<i>Calm over Westeros.</i><br>"
	)
	TRIAL_BY_COMBAT_CoW ("02090"),
	@GraphQLEnumValue(description="" +
		"<h5>Raider from Pyke</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Raider.</i></b><br>" +
		"Each<i> Weapon</i> card in your hand gains ambush (X). X is that card's printed cost..<br>" +
		"<i>Calm over Westeros.</i><br>"
	)
	RAIDER_FROM_PYKE_CoW ("02091"),
	@GraphQLEnumValue(description="" +
		"<h5>Iron Mines</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Iron Islands.</i></b><br>" +
		"<b>Interrupt:</b> When a character would be killed, sacrifice Iron Mines to save that character..<br>" +
		"<i>Calm over Westeros.</i><br>"
	)
	IRON_MINES_CoW ("02092"),
	@GraphQLEnumValue(description="" +
		"<h5>Mirri Maz Duur</h5>" +
		"House Targaryen.<br>" +
		"<b><i>Lhazareen. Maegi.</i></b><br>" +
		"<b>Interrupt:</b> When claim is applied for a challenge in which Mirri Maz Duur is attacking alone, choose a character controlled by the losing opponent. Instead of the normal claim effects, kill that character..<br>" +
		"<i>Calm over Westeros.</i><br>"
	)
	MIRRI_MAZ_DUUR_CoW ("02093"),
	@GraphQLEnumValue(description="" +
		"<h5>Blood Magic Ritual</h5>" +
		"House Targaryen.<br>" +
		"<b>Interrupt:</b> When a non-<i>Army</i> character would be killed, save it. Then, attach Blood Magic Ritual to that character as a <i>Condition</i> attachment with the text: \"Terminal. Treat attached character's printed text box as if it were blank (except for <i>Traits</i>).\".<br>" +
		"<i>Calm over Westeros.</i><br>"
	)
	BLOOD_MAGIC_RITUAL_CoW ("02094"),
	@GraphQLEnumValue(description="" +
		"<h5>Knights of the Sun</h5>" +
		"House Martell.<br>" +
		"<b><i>Army. Knight.</i></b><br>" +
		"No attachments except <i>Weapon</i>.While there are 3 or more plot cards in your used pile, Knights of the Sun gains renown..<br>" +
		"<i>Calm over Westeros.</i><br>"
	)
	KNIGHTS_OF_THE_SUN_CoW ("02095"),
	@GraphQLEnumValue(description="" +
		"<h5>Vengeance for Elia</h5>" +
		"House Martell.<br>" +
		"<b>Interrupt:</b> When claim is applied for a challenge in which you are the defending player, choose an opponent. That player must satisfy the normal claim effect instead of you as if he or she were the defending player..<br>" +
		"<i>Calm over Westeros.</i><br>"
	)
	VENGEANCE_FOR_ELIA_CoW ("02096"),
	@GraphQLEnumValue(description="" +
		"<h5>Street of Steel</h5>" +
		"Neutral.<br>" +
		"<b><i>King's Landing.</i></b><br>" +
		"<b>Reaction:</b> After you win a [military] challenge, kneel your faction card to search the top 10 cards of your deck for a <i>Weapon</i> or <i>Item</i> attachment, reveal it, and add it to your hand. Shuffle your deck..<br>" +
		"<i>Calm over Westeros.</i><br>"
	)
	STREET_OF_STEEL_CoW ("02097"),
	@GraphQLEnumValue(description="" +
		"<h5>The Eyrie</h5>" +
		"Neutral.<br>" +
		"<b><i>House Arryn. Stronghold.</i></b><br>" +
		"<b>Reaction:</b> After a phase begins, kneel The Eyrie to choose a character. Until the end of the phase, that character cannot be killed..<br>" +
		"<i>Calm over Westeros.</i><br>"
	)
	THE_EYRIE_CoW ("02098"),
	@GraphQLEnumValue(description="" +
		"<h5>Nightmares</h5>" +
		"Neutral.<br>" +
		"<b><i>Dream.</i></b><br>" +
		"<b>Action: </b>Choose a character or location. Until the end of the phase, treat that card's printed text box as if it were blank (except for <i>Traits</i>)..<br>" +
		"<i>Calm over Westeros.</i><br>"
	)
	NIGHTMARES_CoW ("02099"),
	@GraphQLEnumValue(description="" +
		"<h5>Famine</h5>" +
		"Neutral.<br>" +
		"<b><i>Winter.</i></b><br>" +
		"Increase the cost for each opponent to marshal each of his or her characters by 1..<br>" +
		"<i>Calm over Westeros.</i><br>"
	)
	FAMINE_CoW ("02100"),
	@GraphQLEnumValue(description="" +
		"<h5>Septa Mordane</h5>" +
		"House Stark.<br>" +
		"<b><i>The Seven.</i></b><br>" +
		"While you control:- Sansa Stark, she gets +2 STR and gains renown.- Arya Stark, she gains an [intrigue] icon and \"immune to opponents' plot effects.\".<br>" +
		"<i>True Steel.</i><br>"
	)
	SEPTA_MORDANE_TS ("02101"),
	@GraphQLEnumValue(description="" +
		"<h5>Ward</h5>" +
		"House Stark.<br>" +
		"<b><i>Condition.</i></b><br>" +
		"Character with printed cost 4 or lower only. Terminal.Take control of attached character.Attached character gains the [stark] affiliation..<br>" +
		"<i>True Steel.</i><br>"
	)
	WARD_TS ("02102"),
	@GraphQLEnumValue(description="" +
		"<h5>Butterbumps</h5>" +
		"House Tyrell.<br>" +
		"<b><i>Fool.</i></b><br>" +
		"Insight.<b>Forced Reaction:</b> After you lose a challenge in which Butterbumps is participating, discard 1 card at random from your hand..<br>" +
		"<i>True Steel.</i><br>"
	)
	BUTTERBUMPS_TS ("02103"),
	@GraphQLEnumValue(description="" +
		"<h5>A Gift of Arbor Red</h5>" +
		"House Tyrell.<br>" +
		"<b><i>House Redwyne.</i></b><br>" +
		"<b>Action:</b> Kneel your faction card to have each player reveal the top 4 cards of his or her deck. Choose 1 card revealed by each player, and add it to that player's hand. Shuffle the other cards back into their owners' decks..<br>" +
		"<i>True Steel.</i><br>"
	)
	A_GIFT_OF_ARBOR_RED_TS ("02104"),
	@GraphQLEnumValue(description="" +
		"<h5>Sworn Brother</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Builder.</i></b><br>" +
		"No attachments except <i>Weapon</i>.Reduce the cost of the first location you marshal each round by 1..<br>" +
		"<i>True Steel.</i><br>"
	)
	SWORN_BROTHER_TS ("02105"),
	@GraphQLEnumValue(description="" +
		"<h5>Old Bear's Raven</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Raven. Companion.</i></b><br>" +
		"Attached character gains stealth.If attached character is Old Bear Mormont, he gains an [intrigue] icon..<br>" +
		"<i>True Steel.</i><br>"
	)
	OLD_BEARS_RAVEN_TS ("02106"),
	@GraphQLEnumValue(description="" +
		"<h5>Ser Barristan Selmy (TS)</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Kingsguard. Knight. Small Council.</i></b><br>" +
		"Renown.<b>Interrupt:</b> When a <i>Lord</i> or <i>Lady</i> character you control would be killed, stand Ser Barristan Selmy to save that character..<br>" +
		"<i>True Steel.</i><br>"
	)
	SER_BARRISTAN_SELMY_TS ("02107"),
	@GraphQLEnumValue(description="" +
		"<h5>City Watch</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Army.</i></b><br>" +
		"Ambush (6). No attachments except <i>Weapon</i>.While you have more power on your faction card than an opponent, reduce the cost to ambush City Watch by 2..<br>" +
		"<i>True Steel.</i><br>"
	)
	CITY_WATCH_TS ("02108"),
	@GraphQLEnumValue(description="" +
		"<h5>Ser Ilyn Payne</h5>" +
		"House Lannister.<br>" +
		"<b><i>Knight.</i></b><br>" +
		"<b>Marshaling Action:</b> Kneel Ser Ilyn Payne to choose and kill a character with printed cost 3 or lower..<br>" +
		"<i>True Steel.</i><br>"
	)
	SER_ILYN_PAYNE_TS ("02109"),
	@GraphQLEnumValue(description="" +
		"<h5>Small Council Chamber</h5>" +
		"House Lannister.<br>" +
		"<b><i>King's Landing.</i></b><br>" +
		"Immune to events.<b>Reaction:</b> After you win an [intrigue] challenge, Small Council Chamber gains 1 power..<br>" +
		"<i>True Steel.</i><br>"
	)
	SMALL_COUNCIL_CHAMBER_TS ("02110"),
	@GraphQLEnumValue(description="" +
		"<h5>Dagmer Cleftjaw</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Captain. Ironborn.</i></b><br>" +
		"Renown.<b>Interrupt:</b> When claim is applied for a challenge in which Dagmer Cleftjaw is attacking alone, choose a non-limited location with printed cost 3 or lower controlled by the losing opponent. Instead of the normal claim effects, take control of that location..<br>" +
		"<i>True Steel.</i><br>"
	)
	DAGMER_CLEFTJAW_TS ("02111"),
	@GraphQLEnumValue(description="" +
		"<h5>Drowned God's Blessing</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Blessing.</i></b><br>" +
		"[greyjoy] character only.Attached character gains the <i>Drowned God</i> trait and cannot be chosen as the only target of opponents' events.+1 Initiative..<br>" +
		"<i>True Steel.</i><br>"
	)
	DROWNED_GODS_BLESSING_TS ("02112"),
	@GraphQLEnumValue(description="" +
		"<h5>Jhogo</h5>" +
		"House Targaryen.<br>" +
		"<b><i>Bloodrider. Dothraki.</i></b><br>" +
		"While you control another <i>Bloodrider</i> character, Jhogo gains stealth.While Jhogo is attacking, he gets +X STR, where X is the number of characters in the defending player's dead pile..<br>" +
		"<i>True Steel.</i><br>"
	)
	JHOGO_TS ("02113"),
	@GraphQLEnumValue(description="" +
		"<h5>Funeral Pyre</h5>" +
		"House Targaryen.<br>" +
		"<b>Reaction:</b> After a <i>Lord</i> or <i>Lady</i> character is killed, kneel your faction card to draw 3 cards..<br>" +
		"<i>True Steel.</i><br>"
	)
	FUNERAL_PYRE_TS ("02114"),
	@GraphQLEnumValue(description="" +
		"<h5>Tyene Sand (TS)</h5>" +
		"House Martell.<br>" +
		"<b><i>Bastard. Sand Snake.</i></b><br>" +
		"<b>Reaction:</b> After you win an [intrigue] challenge in which Tyene Sand is participating as an attacker, place a poison token on a character without an [intrigue] icon. At the end of the phase, if that character still has the poison token, remove it and kill that character..<br>" +
		"<i>True Steel.</i><br>"
	)
	TYENE_SAND_TS ("02115"),
	@GraphQLEnumValue(description="" +
		"<h5>Imprisoned</h5>" +
		"House Martell.<br>" +
		"<b><i>Condition.</i></b><br>" +
		"Opponent's character only.Attached character loses a [military] icon..<br>" +
		"<i>True Steel.</i><br>"
	)
	IMPRISONED_TS ("02116"),
	@GraphQLEnumValue(description="" +
		"<h5>Maester's Chain</h5>" +
		"Neutral.<br>" +
		"<b><i>Item.</i></b><br>" +
		"<i>Maester</i> character only.<b>Dominance Action:</b> Kneel Maester's Chain to choose a <i>Condition</i> attachment, and discard it from play..<br>" +
		"<i>True Steel.</i><br>"
	)
	MAESTERS_CHAIN_TS ("02117"),
	@GraphQLEnumValue(description="" +
		"<h5>Street of Silk</h5>" +
		"Neutral.<br>" +
		"<b><i>King's Landing.</i></b><br>" +
		"<b>Reaction:</b> After you win a challenge in which you control a participating <i>Lord</i> or <i>Lady</i> character, kneel your faction card to search the top 5 cards of your deck for an <i>Ally</i> or <i>Companion</i> card, reveal it, and add it to your hand. Shuffle your deck..<br>" +
		"<i>True Steel.</i><br>"
	)
	STREET_OF_SILK_TS ("02118"),
	@GraphQLEnumValue(description="" +
		"<h5>Forgotten Plans</h5>" +
		"Neutral.<br>" +
		"<b><i>Scheme.</i></b><br>" +
		"While it is not the plot phase, treat the text box of each revealed non-<i>Scheme</i> plot card as if it were blank (except for <i>Traits</i>)..<br>" +
		"<i>True Steel.</i><br>"
	)
	FORGOTTEN_PLANS_TS ("02119"),
	@GraphQLEnumValue(description="" +
		"<h5>Close Call</h5>" +
		"Neutral.<br>" +
		"<b><i>Summer.</i></b><br>" +
		"<b>When Revealed:</b> Move a character from your dead pile to your discard pile. Then, if there are no <i>Winter</i> plot cards in play, draw 1 card..<br>" +
		"<i>True Steel.</i><br>"
	)
	CLOSE_CALL_TS ("02120"),
	@GraphQLEnumValue(description="" +
		"<h5>King Robb's Host</h5>" +
		"House Stark.<br>" +
		"<b><i>Army.</i></b><br>" +
		"No attachments.<b>Reaction:</b> After you win a [military] challenge in which King Robb's Host is participating, move 1 power from the losing opponent's faction card to an attacking character. (2 power instead if there is a <i>War</i> plot card revealed.).<br>" +
		"<i>Wolves of the North.</i><br>"
	)
	KING_ROBBS_HOST_WotN ("03001"),
	@GraphQLEnumValue(description="" +
		"<h5>Catelyn Stark (WotN)</h5>" +
		"House Stark.<br>" +
		"<b><i>House Tully. Lady. The Seven.</i></b><br>" +
		"Catelyn Stark gets +1 STR for each power she has.<b>Reaction:</b> After a [stark] character you control is sacrificed or killed, Catelyn Stark gains 1 power. (Limit twice per round.).<br>" +
		"<i>Wolves of the North.</i><br>"
	)
	CATELYN_STARK_WotN ("03002"),
	@GraphQLEnumValue(description="" +
		"<h5>Eddard Stark (WotN)</h5>" +
		"House Stark.<br>" +
		"<b><i>Lord. Small Council.</i></b><br>" +
		"Renown.<b>Reaction: </b>After Eddard Stark gains power using renown, choose another participating character you control. That character gains 1 power..<br>" +
		"<i>Wolves of the North.</i><br>"
	)
	EDDARD_STARK_WotN ("03003"),
	@GraphQLEnumValue(description="" +
		"<h5>The Blackfish</h5>" +
		"House Stark.<br>" +
		"<b><i>House Tully. Knight. Lord.</i></b><br>" +
		"Renown.While The Blackfish has 4 or more power, each <i>House Tully </i>character you control does not kneel when declared as an attacker.<b>Reaction:</b> After you win a [military] challenge as the attacking player, draw 1 card. (Limit once per phase.).<br>" +
		"<i>Wolves of the North.</i><br>"
	)
	THE_BLACKFISH_WotN ("03004"),
	@GraphQLEnumValue(description="" +
		"<h5>Jon Snow (WotN)</h5>" +
		"House Stark.<br>" +
		"<b><i>Bastard.</i></b><br>" +
		"<b>Action:</b> Sacrifice a [stark] character to choose and stand a unique [stark] character. (Limit once per round.).<br>" +
		"<i>Wolves of the North.</i><br>"
	)
	JON_SNOW_WotN ("03005"),
	@GraphQLEnumValue(description="" +
		"<h5>Wolves of the North</h5>" +
		"House Stark.<br>" +
		"<b><i>Direwolf.</i></b><br>" +
		"No attachments. Stealth.<b>Reaction:</b> After Wolves of the North bypasses a character using stealth, that character gets -X STR until the end of the phase. X is the number of <i>Direwolf</i> cards you control..<br>" +
		"<i>Wolves of the North.</i><br>"
	)
	WOLVES_OF_THE_NORTH_WotN ("03006"),
	@GraphQLEnumValue(description="" +
		"<h5>Arya Stark (WotN)</h5>" +
		"House Stark.<br>" +
		"<b><i>Lady.</i></b><br>" +
		"<b>Reaction:</b> After a [stark] character you control is killed, sacrifice Arya Stark to choose and kill a character with STR 3 or lower..<br>" +
		"<i>Wolves of the North.</i><br>"
	)
	ARYA_STARK_WotN ("03007"),
	@GraphQLEnumValue(description="" +
		"<h5>Jory Cassel</h5>" +
		"House Stark.<br>" +
		"<b><i>Guard.</i></b><br>" +
		"<b>Interrupt:</b> When a unique [stark] character you control would be killed, sacrifice Jory Cassel to save it. Then, if there is a <i>Winter</i> plot card revealed, that character gains 1 power..<br>" +
		"<i>Wolves of the North.</i><br>"
	)
	JORY_CASSEL_WotN ("03008"),
	@GraphQLEnumValue(description="" +
		"<h5>Riverrun Minstrel</h5>" +
		"House Stark.<br>" +
		"<b><i>House Tully. Minstrel.</i></b><br>" +
		"<b>Reaction:</b> After Riverrun Minstrel enters play, choose a <i>House Tully</i> character. That character gains 1 power..<br>" +
		"<i>Wolves of the North.</i><br>"
	)
	RIVERRUN_MINSTREL_WotN ("03009"),
	@GraphQLEnumValue(description="" +
		"<h5>Old Nan</h5>" +
		"House Stark.<br>" +
		"<b><i>Storyteller.</i></b><br>" +
		"<b>Interrupt:</b> When a plot card is revealed, kneel Old Nan to have that plot card gain the <i>Summer </i>or <i>Winter</i> trait until the end of the round..<br>" +
		"<i>Wolves of the North.</i><br>"
	)
	OLD_NAN_WotN ("03010"),
	@GraphQLEnumValue(description="" +
		"<h5>Osha</h5>" +
		"House Stark.<br>" +
		"<b><i>Wildling.</i></b><br>" +
		"<b>Challenges Action:</b> Remove Osha from the challenge. Then, stand her. (Limit once per phase.).<br>" +
		"<i>Wolves of the North.</i><br>"
	)
	OSHA_WotN ("03011"),
	@GraphQLEnumValue(description="" +
		"<h5>Bear Island Loyalist</h5>" +
		"House Stark.<br>" +
		"<b><i>House Mormont.</i></b><br>" +
		"While Bear Island Loyalist is participating in a challenge, each other participating [stark] character you control gains \"immune to opponents' events.\".<br>" +
		"<i>Wolves of the North.</i><br>"
	)
	BEAR_ISLAND_LOYALIST_WotN ("03012"),
	@GraphQLEnumValue(description="" +
		"<h5>Sansa Stark (WotN)</h5>" +
		"House Stark.<br>" +
		"<b><i>Lady.</i></b><br>" +
		"Sansa Stark gets -1 STR for each [stark] character in your dead pile.While Sansa Stark's STR is 0, she gains insight..<br>" +
		"<i>Wolves of the North.</i><br>"
	)
	SANSA_STARK_WotN ("03013"),
	@GraphQLEnumValue(description="" +
		"<h5>Shaggydog (WotN)</h5>" +
		"House Stark.<br>" +
		"<b><i>Direwolf.</i></b><br>" +
		"No attachments.While you control Rickon Stark, he gets +2 STR and gains a [military] icon..<br>" +
		"<i>Wolves of the North.</i><br>"
	)
	SHAGGYDOG_WotN ("03014"),
	@GraphQLEnumValue(description="" +
		"<h5>House Tully Septon</h5>" +
		"House Stark.<br>" +
		"<b><i>Ally. House Tully. The Seven.</i></b><br>" +
		"<b>Marshaling Action:</b> Discard 1 power from a character you control to reduce the cost of the next <i>House Tully</i> or <i>The Seven</i> character you marshal this phase by 2. (Limit once per phase.).<br>" +
		"<i>Wolves of the North.</i><br>"
	)
	HOUSE_TULLY_SEPTON_WotN ("03015"),
	@GraphQLEnumValue(description="" +
		"<h5>Rickon Stark</h5>" +
		"House Stark.<br>" +
		"<b><i>Lord.</i></b><br>" +
		"<b>Interrupt:</b> When the effects of a triggered ability with the word \"search\" in it would initiate, sacrifice Rickon Stark to cancel those effects..<br>" +
		"<i>Wolves of the North.</i><br>"
	)
	RICKON_STARK_WotN ("03016"),
	@GraphQLEnumValue(description="" +
		"<h5>Winterfell</h5>" +
		"House Stark.<br>" +
		"<b><i>The North. Winterfell.</i></b><br>" +
		"Each [stark] character you control gets +1 STR.<b>Reaction:</b> After a challenge is initiated, kneel Winterfell. Then, each player with a non-<i>Winter</i> plot card revealed cannot trigger card abilities until the end of the challenge..<br>" +
		"<i>Wolves of the North.</i><br>"
	)
	WINTERFELL_WotN ("03017"),
	@GraphQLEnumValue(description="" +
		"<h5>Winterfell Heart Tree</h5>" +
		"House Stark.<br>" +
		"<b><i>Old Gods. Winterfell.</i></b><br>" +
		"<b>Reaction:</b> After a phase begins, sacrifice Winterfell Heart Tree to choose a [stark] card you control. Until the end of the phase, that card gains \"immune to opponents' plot effects.\".<br>" +
		"<i>Wolves of the North.</i><br>"
	)
	WINTERFELL_HEART_TREE_WotN ("03018"),
	@GraphQLEnumValue(description="" +
		"<h5>Nymeria (WotN)</h5>" +
		"House Stark.<br>" +
		"<b><i>Direwolf.</i></b><br>" +
		"Unique [stark] character only.Attached character gains intimidate.<b>Action:</b> Pay 1 gold to attach Nymeria to a different character. (Limit once per phase.).<br>" +
		"<i>Wolves of the North.</i><br>"
	)
	NYMERIA_WotN ("03019"),
	@GraphQLEnumValue(description="" +
		"<h5>Needle</h5>" +
		"House Stark.<br>" +
		"<b><i>Weapon.</i></b><br>" +
		"[stark] character only.Attached character gets +2 STR.<b>Interrupt:</b> When attached character is sacrificed, sacrifice Needle to return that character to your hand instead of placing it in your discard pile..<br>" +
		"<i>Wolves of the North.</i><br>"
	)
	NEEDLE_WotN ("03020"),
	@GraphQLEnumValue(description="" +
		"<h5>Frozen Solid</h5>" +
		"House Stark.<br>" +
		"<b><i>Condition.</i></b><br>" +
		"Non-limited location with printed cost 3 or lower only. Terminal.Treat attached location's printed text box as if it were blank (except for <i>Traits</i>)..<br>" +
		"<i>Wolves of the North.</i><br>"
	)
	FROZEN_SOLID_WotN ("03021"),
	@GraphQLEnumValue(description="" +
		"<h5>As Hard as Winter</h5>" +
		"House Stark.<br>" +
		"Play only if there is a <i>Winter</i> plot card in your used pile.<b>Reaction:</b> After a [stark] character you control is sacrificed or killed, put a [stark] character with equal or lower printed cost into play from your hand..<br>" +
		"<i>Wolves of the North.</i><br>"
	)
	AS_HARD_AS_WINTER_WotN ("03022"),
	@GraphQLEnumValue(description="" +
		"<h5>The Pack Survives</h5>" +
		"House Stark.<br>" +
		"<b>Interrupt:</b> When the effects of an opponent's event would initiate, sacrifice a <i>Direwolf</i> card or kneel 2 [stark] characters to cancel those effects..<br>" +
		"<i>Wolves of the North.</i><br>"
	)
	THE_PACK_SURVIVES_WotN ("03023"),
	@GraphQLEnumValue(description="" +
		"<h5>Arya's Gift</h5>" +
		"House Stark.<br>" +
		"<b>Action:</b> Move an attachment from a [stark] character you control to another eligible character you control..<br>" +
		"<i>Wolves of the North.</i><br>"
	)
	ARYAS_GIFT_WotN ("03024"),
	@GraphQLEnumValue(description="" +
		"<h5>Motley</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Condition.</i></b><br>" +
		"Opponent's character only.Attached character gains the <i>Fool</i> trait.<b>Reaction:</b> After attached character is declared as an attacker or defender, discard 1 card at random from its controller's hand..<br>" +
		"<i>Wolves of the North.</i><br>"
	)
	MOTLEY_WotN ("03025"),
	@GraphQLEnumValue(description="" +
		"<h5>Even Handed Justice</h5>" +
		"House Baratheon.<br>" +
		"<b>Action:</b> Choose a standing character controlled by each player. Kneel each of those characters..<br>" +
		"<i>Wolves of the North.</i><br>"
	)
	EVEN_HANDED_JUSTICE_WotN ("03026"),
	@GraphQLEnumValue(description="" +
		"<h5>Fishwhiskers</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>House Botley. Ironborn.</i></b><br>" +
		"While Fishwhiskers is attacking, if there are more <i>Winter</i> plot cards than <i>Summer</i> plot cards revealed, each defending character does not contribute its STR to that challenge..<br>" +
		"<i>Wolves of the North.</i><br>"
	)
	FISHWHISKERS_WotN ("03027"),
	@GraphQLEnumValue(description="" +
		"<h5>Ahead of the Tide</h5>" +
		"House Greyjoy.<br>" +
		"<b>Interrupt:</b> When you compare initiative, your revealed plot card gets +3 initiative until the end of the phase. If you win initiative this phase, draw 1 card..<br>" +
		"<i>Wolves of the North.</i><br>"
	)
	AHEAD_OF_THE_TIDE_WotN ("03028"),
	@GraphQLEnumValue(description="" +
		"<h5>Crossroads Sellsword</h5>" +
		"House Lannister.<br>" +
		"<b><i>Mercenary.</i></b><br>" +
		"<b>Interrupt:</b> When Crossroads Sellsword is killed during the challenges phase, gain 2 gold..<br>" +
		"<i>Wolves of the North.</i><br>"
	)
	CROSSROADS_SELLSWORD_WotN ("03029"),
	@GraphQLEnumValue(description="" +
		"<h5>Tower of the Hand (WotN)</h5>" +
		"House Lannister.<br>" +
		"<b><i>King's Landing.</i></b><br>" +
		"<b>Reaction:</b> After you win an [intrigue] challenge, kneel Tower of the Hand and return a participating [lannister] character to your hand to choose a character with lower printed cost controlled by the losing opponent. Return that character to its owner's hand..<br>" +
		"<i>Wolves of the North.</i><br>"
	)
	TOWER_OF_THE_HAND_WotN ("03030"),
	@GraphQLEnumValue(description="" +
		"<h5>Quentyn Martell (WotN)</h5>" +
		"House Martell.<br>" +
		"<b><i>Knight. Lord.</i></b><br>" +
		"While you are not the first player, Quentyn Martell gets +1 STR and gains stealth.<b>Interrupt:</b> When Quentyn Martell is killed, choose and kill a character with a lower STR than his..<br>" +
		"<i>Wolves of the North.</i><br>"
	)
	QUENTYN_MARTELL_WotN ("03031"),
	@GraphQLEnumValue(description="" +
		"<h5>His Viper Eyes</h5>" +
		"House Martell.<br>" +
		"<b>Reaction:</b> After you lose a [military] or [power] challenge as the defending player, look at the winning opponent's hand. Then, choose and discard 1 card from that hand..<br>" +
		"<i>Wolves of the North.</i><br>"
	)
	HIS_VIPER_EYES_WotN ("03032"),
	@GraphQLEnumValue(description="" +
		"<h5>Stonesnake</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Ranger.</i></b><br>" +
		"Stealth.<b>Reaction:</b> After Stonesnake bypasses a character using stealth, choose one of that character's keywords. Stonesnake gains that keyword until the end of the phase..<br>" +
		"<i>Wolves of the North.</i><br>"
	)
	STONESNAKE_WotN ("03033"),
	@GraphQLEnumValue(description="" +
		"<h5>The Shadow Tower</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>The North.</i></b><br>" +
		"<b>Reaction:</b> After you win a challenge as the defending player, kneel The Shadow Tower to choose a character controlled by the losing opponent. That character cannot be declared as an attacker this phase..<br>" +
		"<i>Wolves of the North.</i><br>"
	)
	THE_SHADOW_TOWER_WotN ("03034"),
	@GraphQLEnumValue(description="" +
		"<h5>Aggo</h5>" +
		"House Targaryen.<br>" +
		"<b><i>Bloodrider. Dothraki.</i></b><br>" +
		"<b>Action:</b> If there is a <i>Summer</i> plot card revealed, choose and stand a <i>Bloodrider</i> character. (Limit once per round.).<br>" +
		"<i>Wolves of the North.</i><br>"
	)
	AGGO_WotN ("03035"),
	@GraphQLEnumValue(description="" +
		"<h5>Dragon Sight</h5>" +
		"House Targaryen.<br>" +
		"<b>Action:</b> Each participating non-<i>Dragon</i> character gets -1 STR until the end of the challenge..<br>" +
		"<i>Wolves of the North.</i><br>"
	)
	DRAGON_SIGHT_WotN ("03036"),
	@GraphQLEnumValue(description="" +
		"<h5>House Florent Knight</h5>" +
		"House Tyrell.<br>" +
		"<b><i>House Florent. Knight.</i></b><br>" +
		"<b>Forced Reaction:</b> After House Florent Knight enters play, choose a character with the lowest STR in play, and discard it from play..<br>" +
		"<i>Wolves of the North.</i><br>"
	)
	HOUSE_FLORENT_KNIGHT_WotN ("03037"),
	@GraphQLEnumValue(description="" +
		"<h5>To the Rose Banner!</h5>" +
		"House Tyrell.<br>" +
		"<b>Marshaling Action:</b> Choose a [tyrell] character you control. Gain X gold, where X is that character's STR. Then, sacrifice that character..<br>" +
		"<i>Wolves of the North.</i><br>"
	)
	TO_THE_ROSE_BANNER_WotN ("03038"),
	@GraphQLEnumValue(description="" +
		"<h5>Mance Rayder</h5>" +
		"Neutral.<br>" +
		"<b><i>King. Wildling.</i></b><br>" +
		"Renown.Each <i>Wildling</i> character in your hand gains ambush (X). X is that card's printed cost.While there is a <i>Winter</i> plot card revealed, reduce the cost to ambush each of your <i>Wildling</i> characters by 1..<br>" +
		"<i>Wolves of the North.</i><br>"
	)
	MANCE_RAYDER_WotN ("03039"),
	@GraphQLEnumValue(description="" +
		"<h5>Young Spearwife</h5>" +
		"Neutral.<br>" +
		"<b><i>Wildling.</i></b><br>" +
		"While you have less power on your faction card than an opponent, Young Spearwife gains stealth..<br>" +
		"<i>Wolves of the North.</i><br>"
	)
	YOUNG_SPEARWIFE_WotN ("03040"),
	@GraphQLEnumValue(description="" +
		"<h5>House Maester</h5>" +
		"Neutral.<br>" +
		"<b><i>Maester.</i></b><br>" +
		".<br>" +
		"<i>Wolves of the North.</i><br>"
	)
	HOUSE_MAESTER_WotN ("03041"),
	@GraphQLEnumValue(description="" +
		"<h5>Tourney Grounds</h5>" +
		"Neutral.<br>" +
		"<b><i>Contested. Westeros.</i></b><br>" +
		"<b>Action:</b> Kneel Tourney Grounds to reduce the cost of the next event you play this phase by 1..<br>" +
		"<i>Wolves of the North.</i><br>"
	)
	TOURNEY_GROUNDS_WotN ("03042"),
	@GraphQLEnumValue(description="" +
		"<h5>Green Dreams</h5>" +
		"Neutral.<br>" +
		"<b><i>Dream.</i></b><br>" +
		"Terminal.<b>Reaction:</b> After attached character is knelt, look at the top card of your deck. You may put that card on the bottom of your deck..<br>" +
		"<i>Wolves of the North.</i><br>"
	)
	GREEN_DREAMS_WotN ("03043"),
	@GraphQLEnumValue(description="" +
		"<h5>Healing Expertise</h5>" +
		"Neutral.<br>" +
		"<b><i>Citadel.</i></b><br>" +
		"<b>Interrupt:</b> When a non-<i>Army </i>character you control would be killed, kneel a <i>Maester</i> character to save it..<br>" +
		"<i>Wolves of the North.</i><br>"
	)
	HEALING_EXPERTISE_WotN ("03044"),
	@GraphQLEnumValue(description="" +
		"<h5>Tithe</h5>" +
		"Neutral.<br>" +
		"<b>Action:</b> Kneel a neutral character to gain 2 gold..<br>" +
		"<i>Wolves of the North.</i><br>"
	)
	TITHE_WotN ("03045"),
	@GraphQLEnumValue(description="" +
		"<h5>A Time For Wolves</h5>" +
		"House Stark.<br>" +
		"<b><i>Winter.</i></b><br>" +
		"<b>When Revealed:</b> Search your deck for a <i>Direwolf</i> card, reveal it, and add it to your hand. If that card's printed cost is 3 or lower, you may put it into play instead. Shuffle your deck..<br>" +
		"<i>Wolves of the North.</i><br>"
	)
	A_TIME_FOR_WOLVES_WotN ("03046"),
	@GraphQLEnumValue(description="" +
		"<h5>Fallen from Favor</h5>" +
		"Neutral.<br>" +
		"<b><i>Edict.</i></b><br>" +
		"<b>When Revealed:</b> Sacrifice a character you control..<br>" +
		"<i>Wolves of the North.</i><br>"
	)
	FALLEN_FROM_FAVOR_WotN ("03047"),
	@GraphQLEnumValue(description="" +
		"<h5>Snowed Under</h5>" +
		"Neutral.<br>" +
		"<b><i>Winter.</i></b><br>" +
		"Treat the base initiative value on each revealed plot card as if it were 0..<br>" +
		"<i>Wolves of the North.</i><br>"
	)
	SNOWED_UNDER_WotN ("03048"),
	@GraphQLEnumValue(description="" +
		"<h5>The Long Winter</h5>" +
		"Neutral.<br>" +
		"<b><i>Winter.</i></b><br>" +
		"<b>When Revealed:</b> Each player without a <i>Summer</i> plot revealed discards 1 power from a card he or she controls..<br>" +
		"<i>Wolves of the North.</i><br>"
	)
	THE_LONG_WINTER_WotN ("03049"),
	@GraphQLEnumValue(description="" +
		"<h5>A Song of Summer</h5>" +
		"Neutral.<br>" +
		"<b><i>Summer.</i></b><br>" +
		"While there are no <i>Winter</i> plot cards revealed, each character you control gets +1 STR..<br>" +
		"<i>Wolves of the North.</i><br>"
	)
	A_SONG_OF_SUMMER_WotN ("03050"),
	@GraphQLEnumValue(description="" +
		"<h5>Weapons at the Door</h5>" +
		"Neutral.<br>" +
		"<b><i>Edict.</i></b><br>" +
		"<b>Forced Reaction:</b> After the challenges phase begins, return each card with the printed attachment cardtype to its owner's hand..<br>" +
		"<i>Wolves of the North.</i><br>"
	)
	WEAPONS_AT_THE_DOOR_WotN ("03051"),
	@GraphQLEnumValue(description="" +
		"<h5>Ranger's Cache</h5>" +
		"Neutral.<br>" +
		"<b><i>Kingdom. Winter.</i></b><br>" +
		"<b>Interrupt:</b> When the taxation phase ends, either: draw 2 cards or gain 3 gold..<br>" +
		"<i>Wolves of the North.</i><br>"
	)
	RANGERS_CACHE_WotN ("03052"),
	@GraphQLEnumValue(description="" +
		"<h5>The Dragon's Tail</h5>" +
		"Neutral.<br>" +
		"<b><i>Omen.</i></b><br>" +
		"<b>Action:</b> Choose an opponent. You and that player each draw 2 cards..<br>" +
		"<i>Across the Seven Kingdoms.</i><br>"
	)
	THE_DRAGONS_TAIL_AtSK ("04001"),
	@GraphQLEnumValue(description="" +
		"<h5>Robb Stark (AtSK)</h5>" +
		"House Stark.<br>" +
		"<b><i>King. Lord.</i></b><br>" +
		"Renown.During [military] challenges, Robb Stark gets +1 STR for each loyal character you control.<b>Action:</b> While Robb Stark is participating in a [military] challenge, choose a participating non-<i>King</i> character. Stand and remove that character from the challenge. (Limit once per challenge.).<br>" +
		"<i>Across the Seven Kingdoms.</i><br>"
	)
	ROBB_STARK_AtSK ("04002"),
	@GraphQLEnumValue(description="" +
		"<h5>Riverrun</h5>" +
		"House Stark.<br>" +
		"<b><i>House Tully. The Riverlands.</i></b><br>" +
		"<b>Reaction:</b> After power is gained by or moved to a <i>House Tully</i> character, kneel Riverrun to have that character gain 1 power..<br>" +
		"<i>Across the Seven Kingdoms.</i><br>"
	)
	RIVERRUN_AtSK ("04003"),
	@GraphQLEnumValue(description="" +
		"<h5>Ser Colen of Greenpools</h5>" +
		"House Tyrell.<br>" +
		"<b><i>Knight.</i></b><br>" +
		"During [power] challenges, Ser Colen of Greenpools gets +3 STR..<br>" +
		"<i>Across the Seven Kingdoms.</i><br>"
	)
	SER_COLEN_OF_GREENPOOLS_AtSK ("04004"),
	@GraphQLEnumValue(description="" +
		"<h5>Bitterbridge Encampment</h5>" +
		"House Tyrell.<br>" +
		"<b><i>The Reach.</i></b><br>" +
		"<b>Reaction:</b> After a <i>Summer</i> plot card is revealed, kneel Bitterbridge Encampment. Then, each player may put a character into play from his or her hand..<br>" +
		"<i>Across the Seven Kingdoms.</i><br>"
	)
	BITTERBRIDGE_ENCAMPMENT_AtSK ("04005"),
	@GraphQLEnumValue(description="" +
		"<h5>Arry</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Recruit.</i></b><br>" +
		"Ambush (4).If you control Arya Stark, sacrifice Arry.<b>Action:</b> Return Arry to your hand to draw 1 card..<br>" +
		"<i>Across the Seven Kingdoms.</i><br>"
	)
	ARRY_AtSK ("04006"),
	@GraphQLEnumValue(description="" +
		"<h5>White Tree</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Contested. The North.</i></b><br>" +
		"<b>Reaction:</b> After an opponent collects income, kneel White Tree to move 1 gold from that player's gold pool to your own..<br>" +
		"<i>Across the Seven Kingdoms.</i><br>"
	)
	WHITE_TREE_AtSK ("04007"),
	@GraphQLEnumValue(description="" +
		"<h5>White Raven</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Raven.</i></b><br>" +
		"<b>Forced Reaction:</b> After you lose a [power] challenge, sacrifice White Raven.<b>Reaction:</b> After you win dominance, if there is a <i>Summer</i> or <i>Winter</i> plot card revealed, gain 1 power for your faction..<br>" +
		"<i>Across the Seven Kingdoms.</i><br>"
	)
	WHITE_RAVEN_AtSK ("04008"),
	@GraphQLEnumValue(description="" +
		"<h5>Ruby of R'hllor</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Item. R'hllor.</i></b><br>" +
		"<i>R'hllor</i> character only.<b>Reaction:</b> After you win an [intrigue] challenge in which attached character is attacking, name a card. The losing opponent reveals his or her hand and discards each card with that name..<br>" +
		"<i>Across the Seven Kingdoms.</i><br>"
	)
	RUBY_OF_RHLLOR_AtSK ("04009"),
	@GraphQLEnumValue(description="" +
		"<h5>Janos Slynt (AtSK)</h5>" +
		"House Lannister.<br>" +
		"<b><i>Mercenary.</i></b><br>" +
		"Intimidate.<b>Action:</b> Pay 1 gold to give Janos Slynt +2 STR until the end of the phase..<br>" +
		"<i>Across the Seven Kingdoms.</i><br>"
	)
	JANOS_SLYNT_AtSK ("04010"),
	@GraphQLEnumValue(description="" +
		"<h5>Levies at the Rock</h5>" +
		"House Lannister.<br>" +
		"<b>Reaction:</b> After a player initiates a challenge against you, move up to X gold from that player's gold pool to your own. X is the number of attacking characters..<br>" +
		"<i>Across the Seven Kingdoms.</i><br>"
	)
	LEVIES_AT_THE_ROCK_AtSK ("04011"),
	@GraphQLEnumValue(description="" +
		"<h5>Captain's Daughter</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Ally.</i></b><br>" +
		"<b>Reaction:</b> After a non-loyal character enters play, kneel your faction card and sacrifice Captain's Daughter to put that character onto the top of it's owner's deck..<br>" +
		"<i>Across the Seven Kingdoms.</i><br>"
	)
	CAPTAINS_DAUGHTER_AtSK ("04012"),
	@GraphQLEnumValue(description="" +
		"<h5>Pyke</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Iron Islands.</i></b><br>" +
		"<b>Action:</b> Kneel Pyke to choose a character. Until the end of the phase, that character gains stealth..<br>" +
		"<i>Across the Seven Kingdoms.</i><br>"
	)
	PYKE_AtSK ("04013"),
	@GraphQLEnumValue(description="" +
		"<h5>Viserys Targaryen (AtSK)</h5>" +
		"House Targaryen.<br>" +
		"<b><i>King. Lord.</i></b><br>" +
		"While Viserys Targaryen is attacking, each <i>King</i> character must be declared as a defender, if able.<b>Interrupt:</b> When the dominance phase ends, if no opponent controls a <i>King</i> character, Viserys Targaryen gains 1 power..<br>" +
		"<i>Across the Seven Kingdoms.</i><br>"
	)
	VISERYS_TARGARYEN_AtSK ("04014"),
	@GraphQLEnumValue(description="" +
		"<h5>Shierak Qiya</h5>" +
		"House Targaryen.<br>" +
		"<b><i>Omen.</i></b><br>" +
		"<b>Reaction:</b> After you win a [power] challenge by 5 or more STR, kneel your faction card to choose and stand a participating character..<br>" +
		"<i>Across the Seven Kingdoms.</i><br>"
	)
	SHIERAK_QIYA_AtSK ("04015"),
	@GraphQLEnumValue(description="" +
		"<h5>Harmen Uller</h5>" +
		"House Martell.<br>" +
		"<b><i>House Uller. Lord.</i></b><br>" +
		"Renown.Each <i>Sand Snake</i> character in your hand gains ambush (X). X is 1 less than that card's printed cost..<br>" +
		"<i>Across the Seven Kingdoms.</i><br>"
	)
	HARMEN_ULLER_AtSK ("04016"),
	@GraphQLEnumValue(description="" +
		"<h5>Tower of the Sun</h5>" +
		"House Martell.<br>" +
		"<b><i>Dorne.</i></b><br>" +
		"<b>Reaction:</b> After an event is played, gain 1 gold. (Limit once per phase.).<br>" +
		"<i>Across the Seven Kingdoms.</i><br>"
	)
	TOWER_OF_THE_SUN_AtSK ("04017"),
	@GraphQLEnumValue(description="" +
		"<h5>Pyromancers</h5>" +
		"Neutral.<br>" +
		"<b><i>Ally.</i></b><br>" +
		"<b>Dominance Action:</b> Kneel Pyromancers and discard 1 power from your faction card to choose a non-limited location, and discard it from play..<br>" +
		"<i>Across the Seven Kingdoms.</i><br>"
	)
	PYROMANCERS_AtSK ("04018"),
	@GraphQLEnumValue(description="" +
		"<h5>Rains of Autumn</h5>" +
		"Neutral.<br>" +
		"<b><i>Omen.</i></b><br>" +
		"Characters and locations do not provide positive gold modifiers..<br>" +
		"<i>Across the Seven Kingdoms.</i><br>"
	)
	RAINS_OF_AUTUMN_AtSK ("04019"),
	@GraphQLEnumValue(description="" +
		"<h5>Varys's Riddle</h5>" +
		"Neutral.<br>" +
		"<b><i>Riddle. Scheme.</i></b><br>" +
		"<b>When Revealed:</b> Initiate the when revealed ability on a revealed non-<i>Riddle</i> plot card as if you had just revealed it..<br>" +
		"<i>Across the Seven Kingdoms.</i><br>"
	)
	VARYSS_RIDDLE_AtSK ("04020"),
	@GraphQLEnumValue(description="" +
		"<h5>Donella Hornwood</h5>" +
		"House Stark.<br>" +
		"<b><i>House Hornwood. Lady.</i></b><br>" +
		"Reduce the cost of the first loyal card you marshal or play each round by 1..<br>" +
		"<i>Called to Arms.</i><br>"
	)
	DONELLA_HORNWOOD_CtA ("04021"),
	@GraphQLEnumValue(description="" +
		"<h5>Fear Cuts Deeper Than Swords</h5>" +
		"House Stark.<br>" +
		"<b>Interrupt:</b> When the effects of an ability that chooses a [stark] character you control as its only target would initiate, cancel those effects and stand that character..<br>" +
		"<i>Called to Arms.</i><br>"
	)
	FEAR_CUTS_DEEPER_THAN_SWORDS_CtA ("04022"),
	@GraphQLEnumValue(description="" +
		"<h5>Knight of Summer</h5>" +
		"House Tyrell.<br>" +
		"<b><i>Knight.</i></b><br>" +
		"While there are more <i>Summer</i> plot cards than <i>Winter</i> plot cards revealed, Knight of Summer gets +2 STR and gains renown..<br>" +
		"<i>Called to Arms.</i><br>"
	)
	KNIGHT_OF_SUMMER_CtA ("04023"),
	@GraphQLEnumValue(description="" +
		"<h5>There Is My Claim</h5>" +
		"House Tyrell.<br>" +
		"Play only during a challenge.<b>Challenges Action:</b> Reveal 4 [tyrell] characters from your hand to raise the claim value on your revealed plot card by 1 until the end of the challenge. (Max 1 per challenge.).<br>" +
		"<i>Called to Arms.</i><br>"
	)
	THERE_IS_MY_CLAIM_CtA ("04024"),
	@GraphQLEnumValue(description="" +
		"<h5>Dolorous Edd</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Steward.</i></b><br>" +
		"<b>Action:</b> During an [intrigue] challenge in which you are the defending player, kneel your faction card to put Dolorous Edd into play from your hand knelt, participating as a defender. If you win the challenge, you may return him to your hand..<br>" +
		"<i>Called to Arms.</i><br>"
	)
	DOLOROUS_EDD_CtA ("04025"),
	@GraphQLEnumValue(description="" +
		"<h5>Craven</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Condition.</i></b><br>" +
		"Terminal.Attached character cannot be declared as an attacker..<br>" +
		"<i>Called to Arms.</i><br>"
	)
	CRAVEN_CtA ("04026"),
	@GraphQLEnumValue(description="" +
		"<h5>Maester Pylos</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Maester.</i></b><br>" +
		"Stealth..<br>" +
		"<i>Called to Arms.</i><br>"
	)
	MAESTER_PYLOS_CtA ("04027"),
	@GraphQLEnumValue(description="" +
		"<h5>The Stone Drum</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Dragonstone.</i></b><br>" +
		"While there is a <i>Kingdom</i> plot card revealed, increase the gold value on your revealed plot card by 1..<br>" +
		"<i>Called to Arms.</i><br>"
	)
	THE_STONE_DRUM_CtA ("04028"),
	@GraphQLEnumValue(description="" +
		"<h5>Shae</h5>" +
		"House Lannister.<br>" +
		"<b><i>Ally. Companion.</i></b><br>" +
		"<b>Challenges Action:</b> Pay 1 gold to stand Shae. (Limit twice per phase.).<br>" +
		"<i>Called to Arms.</i><br>"
	)
	SHAE_CtA ("04029"),
	@GraphQLEnumValue(description="" +
		"<h5>The Boy King</h5>" +
		"House Lannister.<br>" +
		"<b><i>Title.</i></b><br>" +
		"<i>Lord</i> character only.Attached character gains the <i>King</i> trait.<b>Reaction:</b> After a character with printed cost 3 or lower is killed, kneel The Boy King to have attached character gain 1 power..<br>" +
		"<i>Called to Arms.</i><br>"
	)
	THE_BOY_KING_CtA ("04030"),
	@GraphQLEnumValue(description="" +
		"<h5>Balon Greyjoy (CtA)</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Ironborn. King. Lord.</i></b><br>" +
		"Renown.Balon Greyjoy does not kneel when declared as an attacker in a [military] challenge against an opponent who does not control a <i>King</i> character.<b>Action:</b> Kneel a [greyjoy] location to give each loyal character you control +1 STR until the end of the challenge. (Limit once per challenge.).<br>" +
		"<i>Called to Arms.</i><br>"
	)
	BALON_GREYJOY_CtA ("04031"),
	@GraphQLEnumValue(description="" +
		"<h5>Ours is the Old Way</h5>" +
		"House Greyjoy.<br>" +
		"<b>Challenges Action:</b> Until the end of the phase, either: each [greyjoy] character you control gains stealth, or each non-[greyjoy] character loses stealth..<br>" +
		"<i>Called to Arms.</i><br>"
	)
	OURS_IS_THE_OLD_WAY_CtA ("04032"),
	@GraphQLEnumValue(description="" +
		"<h5>Doreah</h5>" +
		"House Targaryen.<br>" +
		"<b><i>Companion.</i></b><br>" +
		"During a challenge in which you control a participating <i>Lord</i> or <i>Lady</i> character, Doreah gains insight..<br>" +
		"<i>Called to Arms.</i><br>"
	)
	DOREAH_CtA ("04033"),
	@GraphQLEnumValue(description="" +
		"<h5>Beggar King</h5>" +
		"House Targaryen.<br>" +
		"<b><i>Title.</i></b><br>" +
		"[targaryen] character only.Attached character gains the <i>King</i> trait.<b>Reaction:</b> After an opponent reveals a plot card with a higher printed gold value than yours, kneel Beggar King to gain 1 gold. (2 gold instead if no opponent controls a <i>King</i> character.).<br>" +
		"<i>Called to Arms.</i><br>"
	)
	BEGGAR_KING_CtA ("04034"),
	@GraphQLEnumValue(description="" +
		"<h5>Starfall Cavalry</h5>" +
		"House Martell.<br>" +
		"<b><i>Army. House Dayne.</i></b><br>" +
		"No attachments except <i>Weapon</i>.<b>Reaction:</b> After Starfall Cavalry enters play, draw 1 card. (3 cards instead if there are 3 or more plot cards in your used pile.).<br>" +
		"<i>Called to Arms.</i><br>"
	)
	STARFALL_CAVALRY_CtA ("04035"),
	@GraphQLEnumValue(description="" +
		"<h5>Venomous Blade</h5>" +
		"House Martell.<br>" +
		"<b><i>Weapon.</i></b><br>" +
		"[martell] character you control only. Ambush (3).Attached character gets +1 STR.<b>Reaction:</b> After Venomous Blade enters play, place a poison token on a character with printed STR 2 or lower. At the end of the phase, if that character still has that poison token, remove it and kill that character..<br>" +
		"<i>Called to Arms.</i><br>"
	)
	VENOMOUS_BLADE_CtA ("04036"),
	@GraphQLEnumValue(description="" +
		"<h5>Kings of Summer</h5>" +
		"Neutral.<br>" +
		"<b><i>Summer.</i></b><br>" +
		"You cannot include <i>Winter</i> plot cards in your plot deck.Increase the reserve value on each player's revealed plot card by 1. While there are no <i>Winter</i> plot cards revealed, increase the gold value on your revealed <i>Summer</i> plot card by 1..<br>" +
		"<i>Called to Arms.</i><br>"
	)
	KINGS_OF_SUMMER_CtA ("04037"),
	@GraphQLEnumValue(description="" +
		"<h5>Kings of Winter</h5>" +
		"Neutral.<br>" +
		"<b><i>Winter.</i></b><br>" +
		"You cannot include <i>Summer</i> plot cards in your plot deck.Reduce the reserve value on each player's revealed plot card by 1. While you have a <i>Winter</i> plot card revealed, reduce the gold value on each opponent's non-<i>Summer</i> plot card by 1..<br>" +
		"<i>Called to Arms.</i><br>"
	)
	KINGS_OF_WINTER_CtA ("04038"),
	@GraphQLEnumValue(description="" +
		"<h5>Summer Harvest</h5>" +
		"Neutral.<br>" +
		"<b><i>Summer.</i></b><br>" +
		"<b>When Revealed:</b> Choose an opponent. X is 2 higher than the printed gold value on that player's revealed plot card..<br>" +
		"<i>Called to Arms.</i><br>"
	)
	SUMMER_HARVEST_CtA ("04039"),
	@GraphQLEnumValue(description="" +
		"<h5>Winter Festival</h5>" +
		"Neutral.<br>" +
		"<b><i>Winter.</i></b><br>" +
		"<b>Interrupt:</b> When the challenges phase ends, if there are no <i>Summer</i> plot cards revealed, gain 2 power for your faction..<br>" +
		"<i>Called to Arms.</i><br>"
	)
	WINTER_FESTIVAL_CtA ("04040"),
	@GraphQLEnumValue(description="" +
		"<h5>Ser Edmure Tully</h5>" +
		"House Stark.<br>" +
		"<b><i>House Tully. Knight.</i></b><br>" +
		"<b>Reaction:</b> After a character gains power, move 1 power from that character to a <i>House Tully</i> character. (Limit once per round.).<br>" +
		"<i>For Family Honor.</i><br>"
	)
	SER_EDMURE_TULLY_FFH ("04041"),
	@GraphQLEnumValue(description="" +
		"<h5>Bear Island</h5>" +
		"House Stark.<br>" +
		"<b><i>The North.</i></b><br>" +
		"<b>Reaction:</b> After you marshal a loyal card, gain 1 gold. (Limit twice per phase.).<br>" +
		"<i>For Family Honor.</i><br>"
	)
	BEAR_ISLAND_FFH ("04042"),
	@GraphQLEnumValue(description="" +
		"<h5>Renly Baratheon (FFH)</h5>" +
		"House Tyrell.<br>" +
		"<b><i>King. Lord.</i></b><br>" +
		"Insight. Renown.While an opponent controls a <i>King</i> character, Renly Baratheon cannot be saved.<b>Reaction:</b> After you draw a loyal card using insight, reveal it to draw 1 card..<br>" +
		"<i>For Family Honor.</i><br>"
	)
	RENLY_BARATHEON_FFH ("04043"),
	@GraphQLEnumValue(description="" +
		"<h5>Crown of Golden Roses</h5>" +
		"House Tyrell.<br>" +
		"<b><i>Crown. Item.</i></b><br>" +
		"<i>Lord</i> character only.Attached character gains the <i>King</i> trait.<b>Action:</b> Discard 1 card from your hand to give attached character +X STR until the end of the phase. X is the number of challenge icons attached character has. (Limit twice per round.).<br>" +
		"<i>For Family Honor.</i><br>"
	)
	CROWN_OF_GOLDEN_ROSES_FFH ("04044"),
	@GraphQLEnumValue(description="" +
		"<h5>Thoren Smallwood</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Ranger.</i></b><br>" +
		"No attachments except <i>Weapon</i>.<b>Reaction:</b> After you win a challenge as the defending player, gain 1 power for your faction..<br>" +
		"<i>For Family Honor.</i><br>"
	)
	THOREN_SMALLWOOD_FFH ("04045"),
	@GraphQLEnumValue(description="" +
		"<h5>Night Gathers...</h5>" +
		"The Night's Watch.<br>" +
		"<b>Marshaling Action:</b> Choose an opponent whose reserve value is lower than yours. Until the end of the phase, you may marshal characters from that player's discard pile as if they were in your hand..<br>" +
		"<i>For Family Honor.</i><br>"
	)
	NIGHT_GATHERS_FFH ("04046"),
	@GraphQLEnumValue(description="" +
		"<h5>Asshai Priestess</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Ally. R'hllor.</i></b><br>" +
		"<b>Reaction:</b> After you marshal Asshai Priestess, choose and kneel a character with STR 2 or lower..<br>" +
		"<i>For Family Honor.</i><br>"
	)
	ASSHAI_PRIESTESS_FFH ("04047"),
	@GraphQLEnumValue(description="" +
		"<h5>Visited by Shadows</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Condition.</i></b><br>" +
		"Opponent's character only.Attached character gets -1 STR..<br>" +
		"<i>For Family Honor.</i><br>"
	)
	VISITED_BY_SHADOWS_FFH ("04048"),
	@GraphQLEnumValue(description="" +
		"<h5>Ser Amory Lorch</h5>" +
		"House Lannister.<br>" +
		"<b><i>Knight.</i></b><br>" +
		"While an opponent controls 3 or fewer characters, Ser Amory Lorch gains renown..<br>" +
		"<i>For Family Honor.</i><br>"
	)
	SER_AMORY_LORCH_FFH ("04049"),
	@GraphQLEnumValue(description="" +
		"<h5>Harrenhal (FFH)</h5>" +
		"House Lannister.<br>" +
		"<b><i>Contested. Stronghold.</i></b><br>" +
		"<b>Challenges Action:</b> Kneel Harrenhal to put a [lannister] or <i>House Bolton</i> character into play from your hand. At the end of the phase, if that character is still in play, kill it (cannot be saved)..<br>" +
		"<i>For Family Honor.</i><br>"
	)
	HARRENHAL_FFH ("04050"),
	@GraphQLEnumValue(description="" +
		"<h5>Lordsport Fisherman</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Ally. Merchant.</i></b><br>" +
		"<b>Reaction:</b> After you marshal Lordsport Fisherman, add the bottom card of your deck to your hand..<br>" +
		"<i>For Family Honor.</i><br>"
	)
	LORDSPORT_FISHERMAN_FFH ("04051"),
	@GraphQLEnumValue(description="" +
		"<h5>King of Salt and Rock</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Title.</i></b><br>" +
		"<i>Ironborn</i> character only.Attached character gains the <i>King</i> trait and pillage.<b>Reaction:</b> After an attachment or location is discarded using pillage, attached character gains 1 power..<br>" +
		"<i>For Family Honor.</i><br>"
	)
	KING_OF_SALT_AND_ROCK_FFH ("04052"),
	@GraphQLEnumValue(description="" +
		"<h5>Devoted Bloodrider</h5>" +
		"House Targaryen.<br>" +
		"<b><i>Bloodrider. Dothraki.</i></b><br>" +
		"Each <i>Bloodrider</i> character you control gets +1 STR..<br>" +
		"<i>For Family Honor.</i><br>"
	)
	DEVOTED_BLOODRIDER_FFH ("04053"),
	@GraphQLEnumValue(description="" +
		"<h5>Blood of My Blood</h5>" +
		"House Targaryen.<br>" +
		"<b>Challenges Action:</b> Search your deck for a <i>Bloodrider</i> character and put it into play. Shuffle your deck. At the end of the phase, if that card is still in play, return it to your hand..<br>" +
		"<i>For Family Honor.</i><br>"
	)
	BLOOD_OF_MY_BLOOD_FFH ("04054"),
	@GraphQLEnumValue(description="" +
		"<h5>Spearmaiden</h5>" +
		"House Martell.<br>" +
		"<b><i>Ally.</i></b><br>" +
		"<b>Reaction:</b> After Spearmaiden is declared as an attacker in a [military] challenge, choose a character controlled by the defending player. If you win the challenge by 5 or more STR, that character must be chosen for claim during this challenge, if able..<br>" +
		"<i>For Family Honor.</i><br>"
	)
	SPEARMAIDEN_FFH ("04055"),
	@GraphQLEnumValue(description="" +
		"<h5>The Scorpion's Sting</h5>" +
		"House Martell.<br>" +
		"<b>Reaction:</b> After you lose a challenge, choose up to X [martell] characters. Each of those characters gains renown until the end of the phase. X is the number of plot cards in your used pile..<br>" +
		"<i>For Family Honor.</i><br>"
	)
	THE_SCORPIONS_STING_FFH ("04056"),
	@GraphQLEnumValue(description="" +
		"<h5>Hot Pie</h5>" +
		"Neutral.<br>" +
		"<b><i>Companion.</i></b><br>" +
		"<b>Marshaling Action:</b> Kneel a <i>Companion</i> character to reduce the cost of the next unique character you marshal this phase by 1..<br>" +
		"<i>For Family Honor.</i><br>"
	)
	HOT_PIE_FFH ("04057"),
	@GraphQLEnumValue(description="" +
		"<h5>The God's Eye</h5>" +
		"Neutral.<br>" +
		"<b><i>Westeros.</i></b><br>" +
		"The God's Eye cannot be discarded from play.+1 Income.+1 Reserve..<br>" +
		"<i>For Family Honor.</i><br>"
	)
	THE_GODS_EYE_FFH ("04058"),
	@GraphQLEnumValue(description="" +
		"<h5>Dissension</h5>" +
		"Neutral.<br>" +
		"<b>Marshaling Action:</b> Choose an <i>Ally</i> character, and discard it from play..<br>" +
		"<i>For Family Honor.</i><br>"
	)
	DISSENSION_FFH ("04059"),
	@GraphQLEnumValue(description="" +
		"<h5>Battle of Oxcross</h5>" +
		"Neutral.<br>" +
		"<b><i>War.</i></b><br>" +
		"Each character with printed cost 4 or higher cannot be declared as a defender during the first challenge you initiate this round..<br>" +
		"<i>For Family Honor.</i><br>"
	)
	BATTLE_OF_OXCROSS_FFH ("04060"),
	@GraphQLEnumValue(description="" +
		"<h5>Jojen Reed</h5>" +
		"House Stark.<br>" +
		"<b><i>House Reed.</i></b><br>" +
		"Stealth.<b>Reaction:</b> After Jojen Reed stands, reveal the top card of each player's deck. You may either: discard each of those cards, or have each player draw 1 card..<br>" +
		"<i>There Is My Claim.</i><br>"
	)
	JOJEN_REED_TIMC ("04061"),
	@GraphQLEnumValue(description="" +
		"<h5>The Wolf King</h5>" +
		"House Stark.<br>" +
		"<b><i>Title.</i></b><br>" +
		"[stark] character only.Attached character gains the <i>King</i> trait and does not kneel when declared as an attacker in a [military] challenge..<br>" +
		"<i>There Is My Claim.</i><br>"
	)
	THE_WOLF_KING_TIMC ("04062"),
	@GraphQLEnumValue(description="" +
		"<h5>King Renly's Host</h5>" +
		"House Tyrell.<br>" +
		"<b><i>Army.</i></b><br>" +
		"Intimidate. No attachments.While there is a <i>Summer</i> plot card revealed, King Renly's Host gets +4 STR.While there is a <i>Winter</i> plot card revealed, King Renly's Host cannot be declared as an attacker..<br>" +
		"<i>There Is My Claim.</i><br>"
	)
	KING_RENLYS_HOST_TIMC ("04063"),
	@GraphQLEnumValue(description="" +
		"<h5>Caswell's Keep</h5>" +
		"House Tyrell.<br>" +
		"<b><i>The Reach.</i></b><br>" +
		"<b>Reaction:</b> After you reveal a plot card, choose a player. Look at the top 2 cards of that player's deck. Place 1 of those cards on the bottom of that deck, and the other on top..<br>" +
		"<i>There Is My Claim.</i><br>"
	)
	CASWELLS_KEEP_TIMC ("04064"),
	@GraphQLEnumValue(description="" +
		"<h5>Shadow Tower Mason</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Builder.</i></b><br>" +
		"No attachments except <i>Weapon</i>.While you control 3 or more [thenightswatch] locations and/or attachments, Shadow Tower Mason gains a [military] and an [intrigue] icon..<br>" +
		"<i>There Is My Claim.</i><br>"
	)
	SHADOW_TOWER_MASON_TIMC ("04065"),
	@GraphQLEnumValue(description="" +
		"<h5>The Haunted Forest</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>The North.</i></b><br>" +
		"While The Haunted Forest is standing, it contributes 1 STR to your side during any challenge in which you are the defending player.<b>Forced Reaction:</b> After you lose a challenge, kneel The Haunted Forest..<br>" +
		"<i>There Is My Claim.</i><br>"
	)
	THE_HAUNTED_FOREST_TIMC ("04066"),
	@GraphQLEnumValue(description="" +
		"<h5>Stannis Baratheon (TIMC)</h5>" +
		"House Baratheon.<br>" +
		"<b><i>King. Lord.</i></b><br>" +
		"During [power] challenges, each participating non-<i>King</i> character gets -1 STR.<b>Reaction:</b> After you win dominance, choose a non-loyal character. That character cannot stand during the standing phase this round..<br>" +
		"<i>There Is My Claim.</i><br>"
	)
	STANNIS_BARATHEON_TIMC ("04067"),
	@GraphQLEnumValue(description="" +
		"<h5>Red God's Blessing</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Blessing. R'hllor.</i></b><br>" +
		"Attached character gains the <i>R'hllor</i> trait and gets +1 STR for each <i>R'hllor</i> character you control..<br>" +
		"<i>There Is My Claim.</i><br>"
	)
	RED_GODS_BLESSING_TIMC ("04068"),
	@GraphQLEnumValue(description="" +
		"<h5>Tanda Stokeworth</h5>" +
		"House Lannister.<br>" +
		"<b><i>Lady.</i></b><br>" +
		"<b>Reaction:</b> After you marshal Tanda Stokeworth, each player gains 3 gold..<br>" +
		"<i>There Is My Claim.</i><br>"
	)
	TANDA_STOKEWORTH_TIMC ("04069"),
	@GraphQLEnumValue(description="" +
		"<h5>Without His Beard</h5>" +
		"House Lannister.<br>" +
		"<b>Reaction:</b> After you win an [intrigue] challenge, discard up to 3 cards at random from the losing opponent's hand. Then, that player draws 2 cards..<br>" +
		"<i>There Is My Claim.</i><br>"
	)
	WITHOUT_HIS_BEARD_TIMC ("04070"),
	@GraphQLEnumValue(description="" +
		"<h5>Aeron Damphair (TIMC)</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Drowned God. Ironborn. Lord.</i></b><br>" +
		"<b>Reaction:</b> After a character is saved, either: stand it, or kneel it..<br>" +
		"<i>There Is My Claim.</i><br>"
	)
	AERON_DAMPHAIR_TIMC ("04071"),
	@GraphQLEnumValue(description="" +
		"<h5>King Balon's Solar</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Iron Islands.</i></b><br>" +
		"<b>Reaction:</b> After you win initiative, gain 1 gold..<br>" +
		"<i>There Is My Claim.</i><br>"
	)
	KING_BALONS_SOLAR_TIMC ("04072"),
	@GraphQLEnumValue(description="" +
		"<h5>Pyat Pree</h5>" +
		"House Targaryen.<br>" +
		"<b><i>Warlock.</i></b><br>" +
		"<b>Reaction:</b> After you win a challenge in which Pyat Pree is participating, search the top X cards of your deck for a [targaryen] attachment or event, reveal it, and add it to your hand. Shuffle your deck. X is the STR by which you won the challenge..<br>" +
		"<i>There Is My Claim.</i><br>"
	)
	PYAT_PREE_TIMC ("04073"),
	@GraphQLEnumValue(description="" +
		"<h5>Vaes Tolorro</h5>" +
		"House Targaryen.<br>" +
		"<b><i>Essos.</i></b><br>" +
		"<b>Interrupt:</b> When a character with 1 or more power is killed, kneel Vaes Tolorro to move 1 power from that character to Vaes Tolorro. (Up to 2 power instead if that character's STR is 0.).<br>" +
		"<i>There Is My Claim.</i><br>"
	)
	VAES_TOLORRO_TIMC ("04074"),
	@GraphQLEnumValue(description="" +
		"<h5>Elia Sand</h5>" +
		"House Martell.<br>" +
		"<b><i>Bastard. Sand Snake.</i></b><br>" +
		"<b>Reaction:</b> After you lose a challenge, choose a character. Until the end of the phase, that character gains stealth. (Limit twice per phase.).<br>" +
		"<i>There Is My Claim.</i><br>"
	)
	ELIA_SAND_TIMC ("04075"),
	@GraphQLEnumValue(description="" +
		"<h5>Burning on the Sand</h5>" +
		"House Martell.<br>" +
		"<b>Reaction:</b> After you lose an unopposed challenge, set the claim value on the winning opponent's revealed plot card to 0 until the end of the challenge..<br>" +
		"<i>There Is My Claim.</i><br>"
	)
	BURNING_ON_THE_SAND_TIMC ("04076"),
	@GraphQLEnumValue(description="" +
		"<h5>Jaqen H'ghar</h5>" +
		"Neutral.<br>" +
		"<b><i>Ally.</i></b><br>" +
		"<b>Reaction:</b> After Jaqen H'ghar enters play, place a Valar Morghulis token on up to 3 different unique characters. If Jaqen H'ghar leaves play, discard those tokens from play.<b>Reaction:</b> After you win a challenge in which Jaqen H'ghar is attacking alone, choose and kill a character with a Valar Morghulis token..<br>" +
		"<i>There Is My Claim.</i><br>"
	)
	JAQEN_HGHAR_TIMC ("04077"),
	@GraphQLEnumValue(description="" +
		"<h5>Isle of Ravens</h5>" +
		"Neutral.<br>" +
		"<b><i>Oldtown.</i></b><br>" +
		"<b>Action:</b> Kneel Isle of Ravens to choose a card in any player's discard pile, and shuffle it into its owner's deck..<br>" +
		"<i>There Is My Claim.</i><br>"
	)
	ISLE_OF_RAVENS_TIMC ("04078"),
	@GraphQLEnumValue(description="" +
		"<h5>King Beyond the Wall</h5>" +
		"Neutral.<br>" +
		"<b><i>Title.</i></b><br>" +
		"<i>Wildling</i> character only.Attached character gains the <i>King</i> trait.While attached character is attacking a player with a higher power total than you, raise the claim value on your revealed plot card by 1..<br>" +
		"<i>There Is My Claim.</i><br>"
	)
	KING_BEYOND_THE_WALL_TIMC ("04079"),
	@GraphQLEnumValue(description="" +
		"<h5>Valar Morghulis</h5>" +
		"Neutral.<br>" +
		"<b><i>Omen.</i></b><br>" +
		"<b>When Revealed:</b> Kill each character..<br>" +
		"<i>There Is My Claim.</i><br>"
	)
	VALAR_MORGHULIS_TIMC ("04080"),
	@GraphQLEnumValue(description="" +
		"<h5>Roose Bolton</h5>" +
		"House Stark.<br>" +
		"<b><i>Ally. House Bolton. Lord.</i></b><br>" +
		"<b>Reaction:</b> After you win a challenge in which Roose Bolton is attacking, choose up to X total STR worth of characters controlled by the losing opponent. X is Roose Bolton's STR. Sacrifice Roose Bolton to kill each of those characters..<br>" +
		"<i>Ghosts of Harrenhal.</i><br>"
	)
	ROOSE_BOLTON_GoH ("04081"),
	@GraphQLEnumValue(description="" +
		"<h5>Harrenhal (GoH)</h5>" +
		"House Stark.<br>" +
		"<b><i>Contested. Stronghold.</i></b><br>" +
		"<b>Reaction:</b> After a character enters play, kneel your faction card and sacrifice Harrenhal to kill it..<br>" +
		"<i>Ghosts of Harrenhal.</i><br>"
	)
	HARRENHAL_GoH ("04082"),
	@GraphQLEnumValue(description="" +
		"<h5>Brienne of Tarth (GoH)</h5>" +
		"House Tyrell.<br>" +
		"<b><i>Lady.</i></b><br>" +
		"Renown.While you control a <i>King</i> character or Catelyn Stark, Brienne of Tarth does not kneel when declared as a defender..<br>" +
		"<i>Ghosts of Harrenhal.</i><br>"
	)
	BRIENNE_OF_TARTH_GoH ("04083"),
	@GraphQLEnumValue(description="" +
		"<h5>Offer of a Peach</h5>" +
		"House Tyrell.<br>" +
		"Play only if you control Renly Baratheon or a <i>Lady</i> character.<b>Challenges Action:</b> Choose an attacking character. Stand that character and remove it from the challenge..<br>" +
		"<i>Ghosts of Harrenhal.</i><br>"
	)
	OFFER_OF_A_PEACH_GoH ("04084"),
	@GraphQLEnumValue(description="" +
		"<h5>Craster</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Ally. Wildling.</i></b><br>" +
		"Immune to <i>Omen</i> card effects.<b>Action:</b> Sacrifice Craster to put each character that was killed this phase into play from its owner's dead pile..<br>" +
		"<i>Ghosts of Harrenhal.</i><br>"
	)
	CRASTER_GoH ("04085"),
	@GraphQLEnumValue(description="" +
		"<h5>Dragonglass Dagger</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Weapon.</i></b><br>" +
		"[thenightswatch] character only.While attached character is participating in a challenge, it gets +2 STR and is immune to opponent's character abilities..<br>" +
		"<i>Ghosts of Harrenhal.</i><br>"
	)
	DRAGONGLASS_DAGGER_GoH ("04086"),
	@GraphQLEnumValue(description="" +
		"<h5>Ser Davos Seaworth (GoH)</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Knight. Lord. Smuggler.</i></b><br>" +
		"Stealth.<b>Reaction:</b> After Ser Davos Seaworth bypasses a non-loyal character using stealth, either: draw 1 card, or gain 1 gold..<br>" +
		"<i>Ghosts of Harrenhal.</i><br>"
	)
	SER_DAVOS_SEAWORTH_GoH ("04087"),
	@GraphQLEnumValue(description="" +
		"<h5>Ritual of R'hllor</h5>" +
		"House Baratheon.<br>" +
		"<b><i>R'hllor.</i></b><br>" +
		"<b>Reaction:</b> After you win dominance, choose X standing <i>R'hllor</i> characters. Each of those characters gains 1 power..<br>" +
		"<i>Ghosts of Harrenhal.</i><br>"
	)
	RITUAL_OF_RHLLOR_GoH ("04088"),
	@GraphQLEnumValue(description="" +
		"<h5>Joffrey Baratheon (GoH)</h5>" +
		"House Lannister.<br>" +
		"<b><i>King. Lord.</i></b><br>" +
		"<b>Reaction:</b> After you marshal a loyal character, kneel that character and your faction card to choose and kill a non-<i>King</i> character with a lower printed cost..<br>" +
		"<i>Ghosts of Harrenhal.</i><br>"
	)
	JOFFREY_BARATHEON_GoH ("04089"),
	@GraphQLEnumValue(description="" +
		"<h5>Chataya's Brothel</h5>" +
		"House Lannister.<br>" +
		"<b><i>King's Landing.</i></b><br>" +
		"<b>Marshaling Action:</b> Kneel a character with an [intrigue] icon to gain 1 gold. (Limit twice per phase.).<br>" +
		"<i>Ghosts of Harrenhal.</i><br>"
	)
	CHATAYAS_BROTHEL_GoH ("04090"),
	@GraphQLEnumValue(description="" +
		"<h5>Helya</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Ironborn. Steward.</i></b><br>" +
		"Each attachment gains terminal..<br>" +
		"<i>Ghosts of Harrenhal.</i><br>"
	)
	HELYA_GoH ("04091"),
	@GraphQLEnumValue(description="" +
		"<h5>Bless Him With Salt</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Blessing.</i></b><br>" +
		"Play only during a [power] challenge.<b>Action:</b> Choose a participating <i>Drowned God</i> or <i>Ironborn</i> character. Until the end of the challenge, that character gets +3 STR. If you win the challenge, draw 1 card..<br>" +
		"<i>Ghosts of Harrenhal.</i><br>"
	)
	BLESS_HIM_WITH_SALT_GoH ("04092"),
	@GraphQLEnumValue(description="" +
		"<h5>Xaro Xhoan Daxos</h5>" +
		"House Targaryen.<br>" +
		"<b><i>Merchant.</i></b><br>" +
		"<b>Reaction:</b> After you marshal a unique attachment, gain 2 gold. (Limit once per phase.).<br>" +
		"<i>Ghosts of Harrenhal.</i><br>"
	)
	XARO_XHOAN_DAXOS_GoH ("04093"),
	@GraphQLEnumValue(description="" +
		"<h5>Mother of Dragons</h5>" +
		"House Targaryen.<br>" +
		"<b><i>Title.</i></b><br>" +
		"<i>Stormborn</i> character you control only.<b>Challenges Action:</b> During a challenge in which you control a participating <i>Dragon</i> character, kneel Mother of Dragons to have attached character participate in the challenge on your side..<br>" +
		"<i>Ghosts of Harrenhal.</i><br>"
	)
	MOTHER_OF_DRAGONS_GoH ("04094"),
	@GraphQLEnumValue(description="" +
		"<h5>Myrcella Baratheon (GoH)</h5>" +
		"House Martell.<br>" +
		"<b><i>Lady.</i></b><br>" +
		"While there are no <i>King</i> characters in play, Myrcella Baratheon gains renown and does not kneel when declared as a defender in a [power] challenge..<br>" +
		"<i>Ghosts of Harrenhal.</i><br>"
	)
	MYRCELLA_BARATHEON_GoH ("04095"),
	@GraphQLEnumValue(description="" +
		"<h5>The Prince's Pass</h5>" +
		"House Martell.<br>" +
		"<b><i>Dorne.</i></b><br>" +
		"<b>Reaction:</b> After you lose a challenge as the defending player, kneel The Prince's Pass to choose an attacking character. Until the end of the phase, that character loses a challenge icon of your choice. Then, if it has no challenge icons, you may sacrifice The Prince's Pass to discard it from play..<br>" +
		"<i>Ghosts of Harrenhal.</i><br>"
	)
	THE_PRINCES_PASS_GoH ("04096"),
	@GraphQLEnumValue(description="" +
		"<h5>Silent Sisters</h5>" +
		"Neutral.<br>" +
		"<b><i>Ally. The Seven.</i></b><br>" +
		"Silent Sisters gets +1 STR for each character in your dead pile..<br>" +
		"<i>Ghosts of Harrenhal.</i><br>"
	)
	SILENT_SISTERS_GoH ("04097"),
	@GraphQLEnumValue(description="" +
		"<h5>The Frostfangs</h5>" +
		"Neutral.<br>" +
		"<b><i>The North.</i></b><br>" +
		"<b>Reaction:</b> After The Frostfangs enters play, give control of it to an opponent.-1 Reserve..<br>" +
		"<i>Ghosts of Harrenhal.</i><br>"
	)
	THE_FROSTFANGS_GoH ("04098"),
	@GraphQLEnumValue(description="" +
		"<h5>Quiet as a Shadow</h5>" +
		"Neutral.<br>" +
		"<b>Action:</b> Choose a unique character with printed cost 3 or lower. Until the end of the phase, that character gains stealth..<br>" +
		"<i>Ghosts of Harrenhal.</i><br>"
	)
	QUIET_AS_A_SHADOW_GoH ("04099"),
	@GraphQLEnumValue(description="" +
		"<h5>Ghosts of Harrenhal</h5>" +
		"Neutral.<br>" +
		"<b><i>Omen.</i></b><br>" +
		"<b>When Revealed:</b> Put the top character in each player's dead pile into play..<br>" +
		"<i>Ghosts of Harrenhal.</i><br>"
	)
	GHOSTS_OF_HARRENHAL_GoH ("04100"),
	@GraphQLEnumValue(description="" +
		"<h5>House Manderly Knight</h5>" +
		"House Stark.<br>" +
		"<b><i>House Manderly. Knight.</i></b><br>" +
		"While there is a <i>Winter</i> plot card revealed, House Manderly Knight gets +2 STR..<br>" +
		"<i>Tyrion's Chain.</i><br>"
	)
	HOUSE_MANDERLY_KNIGHT_TC ("04101"),
	@GraphQLEnumValue(description="" +
		"<h5>\"Wolf in the Night\"</h5>" +
		"House Stark.<br>" +
		"<b><i>Song.</i></b><br>" +
		"<b>Action:</b> Choose a [stark] character that is attacking alone. Until the end of the challenge, that character gets +3 STR and gains renown..<br>" +
		"<i>Tyrion's Chain.</i><br>"
	)
	WOLF_IN_THE_NIGHT_TC ("04102"),
	@GraphQLEnumValue(description="" +
		"<h5>Ser Robar Royce</h5>" +
		"House Tyrell.<br>" +
		"<b><i>Knight.</i></b><br>" +
		"<b>Reaction:</b> After a <i>Summer</i> plot card is revealed, Ser Robar Royce gains 1 power. (Limit once per phase).<b>Forced Reaction:</b> After a <i>Winter</i> plot card is revealed, kneel Ser Robar Royce..<br>" +
		"<i>Tyrion's Chain.</i><br>"
	)
	SER_ROBAR_ROYCE_TC ("04103"),
	@GraphQLEnumValue(description="" +
		"<h5>Renly's Pavilion</h5>" +
		"House Tyrell.<br>" +
		"<b><i>Westeros.</i></b><br>" +
		"<b>Action:</b> Kneel Renly's Pavilion to choose 2 characters. Until the end of the phase, one of those characters gets -1 STR, and the other gets +1 STR..<br>" +
		"<i>Tyrion's Chain.</i><br>"
	)
	RENLYS_PAVILION_TC ("04104"),
	@GraphQLEnumValue(description="" +
		"<h5>Qhorin Halfhand</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Ranger.</i></b><br>" +
		"Renown. No attachments except <i>Weapon</i>.<b>Reaction:</b> After you win a [military] challenge in which Qhorin Halfhand is participating, choose and kill a non-unique character with lower STR than his controlled by the losing opponent..<br>" +
		"<i>Tyrion's Chain.</i><br>"
	)
	QHORIN_HALFHAND_TC ("04105"),
	@GraphQLEnumValue(description="" +
		"<h5>Fist of the First Men</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>The North.</i></b><br>" +
		"While your reserve value is higher than an opponent's, each <i>Ranger</i> character you control gets +1 STR and cannot be bypassed by stealth..<br>" +
		"<i>Tyrion's Chain.</i><br>"
	)
	FIST_OF_THE_FIRST_MEN_TC ("04106"),
	@GraphQLEnumValue(description="" +
		"<h5>Salladhor Saan (TC)</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Mercenary. Raider. Smuggler.</i></b><br>" +
		"<b>Reaction:</b> After you win a challenge in which Salladhor Saan is participating, put a <i>Warship</i> location or <i>Weapon</i> attachment into play from your hand..<br>" +
		"<i>Tyrion's Chain.</i><br>"
	)
	SALLADHOR_SAAN_TC ("04107"),
	@GraphQLEnumValue(description="" +
		"<h5>The Valyrian</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Warship.</i></b><br>" +
		"Ambush (2).<b>Action:</b> Kneel The Valyrian to give an attacking character +X STR until the end of the challenge. X is the number of gold in the defending player's gold pool..<br>" +
		"<i>Tyrion's Chain.</i><br>"
	)
	THE_VALYRIAN_TC ("04108"),
	@GraphQLEnumValue(description="" +
		"<h5>Podrick Payne</h5>" +
		"House Lannister.<br>" +
		"<b><i>Companion.</i></b><br>" +
		"<b>Interrupt:</b> When a character would be killed for [military] claim, pay 2 gold and put Podrick Payne into play from your hand to save it. Then, if that character was Tyrion Lannister, you may pay 2 gold to choose and kill an attacking character..<br>" +
		"<i>Tyrion's Chain.</i><br>"
	)
	PODRICK_PAYNE_TC ("04109"),
	@GraphQLEnumValue(description="" +
		"<h5>Tyrion's Chain</h5>" +
		"House Lannister.<br>" +
		"<b>Reaction:</b> After you win a challenge in which you control a participating unique [lannister] character, choose a revealed <i>War</i> plot card. Initiate the when revealed ability on that plot card as if you had just revealed it. (Max 1 per phase.).<br>" +
		"<i>Tyrion's Chain.</i><br>"
	)
	TYRIONS_CHAIN_TC ("04110"),
	@GraphQLEnumValue(description="" +
		"<h5>Esgred</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Ironborn.</i></b><br>" +
		"Stealth.If you control Asha Greyjoy, sacrifice Esgred. Then, your Asha Greyjoy gains 1 power.Esgred may bypass an additional character using stealth.<em>Errata from FAQ v2.1</em>.<br>" +
		"<i>Tyrion's Chain.</i><br>"
	)
	ESGRED_TC ("04111"),
	@GraphQLEnumValue(description="" +
		"<h5>Sea Bitch</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Warship.</i></b><br>" +
		"<b>Action:</b> Sacrifice Sea Bitch to choose a non-limited location. Take control of that location until the end of the phase..<br>" +
		"<i>Tyrion's Chain.</i><br>"
	)
	SEA_BITCH_TC ("04112"),
	@GraphQLEnumValue(description="" +
		"<h5>Quaithe of the Shadow</h5>" +
		"House Targaryen.<br>" +
		"<b><i>Companion.</i></b><br>" +
		"Ambush (3).<b>Reaction:</b> After Quaithe of the Shadow enters play during a challenge, remove each character with STR 2 or lower from the challenge..<br>" +
		"<i>Tyrion's Chain.</i><br>"
	)
	QUAITHE_OF_THE_SHADOW_TC ("04113"),
	@GraphQLEnumValue(description="" +
		"<h5>House of the Undying</h5>" +
		"House Targaryen.<br>" +
		"<b><i>Qarth.</i></b><br>" +
		"<b>Challenges Action:</b> Remove House of the Undying from the game to choose an opponent. Put each character in that player's dead pile into play under your control. At the end of the phase, return each of those cards to its owner's dead pile (cannot be saved)..<br>" +
		"<i>Tyrion's Chain.</i><br>"
	)
	HOUSE_OF_THE_UNDYING_TC ("04114"),
	@GraphQLEnumValue(description="" +
		"<h5>Ser Arys Oakheart</h5>" +
		"House Martell.<br>" +
		"<b><i>Kingsguard. Knight.</i></b><br>" +
		"No attachments except <i>Weapon</i>.<b>Reaction:</b> After Ser Arys Oakheart enters play, pay 2 gold to choose an <i>Ally</i> character, and discard it from play..<br>" +
		"<i>Tyrion's Chain.</i><br>"
	)
	SER_ARYS_OAKHEART_TC ("04115"),
	@GraphQLEnumValue(description="" +
		"<h5>The Greenblood</h5>" +
		"House Martell.<br>" +
		"<b><i>Dorne.</i></b><br>" +
		"Each [martell] character you control gets +1 STR for each <i>Summer</i> plot card revealed..<br>" +
		"<i>Tyrion's Chain.</i><br>"
	)
	THE_GREENBLOOD_TC ("04116"),
	@GraphQLEnumValue(description="" +
		"<h5>Northern Refugee</h5>" +
		"Neutral.<br>" +
		"<b><i>Ally. Wildling.</i></b><br>" +
		"While there is a <i>Winter</i> plot card revealed, reduce the cost to marshal Northern Refugee by 1..<br>" +
		"<i>Tyrion's Chain.</i><br>"
	)
	NORTHERN_REFUGEE_TC ("04117"),
	@GraphQLEnumValue(description="" +
		"<h5>Relentless Assault</h5>" +
		"Neutral.<br>" +
		"<b>Reaction:</b> After you win a challenge by 5 or more STR as the attacking player, kneel your faction card. Then, you may initiate an additional challenge of that type this phase..<br>" +
		"<i>Tyrion's Chain.</i><br>"
	)
	RELENTLESS_ASSAULT_TC ("04118"),
	@GraphQLEnumValue(description="" +
		"<h5>Tarred Heads</h5>" +
		"Neutral.<br>" +
		"<b>Reaction:</b> After you win a [power] challenge, discard 1 card at random from the losing opponent's hand. If that card is a character, place it in its owner's dead pile..<br>" +
		"<i>Tyrion's Chain.</i><br>"
	)
	TARRED_HEADS_TC ("04119"),
	@GraphQLEnumValue(description="" +
		"<h5>Battle of the Blackwater</h5>" +
		"Neutral.<br>" +
		"<b><i>Siege. War.</i></b><br>" +
		"<b>When Revealed:</b> Choose an opponent. Discard each duplicate you control and each duplicate controlled by that opponent from play..<br>" +
		"<i>Tyrion's Chain.</i><br>"
	)
	BATTLE_OF_THE_BLACKWATER_TC ("04120"),
	@GraphQLEnumValue(description="" +
		"<h5>Cersei Lannister (LoCR)</h5>" +
		"House Lannister.<br>" +
		"<b><i>Lady. Queen.</i></b><br>" +
		"Cersei Lannister does not kneel when declared as an attacker in an [intrigue] challenge.<b>Reaction:</b> After 1 or more cards are discarded from an opponent's hand, if you do not support that player, Cersei Lannister gains 1 power. (Limit 3 times per round.).<br>" +
		"<i>Lions of Casterly Rock.</i><br>"
	)
	CERSEI_LANNISTER_LoCR ("05001"),
	@GraphQLEnumValue(description="" +
		"<h5>Tyrion Lannister (LoCR)</h5>" +
		"House Lannister.<br>" +
		"<b><i>Lord.</i></b><br>" +
		"<b>Reaction:</b> After you win a challenge, return an attacking <i>Clansman</i> character to your hand to (choose one): draw 2 cards, gain 3 gold, or raise the claim value on your revealed plot card by 1 until the end of the challenge. (Limit twice per phase.).<br>" +
		"<i>Lions of Casterly Rock.</i><br>"
	)
	TYRION_LANNISTER_LoCR ("05002"),
	@GraphQLEnumValue(description="" +
		"<h5>Ser Kevan Lannister</h5>" +
		"House Lannister.<br>" +
		"<b><i>Knight. Lord. Small Council.</i></b><br>" +
		"<b>Reaction:</b> After you marshal Ser Kevan Lannister, choose a [lannister] or neutral location or attachment in your discard pile and put it into play..<br>" +
		"<i>Lions of Casterly Rock.</i><br>"
	)
	SER_KEVAN_LANNISTER_LoCR ("05003"),
	@GraphQLEnumValue(description="" +
		"<h5>Timett Son of Timett</h5>" +
		"House Lannister.<br>" +
		"<b><i>Clansman.</i></b><br>" +
		"<b>Reaction:</b> After you win a challenge in which Timett Son of Timett is attacking, choose and kill a character with printed cost X or lower. X is the number of <i>Clansman</i> characters you control..<br>" +
		"<i>Lions of Casterly Rock.</i><br>"
	)
	TIMETT_SON_OF_TIMETT_LoCR ("05004"),
	@GraphQLEnumValue(description="" +
		"<h5>Ser Jaime Lannister (LoCR)</h5>" +
		"House Lannister.<br>" +
		"<b><i>Kingsguard. Knight.</i></b><br>" +
		"Each <i>Knight</i> character you control gains renown while attacking alone.<b>Challenges Action:</b> Choose a <i>Kingsguard</i> character. Until the end of the phase, that character gains an [intrigue] icon. (Limit once per phase.).<br>" +
		"<i>Lions of Casterly Rock.</i><br>"
	)
	SER_JAIME_LANNISTER_LoCR ("05005"),
	@GraphQLEnumValue(description="" +
		"<h5>Tywin Lannister (LoCR)</h5>" +
		"House Lannister.<br>" +
		"<b><i>Lord. Small Council.</i></b><br>" +
		"Pillage.<b>Interrupt:</b> When exactly 1 card is discarded from a player's deck, instead look at the top 2 cards of that player's deck and discard 1..<br>" +
		"<i>Lions of Casterly Rock.</i><br>"
	)
	TYWIN_LANNISTER_LoCR ("05006"),
	@GraphQLEnumValue(description="" +
		"<h5>Chella Daughter of Cheyk</h5>" +
		"House Lannister.<br>" +
		"<b><i>Clansman.</i></b><br>" +
		"Chella Daughter of Cheyk gets +1 STR for each ear token she has. While she has 3 or more ear tokens, she gains intimidate and renown.<b>Reaction:</b> After a character is killed during a challenge in which Chella Daughter of Cheyk is attacking, place an ear token on her..<br>" +
		"<i>Lions of Casterly Rock.</i><br>"
	)
	CHELLA_DAUGHTER_OF_CHEYK_LoCR ("05007"),
	@GraphQLEnumValue(description="" +
		"<h5>Ser Gregor's Marauders</h5>" +
		"House Lannister.<br>" +
		"<b><i>House Clegane. Raider.</i></b><br>" +
		"Pillage.<b>Reaction:</b> After Ser Gregor's Marauders discards an event using pillage, stand Ser Gregor's Marauders..<br>" +
		"<i>Lions of Casterly Rock.</i><br>"
	)
	SER_GREGORS_MARAUDERS_LoCR ("05008"),
	@GraphQLEnumValue(description="" +
		"<h5>Shagga Son of Dolf</h5>" +
		"House Lannister.<br>" +
		"<b><i>Clansman.</i></b><br>" +
		"While Shagga Son of Dolf is in your hand, he gains ambush (0) if you control a <i>Clansman</i> character or Tyrion Lannister.<b>Forced Reaction:</b> After Shagga Son of Dolf enters play using ambush, choose and kill a [lannister] character you control..<br>" +
		"<i>Lions of Casterly Rock.</i><br>"
	)
	SHAGGA_SON_OF_DOLF_LoCR ("05009"),
	@GraphQLEnumValue(description="" +
		"<h5>Taena Merryweather</h5>" +
		"House Lannister.<br>" +
		"<b><i>Companion. Lady.</i></b><br>" +
		"<b>Reaction:</b> After you play an event, choose and discard 1 card from your hand to draw 1 card..<br>" +
		"<i>Lions of Casterly Rock.</i><br>"
	)
	TAENA_MERRYWEATHER_LoCR ("05010"),
	@GraphQLEnumValue(description="" +
		"<h5>Moon Brothers</h5>" +
		"House Lannister.<br>" +
		"<b><i>Clansman.</i></b><br>" +
		"<b>Action:</b> During a challenge in which you control an attacking <i>Clansman</i> character, kneel your faction card to put Moon Brothers into play from your hand (standing), participating as an attacker..<br>" +
		"<i>Lions of Casterly Rock.</i><br>"
	)
	MOON_BROTHERS_LoCR ("05011"),
	@GraphQLEnumValue(description="" +
		"<h5>Red Keep Spy</h5>" +
		"House Lannister.<br>" +
		"<b><i>Ally. Spy.</i></b><br>" +
		"Ambush (4).<b>Reaction:</b> After Red Keep Spy enters play using ambush, choose a character with printed cost 3 or lower. If you have more cards in hand than that character's controller, return it to its owner's hand..<br>" +
		"<i>Lions of Casterly Rock.</i><br>"
	)
	RED_KEEP_SPY_LoCR ("05012"),
	@GraphQLEnumValue(description="" +
		"<h5>Alayaya</h5>" +
		"House Lannister.<br>" +
		"<b><i>Companion.</i></b><br>" +
		"<b>Reaction:</b> After you win a challenge in which Alayaya is participating, move 1 gold from the losing opponent's gold pool to your own..<br>" +
		"<i>Lions of Casterly Rock.</i><br>"
	)
	ALAYAYA_LoCR ("05013"),
	@GraphQLEnumValue(description="" +
		"<h5>Ser Lancel Lannister</h5>" +
		"House Lannister.<br>" +
		"<b><i>Knight. Lord.</i></b><br>" +
		"While you control exactly 1 other [lannister] <i>Lord</i> or <i>Lady</i> character, Ser Lancel Lannister gets +X STR, where X is that character's STR..<br>" +
		"<i>Lions of Casterly Rock.</i><br>"
	)
	SER_LANCEL_LANNISTER_LoCR ("05014"),
	@GraphQLEnumValue(description="" +
		"<h5>Tommen Baratheon</h5>" +
		"House Lannister.<br>" +
		"<b><i>King. Lord.</i></b><br>" +
		"Each player with no cards in his or her hand cannot gain power from challenge bonuses (unopposed and rivals)..<br>" +
		"<i>Lions of Casterly Rock.</i><br>"
	)
	TOMMEN_BARATHEON_LoCR ("05015"),
	@GraphQLEnumValue(description="" +
		"<h5>Lannisport Guard</h5>" +
		"House Lannister.<br>" +
		"<b><i>Ally. Guard.</i></b><br>" +
		"<b>Reaction:</b> After you marshal Lannisport Guard, each player draws 1 card..<br>" +
		"<i>Lions of Casterly Rock.</i><br>"
	)
	LANNISPORT_GUARD_LoCR ("05016"),
	@GraphQLEnumValue(description="" +
		"<h5>Golden Tooth</h5>" +
		"House Lannister.<br>" +
		"<b><i>Stronghold. The Westerlands.</i></b><br>" +
		"Limited.<b>Action:</b> Kneel Golden Tooth to gain 1 gold. (3 gold instead if an opponent has no cards in his or her hand.).<br>" +
		"<i>Lions of Casterly Rock.</i><br>"
	)
	GOLDEN_TOOTH_LoCR ("05017"),
	@GraphQLEnumValue(description="" +
		"<h5>Mountains of the Moon</h5>" +
		"House Lannister.<br>" +
		"<b><i>Westeros.</i></b><br>" +
		"<b>Reaction:</b> After a <i>Clansman</i> character enters play, that character gains a challenge icon of your choice until the end of the phase..<br>" +
		"<i>Lions of Casterly Rock.</i><br>"
	)
	MOUNTAINS_OF_THE_MOON_LoCR ("05018"),
	@GraphQLEnumValue(description="" +
		"<h5>Lannisport Treasury</h5>" +
		"House Lannister.<br>" +
		"<b><i>The Westerlands.</i></b><br>" +
		"<b>Reaction:</b> After the taxation phase begins, place 1 gold from your gold pool on Lannisport Treasury.<b>Marshaling Action:</b> Kneel Lannisport Treasury to move any number of gold from Lannisport Treasury to your gold pool..<br>" +
		"<i>Lions of Casterly Rock.</i><br>"
	)
	LANNISPORT_TREASURY_LoCR ("05019"),
	@GraphQLEnumValue(description="" +
		"<h5>Shield of Lannisport</h5>" +
		"House Lannister.<br>" +
		"<b><i>Title.</i></b><br>" +
		"[lannister] <i>Lord</i> or <i>Lady</i> character only.While you control no <i>Lord</i> or <i>Lady</i> characters with printed cost 4 or higher other than attached character, attached character gets +2 STR and gains renown.+1 Income..<br>" +
		"<i>Lions of Casterly Rock.</i><br>"
	)
	SHIELD_OF_LANNISPORT_LoCR ("05020"),
	@GraphQLEnumValue(description="" +
		"<h5>Valyrian Steel Dagger</h5>" +
		"House Lannister.<br>" +
		"<b><i>Valyrian Steel. Weapon.</i></b><br>" +
		"During [intrigue] challenges, attached character gets +2 STR and gains stealth..<br>" +
		"<i>Lions of Casterly Rock.</i><br>"
	)
	VALYRIAN_STEEL_DAGGER_LoCR ("05021"),
	@GraphQLEnumValue(description="" +
		"<h5>A Lannister Always Pays His Debts</h5>" +
		"House Lannister.<br>" +
		"<b>Challenges Action:</b> Choose an opponent who has won a challenge against you this phase. You may initiate an additional [military] and [intrigue] challenge against that player this phase. (Max 1 per phase.).<br>" +
		"<i>Lions of Casterly Rock.</i><br>"
	)
	A_LANNISTER_ALWAYS_PAYS_HIS_DEBTS_LoCR ("05022"),
	@GraphQLEnumValue(description="" +
		"<h5>Insidious Scheme</h5>" +
		"House Lannister.<br>" +
		"<b>Reaction:</b> After claim is applied for an [intrigue] challenge you won by 5 or more STR, draw 2 cards. (4 cards instead if the losing opponent has no cards in his or her hand.).<br>" +
		"<i>Lions of Casterly Rock.</i><br>"
	)
	INSIDIOUS_SCHEME_LoCR ("05023"),
	@GraphQLEnumValue(description="" +
		"<h5>Daring Rescue</h5>" +
		"House Lannister.<br>" +
		"Play only if you control a <i>Knight</i> character.<b>Challenges Action:</b> Return a character you control to its owner's hand. Then, have a <i>Knight</i> character you control gain 1 power..<br>" +
		"<i>Lions of Casterly Rock.</i><br>"
	)
	DARING_RESCUE_LoCR ("05024"),
	@GraphQLEnumValue(description="" +
		"<h5>Edric Storm</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Bastard.</i></b><br>" +
		"<b>Reaction:</b> After the dominance phase begins, choose a character. That character does not contribute its STR to its controller's total for dominance this phase..<br>" +
		"<i>Lions of Casterly Rock.</i><br>"
	)
	EDRIC_STORM_LoCR ("05025"),
	@GraphQLEnumValue(description="" +
		"<h5>Disputed Claim</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Condition.</i></b><br>" +
		"<i>Bastard</i>, <i>Lord</i>, or <i>Lady</i> character only.While you have more power on your faction card than each opponent, attached character gets +2 STR and gains renown..<br>" +
		"<i>Lions of Casterly Rock.</i><br>"
	)
	DISPUTED_CLAIM_LoCR ("05026"),
	@GraphQLEnumValue(description="" +
		"<h5>Victarion Greyjoy (LoCR)</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Captain. Ironborn. Lord.</i></b><br>" +
		"Intimidate. Renown.<b>Interrupt:</b> When Victarion Greyjoy would be killed, discard 2 power from him to save him..<br>" +
		"<i>Lions of Casterly Rock.</i><br>"
	)
	VICTARION_GREYJOY_LoCR ("05027"),
	@GraphQLEnumValue(description="" +
		"<h5>Old Wyk</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Iron Islands.</i></b><br>" +
		"<b>Reaction:</b> After you initiate a [power] challenge, kneel Old Wyk to put the top <i>Drowned God</i> character in your dead pile into play knelt, participating as an attacker. Then, if you win the challenge by 5 or more STR, return that character to your hand. Otherwise, place it on the bottom of your deck.<em>Errata from FAQ v2.0</em>.<br>" +
		"<i>Lions of Casterly Rock.</i><br>"
	)
	OLD_WYK_LoCR ("05028"),
	@GraphQLEnumValue(description="" +
		"<h5>Trystane Martell</h5>" +
		"House Martell.<br>" +
		"<b><i>Lord.</i></b><br>" +
		"<b>Reaction:</b> After you lose a challenge in which Trystane Martell is participating, choose a character with lower STR than his. Until the end of the phase, that character cannot be declared as a defender..<br>" +
		"<i>Lions of Casterly Rock.</i><br>"
	)
	TRYSTANE_MARTELL_LoCR ("05029"),
	@GraphQLEnumValue(description="" +
		"<h5>You Murdered Her Children</h5>" +
		"House Martell.<br>" +
		"<b>Challenges Action:</b> Choose a [martell] character you control. Until the end of the phase, double that character's STR. At the end of the phase, if that character is still in play, kill it..<br>" +
		"<i>Lions of Casterly Rock.</i><br>"
	)
	YOU_MURDERED_HER_CHILDREN_LoCR ("05030"),
	@GraphQLEnumValue(description="" +
		"<h5>Sweet Donnel Hill</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Bastard. Steward.</i></b><br>" +
		"No attachments except <i>Weapon</i>.While Sweet Donnel Hill is defending, each attacking character loses all keywords..<br>" +
		"<i>Lions of Casterly Rock.</i><br>"
	)
	SWEET_DONNEL_HILL_LoCR ("05031"),
	@GraphQLEnumValue(description="" +
		"<h5>Bridge of Skulls</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>The North.</i></b><br>" +
		"<b>Interrupt:</b> When the challenges phase ends, choose an opponent who did not initiate a military challenge against you this phase. That player discards one card at random from his or her hand..<br>" +
		"<i>Lions of Casterly Rock.</i><br>"
	)
	BRIDGE_OF_SKULLS_LoCR ("05032"),
	@GraphQLEnumValue(description="" +
		"<h5>Jeyne Westerling</h5>" +
		"House Stark.<br>" +
		"<b><i>Lady. Queen.</i></b><br>" +
		"<b>Action:</b> Kneel Jeyne Westerling to choose and stand a [stark] <i>King</i> or <i>Lord</i> character..<br>" +
		"<i>Lions of Casterly Rock.</i><br>"
	)
	JEYNE_WESTERLING_LoCR ("05033"),
	@GraphQLEnumValue(description="" +
		"<h5>Last Hearth Scouts</h5>" +
		"House Stark.<br>" +
		"<b><i>House Umber.</i></b><br>" +
		"<b>Forced Reaction:</b> After a character enters play during the challenges phase, kneel that character..<br>" +
		"<i>Lions of Casterly Rock.</i><br>"
	)
	LAST_HEARTH_SCOUTS_LoCR ("05034"),
	@GraphQLEnumValue(description="" +
		"<h5>Ser Barristan Selmy (LoCR)</h5>" +
		"House Targaryen.<br>" +
		"<b><i>Knight.</i></b><br>" +
		"<b>Reaction:</b> After you win a challenge in which Ser Barristan Selmy is participating, if you have fewer cards in hand than the losing opponent, stand him..<br>" +
		"<i>Lions of Casterly Rock.</i><br>"
	)
	SER_BARRISTAN_SELMY_LoCR ("05035"),
	@GraphQLEnumValue(description="" +
		"<h5>Daenerys's Favor</h5>" +
		"House Targaryen.<br>" +
		"<b><i>Condition.</i></b><br>" +
		"[targaryen] character only.While attached character is participating in a challenge, each other participating character gets -1 STR..<br>" +
		"<i>Lions of Casterly Rock.</i><br>"
	)
	DAENERYSS_FAVOR_LoCR ("05036"),
	@GraphQLEnumValue(description="" +
		"<h5>Alerie Tyrell</h5>" +
		"House Tyrell.<br>" +
		"<b><i>House Hightower. Lady.</i></b><br>" +
		"<b>Reaction:</b> After Alerie Tyrell enters play, search the top 10 cards of your deck for a [tyrell] character with printed cost 3 or lower, reveal it, and add it to your hand. Shuffle your deck..<br>" +
		"<i>Lions of Casterly Rock.</i><br>"
	)
	ALERIE_TYRELL_LoCR ("05037"),
	@GraphQLEnumValue(description="" +
		"<h5>\"A Rose of Gold\"</h5>" +
		"House Tyrell.<br>" +
		"<b><i>Song.</i></b><br>" +
		"<b>Challenges Action:</b> Look at the top 3 cards of your deck. Add 1 to your hand, and place the others on the bottom of your deck in any order..<br>" +
		"<i>Lions of Casterly Rock.</i><br>"
	)
	A_ROSE_OF_GOLD_LoCR ("05038"),
	@GraphQLEnumValue(description="" +
		"<h5>High Septon</h5>" +
		"Neutral.<br>" +
		"<b><i>The Seven.</i></b><br>" +
		"<b>Interrupt:</b> When an opponent chooses a character you control as the only target of a triggered ability, choose an eligible <i>The Seven</i> character you control to become the target of that triggered ability instead. (Limit once per phase.).<br>" +
		"<i>Lions of Casterly Rock.</i><br>"
	)
	HIGH_SEPTON_LoCR ("05039"),
	@GraphQLEnumValue(description="" +
		"<h5>Devout Freerider</h5>" +
		"Neutral.<br>" +
		"<b><i>Ally. Mercenary. The Seven.</i></b><br>" +
		"During the challenges phase, each player cannot gain gold..<br>" +
		"<i>Lions of Casterly Rock.</i><br>"
	)
	DEVOUT_FREERIDER_LoCR ("05040"),
	@GraphQLEnumValue(description="" +
		"<h5>Wildling Bandit</h5>" +
		"Neutral.<br>" +
		"<b><i>Wildling.</i></b><br>" +
		"While Wildling Bandit is attacking an opponent with more gold in his or her gold pool than you, it gets +2 STR..<br>" +
		"<i>Lions of Casterly Rock.</i><br>"
	)
	WILDLING_BANDIT_LoCR ("05041"),
	@GraphQLEnumValue(description="" +
		"<h5>Ocean Road</h5>" +
		"Neutral.<br>" +
		"<b><i>Westeros.</i></b><br>" +
		"Limited.<b>Marshaling Action:</b> Kneel Ocean Road to reduce the cost of the next neutral or out-of-faction card you marshal this phase by 1..<br>" +
		"<i>Lions of Casterly Rock.</i><br>"
	)
	OCEAN_ROAD_LoCR ("05042"),
	@GraphQLEnumValue(description="" +
		"<h5>Appointed</h5>" +
		"Neutral.<br>" +
		"<b><i>Title.</i></b><br>" +
		"Unique character only.Attached character gains an [intrigue] icon and the <i>Small Council</i> trait..<br>" +
		"<i>Lions of Casterly Rock.</i><br>"
	)
	APPOINTED_LoCR ("05043"),
	@GraphQLEnumValue(description="" +
		"<h5>The Council Consents</h5>" +
		"Neutral.<br>" +
		"<b><i>Small Council.</i></b><br>" +
		"<b>Reaction:</b> After a player wins an [intrigue] challenge by 5 or more STR, stand each <i>Small Council</i> character..<br>" +
		"<i>Lions of Casterly Rock.</i><br>"
	)
	THE_COUNCIL_CONSENTS_LoCR ("05044"),
	@GraphQLEnumValue(description="" +
		"<h5>\"The Rains of Castamere\"</h5>" +
		"Neutral.<br>" +
		"<b><i>Song.</i></b><br>" +
		"Your plot deck must be 12 cards, including exactly 5 different <i>Scheme</i> cards. During the plot phase, <i>Scheme</i> cards are not considered to be in your plot deck.<b>Reaction:</b> After you win an [intrigue] challenge by 5 or more STR, kneel your faction card to reveal a <i>Scheme</i> plot. If that card leaves play, remove it from the game..<br>" +
		"<i>Lions of Casterly Rock.</i><br>"
	)
	THE_RAINS_OF_CASTAMERE_LoCR ("05045"),
	@GraphQLEnumValue(description="" +
		"<h5>Lions of the Rock</h5>" +
		"House Lannister.<br>" +
		"<b><i>Kingdom.</i></b><br>" +
		"<b>Reaction:</b> After the challenges phase begins, gain 3 gold..<br>" +
		"<i>Lions of Casterly Rock.</i><br>"
	)
	LIONS_OF_THE_ROCK_LoCR ("05046"),
	@GraphQLEnumValue(description="" +
		"<h5>Unexpected Delay</h5>" +
		"Neutral.<br>" +
		"<b><i>House Frey.</i></b><br>" +
		"<b>Forced Reaction:</b> After the challenges phase begins, each player chooses a character without attachments or power. Return each of those characters to its owner's hand..<br>" +
		"<i>Lions of Casterly Rock.</i><br>"
	)
	UNEXPECTED_DELAY_LoCR ("05047"),
	@GraphQLEnumValue(description="" +
		"<h5>Summoned to Court</h5>" +
		"Neutral.<br>" +
		"<b><i>Edict. Kingdom.</i></b><br>" +
		"<b>Forced Interrupt:</b> When the draw phase ends, each player chooses a card in his or her hand, if able. Then, reveal the chosen cards. Each player who revealed a character with the lowest printed cost may put that character into play..<br>" +
		"<i>Lions of Casterly Rock.</i><br>"
	)
	SUMMONED_TO_COURT_LoCR ("05048"),
	@GraphQLEnumValue(description="" +
		"<h5>Littlefinger's Meddling</h5>" +
		"Neutral.<br>" +
		"<b><i>Kingdom. Scheme.</i></b><br>" +
		"Reduce the cost of each event you play by 2..<br>" +
		"<i>Lions of Casterly Rock.</i><br>"
	)
	LITTLEFINGERS_MEDDLING_LoCR ("05049"),
	@GraphQLEnumValue(description="" +
		"<h5>Gossip and Lies</h5>" +
		"Neutral.<br>" +
		"<b><i>Scheme.</i></b><br>" +
		"Each character you control does not kneel when declared as an attacker in the first [intrigue] challenge you initiate during the challenges phase..<br>" +
		"<i>Lions of Casterly Rock.</i><br>"
	)
	GOSSIP_AND_LIES_LoCR ("05050"),
	@GraphQLEnumValue(description="" +
		"<h5>Time of Plenty</h5>" +
		"Neutral.<br>" +
		"<b><i>Summer.</i></b><br>" +
		"Increase the number of cards each player draws in the draw phase by 1..<br>" +
		"<i>Lions of Casterly Rock.</i><br>"
	)
	TIME_OF_PLENTY_LoCR ("05051"),
	@GraphQLEnumValue(description="" +
		"<h5>Early Frost</h5>" +
		"Neutral.<br>" +
		"<b><i>Winter.</i></b><br>" +
		"Reduce the number of cards each player draws in the draw phase by 1..<br>" +
		"<i>Lions of Casterly Rock.</i><br>"
	)
	EARLY_FROST_LoCR ("05052"),
	@GraphQLEnumValue(description="" +
		"<h5>Hoster Tully</h5>" +
		"House Stark.<br>" +
		"<b><i>House Tully. Lord.</i></b><br>" +
		"While Hoster Tully is participating in a challenge, each other participating <i>House Tully</i> character you control gains renown..<br>" +
		"<i>All Men Are Fools.</i><br>"
	)
	HOSTER_TULLY_AMAF ("06001"),
	@GraphQLEnumValue(description="" +
		"<h5>The Tumblestone</h5>" +
		"House Stark.<br>" +
		"<b><i>The Riverlands.</i></b><br>" +
		"Bestow (3).<b>Reaction:</b> After a <i>House Tully</i> character gains power, discard 1 gold from The Tumblestone to stand that character..<br>" +
		"<i>All Men Are Fools.</i><br>"
	)
	THE_TUMBLESTONE_AMAF ("06002"),
	@GraphQLEnumValue(description="" +
		"<h5>Margaery Tyrell (AMAF)</h5>" +
		"House Tyrell.<br>" +
		"<b><i>Lady. Queen.</i></b><br>" +
		"Renown.<b>Reaction:</b> After a unique <i>King</i> or <i>Lord</i> character you control is killed, search your deck for a unique <i>King</i> or <i>Lord</i> character and put it into play. Shuffle your deck. (Limit once per round.).<br>" +
		"<i>All Men Are Fools.</i><br>"
	)
	MARGAERY_TYRELL_AMAF ("06003"),
	@GraphQLEnumValue(description="" +
		"<h5>All Men Are Fools</h5>" +
		"House Tyrell.<br>" +
		"<b>Reaction:</b> After you win a challenge by 5 or more STR, each <i>Lady</i> character you control gains 1 power. (Max 1 per challenge.).<br>" +
		"<i>All Men Are Fools.</i><br>"
	)
	ALL_MEN_ARE_FOOLS_AMAF ("06004"),
	@GraphQLEnumValue(description="" +
		"<h5>Eastwatch Carpenter</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Builder.</i></b><br>" +
		"No attachments except <i>Weapon</i>.<b>Reaction:</b> After you collect income, gain 1 gold for every 2 [thenightswatch] locations you control..<br>" +
		"<i>All Men Are Fools.</i><br>"
	)
	EASTWATCH_CARPENTER_AMAF ("06005"),
	@GraphQLEnumValue(description="" +
		"<h5>Eastwatch-by-the-Sea</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>The North.</i></b><br>" +
		"<b>Reaction:</b> After the dominance phase begins, if you have a higher reserve value than an opponent, draw 1 card.+1 Reserve..<br>" +
		"<i>All Men Are Fools.</i><br>"
	)
	EASTWATCH_BY_THE_SEA_AMAF ("06006"),
	@GraphQLEnumValue(description="" +
		"<h5>Fickle Bannerman</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Ally.</i></b><br>" +
		"Bestow (2). Renown.<b>Forced Reaction:</b> After you lose a [power] challenge, the winning opponent takes control of Fickle Bannerman unless you discard 1 gold from it..<br>" +
		"<i>All Men Are Fools.</i><br>"
	)
	FICKLE_BANNERMAN_AMAF ("06007"),
	@GraphQLEnumValue(description="" +
		"<h5>Storm's End</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Stronghold.</i></b><br>" +
		"<b>Reaction:</b> After you win dominance, discard 1 power from your faction card to choose 2 characters. Each of those characters gains 1 power..<br>" +
		"<i>All Men Are Fools.</i><br>"
	)
	STORMS_END_AMAF ("06008"),
	@GraphQLEnumValue(description="" +
		"<h5>Stone Crows</h5>" +
		"House Lannister.<br>" +
		"<b><i>Clansman.</i></b><br>" +
		"Ambush (3). Bestow (2). <b>Reaction:</b> After you win a challenge in which Stone Crows is attacking, discard 1 gold from it to have the losing opponent choose and kill a defending character..<br>" +
		"<i>All Men Are Fools.</i><br>"
	)
	STONE_CROWS_AMAF ("06009"),
	@GraphQLEnumValue(description="" +
		"<h5>Attack From the Mountains</h5>" +
		"House Lannister.<br>" +
		"<b>Reaction:</b> After you win a challenge in which you control an attacking <i>Clansman</i> character, put a <i>Clansman</i> character into play from your hand..<br>" +
		"<i>All Men Are Fools.</i><br>"
	)
	ATTACK_FROM_THE_MOUNTAINS_AMAF ("06010"),
	@GraphQLEnumValue(description="" +
		"<h5>Drowned Disciple</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Drowned God.</i></b><br>" +
		"<b>Reaction:</b> After a character enters play from your dead pile, choose a <i>Drowned God</i> character and have it gain 1 power. (Limit twice per phase.).<br>" +
		"<i>All Men Are Fools.</i><br>"
	)
	DROWNED_DISCIPLE_AMAF ("06011"),
	@GraphQLEnumValue(description="" +
		"<h5>Moat Cailin</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Contested. The North.</i></b><br>" +
		"While there are more <i>Winter</i> plot cards than <i>Summer</i> plot cards revealed, reduce the initiative value on each opponent's revealed plot card by 3, and the reserve value on each opponent's revealed plot card by 1..<br>" +
		"<i>All Men Are Fools.</i><br>"
	)
	MOAT_CAILIN_AMAF ("06012"),
	@GraphQLEnumValue(description="" +
		"<h5>Ghiscari Elite</h5>" +
		"House Targaryen.<br>" +
		"<b><i>Ally.</i></b><br>" +
		"<b>Reaction:</b> After Ghiscari Elite is knelt, choose an attachment or event in your discard pile, and place it on the bottom of your deck..<br>" +
		"<i>All Men Are Fools.</i><br>"
	)
	GHISCARI_ELITE_AMAF ("06013"),
	@GraphQLEnumValue(description="" +
		"<h5>Slaver's Bay Port</h5>" +
		"House Targaryen.<br>" +
		"<b><i>Essos.</i></b><br>" +
		"Limited.<b>Marshaling Action:</b> Kneel Slaver's Bay Port to gain 1 gold. (2 gold instead if an opponent has 4 or more characters in his or her dead pile.).<br>" +
		"<i>All Men Are Fools.</i><br>"
	)
	SLAVERS_BAY_PORT_AMAF ("06014"),
	@GraphQLEnumValue(description="" +
		"<h5>Ricasso</h5>" +
		"House Martell.<br>" +
		"<b><i>Ally. Steward.</i></b><br>" +
		"Bestow (2). You are considered to have X additional plot cards in your used pile. X is the number of gold Ricasso has..<br>" +
		"<i>All Men Are Fools.</i><br>"
	)
	RICASSO_AMAF ("06015"),
	@GraphQLEnumValue(description="" +
		"<h5>The Prince's Plan</h5>" +
		"House Martell.<br>" +
		"<b>Action:</b> Choose a character. Until the end of the phase, that character gets +1 STR for each plot card in your used pile and gains a challenge icon of your choice.<b>Reaction:</b> After you lose a challenge, pay 1 gold to return The Prince's Plan from your discard pile to your hand..<br>" +
		"<i>All Men Are Fools.</i><br>"
	)
	THE_PRINCES_PLAN_AMAF ("06016"),
	@GraphQLEnumValue(description="" +
		"<h5>Ygritte</h5>" +
		"Neutral.<br>" +
		"<b><i>Wildling.</i></b><br>" +
		"Ygritte cannot be knelt by card effects.While you control another <i>Wildling</i> character, Ygritte gains stealth..<br>" +
		"<i>All Men Are Fools.</i><br>"
	)
	YGRITTE_AMAF ("06017"),
	@GraphQLEnumValue(description="" +
		"<h5>Alliance</h5>" +
		"Neutral.<br>" +
		"Your minimum deck size is 75 cards.You may run 2 <i>Banner</i> agendas in addition to this agenda..<br>" +
		"<i>All Men Are Fools.</i><br>"
	)
	ALLIANCE_AMAF ("06018"),
	@GraphQLEnumValue(description="" +
		"<h5>Barring the Gates</h5>" +
		"Neutral.<br>" +
		"<b><i>Edict. Winter.</i></b><br>" +
		"Card abilities cannot cause characters to enter play..<br>" +
		"<i>All Men Are Fools.</i><br>"
	)
	BARRING_THE_GATES_AMAF ("06019"),
	@GraphQLEnumValue(description="" +
		"<h5>Late Summer Feast</h5>" +
		"Neutral.<br>" +
		"<b><i>Kingdom. Summer.</i></b><br>" +
		"<b>Forced Reaction:</b> After you win a challenge, the losing opponent may draw 1 card..<br>" +
		"<i>All Men Are Fools.</i><br>"
	)
	LATE_SUMMER_FEAST_AMAF ("06020"),
	@GraphQLEnumValue(description="" +
		"<h5>Bear Island Host</h5>" +
		"House Stark.<br>" +
		"<b><i>Army. House Mormont.</i></b><br>" +
		"Bestow (3). No attachments.<b>Action:</b> Discard 1 gold from Bear Island Host to choose a <i>House Mormont</i> character. Until the end of the phase, that character does not kneel when declared as an attacker in a [military] challenge..<br>" +
		"<i>Guarding the Realm.</i><br>"
	)
	BEAR_ISLAND_HOST_GtR ("06021"),
	@GraphQLEnumValue(description="" +
		"<h5>Marriage Pact</h5>" +
		"House Stark.<br>" +
		"<b><i>Condition.</i></b><br>" +
		"Terminal.Attached character cannot participate in challenges against you.<b>Forced Interrupt:</b> When attached character leaves play, sacrifice a character you control..<br>" +
		"<i>Guarding the Realm.</i><br>"
	)
	MARRIAGE_PACT_GtR ("06022"),
	@GraphQLEnumValue(description="" +
		"<h5>Knight of the Reach</h5>" +
		"House Tyrell.<br>" +
		"<b><i>Knight.</i></b><br>" +
		"<b>Reaction:</b> After you win a challenge in which Knight of the Reach is attacking or defending alone, choose a <i>Lady</i> character. That character gains 1 power..<br>" +
		"<i>Guarding the Realm.</i><br>"
	)
	KNIGHT_OF_THE_REACH_GtR ("06023"),
	@GraphQLEnumValue(description="" +
		"<h5>\"Lord Renly's Ride\"</h5>" +
		"House Tyrell.<br>" +
		"<b><i>Song.</i></b><br>" +
		"<b>Action:</b> Choose a character. Until the end of the phase, that character gets +X STR and gains intimidate. X is the printed STR of the top character in your dead pile..<br>" +
		"<i>Guarding the Realm.</i><br>"
	)
	LORD_RENLYS_RIDE_GtR ("06024"),
	@GraphQLEnumValue(description="" +
		"<h5>Gilly</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Wildling.</i></b><br>" +
		"Bestow (3).<b>Action:</b> Discard 1 gold from Gilly to choose a <i>Steward</i> character you control. Until the end of the phase, that character gains stealth..<br>" +
		"<i>Guarding the Realm.</i><br>"
	)
	GILLY_GtR ("06025"),
	@GraphQLEnumValue(description="" +
		"<h5>Guarding the Realm</h5>" +
		"The Night's Watch.<br>" +
		"<b>Marshaling Action:</b> Choose a character with printed cost 3 or lower in an opponent's discard pile, and put it into play under your control.<b>Reaction:</b> After you win a challenge as the defending player, pay 1 gold to return Guarding the Realm from your discard pile to your hand..<br>" +
		"<i>Guarding the Realm.</i><br>"
	)
	GUARDING_THE_REALM_GtR ("06026"),
	@GraphQLEnumValue(description="" +
		"<h5>Melisandre (GtR)</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Lady. R'hllor.</i></b><br>" +
		"Insight.<b>Reaction:</b> After you win dominance, choose an opponent and look at his or her hand. Then, choose and discard 1 card from that hand. If that card is a character, place it in its owner's dead pile..<br>" +
		"<i>Guarding the Realm.</i><br>"
	)
	MELISANDRE_GtR ("06027"),
	@GraphQLEnumValue(description="" +
		"<h5>Light of the Lord</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Blessing. R'hllor.</i></b><br>" +
		"[baratheon] or <i>R'hllor</i> character only.<b>Reaction:</b> After the dominance phase begins, stand attached character and gain 1 gold..<br>" +
		"<i>Guarding the Realm.</i><br>"
	)
	LIGHT_OF_THE_LORD_GtR ("06028"),
	@GraphQLEnumValue(description="" +
		"<h5>Polliver</h5>" +
		"House Lannister.<br>" +
		"<b><i>Ally.</i></b><br>" +
		"Pillage.<b>Reaction:</b> After Polliver discards a character using pillage, return 2 gold from the losing opponent's gold pool to the treasury..<br>" +
		"<i>Guarding the Realm.</i><br>"
	)
	POLLIVER_GtR ("06029"),
	@GraphQLEnumValue(description="" +
		"<h5>The Hand's Solar</h5>" +
		"House Lannister.<br>" +
		"<b><i>King's Landing.</i></b><br>" +
		"<b>Action:</b> Kneel The Hand's Solar to choose a character. Until the end of the phase, that character gains an [intrigue] icon..<br>" +
		"<i>Guarding the Realm.</i><br>"
	)
	THE_HANDS_SOLAR_GtR ("06030"),
	@GraphQLEnumValue(description="" +
		"<h5>Wex Pyke</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Bastard. House Botley.</i></b><br>" +
		"Bestow (8).While Wex Pyke is attacking, each character with printed cost X cannot be declared as a defender. X is the number of gold Wex Pyke has.<b>Dominance Action:</b> Move 1 gold from your gold pool to Wex Pyke. (Limit twice per phase.).<br>" +
		"<i>Guarding the Realm.</i><br>"
	)
	WEX_PYKE_GtR ("06031"),
	@GraphQLEnumValue(description="" +
		"<h5>Iron Islands Market</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Iron Islands.</i></b><br>" +
		"Limited.<b>Marshaling Action:</b> Kneel Iron Islands Market to gain 1 gold. (2 gold instead if an opponent has 8 or more cards in his or her discard pile.).<br>" +
		"<i>Guarding the Realm.</i><br>"
	)
	IRON_ISLANDS_MARKET_GtR ("06032"),
	@GraphQLEnumValue(description="" +
		"<h5>Second Sons</h5>" +
		"House Targaryen.<br>" +
		"<b><i>Mercenary.</i></b><br>" +
		"Bestow (3).<b>Forced Interrupt:</b> When the challenges phase ends, sacrifice Second Sons unless you discard 1 gold from it..<br>" +
		"<i>Guarding the Realm.</i><br>"
	)
	SECOND_SONS_GtR ("06033"),
	@GraphQLEnumValue(description="" +
		"<h5>A Dragon Is No Slave</h5>" +
		"House Targaryen.<br>" +
		"<b>Challenges Action:</b> Choose a character without attachments. That character gets -2 STR until the end of the phase.<b>Reaction:</b> After you win a challenge in which you control a participating <i>Dragon</i> character or Daenerys Targaryen, pay 1 gold to return A Dragon Is No Slave from your discard pile to your hand..<br>" +
		"<i>Guarding the Realm.</i><br>"
	)
	A_DRAGON_IS_NO_SLAVE_GtR ("06034"),
	@GraphQLEnumValue(description="" +
		"<h5>Orphan of the Greenblood</h5>" +
		"House Martell.<br>" +
		"<b><i>Ally.</i></b><br>" +
		"Bestow (3).<b>Action:</b> Discard 1 gold from Orphan of the Greenblood to return another character you control to its owner's hand..<br>" +
		"<i>Guarding the Realm.</i><br>"
	)
	ORPHAN_OF_THE_GREENBLOOD_GtR ("06035"),
	@GraphQLEnumValue(description="" +
		"<h5>Scorching Deserts</h5>" +
		"House Martell.<br>" +
		"<b><i>Dorne.</i></b><br>" +
		"<b>Reaction:</b> After a character with fewer than 2 challenge icons is declared as an attacker or defender, kneel and sacrifice Scorching Deserts to remove that character from the challenge..<br>" +
		"<i>Guarding the Realm.</i><br>"
	)
	SCORCHING_DESERTS_GtR ("06036"),
	@GraphQLEnumValue(description="" +
		"<h5>Black Walder</h5>" +
		"Neutral.<br>" +
		"<b><i>House Frey.</i></b><br>" +
		"Bestow (3).During the third challenge you initiate each phase, Black Walder gains renown and gets +2 STR for each gold he has..<br>" +
		"<i>Guarding the Realm.</i><br>"
	)
	BLACK_WALDER_GtR ("06037"),
	@GraphQLEnumValue(description="" +
		"<h5>Great Hall</h5>" +
		"Neutral.<br>" +
		"<b><i>Westeros.</i></b><br>" +
		"Limited.<b>Marshaling Action:</b> Kneel Great Hall to reduce the cost of the next unique character you marshal this phase by 1. (By 2 instead if that character's printed cost is 6 or higher.).<br>" +
		"<i>Guarding the Realm.</i><br>"
	)
	GREAT_HALL_GtR ("06038"),
	@GraphQLEnumValue(description="" +
		"<h5>\"The Dornishman's Wife\"</h5>" +
		"Neutral.<br>" +
		"<b><i>Song.</i></b><br>" +
		"<b>Action:</b> Choose an opponent. If that player has a higher power total than you, gain 2 gold. If that player has more cards in his or her hand than you, gain 1 power for your faction. If that player controls more characters than you, draw 1 card..<br>" +
		"<i>Guarding the Realm.</i><br>"
	)
	THE_DORNISHMANS_WIFE_GtR ("06039"),
	@GraphQLEnumValue(description="" +
		"<h5>The Annals of Castle Black</h5>" +
		"Neutral.<br>" +
		"<b><i>Legacy.</i></b><br>" +
		"Each player may play events in his or her discard pile as if they were in his or her hand.<b>Forced Reaction:</b> After an event is placed in a discard pile, remove it from the game..<br>" +
		"<i>Guarding the Realm.</i><br>"
	)
	THE_ANNALS_OF_CASTLE_BLACK_GtR ("06040"),
	@GraphQLEnumValue(description="" +
		"<h5>Roaming Wolfpack</h5>" +
		"House Stark.<br>" +
		"<b><i>Direwolf.</i></b><br>" +
		"Intimidate. No attachments.While Roaming Wolfpack is attacking, each attacking <i>Direwolf</i> character gets +2 STR..<br>" +
		"<i>The Fall of Astapor.</i><br>"
	)
	ROAMING_WOLFPACK_TFoA ("06041"),
	@GraphQLEnumValue(description="" +
		"<h5>The North Remembers</h5>" +
		"House Stark.<br>" +
		"<b>Challenges Action:</b> Each player sacrifices a character or location.<b>Reaction:</b> After a character you control is killed, pay 1 gold to return The North Remembers from your discard pile to your hand..<br>" +
		"<i>The Fall of Astapor.</i><br>"
	)
	THE_NORTH_REMEMBERS_TFoA ("06042"),
	@GraphQLEnumValue(description="" +
		"<h5>Elinor Tyrell</h5>" +
		"House Tyrell.<br>" +
		"<b><i>Lady.</i></b><br>" +
		"You may marshal or play 1 additional limited card each round..<br>" +
		"<i>The Fall of Astapor.</i><br>"
	)
	ELINOR_TYRELL_TFoA ("06043"),
	@GraphQLEnumValue(description="" +
		"<h5>Silver Hair Net</h5>" +
		"House Tyrell.<br>" +
		"<b><i>Item.</i></b><br>" +
		"<i>Lady</i> character only.Attached character gains stealth.While attached character is participating in a challenge, reduce the cost of each event you play by 1..<br>" +
		"<i>The Fall of Astapor.</i><br>"
	)
	SILVER_HAIR_NET_TFoA ("06044"),
	@GraphQLEnumValue(description="" +
		"<h5>Recruiter for the Watch</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Wandering Crow.</i></b><br>" +
		"You may choose not to stand Recruiter for the Watch during the standing phase.<b>Marshaling Action:</b> Kneel Recruiter for the Watch to choose a character with printed cost 2 or lower. Take control of that character until Recruiter for the Watch stands or leaves play..<br>" +
		"<i>The Fall of Astapor.</i><br>"
	)
	RECRUITER_FOR_THE_WATCH_TFoA ("06045"),
	@GraphQLEnumValue(description="" +
		"<h5>Underground Vault</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>The North.</i></b><br>" +
		"Limited.<b>Marshaling Action:</b> Kneel Underground Vault to gain 1 gold. (2 gold instead if the gold value on an opponent's revealed plot card is 5 or higher.).<br>" +
		"<i>The Fall of Astapor.</i><br>"
	)
	UNDERGROUND_VAULT_TFoA ("06046"),
	@GraphQLEnumValue(description="" +
		"<h5>Flea Bottom Bastard</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Bastard.</i></b><br>" +
		"During the dominance phase, Flea Bottom Bastard gets +3 STR..<br>" +
		"<i>The Fall of Astapor.</i><br>"
	)
	FLEA_BOTTOM_BASTARD_TFoA ("06047"),
	@GraphQLEnumValue(description="" +
		"<h5>Spears of the Merling King</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Westeros.</i></b><br>" +
		"<b>Interrupt:</b> When a character you control is killed, sacrifice Spears of the Merling King to return that character to your hand instead of placing it in your dead pile..<br>" +
		"<i>The Fall of Astapor.</i><br>"
	)
	SPEARS_OF_THE_MERLING_KING_TFoA ("06048"),
	@GraphQLEnumValue(description="" +
		"<h5>Cersei's Attendant</h5>" +
		"House Lannister.<br>" +
		"<b><i>Companion.</i></b><br>" +
		"While Cersei's Attendant is participating in a challenge against an opponent with no cards in his or her hand, Cersei's Attendant gains insight..<br>" +
		"<i>The Fall of Astapor.</i><br>"
	)
	CERSEIS_ATTENDANT_TFoA ("06049"),
	@GraphQLEnumValue(description="" +
		"<h5>Fever Dreams</h5>" +
		"House Lannister.<br>" +
		"<b><i>Dream.</i></b><br>" +
		"Opponent's character only. Bestow (3).<b>Reaction:</b> After attached character is knelt, discard 1 gold from Fever Dreams to draw 2 cards..<br>" +
		"<i>The Fall of Astapor.</i><br>"
	)
	FEVER_DREAMS_TFoA ("06050"),
	@GraphQLEnumValue(description="" +
		"<h5>Theon Greyjoy (TFoA)</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Ironborn. Lord.</i></b><br>" +
		"While Theon Greyjoy is attacking alone, each character with a higher STR than his does not contribute its STR to the challenge..<br>" +
		"<i>The Fall of Astapor.</i><br>"
	)
	THEON_GREYJOY_TFoA ("06051"),
	@GraphQLEnumValue(description="" +
		"<h5>Corsair's Dirk</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Weapon.</i></b><br>" +
		"<i>Ironborn</i> character only.Attached character gets +2 STR.<b>Reaction:</b> After you win a challenge in which attached character is attacking, move 1 gold from the losing opponent's gold pool to your own..<br>" +
		"<i>The Fall of Astapor.</i><br>"
	)
	CORSAIRS_DIRK_TFoA ("06052"),
	@GraphQLEnumValue(description="" +
		"<h5>Grey Worm</h5>" +
		"House Targaryen.<br>" +
		"<b><i>Companion.</i></b><br>" +
		"No attachments except <i>Weapon</i>.<b>Action:</b> During a challenge in which Grey Worm is attacking, choose a defending character. Until the end of the challenge, that character gets -3 STR. (Limit once per challenge.).<br>" +
		"<i>The Fall of Astapor.</i><br>"
	)
	GREY_WORM_TFoA ("06053"),
	@GraphQLEnumValue(description="" +
		"<h5>Astapor</h5>" +
		"House Targaryen.<br>" +
		"<b><i>Astapor. Contested.</i></b><br>" +
		"Bestow (4).<b>Action:</b> Kneel Astapor to choose a participating character. Until the end of the challenge, that character gets -X STR. X is the number of gold Astapor has..<br>" +
		"<i>The Fall of Astapor.</i><br>"
	)
	ASTAPOR_TFoA ("06054"),
	@GraphQLEnumValue(description="" +
		"<h5>Maester of Sunspear</h5>" +
		"House Martell.<br>" +
		"<b><i>Maester.</i></b><br>" +
		"<b>Reaction:</b> After you lose a challenge in which Maester of Sunspear is participating, choose an attachment and return it to its owner's hand..<br>" +
		"<i>The Fall of Astapor.</i><br>"
	)
	MAESTER_OF_SUNSPEAR_TFoA ("06055"),
	@GraphQLEnumValue(description="" +
		"<h5>Dornish Fiefdom</h5>" +
		"House Martell.<br>" +
		"<b><i>Dorne.</i></b><br>" +
		"Limited.<b>Marshaling Action:</b> Kneel Dornish Fiefdom to gain 1 gold. (2 gold instead if you are not the first player.).<br>" +
		"<i>The Fall of Astapor.</i><br>"
	)
	DORNISH_FIEFDOM_TFoA ("06056"),
	@GraphQLEnumValue(description="" +
		"<h5>Frey Lordling</h5>" +
		"Neutral.<br>" +
		"<b><i>House Frey. Lord.</i></b><br>" +
		"<b>Reaction:</b> After you initiate a challenge, Frey Lordling gets +1 STR until the end of the phase..<br>" +
		"<i>The Fall of Astapor.</i><br>"
	)
	FREY_LORDLING_TFoA ("06057"),
	@GraphQLEnumValue(description="" +
		"<h5>The Twins</h5>" +
		"Neutral.<br>" +
		"<b><i>House Frey. The Riverlands.</i></b><br>" +
		"During the third challenge you initiate each phase, if you control an attacking <i>House Frey</i> character, raise the claim value on your revealed plot card by 1..<br>" +
		"<i>The Fall of Astapor.</i><br>"
	)
	THE_TWINS_TFoA ("06058"),
	@GraphQLEnumValue(description="" +
		"<h5>Lay Siege</h5>" +
		"Neutral.<br>" +
		"<b><i>Siege.</i></b><br>" +
		"<b>Action:</b> Choose and kneel a location. Then, if that location is <i>Contested</i>, discard it from play..<br>" +
		"<i>The Fall of Astapor.</i><br>"
	)
	LAY_SIEGE_TFoA ("06059"),
	@GraphQLEnumValue(description="" +
		"<h5>Duel</h5>" +
		"Neutral.<br>" +
		"<b><i>War.</i></b><br>" +
		"<b>When Revealed:</b> Choose an opponent. That player chooses 2 non-<i>Army</i> characters, each with printed cost 6 or higher. Then, that player chooses and kneels 1 of those characters. Kill the other (cannot be saved)..<br>" +
		"<i>The Fall of Astapor.</i><br>"
	)
	DUEL_TFoA ("06060"),
	@GraphQLEnumValue(description="" +
		"<h5>Dacey Mormont</h5>" +
		"House Stark.<br>" +
		"<b><i>House Mormont. Lady.</i></b><br>" +
		"Renown.X is the number of [stark] characters you control..<br>" +
		"<i>The Red Wedding.</i><br>"
	)
	DACEY_MORMONT_TRW ("06061"),
	@GraphQLEnumValue(description="" +
		"<h5>Winterfell Archery Range</h5>" +
		"House Stark.<br>" +
		"<b><i>Winterfell.</i></b><br>" +
		"<b>Action:</b> During a [military] challenge, kneel Winterfell Archery Range to choose a participating character with STR 3 or lower, and remove it from the challenge..<br>" +
		"<i>The Red Wedding.</i><br>"
	)
	WINTERFELL_ARCHERY_RANGE_TRW ("06062"),
	@GraphQLEnumValue(description="" +
		"<h5>Oldtown Informer</h5>" +
		"House Tyrell.<br>" +
		"<b><i>Ally. Spy.</i></b><br>" +
		"Ambush (2). Bestow (3).<b>Reaction:</b> After a card enters play during the challenges phase, draw X cards. Then, discard X cards. X is the number of gold Oldtown Informer has..<br>" +
		"<i>The Red Wedding.</i><br>"
	)
	OLDTOWN_INFORMER_TRW ("06063"),
	@GraphQLEnumValue(description="" +
		"<h5>Arbor Vineyard</h5>" +
		"House Tyrell.<br>" +
		"<b><i>House Redwyne.</i></b><br>" +
		"Limited.<b>Marshaling Action:</b> Kneel Arbor Vineyard to gain 1 gold. (2 gold instead if there are more <i>Summer</i> plot cards than <i>Winter</i> plot cards revealed.).<br>" +
		"<i>The Red Wedding.</i><br>"
	)
	ARBOR_VINEYARD_TRW ("06064"),
	@GraphQLEnumValue(description="" +
		"<h5>Othell Yarwyck</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Builder.</i></b><br>" +
		"<b>Action:</b> Kneel a [thenightswatch] location to choose a [thenightswatch] character. Until the end of the phase, that character gains a challenge icon of your choice..<br>" +
		"<i>The Red Wedding.</i><br>"
	)
	OTHELL_YARWYCK_TRW ("06065"),
	@GraphQLEnumValue(description="" +
		"<h5>Improved Fortifications</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Fortification.</i></b><br>" +
		"Location only.<b>Interrupt:</b> When attached location would leave play, sacrifice Improved Fortifications to save it..<br>" +
		"<i>The Red Wedding.</i><br>"
	)
	IMPROVED_FORTIFICATIONS_TRW ("06066"),
	@GraphQLEnumValue(description="" +
		"<h5>Ser Axell Florent</h5>" +
		"House Baratheon.<br>" +
		"<b><i>House Florent. Knight.</i></b><br>" +
		"Bestow (3).<b>Reaction:</b> After you win a challenge in which Ser Axell Florent is participating, discard 1 gold from him to choose and kneel a character without attachments..<br>" +
		"<i>The Red Wedding.</i><br>"
	)
	SER_AXELL_FLORENT_TRW ("06067"),
	@GraphQLEnumValue(description="" +
		"<h5>Saving the Kingdom</h5>" +
		"House Baratheon.<br>" +
		"<b>Challenges Action:</b> Choose and kneel a character with STR 3 or lower. That character cannot stand during the standing phase this round.<b>Reaction:</b> After you win dominance, pay 1 gold to return Saving the Kingdom from your discard pile to your hand..<br>" +
		"<i>The Red Wedding.</i><br>"
	)
	SAVING_THE_KINGDOM_TRW ("06068"),
	@GraphQLEnumValue(description="" +
		"<h5>Ser Osmund Kettleblack</h5>" +
		"House Lannister.<br>" +
		"<b><i>Kingsguard. Knight.</i></b><br>" +
		"Bestow (3).<b>Challenges Action:</b> Discard 1 gold from Ser Osmund Kettleblack to put a <i>Knight</i> character into play from your hand. At the end of the phase, if that card is still in play, discard it from play (cannot be saved). (Limit once per phase.).<br>" +
		"<i>The Red Wedding.</i><br>"
	)
	SER_OSMUND_KETTLEBLACK_TRW ("06069"),
	@GraphQLEnumValue(description="" +
		"<h5>Tywin's Stratagem</h5>" +
		"House Lannister.<br>" +
		"<b>Challenges Action:</b> Choose a character with printed cost 2 or lower controlled by each player. Return each of those characters to its owner's hand.<b>Reaction:</b> After a character is discarded from an opponent's hand or deck, pay 1 gold to return Tywin's Stratagem from your discard pile to your hand..<br>" +
		"<i>The Red Wedding.</i><br>"
	)
	TYWINS_STRATAGEM_TRW ("06070"),
	@GraphQLEnumValue(description="" +
		"<h5>Silence's Crew</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Raider.</i></b><br>" +
		"Bestow (3). No attachments. Pillage.Silence's Crew gets +2 STR for each gold it has.<b>Reaction:</b> After Silence's Crew discards a location or attachment using pillage, place 1 gold from the treasury on Silence's Crew..<br>" +
		"<i>The Red Wedding.</i><br>"
	)
	SILENCES_CREW_TRW ("06071"),
	@GraphQLEnumValue(description="" +
		"<h5>Plunder</h5>" +
		"House Greyjoy.<br>" +
		"<b>Action:</b> Kneel your faction card to choose an opponent. Gain 1 gold for each location and attachment in that player's discard pile..<br>" +
		"<i>The Red Wedding.</i><br>"
	)
	PLUNDER_TRW ("06072"),
	@GraphQLEnumValue(description="" +
		"<h5>Strong Belwas</h5>" +
		"House Targaryen.<br>" +
		"<b><i>Companion.</i></b><br>" +
		"Bestow (2).<b>Interrupt:</b> When another unique [targaryen] character would be killed, discard 1 gold from Strong Belwas to save it. (Limit once per phase.).<br>" +
		"<i>The Red Wedding.</i><br>"
	)
	STRONG_BELWAS_TRW ("06073"),
	@GraphQLEnumValue(description="" +
		"<h5>Breaker of Chains</h5>" +
		"House Targaryen.<br>" +
		"<b><i>Title.</i></b><br>" +
		"Unique [targaryen] character only.Attached character gets +1 STR for each character you control with printed cost 2 or lower.<b>Reaction:</b> After attached character is declared as an attacker, put a character with printed cost 2 or lower into play from your hand..<br>" +
		"<i>The Red Wedding.</i><br>"
	)
	BREAKER_OF_CHAINS_TRW ("06074"),
	@GraphQLEnumValue(description="" +
		"<h5>Ellaria Sand (TRW)</h5>" +
		"House Martell.<br>" +
		"<b><i>Bastard. Companion.</i></b><br>" +
		"Bestow (3).<b>Reaction:</b> After you lose a challenge in which Ellaria Sand is participating, discard 1 gold from her to stand each <i>Bastard</i> character you control..<br>" +
		"<i>The Red Wedding.</i><br>"
	)
	ELLARIA_SAND_TRW ("06075"),
	@GraphQLEnumValue(description="" +
		"<h5>Secret Schemes</h5>" +
		"House Martell.<br>" +
		"<b>Action:</b> Kneel your faction card to draw X cards. X is the number of plot cards in your used pile..<br>" +
		"<i>The Red Wedding.</i><br>"
	)
	SECRET_SCHEMES_TRW ("06076"),
	@GraphQLEnumValue(description="" +
		"<h5>Walder Frey</h5>" +
		"Neutral.<br>" +
		"<b><i>House Frey. Lord.</i></b><br>" +
		"Renown.While Walder Frey is attacking, each other <i>House Frey</i> character you control is also considered to be attacking..<br>" +
		"<i>The Red Wedding.</i><br>"
	)
	WALDER_FREY_TRW ("06077"),
	@GraphQLEnumValue(description="" +
		"<h5>Frey Bastard</h5>" +
		"Neutral.<br>" +
		"<b><i>Bastard. House Frey.</i></b><br>" +
		"Bestow (2).<b>Reaction:</b> After you win a challenge in which you control 2 or more attacking <i>House Frey</i> characters, discard 1 gold from Frey Bastard to gain 1 power for your faction..<br>" +
		"<i>The Red Wedding.</i><br>"
	)
	FREY_BASTARD_TRW ("06078"),
	@GraphQLEnumValue(description="" +
		"<h5>Frey Hospitality</h5>" +
		"Neutral.<br>" +
		"<b><i>House Frey.</i></b><br>" +
		"<b>Reaction:</b> After you win a challenge in which you control an attacking <i>House Frey</i> character, if it was the third challenge you initiated this phase, choose and kill a character controlled by the losing opponent. (Choose and kill 3 characters instead if you won by 20 or more STR.).<br>" +
		"<i>The Red Wedding.</i><br>"
	)
	FREY_HOSPITALITY_TRW ("06079"),
	@GraphQLEnumValue(description="" +
		"<h5>The Red Wedding</h5>" +
		"Neutral.<br>" +
		"<b><i>House Frey. Scheme.</i></b><br>" +
		"<b>Interrupt:</b> When you win a challenge as the attacking player, choose and kill a <i>Lord</i> or <i>Lady</i> character controlled by the losing opponent. (Any player may initiate this ability.).<br>" +
		"<i>The Red Wedding.</i><br>"
	)
	THE_RED_WEDDING_TRW ("06080"),
	@GraphQLEnumValue(description="" +
		"<h5>Bran Stark (OR)</h5>" +
		"House Stark.<br>" +
		"<b><i>Lord.</i></b><br>" +
		"<b>Action:</b> Kneel Bran Stark to choose and stand a <i>Direwolf</i> character. Until the end of the phase, that character gains a challenge icon of your choice..<br>" +
		"<i>Oberyn's Revenge.</i><br>"
	)
	BRAN_STARK_OR ("06081"),
	@GraphQLEnumValue(description="" +
		"<h5>Passing the Black Gate</h5>" +
		"House Stark.<br>" +
		"<b>Marshaling Action:</b> Kneel your faction card to reduce the cost of each [stark] character you marshal this phase by 1..<br>" +
		"<i>Oberyn's Revenge.</i><br>"
	)
	PASSING_THE_BLACK_GATE_OR ("06082"),
	@GraphQLEnumValue(description="" +
		"<h5>Ser Garlan Tyrell (OR)</h5>" +
		"House Tyrell.<br>" +
		"<b><i>Knight. Lord.</i></b><br>" +
		"Bestow (3). Renown.Ser Garlan Tyrell gets +1 STR for each gold he has.<b>Action:</b> Discard 1 gold from Ser Garlan Tyrell to choose a [tyrell] character. Until the end of the phase, that character gets +2 STR..<br>" +
		"<i>Oberyn's Revenge.</i><br>"
	)
	SER_GARLAN_TYRELL_OR ("06083"),
	@GraphQLEnumValue(description="" +
		"<h5>Olenna's Machinations</h5>" +
		"House Tyrell.<br>" +
		"<b>Challenges Action:</b> You may initiate an additional [power] challenge this phase. (Max 1 per phase.)<b>Reaction:</b> After you win an [intrigue] challenge by 5 or more STR, pay 1 gold to return Olenna's Machinations from your discard pile to your hand..<br>" +
		"<i>Oberyn's Revenge.</i><br>"
	)
	OLENNAS_MACHINATIONS_OR ("06084"),
	@GraphQLEnumValue(description="" +
		"<h5>Defender of the Wall</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Ranger.</i></b><br>" +
		"No attachments except <i>Weapon</i>.While Defender of the Wall is defending, it gets +2 STR..<br>" +
		"<i>Oberyn's Revenge.</i><br>"
	)
	DEFENDER_OF_THE_WALL_OR ("06085"),
	@GraphQLEnumValue(description="" +
		"<h5>Mutiny At Craster's Keep</h5>" +
		"The Night's Watch.<br>" +
		"<b>Dominance Action:</b> Choose a character with the highest printed cost among characters you control. Sacrifice that character to choose a character an opponent controls and discard it from play..<br>" +
		"<i>Oberyn's Revenge.</i><br>"
	)
	MUTINY_AT_CRASTERS_KEEP_OR ("06086"),
	@GraphQLEnumValue(description="" +
		"<h5>Stannis's Cavalry</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Army.</i></b><br>" +
		"Bestow (8). No attachments.Each character an opponent controls with printed cost X cannot stand during the standing phase. X is the number of gold Stannis's Cavalry has.<b>Standing Action:</b> Move 1 gold from your gold pool to Stannis's Cavalry. (Limit twice per phase.).<br>" +
		"<i>Oberyn's Revenge.</i><br>"
	)
	STANNISS_CAVALRY_OR ("06087"),
	@GraphQLEnumValue(description="" +
		"<h5>Northern Encampment</h5>" +
		"House Baratheon.<br>" +
		"<b><i>The North.</i></b><br>" +
		"Limited.Northern Encampment cannot stand during the standing phase unless you have won dominance this round.<b>Marshaling Action:</b> Kneel Northern Encampment to gain 2 gold..<br>" +
		"<i>Oberyn's Revenge.</i><br>"
	)
	NORTHERN_ENCAMPMENT_OR ("06088"),
	@GraphQLEnumValue(description="" +
		"<h5>Kayce Merchant</h5>" +
		"House Lannister.<br>" +
		"<b><i>Merchant.</i></b><br>" +
		"Bestow (3).<b>Reaction:</b> After you collect income, discard 1 gold from Kayce Merchant to gain 2 gold..<br>" +
		"<i>Oberyn's Revenge.</i><br>"
	)
	KAYCE_MERCHANT_OR ("06089"),
	@GraphQLEnumValue(description="" +
		"<h5>A Task For Every Tool</h5>" +
		"House Lannister.<br>" +
		"<b>Challenges Action:</b> Put a [lannister] character with printed STR 2 or lower into play from your hand..<br>" +
		"<i>Oberyn's Revenge.</i><br>"
	)
	A_TASK_FOR_EVERY_TOOL_OR ("06090"),
	@GraphQLEnumValue(description="" +
		"<h5>Nute the Barber</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Ironborn.</i></b><br>" +
		"Pillage.<b>Reaction:</b> After a character you control discards a card using pillage, return a card from the losing opponent's discard pile to its owner's hand. Then, draw 1 card. (Limit 3 times per phase.).<br>" +
		"<i>Oberyn's Revenge.</i><br>"
	)
	NUTE_THE_BARBER_OR ("06091"),
	@GraphQLEnumValue(description="" +
		"<h5>Iron Victory</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Warship.</i></b><br>" +
		"While you control Victarion Greyjoy, he gets +1 STR for each power he has.<b>Reaction:</b> After a [greyjoy] character is saved, that character gains 1 power. (Limit twice per phase.).<br>" +
		"<i>Oberyn's Revenge.</i><br>"
	)
	IRON_VICTORY_OR ("06092"),
	@GraphQLEnumValue(description="" +
		"<h5>Irri</h5>" +
		"House Targaryen.<br>" +
		"<b><i>Companion. Dothraki.</i></b><br>" +
		"Bestow (2).<b>Action:</b> Discard 1 gold from Irri to choose and stand a <i>Lord</i> or <i>Lady</i> character. (Limit once per phase.).<br>" +
		"<i>Oberyn's Revenge.</i><br>"
	)
	IRRI_OR ("06093"),
	@GraphQLEnumValue(description="" +
		"<h5>Overthrowing the Masters</h5>" +
		"House Targaryen.<br>" +
		"<b>Action:</b> During a challenge in which you are the attacking player, choose a defending character with X STR or lower and remove it from the challenge. X is the number of characters in the defending player's dead pile..<br>" +
		"<i>Oberyn's Revenge.</i><br>"
	)
	OVERTHROWING_THE_MASTERS_OR ("06094"),
	@GraphQLEnumValue(description="" +
		"<h5>The Red Viper (OR)</h5>" +
		"House Martell.<br>" +
		"<b><i>Lord.</i></b><br>" +
		"Renown.While The Red Viper is attacking, each defending character with fewer than 2 challenge icons does not contribute its STR to the challenge..<br>" +
		"<i>Oberyn's Revenge.</i><br>"
	)
	THE_RED_VIPER_OR ("06095"),
	@GraphQLEnumValue(description="" +
		"<h5>Dornish Revenge</h5>" +
		"House Martell.<br>" +
		"<b>Reaction:</b> After you initiate a challenge, choose a character controlled by the defending player. That character must be declared as a defender for this challenge, if able. If you win this challenge by 5 or more STR, the losing opponent must choose and kill a defending character..<br>" +
		"<i>Oberyn's Revenge.</i><br>"
	)
	DORNISH_REVENGE_OR ("06096"),
	@GraphQLEnumValue(description="" +
		"<h5>Begging Brother</h5>" +
		"Neutral.<br>" +
		"<b><i>The Seven.</i></b><br>" +
		"Bestow (3).<b>Interrupt:</b> When the effects of a triggered character ability would initiate, discard 1 gold from Begging Brother to cancel those effects..<br>" +
		"<i>Oberyn's Revenge.</i><br>"
	)
	BEGGING_BROTHER_OR ("06097"),
	@GraphQLEnumValue(description="" +
		"<h5>Flea Bottom</h5>" +
		"Neutral.<br>" +
		"<b><i>King's Landing.</i></b><br>" +
		"<b>Challenges Action:</b> Pay 1 gold and kneel Flea Bottom to put a character with printed cost 3 or lower into play from your discard pile. At the end of the phase, if that card is still in play, place it on the bottom of your deck..<br>" +
		"<i>Oberyn's Revenge.</i><br>"
	)
	FLEA_BOTTOM_OR ("06098"),
	@GraphQLEnumValue(description="" +
		"<h5>The Iron Bank Will Have Its Due</h5>" +
		"Neutral.<br>" +
		"<b>Action:</b> If it is not the taxation phase, kneel your faction card and return a character to your hand to gain gold equal to that character's printed cost. Until the end of the round, you cannot marshal or put into play any card with the same title as that character..<br>" +
		"<i>Oberyn's Revenge.</i><br>"
	)
	THE_IRON_BANK_WILL_HAVE_ITS_DUE_OR ("06099"),
	@GraphQLEnumValue(description="" +
		"<h5>Wheels Within Wheels</h5>" +
		"Neutral.<br>" +
		"<b><i>Scheme.</i></b><br>" +
		"<b>When Revealed:</b> Search the top 10 cards of your deck for any number of events and reveal them. Add 1 to your hand, and place the others in your discard pile. Shuffle your deck..<br>" +
		"<i>Oberyn's Revenge.</i><br>"
	)
	WHEELS_WITHIN_WHEELS_OR ("06100"),
	@GraphQLEnumValue(description="" +
		"<h5>Sansa's Maid</h5>" +
		"House Stark.<br>" +
		"<b><i>Companion.</i></b><br>" +
		"Bestow (3).Each <i>Lady</i> character you control gets +1 STR for each gold Sansa's Maid has..<br>" +
		"<i>The Brotherhood Without Banners.</i><br>"
	)
	SANSAS_MAID_TBWB ("06101"),
	@GraphQLEnumValue(description="" +
		"<h5>Northern Keep</h5>" +
		"House Stark.<br>" +
		"<b><i>The North.</i></b><br>" +
		"Limited.<b>Marshaling Action:</b> Kneel Northern Keep to gain 1 gold. (2 gold instead if there are more <i>Winter</i> plot cards than <i>Summer</i> plot cards revealed.).<br>" +
		"<i>The Brotherhood Without Banners.</i><br>"
	)
	NORTHERN_KEEP_TBWB ("06102"),
	@GraphQLEnumValue(description="" +
		"<h5>Highgarden Minstrel</h5>" +
		"House Tyrell.<br>" +
		"<b><i>Minstrel.</i></b><br>" +
		"<b>Reaction:</b> After you play a <i>Song</i> event, gain 1 gold. (Limit 3 times per round.).<br>" +
		"<i>The Brotherhood Without Banners.</i><br>"
	)
	HIGHGARDEN_MINSTREL_TBWB ("06103"),
	@GraphQLEnumValue(description="" +
		"<h5>Horn Hill</h5>" +
		"House Tyrell.<br>" +
		"<b><i>The Reach.</i></b><br>" +
		"Bestow (3).<b>Challenges Action:</b> Kneel Horn Hill to give each participating [tyrell] character you control +X STR until the end of the challenge. X is the number of gold Horn Hill has..<br>" +
		"<i>The Brotherhood Without Banners.</i><br>"
	)
	HORN_HILL_TBWB ("06104"),
	@GraphQLEnumValue(description="" +
		"<h5>Donal Noye</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Steward.</i></b><br>" +
		"Bestow (3). No attachments except <i>Weapon</i>.<b>Action:</b> Discard 1 gold from Donal Noye to put a <i>Weapon</i> attachment into play from your hand..<br>" +
		"<i>The Brotherhood Without Banners.</i><br>"
	)
	DONAL_NOYE_TBWB ("06105"),
	@GraphQLEnumValue(description="" +
		"<h5>Ranger's Bow</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Weapon.</i></b><br>" +
		"[thenightswatch] character only.Attached character gets +1 STR.<b>Challenges Action:</b> Kneel Ranger's Bow to choose a defending [thenightswatch] character. Until the end of the challenge, that character gets +2 STR..<br>" +
		"<i>The Brotherhood Without Banners.</i><br>"
	)
	RANGERS_BOW_TBWB ("06106"),
	@GraphQLEnumValue(description="" +
		"<h5>Patchface</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Fool.</i></b><br>" +
		"While another <i>Fool</i> character has a keyword, Patchface gains that keyword.While another <i>Fool</i> character has a challenge icon, Patchface gains that challenge icon..<br>" +
		"<i>The Brotherhood Without Banners.</i><br>"
	)
	PATCHFACE_TBWB ("06107"),
	@GraphQLEnumValue(description="" +
		"<h5>King's Blood</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Condition.</i></b><br>" +
		"<i>Bastard</i> or <i>King</i> character you control only. Bestow (3).<b>Plot Action:</b> Kneel attached character and sacrifice King's Blood to discard X power from each opponent's faction card. X is the number of gold King's Blood has..<br>" +
		"<i>The Brotherhood Without Banners.</i><br>"
	)
	KINGS_BLOOD_TBWB ("06108"),
	@GraphQLEnumValue(description="" +
		"<h5>Genna Frey</h5>" +
		"House Lannister.<br>" +
		"<b><i>House Frey. Lady.</i></b><br>" +
		"<b>Reaction:</b> After you win a challenge in which Genna Frey is attacking, if it was the third challenge you initiated this phase, the losing opponent discards 1 card at random from his or her hand. (2 cards instead if you control another attacking <i>House Frey</i> character.).<br>" +
		"<i>The Brotherhood Without Banners.</i><br>"
	)
	GENNA_FREY_TBWB ("06109"),
	@GraphQLEnumValue(description="" +
		"<h5>The Goldroad</h5>" +
		"House Lannister.<br>" +
		"<b><i>Westeros.</i></b><br>" +
		"Limited.<b>Challenges Action:</b> Kneel The Goldroad to gain 1 gold.+1 Income..<br>" +
		"<i>The Brotherhood Without Banners.</i><br>"
	)
	THE_GOLDROAD_TBWB ("06110"),
	@GraphQLEnumValue(description="" +
		"<h5>Stony Shore Raider</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Ironborn. Raider.</i></b><br>" +
		"Bestow (3).<b>Action:</b> Discard 1 gold from Stony Shore Raider to choose and kneel a location with printed cost 3 or lower. (Limit once per round.).<br>" +
		"<i>The Brotherhood Without Banners.</i><br>"
	)
	STONY_SHORE_RAIDER_TBWB ("06111"),
	@GraphQLEnumValue(description="" +
		"<h5>Pay The Iron Price</h5>" +
		"House Greyjoy.<br>" +
		"<b>Challenges Action:</b> Choose an attachment in an opponent's discard pile, and put it into play under your control.<b>Reaction:</b> After you win an unopposed challenge, pay 1 gold to return Pay The Iron Price from your discard pile to your hand..<br>" +
		"<i>The Brotherhood Without Banners.</i><br>"
	)
	PAY_THE_IRON_PRICE_TBWB ("06112"),
	@GraphQLEnumValue(description="" +
		"<h5>Freedmen</h5>" +
		"House Targaryen.<br>" +
		"<b><i>Ally.</i></b><br>" +
		"<b>Reaction:</b> After you win a challenge by 5 or more STR as the attacking player, put Freedmen into play from your discard pile..<br>" +
		"<i>The Brotherhood Without Banners.</i><br>"
	)
	FREEDMEN_TBWB ("06113"),
	@GraphQLEnumValue(description="" +
		"<h5>Warrior's Braid</h5>" +
		"House Targaryen.<br>" +
		"<b><i>Item.</i></b><br>" +
		"[targaryen] character only.Attached character gains renown, and gets +1 STR for each bell token on Warrior's Braid.<b>Reaction:</b> After you win a [military] challenge in which attached character is attacking, place a bell token on Warrior's Braid..<br>" +
		"<i>The Brotherhood Without Banners.</i><br>"
	)
	WARRIORS_BRAID_TBWB ("06114"),
	@GraphQLEnumValue(description="" +
		"<h5>Dornish Spy</h5>" +
		"House Martell.<br>" +
		"<b><i>Spy.</i></b><br>" +
		"Ambush (4).<b>Reaction:</b> After Dornish Spy enters play, choose a character. Until the end of the phase, that character loses a challenge icon of your choice..<br>" +
		"<i>The Brotherhood Without Banners.</i><br>"
	)
	DORNISH_SPY_TBWB ("06115"),
	@GraphQLEnumValue(description="" +
		"<h5>Locked Away</h5>" +
		"House Martell.<br>" +
		"<b><i>Condition.</i></b><br>" +
		"Terminal.<b>Reaction:</b> After the marshaling phase begins, return attached character to its owner's hand (cannot be saved)..<br>" +
		"<i>The Brotherhood Without Banners.</i><br>"
	)
	LOCKED_AWAY_TBWB ("06116"),
	@GraphQLEnumValue(description="" +
		"<h5>Beric Dondarrion</h5>" +
		"Neutral.<br>" +
		"<b><i>Knight. Lord. R'hllor.</i></b><br>" +
		"Renown.X is the number of kiss tokens Beric Dondarrion has.<b>Forced Reaction:</b> After you marshal Beric Dondarrion, place 6 kiss tokens on him. (Cannot be canceled.)<b>Interrupt:</b> When Beric Dondarrion would be killed, discard a kiss token from him to save him..<br>" +
		"<i>The Brotherhood Without Banners.</i><br>"
	)
	BERIC_DONDARRION_TBWB ("06117"),
	@GraphQLEnumValue(description="" +
		"<h5>Unbridled Generosity</h5>" +
		"Neutral.<br>" +
		"<b>Action:</b> Choose up to 3 cards. Move 1 gold from the treasury to each of those cards..<br>" +
		"<i>The Brotherhood Without Banners.</i><br>"
	)
	UNBRIDLED_GENEROSITY_TBWB ("06118"),
	@GraphQLEnumValue(description="" +
		"<h5>The Brotherhood Without Banners</h5>" +
		"Neutral.<br>" +
		"You cannot include loyal characters in your deck.<b>Reaction:</b> After the challenges phase begins, kneel your faction card to choose a neutral character you control. Until the end of the phase, that character gains (choose one): insight, intimidate, renown, or stealth..<br>" +
		"<i>The Brotherhood Without Banners.</i><br>"
	)
	THE_BROTHERHOOD_WITHOUT_BANNERS_TBWB ("06119"),
	@GraphQLEnumValue(description="" +
		"<h5>Favors From the Crown</h5>" +
		"Neutral.<br>" +
		"<b><i>Kingdom.</i></b><br>" +
		"<b>Reaction:</b> After a card with bestow enters play, place 1 gold from the treasury on that card. (2 gold instead if that card has 3 or more gold on it.).<br>" +
		"<i>The Brotherhood Without Banners.</i><br>"
	)
	FAVORS_FROM_THE_CROWN_TBWB ("06120"),
	@GraphQLEnumValue(description="" +
		"<h5>Jon Snow (WotW)</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Bastard. Steward. Wildling.</i></b><br>" +
		"Stealth.<b>Reaction:</b> After you win a challenge in which Jon Snow is participating, either: stand each attacking <i>Wildling</i> character, or stand each defending [thenightswatch] character. (Limit once per phase.).<br>" +
		"<i>Watchers on the Wall.</i><br>"
	)
	JON_SNOW_WotW ("07001"),
	@GraphQLEnumValue(description="" +
		"<h5>Bowen Marsh</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Lord. Steward.</i></b><br>" +
		"During [intrigue] challenges, each <i>Steward</i> character you control gains insight.+1 Reserve..<br>" +
		"<i>Watchers on the Wall.</i><br>"
	)
	BOWEN_MARSH_WotW ("07002"),
	@GraphQLEnumValue(description="" +
		"<h5>Old Bear Mormont (WotW)</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Commander. Lord.</i></b><br>" +
		"<b>Reaction:</b> After you win a challenge in which Old Bear Mormont is participating, choose a non-unique character in the losing opponent's discard pile, and put it into play under your control..<br>" +
		"<i>Watchers on the Wall.</i><br>"
	)
	OLD_BEAR_MORMONT_WotW ("07003"),
	@GraphQLEnumValue(description="" +
		"<h5>Cotter Pyke</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Bastard. Commander. Ironborn.</i></b><br>" +
		"Stealth.<b>Reaction:</b> After Cotter Pyke bypasses a character using stealth, if there is a <i>Winter</i> plot card revealed, choose a [thenightswatch] character and have it gain stealth until the end of the phase..<br>" +
		"<i>Watchers on the Wall.</i><br>"
	)
	COTTER_PYKE_WotW ("07004"),
	@GraphQLEnumValue(description="" +
		"<h5>Maester Aemon (WotW)</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Maester. Steward.</i></b><br>" +
		"No attachments except <i>Item</i>.<b>Interrupt:</b> When the challenges phase ends, choose an opponent and a challenge type that has not been initiated against you this phase. That player must satisfy the claim of that challenge type as if you were the winning opponent..<br>" +
		"<i>Watchers on the Wall.</i><br>"
	)
	MAESTER_AEMON_WotW ("07005"),
	@GraphQLEnumValue(description="" +
		"<h5>Grizzled Miner</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Builder.</i></b><br>" +
		"No attachments except <i>Weapon</i>.Reduce the cost to marshal Grizzled Miner by 1 for each [thenightswatch] attachment and location you control (to a minimum of 1)..<br>" +
		"<i>Watchers on the Wall.</i><br>"
	)
	GRIZZLED_MINER_WotW ("07006"),
	@GraphQLEnumValue(description="" +
		"<h5>Ser Denys Mallister</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Commander. Knight.</i></b><br>" +
		"While Ser Denys Mallister is defending, he gains renown..<br>" +
		"<i>Watchers on the Wall.</i><br>"
	)
	SER_DENYS_MALLISTER_WotW ("07007"),
	@GraphQLEnumValue(description="" +
		"<h5>Ser Jaremy Rykker</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Knight. Ranger.</i></b><br>" +
		"No attachments except <i>Weapon</i>.Each other <i>Ranger</i> character you control gains a [power] icon..<br>" +
		"<i>Watchers on the Wall.</i><br>"
	)
	SER_JAREMY_RYKKER_WotW ("07008"),
	@GraphQLEnumValue(description="" +
		"<h5>Castle Black Mason</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Builder.</i></b><br>" +
		"No attachments except <i>Weapon</i>.<b>Action:</b> Kneel 2 <i>Builder</i> characters to search the top 10 cards of your deck for a location or attachment, reveal it, and add it to your hand. Shuffle your deck. (Limit twice per round.).<br>" +
		"<i>Watchers on the Wall.</i><br>"
	)
	CASTLE_BLACK_MASON_WotW ("07009"),
	@GraphQLEnumValue(description="" +
		"<h5>Grenn</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Ranger.</i></b><br>" +
		"No attachments except <i>Weapon</i>.<b>Reaction:</b> After you win a challenge in which Grenn is attacking, move 1 power from the losing opponent's faction card to another attacking [thenightswatch] character. (Up to 2 power instead if that character is standing.).<br>" +
		"<i>Watchers on the Wall.</i><br>"
	)
	GRENN_WotW ("07010"),
	@GraphQLEnumValue(description="" +
		"<h5>Pyp</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Ranger.</i></b><br>" +
		"No attachments except <i>Weapon</i>.<b>Reaction:</b> After you win a challenge in which Pyp is attacking, choose another attacking [thenightswatch] character. That character gains insight until the end of the phase..<br>" +
		"<i>Watchers on the Wall.</i><br>"
	)
	PYP_WotW ("07011"),
	@GraphQLEnumValue(description="" +
		"<h5>Samwell Tarly (WotW)</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Steward.</i></b><br>" +
		"While Samwell Tarly is participating in a challenge, treat each other participating non-<i>Steward</i> character as if its printed text box were blank (except for <i>Traits</i>)..<br>" +
		"<i>Watchers on the Wall.</i><br>"
	)
	SAMWELL_TARLY_WotW ("07012"),
	@GraphQLEnumValue(description="" +
		"<h5>Satin</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Steward.</i></b><br>" +
		"No attachments except <i>Weapon</i>.<b>Reaction:</b> After Satin is knelt, choose and stand another <i>Steward</i> character. (Limit twice per phase.).<br>" +
		"<i>Watchers on the Wall.</i><br>"
	)
	SATIN_WotW ("07013"),
	@GraphQLEnumValue(description="" +
		"<h5>Lost Ranger</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Ranger.</i></b><br>" +
		"No attachments except <i>Weapon</i>.<b>Forced Interrupt:</b> When the challenges phase ends, if you control no other <i>Ranger</i> characters, sacrifice Lost Ranger..<br>" +
		"<i>Watchers on the Wall.</i><br>"
	)
	LOST_RANGER_WotW ("07014"),
	@GraphQLEnumValue(description="" +
		"<h5>Seasoned Woodsman</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Builder.</i></b><br>" +
		"<b>Reaction:</b> After you attach an attachment to Seasoned Woodsman, either: gain 1 gold, or draw 1 card. (Limit twice per phase.).<br>" +
		"<i>Watchers on the Wall.</i><br>"
	)
	SEASONED_WOODSMAN_WotW ("07015"),
	@GraphQLEnumValue(description="" +
		"<h5>Builder at the Wall</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Builder.</i></b><br>" +
		"<b>Marshaling Action:</b> Kneel Builder at the Wall to reduce the cost of the next [thenightswatch] attachment or location you marshal this phase by 1..<br>" +
		"<i>Watchers on the Wall.</i><br>"
	)
	BUILDER_AT_THE_WALL_WotW ("07016"),
	@GraphQLEnumValue(description="" +
		"<h5>The New Gift</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>The North.</i></b><br>" +
		"Limited.<b>Marshaling Action:</b> Kneel a <i>Steward</i> character to gain 1 gold. (Limit twice per phase.)<b>Challenges Action:</b> Kneel a <i>Steward</i> character to draw 1 card. (Limit twice per phase.).<br>" +
		"<i>Watchers on the Wall.</i><br>"
	)
	THE_NEW_GIFT_WotW ("07017"),
	@GraphQLEnumValue(description="" +
		"<h5>Abandoned Stronghold</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Stronghold. The North.</i></b><br>" +
		"<b>Action:</b> Kneel Abandoned Stronghold to choose a defending character. Until the end of the challenge, that character gets +X STR. X is the number of <i>Builder</i> characters you control..<br>" +
		"<i>Watchers on the Wall.</i><br>"
	)
	ABANDONED_STRONGHOLD_WotW ("07018"),
	@GraphQLEnumValue(description="" +
		"<h5>Queenscrown</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>The North.</i></b><br>" +
		"<b>Action:</b> Kneel Queenscrown to reveal the top 3 cards of an opponent's deck. Choose up to 1 character revealed this way and place it in that player's discard pile. Place the other cards on the bottom of that player's deck in any order..<br>" +
		"<i>Watchers on the Wall.</i><br>"
	)
	QUEENSCROWN_WotW ("07019"),
	@GraphQLEnumValue(description="" +
		"<h5>Catapult on the Wall</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Weapon.</i></b><br>" +
		"<b>Action:</b> Kneel Catapult on the Wall and attached character to choose and kill an attacking character with STR 4 or lower. Attached character cannot stand during the standing phase this round..<br>" +
		"<i>Watchers on the Wall.</i><br>"
	)
	CATAPULT_ON_THE_WALL_WotW ("07020"),
	@GraphQLEnumValue(description="" +
		"<h5>Ghost (WotW)</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Direwolf.</i></b><br>" +
		"[thenightswatch] or [stark] character only.<b>Interrupt:</b> When attached character would be killed, return Ghost to your hand to save that character..<br>" +
		"<i>Watchers on the Wall.</i><br>"
	)
	GHOST_WotW ("07021"),
	@GraphQLEnumValue(description="" +
		"<h5>Sworn to the Watch</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Condition.</i></b><br>" +
		"Attached character gains the [thenightswatch] affiliation.While attached character has:- a [military] icon, it gains the <i>Ranger</i> trait.- an [intrigue] icon, it gains the <i>Steward</i> trait.- a [power] icon, it gains the <i>Builder</i> trait..<br>" +
		"<i>Watchers on the Wall.</i><br>"
	)
	SWORN_TO_THE_WATCH_WotW ("07022"),
	@GraphQLEnumValue(description="" +
		"<h5>Now My Watch Begins</h5>" +
		"The Night's Watch.<br>" +
		"<b>Reaction:</b> After a character with printed cost 5 or lower is placed in an opponent's discard pile, put that character into play under your control..<br>" +
		"<i>Watchers on the Wall.</i><br>"
	)
	NOW_MY_WATCH_BEGINS_WotW ("07023"),
	@GraphQLEnumValue(description="" +
		"<h5>I Shall Win No Glory</h5>" +
		"The Night's Watch.<br>" +
		"<b>Reaction:</b> After a challenge is initiated against you, kneel 3 <i>Builder</i> characters, 3 <i>Ranger</i> characters, or 3 <i>Steward</i> characters to end the challenge immediately with no winner or loser..<br>" +
		"<i>Watchers on the Wall.</i><br>"
	)
	I_SHALL_WIN_NO_GLORY_WotW ("07024"),
	@GraphQLEnumValue(description="" +
		"<h5>Marya Seaworth</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Companion. Lady.</i></b><br>" +
		"<b>Reaction:</b> After a character is bypassed using stealth, pay 1 gold to kneel it. (Limit twice per phase.).<br>" +
		"<i>Watchers on the Wall.</i><br>"
	)
	MARYA_SEAWORTH_WotW ("07025"),
	@GraphQLEnumValue(description="" +
		"<h5>Black Betha</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Warship.</i></b><br>" +
		"While you control Ser Davos Seaworth, he gains renown.<b>Action:</b> Kneel Black Betha to choose an attacking character. Until the end of the challenge, that character gets +X STR. X is the number of kneeling characters the defending player controls..<br>" +
		"<i>Watchers on the Wall.</i><br>"
	)
	BLACK_BETHA_WotW ("07026"),
	@GraphQLEnumValue(description="" +
		"<h5>Salt Wife</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Companion.</i></b><br>" +
		"<b>Challenges Action:</b> Sacrifice Salt Wife to choose a character. Until the end of the phase, that character cannot be declared as a defender..<br>" +
		"<i>Watchers on the Wall.</i><br>"
	)
	SALT_WIFE_WotW ("07027"),
	@GraphQLEnumValue(description="" +
		"<h5>Raiding the Bay of Ice</h5>" +
		"House Greyjoy.<br>" +
		"<b>Reaction:</b> After you win a challenge as the attacking player, kneel a <i>Warship</i> location to choose a non-limited location controlled by the losing opponent, and place it on top of its owner's deck..<br>" +
		"<i>Watchers on the Wall.</i><br>"
	)
	RAIDING_THE_BAY_OF_ICE_WotW ("07028"),
	@GraphQLEnumValue(description="" +
		"<h5>Ulf Son of Umar</h5>" +
		"House Lannister.<br>" +
		"<b><i>Clansman.</i></b><br>" +
		"<b>Reaction:</b> After a <i>Clansman</i> character enters play under your control, Ulf Son of Umar gets +X STR until the end of the phase. X is that character's printed STR. (Limit 3 times per phase.).<br>" +
		"<i>Watchers on the Wall.</i><br>"
	)
	ULF_SON_OF_UMAR_WotW ("07029"),
	@GraphQLEnumValue(description="" +
		"<h5>There Are No Men Like Me</h5>" +
		"House Lannister.<br>" +
		"<b>Action:</b> Choose a <i>Knight</i> character. Until the end of the phase, that character does not kneel when declared as an attacker or defender in a [military] challenge..<br>" +
		"<i>Watchers on the Wall.</i><br>"
	)
	THERE_ARE_NO_MEN_LIKE_ME_WotW ("07030"),
	@GraphQLEnumValue(description="" +
		"<h5>Southron Messenger</h5>" +
		"House Martell.<br>" +
		"<b><i>Ally.</i></b><br>" +
		"Ambush (5).<b>Reaction:</b> After Southron Messenger enters play during a challenge, choose a participating character with fewer than 2 challenge icons, and return that character to its owner's hand..<br>" +
		"<i>Watchers on the Wall.</i><br>"
	)
	SOUTHRON_MESSENGER_WotW ("07031"),
	@GraphQLEnumValue(description="" +
		"<h5>Lingering Venom</h5>" +
		"House Martell.<br>" +
		"<b><i>Condition.</i></b><br>" +
		"Terminal.<b>Reaction:</b> After you lose a challenge, place a venom token on Lingering Venom. Then, if attached character's STR is equal to or lower than the number of venom tokens on Lingering Venom, kill it..<br>" +
		"<i>Watchers on the Wall.</i><br>"
	)
	LINGERING_VENOM_WotW ("07032"),
	@GraphQLEnumValue(description="" +
		"<h5>Jeyne Poole</h5>" +
		"House Stark.<br>" +
		"<b><i>Companion.</i></b><br>" +
		"<b>Marshaling Action:</b> Sacrifice Jeyne Poole to return a <i>Lady</i> character from your discard pile to your hand..<br>" +
		"<i>Watchers on the Wall.</i><br>"
	)
	JEYNE_POOLE_WotW ("07033"),
	@GraphQLEnumValue(description="" +
		"<h5>Summer (WotW)</h5>" +
		"House Stark.<br>" +
		"<b><i>Direwolf.</i></b><br>" +
		"Unique [stark] character only.<b>Action:</b> Kneel attached character to have it participate in a [military] challenge on your side. (Limit once per challenge.)<b>Action:</b> Pay 1 gold to attach Summer to a different character. (Limit once per phase.).<br>" +
		"<i>Watchers on the Wall.</i><br>"
	)
	SUMMER_WotW ("07034"),
	@GraphQLEnumValue(description="" +
		"<h5>Dothraki Honor Guard</h5>" +
		"House Targaryen.<br>" +
		"<b><i>Army. Dothraki. Guard.</i></b><br>" +
		"No attachments.Dothraki Honor Guard gets -1 STR for each card in your hand..<br>" +
		"<i>Watchers on the Wall.</i><br>"
	)
	DOTHRAKI_HONOR_GUARD_WotW ("07035"),
	@GraphQLEnumValue(description="" +
		"<h5>Plaza of Pride</h5>" +
		"House Targaryen.<br>" +
		"<b><i>Astapor.</i></b><br>" +
		"<b>Action:</b> Kneel Plaza of Pride and discard a card from your hand to choose and stand a character with printed cost X or lower. X is 3 higher than the printed cost of the discarded card..<br>" +
		"<i>Watchers on the Wall.</i><br>"
	)
	PLAZA_OF_PRIDE_WotW ("07036"),
	@GraphQLEnumValue(description="" +
		"<h5>Ser Jon Fossoway</h5>" +
		"House Tyrell.<br>" +
		"<b><i>Knight.</i></b><br>" +
		"While Ser Jon Fossoway's STR is 5 or higher, he gains renown..<br>" +
		"<i>Watchers on the Wall.</i><br>"
	)
	SER_JON_FOSSOWAY_WotW ("07037"),
	@GraphQLEnumValue(description="" +
		"<h5>The Honeywine</h5>" +
		"House Tyrell.<br>" +
		"<b><i>The Reach.</i></b><br>" +
		"<b>Reaction:</b> After you win a challenge by 5 or more STR as the attacking player, The Honeywine gains 1 power..<br>" +
		"<i>Watchers on the Wall.</i><br>"
	)
	THE_HONEYWINE_WotW ("07038"),
	@GraphQLEnumValue(description="" +
		"<h5>Rattleshirt</h5>" +
		"Neutral.<br>" +
		"<b><i>Wildling.</i></b><br>" +
		"While Rattleshirt is attacking alone, each character without attachments cannot be declared as a defender..<br>" +
		"<i>Watchers on the Wall.</i><br>"
	)
	RATTLESHIRT_WotW ("07039"),
	@GraphQLEnumValue(description="" +
		"<h5>Dalla</h5>" +
		"Neutral.<br>" +
		"<b><i>Wildling.</i></b><br>" +
		"<b>Reaction:</b> After a <i>Wildling</i> character enters play under your control, draw 1 card. (Limit once per phase.).<br>" +
		"<i>Watchers on the Wall.</i><br>"
	)
	DALLA_WotW ("07040"),
	@GraphQLEnumValue(description="" +
		"<h5>Crow Killers</h5>" +
		"Neutral.<br>" +
		"<b><i>Wildling.</i></b><br>" +
		"Crow Killers does not kneel when declared as an attacker against an opponent whose reserve value is higher than yours..<br>" +
		"<i>Watchers on the Wall.</i><br>"
	)
	CROW_KILLERS_WotW ("07041"),
	@GraphQLEnumValue(description="" +
		"<h5>The Frozen Shore</h5>" +
		"Neutral.<br>" +
		"<b><i>The North.</i></b><br>" +
		"<b>Reaction:</b> After you win a challenge, kneel The Frozen Shore to choose and stand 1 attacking <i>Wildling</i> character for each <i>Winter</i> plot card revealed..<br>" +
		"<i>Watchers on the Wall.</i><br>"
	)
	THE_FROZEN_SHORE_WotW ("07042"),
	@GraphQLEnumValue(description="" +
		"<h5>Weirwood Bow</h5>" +
		"Neutral.<br>" +
		"<b><i>Weapon.</i></b><br>" +
		"[thenightswatch] or <i>Wildling</i> character only.<b>Action:</b> Kneel Weirwood Bow to choose a defending character. That character gets -2 STR until the end of the challenge..<br>" +
		"<i>Watchers on the Wall.</i><br>"
	)
	WEIRWOOD_BOW_WotW ("07043"),
	@GraphQLEnumValue(description="" +
		"<h5>Scaling the Wall</h5>" +
		"Neutral.<br>" +
		"<b>Reaction:</b> After you win a challenge in which you control an attacking <i>Wildling</i> character, choose a non-limited location controlled by the losing opponent. Return that location to its owner's hand..<br>" +
		"<i>Watchers on the Wall.</i><br>"
	)
	SCALING_THE_WALL_WotW ("07044"),
	@GraphQLEnumValue(description="" +
		"<h5>\"The Last of the Giants\"</h5>" +
		"Neutral.<br>" +
		"<b><i>Song.</i></b><br>" +
		"<b>Action:</b> Put a neutral character into play from your hand. Until the end of the phase, that character gains intimidate. At the end of the phase, if that character is still in play, kill it (cannot be saved)..<br>" +
		"<i>Watchers on the Wall.</i><br>"
	)
	THE_LAST_OF_THE_GIANTS_WotW ("07045"),
	@GraphQLEnumValue(description="" +
		"<h5>The Fire That Burns</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Winter.</i></b><br>" +
		"Each [thenightswatch] character you control does not kneel when declared as a defender..<br>" +
		"<i>Watchers on the Wall.</i><br>"
	)
	THE_FIRE_THAT_BURNS_WotW ("07046"),
	@GraphQLEnumValue(description="" +
		"<h5>Retaliation</h5>" +
		"Neutral.<br>" +
		"<b><i>War.</i></b><br>" +
		"If you win initiative, you must choose an opponent to be the first player..<br>" +
		"<i>Watchers on the Wall.</i><br>"
	)
	RETALIATION_WotW ("07047"),
	@GraphQLEnumValue(description="" +
		"<h5>Whisper Campaign</h5>" +
		"Neutral.<br>" +
		"<b><i>Scheme.</i></b><br>" +
		"<b>Forced Reaction:</b> After a character without an [intrigue] icon enters play, kneel it..<br>" +
		"<i>Watchers on the Wall.</i><br>"
	)
	WHISPER_CAMPAIGN_WotW ("07048"),
	@GraphQLEnumValue(description="" +
		"<h5>Called Into Service</h5>" +
		"Neutral.<br>" +
		"<b><i>Kingdom.</i></b><br>" +
		"<b>When Revealed:</b> Reveal the top card of your deck. If it is a character, put it into play. If it is a non-character card, draw it and gain 2 gold..<br>" +
		"<i>Watchers on the Wall.</i><br>"
	)
	CALLED_INTO_SERVICE_WotW ("07049"),
	@GraphQLEnumValue(description="" +
		"<h5>The White Shadows</h5>" +
		"Neutral.<br>" +
		"<b><i>Omen.</i></b><br>" +
		"<b>Reaction:</b> After a character an opponent controls is killed, put it into play under your control. While that character is in play, treat its printed text box as if it were blank. At the end of the phase, if that card is still in play, place it in its owner's dead pile (cannot be saved)..<br>" +
		"<i>Watchers on the Wall.</i><br>"
	)
	THE_WHITE_SHADOWS_WotW ("07050"),
	@GraphQLEnumValue(description="" +
		"<h5>Name Day Tourney</h5>" +
		"Neutral.<br>" +
		"<b><i>Summer.</i></b><br>" +
		"<b>Reaction:</b> After you win a challenge in which a <i>Knight</i> character you control is attacking or defending alone, choose a <i>Lord</i> or <i>Lady</i> character you control and have it gain 1 power..<br>" +
		"<i>Watchers on the Wall.</i><br>"
	)
	NAME_DAY_TOURNEY_WotW ("07051"),
	@GraphQLEnumValue(description="" +
		"<h5>Frozen Expanse</h5>" +
		"Neutral.<br>" +
		"<b><i>Winter.</i></b><br>" +
		"Each character with STR 2 or lower cannot stand..<br>" +
		"<i>Watchers on the Wall.</i><br>"
	)
	FROZEN_EXPANSE_WotW ("07052"),
	@GraphQLEnumValue(description="" +
		"<h5>Archmaester's Key</h5>" +
		"Neutral.<br>" +
		"<b><i>Item. Citadel.</i></b><br>" +
		"<i>Maester</i> character only.<b>Action:</b> Kneel attached character to choose an event in an opponent's discard pile. Once this phase, you may play that event as if it were in your hand. If you do, place it on the bottom of its owner's deck instead of placing it in that player's discard pile..<br>" +
		"<i>The Archmaester's Key.</i><br>"
	)
	ARCHMAESTERS_KEY_TAK ("08001"),
	@GraphQLEnumValue(description="" +
		"<h5>Dreadfort Maester</h5>" +
		"House Stark.<br>" +
		"<b><i>House Bolton. Maester.</i></b><br>" +
		"<b>Reaction:</b> After you initiate a [military] or [intrigue] challenge, sacrifice Dreadfort Maester to raise the claim value on your revealed plot card by 1 until the end of the challenge..<br>" +
		"<i>The Archmaester's Key.</i><br>"
	)
	DREADFORT_MAESTER_TAK ("08002"),
	@GraphQLEnumValue(description="" +
		"<h5>At Night They Howl</h5>" +
		"House Stark.<br>" +
		"<b>Challenges Action:</b> Choose and stand any number of <i>Direwolf</i> characters and characters with a <i>Direwolf</i> attachment..<br>" +
		"<i>The Archmaester's Key.</i><br>"
	)
	AT_NIGHT_THEY_HOWL_TAK ("08003"),
	@GraphQLEnumValue(description="" +
		"<h5>Septa Nysterica</h5>" +
		"House Tyrell.<br>" +
		"<b><i>The Seven.</i></b><br>" +
		"<b>Action:</b> Kneel Septa Nysterica to choose an attacking character with STR 4 or lower. Stand that character and remove it from the challenge..<br>" +
		"<i>The Archmaester's Key.</i><br>"
	)
	SEPTA_NYSTERICA_TAK ("08004"),
	@GraphQLEnumValue(description="" +
		"<h5>Oathkeeper</h5>" +
		"House Tyrell.<br>" +
		"<b><i>Valyrian Steel. Weapon.</i></b><br>" +
		"Attached character gets +2 STR.<b>Reaction:</b> After you win a challenge by 5 or more STR in which attached character is participating, sacrifice Oathkeeper to search your deck for a non-[tyrell] character, reveal it, and add it to your hand. Shuffle your deck..<br>" +
		"<i>The Archmaester's Key.</i><br>"
	)
	OATHKEEPER_TAK ("08005"),
	@GraphQLEnumValue(description="" +
		"<h5>Young Builder</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Builder.</i></b><br>" +
		"Bestow (3). No attachments except <i>Weapon</i>.<b>Reaction:</b> After a [thenightswatch] location or attachment enters play under your control, discard 1 gold from Young Builder to draw 1 card..<br>" +
		"<i>The Archmaester's Key.</i><br>"
	)
	YOUNG_BUILDER_TAK ("08006"),
	@GraphQLEnumValue(description="" +
		"<h5>\"The Rat Cook\"</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Song.</i></b><br>" +
		"<b>Marshaling Action:</b> Choose a character with printed cost X or lower. X is the number of Steward characters you control. Until the end of the round, take control of that character, and treat its printed text box as if it were blank (except for Traits)..<br>" +
		"<i>The Archmaester's Key.</i><br>"
	)
	THE_RAT_COOK_TAK ("08007"),
	@GraphQLEnumValue(description="" +
		"<h5>Queen's Men</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Ally. R'hllor.</i></b><br>" +
		"<b>Reaction:</b> After you marshal Queen's Men, choose an opponent and look at his or her hand. Then, you may kneel a non-[baratheon] character to choose and discard 1 non-character card from that hand..<br>" +
		"<i>The Archmaester's Key.</i><br>"
	)
	QUEENS_MEN_TAK ("08008"),
	@GraphQLEnumValue(description="" +
		"<h5>Traitor to the Crown</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Condition.</i></b><br>" +
		"Opponent's character only.Attached character does not contribute its STR to [power] challenges or to its controller's total for dominance..<br>" +
		"<i>The Archmaester's Key.</i><br>"
	)
	TRAITOR_TO_THE_CROWN_TAK ("08009"),
	@GraphQLEnumValue(description="" +
		"<h5>Maester at the Rock</h5>" +
		"House Lannister.<br>" +
		"<b><i>Maester.</i></b><br>" +
		"<b>Reaction:</b> After you play a [lannister] event, kneel Maester at the Rock to move that event from your discard pile to the top of your deck..<br>" +
		"<i>The Archmaester's Key.</i><br>"
	)
	MAESTER_AT_THE_ROCK_TAK ("08010"),
	@GraphQLEnumValue(description="" +
		"<h5>Ashemark</h5>" +
		"House Lannister.<br>" +
		"<b><i>The Westerlands.</i></b><br>" +
		"Bestow (3).<b>Reaction:</b> After a phase begins, kneel and sacrifice Ashemark to return each character with printed cost X or lower to its owner's hand. X is the number of gold on Ashemark..<br>" +
		"<i>The Archmaester's Key.</i><br>"
	)
	ASHEMARK_TAK ("08011"),
	@GraphQLEnumValue(description="" +
		"<h5>Acolyte of the Waves</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Drowned God.</i></b><br>" +
		"<b>Interrupt:</b> When Acolyte of the Waves is killed, gain 1 power for your faction..<br>" +
		"<i>The Archmaester's Key.</i><br>"
	)
	ACOLYTE_OF_THE_WAVES_TAK ("08012"),
	@GraphQLEnumValue(description="" +
		"<h5>Nagga's Ribs</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Iron Islands.</i></b><br>" +
		"For each character in your dead pile, Nagga's Ribs contributes 2 STR to your total for dominance.<b>Reaction:</b> After a character is placed in your discard pile, move it to your dead pile..<br>" +
		"<i>The Archmaester's Key.</i><br>"
	)
	NAGGAS_RIBS_TAK ("08013"),
	@GraphQLEnumValue(description="" +
		"<h5>Daario Naharis</h5>" +
		"House Targaryen.<br>" +
		"<b><i>Companion. Mercenary.</i></b><br>" +
		"Renown.<b>Reaction:</b> After you win a challenge in which Daario Naharis is attacking, choose another <i>Ally</i>, <i>Companion</i>, or <i>Mercenary</i> character. Stand that character and take control of it until the end of the phase..<br>" +
		"<i>The Archmaester's Key.</i><br>"
	)
	DAARIO_NAHARIS_TAK ("08014"),
	@GraphQLEnumValue(description="" +
		"<h5>Bloody Arakh</h5>" +
		"House Targaryen.<br>" +
		"<b><i>Weapon.</i></b><br>" +
		"<i>Dothraki</i> character only.<b>Reaction:</b> After you win a [military] challenge in which attached character is attacking, sacrifice Bloody Arakh. Then, you may initiate an additional [military] challenge this phase. (Max 1 per phase.).<br>" +
		"<i>The Archmaester's Key.</i><br>"
	)
	BLOODY_ARAKH_TAK ("08015"),
	@GraphQLEnumValue(description="" +
		"<h5>Dorea Sand</h5>" +
		"House Martell.<br>" +
		"<b><i>Bastard. Sand Snake.</i></b><br>" +
		"<b>Reaction:</b> After Dorea Sand enters play, choose another character with printed cost X or lower and return it to its owner's hand. X is the number of <i>Sand Snake</i> characters you control..<br>" +
		"<i>The Archmaester's Key.</i><br>"
	)
	DOREA_SAND_TAK ("08016"),
	@GraphQLEnumValue(description="" +
		"<h5>The Water Gardens</h5>" +
		"House Martell.<br>" +
		"<b><i>Dorne.</i></b><br>" +
		"<b>Action:</b> Kneel The Water Gardens to reduce the cost of the next non-character card you marshal, play, or ambush this phase by X. X is the number of plot cards in your used pile..<br>" +
		"<i>The Archmaester's Key.</i><br>"
	)
	THE_WATER_GARDENS_TAK ("08017"),
	@GraphQLEnumValue(description="" +
		"<h5>Mag the Mighty</h5>" +
		"Neutral.<br>" +
		"<b><i>Giant. Wildling.</i></b><br>" +
		"Renown. No attachments except <i>Weapon</i>.<b>Forced Reaction:</b> After you win a challenge in which Mag the Mighty is participating, choose and kill a character you control. Then, the losing opponent chooses and kills a character he or she controls..<br>" +
		"<i>The Archmaester's Key.</i><br>"
	)
	MAG_THE_MIGHTY_TAK ("08018"),
	@GraphQLEnumValue(description="" +
		"<h5>The Iron Bank</h5>" +
		"Neutral.<br>" +
		"<b><i>Braavos.</i></b><br>" +
		"Bestow (1).During the marshaling phase, you may spend gold on The Iron Bank as if it were in your gold pool.<b>Reaction:</b> After you collect income, move X gold from the treasury to The Iron Bank. X is the number of gold on The Iron Bank..<br>" +
		"<i>The Archmaester's Key.</i><br>"
	)
	THE_IRON_BANK_TAK ("08019"),
	@GraphQLEnumValue(description="" +
		"<h5>Valar Dohaeris</h5>" +
		"Neutral.<br>" +
		"<b><i>Omen.</i></b><br>" +
		"<b>When Revealed:</b> Each player chooses any number of characters he or she controls with a total printed cost of 10 or lower. Place each character not chosen on the bottom of its owner's deck (cannot be saved)..<br>" +
		"<i>The Archmaester's Key.</i><br>"
	)
	VALAR_DOHAERIS_TAK ("08020"),
	@GraphQLEnumValue(description="" +
		"<h5>Maege Mormont</h5>" +
		"House Stark.<br>" +
		"<b><i>House Mormont. Lady.</i></b><br>" +
		"Renown.<b>Reaction:</b> After you win a challenge in which you control a participating <i>House Mormont</i> character, reveal the top card of your deck. If it is a [stark] card, draw it..<br>" +
		"<i>Journey to Oldtown.</i><br>"
	)
	MAEGE_MORMONT_JtO ("08021"),
	@GraphQLEnumValue(description="" +
		"<h5>The House of Black and White</h5>" +
		"House Stark.<br>" +
		"<b><i>Braavos.</i></b><br>" +
		"Bestow (10).<b>Dominance Action:</b> Kneel The House of Black and White and discard X gold from it to choose and kill a character with printed STR X or lower (X cannot be 0). You may move any number of gold from your gold pool to The House of Black and White..<br>" +
		"<i>Journey to Oldtown.</i><br>"
	)
	THE_HOUSE_OF_BLACK_AND_WHITE_JtO ("08022"),
	@GraphQLEnumValue(description="" +
		"<h5>Brightwater Knight</h5>" +
		"House Tyrell.<br>" +
		"<b><i>House Florent. Knight.</i></b><br>" +
		"Bestow (3).<b>Marshaling Action:</b> Discard 1 gold from Brightwater Knight to reduce the cost of the next <i>Knight</i> character you marshal this phase by 2. (Limit once per phase.).<br>" +
		"<i>Journey to Oldtown.</i><br>"
	)
	BRIGHTWATER_KNIGHT_JtO ("08023"),
	@GraphQLEnumValue(description="" +
		"<h5>Oldtown</h5>" +
		"House Tyrell.<br>" +
		"<b><i>Oldtown. The Reach.</i></b><br>" +
		"<b>Action:</b> Kneel Oldtown to name a cardtype (character, location, attachment, or event). Then, reveal the top card of your deck. If the revealed card has that cardtype, draw it and gain 1 power for your faction..<br>" +
		"<i>Journey to Oldtown.</i><br>"
	)
	OLDTOWN_JtO ("08024"),
	@GraphQLEnumValue(description="" +
		"<h5>Dareon</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Minstrel. Steward.</i></b><br>" +
		"<b>Reaction:</b> After you play a <i>Song</i> event, choose an opponent. Move 1 gold from that player's gold pool to your own. (Limit once per phase.).<br>" +
		"<i>Journey to Oldtown.</i><br>"
	)
	DAREON_JtO ("08025"),
	@GraphQLEnumValue(description="" +
		"<h5>Journey to Oldtown</h5>" +
		"The Night's Watch.<br>" +
		"<b>Reaction:</b> After the plot phase begins, choose a character you control. Remove it from the game until the beginning of the next plot phase..<br>" +
		"<i>Journey to Oldtown.</i><br>"
	)
	JOURNEY_TO_OLDTOWN_JtO ("08026"),
	@GraphQLEnumValue(description="" +
		"<h5>Devan Seaworth</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Companion.</i></b><br>" +
		"Bestow (3).<b>Reaction:</b> After you win dominance, discard X gold from Devan Seaworth to search your deck for a non-limited location with printed cost X or lower, reveal it, and put it into play (X cannot be 0). Shuffle your deck..<br>" +
		"<i>Journey to Oldtown.</i><br>"
	)
	DEVAN_SEAWORTH_JtO ("08027"),
	@GraphQLEnumValue(description="" +
		"<h5>Stannis's Wrath</h5>" +
		"House Baratheon.<br>" +
		"<b>Action:</b> Choose and kneel a character without a [power] icon..<br>" +
		"<i>Journey to Oldtown.</i><br>"
	)
	STANNISS_WRATH_JtO ("08028"),
	@GraphQLEnumValue(description="" +
		"<h5>Black Ears</h5>" +
		"House Lannister.<br>" +
		"<b><i>Clansman.</i></b><br>" +
		"<b>Reaction:</b> After a character is killed, pay 2 gold to put Black Ears into play from your hand..<br>" +
		"<i>Journey to Oldtown.</i><br>"
	)
	BLACK_EARS_JtO ("08029"),
	@GraphQLEnumValue(description="" +
		"<h5>Kingslayer</h5>" +
		"House Lannister.<br>" +
		"<b><i>Title.</i></b><br>" +
		"<i>Kingsguard</i> character only. Terminal.<b>Action:</b> Kneel attached character to choose and kill a character with 2 or more power. (Limit once per game.)<b>Forced Interrupt:</b> When attached character leaves play, each opponent gains 2 power for his or her faction..<br>" +
		"<i>Journey to Oldtown.</i><br>"
	)
	KINGSLAYER_JtO ("08030"),
	@GraphQLEnumValue(description="" +
		"<h5>Tris Botley</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>House Botley. Lord.</i></b><br>" +
		"Pillage.<b>Action:</b> Choose a card in an opponent's discard pile and remove it from the game. Until Tris Botley leaves play, that player cannot marshal or play any copy of that card. (Limit once per round.).<br>" +
		"<i>Journey to Oldtown.</i><br>"
	)
	TRIS_BOTLEY_JtO ("08031"),
	@GraphQLEnumValue(description="" +
		"<h5>Black Wind</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Warship.</i></b><br>" +
		"While you control Asha Greyjoy, she gains renown.<b>Reaction:</b> After a character you control discards a location or attachment using pillage, draw 1 card. (Limit twice per phase.).<br>" +
		"<i>Journey to Oldtown.</i><br>"
	)
	BLACK_WIND_JtO ("08032"),
	@GraphQLEnumValue(description="" +
		"<h5>Stormcrows</h5>" +
		"House Targaryen.<br>" +
		"<b><i>Mercenary.</i></b><br>" +
		"Bestow (5).<b>Challenges Action:</b> Discard X gold from Stormcrows to choose X characters. Until the end of the phase, each of those characters gets -1 STR. (Limit once per phase.).<br>" +
		"<i>Journey to Oldtown.</i><br>"
	)
	STORMCROWS_JtO ("08033"),
	@GraphQLEnumValue(description="" +
		"<h5>Consuming Flames</h5>" +
		"House Targaryen.<br>" +
		"<b>Challenges Action:</b> Discard another [targaryen] card from your hand to choose a participating character. Until the end of the phase, that character gets -3 STR and is killed if its STR is 0..<br>" +
		"<i>Journey to Oldtown.</i><br>"
	)
	CONSUMING_FLAMES_JtO ("08034"),
	@GraphQLEnumValue(description="" +
		"<h5>Arianne Martell (JtO)</h5>" +
		"House Martell.<br>" +
		"<b><i>Lady.</i></b><br>" +
		"Insight.<b>Challenges Action:</b> Return Arianne Martell to your hand to choose a character with a lower STR than hers, and return it to its owner's hand..<br>" +
		"<i>Journey to Oldtown.</i><br>"
	)
	ARIANNE_MARTELL_JtO ("08035"),
	@GraphQLEnumValue(description="" +
		"<h5>Change of Plans</h5>" +
		"House Martell.<br>" +
		"<b>Reaction:</b> After you lose a challenge, if there are fewer than 5 plot cards in your used pile, move a card from your plot deck to the bottom of your used pile..<br>" +
		"<i>Journey to Oldtown.</i><br>"
	)
	CHANGE_OF_PLANS_JtO ("08036"),
	@GraphQLEnumValue(description="" +
		"<h5>Thoros of Myr</h5>" +
		"Neutral.<br>" +
		"<b><i>Brotherhood. R'hllor.</i></b><br>" +
		"Renown.<b>Interrupt:</b> When another non-loyal character you control would be killed, kneel Thoros of Myr and discard 1 power from him to save that character..<br>" +
		"<i>Journey to Oldtown.</i><br>"
	)
	THOROS_OF_MYR_JtO ("08037"),
	@GraphQLEnumValue(description="" +
		"<h5>Gates of the Moon</h5>" +
		"Neutral.<br>" +
		"<b><i>Contested. House Arryn.</i></b><br>" +
		"Limited.Increase the gold value on each opponent's revealed plot card by 1.+2 Income..<br>" +
		"<i>Journey to Oldtown.</i><br>"
	)
	GATES_OF_THE_MOON_JtO ("08038"),
	@GraphQLEnumValue(description="" +
		"<h5>The House With the Red Door</h5>" +
		"Neutral.<br>" +
		"<b><i>Dream.</i></b><br>" +
		"After all agendas are announced, search your deck for a non-limited unique location with printed cost 3 or lower and put it into play. That location cannot be discarded from play by card effects.You cannot spend more than 4 gold during setup..<br>" +
		"<i>Journey to Oldtown.</i><br>"
	)
	THE_HOUSE_WITH_THE_RED_DOOR_JtO ("08039"),
	@GraphQLEnumValue(description="" +
		"<h5>Sailing the Summer Sea</h5>" +
		"Neutral.<br>" +
		"<b><i>Summer.</i></b><br>" +
		"You may initiate an additional [power] challenge during the challenges phase. You cannot initiate [military] or [intrigue] challenges..<br>" +
		"<i>Journey to Oldtown.</i><br>"
	)
	SAILING_THE_SUMMER_SEA_JtO ("08040"),
	@GraphQLEnumValue(description="" +
		"<h5>Ramsay Snow</h5>" +
		"House Stark.<br>" +
		"<b><i>Bastard. House Bolton.</i></b><br>" +
		"<b>Forced Reaction:</b> After Ramsay Snow enters play, each player sacrifices a character, if able..<br>" +
		"<i>Kingsmoot.</i><br>"
	)
	RAMSAY_SNOW_Km ("08041"),
	@GraphQLEnumValue(description="" +
		"<h5>The Dreadfort</h5>" +
		"House Stark.<br>" +
		"<b><i>House Bolton. The North.</i></b><br>" +
		"<b>Reaction:</b> After a character you control is sacrificed, kneel The Dreadfort to choose and stand a <i>House Bolton</i> or non-[stark] character..<br>" +
		"<i>Kingsmoot.</i><br>"
	)
	THE_DREADFORT_Km ("08042"),
	@GraphQLEnumValue(description="" +
		"<h5>Ser Hyle Hunt</h5>" +
		"House Tyrell.<br>" +
		"<b><i>Knight.</i></b><br>" +
		"<b>Action:</b> During a challenge in which Ser Hyle Hunt is participating, pay 1 gold to choose a participating character with a lower STR than his. Stand that character and remove it from the challenge. (Limit once per challenge.).<br>" +
		"<i>Kingsmoot.</i><br>"
	)
	SER_HYLE_HUNT_Km ("08043"),
	@GraphQLEnumValue(description="" +
		"<h5>The Bounty of Highgarden</h5>" +
		"House Tyrell.<br>" +
		"Limited.<b>Action:</b> Gain 5 gold. (Cannot be canceled.).<br>" +
		"<i>Kingsmoot.</i><br>"
	)
	THE_BOUNTY_OF_HIGHGARDEN_Km ("08044"),
	@GraphQLEnumValue(description="" +
		"<h5>Haunted Forest Scout</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Ally. Ranger.</i></b><br>" +
		"No attachments except <i>Weapon</i>.Haunted Forest Scout cannot be declared as a defender.While you control 3 or more <i>Ranger</i> characters, Haunted Forest Scout does not kneel when declared as an attacker..<br>" +
		"<i>Kingsmoot.</i><br>"
	)
	HAUNTED_FOREST_SCOUT_Km ("08045"),
	@GraphQLEnumValue(description="" +
		"<h5>Mole's Town</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>The North.</i></b><br>" +
		"Bestow (4).<b>Challenges Action:</b> Kneel Mole's Town to choose a character without gold. Move 1 gold from Mole's Town to that character. Then, that character cannot be declared as an attacker until the end of the phase..<br>" +
		"<i>Kingsmoot.</i><br>"
	)
	MOLES_TOWN_Km ("08046"),
	@GraphQLEnumValue(description="" +
		"<h5>Lyseni Pirate</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Raider. Smuggler.</i></b><br>" +
		"While you control a <i>Warship</i> location, Lyseni Pirate gains stealth.<b>Reaction:</b> After you win a challenge in which Lyseni Pirate is attacking, move 1 gold from the losing opponent’s gold pool or a card that player controls to your gold pool..<br>" +
		"<i>Kingsmoot.</i><br>"
	)
	LYSENI_PIRATE_Km ("08047"),
	@GraphQLEnumValue(description="" +
		"<h5>Laughing Lord</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Warship.</i></b><br>" +
		"<b>Reaction:</b> After you initiate a challenge, kneel Laughing Lord to choose an attacking [baratheon] character. Until the end of the challenge, that character gains intimidate..<br>" +
		"<i>Kingsmoot.</i><br>"
	)
	LAUGHING_LORD_Km ("08048"),
	@GraphQLEnumValue(description="" +
		"<h5>Raff the Sweetling</h5>" +
		"House Lannister.<br>" +
		"<b><i>Ally.</i></b><br>" +
		"Pillage.<b>Reaction:</b> After Raff the Sweetling discards a character using pillage, choose a character with printed cost 2 or lower and return it to its owner’s hand..<br>" +
		"<i>Kingsmoot.</i><br>"
	)
	RAFF_THE_SWEETLING_Km ("08049"),
	@GraphQLEnumValue(description="" +
		"<h5>Sparring in Secret</h5>" +
		"House Lannister.<br>" +
		"<b>Action:</b> Kneel a <i>Knight</i> character to choose and stand another <i>Knight</i> character..<br>" +
		"<i>Kingsmoot.</i><br>"
	)
	SPARRING_IN_SECRET_Km ("08050"),
	@GraphQLEnumValue(description="" +
		"<h5>Asha Greyjoy (Km)</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Captain. Ironborn. Lady.</i></b><br>" +
		"Pillage. Stealth.<b>Reaction:</b> After Asha Greyjoy discards a card using pillage, search the top X cards of your deck for a card and add it to your hand. Shuffle your deck. X is the number of cards in the losing opponent's discard pile..<br>" +
		"<i>Kingsmoot.</i><br>"
	)
	ASHA_GREYJOY_Km ("08051"),
	@GraphQLEnumValue(description="" +
		"<h5>Kingsmoot</h5>" +
		"House Greyjoy.<br>" +
		"<b>Reaction:</b> After you win dominance, choose a unique [greyjoy] character you control. That character gains 1 power for each unique [greyjoy] character you control. (Max 1 per round.).<br>" +
		"<i>Kingsmoot.</i><br>"
	)
	KINGSMOOT_Km ("08052"),
	@GraphQLEnumValue(description="" +
		"<h5>Jhiqui</h5>" +
		"House Targaryen.<br>" +
		"<b><i>Companion. Dothraki.</i></b><br>" +
		"<b>Reaction:</b> After you win a challenge, discard 1 card from your hand to have a participating <i>Lord</i> or <i>Lady</i> character gain 1 power..<br>" +
		"<i>Kingsmoot.</i><br>"
	)
	JHIQUI_Km ("08053"),
	@GraphQLEnumValue(description="" +
		"<h5>The Skahazadhan</h5>" +
		"House Targaryen.<br>" +
		"<b><i>Essos.</i></b><br>" +
		"<b>Reaction:</b> After you reveal a plot card, kneel The Skahazadhan and discard 1 card from your hand to gain 2 gold. (3 gold instead if that plot card has the <i>Summer</i> trait.).<br>" +
		"<i>Kingsmoot.</i><br>"
	)
	THE_SKAHAZADHAN_Km ("08054"),
	@GraphQLEnumValue(description="" +
		"<h5>Darkstar (Km)</h5>" +
		"House Martell.<br>" +
		"<b><i>House Dayne. Knight.</i></b><br>" +
		"Stealth.<b>Reaction:</b> After Darkstar bypasses a character using stealth, that character loses a challenge icon of your choice until the end of the phase..<br>" +
		"<i>Kingsmoot.</i><br>"
	)
	DARKSTAR_Km ("08055"),
	@GraphQLEnumValue(description="" +
		"<h5>Sand Steed</h5>" +
		"House Martell.<br>" +
		"<b><i>Warhorse.</i></b><br>" +
		"Limit 1 copy per character.<b>Reaction:</b> After a <i>Summer</i> plot card enters your used pile, attached character gains 1 power..<br>" +
		"<i>Kingsmoot.</i><br>"
	)
	SAND_STEED_Km ("08056"),
	@GraphQLEnumValue(description="" +
		"<h5>Tom of Sevenstreams</h5>" +
		"Neutral.<br>" +
		"<b><i>Brotherhood. Minstrel. R'hllor.</i></b><br>" +
		"<b>Reaction:</b> After you play a <i>Song</i> event, choose and stand a non-loyal character you control. (Limit once per phase.).<br>" +
		"<i>Kingsmoot.</i><br>"
	)
	TOM_OF_SEVENSTREAMS_Km ("08057"),
	@GraphQLEnumValue(description="" +
		"<h5>Lem Lemoncloak</h5>" +
		"Neutral.<br>" +
		"<b><i>Brotherhood. R'hllor.</i></b><br>" +
		"While you control no loyal characters, Lem Lemoncloak gets +2 STR and gains a [power] icon..<br>" +
		"<i>Kingsmoot.</i><br>"
	)
	LEM_LEMONCLOAK_Km ("08058"),
	@GraphQLEnumValue(description="" +
		"<h5>Forgotten By History</h5>" +
		"Neutral.<br>" +
		"<b>Dominance Action:</b> Kneel your faction card to choose a character with printed cost X or lower, and shuffle it into its owner's deck. X is the amount of power on the faction card of that character's controller..<br>" +
		"<i>Kingsmoot.</i><br>"
	)
	FORGOTTEN_BY_HISTORY_Km ("08059"),
	@GraphQLEnumValue(description="" +
		"<h5>The Withering Cold</h5>" +
		"Neutral.<br>" +
		"<b><i>Winter.</i></b><br>" +
		"Skip the standing phase this round..<br>" +
		"<i>Kingsmoot.</i><br>"
	)
	THE_WITHERING_COLD_Km ("08060"),
	@GraphQLEnumValue(description="" +
		"<h5>Nymeria (FotOG)</h5>" +
		"House Stark.<br>" +
		"<b><i>Direwolf.</i></b><br>" +
		"Intimidate. No attachments.<b>Action:</b> During a challenge in which you control a participating [stark] character, kneel Nymeria and any number of other <i>Direwolf</i> characters to have each of those characters participate in the challenge on your side..<br>" +
		"<i>Favor of the Old Gods.</i><br>"
	)
	NYMERIA_FotOG ("08061"),
	@GraphQLEnumValue(description="" +
		"<h5>Favor of the Old Gods</h5>" +
		"House Stark.<br>" +
		"<b><i>Blessing. Old Gods.</i></b><br>" +
		"Attached character gains the <i>Old Gods</i> trait.<b>Action:</b> If each character, location, and attachment you control has the [stark] affiliation, kneel Favor of the Old Gods to stand attached character..<br>" +
		"<i>Favor of the Old Gods.</i><br>"
	)
	FAVOR_OF_THE_OLD_GODS_FotOG ("08062"),
	@GraphQLEnumValue(description="" +
		"<h5>Hightower Spy</h5>" +
		"House Tyrell.<br>" +
		"<b><i>House Hightower. Spy.</i></b><br>" +
		"Ambush (3).<b>Reaction:</b> After Hightower Spy enters play, choose a character and reveal the top card of your deck. Until the end of the phase, that character gets +X STR. X is the printed cost of the revealed card..<br>" +
		"<i>Favor of the Old Gods.</i><br>"
	)
	HIGHTOWER_SPY_FotOG ("08063"),
	@GraphQLEnumValue(description="" +
		"<h5>Blessed by the Maiden</h5>" +
		"House Tyrell.<br>" +
		"<b><i>Blessing. The Seven.</i></b><br>" +
		"Character you control only.Attached character gains <i>The Seven</i> trait and \"No attachments except <i>Blessing.</i>\".<br>" +
		"<i>Favor of the Old Gods.</i><br>"
	)
	BLESSED_BY_THE_MAIDEN_FotOG ("08064"),
	@GraphQLEnumValue(description="" +
		"<h5>Garrison on the Wall</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Army.</i></b><br>" +
		"No attachments.<b>Reaction:</b> After Garrison on the Wall is declared as a defender, kneel a non-[thenightswatch] character to stand Garrison on the Wall..<br>" +
		"<i>Favor of the Old Gods.</i><br>"
	)
	GARRISON_ON_THE_WALL_FotOG ("08065"),
	@GraphQLEnumValue(description="" +
		"<h5>Obsidian Arrows</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Weapon.</i></b><br>" +
		"Bestow (4).<b>Action:</b> While attached character is attacking, move 1 gold from Obsidian Arrows to a defending character to give that character –3 STR until the end of the challenge. (Limit once per challenge.).<br>" +
		"<i>Favor of the Old Gods.</i><br>"
	)
	OBSIDIAN_ARROWS_FotOG ("08066"),
	@GraphQLEnumValue(description="" +
		"<h5>Selyse Baratheon (FotOG)</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Lady. Queen. R'hllor.</i></b><br>" +
		"<b>Forced Reaction:</b> After you marshal Selyse Baratheon, kneel your faction card. Then, kneel each non-<i>Lady</i> character..<br>" +
		"<i>Favor of the Old Gods.</i><br>"
	)
	SELYSE_BARATHEON_FotOG ("08067"),
	@GraphQLEnumValue(description="" +
		"<h5>Dragonstone Castle</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Dragonstone. Stronghold.</i></b><br>" +
		"<b>Reaction:</b> After a phase begins, kneel Dragonstone Castle to choose a character. Until the end of the phase, that character cannot stand..<br>" +
		"<i>Favor of the Old Gods.</i><br>"
	)
	DRAGONSTONE_CASTLE_FotOG ("08068"),
	@GraphQLEnumValue(description="" +
		"<h5>Ser Balon Swann</h5>" +
		"House Lannister.<br>" +
		"<b><i>Kingsguard. Knight.</i></b><br>" +
		"Renown.<b>Reaction:</b> After a non-[lannister] Knight character enters play under your control, gain 2 gold. (Limit once per phase.).<br>" +
		"<i>Favor of the Old Gods.</i><br>"
	)
	SER_BALON_SWANN_FotOG ("08069"),
	@GraphQLEnumValue(description="" +
		"<h5>Sweet Cersei</h5>" +
		"House Lannister.<br>" +
		"<b><i>Warship.</i></b><br>" +
		"During the challenges phase, you may spend gold on Sweet Cersei as if it were in your gold pool.<b>Reaction:</b> After you win an [intrigue] challenge, move 1 gold from the treasury to Sweet Cersei..<br>" +
		"<i>Favor of the Old Gods.</i><br>"
	)
	SWEET_CERSEI_FotOG ("08070"),
	@GraphQLEnumValue(description="" +
		"<h5>Coastal Reaver</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Raider.</i></b><br>" +
		"<b>Reaction:</b> After Coastal Reaver enters play, choose an opponent. That player chooses a card in his or her hand and places it on top of his or her deck..<br>" +
		"<i>Favor of the Old Gods.</i><br>"
	)
	COASTAL_REAVER_FotOG ("08071"),
	@GraphQLEnumValue(description="" +
		"<h5>Support of Harlaw</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>House Harlaw.</i></b><br>" +
		"<b>Challenges Action:</b> Kneel a <i>Warship</i> location to have attached character gain (choose one): pillage, renown, or stealth until the end of the phase..<br>" +
		"<i>Favor of the Old Gods.</i><br>"
	)
	SUPPORT_OF_HARLAW_FotOG ("08072"),
	@GraphQLEnumValue(description="" +
		"<h5>Wise Master</h5>" +
		"House Targaryen.<br>" +
		"<b><i>Ally.</i></b><br>" +
		"Bestow (3).<b>Action:</b> Discard 1 gold from Wise Master to return an out-of-faction attachment or event from your discard pile to your hand. (Limit once per round.).<br>" +
		"<i>Favor of the Old Gods.</i><br>"
	)
	WISE_MASTER_FotOG ("08073"),
	@GraphQLEnumValue(description="" +
		"<h5>Yunkai</h5>" +
		"House Targaryen.<br>" +
		"<b><i>Essos.</i></b><br>" +
		"Bestow (4).<b>Action:</b> During a challenge in which you are the attacking player, kneel Yunkai and discard X gold from it to remove each character with STR X or lower from the challenge (X cannot be 0). Then, if you win the challenge, place 2 gold from the treasury on Yunkai..<br>" +
		"<i>Favor of the Old Gods.</i><br>"
	)
	YUNKAI_FotOG ("08074"),
	@GraphQLEnumValue(description="" +
		"<h5>Planky Town Trader</h5>" +
		"House Martell.<br>" +
		"<b><i>Merchant.</i></b><br>" +
		"Bestow (5).<b>Interrupt:</b> When Planky Town Trader leaves play, put a non-[martell] character with printed cost X or lower into play from your hand. X is the number of gold on Planky Town Trader. Until the end of the phase, that character cannot leave play..<br>" +
		"<i>Favor of the Old Gods.</i><br>"
	)
	PLANKY_TOWN_TRADER_FotOG ("08075"),
	@GraphQLEnumValue(description="" +
		"<h5>Shandystone</h5>" +
		"House Martell.<br>" +
		"<b><i>Dorne. Stronghold.</i></b><br>" +
		"<b>Reaction:</b> After you lose a challenge as the defending player, kneel Shandystone to choose and stand a character you control..<br>" +
		"<i>Favor of the Old Gods.</i><br>"
	)
	SHANDYSTONE_FotOG ("08076"),
	@GraphQLEnumValue(description="" +
		"<h5>Warrior's Sons</h5>" +
		"Neutral.<br>" +
		"<b><i>Army. The Seven.</i></b><br>" +
		"No attachments.<b>Reaction:</b> After an opponent plays an event during a challenge in which Warrior’s Sons is participating, move 1 power from that opponent’s faction card to Warrior’s Sons..<br>" +
		"<i>Favor of the Old Gods.</i><br>"
	)
	WARRIORS_SONS_FotOG ("08077"),
	@GraphQLEnumValue(description="" +
		"<h5>Seized by the Guard</h5>" +
		"Neutral.<br>" +
		"<b><i>Condition.</i></b><br>" +
		"Non-limited location only. Bestow (4). Terminal.Treat attached location as if its printed text box were blank (except for <i>Traits</i>).<b>Forced Reaction:</b> After the marshaling phase begins, sacrifice Seized by the Guard unless you discard 1 gold from it..<br>" +
		"<i>Favor of the Old Gods.</i><br>"
	)
	SEIZED_BY_THE_GUARD_FotOG ("08078"),
	@GraphQLEnumValue(description="" +
		"<h5>Greensight</h5>" +
		"Neutral.<br>" +
		"<b>Forced Reaction:</b> After the draw phase begins, reveal the top card of each player's deck. You may kneel your faction card to discard those cards..<br>" +
		"<i>Favor of the Old Gods.</i><br>"
	)
	GREENSIGHT_FotOG ("08079"),
	@GraphQLEnumValue(description="" +
		"<h5>The King in the North</h5>" +
		"Neutral.<br>" +
		"<b><i>Kingdom.</i></b><br>" +
		"While a player does not control a <i>King</i> character, he or she cannot trigger abilities on characters, locations, or attachments..<br>" +
		"<i>Favor of the Old Gods.</i><br>"
	)
	THE_KING_IN_THE_NORTH_FotOG ("08080"),
	@GraphQLEnumValue(description="" +
		"<h5>Arya Stark (TFM)</h5>" +
		"House Stark.<br>" +
		"<b><i>Lady.</i></b><br>" +
		"While Arya Stark is standing, characters cannot be saved..<br>" +
		"<i>The Faith Militant.</i><br>"
	)
	ARYA_STARK_TFM ("08081"),
	@GraphQLEnumValue(description="" +
		"<h5>I Am No One</h5>" +
		"House Stark.<br>" +
		"<b>Action:</b> Choose a character you control with printed cost 3 or lower. Until the end of the phase, that character loses all faction affiliations and <i>Traits</i>, gains insight and stealth, and does not kneel when declared as an attacker..<br>" +
		"<i>The Faith Militant.</i><br>"
	)
	I_AM_NO_ONE_TFM ("08082"),
	@GraphQLEnumValue(description="" +
		"<h5>Highgarden Refugee</h5>" +
		"House Tyrell.<br>" +
		"<b><i>Ally.</i></b><br>" +
		"While there is a <i>Summer</i> plot card revealed, reduce the cost to marshal Highgarden Refugee by 1..<br>" +
		"<i>The Faith Militant.</i><br>"
	)
	HIGHGARDEN_REFUGEE_TFM ("08083"),
	@GraphQLEnumValue(description="" +
		"<h5>Arbor Queen</h5>" +
		"House Tyrell.<br>" +
		"<b><i>Warship.</i></b><br>" +
		"<b>Action:</b> Kneel Arbor Queen to choose a [tyrell] character and a non-[tyrell] character. Until the end of the phase, each of those characters gets +2 STR..<br>" +
		"<i>The Faith Militant.</i><br>"
	)
	ARBOR_QUEEN_TFM ("08084"),
	@GraphQLEnumValue(description="" +
		"<h5>Coldhands</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>The North.</i></b><br>" +
		"Coldhands cannot be saved.<b>Reaction:</b> After you marshal Coldhands, choose 1 other non-<i>Army</i> character controlled by each player. Remove each of those characters from the game until Coldhands leaves play..<br>" +
		"<i>The Faith Militant.</i><br>"
	)
	COLDHANDS_TFM ("08085"),
	@GraphQLEnumValue(description="" +
		"<h5>The Bay of Seals</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>The North.</i></b><br>" +
		"<b>Action:</b> Kneel The Bay of Seals to choose and stand a character owned by an opponent..<br>" +
		"<i>The Faith Militant.</i><br>"
	)
	THE_BAY_OF_SEALS_TFM ("08086"),
	@GraphQLEnumValue(description="" +
		"<h5>King's Men</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Ally. The Seven.</i></b><br>" +
		"<b>Reaction:</b> After a phase begins, choose a kneeling character. Until the end of the phase, treat that character as if its printed text box were blank (except for <i>Traits</i>). (Limit once per round.).<br>" +
		"<i>The Faith Militant.</i><br>"
	)
	KINGS_MEN_TFM ("08087"),
	@GraphQLEnumValue(description="" +
		"<h5>Sacrificed to the Red God</h5>" +
		"House Baratheon.<br>" +
		"<b><i>R'hllor.</i></b><br>" +
		"Play only if you control a <i>R'hllor</i> character.<b>Marshaling Action:</b> Sacrifice a character to search your deck for a <i>R'hllor</i> character with equal or lower printed cost and add it to your hand. Shuffle your deck..<br>" +
		"<i>The Faith Militant.</i><br>"
	)
	SACRIFICED_TO_THE_RED_GOD_TFM ("08088"),
	@GraphQLEnumValue(description="" +
		"<h5>Cersei's Informer</h5>" +
		"House Lannister.<br>" +
		"<b><i>Spy.</i></b><br>" +
		"Bestow (3).<b>Action:</b> Move 1 gold from Cersei's Informer to a non-<i>Spy</i> card you control to draw 1 card. Then, choose and discard 1 card from your hand. (Limit once per round.).<br>" +
		"<i>The Faith Militant.</i><br>"
	)
	CERSEIS_INFORMER_TFM ("08089"),
	@GraphQLEnumValue(description="" +
		"<h5>Ser Pounce</h5>" +
		"House Lannister.<br>" +
		"<b><i>Cat. Knight.</i></b><br>" +
		"Unique character with printed cost 3 or lower only. Ambush (1).Attached character gains an [intrigue] icon and does not kneel when declared as an attacker in an [intrigue] challenge..<br>" +
		"<i>The Faith Militant.</i><br>"
	)
	SER_POUNCE_TFM ("08090"),
	@GraphQLEnumValue(description="" +
		"<h5>Tarle the Thrice-Drowned</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Drowned God. Ironborn.</i></b><br>" +
		"You may marshal non-unique <i>Drowned God</i> characters from your dead pile as if they were in your hand..<br>" +
		"<i>The Faith Militant.</i><br>"
	)
	TARLE_THE_THRICE_DROWNED_TFM ("08091"),
	@GraphQLEnumValue(description="" +
		"<h5>Given to the Drowned God</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Drowned God.</i></b><br>" +
		"<b>Action:</b> Kill a <i>Drowned God</i> character to draw X cards. X is that character's printed cost..<br>" +
		"<i>The Faith Militant.</i><br>"
	)
	GIVEN_TO_THE_DROWNED_GOD_TFM ("08092"),
	@GraphQLEnumValue(description="" +
		"<h5>Daenerys Targaryen (TFM)</h5>" +
		"House Targaryen.<br>" +
		"<b><i>Lady. Queen.</i></b><br>" +
		"Daenerys Targaryen's STR cannot be reduced by card effects.<b>Reaction:</b> After you play a [targaryen] event, choose a character. Until the end of the phase, that character gets -1 STR and is killed if its STR is 0. (Limit 3 times per round.).<br>" +
		"<i>The Faith Militant.</i><br>"
	)
	DAENERYS_TARGARYEN_TFM ("08093"),
	@GraphQLEnumValue(description="" +
		"<h5>Mhysa</h5>" +
		"House Targaryen.<br>" +
		"<b><i>Title.</i></b><br>" +
		"<i>Lady</i> character only.During the first [power] challenge you initiate each round, attached character does not kneel when declared as an attacker and gets +1 STR for each attacking character..<br>" +
		"<i>The Faith Militant.</i><br>"
	)
	MHYSA_TFM ("08094"),
	@GraphQLEnumValue(description="" +
		"<h5>House Yronwood Knight</h5>" +
		"House Martell.<br>" +
		"<b><i>House Yronwood. Knight.</i></b><br>" +
		"<b>Reaction:</b> After you lose a challenge in which House Yronwood Knight is participating, discard 1 card at random from the winning opponent's hand..<br>" +
		"<i>The Faith Militant.</i><br>"
	)
	HOUSE_YRONWOOD_KNIGHT_TFM ("08095"),
	@GraphQLEnumValue(description="" +
		"<h5>Secret Pact</h5>" +
		"House Martell.<br>" +
		"<b><i>Condition.</i></b><br>" +
		"Non-[martell] character only. Ambush (3).Attached character gains renown.Attached character cannot be declared as an attacker in challenges against you..<br>" +
		"<i>The Faith Militant.</i><br>"
	)
	SECRET_PACT_TFM ("08096"),
	@GraphQLEnumValue(description="" +
		"<h5>The High Sparrow</h5>" +
		"Neutral.<br>" +
		"<b><i>The Seven.</i></b><br>" +
		"Each player cannot gain more than 7 gold each round.Each player cannot draw more than 3 cards each round..<br>" +
		"<i>The Faith Militant.</i><br>"
	)
	THE_HIGH_SPARROW_TFM ("08097"),
	@GraphQLEnumValue(description="" +
		"<h5>\"The Song of the Seven\"</h5>" +
		"Neutral.<br>" +
		"<b><i>Song. The Seven.</i></b><br>" +
		"<b>Reaction:</b> After you lose dominance, move 2 power from the winning opponent's faction card to a <i>The Seven</i> character you control. (Max 1 per phase.).<br>" +
		"<i>The Faith Militant.</i><br>"
	)
	THE_SONG_OF_THE_SEVEN_TFM ("08098"),
	@GraphQLEnumValue(description="" +
		"<h5>The Faith Militant</h5>" +
		"Neutral.<br>" +
		"<b><i>The Seven.</i></b><br>" +
		"Non-<i>The Seven</i> characters and locations you control cannot gain power.<b>Reaction:</b> After you win a challenge, kneel your faction card to move 1 power from the losing opponent's faction card to a participating <i>The Seven</i> character you control..<br>" +
		"<i>The Faith Militant.</i><br>"
	)
	THE_FAITH_MILITANT_TFM ("08099"),
	@GraphQLEnumValue(description="" +
		"<h5>Compelled by the Faith</h5>" +
		"Neutral.<br>" +
		"<b><i>The Seven.</i></b><br>" +
		"<b>When Revealed:</b> Move each power from each card in play to its controller's faction card..<br>" +
		"<i>The Faith Militant.</i><br>"
	)
	COMPELLED_BY_THE_FAITH_TFM ("08100"),
	@GraphQLEnumValue(description="" +
		"<h5>Host of the Riverlands</h5>" +
		"House Stark.<br>" +
		"<b><i>Army. House Tully.</i></b><br>" +
		"Bestow (3). No attachments.<b>Reaction:</b> After a <i>House Tully</i> character you control gains power, discard 1 gold from Host of the Riverlands to have that character gain 1 power. (Limit once per phase.).<br>" +
		"<i>Someone Always Tells.</i><br>"
	)
	HOST_OF_THE_RIVERLANDS_SAT ("08101"),
	@GraphQLEnumValue(description="" +
		"<h5>Godswood</h5>" +
		"House Stark.<br>" +
		"<b><i>Old Gods.</i></b><br>" +
		"<b>Reaction:</b> After you win a challenge as the attacking player, if there are more <i>Winter</i> plot cards than <i>Summer</i> plot cards revealed, kneel Godswood to draw X cards. X is the claim value on your revealed plot card..<br>" +
		"<i>Someone Always Tells.</i><br>"
	)
	GODSWOOD_SAT ("08102"),
	@GraphQLEnumValue(description="" +
		"<h5>Mace Tyrell (SAT)</h5>" +
		"House Tyrell.<br>" +
		"<b><i>Lord. Small Council.</i></b><br>" +
		"<b>Reaction:</b> After Mace Tyrell is knelt, draw 2 cards. Then, choose a card in your hand and place it on top of your deck.+1 Income..<br>" +
		"<i>Someone Always Tells.</i><br>"
	)
	MACE_TYRELL_SAT ("08103"),
	@GraphQLEnumValue(description="" +
		"<h5>This Must Be Answered Fiercely!</h5>" +
		"House Tyrell.<br>" +
		"<b>Reaction:</b> After 3 or more characters are declared as attackers in a challenge against you, search your deck for a [tyrell] character and put it into play. Shuffle your deck..<br>" +
		"<i>Someone Always Tells.</i><br>"
	)
	THIS_MUST_BE_ANSWERED_FIERCELY_SAT ("08104"),
	@GraphQLEnumValue(description="" +
		"<h5>Septon Cellador</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>The Seven.</i></b><br>" +
		"<b>Challenges Action:</b> Kneel Septon Cellador to choose an opponent. That player must choose and discard a character from his or her hand unless he or she reveals a hand containing no characters..<br>" +
		"<i>Someone Always Tells.</i><br>"
	)
	SEPTON_CELLADOR_SAT ("08105"),
	@GraphQLEnumValue(description="" +
		"<h5>The Crow is a Tricksy Bird</h5>" +
		"The Night's Watch.<br>" +
		"<b>Plot Action:</b> Kneel your faction card to choose an opponent and look at his or her plot deck. Choose 1 plot in that deck. That player must reveal that plot as his or her next plot card, if able..<br>" +
		"<i>Someone Always Tells.</i><br>"
	)
	THE_CROW_IS_A_TRICKSY_BIRD_SAT ("08106"),
	@GraphQLEnumValue(description="" +
		"<h5>The Bastard of Nightsong</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Bastard. Knight.</i></b><br>" +
		"<b>Reaction:</b> After you win a [power] challenge in which The Bastard of Nightsong is participating, move 1 power from the losing opponent’s faction card to your own..<br>" +
		"<i>Someone Always Tells.</i><br>"
	)
	THE_BASTARD_OF_NIGHTSONG_SAT ("08107"),
	@GraphQLEnumValue(description="" +
		"<h5>King at the Wall</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Title.</i></b><br>" +
		"Unique [baratheon] character only.Attached character gains the <i>King</i> trait.<b>Reaction:</b> After you win a [power] challenge in which attached character is participating, draw 1 card for each out-of-faction location you control..<br>" +
		"<i>Someone Always Tells.</i><br>"
	)
	KING_AT_THE_WALL_SAT ("08108"),
	@GraphQLEnumValue(description="" +
		"<h5>Qyburn</h5>" +
		"House Lannister.<br>" +
		"<b><i>Maester. Small Council.</i></b><br>" +
		"<b>Reaction:</b> After a character is killed, kneel Qyburn to draw 2 cards. Then, choose and discard 1 card from your hand..<br>" +
		"<i>Someone Always Tells.</i><br>"
	)
	QYBURN_SAT ("08109"),
	@GraphQLEnumValue(description="" +
		"<h5>A Plot Against The Queen</h5>" +
		"House Lannister.<br>" +
		"<b>Reaction:</b> After you lose a [power] challenge, return a character with 1 or more power to your hand to choose a participating character with 1 or more power and return it to its owner’s hand..<br>" +
		"<i>Someone Always Tells.</i><br>"
	)
	A_PLOT_AGAINST_THE_QUEEN_SAT ("08110"),
	@GraphQLEnumValue(description="" +
		"<h5>Saltcliffe Sailor</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Ally.</i></b><br>" +
		"Bestow (3).Each character you control with 1 or more gold gains stealth.<b>Action:</b> Move 1 gold from Saltcliffe Sailor to a non-[greyjoy] character you control..<br>" +
		"<i>Someone Always Tells.</i><br>"
	)
	SALTCLIFFE_SAILOR_SAT ("08111"),
	@GraphQLEnumValue(description="" +
		"<h5>Driftwood Cudgel</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Drowned God. Weapon.</i></b><br>" +
		"<i>Drowned God</i> character only.Attached character gets +1 STR for each character in your dead pile.<b>Interrupt:</b> When attached character is killed, move Driftwood Cudgel to another eligible character. That character gains 1 power. (Limit once per phase.)<em>Errata from FAQ v1.4</em>.<br>" +
		"<i>Someone Always Tells.</i><br>"
	)
	DRIFTWOOD_CUDGEL_SAT ("08112"),
	@GraphQLEnumValue(description="" +
		"<h5>Raiding Khalasar</h5>" +
		"House Targaryen.<br>" +
		"<b><i>Army. Dothraki.</i></b><br>" +
		"No attachments. Pillage.While Raiding Khalasar is attacking, if you control an attacking <i>Bloodrider</i> character, raise the claim value on your revealed plot card by 1..<br>" +
		"<i>Someone Always Tells.</i><br>"
	)
	RAIDING_KHALASAR_SAT ("08113"),
	@GraphQLEnumValue(description="" +
		"<h5>To Go Forward You Must Go Back</h5>" +
		"House Targaryen.<br>" +
		"<b><i>Prophecy.</i></b><br>" +
		"<b>Dominance Action:</b> Each player may shuffle his or her hand (of at least 1 card) into his or her deck. Each player that does draws 5 cards.<em>Errata from FAQ v1.4</em>.<br>" +
		"<i>Someone Always Tells.</i><br>"
	)
	TO_GO_FORWARD_YOU_MUST_GO_BACK_SAT ("08114"),
	@GraphQLEnumValue(description="" +
		"<h5>Host of the Boneway</h5>" +
		"House Martell.<br>" +
		"<b><i>Army.</i></b><br>" +
		"Intimidate. No attachments.Host of the Boneway gets +1 STR for each plot card in your used pile..<br>" +
		"<i>Someone Always Tells.</i><br>"
	)
	HOST_OF_THE_BONEWAY_SAT ("08115"),
	@GraphQLEnumValue(description="" +
		"<h5>Someone Always Tells</h5>" +
		"House Martell.<br>" +
		"<b>Interrupt:</b> When the effects of an opponent's event or triggered plot ability would initiate, cancel those effects..<br>" +
		"<i>Someone Always Tells.</i><br>"
	)
	SOMEONE_ALWAYS_TELLS_SAT ("08116"),
	@GraphQLEnumValue(description="" +
		"<h5>Mya Stone</h5>" +
		"Neutral.<br>" +
		"<b><i>Bastard.</i></b><br>" +
		"<b>Interrupt:</b> When claim is applied for a [military] or [intrigue] challenge in which you are the defending player, kneel Mya Stone to apply [power] claim instead..<br>" +
		"<i>Someone Always Tells.</i><br>"
	)
	MYA_STONE_SAT ("08117"),
	@GraphQLEnumValue(description="" +
		"<h5>The Great Sept of Baelor</h5>" +
		"Neutral.<br>" +
		"<b><i>King's Landing. The Seven.</i></b><br>" +
		"Bestow (3).<b>Reaction:</b> After a character enters play, kneel The Great Sept of Baelor and discard 1 gold from it to treat that character’s printed text box as if it were blank (except for <i>Traits</i>) until the end of the round..<br>" +
		"<i>Someone Always Tells.</i><br>"
	)
	THE_GREAT_SEPT_OF_BAELOR_SAT ("08118"),
	@GraphQLEnumValue(description="" +
		"<h5>The Seven-Pointed Star</h5>" +
		"Neutral.<br>" +
		"<b><i>Item. The Seven.</i></b><br>" +
		"Attached character gains <i>The Seven</i> trait.<b>Marshaling Action:</b> Kneel attached character to reduce the cost of the next <i>The Seven</i> card you marshal this phase by 2..<br>" +
		"<i>Someone Always Tells.</i><br>"
	)
	THE_SEVEN_POINTED_STAR_SAT ("08119"),
	@GraphQLEnumValue(description="" +
		"<h5>You Win Or You Die</h5>" +
		"Neutral.<br>" +
		"<b><i>Scheme.</i></b><br>" +
		"<b>When Revealed:</b> Draw 2 cards..<br>" +
		"<i>Someone Always Tells.</i><br>"
	)
	YOU_WIN_OR_YOU_DIE_SAT ("08120"),
	@GraphQLEnumValue(description="" +
		"<h5>Mace Tyrell (HoT)</h5>" +
		"House Tyrell.<br>" +
		"<b><i>Lord.</i></b><br>" +
		"<b>Reaction:</b> After a [tyrell] character enters play under your control, pay 1 gold to have Mace Tyrell gain 1 power. (Limit once per phase.)<b>Action:</b> Kneel your faction card to remove another [tyrell] character you control from the game until the beginning of the next phase..<br>" +
		"<i>House of Thorns.</i><br>"
	)
	MACE_TYRELL_HoT ("09001"),
	@GraphQLEnumValue(description="" +
		"<h5>Brienne of Tarth (HoT)</h5>" +
		"House Tyrell.<br>" +
		"<b><i>Lady.</i></b><br>" +
		"<b>Reaction:</b> After you win a challenge in which Brienne of Tarth is participating, if her STR is: - 6 or higher, she gains 1 power.- 10 or higher, choose another character. It gets +3 STR until the end of the phase.- 15 or higher, stand her and draw 1 card..<br>" +
		"<i>House of Thorns.</i><br>"
	)
	BRIENNE_OF_TARTH_HoT ("09002"),
	@GraphQLEnumValue(description="" +
		"<h5>Ser Garlan Tyrell (HoT)</h5>" +
		"House Tyrell.<br>" +
		"<b><i>Knight. Lord.</i></b><br>" +
		"<b>Action:</b> During a challenge in which a <i>Knight</i> character you control is attacking alone, discard 1 card from your hand to raise the claim value on your revealed plot card by 1 until the end of the challenge. (Limit once per challenge.).<br>" +
		"<i>House of Thorns.</i><br>"
	)
	SER_GARLAN_TYRELL_HoT ("09003"),
	@GraphQLEnumValue(description="" +
		"<h5>The Queen of Thorns (HoT)</h5>" +
		"House Tyrell.<br>" +
		"<b><i>Lady.</i></b><br>" +
		"Insight.<b>Reaction:</b> After The Queen of Thorns is knelt, discard an event from your hand to search your deck for an event, reveal it, and add it to your hand. Shuffle your deck..<br>" +
		"<i>House of Thorns.</i><br>"
	)
	THE_QUEEN_OF_THORNS_HoT ("09004"),
	@GraphQLEnumValue(description="" +
		"<h5>Highgarden Honor Guard</h5>" +
		"House Tyrell.<br>" +
		"<b><i>Army. Guard.</i></b><br>" +
		"Ambush (6). No attachments.Reduce the cost to ambush Highgarden Honor Guard by 1 for each <i>The Reach</i> location you control..<br>" +
		"<i>House of Thorns.</i><br>"
	)
	HIGHGARDEN_HONOR_GUARD_HoT ("09005"),
	@GraphQLEnumValue(description="" +
		"<h5>Margaery Tyrell (HoT)</h5>" +
		"House Tyrell.<br>" +
		"<b><i>Lady. Queen.</i></b><br>" +
		"While Margaery Tyrell is attacking, she gets +1 STR for each defending character.<b>Reaction:</b> After Margaery Tyrell is declared as an attacker, choose and kneel a character controlled by the defending player. That character is participating in the challenge as a defender..<br>" +
		"<i>House of Thorns.</i><br>"
	)
	MARGAERY_TYRELL_HoT ("09006"),
	@GraphQLEnumValue(description="" +
		"<h5>The Knight of Flowers (HoT)</h5>" +
		"House Tyrell.<br>" +
		"<b><i>Knight. Lord.</i></b><br>" +
		"Renown.<b>Reaction:</b> After you play an event, The Knight of Flowers gets +2 STR until the end of the phase..<br>" +
		"<i>House of Thorns.</i><br>"
	)
	THE_KNIGHT_OF_FLOWERS_HoT ("09007"),
	@GraphQLEnumValue(description="" +
		"<h5>Willas Tyrell</h5>" +
		"House Tyrell.<br>" +
		"<b><i>Lord.</i></b><br>" +
		"<b>Action:</b> Kneel Willas Tyrell. Then, if you control:- Margaery Tyrell, stand her.- The Knight of Flowers, he gains insight until the end of the phase.- Ser Garlan Tyrell, he gains renown until the end of the phase..<br>" +
		"<i>House of Thorns.</i><br>"
	)
	WILLAS_TYRELL_HoT ("09008"),
	@GraphQLEnumValue(description="" +
		"<h5>Garth the Gross</h5>" +
		"House Tyrell.<br>" +
		"<b><i>Lord. Steward.</i></b><br>" +
		"While you control another [tyrell] <i>Lord</i> character, Garth the Gross gains a [military] icon and renown.While you control a [tyrell] <i>Lady</i> character, Garth the Gross gains an [intrigue] icon and gets +2 STR..<br>" +
		"<i>House of Thorns.</i><br>"
	)
	GARTH_THE_GROSS_HoT ("09009"),
	@GraphQLEnumValue(description="" +
		"<h5>The Blue Bard</h5>" +
		"House Tyrell.<br>" +
		"<b><i>Minstrel.</i></b><br>" +
		"<b>Interrupt:</b> When the Blue Bard leaves play, search the top 10 cards of your deck for any number of <i>Song</i> events, reveal them, and add them to your hand. Shuffle your deck..<br>" +
		"<i>House of Thorns.</i><br>"
	)
	THE_BLUE_BARD_HoT ("09010"),
	@GraphQLEnumValue(description="" +
		"<h5>Emissary of the Hightower</h5>" +
		"House Tyrell.<br>" +
		"<b><i>House Hightower.</i></b><br>" +
		"Ambush (4).<b>Reaction:</b> After Emissary of the Hightower enters play, choose an event in your discard pile. Until the end of the phase, you may play that event as if it were in your hand. If you do, remove it from the game instead of placing it into your discard pile..<br>" +
		"<i>House of Thorns.</i><br>"
	)
	EMISSARY_OF_THE_HIGHTOWER_HoT ("09011"),
	@GraphQLEnumValue(description="" +
		"<h5>Green-Apple Knight</h5>" +
		"House Tyrell.<br>" +
		"<b><i>Knight.</i></b><br>" +
		"Green-Apple Knight gets +1 STR for each other <i>Knight</i> character you control.While you control 2 or more other <i>Knight</i> characters, Green-Apple Knight does not kneel when declared as an attacker..<br>" +
		"<i>House of Thorns.</i><br>"
	)
	GREEN_APPLE_KNIGHT_HoT ("09012"),
	@GraphQLEnumValue(description="" +
		"<h5>Desmera Redwyne</h5>" +
		"House Tyrell.<br>" +
		"<b><i>House Redwyne. Lady.</i></b><br>" +
		"<b>Reaction:</b> After a character is removed from a challenge, pay 1 gold to give that character +2 STR or -1 STR until the end of the phase..<br>" +
		"<i>House of Thorns.</i><br>"
	)
	DESMERA_REDWYNE_HoT ("09013"),
	@GraphQLEnumValue(description="" +
		"<h5>Maester Ballabar</h5>" +
		"House Tyrell.<br>" +
		"<b><i>Maester.</i></b><br>" +
		"<b>Action:</b> During a challenge in which you control a participating character, kneel Maester Ballabar to choose a character with the lowest STR among participating characters. Stand that character and remove it from the challenge..<br>" +
		"<i>House of Thorns.</i><br>"
	)
	MAESTER_BALLABAR_HoT ("09014"),
	@GraphQLEnumValue(description="" +
		"<h5>Highgarden Courtier</h5>" +
		"House Tyrell.<br>" +
		"<b><i>Companion.</i></b><br>" +
		"<b>Reaction:</b> After another character’s STR is increased by a card effect, kneel Highgarden Courtier to stand that character. (Limit once per phase.).<br>" +
		"<i>House of Thorns.</i><br>"
	)
	HIGHGARDEN_COURTIER_HoT ("09015"),
	@GraphQLEnumValue(description="" +
		"<h5>Jousting Knight</h5>" +
		"House Tyrell.<br>" +
		"<b><i>Knight.</i></b><br>" +
		"Jousting Knight does not contribute its STR to a challenge unless it is attacking or defending alone..<br>" +
		"<i>House of Thorns.</i><br>"
	)
	JOUSTING_KNIGHT_HoT ("09016"),
	@GraphQLEnumValue(description="" +
		"<h5>The Hightower</h5>" +
		"House Tyrell.<br>" +
		"<b><i>House Hightower. Oldtown.</i></b><br>" +
		"<b>Reaction:</b> After a [tyrell] character enters play under your control, gain 1 gold and draw 1 card. (Limit once per phase.).<br>" +
		"<i>House of Thorns.</i><br>"
	)
	THE_HIGHTOWER_HoT ("09017"),
	@GraphQLEnumValue(description="" +
		"<h5>Redwyne Straits</h5>" +
		"House Tyrell.<br>" +
		"<b><i>House Redwyne.</i></b><br>" +
		"Limited.+2 Income..<br>" +
		"<i>House of Thorns.</i><br>"
	)
	REDWYNE_STRAITS_HoT ("09018"),
	@GraphQLEnumValue(description="" +
		"<h5>Jousting Pavilion</h5>" +
		"House Tyrell.<br>" +
		"<b><i>The Reach.</i></b><br>" +
		"Each <i>Knight</i> character you control gets +1 STR while attacking or defending alone..<br>" +
		"<i>House of Thorns.</i><br>"
	)
	JOUSTING_PAVILION_HoT ("09019"),
	@GraphQLEnumValue(description="" +
		"<h5>Queen of the Seven Kingdoms</h5>" +
		"House Tyrell.<br>" +
		"<b><i>Title.</i></b><br>" +
		"<i>Lady</i> character only.Attached character gains the <i>Queen</i> trait.<b>Action</b> Stand attached character and remove it from the challenge to choose a participating character. Stand that character and remove it from the challenge. (Limit once per phase.).<br>" +
		"<i>House of Thorns.</i><br>"
	)
	QUEEN_OF_THE_SEVEN_KINGDOMS_HoT ("09020"),
	@GraphQLEnumValue(description="" +
		"<h5>Tourney Lance</h5>" +
		"House Tyrell.<br>" +
		"<b><i>Weapon.</i></b><br>" +
		"<i>Knight</i> character only.Attached character gets +1 STR.While attached character is attacking alone, the defending player cannot declare more than 1 character as a defender..<br>" +
		"<i>House of Thorns.</i><br>"
	)
	TOURNEY_LANCE_HoT ("09021"),
	@GraphQLEnumValue(description="" +
		"<h5>Melee at Bitterbridge</h5>" +
		"House Tyrell.<br>" +
		"<b>Action:</b> Choose X participating characters. Each character with the highest STR among those characters gains renown until the end of the challenge. Each other chosen character does not contribute its STR to the challenge..<br>" +
		"<i>House of Thorns.</i><br>"
	)
	MELEE_AT_BITTERBRIDGE_HoT ("09022"),
	@GraphQLEnumValue(description="" +
		"<h5>\"Six Maids in a Pool\"</h5>" +
		"House Tyrell.<br>" +
		"<b><i>Song.</i></b><br>" +
		"<b>Action:</b> Draw 1 card for each <i>Lady</i> character you control..<br>" +
		"<i>House of Thorns.</i><br>"
	)
	SIX_MAIDS_IN_A_POOL_HoT ("09023"),
	@GraphQLEnumValue(description="" +
		"<h5>Hidden Thorns</h5>" +
		"House Tyrell.<br>" +
		"<b>Reaction:</b> After you win an [intrigue] challenge by 5 or more STR, the losing opponent chooses and discards 2 cards from his or her hand. Then, if you control The Queen of Thorns, return Hidden Thorns to your hand instead of placing it in your discard pile. (Max 1 per challenge.).<br>" +
		"<i>House of Thorns.</i><br>"
	)
	HIDDEN_THORNS_HoT ("09024"),
	@GraphQLEnumValue(description="" +
		"<h5>River Runner</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Ally. Smuggler.</i></b><br>" +
		"While River Runner is attacking, each character with power cannot be declared as a defender..<br>" +
		"<i>House of Thorns.</i><br>"
	)
	RIVER_RUNNER_HoT ("09025"),
	@GraphQLEnumValue(description="" +
		"<h5>Bend the Knee</h5>" +
		"House Baratheon.<br>" +
		"Play only if you control a standing <i>King</i> character.<b>Action:</b> Choose and kneel a <i>Lord</i> or <i>Lady</i> character..<br>" +
		"<i>House of Thorns.</i><br>"
	)
	BEND_THE_KNEE_HoT ("09026"),
	@GraphQLEnumValue(description="" +
		"<h5>Drowned God's Apostle</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Drowned God. Ironborn.</i></b><br>" +
		"<b>Reaction:</b> After you win dominance, kill Drowned God's Apostle to put a non-unique [greyjoy] character with printed cost 3 or lower into play from your dead pile..<br>" +
		"<i>House of Thorns.</i><br>"
	)
	DROWNED_GODS_APOSTLE_HoT ("09027"),
	@GraphQLEnumValue(description="" +
		"<h5>Corpse Lake</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Iron Islands.</i></b><br>" +
		"<b>Reaction:</b> After a character is discarded from an opponent's deck, Corpse Lake gains 1 power. (Limit 3 times per round.).<br>" +
		"<i>House of Thorns.</i><br>"
	)
	CORPSE_LAKE_HoT ("09028"),
	@GraphQLEnumValue(description="" +
		"<h5>The Hound (HoT)</h5>" +
		"House Lannister.<br>" +
		"<b><i>House Clegane. Kingsguard.</i></b><br>" +
		"No attachments except <i>Weapon</i>.<b>Reaction:</b> After The Hound enters play, choose a <i>Knight</i> character without attachments and return it to its owner's hand..<br>" +
		"<i>House of Thorns.</i><br>"
	)
	THE_HOUND_HoT ("09029"),
	@GraphQLEnumValue(description="" +
		"<h5>Lion's Tooth</h5>" +
		"House Lannister.<br>" +
		"<b><i>Weapon.</i></b><br>" +
		"Unique [lannister] character only. Ambush (2).Attached character gets +1 STR.<b>Action:</b> During a challenge in which attached character is participating, sacrifice Lion’s Tooth to choose a participating character with printed cost 3 or lower and return it to its owner’s hand..<br>" +
		"<i>House of Thorns.</i><br>"
	)
	LIONS_TOOTH_HoT ("09030"),
	@GraphQLEnumValue(description="" +
		"<h5>The Bastard of Godsgrace</h5>" +
		"House Martell.<br>" +
		"<b><i>Bastard. Knight.</i></b><br>" +
		"Renown.<b>Challenges Action:</b> Discard 1 power from The Bastard of Godsgrace to reduce the cost of the next card you play or ambush this phase by 2..<br>" +
		"<i>House of Thorns.</i><br>"
	)
	THE_BASTARD_OF_GODSGRACE_HoT ("09031"),
	@GraphQLEnumValue(description="" +
		"<h5>Hellholt</h5>" +
		"House Martell.<br>" +
		"<b><i>Dorne. House Uller. Stronghold.</i></b><br>" +
		"<b>Reaction:</b> After you lose a challenge by 5 or more STR, Hellholt gains 1 power..<br>" +
		"<i>House of Thorns.</i><br>"
	)
	HELLHOLT_HoT ("09032"),
	@GraphQLEnumValue(description="" +
		"<h5>Small Paul</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Steward.</i></b><br>" +
		"No attachments except <i>Weapon</i>.<b>Interrupt:</b> When Small Paul is killed, search the top X cards of your deck for any number of <i>Steward</i> characters, reveal them, and add them to your hand. X is your reserve value. Shuffle your deck..<br>" +
		"<i>House of Thorns.</i><br>"
	)
	SMALL_PAUL_HoT ("09033"),
	@GraphQLEnumValue(description="" +
		"<h5>Broken Vows</h5>" +
		"The Night's Watch.<br>" +
		"<b>Marshaling Action:</b> Give control of a [thenightswatch] character you control to an opponent. Then, take control of a non-loyal character that player controls with a lower printed cost..<br>" +
		"<i>House of Thorns.</i><br>"
	)
	BROKEN_VOWS_HoT ("09034"),
	@GraphQLEnumValue(description="" +
		"<h5>Ser Dontos Hollard</h5>" +
		"House Stark.<br>" +
		"<b><i>Fool. Knight.</i></b><br>" +
		"No attachments except <i>Weapon</i>.<b>Interrupt:</b> When a <i>Lady</i> character would be killed or discarded from play, stand Ser Dontos Hollard to save that character..<br>" +
		"<i>House of Thorns.</i><br>"
	)
	SER_DONTOS_HOLLARD_HoT ("09035"),
	@GraphQLEnumValue(description="" +
		"<h5>Last Hearth</h5>" +
		"House Stark.<br>" +
		"<b><i>House Umber. The North.</i></b><br>" +
		"<b>Action:</b> Kneel Last Hearth to give a participating [stark] character +2 STR until the end of the challenge. (+3 STR instead if there are fewer than 3 plot cards in your used pile.).<br>" +
		"<i>House of Thorns.</i><br>"
	)
	LAST_HEARTH_HoT ("09036"),
	@GraphQLEnumValue(description="" +
		"<h5>Qotho</h5>" +
		"House Targaryen.<br>" +
		"<b><i>Bloodrider. Dothraki.</i></b><br>" +
		"<b>Action:</b> Discard 2 [targaryen] cards from your hand to put Qotho into play from your hand..<br>" +
		"<i>House of Thorns.</i><br>"
	)
	QOTHO_HoT ("09037"),
	@GraphQLEnumValue(description="" +
		"<h5>Tokar</h5>" +
		"House Targaryen.<br>" +
		"<b><i>Item.</i></b><br>" +
		"[targaryen] character only.Attached character gets +1 STR for each attachment it has.While attached character is participating in a challenge, each character without attachments cannot gain power..<br>" +
		"<i>House of Thorns.</i><br>"
	)
	TOKAR_HoT ("09038"),
	@GraphQLEnumValue(description="" +
		"<h5>Archmaester Ebrose</h5>" +
		"Neutral.<br>" +
		"<b><i>Maester.</i></b><br>" +
		"<b>Action:</b> Kneel a <i>Maester</i> character to choose and stand another <i>Maester</i> character. (Limit once per phase.).<br>" +
		"<i>House of Thorns.</i><br>"
	)
	ARCHMAESTER_EBROSE_HoT ("09039"),
	@GraphQLEnumValue(description="" +
		"<h5>Faceless Man</h5>" +
		"Neutral.<br>" +
		"Ambush (4).<b>Challenges Action:</b> Choose a character in a dead pile. Until the end of the phase, Faceless Man gains each of that character's printed challenge icons, keywords, faction affiliations, and <i>Traits</i>. (Limit once per phase.).<br>" +
		"<i>House of Thorns.</i><br>"
	)
	FACELESS_MAN_HoT ("09040"),
	@GraphQLEnumValue(description="" +
		"<h5>Citadel Novice</h5>" +
		"Neutral.<br>" +
		"<b><i>Maester.</i></b><br>" +
		"<b>Reaction:</b> After Citadel Novice is knelt, reveal the top card of your deck. If it is an attachment or a <i>Maester</i> character, draw it. (Limit once per phase.).<br>" +
		"<i>House of Thorns.</i><br>"
	)
	CITADEL_NOVICE_HoT ("09041"),
	@GraphQLEnumValue(description="" +
		"<h5>The Citadel</h5>" +
		"Neutral.<br>" +
		"<b><i>Citadel. Oldtown.</i></b><br>" +
		"<b>Action:</b> Kneel The Citadel to search the top 10 cards of your deck for a <i>Maester</i> character, reveal it, and add it to your hand. Shuffle your deck..<br>" +
		"<i>House of Thorns.</i><br>"
	)
	THE_CITADEL_HoT ("09042"),
	@GraphQLEnumValue(description="" +
		"<h5>Strangler</h5>" +
		"Neutral.<br>" +
		"<b><i>Condition. Poison.</i></b><br>" +
		"Terminal.While attached character is participating in a challenge, set its STR to 1. <em>(Other modifiers do not raise or lower its STR.)</em>.<br>" +
		"<i>House of Thorns.</i><br>"
	)
	STRANGLER_HoT ("09043"),
	@GraphQLEnumValue(description="" +
		"<h5>Words Are Wind</h5>" +
		"Neutral.<br>" +
		"<b>Interrupt:</b> When the effects of an opponent's event would initiate, that opponent must choose, either: cancel those effects, or you draw 2 cards..<br>" +
		"<i>House of Thorns.</i><br>"
	)
	WORDS_ARE_WIND_HoT ("09044"),
	@GraphQLEnumValue(description="" +
		"<h5>The Conclave</h5>" +
		"Neutral.<br>" +
		"<b><i>Citadel. Conclave.</i></b><br>" +
		"Your deck may include non-loyal <i>Maester</i> characters from any faction. Your deck must include at least 12 <i>Maester</i> characters. Before placing setup cards, place the top 7 cards of your deck facedown under this agenda.<b>Reaction:</b> After you win a challenge in which you control a participating <i>Maester</i> character, choose 1 card under this agenda and switch it with the top card of your deck..<br>" +
		"<i>House of Thorns.</i><br>"
	)
	THE_CONCLAVE_HoT ("09045"),
	@GraphQLEnumValue(description="" +
		"<h5>Wardens of the South</h5>" +
		"House Tyrell.<br>" +
		"<b><i>Summer.</i></b><br>" +
		"<b>Reaction:</b> After a [tyrell] character you control is declared as an attacker or defender, that character gets +2 STR until the end of the challenge..<br>" +
		"<i>House of Thorns.</i><br>"
	)
	WARDENS_OF_THE_SOUTH_HoT ("09046"),
	@GraphQLEnumValue(description="" +
		"<h5>Besieged</h5>" +
		"Neutral.<br>" +
		"<b><i>Siege. War.</i></b><br>" +
		"At least one character must be declared as a defender in each challenge, if able..<br>" +
		"<i>House of Thorns.</i><br>"
	)
	BESIEGED_HoT ("09047"),
	@GraphQLEnumValue(description="" +
		"<h5>Your King Commands It</h5>" +
		"Neutral.<br>" +
		"<b><i>Edict. Noble.</i></b><br>" +
		"Each non-<i>King</i>, non-<i>Queen</i> character cannot gain power..<br>" +
		"<i>House of Thorns.</i><br>"
	)
	YOUR_KING_COMMANDS_IT_HoT ("09048"),
	@GraphQLEnumValue(description="" +
		"<h5>The Spider's Web</h5>" +
		"Neutral.<br>" +
		"<b><i>Scheme.</i></b><br>" +
		"<b>Reaction:</b> After claim is applied for an [intrigue] challenge you won, you may initiate an additional [intrigue] challenge this phase. Until the end of the phase, raise the claim value on your revealed plot card by 1 during [intrigue] challenges. (Limit once per phase.).<br>" +
		"<i>House of Thorns.</i><br>"
	)
	THE_SPIDERS_WEB_HoT ("09049"),
	@GraphQLEnumValue(description="" +
		"<h5>Now It Comes To War</h5>" +
		"Neutral.<br>" +
		"<b><i>War.</i></b><br>" +
		"<b>Forced Interrupt:</b> When claim is applied for an [intrigue] or [power] challenge, the attacking player may choose to apply [military] claim instead..<br>" +
		"<i>House of Thorns.</i><br>"
	)
	NOW_IT_COMES_TO_WAR_HoT ("09050"),
	@GraphQLEnumValue(description="" +
		"<h5>Trade Routes</h5>" +
		"Neutral.<br>" +
		"<b><i>Kingdom. Summer.</i></b><br>" +
		"<b>When Revealed:</b> Choose an opponent. Gain 1 gold for each location you control and each location that opponent controls..<br>" +
		"<i>House of Thorns.</i><br>"
	)
	TRADE_ROUTES_HoT ("09051"),
	@GraphQLEnumValue(description="" +
		"<h5>Nothing Burns Like The Cold</h5>" +
		"Neutral.<br>" +
		"<b><i>Winter.</i></b><br>" +
		"<b>When Revealed:</b> Each player chooses an attachment and a non-limited location he or she controls, if able, and discards each of those cards from play (cannot be saved)..<br>" +
		"<i>House of Thorns.</i><br>"
	)
	NOTHING_BURNS_LIKE_THE_COLD_HoT ("09052"),
	@GraphQLEnumValue(description="" +
		"<h5>Doran Martell (SoD)</h5>" +
		"House Martell.<br>" +
		"<b><i>Lord.</i></b><br>" +
		"<b>Action:</b> Kneel your faction card to choose a participating character with fewer than 2 challenge icons and remove it from the challenge.<b>Reaction:</b> After you lose a challenge, choose a character. Until the end of the phase, that character gains or loses a challenge icon of your choice..<br>" +
		"<i>Sands of Dorne.</i><br>"
	)
	DORAN_MARTELL_SoD ("10001"),
	@GraphQLEnumValue(description="" +
		"<h5>Ellaria Sand (SoD)</h5>" +
		"House Martell.<br>" +
		"<b><i>Bastard. Companion.</i></b><br>" +
		"<b>Reaction:</b> After Ellaria Sand is declared as an attacker, choose up to 3 characters controlled by the defending player. Each of those characters must be declared as a defender for this challenge, if able..<br>" +
		"<i>Sands of Dorne.</i><br>"
	)
	ELLARIA_SAND_SoD ("10002"),
	@GraphQLEnumValue(description="" +
		"<h5>The Red Viper (SoD)</h5>" +
		"House Martell.<br>" +
		"<b><i>Lord.</i></b><br>" +
		"Intimidate.The Red Viper gets +1 STR for each power he has.<b>Reaction:</b> After you win a challenge in which you control an attacking <i>Bastard</i> character, The Red Viper gains 1 power..<br>" +
		"<i>Sands of Dorne.</i><br>"
	)
	THE_RED_VIPER_SoD ("10003"),
	@GraphQLEnumValue(description="" +
		"<h5>Darkstar (SoD)</h5>" +
		"House Martell.<br>" +
		"<b><i>House Dayne. Knight.</i></b><br>" +
		"Intimidate.<b>Action:</b> During a challenge in which Darkstar is attacking, sacrifice him to return each participating character to its owner's hand..<br>" +
		"<i>Sands of Dorne.</i><br>"
	)
	DARKSTAR_SoD ("10004"),
	@GraphQLEnumValue(description="" +
		"<h5>Obara Sand (SoD)</h5>" +
		"House Martell.<br>" +
		"<b><i>Bastard. Sand Snake.</i></b><br>" +
		"<b>Challenges Action:</b> Return a <i>Sand Snake</i> character to your hand to put a [martell] character with lower printed cost into play from your hand. (Limit once per phase.).<br>" +
		"<i>Sands of Dorne.</i><br>"
	)
	OBARA_SAND_SoD ("10005"),
	@GraphQLEnumValue(description="" +
		"<h5>Areo Hotah (SoD)</h5>" +
		"House Martell.<br>" +
		"<b><i>Guard.</i></b><br>" +
		"Ambush (6).Reduce the cost to ambush Areo Hotah by 1 for each plot in your used pile.<b>Reaction:</b> After you win a challenge in which Areo Hotah is defending, return him to your hand to raise the claim value on your revealed plot by 1 until the end of the phase..<br>" +
		"<i>Sands of Dorne.</i><br>"
	)
	AREO_HOTAH_SoD ("10006"),
	@GraphQLEnumValue(description="" +
		"<h5>Nymeria Sand (SoD)</h5>" +
		"House Martell.<br>" +
		"<b><i>Bastard. Sand Snake.</i></b><br>" +
		"<b>Reaction:</b> After you lose dominance, discard 1 card at random from the winning opponent's hand and draw 1 card..<br>" +
		"<i>Sands of Dorne.</i><br>"
	)
	NYMERIA_SAND_SoD ("10007"),
	@GraphQLEnumValue(description="" +
		"<h5>Tyene Sand (SoD)</h5>" +
		"House Martell.<br>" +
		"<b><i>Bastard. Sand Snake.</i></b><br>" +
		"Stealth.<b>Reaction:</b> After you lose a challenge as the defending player, kneel a <i>Sand Snake</i> character to put Tyene Sand into play from your hand..<br>" +
		"<i>Sands of Dorne.</i><br>"
	)
	TYENE_SAND_SoD ("10008"),
	@GraphQLEnumValue(description="" +
		"<h5>Nymeria's Guard</h5>" +
		"House Martell.<br>" +
		"<b><i>Army. Guard.</i></b><br>" +
		"No attachments.<b>Challenges Action:</b> Pay 4 gold and stand a <i>Sand Snake</i> character to put Nymeria's Guard into play from your hand..<br>" +
		"<i>Sands of Dorne.</i><br>"
	)
	NYMERIAS_GUARD_SoD ("10009"),
	@GraphQLEnumValue(description="" +
		"<h5>Obella Sand</h5>" +
		"House Martell.<br>" +
		"<b><i>Bastard. Sand Snake.</i></b><br>" +
		"<b>Reaction:</b> After Obella Sand is discarded for [intrigue] claim or killed for [military] claim, move 1 power from the winning opponent's faction card to your own. Shuffle Obella Sand from your discard or dead pile into your deck..<br>" +
		"<i>Sands of Dorne.</i><br>"
	)
	OBELLA_SAND_SoD ("10010"),
	@GraphQLEnumValue(description="" +
		"<h5>Quentyn Martell (SoD)</h5>" +
		"House Martell.<br>" +
		"<b><i>Knight. Lord.</i></b><br>" +
		"Renown.<b>Forced Reaction:</b> After the challenges phase begins, if there are fewer than 3 plot cards in your used pile, kneel Quentyn Martell..<br>" +
		"<i>Sands of Dorne.</i><br>"
	)
	QUENTYN_MARTELL_SoD ("10011"),
	@GraphQLEnumValue(description="" +
		"<h5>Ser Cletus Yronwood</h5>" +
		"House Martell.<br>" +
		"<b><i>House Yronwood. Knight.</i></b><br>" +
		"No attachments except <i>Weapon</i>.Increase the initiative value on your revealed plot card by 1 for each plot card in your used pile..<br>" +
		"<i>Sands of Dorne.</i><br>"
	)
	SER_CLETUS_YRONWOOD_SoD ("10012"),
	@GraphQLEnumValue(description="" +
		"<h5>Loreza Sand</h5>" +
		"House Martell.<br>" +
		"<b><i>Bastard. Sand Snake.</i></b><br>" +
		"<b>Interrupt:</b> When a unique [martell] character you control is killed, draw 1 card. (Limit once per phase.).<br>" +
		"<i>Sands of Dorne.</i><br>"
	)
	LOREZA_SAND_SoD ("10013"),
	@GraphQLEnumValue(description="" +
		"<h5>Maester Kedry</h5>" +
		"House Martell.<br>" +
		"<b><i>Maester.</i></b><br>" +
		"<b>Action:</b> Kneel Maester Kedry to reduce the gold cost of the next event you play this phase by 2..<br>" +
		"<i>Sands of Dorne.</i><br>"
	)
	MAESTER_KEDRY_SoD ("10014"),
	@GraphQLEnumValue(description="" +
		"<h5>House Dayne Escort</h5>" +
		"House Martell.<br>" +
		"<b><i>Ally. House Dayne.</i></b><br>" +
		"While there are 3 or more plot cards in your used pile, you may marshal House Dayne Escort from your discard pile as if it were in your hand..<br>" +
		"<i>Sands of Dorne.</i><br>"
	)
	HOUSE_DAYNE_ESCORT_SoD ("10015"),
	@GraphQLEnumValue(description="" +
		"<h5>Shadow City Bastard</h5>" +
		"House Martell.<br>" +
		"<b><i>Bastard.</i></b><br>" +
		"Ambush (3).<b>Challenges Action:</b> Sacrifice Shadow City Bastard to choose a character with printed cost 5 or lower. Until the end of the phase, that characters loses a [military], an [intrigue], and a [power] icon..<br>" +
		"<i>Sands of Dorne.</i><br>"
	)
	SHADOW_CITY_BASTARD_SoD ("10016"),
	@GraphQLEnumValue(description="" +
		"<h5>Dorne</h5>" +
		"House Martell.<br>" +
		"<b><i>Dorne.</i></b><br>" +
		"<b>Reaction:</b> After you lose a challenge, look at the top 2 cards of your deck. Add 1 to your hand, and place the other on the bottom of your deck.+1 Reserve..<br>" +
		"<i>Sands of Dorne.</i><br>"
	)
	DORNE_SoD ("10017"),
	@GraphQLEnumValue(description="" +
		"<h5>Starfall</h5>" +
		"House Martell.<br>" +
		"<b><i>Dorne. House Dayne.</i></b><br>" +
		"<b>Challenges Action:</b> Kneel Starfall to choose a character. Until the end of the phase, that character loses a challenge icon of your choice..<br>" +
		"<i>Sands of Dorne.</i><br>"
	)
	STARFALL_SoD ("10018"),
	@GraphQLEnumValue(description="" +
		"<h5>Hotah's Axe</h5>" +
		"House Martell.<br>" +
		"<b><i>Weapon.</i></b><br>" +
		"Attached character gets +3 STR.<b>Reaction:</b> After a [martell] character enters play during the challenges phase, put Hotah's Axe into play from your hand, attached to that character..<br>" +
		"<i>Sands of Dorne.</i><br>"
	)
	HOTAHS_AXE_SoD ("10019"),
	@GraphQLEnumValue(description="" +
		"<h5>Patience</h5>" +
		"House Martell.<br>" +
		"<b><i>Skill.</i></b><br>" +
		"Character you control only.<b>Challenges Action:</b> Return attached character to its owner's hand..<br>" +
		"<i>Sands of Dorne.</i><br>"
	)
	PATIENCE_SoD ("10020"),
	@GraphQLEnumValue(description="" +
		"<h5>Beguiled</h5>" +
		"House Martell.<br>" +
		"<b><i>Condition.</i></b><br>" +
		"Terminal.<b>Challenges Action:</b> Kneel Beguiled to have attached character lose a challenge icon of your choice until the end of the phase..<br>" +
		"<i>Sands of Dorne.</i><br>"
	)
	BEGUILED_SoD ("10021"),
	@GraphQLEnumValue(description="" +
		"<h5>No Use For Grief</h5>" +
		"House Martell.<br>" +
		"Play only if a [martell] character was killed under your control this round.<b>Action:</b> Search your deck for a <i>Sand Snake</i> character with printed cost 3 or lower, put it into play, and shuffle your deck. (Printed cost 6 or lower instead if The Red Viper is in your dead pile.).<br>" +
		"<i>Sands of Dorne.</i><br>"
	)
	NO_USE_FOR_GRIEF_SoD ("10022"),
	@GraphQLEnumValue(description="" +
		"<h5>False Plans</h5>" +
		"House Martell.<br>" +
		"<b>Challenges Action:</b> Choose an opponent. That player discards 1 card at random from his or her hand.<b>Reaction:</b> After False Plans is discarded for [intrigue] claim, the winning opponent discards 2 cards at random from his or her hand..<br>" +
		"<i>Sands of Dorne.</i><br>"
	)
	FALSE_PLANS_SoD ("10023"),
	@GraphQLEnumValue(description="" +
		"<h5>To The Spears!</h5>" +
		"House Martell.<br>" +
		"Play only if there are 3 or more plot cards in your used pile.<b>Challenges Action:</b> Each [martell] character you control does not kneel when declared as an attacker in the next challenge you initiate this phase..<br>" +
		"<i>Sands of Dorne.</i><br>"
	)
	TO_THE_SPEARS_SoD ("10024"),
	@GraphQLEnumValue(description="" +
		"<h5>Ser Cortnay Penrose</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Knight.</i></b><br>" +
		"<b>Reaction:</b> After you win a [power] challenge in which Ser Cortnay Penrose is participating, stand him..<br>" +
		"<i>Sands of Dorne.</i><br>"
	)
	SER_CORTNAY_PENROSE_SoD ("10025"),
	@GraphQLEnumValue(description="" +
		"<h5>Sea Dragon Tower</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Dragonstone.</i></b><br>" +
		"<b>Challenges Action:</b> Kneel Sea Dragon Tower to choose a character. Until the end of the phase, that character gains a [power] icon..<br>" +
		"<i>Sands of Dorne.</i><br>"
	)
	SEA_DRAGON_TOWER_SoD ("10026"),
	@GraphQLEnumValue(description="" +
		"<h5>Fleet From Pyke</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Army.</i></b><br>" +
		"No attachments. Pillage.<b>Reaction:</b> After a character you control discards a location or attachment using pillage, Fleet From Pyke gains a challenge icon of your choice until the end of the phase..<br>" +
		"<i>Sands of Dorne.</i><br>"
	)
	FLEET_FROM_PYKE_SoD ("10027"),
	@GraphQLEnumValue(description="" +
		"<h5>Plundered</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Condition.</i></b><br>" +
		"Opponent's location only. Terminal.<b>Reaction:</b> After attached location's controller loses a challenge as the defending player, kneel attached location. Then, you may sacrifice Plundered to gain 3 gold..<br>" +
		"<i>Sands of Dorne.</i><br>"
	)
	PLUNDERED_SoD ("10028"),
	@GraphQLEnumValue(description="" +
		"<h5>Myrcella Baratheon (SoD)</h5>" +
		"House Lannister.<br>" +
		"<b><i>Lady.</i></b><br>" +
		"Myrcella Baratheon does not kneel when declared as an attacker against an opponent with fewer cards in his or her hand than you..<br>" +
		"<i>Sands of Dorne.</i><br>"
	)
	MYRCELLA_BARATHEON_SoD ("10029"),
	@GraphQLEnumValue(description="" +
		"<h5>Extortion</h5>" +
		"House Lannister.<br>" +
		"<b>Reaction:</b> After you win an [intrigue] challenge as the attacking player, gain 3 gold and return up to 3 gold from the losing opponent's gold pool to the treasury..<br>" +
		"<i>Sands of Dorne.</i><br>"
	)
	EXTORTION_SoD ("10030"),
	@GraphQLEnumValue(description="" +
		"<h5>Spare Boot</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Builder.</i></b><br>" +
		"<b>Challenges Action:</b> Choose an attachment attached to a character you control. Stand that attachment and move it to Spare Boot. (Limit once per phase.).<br>" +
		"<i>Sands of Dorne.</i><br>"
	)
	SPARE_BOOT_SoD ("10031"),
	@GraphQLEnumValue(description="" +
		"<h5>Turncloak</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Condition.</i></b><br>" +
		"Non-loyal character only. Terminal.<b>Reaction:</b> After you win a challenge in which attached character is participating, take control of attached character. (Any player may initiate this ability.).<br>" +
		"<i>Sands of Dorne.</i><br>"
	)
	TURNCLOAK_SoD ("10032"),
	@GraphQLEnumValue(description="" +
		"<h5>Greatjon Umber</h5>" +
		"House Stark.<br>" +
		"<b><i>House Umber. Lord.</i></b><br>" +
		"Intimidate.<b>Reaction:</b> After you win a [military] challenge in which Greatjon Umber is attacking, if there are fewer than 3 plot cards in your used pile, stand him..<br>" +
		"<i>Sands of Dorne.</i><br>"
	)
	GREATJON_UMBER_SoD ("10033"),
	@GraphQLEnumValue(description="" +
		"<h5>Taste For Flesh</h5>" +
		"House Stark.<br>" +
		"<b>Reaction:</b> After you win a challenge in which you control an attacking <i>Direwolf</i> character or an attacking character with a <i>Direwolf</i> attachment, choose and kill a defending character..<br>" +
		"<i>Sands of Dorne.</i><br>"
	)
	TASTE_FOR_FLESH_SoD ("10034"),
	@GraphQLEnumValue(description="" +
		"<h5>Missandei</h5>" +
		"House Targaryen.<br>" +
		"<b><i>Companion.</i></b><br>" +
		"<b>Interrupt:</b> When Missandei is discarded from your hand or deck, put her into play instead of placing her in your discard pile..<br>" +
		"<i>Sands of Dorne.</i><br>"
	)
	MISSANDEI_SoD ("10035"),
	@GraphQLEnumValue(description="" +
		"<h5>Qarth</h5>" +
		"House Targaryen.<br>" +
		"<b><i>Essos. Qarth.</i></b><br>" +
		"<b>Action:</b> Kneel Qarth and pay 1 gold to choose an attachment attached to a card you control and discard it from play..<br>" +
		"<i>Sands of Dorne.</i><br>"
	)
	QARTH_SoD ("10036"),
	@GraphQLEnumValue(description="" +
		"<h5>Leyton Hightower</h5>" +
		"House Tyrell.<br>" +
		"<b><i>House Hightower. Lord.</i></b><br>" +
		"<b>Action:</b> Kneel Leyton Hightower to put a non-limited [tyrell] card with printed cost 4 or lower into play from your hand knelt..<br>" +
		"<i>Sands of Dorne.</i><br>"
	)
	LEYTON_HIGHTOWER_SoD ("10037"),
	@GraphQLEnumValue(description="" +
		"<h5>Beacon of the South</h5>" +
		"House Tyrell.<br>" +
		"<b><i>Title.</i></b><br>" +
		"[tyrell] character only.<b>Reaction:</b> After you win a challenge by 5 or more STR in which attached character is attacking, it gains 1 power..<br>" +
		"<i>Sands of Dorne.</i><br>"
	)
	BEACON_OF_THE_SOUTH_SoD ("10038"),
	@GraphQLEnumValue(description="" +
		"<h5>Val</h5>" +
		"Neutral.<br>" +
		"<b><i>Wildling.</i></b><br>" +
		"<b>Reaction:</b> After Val is declared as an attacker, put a <i>Wildling</i> character with printed cost 4 or lower into play from your hand knelt, participating as an attacker..<br>" +
		"<i>Sands of Dorne.</i><br>"
	)
	VAL_SoD ("10039"),
	@GraphQLEnumValue(description="" +
		"<h5>Septon Meribald</h5>" +
		"Neutral.<br>" +
		"<b><i>The Seven.</i></b><br>" +
		"<b>Action:</b> Kneel Septon Meribald to choose and stand up to 3 characters with printed STR 1 or lower. (Limit once per round.).<br>" +
		"<i>Sands of Dorne.</i><br>"
	)
	SEPTON_MERIBALD_SoD ("10040"),
	@GraphQLEnumValue(description="" +
		"<h5>Oldtown Scholar</h5>" +
		"Neutral.<br>" +
		"<b><i>Maester.</i></b><br>" +
		"<b>Reaction:</b> After an opponent draws 1 or more cards, if it is not the draw phase, kneel Oldtown Scholar to draw that many cards..<br>" +
		"<i>Sands of Dorne.</i><br>"
	)
	OLDTOWN_SCHOLAR_SoD ("10041"),
	@GraphQLEnumValue(description="" +
		"<h5>Jade Sea Dromond</h5>" +
		"Neutral.<br>" +
		"<b><i>Warship.</i></b><br>" +
		"Limited.<b>Dominance Action:</b> Kneel and sacrifice Jade Sea Dromond to choose a non-limited location with printed cost 3 or lower and discard it from play.+1 Income..<br>" +
		"<i>Sands of Dorne.</i><br>"
	)
	JADE_SEA_DROMOND_SoD ("10042"),
	@GraphQLEnumValue(description="" +
		"<h5>Brother's Robes</h5>" +
		"Neutral.<br>" +
		"<b><i>The Seven.</i></b><br>" +
		"<i>The Seven</i> character only.<b>Reaction:</b> After attached character is knelt, choose a location or attachment. Until the end of the phase, treat that card as if its printed text box were blank (except for <i>Traits</i>)..<br>" +
		"<i>Sands of Dorne.</i><br>"
	)
	BROTHERS_ROBES_SoD ("10043"),
	@GraphQLEnumValue(description="" +
		"<h5>\"Off To Gulltown\"</h5>" +
		"Neutral.<br>" +
		"<b><i>Song.</i></b><br>" +
		"<b>Challenges Action:</b> Choose a character. Until the end of the phase, that character gains a [military], an [intrigue], and a [power] icon. Draw 1 card..<br>" +
		"<i>Sands of Dorne.</i><br>"
	)
	OFF_TO_GULLTOWN_SoD ("10044"),
	@GraphQLEnumValue(description="" +
		"<h5>The Wars To Come</h5>" +
		"Neutral.<br>" +
		"<b><i>Omen.</i></b><br>" +
		"Your plot deck must be exactly 10 cards. You may include a second copy of up to 2 different cards in your plot deck..<br>" +
		"<i>Sands of Dorne.</i><br>"
	)
	THE_WARS_TO_COME_SoD ("10045"),
	@GraphQLEnumValue(description="" +
		"<h5>At Prince Doran's Behest</h5>" +
		"House Martell.<br>" +
		"<b><i>Edict.</i></b><br>" +
		"<b>When Revealed:</b> Choose and reveal a new plot card. (Cannot be canceled.).<br>" +
		"<i>Sands of Dorne.</i><br>"
	)
	AT_PRINCE_DORANS_BEHEST_SoD ("10046"),
	@GraphQLEnumValue(description="" +
		"<h5>Peace and Prosperity</h5>" +
		"Neutral.<br>" +
		"<b><i>Kingdom.</i></b><br>" +
		"Reduce the cost of the first character you marshal this round by 3, the first location your marshal this round by 2, and the first attachment you marshal this round by 1..<br>" +
		"<i>Sands of Dorne.</i><br>"
	)
	PEACE_AND_PROSPERITY_SoD ("10047"),
	@GraphQLEnumValue(description="" +
		"<h5>Forced March</h5>" +
		"Neutral.<br>" +
		"<b><i>Edict. War.</i></b><br>" +
		"<b>When Revealed:</b> Each opponent kneels 1 character he or she controls with a [military] icon. Then, you may kneel a character with a [military] icon to initiate this effect again..<br>" +
		"<i>Sands of Dorne.</i><br>"
	)
	FORCED_MARCH_SoD ("10048"),
	@GraphQLEnumValue(description="" +
		"<h5>Beyond Reproach</h5>" +
		"Neutral.<br>" +
		"<b><i>The Seven.</i></b><br>" +
		"<b>When Revealed:</b> Each player sacrifices each attachment that is attached to a character he or she does not control..<br>" +
		"<i>Sands of Dorne.</i><br>"
	)
	BEYOND_REPROACH_SoD ("10049"),
	@GraphQLEnumValue(description="" +
		"<h5>Breaking Ties</h5>" +
		"Neutral.<br>" +
		"<b><i>House Frey. Scheme.</i></b><br>" +
		"<b>Action:</b> Sacrifice a loyal character to choose a non-loyal character or location and return it to its owner's hand. (Limit twice per round.).<br>" +
		"<i>Sands of Dorne.</i><br>"
	)
	BREAKING_TIES_SoD ("10050"),
	@GraphQLEnumValue(description="" +
		"<h5>Grand Melee</h5>" +
		"Neutral.<br>" +
		"<b><i>Summer.</i></b><br>" +
		"Each character that is attacking or defending alone does not contribute its STR to the challenge..<br>" +
		"<i>Sands of Dorne.</i><br>"
	)
	GRAND_MELEE_SoD ("10051"),
	@GraphQLEnumValue(description="" +
		"<h5>False Spring</h5>" +
		"Neutral.<br>" +
		"<b><i>Winter.</i></b><br>" +
		"<b>When Revealed:</b> Each opponent chooses and reveals 3 cards from his or her hand, if able. You may choose and discard 1 revealed card from any number of those hands..<br>" +
		"<i>Sands of Dorne.</i><br>"
	)
	FALSE_SPRING_SoD ("10052"),
	@GraphQLEnumValue(description="" +
		"<h5>Varamyr Sixskins</h5>" +
		"Neutral.<br>" +
		"<b><i>Wildling.</i></b><br>" +
		"<b>Reaction:</b> After the challenges phase begins, until the end of the phase, Varamyr Sixskins gains (choose one):- the <i>Bear</i> trait and gets +5 STR.- the <i>Eagle</i> trait, an [intrigue] icon, and insight.- the <i>Cat</i> trait, a [power] icon, and stealth.- the <i>Wolf</i> trait and intimidate, and gets +2 STR..<br>" +
		"<i>The Shadow City.</i><br>"
	)
	VARAMYR_SIXSKINS_TSC ("11001"),
	@GraphQLEnumValue(description="" +
		"<h5>Bolton Flayer</h5>" +
		"House Stark.<br>" +
		"<b><i>Ally. House Bolton.</i></b><br>" +
		"Shadow (2).<b>Forced Interrupt:</b> When the challenges phase ends, choose and kill a character with the lowest printed cost (cannot be saved)..<br>" +
		"<i>The Shadow City.</i><br>"
	)
	BOLTON_FLAYER_TSC ("11002"),
	@GraphQLEnumValue(description="" +
		"<h5>Northern Armory</h5>" +
		"House Stark.<br>" +
		"<b><i>The North.</i></b><br>" +
		"Northern Armory cannot stand.<b>Action:</b> Kneel Northern Armory to choose and stand a [stark] character.+1 Income..<br>" +
		"<i>The Shadow City.</i><br>"
	)
	NORTHERN_ARMORY_TSC ("11003"),
	@GraphQLEnumValue(description="" +
		"<h5>Scheming Septon</h5>" +
		"House Tyrell.<br>" +
		"<b><i>The Seven.</i></b><br>" +
		"Shadow (2).<b>Challenges Action:</b> Draw 1 card and gain 2 gold. Then, place Scheming Septon on top of your deck. (Limit once per phase.).<br>" +
		"<i>The Shadow City.</i><br>"
	)
	SCHEMING_SEPTON_TSC ("11004"),
	@GraphQLEnumValue(description="" +
		"<h5>Margaery's Influence</h5>" +
		"House Tyrell.<br>" +
		"<b><i>Condition.</i></b><br>" +
		"Terminal.<b>Action:</b> While attached character is participating in a challenge, kneel Margaery's Influence and pay 1 gold to stand attached character and remove it from the challenge..<br>" +
		"<i>The Shadow City.</i><br>"
	)
	MARGAERYS_INFLUENCE_TSC ("11005"),
	@GraphQLEnumValue(description="" +
		"<h5>Janos Slynt (TSC)</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Ally.</i></b><br>" +
		"Shadow (0).<b>Forced Reaction:</b> After Janos Slynt comes out of shadows, sacrifice a [thenightswatch] character..<br>" +
		"<i>The Shadow City.</i><br>"
	)
	JANOS_SLYNT_TSC ("11006"),
	@GraphQLEnumValue(description="" +
		"<h5>Fresh Recruits</h5>" +
		"The Night's Watch.<br>" +
		"<b>Action:</b> Search your deck for a <i>Ranger</i> character, a <i>Builder</i> character, and a <i>Steward</i> character, reveal them, and add them to your hand. Shuffle your deck..<br>" +
		"<i>The Shadow City.</i><br>"
	)
	FRESH_RECRUITS_TSC ("11007"),
	@GraphQLEnumValue(description="" +
		"<h5>Shadow Priestess</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Ally. R'hllor.</i></b><br>" +
		"Shadow (3).<b>Reaction:</b> After Shadow Priestess comes out of shadows, choose and kneel a character without attachments..<br>" +
		"<i>The Shadow City.</i><br>"
	)
	SHADOW_PRIESTESS_TSC ("11008"),
	@GraphQLEnumValue(description="" +
		"<h5>Stormlands Fiefdom</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Westeros.</i></b><br>" +
		"<b>Action:</b> Kneel Stormlands Fiefdom to move 1 power from a character or location to its owner's faction card.+1 Income..<br>" +
		"<i>The Shadow City.</i><br>"
	)
	STORMLANDS_FIEFDOM_TSC ("11009"),
	@GraphQLEnumValue(description="" +
		"<h5>Ser Robert Strong</h5>" +
		"House Lannister.<br>" +
		"<b><i>Kingsguard. Knight.</i></b><br>" +
		"Shadow (5).<b>Reaction:</b> After Ser Robert Strong comes out of shadows, choose and kill a kneeling character with printed cost 5 or lower..<br>" +
		"<i>The Shadow City.</i><br>"
	)
	SER_ROBERT_STRONG_TSC ("11010"),
	@GraphQLEnumValue(description="" +
		"<h5>Beneath the Bridge of Dream</h5>" +
		"House Lannister.<br>" +
		"Shadow (0).<b>Interrupt:</b> When you choose a plot card to reveal in the plot phase, instead shuffle your used pile into your plot deck and choose a plot card to reveal at random. Until the end of the round, increase the gold value on your revealed plot card by 2..<br>" +
		"<i>The Shadow City.</i><br>"
	)
	BENEATH_THE_BRIDGE_OF_DREAM_TSC ("11011"),
	@GraphQLEnumValue(description="" +
		"<h5>Nighttime Marauders</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Raider.</i></b><br>" +
		"Pillage. Shadow (3).<b>Reaction:</b> After Nighttime Marauders comes out of shadows, choose a card in an opponent's discard pile. That player reveals his or her hand and discards from it each card with the same printed cost as the chosen card..<br>" +
		"<i>The Shadow City.</i><br>"
	)
	NIGHTTIME_MARAUDERS_TSC ("11012"),
	@GraphQLEnumValue(description="" +
		"<h5>Seize the Initiative</h5>" +
		"House Greyjoy.<br>" +
		"X is the number of opponents you have.<b>Interrupt:</b> When the marshaling phase ends, you become the first player..<br>" +
		"<i>The Shadow City.</i><br>"
	)
	SEIZE_THE_INITIATIVE_TSC ("11013"),
	@GraphQLEnumValue(description="" +
		"<h5>Aegon Targaryen</h5>" +
		"House Targaryen.<br>" +
		"<b><i>Lord.</i></b><br>" +
		"Shadow (3).<b>Reaction:</b> After Aegon Targaryen enters play, search your deck for an <i>Army</i> or <i>Mercenary</i> character, put it into play, and shuffle your deck. At the end of the phase, if that card is still in play, return it to your hand..<br>" +
		"<i>The Shadow City.</i><br>"
	)
	AEGON_TARGARYEN_TSC ("11014"),
	@GraphQLEnumValue(description="" +
		"<h5>Unexpected Return</h5>" +
		"House Targaryen.<br>" +
		"<b>Challenges Action:</b> Choose a character in your discard pile and put it into play..<br>" +
		"<i>The Shadow City.</i><br>"
	)
	UNEXPECTED_RETURN_TSC ("11015"),
	@GraphQLEnumValue(description="" +
		"<h5>Ser Gerris Drinkwater</h5>" +
		"House Martell.<br>" +
		"<b><i>Knight.</i></b><br>" +
		"Renown. Shadow (5).<b>Reaction:</b> After Ser Gerris Drinkwater comes out of shadows, choose a card in your plot deck and switch it with a card in your used pile..<br>" +
		"<i>The Shadow City.</i><br>"
	)
	SER_GERRIS_DRINKWATER_TSC ("11016"),
	@GraphQLEnumValue(description="" +
		"<h5>The Shadow City</h5>" +
		"House Martell.<br>" +
		"<b><i>Dorne.</i></b><br>" +
		"Shadow (2).Reduce the cost to marshal each of your cards into shadows by 1.<b>Challenges Action:</b> Kneel The Shadow City and discard 1 card from shadows to draw 2 cards..<br>" +
		"<i>The Shadow City.</i><br>"
	)
	THE_SHADOW_CITY_TSC ("11017"),
	@GraphQLEnumValue(description="" +
		"<h5>Nefarious Acolyte</h5>" +
		"Neutral.<br>" +
		"<b><i>Maester.</i></b><br>" +
		"Shadow (2).<b>Action:</b> Kneel Nefarious Acolyte and pay 1 gold to choose a plot card. Until the end of the phase, treat it as if its printed text box were blank (except for <i>Traits</i>)..<br>" +
		"<i>The Shadow City.</i><br>"
	)
	NEFARIOUS_ACOLYTE_TSC ("11018"),
	@GraphQLEnumValue(description="" +
		"<h5>Burning the Dead</h5>" +
		"Neutral.<br>" +
		"<b>Action:</b> Remove each non-unique character in each player's dead pile from the game. Draw 1 card..<br>" +
		"<i>The Shadow City.</i><br>"
	)
	BURNING_THE_DEAD_TSC ("11019"),
	@GraphQLEnumValue(description="" +
		"<h5>Exchange of Information</h5>" +
		"Neutral.<br>" +
		"<b><i>Kingdom. Summer.</i></b><br>" +
		"<b>When Revealed:</b> Choose an opponent and reveal the top 10 cards of your deck. That opponent chooses 1 character, 1 location, 1 attachment, and 1 event revealed this way, if able, and adds them to your hand. Shuffle your deck..<br>" +
		"<i>The Shadow City.</i><br>"
	)
	EXCHANGE_OF_INFORMATION_TSC ("11020"),
	@GraphQLEnumValue(description="" +
		"<h5>Wyman Manderly</h5>" +
		"House Stark.<br>" +
		"<b><i>House Manderly. Lord.</i></b><br>" +
		"<b>Action:</b> Sacrifice a character.<b>Reaction:</b> After 1 or more characters you control are sacrificed or killed, stand Wyman Manderly and draw 1 card. (Limit 3 times per round.).<br>" +
		"<i>The March on Winterfell.</i><br>"
	)
	WYMAN_MANDERLY_TMoW ("11021"),
	@GraphQLEnumValue(description="" +
		"<h5>Honor-Bound</h5>" +
		"House Stark.<br>" +
		"<b><i>Condition.</i></b><br>" +
		"During [military] challenges, attached character gets +2 STR.Attached character cannot be declared as an attacker or defender in [intrigue] challenges..<br>" +
		"<i>The March on Winterfell.</i><br>"
	)
	HONOR_BOUND_TMoW ("11022"),
	@GraphQLEnumValue(description="" +
		"<h5>The Queen of Thorns (TMoW)</h5>" +
		"House Tyrell.<br>" +
		"<b><i>Lady.</i></b><br>" +
		"Shadow (4). Stealth.<b>Reaction:</b> After you win a challenge in which The Queen of Thorns is participating, choose a card you control in shadows and put it into play..<br>" +
		"<i>The March on Winterfell.</i><br>"
	)
	THE_QUEEN_OF_THORNS_TMoW ("11023"),
	@GraphQLEnumValue(description="" +
		"<h5>Oldtown Undercity</h5>" +
		"House Tyrell.<br>" +
		"<b><i>Oldtown.</i></b><br>" +
		"Shadow (2).<b>Reaction:</b> After a card you control comes out of shadows, look at the top 3 cards of your deck. Add 1 to your hand, place 1 on the bottom of your deck, and place the other on top of your deck. (Limit once per phase.).<br>" +
		"<i>The March on Winterfell.</i><br>"
	)
	OLDTOWN_UNDERCITY_TMoW ("11024"),
	@GraphQLEnumValue(description="" +
		"<h5>Cunning Steward</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Steward.</i></b><br>" +
		"Shadow (3).While you are the defending player, Cunning Steward gains a [military] and a [power] icon..<br>" +
		"<i>The March on Winterfell.</i><br>"
	)
	CUNNING_STEWARD_TMoW ("11025"),
	@GraphQLEnumValue(description="" +
		"<h5>The Wall (TMoW)</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>The North.</i></b><br>" +
		"Each character you control gains the [thenightswatch] affiliation and loses all other faction affiliations.<b>Action:</b> Kneel The Wall to choose an opponent. Put an eligible character of that player’s choice from his or her discard pile into play under your control..<br>" +
		"<i>The March on Winterfell.</i><br>"
	)
	THE_WALL_TMoW ("11026"),
	@GraphQLEnumValue(description="" +
		"<h5>Ser Justin Massey</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Knight.</i></b><br>" +
		"While you control a <i>King</i> character, Ser Justin Massey gains renown.<b>Reaction:</b> After a [baratheon] character gains power, stand it. (Limit once per phase.).<br>" +
		"<i>The March on Winterfell.</i><br>"
	)
	SER_JUSTIN_MASSEY_TMoW ("11027"),
	@GraphQLEnumValue(description="" +
		"<h5>March on Winterfell</h5>" +
		"House Baratheon.<br>" +
		"Play only during a challenge you initiated.<b>Action:</b> End the challenge with no winner or loser. You may initiate an additional [power] challenge this phase..<br>" +
		"<i>The March on Winterfell.</i><br>"
	)
	MARCH_ON_WINTERFELL_TMoW ("11028"),
	@GraphQLEnumValue(description="" +
		"<h5>Penny</h5>" +
		"House Lannister.<br>" +
		"<b><i>Fool.</i></b><br>" +
		"Shadow (1).While you control more cards in shadows than each opponent, Penny gains an [intrigue] icon and stealth..<br>" +
		"<i>The March on Winterfell.</i><br>"
	)
	PENNY_TMoW ("11029"),
	@GraphQLEnumValue(description="" +
		"<h5>Bowels of Casterly Rock</h5>" +
		"House Lannister.<br>" +
		"<b><i>The Westerlands.</i></b><br>" +
		"<b>Reaction:</b> After a card you control comes out of shadows, either: gain 2 gold, or draw 1 card. (Limit once per phase.).<br>" +
		"<i>The March on Winterfell.</i><br>"
	)
	BOWELS_OF_CASTERLY_ROCK_TMoW ("11030"),
	@GraphQLEnumValue(description="" +
		"<h5>Hagen's Daughter</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Ironborn.</i></b><br>" +
		"Shadow (2).<b>Interrupt:</b> When Hagen’s Daughter would be killed, save her and return her to shadows..<br>" +
		"<i>The March on Winterfell.</i><br>"
	)
	HAGENS_DAUGHTER_TMoW ("11031"),
	@GraphQLEnumValue(description="" +
		"<h5>\"Steel Rain\"</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Song.</i></b><br>" +
		"Shadow (2).<b>Action:</b> Sacrifice any number of [greyjoy] locations. For each location sacrificed, search your deck for a different [greyjoy] location with equal or lower printed cost and put it into play. Shuffle your deck..<br>" +
		"<i>The March on Winterfell.</i><br>"
	)
	STEEL_RAIN_TMoW ("11032"),
	@GraphQLEnumValue(description="" +
		"<h5>Hizdahr zo Loraq</h5>" +
		"House Targaryen.<br>" +
		"<b><i>King.</i></b><br>" +
		"<b>Action:</b> Discard 1 card from your hand to reduce the cost of the next card you marshal, ambush, or bring out of shadows this phase by 3. (Limit once per phase.).<br>" +
		"<i>The March on Winterfell.</i><br>"
	)
	HIZDAHR_ZO_LORAQ_TMoW ("11033"),
	@GraphQLEnumValue(description="" +
		"<h5>Meereen</h5>" +
		"House Targaryen.<br>" +
		"<b><i>Meereen.</i></b><br>" +
		"<b>Action:</b> Kneel Meereen to place each card in your hand facedown under Meereen and draw 3 cards. At the end of the phase, or if Meereen leaves play, discard your hand and return each card you placed under Meereen to your hand..<br>" +
		"<i>The March on Winterfell.</i><br>"
	)
	MEEREEN_TMoW ("11034"),
	@GraphQLEnumValue(description="" +
		"<h5>Maiden of Poisons</h5>" +
		"House Martell.<br>" +
		"<b><i>Bastard. Sand Snake.</i></b><br>" +
		"Shadow (2).<b>Reaction:</b> After you lose a challenge in which Maiden of Poisons is participating, sacrifice it to choose a participating character with fewer than 2 challenge icons and return it to its owner’s hand..<br>" +
		"<i>The March on Winterfell.</i><br>"
	)
	MAIDEN_OF_POISONS_TMoW ("11035"),
	@GraphQLEnumValue(description="" +
		"<h5>Serve. Obey. Protect.</h5>" +
		"House Martell.<br>" +
		"Play only if you have lost a challenge as the defending player this phase.<b>Reaction:</b> After an opponent initiates a challenge against you, return a [martell] character to your hand to put a different [martell] character with printed cost 5 or lower into play from your hand..<br>" +
		"<i>The March on Winterfell.</i><br>"
	)
	SERVE_OBEY_PROTECT_TMoW ("11036"),
	@GraphQLEnumValue(description="" +
		"<h5>Tycho Nestoris</h5>" +
		"Neutral.<br>" +
		"<b><i>Ally.</i></b><br>" +
		"You cannot win the game.<b>Action:</b> Pay 6 gold to treat Tycho Nestoris’s printed text box as if it were blank (except for <i>Traits</i>) until the end of the phase.+3 Income..<br>" +
		"<i>The March on Winterfell.</i><br>"
	)
	TYCHO_NESTORIS_TMoW ("11037"),
	@GraphQLEnumValue(description="" +
		"<h5>City Gates</h5>" +
		"Neutral.<br>" +
		"<b><i>King's Landing.</i></b><br>" +
		"Limited.<b>Action:</b> Pay 1 gold and discard City Gates from your hand to draw 1 card.+1 Income..<br>" +
		"<i>The March on Winterfell.</i><br>"
	)
	CITY_GATES_TMoW ("11038"),
	@GraphQLEnumValue(description="" +
		"<h5>Trading With Qohor</h5>" +
		"Neutral.<br>" +
		"<b><i>Banner.</i></b><br>" +
		"While you control no attachments, increase the gold value on each opponent’s revealed plot card by 1.<b>Reaction:</b> After claim is applied for a challenge you won, sacrifice an attachment to search your deck for a different attachment with equal or lower printed cost and put it into play..<br>" +
		"<i>The March on Winterfell.</i><br>"
	)
	TRADING_WITH_QOHOR_TMoW ("11039"),
	@GraphQLEnumValue(description="" +
		"<h5>The Bloody Flux</h5>" +
		"Neutral.<br>" +
		"<b><i>Omen.</i></b><br>" +
		"Characters cannot be saved..<br>" +
		"<i>The March on Winterfell.</i><br>"
	)
	THE_BLOODY_FLUX_TMoW ("11040"),
	@GraphQLEnumValue(description="" +
		"<h5>Umber Loyalist</h5>" +
		"House Stark.<br>" +
		"<b><i>House Umber.</i></b><br>" +
		"<b>Reaction:</b> After Umber Loyalist enters play, draw 2 cards.<b>Forced Interrupt:</b> When Umber Loyalist leaves play, choose and discard 2 cards from your hand..<br>" +
		"<i>Streets of King's Landing.</i><br>"
	)
	UMBER_LOYALIST_SoKL ("11041"),
	@GraphQLEnumValue(description="" +
		"<h5>White Harbor</h5>" +
		"House Stark.<br>" +
		"<b><i>House Manderly. The North.</i></b><br>" +
		"<b>Reaction:</b> After you win a challenge, reveal the top 2 cards of your deck. The losing opponent chooses 1 of those cards. Add that card to your hand, and place the other on the bottom of your deck..<br>" +
		"<i>Streets of King's Landing.</i><br>"
	)
	WHITE_HARBOR_SoKL ("11042"),
	@GraphQLEnumValue(description="" +
		"<h5>Lazy Leo</h5>" +
		"House Tyrell.<br>" +
		"<b><i>Maester.</i></b><br>" +
		"Shadow (2).<b>Reaction:</b> After Lazy Leo comes out of shadows, choose a player. Shuffle any number of events from that player's discard pile into his or her deck..<br>" +
		"<i>Streets of King's Landing.</i><br>"
	)
	LAZY_LEO_SoKL ("11043"),
	@GraphQLEnumValue(description="" +
		"<h5>Growing Ambition</h5>" +
		"House Tyrell.<br>" +
		"Shadow (X).<b>Challenges Action:</b> Search your deck for X different cards and place them in your discard pile. Shuffle your deck. Then, choose an opponent. Return X cards of that opponent's choice from your discard pile to your hand..<br>" +
		"<i>Streets of King's Landing.</i><br>"
	)
	GROWING_AMBITION_SoKL ("11044"),
	@GraphQLEnumValue(description="" +
		"<h5>Naive Scout</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Ally. Ranger.</i></b><br>" +
		"No attachments except <i>Weapon</i>.While there is a card in shadows, Naive Scout cannot be declared as a defender..<br>" +
		"<i>Streets of King's Landing.</i><br>"
	)
	NAIVE_SCOUT_SoKL ("11045"),
	@GraphQLEnumValue(description="" +
		"<h5>Miner's Pick</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Item. Weapon.</i></b><br>" +
		"<i>Builder</i> or <i>Steward</i> character only.Attached character gets +1 STR.+1 Income..<br>" +
		"<i>Streets of King's Landing.</i><br>"
	)
	MINERS_PICK_SoKL ("11046"),
	@GraphQLEnumValue(description="" +
		"<h5>Valyrian's Crew</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Mercenary. Smuggler.</i></b><br>" +
		"Stealth.You may marshal or play facedown cards attached to Valyrian's Crew as if they were in your hand.<b>Reaction:</b> After you win a challenge in which Valyrian's Crew is attacking, attach the top card of the losing opponent's deck to Valyrian's Crew facedown under your control, as an attachment with terminal..<br>" +
		"<i>Streets of King's Landing.</i><br>"
	)
	VALYRIANS_CREW_SoKL ("11047"),
	@GraphQLEnumValue(description="" +
		"<h5>Blackwater Bay</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Westeros.</i></b><br>" +
		"<b>Reaction:</b> After the challenges phase begins, kneel Blackwater Bay to choose an opponent. Draw 1 card for each kneeling character that player controls..<br>" +
		"<i>Streets of King's Landing.</i><br>"
	)
	BLACKWATER_BAY_SoKL ("11048"),
	@GraphQLEnumValue(description="" +
		"<h5>Catspaw</h5>" +
		"House Lannister.<br>" +
		"<b><i>Ally.</i></b><br>" +
		"Shadow (2).<b>Reaction:</b> After Catspaw comes out of shadows, pay X gold to choose another character with printed cost X or lower and return it to its owner's hand..<br>" +
		"<i>Streets of King's Landing.</i><br>"
	)
	CATSPAW_SoKL ("11049"),
	@GraphQLEnumValue(description="" +
		"<h5>Gold Mine</h5>" +
		"House Lannister.<br>" +
		"<b><i>The Westerlands.</i></b><br>" +
		"<b>Action:</b> Kneel Gold Mine and discard 1 card from your hand to draw 1 card.+1 Income..<br>" +
		"<i>Streets of King's Landing.</i><br>"
	)
	GOLD_MINE_SoKL ("11050"),
	@GraphQLEnumValue(description="" +
		"<h5>Drowned God Fanatic</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Drowned God.</i></b><br>" +
		"<b>Action:</b> Kill a character to put Drowned God Fanatic into play from your dead pile. (Max once per round.)<b>Interrupt:</b> When the effects of an opponent's triggered character ability would initiate, place Drowned God Fanatic into your dead pile from your hand to cancel those effects..<br>" +
		"<i>Streets of King's Landing.</i><br>"
	)
	DROWNED_GOD_FANATIC_SoKL ("11051"),
	@GraphQLEnumValue(description="" +
		"<h5>Dragonbinder</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Item.</i></b><br>" +
		"Character you control only.Attached character gains intimidate.<b>Reaction:</b> After you win dominance, kill attached character to, either: choose and take control of a <i>Dragon</i> character, or search the top 10 cards of your deck for a [greyjoy] character, put into play, and shuffle your deck..<br>" +
		"<i>Streets of King's Landing.</i><br>"
	)
	DRAGONBINDER_SoKL ("11052"),
	@GraphQLEnumValue(description="" +
		"<h5>Hired Assassin</h5>" +
		"House Targaryen.<br>" +
		"<b><i>Mercenary.</i></b><br>" +
		"Shadow (2).<b>Reaction:</b> After Hired Assassin comes out of shadows, look at a card in shadows. If it is a character, you may place it in its owner's dead pile..<br>" +
		"<i>Streets of King's Landing.</i><br>"
	)
	HIRED_ASSASSIN_SoKL ("11053"),
	@GraphQLEnumValue(description="" +
		"<h5>Queensguard</h5>" +
		"House Targaryen.<br>" +
		"<b><i>Title.</i></b><br>" +
		"Non-<i>Lady</i> character only. Shadow (2).<b>Action:</b> Discard 1 card from your hand to stand attached character. (Limit 3 times per round.).<br>" +
		"<i>Streets of King's Landing.</i><br>"
	)
	QUEENSGUARD_SoKL ("11054"),
	@GraphQLEnumValue(description="" +
		"<h5>Ser Archibald Yronwood</h5>" +
		"House Martell.<br>" +
		"<b><i>House Yronwood. Knight.</i></b><br>" +
		"Shadow (4). No attachments except <i>Weapon</i>.<b>Reaction:</b> After you lose dominance, the winning opponent must choose and kill a character he or she controls..<br>" +
		"<i>Streets of King's Landing.</i><br>"
	)
	SER_ARCHIBALD_YRONWOOD_SoKL ("11055"),
	@GraphQLEnumValue(description="" +
		"<h5>Summer Sea Port</h5>" +
		"House Martell.<br>" +
		"<b><i>Dorne.</i></b><br>" +
		"+1 Income. +1 Reserve..<br>" +
		"<i>Streets of King's Landing.</i><br>"
	)
	SUMMER_SEA_PORT_SoKL ("11056"),
	@GraphQLEnumValue(description="" +
		"<h5>Poor Fellows</h5>" +
		"Neutral.<br>" +
		"<b><i>Army. The Seven.</i></b><br>" +
		"No attachments.<b>Reaction:</b> After you win a challenge in which Poor Fellows is attacking, the losing opponent chooses, either: Poor Fellows gains 1 power, or you draw 1 card..<br>" +
		"<i>Streets of King's Landing.</i><br>"
	)
	POOR_FELLOWS_SoKL ("11057"),
	@GraphQLEnumValue(description="" +
		"<h5>King's Landing</h5>" +
		"Neutral.<br>" +
		"<b><i>King's Landing.</i></b><br>" +
		"Once per marshaling phase, you may marshal a location from your discard pile as if it were in your hand.<b>Challenges Action:</b> Kneel King's Landing and discard 1 location from your hand to draw 1 card..<br>" +
		"<i>Streets of King's Landing.</i><br>"
	)
	KINGS_LANDING_SoKL ("11058"),
	@GraphQLEnumValue(description="" +
		"<h5>Glass Candle</h5>" +
		"Neutral.<br>" +
		"<b><i>Item. The Citadel.</i></b><br>" +
		"Character you control only.If attached character has the <i>Maester</i> trait, it gains insight.<b>Challenges Action:</b> Kneel Glass Candle to look at the top card of any player's deck. You may discard that card..<br>" +
		"<i>Streets of King's Landing.</i><br>"
	)
	GLASS_CANDLE_SoKL ("11059"),
	@GraphQLEnumValue(description="" +
		"<h5>Uneasy Truce</h5>" +
		"Neutral.<br>" +
		"<b><i>Edict.</i></b><br>" +
		"Each player cannot gain power for his or her faction except during challenges.<b>Forced Reaction:</b> After a challenge is initiated, move 1 power from the attacking player's faction card to the defending player's faction card..<br>" +
		"<i>Streets of King's Landing.</i><br>"
	)
	UNEASY_TRUCE_SoKL ("11060"),
	@GraphQLEnumValue(description="" +
		"<h5>Meera Reed</h5>" +
		"House Stark.<br>" +
		"<b><i>House Reed. Lady.</i></b><br>" +
		"Shadow (1). Stealth.<b>Reaction:</b> After a [stark] character you control is sacrificed, return Meera Reed to shadows.<b>Reaction:</b> After Meera Reed comes out of shadows, choose a character. Until the end of the phase, treat it as if its printed text box were blank (except for <i>Traits</i>)..<br>" +
		"<i>Music of Dragons.</i><br>"
	)
	MEERA_REED_MoD ("11061"),
	@GraphQLEnumValue(description="" +
		"<h5>Shaggydog (MoD)</h5>" +
		"House Stark.<br>" +
		"<b><i>Direwolf.</i></b><br>" +
		"[stark] character you control only.<b>Reaction:</b> After you win a challenge in which attached character is attacking, the losing opponent must choose and kill a defending character.<b>Action:</b> Pay 1 gold to attach Shaggydog to a different character. (Limit once per phase.).<br>" +
		"<i>Music of Dragons.</i><br>"
	)
	SHAGGYDOG_MoD ("11062"),
	@GraphQLEnumValue(description="" +
		"<h5>Ser Mark Mullendore</h5>" +
		"House Tyrell.<br>" +
		"<b><i>Knight.</i></b><br>" +
		"<b>Reaction:</b> After you win a challenge in which Ser Mark Mullendore is participating, reveal the top card of your deck. You may put that card into play. If you do, place Ser Mark Mullendore on top of your deck (cannot be saved)..<br>" +
		"<i>Music of Dragons.</i><br>"
	)
	SER_MARK_MULLENDORE_MoD ("11063"),
	@GraphQLEnumValue(description="" +
		"<h5>Bonds of Chivalry</h5>" +
		"House Tyrell.<br>" +
		"<b>Action:</b> Choose a participating <i>Knight</i> character you control. Stand it and remove it from the challenge. Then, you may kneel another <i>Knight</i> character you control to have it participate in the challenge on your side..<br>" +
		"<i>Music of Dragons.</i><br>"
	)
	BONDS_OF_CHIVALRY_MoD ("11064"),
	@GraphQLEnumValue(description="" +
		"<h5>Jon Snow (MoD)</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Bastard. Commander. Lord.</i></b><br>" +
		"While you control a:- <i>Builder</i> character, Jon Snow gains stealth.- <i>Ranger</i> character, Jon Snow gains intimidate.- <i>Steward</i> character, Jon Snow gains insight..<br>" +
		"<i>Music of Dragons.</i><br>"
	)
	JON_SNOW_MoD ("11065"),
	@GraphQLEnumValue(description="" +
		"<h5>Lord Commander</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Title.</i></b><br>" +
		"[thenightswatch] character with printed cost 5 or higher only.<b>Reaction:</b> After you win a challenge in which you control a participating [thenightswatch] character, attached character gains 1 power..<br>" +
		"<i>Music of Dragons.</i><br>"
	)
	LORD_COMMANDER_MoD ("11066"),
	@GraphQLEnumValue(description="" +
		"<h5>Shireen Baratheon (MoD)</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Lady.</i></b><br>" +
		"Shadow (3).<b>Action:</b> During a challenge in which Shireen Baratheon is participating, choose a participating character. That character and Shireen Baratheon do not contribute their STR to the challenge. (Limit once per challenge.).<br>" +
		"<i>Music of Dragons.</i><br>"
	)
	SHIREEN_BARATHEON_MoD ("11067"),
	@GraphQLEnumValue(description="" +
		"<h5>Privileged Position</h5>" +
		"House Baratheon.<br>" +
		"Play only if you have not lost a [power] challenge this round.<b>Interrupt:</b> When the effects of an opponent's event or triggered location ability would initiate, cancel those effects..<br>" +
		"<i>Music of Dragons.</i><br>"
	)
	PRIVILEGED_POSITION_MoD ("11068"),
	@GraphQLEnumValue(description="" +
		"<h5>Tithe Collector</h5>" +
		"House Lannister.<br>" +
		"<b><i>Ally. The Seven.</i></b><br>" +
		"<b>Reaction:</b> After you collect income, pay 2 gold to have Tithe Collector gain 1 power.+1 Income..<br>" +
		"<i>Music of Dragons.</i><br>"
	)
	TITHE_COLLECTOR_MoD ("11069"),
	@GraphQLEnumValue(description="" +
		"<h5>Clever Feint</h5>" +
		"House Lannister.<br>" +
		"<b>Action:</b> Kneel your faction card to choose any number of cards you control with shadow. Return each of those cards to shadows..<br>" +
		"<i>Music of Dragons.</i><br>"
	)
	CLEVER_FEINT_MoD ("11070"),
	@GraphQLEnumValue(description="" +
		"<h5>Victarion Greyjoy (MoD)</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Captain. Ironborn. Lord.</i></b><br>" +
		"<b>Challenges Action:</b> Kneel a <i>Warship</i> location to (choose 1):- choose and kneel a location.- stand Victarion Greyjoy.- have Victarion Greyjoy gain renown until the end of the challenge..<br>" +
		"<i>Music of Dragons.</i><br>"
	)
	VICTARION_GREYJOY_MoD ("11071"),
	@GraphQLEnumValue(description="" +
		"<h5>Grey Ghost</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Warship.</i></b><br>" +
		"Shadow (2).<b>Action:</b> Kneel Grey Ghost to choose 1 character (up to 2 characters instead if Grey Ghost came out of shadows this phase). Until the end of the phase, each chosen character cannot be declared as a defender..<br>" +
		"<i>Music of Dragons.</i><br>"
	)
	GREY_GHOST_MoD ("11072"),
	@GraphQLEnumValue(description="" +
		"<h5>Rhaegal (MoD)</h5>" +
		"House Targaryen.<br>" +
		"<b><i>Dragon.</i></b><br>" +
		"Ambush (5). No attachments.<b>Reaction:</b> After an opponent's character is killed by a card effect, stand Rhaegal..<br>" +
		"<i>Music of Dragons.</i><br>"
	)
	RHAEGAL_MoD ("11073"),
	@GraphQLEnumValue(description="" +
		"<h5>Meereenese Market</h5>" +
		"House Targaryen.<br>" +
		"<b><i>Meereen.</i></b><br>" +
		"<b>Action:</b> Kneel Meereenese Market to choose a card in a discard pile and place it on the bottom of its owner's deck.+1 Income..<br>" +
		"<i>Music of Dragons.</i><br>"
	)
	MEEREENESE_MARKET_MoD ("11074"),
	@GraphQLEnumValue(description="" +
		"<h5>House Manwoody Guard</h5>" +
		"House Martell.<br>" +
		"<b><i>Guard. House Manwoody.</i></b><br>" +
		"While you are not the first player, each <i>Guard</i> character you control does not kneel when declared as a defender..<br>" +
		"<i>Music of Dragons.</i><br>"
	)
	HOUSE_MANWOODY_GUARD_MoD ("11075"),
	@GraphQLEnumValue(description="" +
		"<h5>A Mission in Essos</h5>" +
		"House Martell.<br>" +
		"Shadow (2).<b>Action:</b> Remove all but the bottom card of your deck from the game facedown. Then, shuffle your discard pile into your deck and draw 3 cards..<br>" +
		"<i>Music of Dragons.</i><br>"
	)
	A_MISSION_IN_ESSOS_MoD ("11076"),
	@GraphQLEnumValue(description="" +
		"<h5>Wun Wun</h5>" +
		"Neutral.<br>" +
		"<b><i>Giant. Wildling.</i></b><br>" +
		"No attachments except <i>Weapon</i>.<b>Action:</b> Kneel Wun Wun to have him participate in a challenge in which you control a participating <i>Wildling</i> character..<br>" +
		"<i>Music of Dragons.</i><br>"
	)
	WUN_WUN_MoD ("11077"),
	@GraphQLEnumValue(description="" +
		"<h5>Poisoned Coin</h5>" +
		"Neutral.<br>" +
		"Shadow (0).<b>Reaction:</b> After you win an unopposed challenge in which you control an attacking character with shadow, place a poison token on a character without shadow controlled by the losing opponen. At the end of the phase, if that character still has that poison token, remove it and kill that character. (Max 1 per challenge.).<br>" +
		"<i>Music of Dragons.</i><br>"
	)
	POISONED_COIN_MoD ("11078"),
	@GraphQLEnumValue(description="" +
		"<h5>The Free Folk</h5>" +
		"Neutral.<br>" +
		"Your plot deck and draw deck can only include neutral cards.<b>Reaction:</b> After claim is applied for a challenge in which you control an attacking <i>Wildling</i> character, kneel your faction card to apply the claim of another challenge type..<br>" +
		"<i>Music of Dragons.</i><br>"
	)
	THE_FREE_FOLK_MoD ("11079"),
	@GraphQLEnumValue(description="" +
		"<h5>Winter Reserves</h5>" +
		"Neutral.<br>" +
		"<b><i>Kingdom. Winter.</i></b><br>" +
		"While Winter Reserves is in your used pile, increase the gold value and reserve value on your revealed <i>Winter</i> plot card by 1..<br>" +
		"<i>Music of Dragons.</i><br>"
	)
	WINTER_RESERVES_MoD ("11080"),
	@GraphQLEnumValue(description="" +
		"<h5>Bear Island Scout</h5>" +
		"House Stark.<br>" +
		"<b><i>House Mormont.</i></b><br>" +
		"<b>Reaction:</b> After you marshal Bear Island Scout, if each character you control has the [stark] affiliation, search your deck for a <i>House Mormont</i> card, reveal it, and add it to your hand. Shuffle your deck..<br>" +
		"<i>In Daznak's Pit.</i><br>"
	)
	BEAR_ISLAND_SCOUT_IDP ("11081"),
	@GraphQLEnumValue(description="" +
		"<h5>Skagos</h5>" +
		"House Stark.<br>" +
		"<b><i>The North.</i></b><br>" +
		"Shadow (1).<b>Action:</b> Kneel Skagos and sacrifice a standing [stark] card to search your deck for a card with the same title as the sacrificed card and put it into play. Shuffle your deck..<br>" +
		"<i>In Daznak's Pit.</i><br>"
	)
	SKAGOS_IDP ("11082"),
	@GraphQLEnumValue(description="" +
		"<h5>Brightwater Host</h5>" +
		"House Tyrell.<br>" +
		"<b><i>Army. House Florent.</i></b><br>" +
		"No attachments.<b>Reaction:</b> After you win a challenge in which Brightwater Host is attacking, choose 1 card in shadows and return it to its owner's hand. Then, a unique [tyrell] character you control gains 2 power..<br>" +
		"<i>In Daznak's Pit.</i><br>"
	)
	BRIGHTWATER_HOST_IDP ("11083"),
	@GraphQLEnumValue(description="" +
		"<h5>The Might of the Reach</h5>" +
		"House Tyrell.<br>" +
		"<b>Challenges Action:</b> Choose a participating character. Until the end of the challenge, that character gets +10 STR..<br>" +
		"<i>In Daznak's Pit.</i><br>"
	)
	THE_MIGHT_OF_THE_REACH_IDP ("11084"),
	@GraphQLEnumValue(description="" +
		"<h5>Three-Finger Hobb</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Steward.</i></b><br>" +
		"No attachments except <i>Weapon</i>.<b>Reaction:</b> After you check reserve, if your hand size is lower than your reserve value, draw 2 cards..<br>" +
		"<i>In Daznak's Pit.</i><br>"
	)
	THREE_FINGER_HOBB_IDP ("11085"),
	@GraphQLEnumValue(description="" +
		"<h5>Hardhome</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>The North.</i></b><br>" +
		"Shadow (2).<b>Dominance Action:</b> Kneel and sacrifice Hardhome to choose an opponent. That player sacrifices a standing character..<br>" +
		"<i>In Daznak's Pit.</i><br>"
	)
	HARDHOME_IDP ("11086"),
	@GraphQLEnumValue(description="" +
		"<h5>Storm's End Maester</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Maester.</i></b><br>" +
		"<b>Challenges Action:</b> Kneel Storm's End Maester to choose an opponent. If you have more power on your faction card than that player, draw 1 card..<br>" +
		"<i>In Daznak's Pit.</i><br>"
	)
	STORMS_END_MAESTER_IDP ("11087"),
	@GraphQLEnumValue(description="" +
		"<h5>Glamor</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Item. R'hllor.</i></b><br>" +
		"Character you control only. Shadow (2). Terminal.Attached character gets +2 STR.<b>Action:</b> Kill attached character to choose a character in your dead pile that was killed this phase. Return the chosen character to play..<br>" +
		"<i>In Daznak's Pit.</i><br>"
	)
	GLAMOR_IDP ("11088"),
	@GraphQLEnumValue(description="" +
		"<h5>Painted Dogs</h5>" +
		"House Lannister.<br>" +
		"<b><i>Clansman.</i></b><br>" +
		"Ambush (4).<b>Challenges Action:</b> Return Painted Dogs to your hand to choose and stand a <i>Clansman</i> character or Tyrion Lannister..<br>" +
		"<i>In Daznak's Pit.</i><br>"
	)
	PAINTED_DOGS_IDP ("11089"),
	@GraphQLEnumValue(description="" +
		"<h5>Walk of Atonement</h5>" +
		"House Lannister.<br>" +
		"<b><i>The Seven.</i></b><br>" +
		"<b>Dominance Action:</b> Discard any amount of power from a character you control. For each power discarded, discard 1 card at random from each opponent's hand and draw 1 card..<br>" +
		"<i>In Daznak's Pit.</i><br>"
	)
	WALK_OF_ATONEMENT_IDP ("11090"),
	@GraphQLEnumValue(description="" +
		"<h5>Iron Victory's Crew</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Ironborn. Raider.</i></b><br>" +
		"No attachments.<b>Reaction:</b> After Iron Victory's Crew enters play, search your deck for a <i>Warship</i> location, reveal it, and add it to your hand (put it into play instead if it is Iron Victory). Shuffle your deck..<br>" +
		"<i>In Daznak's Pit.</i><br>"
	)
	IRON_VICTORYS_CREW_IDP ("11091"),
	@GraphQLEnumValue(description="" +
		"<h5>Refurbished Hulk</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Warship.</i></b><br>" +
		"+1 Income.+1 Initiative..<br>" +
		"<i>In Daznak's Pit.</i><br>"
	)
	REFURBISHED_HULK_IDP ("11092"),
	@GraphQLEnumValue(description="" +
		"<h5>Drogon (IDP)</h5>" +
		"House Targaryen.<br>" +
		"<b><i>Dragon.</i></b><br>" +
		"Ambush (6). No attachments.<b>Reaction:</b> After you win a challenge in which Drogon is attacking, choose a character controlled by the losing opponent. Until the end of the phase, that character gets -4 STR and is killed if its STR is 0..<br>" +
		"<i>In Daznak's Pit.</i><br>"
	)
	DROGON_IDP ("11093"),
	@GraphQLEnumValue(description="" +
		"<h5>In Daznak's Pit</h5>" +
		"House Targaryen.<br>" +
		"Shadow (3).<b>Interrupt:</b> When the challenges phase ends, stand each character. Following this phase, there is an additional challenges phase. (Max 1 per round.).<br>" +
		"<i>In Daznak's Pit.</i><br>"
	)
	IN_DAZNAKS_PIT_IDP ("11094"),
	@GraphQLEnumValue(description="" +
		"<h5>Maester Myles</h5>" +
		"House Martell.<br>" +
		"<b><i>Maester.</i></b><br>" +
		"<b>Challenges Action:</b> Kneel Maester Myles to choose a character with printed cost equal to or lower than the number of plot cards in your used pile. Until the end of the phase, that character loses a challenge icon of your choice..<br>" +
		"<i>In Daznak's Pit.</i><br>"
	)
	MAESTER_MYLES_IDP ("11095"),
	@GraphQLEnumValue(description="" +
		"<h5>He Calls It Thinking</h5>" +
		"House Martell.<br>" +
		"<b>Interrupt:</b> When the effects of an opponent's non-agenda, non-plot triggered ability would initiate, cancel those effects unless that player pays 1 gold..<br>" +
		"<i>In Daznak's Pit.</i><br>"
	)
	HE_CALLS_IT_THINKING_IDP ("11096"),
	@GraphQLEnumValue(description="" +
		"<h5>Old Bill Bone</h5>" +
		"Neutral.<br>" +
		"<b><i>Mercenary.</i></b><br>" +
		"Shadow (1).<b>Reaction:</b> After Old Bill Bone comes out of shadows, kneel each opponent's faction card..<br>" +
		"<i>In Daznak's Pit.</i><br>"
	)
	OLD_BILL_BONE_IDP ("11097"),
	@GraphQLEnumValue(description="" +
		"<h5>The Inn at the Crossroads</h5>" +
		"Neutral.<br>" +
		"<b><i>Riverlands.</i></b><br>" +
		"Shadow (1).<b>Dominance Action:</b> Kneel The Inn at the Crossroads to draw 3 cards and choose an opponent. Give control of The Inn at the Crossroads to that player..<br>" +
		"<i>In Daznak's Pit.</i><br>"
	)
	THE_INN_AT_THE_CROSSROADS_IDP ("11098"),
	@GraphQLEnumValue(description="" +
		"<h5>A Pinch of Powder</h5>" +
		"Neutral.<br>" +
		"<b><i>Item. Weapon.</i></b><br>" +
		"Shadow (1).<b>Reaction:</b> After you win an [intrigue] or [power] challenge by 5 or more STR as the attacking player, return attached character to its owner's hand..<br>" +
		"<i>In Daznak's Pit.</i><br>"
	)
	A_PINCH_OF_POWDER_IDP ("11099"),
	@GraphQLEnumValue(description="" +
		"<h5>Double-Dealing</h5>" +
		"Neutral.<br>" +
		"<b><i>Scheme.</i></b><br>" +
		"<b>Plot Action:</b> Choose a plot card in an opponent's used pile. Double-Dealing gains that plot card's printed text box (except for <i>Traits</i>) until you reveal a new plot card. (Limit once per round.).<br>" +
		"<i>In Daznak's Pit.</i><br>"
	)
	DOUBLE_DEALING_IDP ("11100"),
	@GraphQLEnumValue(description="" +
		"<h5>Ser Jason Mallister</h5>" +
		"House Stark.<br>" +
		"<b><i>House Tully. Knight. Lord.</i></b><br>" +
		"While there are no cards in shadows, Ser Jason Mallister gains renown.<b>Reaction:</b> After you win a challenge in which Ser Jason Mallister is attacking, choose a card in shadows controlled by the losing opponent, and discard it..<br>" +
		"<i>Daggers in the Dark.</i><br>"
	)
	SER_JASON_MALLISTER_DitD ("11101"),
	@GraphQLEnumValue(description="" +
		"<h5>The Bastard's Letter</h5>" +
		"House Stark.<br>" +
		"<b><i>House Bolton.</i></b><br>" +
		"Shadow (3).<b>Reaction:</b> After an opponent initiates a [military] challenge against you, stand any number of characters you control with a [military] icon. If you win the challenge, kill each attacking character..<br>" +
		"<i>Daggers in the Dark.</i><br>"
	)
	THE_BASTARDS_LETTER_DitD ("11102"),
	@GraphQLEnumValue(description="" +
		"<h5>Shrewd Diplomat</h5>" +
		"House Tyrell.<br>" +
		"<b><i>Ally. Spy.</i></b><br>" +
		"Ambush (5). Shadow (3).<b>Reaction:</b> After Shrewd Diplomat enters play during a challenge, choose a participating character. Stand that character and remove it from the challenge..<br>" +
		"<i>Daggers in the Dark.</i><br>"
	)
	SHREWD_DIPLOMAT_DitD ("11103"),
	@GraphQLEnumValue(description="" +
		"<h5>Arbor Marketplace</h5>" +
		"House Tyrell.<br>" +
		"<b><i>House Redwyne.</i></b><br>" +
		"<b>Challenges Action:</b> Kneel Arbor Marketplace to choose a participating character. Until the end of the challenge, that character gets +1 STR.+1 Income..<br>" +
		"<i>Daggers in the Dark.</i><br>"
	)
	ARBOR_MARKETPLACE_DitD ("11104"),
	@GraphQLEnumValue(description="" +
		"<h5>Nightfort Builder</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Builder.</i></b><br>" +
		"<b>Reaction:</b> After Nightfort Builder is knelt, reveal the top card of your deck. If it is a [thenightswatch] location or attachment, draw it..<br>" +
		"<i>Daggers in the Dark.</i><br>"
	)
	NIGHTFORT_BUILDER_DitD ("11105"),
	@GraphQLEnumValue(description="" +
		"<h5>Daggers in the Dark</h5>" +
		"The Night's Watch.<br>" +
		"Shadow (2).<b>Reaction:</b> After you win a challenge as the defending player, choose and kill an attacking character. The attacking player may sacrifice 2 characters to cancel this effect..<br>" +
		"<i>Daggers in the Dark.</i><br>"
	)
	DAGGERS_IN_THE_DARK_DitD ("11106"),
	@GraphQLEnumValue(description="" +
		"<h5>Red Ronnet</h5>" +
		"House Baratheon.<br>" +
		"<b><i>House Connington. Knight.</i></b><br>" +
		"No attachments except <i>Weapon</i>.While Red Ronnet is attacking, if the defending player controls a card in shadows, raise the claim value on your revealed plot card by 1..<br>" +
		"<i>Daggers in the Dark.</i><br>"
	)
	RED_RONNET_DitD ("11107"),
	@GraphQLEnumValue(description="" +
		"<h5>Banished from the Light</h5>" +
		"House Baratheon.<br>" +
		"Shadow (2).<b>Reaction:</b> After you win a [power] challenge, choose a character. Place it in shadows with a shadow token on it. While that card is in shadows, it gains shadow (X). X is its printed cost..<br>" +
		"<i>Daggers in the Dark.</i><br>"
	)
	BANISHED_FROM_THE_LIGHT_DitD ("11108"),
	@GraphQLEnumValue(description="" +
		"<h5>Cersei Lannister (DitD)</h5>" +
		"House Lannister.<br>" +
		"<b><i>Lady.</i></b><br>" +
		"Shadow (5).<b>Reaction:</b> After a card you control comes out of shadows during the challenges phase, each opponent discards 1 card at random from his or her hand. (Limit 3 times per phase.).<br>" +
		"<i>Daggers in the Dark.</i><br>"
	)
	CERSEI_LANNISTER_DitD ("11109"),
	@GraphQLEnumValue(description="" +
		"<h5>Underhanded Methods</h5>" +
		"House Lannister.<br>" +
		"<b><i>Skill.</i></b><br>" +
		"Shadow (0).Attached character gets +1 STR for each card you control in shadows..<br>" +
		"<i>Daggers in the Dark.</i><br>"
	)
	UNDERHANDED_METHODS_DitD ("11110"),
	@GraphQLEnumValue(description="" +
		"<h5>Moqorro</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Ally. R'hllor.</i></b><br>" +
		"Shadow (5).<b>Reaction:</b> After Moqorro comes out of shadows during a challenge, choose a defending character and place it on top of its owner's deck..<br>" +
		"<i>Daggers in the Dark.</i><br>"
	)
	MOQORRO_DitD ("11111"),
	@GraphQLEnumValue(description="" +
		"<h5>Rhymes With Meek</h5>" +
		"House Greyjoy.<br>" +
		"Shadow (0).<b>Reaction:</b> After you win an unopposed challenge, draw 2 cards (3 cards instead if you played this event from shadows)..<br>" +
		"<i>Daggers in the Dark.</i><br>"
	)
	RHYMES_WITH_MEEK_DitD ("11112"),
	@GraphQLEnumValue(description="" +
		"<h5>Brazen Beast</h5>" +
		"House Targaryen.<br>" +
		"<b><i>Guard.</i></b><br>" +
		"No attachments. Shadow (3).<b>Marshaling Action:</b> Pay 3 gold to put Brazen Beast into shadows from your discard pile..<br>" +
		"<i>Daggers in the Dark.</i><br>"
	)
	BRAZEN_BEAST_DitD ("11113"),
	@GraphQLEnumValue(description="" +
		"<h5>Gifts for the Widow</h5>" +
		"House Targaryen.<br>" +
		"<b>Action:</b> Search your deck for an attachment with printed cost X or lower and put it into play attached to a character you control. Shuffle your deck..<br>" +
		"<i>Daggers in the Dark.</i><br>"
	)
	GIFTS_FOR_THE_WIDOW_DitD ("11114"),
	@GraphQLEnumValue(description="" +
		"<h5>Starfall Spy</h5>" +
		"House Martell.<br>" +
		"<b><i>House Dayne. Spy.</i></b><br>" +
		"Shadow (3).<b>Reaction:</b> After you win a challenge in which Starfall Spy is participating, return it to shadows to choose another card you control in shadows and put it into play..<br>" +
		"<i>Daggers in the Dark.</i><br>"
	)
	STARFALL_SPY_DitD ("11115"),
	@GraphQLEnumValue(description="" +
		"<h5>Blood of the Viper</h5>" +
		"House Martell.<br>" +
		"<b><i>Legacy.</i></b><br>" +
		"<i>Sand Snake</i> character only. Ambush (2).<b>Reaction:</b> After you lose a challenge in which attached character is participating, stand it..<br>" +
		"<i>Daggers in the Dark.</i><br>"
	)
	BLOOD_OF_THE_VIPER_DitD ("11116"),
	@GraphQLEnumValue(description="" +
		"<h5>\"On a Misty Morn\"</h5>" +
		"Neutral.<br>" +
		"<b><i>Song.</i></b><br>" +
		"<b>Action:</b> Choose up to 2 non-unique characters in your dead pile and return them to your hand..<br>" +
		"<i>Daggers in the Dark.</i><br>"
	)
	ON_A_MISTY_MORN_DitD ("11117"),
	@GraphQLEnumValue(description="" +
		"<h5>Assault from the Shadows</h5>" +
		"Neutral.<br>" +
		"Reduce the gold value on your revealed plot card by 1.<b>Marshaling Action:</b> Kneel your faction card to choose 1 card in your hand and place it facedown in shadows with a shadow token on it. While that card is in shadows, if it does not have the printed shadow keyword, it gains shadow (X). X is its printed cost..<br>" +
		"<i>Daggers in the Dark.</i><br>"
	)
	ASSAULT_FROM_THE_SHADOWS_DitD ("11118"),
	@GraphQLEnumValue(description="" +
		"<h5>Varys (DitD)</h5>" +
		"Neutral.<br>" +
		"<b><i>Ally. Lord.</i></b><br>" +
		"Shadow (8). Stealth.Reduce the cost to bring Varys out of shadows by 1 for each other card in shadows.<b>Reaction:</b> After Varys comes out of shadows, choose and kill a character with power..<br>" +
		"<i>Daggers in the Dark.</i><br>"
	)
	VARYS_DitD ("11119"),
	@GraphQLEnumValue(description="" +
		"<h5>Ravages of War</h5>" +
		"Neutral.<br>" +
		"<b><i>War.</i></b><br>" +
		"<b>When Revealed:</b> Each player sacrifices a character or location, chooses and discards 1 card from his or her hand, and chooses and discards 1 card from his or her shadows area, if able..<br>" +
		"<i>Daggers in the Dark.</i><br>"
	)
	RAVAGES_OF_WAR_DitD ("11120"),
	@GraphQLEnumValue(description="" +
		"<h5>Balon Greyjoy (KotI)</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Ironborn. Lord.</i></b><br>" +
		"Pillage. Renown.<b>Action:</b> Kneel your faction card to choose a card in an opponent's discard pile and put it into play under your control. At the end of the phase, if that card is still in play, shuffle it into its owner's deck.<em>Errata from FAQ v2.0</em>.<br>" +
		"<i>Kings of the Isles.</i><br>"
	)
	BALON_GREYJOY_KotI ("12001"),
	@GraphQLEnumValue(description="" +
		"<h5>Euron Crow's Eye (KotI)</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Captain. Ironborn. Lord. Raider.</i></b><br>" +
		"Intimidate.<b>Reaction:</b> After you marshal Euron Crow's Eye, search your hand, deck, and discard pile for Silence and put it into play. Shuffle your deck..<br>" +
		"<i>Kings of the Isles.</i><br>"
	)
	EURON_CROWS_EYE_KotI ("12002"),
	@GraphQLEnumValue(description="" +
		"<h5>Asha Greyjoy (KotI)</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Captain. Ironborn. Lady.</i></b><br>" +
		"Pillage. Stealth.Each other unique <i>Ironborn</i> character you control gains stealth..<br>" +
		"<i>Kings of the Isles.</i><br>"
	)
	ASHA_GREYJOY_KotI ("12003"),
	@GraphQLEnumValue(description="" +
		"<h5>The Knight</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>House Harlaw. Knight.</i></b><br>" +
		"No attachments except <i>Weapon</i>.While The Knight is attacking alone, he gains stealth and renown..<br>" +
		"<i>Kings of the Isles.</i><br>"
	)
	THE_KNIGHT_KotI ("12004"),
	@GraphQLEnumValue(description="" +
		"<h5>Aeron Damphair (KotI)</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Drowned God. Ironborn. Lord.</i></b><br>" +
		"Insight.<b>Reaction:</b> After another <i>Drowned God</i> character you control is killed, draw 1 card. (Limit once per phase.).<br>" +
		"<i>Kings of the Isles.</i><br>"
	)
	AERON_DAMPHAIR_KotI ("12005"),
	@GraphQLEnumValue(description="" +
		"<h5>The Drumm</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Captain. Lord.</i></b><br>" +
		"While The Drumm is attacking in a [military] or [power] challenge, each character with an [intrigue] icon cannot be declared as a defender..<br>" +
		"<i>Kings of the Isles.</i><br>"
	)
	THE_DRUMM_KotI ("12006"),
	@GraphQLEnumValue(description="" +
		"<h5>Gwynesse Harlaw</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>House Harlaw. Lady.</i></b><br>" +
		"<b>Action:</b> Choose 3 cards in an opponent's discard pile and place them on the bottom of his or her deck in any order. Then, gain 1 gold and draw 1 card. (Limit once per round.).<br>" +
		"<i>Kings of the Isles.</i><br>"
	)
	GWYNESSE_HARLAW_KotI ("12007"),
	@GraphQLEnumValue(description="" +
		"<h5>Andrik the Unsmiling</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Ironborn. Raider.</i></b><br>" +
		"Pillage.<b>Reaction:</b> After Andrik the Unsmiling discards a card using pillage, choose a non-limited location or attachment in the losing opponent's discard pile. Discard 1 copy of that card from play..<br>" +
		"<i>Kings of the Isles.</i><br>"
	)
	ANDRIK_THE_UNSMILING_KotI ("12008"),
	@GraphQLEnumValue(description="" +
		"<h5>Qarl the Maid</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Ironborn.</i></b><br>" +
		"<b>Reaction:</b> After you win a challenge in which Qarl the Maid is participating, either: stand a <i>Warship</i> location, or stand Asha Greyjoy..<br>" +
		"<i>Kings of the Isles.</i><br>"
	)
	QARL_THE_MAID_KotI ("12009"),
	@GraphQLEnumValue(description="" +
		"<h5>Maester Murenmure</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Maester.</i></b><br>" +
		"<b>Interrupt:</b> When the effects of a triggered location ability would initiate, kneel Maester Murenmure to cancel those effects..<br>" +
		"<i>Kings of the Isles.</i><br>"
	)
	MAESTER_MURENMURE_KotI ("12010"),
	@GraphQLEnumValue(description="" +
		"<h5>Old Grey Gull</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Drowned God. Ironborn.</i></b><br>" +
		"<b>Action:</b> Kneel Old Grey Gull to kill another [greyjoy] character you control. Then, you may return that character from your dead pile to your hand..<br>" +
		"<i>Kings of the Isles.</i><br>"
	)
	OLD_GREY_GULL_KotI ("12011"),
	@GraphQLEnumValue(description="" +
		"<h5>Priest of Old Wyk</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Drowned God.</i></b><br>" +
		"While there is a <i>Drowned God</i> character in your dead pile, Priest of Old Wyk contributes its STR to your total for dominance even while kneeling..<br>" +
		"<i>Kings of the Isles.</i><br>"
	)
	PRIEST_OF_OLD_WYK_KotI ("12012"),
	@GraphQLEnumValue(description="" +
		"<h5>Drowned Prophet</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Drowned God.</i></b><br>" +
		"<b>Interrupt:</b> When Drowned Prophet is killed, search the top 5 cards of your deck for a [greyjoy] character and place it in your dead pile. Shuffle your deck..<br>" +
		"<i>Kings of the Isles.</i><br>"
	)
	DROWNED_PROPHET_KotI ("12013"),
	@GraphQLEnumValue(description="" +
		"<h5>Eager Deckhand</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Ally. Raider.</i></b><br>" +
		"<b>Reaction:</b> After a <i>Warship</i> location enters play under your control, put Eager Deckhand into play from your hand..<br>" +
		"<i>Kings of the Isles.</i><br>"
	)
	EAGER_DECKHAND_KotI ("12014"),
	@GraphQLEnumValue(description="" +
		"<h5>Orkmont Reaver</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Ironborn. Raider.</i></b><br>" +
		"Pillage.While an opponent has 10 or more cards in his or her discard pile, Orkmont Reaver gains stealth..<br>" +
		"<i>Kings of the Isles.</i><br>"
	)
	ORKMONT_REAVER_KotI ("12015"),
	@GraphQLEnumValue(description="" +
		"<h5>Silence</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Warship.</i></b><br>" +
		"<b>Challenges Action:</b> Kneel Silence to put a <i>Warship</i> location into play from your hand. Then, if you control Euron Crow's Eye, stand him.+2 Initiative..<br>" +
		"<i>Kings of the Isles.</i><br>"
	)
	SILENCE_KotI ("12016"),
	@GraphQLEnumValue(description="" +
		"<h5>Great Wyk</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Drowned God. Iron Islands.</i></b><br>" +
		"<b>Reaction:</b> After a character enters play from your dead pile, each opponent chooses and discards 1 card from his or her hand. (Limit once per phase.).<br>" +
		"<i>Kings of the Isles.</i><br>"
	)
	GREAT_WYK_KotI ("12017"),
	@GraphQLEnumValue(description="" +
		"<h5>Golden Storm</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Warship.</i></b><br>" +
		"<b>Reaction:</b> After you win a [military] challenge as the attacking player, kneel Golden Storm to choose and kill a participating character. Then, if you control a participating <i>Raider</i> character, stand Golden Storm..<br>" +
		"<i>Kings of the Isles.</i><br>"
	)
	GOLDEN_STORM_KotI ("12018"),
	@GraphQLEnumValue(description="" +
		"<h5>Maiden's Bane</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Warship.</i></b><br>" +
		"<b>Reaction:</b> After you win an unopposed challenge, kneel Maiden's Bane to choose and stand an attacking character. Then, if that character is a <i>Captain</i>, stand Maiden's Bane..<br>" +
		"<i>Kings of the Isles.</i><br>"
	)
	MAIDENS_BANE_KotI ("12019"),
	@GraphQLEnumValue(description="" +
		"<h5>Scouting Vessel</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Warship.</i></b><br>" +
		"<b>Interrupt:</b> When a character you control discards a card using pillage, kneel and sacrifice Scouting Vessel to discard 3 cards instead..<br>" +
		"<i>Kings of the Isles.</i><br>"
	)
	SCOUTING_VESSEL_KotI ("12020"),
	@GraphQLEnumValue(description="" +
		"<h5>Red Rain</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Valyrian Steel. Weapon.</i></b><br>" +
		"Unique [greyjoy] character only.If attached character is The Drumm, he gains stealth.<b>Reaction:</b> After you win an unopposed challenge in which attached character is attacking, it gains 2 power. (Limit once per phase.).<br>" +
		"<i>Kings of the Isles.</i><br>"
	)
	RED_RAIN_KotI ("12021"),
	@GraphQLEnumValue(description="" +
		"<h5>Fleet Captain</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Title.</i></b><br>" +
		"Attached character gains the <i>Captain</i> trait and gets +1 STR. (+3 STR instead if you control 3 or more <i>Warship</i> locations.).<br>" +
		"<i>Kings of the Isles.</i><br>"
	)
	FLEET_CAPTAIN_KotI ("12022"),
	@GraphQLEnumValue(description="" +
		"<h5>What Is Dead May Never Die</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Drowned God.</i></b><br>" +
		"<b>Reaction:</b> After you win dominance, choose a [greyjoy] character in your dead pile and put it into play..<br>" +
		"<i>Kings of the Isles.</i><br>"
	)
	WHAT_IS_DEAD_MAY_NEVER_DIE_KotI ("12023"),
	@GraphQLEnumValue(description="" +
		"<h5>Nighttime Raid</h5>" +
		"House Greyjoy.<br>" +
		"<b>Action:</b> Choose up to 3 characters with pillage and/or the <i>Raider</i> trait. Until the end of the phase, each of those characters gains stealth..<br>" +
		"<i>Kings of the Isles.</i><br>"
	)
	NIGHTTIME_RAID_KotI ("12024"),
	@GraphQLEnumValue(description="" +
		"<h5>Khorane Sathmantes</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Captain. Raider. Smuggler.</i></b><br>" +
		"<b>Action:</b> Kneel Khorane Sathmantes and a <i>Warship</i> location to choose and kneel 1 character and 1 location..<br>" +
		"<i>Kings of the Isles.</i><br>"
	)
	KHORANE_SATHMANTES_KotI ("12025"),
	@GraphQLEnumValue(description="" +
		"<h5>Fury</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Warship.</i></b><br>" +
		"While you control Stannis Baratheon, he gains intimidate.<b>Reaction:</b> After you win a [power] challenge, kneel Fury to choose a character or location. Move 1 power from that card to your faction card..<br>" +
		"<i>Kings of the Isles.</i><br>"
	)
	FURY_KotI ("12026"),
	@GraphQLEnumValue(description="" +
		"<h5>Gunthor Son of Gurn</h5>" +
		"House Lannister.<br>" +
		"<b><i>Clansman.</i></b><br>" +
		"Ambush (4).<b>Reaction:</b> After you win a challenge in which Gunthor Son of Gurn is attacking, the losing opponent must choose and discard 1 card from his or her hand..<br>" +
		"<i>Kings of the Isles.</i><br>"
	)
	GUNTHOR_SON_OF_GURN_KotI ("12027"),
	@GraphQLEnumValue(description="" +
		"<h5>My Mind Is My Weapon</h5>" +
		"House Lannister.<br>" +
		"<b>Action:</b> During a [military] challenge, choose a character you control with an [intrigue] icon and have it participate in the challenge on your side..<br>" +
		"<i>Kings of the Isles.</i><br>"
	)
	MY_MIND_IS_MY_WEAPON_KotI ("12028"),
	@GraphQLEnumValue(description="" +
		"<h5>Desert Raider</h5>" +
		"House Martell.<br>" +
		"<b><i>Ally. House Dayne. Raider.</i></b><br>" +
		"<b>Reaction:</b> After you lose a challenge, put Desert Raider into play from your dead pile and choose a character controlled by the winning opponent. That character gains 1 power. Until the end of the phase, that character loses an [intrigue] or [power] icon and Desert Raider gains that icon..<br>" +
		"<i>Kings of the Isles.</i><br>"
	)
	DESERT_RAIDER_KotI ("12029"),
	@GraphQLEnumValue(description="" +
		"<h5>The Bloodroyal</h5>" +
		"House Martell.<br>" +
		"<b><i>House Yronwood. Title.</i></b><br>" +
		"[martell] character only.While you are not the first player, attached character gains stealth and renown..<br>" +
		"<i>Kings of the Isles.</i><br>"
	)
	THE_BLOODROYAL_KotI ("12030"),
	@GraphQLEnumValue(description="" +
		"<h5>Vindictive Ranger</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Ranger.</i></b><br>" +
		"<b>Reaction:</b> After you lose a challenge as the defending player, Vindictive Ranger gains stealth and a challenge icon of your choice until the end of the phase..<br>" +
		"<i>Kings of the Isles.</i><br>"
	)
	VINDICTIVE_RANGER_KotI ("12031"),
	@GraphQLEnumValue(description="" +
		"<h5>Westwatch-by-the-Bridge</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>The North.</i></b><br>" +
		"<b>Action:</b> Kneel Westwatch-by-the-Bridge to choose and stand another [thenightswatch] location with printed cost 1 or lower. (Printed cost 4 or lower instead if you control a <i>Ranger</i> character, a <i>Steward</i> character, and a <i>Builder</i> character.).<br>" +
		"<i>Kings of the Isles.</i><br>"
	)
	WESTWATCH_BY_THE_BRIDGE_KotI ("12032"),
	@GraphQLEnumValue(description="" +
		"<h5>Maester Vyman</h5>" +
		"House Stark.<br>" +
		"<b><i>House Tully. Maester.</i></b><br>" +
		"<b>Reaction:</b> After you win a [military] or [power] challenge, kneel Maester Vyman to choose another character that shares a <i>Trait</i> with him. That character gains 1 power..<br>" +
		"<i>Kings of the Isles.</i><br>"
	)
	MAESTER_VYMAN_KotI ("12033"),
	@GraphQLEnumValue(description="" +
		"<h5>Karhold</h5>" +
		"House Stark.<br>" +
		"<b><i>The North.</i></b><br>" +
		"While a player does not have a <i>Winter</i> plot card revealed, characters and locations he or she controls cannot gain power..<br>" +
		"<i>Kings of the Isles.</i><br>"
	)
	KARHOLD_KotI ("12034"),
	@GraphQLEnumValue(description="" +
		"<h5>Cohollo</h5>" +
		"House Targaryen.<br>" +
		"<b><i>Bloodrider. Dothraki.</i></b><br>" +
		"Intimidate.<b>Action:</b> Kneel Cohollo and discard 1 card from your hand to have him participate in a challenge on your side..<br>" +
		"<i>Kings of the Isles.</i><br>"
	)
	COHOLLO_KotI ("12035"),
	@GraphQLEnumValue(description="" +
		"<h5>\"Dance of the Dragons\"</h5>" +
		"House Targaryen.<br>" +
		"<b><i>Song.</i></b><br>" +
		"<b>Action:</b> Choose a non-event card with printed cost 3 or lower in your discard pile and return it to your hand..<br>" +
		"<i>Kings of the Isles.</i><br>"
	)
	DANCE_OF_THE_DRAGONS_KotI ("12036"),
	@GraphQLEnumValue(description="" +
		"<h5>Ser Talbert Serry</h5>" +
		"House Tyrell.<br>" +
		"<b><i>Knight.</i></b><br>" +
		"No attachments except <i>Weapon</i>.<b>Reaction:</b> After an opponent triggers a location ability, Ser Talbert Serry gets +2 STR until the end of the phase. (Limit 3 times per phase.).<br>" +
		"<i>Kings of the Isles.</i><br>"
	)
	SER_TALBERT_SERRY_KotI ("12037"),
	@GraphQLEnumValue(description="" +
		"<h5>The Shield Islands</h5>" +
		"House Tyrell.<br>" +
		"<b><i>The Reach.</i></b><br>" +
		"Increase the number of cards each player draws in the draw phase by 1..<br>" +
		"<i>Kings of the Isles.</i><br>"
	)
	THE_SHIELD_ISLANDS_KotI ("12038"),
	@GraphQLEnumValue(description="" +
		"<h5>Bronze Yohn Royce</h5>" +
		"Neutral.<br>" +
		"<b><i>House Arryn. Lord.</i></b><br>" +
		"Renown.<b>Reaction:</b> After you win a challenge in which Bronze Yohn Royce is defending, kneel a neutral location with printed cost 1 or higher to stand him. (Limit twice per phase.).<br>" +
		"<i>Kings of the Isles.</i><br>"
	)
	BRONZE_YOHN_ROYCE_KotI ("12039"),
	@GraphQLEnumValue(description="" +
		"<h5>Rogue Wildling</h5>" +
		"Neutral.<br>" +
		"<b><i>Raider. Wildling.</i></b><br>" +
		"Ambush (5).<b>Reaction:</b> After Rogue Wildling enters play, choose and stand a <i>Wildling</i> character you control..<br>" +
		"<i>Kings of the Isles.</i><br>"
	)
	ROGUE_WILDLING_KotI ("12040"),
	@GraphQLEnumValue(description="" +
		"<h5>Citadel Archivist</h5>" +
		"Neutral.<br>" +
		"<b><i>Maester.</i></b><br>" +
		"<b>Reaction:</b> After Citadel Archivist enters your discard pile, each player shuffles his or her discard pile into his or her deck..<br>" +
		"<i>Kings of the Isles.</i><br>"
	)
	CITADEL_ARCHIVIST_KotI ("12041"),
	@GraphQLEnumValue(description="" +
		"<h5>The Starry Sept</h5>" +
		"Neutral.<br>" +
		"<b><i>Oldtown. The Seven.</i></b><br>" +
		"<b>Action:</b> Move 1 power from The Starry Sept to a character. Until the end of the phase, treat that character as if its printed text box were blank (except for <i>Traits</i>).<b>Reaction:</b> After you win a [power] challenge, The Starry Sept gains 1 power..<br>" +
		"<i>Kings of the Isles.</i><br>"
	)
	THE_STARRY_SEPT_KotI ("12042"),
	@GraphQLEnumValue(description="" +
		"<h5>Reckless</h5>" +
		"Neutral.<br>" +
		"<b><i>Condition.</i></b><br>" +
		"Terminal.Attached character must be declared as an attacker or defender in each challenge, if able..<br>" +
		"<i>Kings of the Isles.</i><br>"
	)
	RECKLESS_KotI ("12043"),
	@GraphQLEnumValue(description="" +
		"<h5>When I Woke...</h5>" +
		"Neutral.<br>" +
		"<b>Reaction:</b> After a player loses a [military] challenge, that player chooses a participating character and places it on top of its owner's deck. (Max 1 per challenge.).<br>" +
		"<i>Kings of the Isles.</i><br>"
	)
	WHEN_I_WOKE_KotI ("12044"),
	@GraphQLEnumValue(description="" +
		"<h5>Sea of Blood</h5>" +
		"Neutral.<br>" +
		"<b><i>Prophecy.</i></b><br>" +
		"During [military] challenges, reduce the cost of each event you play by 1 for each blood token on Sea of Blood. You cannot play events during [intrigue] or [power] challenges.<b>Reaction:</b> After you win a [military] challenge by 5 or more STR, kneel your faction card to place a blood token on Sea of Blood. Then, search your deck for an event, reveal it, and add it to your hand. Shuffle your deck..<br>" +
		"<i>Kings of the Isles.</i><br>"
	)
	SEA_OF_BLOOD_KotI ("12045"),
	@GraphQLEnumValue(description="" +
		"<h5>We Take Westeros!</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>War.</i></b><br>" +
		"<b>When Revealed:</b> Choose a location in a discard pile and put it into play under your control..<br>" +
		"<i>Kings of the Isles.</i><br>"
	)
	WE_TAKE_WESTEROS_KotI ("12046"),
	@GraphQLEnumValue(description="" +
		"<h5>Return to the Fields</h5>" +
		"Neutral.<br>" +
		"<b><i>Edict.</i></b><br>" +
		"<b>When Revealed:</b> You may sacrifice up to 3 characters. For each character sacrificed this way, draw 1 card and gain 1 gold..<br>" +
		"<i>Kings of the Isles.</i><br>"
	)
	RETURN_TO_THE_FIELDS_KotI ("12047"),
	@GraphQLEnumValue(description="" +
		"<h5>Heir to the Iron Throne</h5>" +
		"Neutral.<br>" +
		"<b><i>Kingdom.</i></b><br>" +
		"<b>When Revealed:</b> Search the top 10 cards of your deck for a <i>Lord</i> or <i>Lady</i> character and put it into play. Shuffle your deck. Then, sacrifice a <i>Lord</i> or <i>Lady</i> character..<br>" +
		"<i>Kings of the Isles.</i><br>"
	)
	HEIR_TO_THE_IRON_THRONE_KotI ("12048"),
	@GraphQLEnumValue(description="" +
		"<h5>Coordinated Attack</h5>" +
		"Neutral.<br>" +
		"<b><i>War.</i></b><br>" +
		"<b>Reaction:</b> After you win a challenge as the attacking player, choose a different challenge type. You may initiate an additional challenge of the chosen type this phase. (Limit once per phase.).<br>" +
		"<i>Kings of the Isles.</i><br>"
	)
	COORDINATED_ATTACK_KotI ("12049"),
	@GraphQLEnumValue(description="" +
		"<h5>Stolen Message</h5>" +
		"Neutral.<br>" +
		"<b><i>Scheme.</i></b><br>" +
		"Each opponent plays with the top card of his or her deck revealed.<b>Action:</b> Pay 1 gold to place the top card of an opponent's deck on the bottom of that player's deck. (Limit 3 times per round.).<br>" +
		"<i>Kings of the Isles.</i><br>"
	)
	STOLEN_MESSAGE_KotI ("12050"),
	@GraphQLEnumValue(description="" +
		"<h5>Secrets of the Conclave</h5>" +
		"Neutral.<br>" +
		"<b><i>Conclave. Kingdom.</i></b><br>" +
		"<b>Reaction:</b> After the challenges phase begins, look at the top 5 cards of your deck. Add 1 to your hand, discard 1, and put the others back on top of your deck in any order..<br>" +
		"<i>Kings of the Isles.</i><br>"
	)
	SECRETS_OF_THE_CONCLAVE_KotI ("12051"),
	@GraphQLEnumValue(description="" +
		"<h5>Vanquish the Unbelievers</h5>" +
		"Neutral.<br>" +
		"<b><i>Edict.</i></b><br>" +
		"<b>Forced Reaction:</b> After the challenges phase begins, choose a <i>Trait</i>. Kill each character you control that does not have that <i>Trait</i> (cannot be saved)..<br>" +
		"<i>Kings of the Isles.</i><br>"
	)
	VANQUISH_THE_UNBELIEVERS_KotI ("12052"),
	@GraphQLEnumValue(description="" +
		"<h5>Alysane Mormont</h5>" +
		"House Stark.<br>" +
		"<b><i>House Mormont. Lady.</i></b><br>" +
		"No attachments except <i>Weapon</i>.While each character you control has the [stark] affiliation, Alysane Mormont gains stealth during [military] challenges and does not kneel when declared as an attacker in a [military] challenge..<br>" +
		"<i>At the Gates.</i><br>"
	)
	ALYSANE_MORMONT_AtG ("13001"),
	@GraphQLEnumValue(description="" +
		"<h5>Old Gate</h5>" +
		"House Stark.<br>" +
		"<b><i>King's Landing.</i></b><br>" +
		"Limited.<b>Challenges Action:</b> If each character you control has the [stark] affiliation, sacrifice Old Gate to draw 2 cards.+1 Income..<br>" +
		"<i>At the Gates.</i><br>"
	)
	OLD_GATE_AtG ("13002"),
	@GraphQLEnumValue(description="" +
		"<h5>The Knight of Flowers (AtG)</h5>" +
		"House Tyrell.<br>" +
		"<b><i>Kingsguard. Knight.</i></b><br>" +
		"Shadow (5). Renown.<b>Reaction:</b> After a card you control comes out of shadows, choose and stand a <i>Kingsguard</i> character. (Limit twice per round.).<br>" +
		"<i>At the Gates.</i><br>"
	)
	THE_KNIGHT_OF_FLOWERS_AtG ("13003"),
	@GraphQLEnumValue(description="" +
		"<h5>Gate of the Gods</h5>" +
		"House Tyrell.<br>" +
		"<b><i>King's Landing. The Seven.</i></b><br>" +
		"Limited.<b>Challenges Action:</b> If you control a character with the highest STR in play, sacrifice Gate of the Gods to draw 2 cards.+1 Income..<br>" +
		"<i>At the Gates.</i><br>"
	)
	GATE_OF_THE_GODS_AtG ("13004"),
	@GraphQLEnumValue(description="" +
		"<h5>Aged Craftsman</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Builder.</i></b><br>" +
		"No attachments.<b>Reaction:</b> After Aged Craftsman enters play, search the top 10 cards of your deck for a [thenightswatch] location with printed cost 2 or lower and put it into play. Shuffle your deck..<br>" +
		"<i>At the Gates.</i><br>"
	)
	AGED_CRAFTSMAN_AtG ("13005"),
	@GraphQLEnumValue(description="" +
		"<h5>Flea Bottom Alley</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>King's Landing.</i></b><br>" +
		"Limited.<b>Marshaling Action:</b> Kneel and sacrifice Flea Bottom Alley to put a [thenightswatch] character with printed cost 3 or lower into play from your hand. Then, draw 1 card..<br>" +
		"<i>At the Gates.</i><br>"
	)
	FLEA_BOTTOM_ALLEY_AtG ("13006"),
	@GraphQLEnumValue(description="" +
		"<h5>R'hllor Infiltrator</h5>" +
		"House Baratheon.<br>" +
		"<b><i>R'hllor. Spy.</i></b><br>" +
		"<b>Dominance Action:</b> Kneel R'hllor Infiltrator to choose an opponent. Give control of R'hllor Infiltrator to that player and gain 1 power for your faction..<br>" +
		"<i>At the Gates.</i><br>"
	)
	RHLLOR_INFILTRATOR_AtG ("13007"),
	@GraphQLEnumValue(description="" +
		"<h5>King's Gate</h5>" +
		"House Baratheon.<br>" +
		"<b><i>King's Landing.</i></b><br>" +
		"Limited.<b>Challenges Action:</b> If you have 5 or more power on your faction card, sacrifice King's Gate to draw 2 cards.+1 Income..<br>" +
		"<i>At the Gates.</i><br>"
	)
	KINGS_GATE_AtG ("13008"),
	@GraphQLEnumValue(description="" +
		"<h5>Ser Mandon Moore</h5>" +
		"House Lannister.<br>" +
		"<b><i>Kingsguard. Knight.</i></b><br>" +
		"Shadow (3).<b>Reaction:</b> After Ser Mandon Moore comes out of shadows, choose an opponent. That player must choose and kill a character he or she controls unless he or she chooses and discards 2 cards from his or her hand..<br>" +
		"<i>At the Gates.</i><br>"
	)
	SER_MANDON_MOORE_AtG ("13009"),
	@GraphQLEnumValue(description="" +
		"<h5>Lion Gate</h5>" +
		"House Lannister.<br>" +
		"<b><i>King's Landing.</i></b><br>" +
		"Limited.<b>Challenges Action:</b> If you control 2 or more cards in shadows, sacrifice Lion Gate to draw 2 cards.+1 Income..<br>" +
		"<i>At the Gates.</i><br>"
	)
	LION_GATE_AtG ("13010"),
	@GraphQLEnumValue(description="" +
		"<h5>Baelor Blacktyde</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Captain. The Seven.</i></b><br>" +
		"Each opponent cannot play copies of events that are in his or her discard pile..<br>" +
		"<i>At the Gates.</i><br>"
	)
	BAELOR_BLACKTYDE_AtG ("13011"),
	@GraphQLEnumValue(description="" +
		"<h5>Iron Gate</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>King's Landing.</i></b><br>" +
		"Limited.<b>Challenges Action:</b> If you are the first player, sacrifice Iron Gate to draw 2 cards.+1 Income..<br>" +
		"<i>At the Gates.</i><br>"
	)
	IRON_GATE_AtG ("13012"),
	@GraphQLEnumValue(description="" +
		"<h5>Viserion (AtG)</h5>" +
		"House Targaryen.<br>" +
		"<b><i>Dragon.</i></b><br>" +
		"Ambush (5). No attachments.<b>Reaction:</b> After you win a challenge in which Viserion is attacking, discard 1 card from your hand to have Viserion gain intimidate until the end of the challenge..<br>" +
		"<i>At the Gates.</i><br>"
	)
	VISERION_AtG ("13013"),
	@GraphQLEnumValue(description="" +
		"<h5>Dragon Gate</h5>" +
		"House Targaryen.<br>" +
		"<b><i>King's Landing.</i></b><br>" +
		"Limited.<b>Challenges Action:</b> If you control 2 or more attachments, sacrifice Dragon Gate to draw 2 cards.+1 Income..<br>" +
		"<i>At the Gates.</i><br>"
	)
	DRAGON_GATE_AtG ("13014"),
	@GraphQLEnumValue(description="" +
		"<h5>Southron Escort</h5>" +
		"House Martell.<br>" +
		"<b><i>Ally. Guard.</i></b><br>" +
		"Shadow (4).<b>Action:</b> Discard another card from shadows to put Southron Escort into play from shadows..<br>" +
		"<i>At the Gates.</i><br>"
	)
	SOUTHRON_ESCORT_AtG ("13015"),
	@GraphQLEnumValue(description="" +
		"<h5>River Gate</h5>" +
		"House Martell.<br>" +
		"<b><i>King's Landing.</i></b><br>" +
		"Limited.<b>Challenges Action:</b> If you have lost 2 or more challenges this phase, sacrifice River Gate to draw 2 cards.+1 Income..<br>" +
		"<i>At the Gates.</i><br>"
	)
	RIVER_GATE_AtG ("13016"),
	@GraphQLEnumValue(description="" +
		"<h5>Littlefinger (AtG)</h5>" +
		"Neutral.<br>" +
		"<b><i>Ally. Lord. Small Council.</i></b><br>" +
		"Shadow (6). Stealth.<b>Reaction:</b> After a character you control comes out of shadows, place up to 3 cards from your hand on the bottom of your deck in any order. Then, draw that many cards. (Limit once per round.).<br>" +
		"<i>At the Gates.</i><br>"
	)
	LITTLEFINGER_AtG ("13017"),
	@GraphQLEnumValue(description="" +
		"<h5>White Sword Tower</h5>" +
		"Neutral.<br>" +
		"<b><i>King's Landing.</i></b><br>" +
		"Each <i>Kingsguard</i> character you control gets +1 STR.Each player that does not control a <i>Kingsguard</i> character cannot play more than 1 event each phase..<br>" +
		"<i>At the Gates.</i><br>"
	)
	WHITE_SWORD_TOWER_AtG ("13018"),
	@GraphQLEnumValue(description="" +
		"<h5>City of Secrets</h5>" +
		"Neutral.<br>" +
		"<b><i>City.</i></b><br>" +
		"<b>When Revealed:</b> Each player draws 2 cards. Then, each player without a <i>City</i> plot card in his or her used pile chooses and discards 2 cards from his or her hand..<br>" +
		"<i>At the Gates.</i><br>"
	)
	CITY_OF_SECRETS_AtG ("13019"),
	@GraphQLEnumValue(description="" +
		"<h5>At the Gates</h5>" +
		"Neutral.<br>" +
		"<b><i>City. Kingdom.</i></b><br>" +
		"<b>When Revealed:</b> Search your deck for a limited location with printed cost 1 or lower, reveal it, and add it to your hand (put it into play instead if there are no <i>City</i> plot cards in your used pile). Shuffle your deck..<br>" +
		"<i>At the Gates.</i><br>"
	)
	AT_THE_GATES_AtG ("13020"),
	@GraphQLEnumValue(description="" +
		"<h5>Smalljon Umber</h5>" +
		"House Stark.<br>" +
		"<b><i>House Umber. Lord.</i></b><br>" +
		"Renown.Smalljon Umber gets -1 STR for each plot card in your used pile..<br>" +
		"<i>City of Secrets.</i><br>"
	)
	SMALLJON_UMBER_CoS ("13021"),
	@GraphQLEnumValue(description="" +
		"<h5>No Surprises</h5>" +
		"House Stark.<br>" +
		"<b>Action:</b> Reveal your hand (of at least 1 card). Then, until the end of the phase, each opponent cannot play events or bring cards out of shadows..<br>" +
		"<i>City of Secrets.</i><br>"
	)
	NO_SURPRISES_CoS ("13022"),
	@GraphQLEnumValue(description="" +
		"<h5>Arrogant Contender</h5>" +
		"House Tyrell.<br>" +
		"<b><i>Knight.</i></b><br>" +
		"While Arrogant Contender is participating in a challenge, it gets +1 STR for each participating character an opponent controls.<b>Reaction:</b> After you win a challenge in which Arrogant Contender is attacking alone, it gains 1 power for each defending character (to a maximum of 3 power)..<br>" +
		"<i>City of Secrets.</i><br>"
	)
	ARROGANT_CONTENDER_CoS ("13023"),
	@GraphQLEnumValue(description="" +
		"<h5>Show of Strength</h5>" +
		"House Tyrell.<br>" +
		"<b>Challenges Action:</b> Until the end of the phase, treat each character with STR 3 or lower as if its printed text box were blank (except for <i>Traits</i>)..<br>" +
		"<i>City of Secrets.</i><br>"
	)
	SHOW_OF_STRENGTH_CoS ("13024"),
	@GraphQLEnumValue(description="" +
		"<h5>Owen the Oaf</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Steward.</i></b><br>" +
		"No attachments except <i>Weapon</i>.While Owen the Oaf is participating in a challenge, each character with more than 1 challenge icon does not contribute its STR to the challenge..<br>" +
		"<i>City of Secrets.</i><br>"
	)
	OWEN_THE_OAF_CoS ("13025"),
	@GraphQLEnumValue(description="" +
		"<h5>Shadow of the Wall</h5>" +
		"The Night's Watch.<br>" +
		"Shadow (0).<b>Action:</b> Choose and stand a character with 1 or fewer challenge icons. If there is a <i>Winter</i> plot card revealed, return Shadow of the Wall to your hand instead of placing it in your discard pile..<br>" +
		"<i>City of Secrets.</i><br>"
	)
	SHADOW_OF_THE_WALL_CoS ("13026"),
	@GraphQLEnumValue(description="" +
		"<h5>Red Keep Gaoler</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Ally. Guard.</i></b><br>" +
		"Shadow (4).<b>Action:</b> Move 2 power from your faction card to a [baratheon] character to put Red Keep Gaoler into play from shadows..<br>" +
		"<i>City of Secrets.</i><br>"
	)
	RED_KEEP_GAOLER_CoS ("13027"),
	@GraphQLEnumValue(description="" +
		"<h5>The Black Cells</h5>" +
		"House Baratheon.<br>" +
		"<b><i>King's Landing.</i></b><br>" +
		"Shadow (2).<b>Reaction:</b> After a card you control comes out of shadows, kneel The Black Cells to choose an opponent's character. Until the end of the phase, that character cannot kneel or stand..<br>" +
		"<i>City of Secrets.</i><br>"
	)
	THE_BLACK_CELLS_CoS ("13028"),
	@GraphQLEnumValue(description="" +
		"<h5>The Regent's Guard</h5>" +
		"House Lannister.<br>" +
		"<b><i>Ally. Guard.</i></b><br>" +
		"Shadow (4).<b>Action:</b> Return a [lannister] non-<i>Ally</i> character with printed cost 4 or higher to your hand to put The Regent's Guard into play from shadows..<br>" +
		"<i>City of Secrets.</i><br>"
	)
	THE_REGENTS_GUARD_CoS ("13029"),
	@GraphQLEnumValue(description="" +
		"<h5>Pyromancer's Cache</h5>" +
		"House Lannister.<br>" +
		"<b><i>Item.</i></b><br>" +
		"Location only.Treat attached location as if its printed text box were blank (except for <i>Traits</i>).Attached location gains: \"<b>Action:</b> Kneel this location to draw 1 card.\".<br>" +
		"<i>City of Secrets.</i><br>"
	)
	PYROMANCERS_CACHE_CoS ("13030"),
	@GraphQLEnumValue(description="" +
		"<h5>Alannys Greyjoy (CoS)</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>House Harlaw. Lady. Queen.</i></b><br>" +
		"<b>Reaction:</b> After a [greyjoy] location enters play under your control, draw 1 card. (Limit once per phase.).<br>" +
		"<i>City of Secrets.</i><br>"
	)
	ALANNYS_GREYJOY_CoS ("13031"),
	@GraphQLEnumValue(description="" +
		"<h5>Nightflyer</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Warship.</i></b><br>" +
		"Shadow (X).<b>Reaction:</b> After Nightflyer comes out of shadows, choose a location with printed cost X or lower and discard it from play.+1 Initiative..<br>" +
		"<i>City of Secrets.</i><br>"
	)
	NIGHTFLYER_CoS ("13032"),
	@GraphQLEnumValue(description="" +
		"<h5>Black Market Merchant</h5>" +
		"House Targaryen.<br>" +
		"<b><i>Merchant.</i></b><br>" +
		"Shadow (2).<b>Reaction:</b> After Black Market Merchant comes out of shadows, search the top 10 cards of your deck for an attachment with printed cost 3 or lower and attach it to an eligible character you control. Shuffle your deck..<br>" +
		"<i>City of Secrets.</i><br>"
	)
	BLACK_MARKET_MERCHANT_CoS ("13033"),
	@GraphQLEnumValue(description="" +
		"<h5>Shadow of the East</h5>" +
		"House Targaryen.<br>" +
		"Shadow (0).<b>Action:</b> Choose an attachment and discard it from play. If there is a <i>Summer</i> plot card revealed, return Shadow of the East to your hand instead of placing it in your discard pile..<br>" +
		"<i>City of Secrets.</i><br>"
	)
	SHADOW_OF_THE_EAST_CoS ("13034"),
	@GraphQLEnumValue(description="" +
		"<h5>The Fowler Twins</h5>" +
		"House Martell.<br>" +
		"<b><i>Companion.</i></b><br>" +
		"<b>Action:</b> Choose a character. That character must be declared as an attacker or defender in the next challenge initiated this phase, if able. (Limit once per phase.).<br>" +
		"<i>City of Secrets.</i><br>"
	)
	THE_FOWLER_TWINS_CoS ("13035"),
	@GraphQLEnumValue(description="" +
		"<h5>Shadow of the South</h5>" +
		"House Martell.<br>" +
		"Shadow (1).<b>Action:</b> Choose a character. Until the end of the phase, that character loses a challenge icon of your choice. If there is a <i>Scheme</i> plot card revealed, return Shadow of the South to your hand instead of placing it in your discard pile..<br>" +
		"<i>City of Secrets.</i><br>"
	)
	SHADOW_OF_THE_SOUTH_CoS ("13036"),
	@GraphQLEnumValue(description="" +
		"<h5>Ghost of High Heart</h5>" +
		"Neutral.<br>" +
		"<b><i>Ally. Brotherhood.</i></b><br>" +
		"While you control no loyal characters, each character you control gets +1 STR.<b>Challenges Action:</b> Kneel Ghost of High Heart to look at a player's hand. Choose and discard 1 card from that hand. Then, that player draws 1 card..<br>" +
		"<i>City of Secrets.</i><br>"
	)
	GHOST_OF_HIGH_HEART_CoS ("13037"),
	@GraphQLEnumValue(description="" +
		"<h5>Shadow Politics</h5>" +
		"Neutral.<br>" +
		"Shadow (1).<b>Action:</b> Choose one:- Choose and discard 1 card from shadows.- Choose up to 5 cards in a single discard pile and remove them from the game.- Look at an opponent's hand..<br>" +
		"<i>City of Secrets.</i><br>"
	)
	SHADOW_POLITICS_CoS ("13038"),
	@GraphQLEnumValue(description="" +
		"<h5>Knights of the Hollow Hill</h5>" +
		"Neutral.<br>" +
		"You cannot place cards during setup. Your other cards do not provide a gold bonus.+3 Income. +2 Initiative. +1 Reserve..<br>" +
		"<i>City of Secrets.</i><br>"
	)
	KNIGHTS_OF_THE_HOLLOW_HILL_CoS ("13039"),
	@GraphQLEnumValue(description="" +
		"<h5>A City Besieged</h5>" +
		"Neutral.<br>" +
		"<b><i>City. Siege.</i></b><br>" +
		"<b>When Revealed:</b> Choose and kneel a location. (Up to 2 locations instead if there is a <i>City</i> plot card in your used pile.).<br>" +
		"<i>City of Secrets.</i><br>"
	)
	A_CITY_BESIEGED_CoS ("13040"),
	@GraphQLEnumValue(description="" +
		"<h5>Eddard Stark (PoS)</h5>" +
		"House Stark.<br>" +
		"<b><i>Lord. Small Council.</i></b><br>" +
		"Renown.<b>Dominance Action:</b> If each character you control has the [stark] affiliation, kneel Eddard Stark to choose and kill a character with printed cost 4 or lower. (Limit once per phase.).<br>" +
		"<i>Pit of Snakes.</i><br>"
	)
	EDDARD_STARK_PoS ("13041"),
	@GraphQLEnumValue(description="" +
		"<h5>Malleon's Tome</h5>" +
		"House Stark.<br>" +
		"<b><i>Citadel. Item.</i></b><br>" +
		"Shadow (1).Attached character gains an [intrigue] icon.<b>Reaction:</b> After you win a challenge in which attached character is attacking, look at the losing opponent's hand. If attached character is Eddard Stark or has the <i>Maester</i> trait, stand it. (Limit once per phase.).<br>" +
		"<i>Pit of Snakes.</i><br>"
	)
	MALLEONS_TOME_PoS ("13042"),
	@GraphQLEnumValue(description="" +
		"<h5>Maester Gormon</h5>" +
		"House Tyrell.<br>" +
		"<b><i>Maester.</i></b><br>" +
		"You may look at the top card of your deck.Once per phase, if the top card of your deck is a non-[tyrell] card, you may marshal or play it as if it were in your hand..<br>" +
		"<i>Pit of Snakes.</i><br>"
	)
	MAESTER_GORMON_PoS ("13043"),
	@GraphQLEnumValue(description="" +
		"<h5>Unexpected Guile</h5>" +
		"House Tyrell.<br>" +
		"<b><i>Skill.</i></b><br>" +
		"Character with shadow you control only. Shadow (1).Attached character gets +2 STR and gains insight.<b>Forced Interrupt:</b> When a challenge ends in which attached character is participating, return Unexpected Guile and attached character to shadows..<br>" +
		"<i>Pit of Snakes.</i><br>"
	)
	UNEXPECTED_GUILE_PoS ("13044"),
	@GraphQLEnumValue(description="" +
		"<h5>Maester Mullin</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Maester.</i></b><br>" +
		"<b>Action:</b> Kneel Maester Mullin to choose a character and a challenge type. Until the end of the phase, that character cannot be declared as an attacker in challenges of that type..<br>" +
		"<i>Pit of Snakes.</i><br>"
	)
	MAESTER_MULLIN_PoS ("13045"),
	@GraphQLEnumValue(description="" +
		"<h5>Guard Duty</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Condition.</i></b><br>" +
		"[thenightswatch] character only.<b>Reaction:</b> After attached character is declared as a defender, kneel Guard Duty to stand attached character..<br>" +
		"<i>Pit of Snakes.</i><br>"
	)
	GUARD_DUTY_PoS ("13046"),
	@GraphQLEnumValue(description="" +
		"<h5>Ser Eldon Estermont</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Knight. Lord.</i></b><br>" +
		"<b>Action:</b> Choose and stand a [baratheon] location. (Limit once per round.).<br>" +
		"<i>Pit of Snakes.</i><br>"
	)
	SER_ELDON_ESTERMONT_PoS ("13047"),
	@GraphQLEnumValue(description="" +
		"<h5>Shadow of the Throne</h5>" +
		"House Baratheon.<br>" +
		"Shadow (1).<b>Action:</b> Choose and kneel any number of locations with total printed cost 3 or lower. If there is a <i>Kingdom</i> plot card revealed, return Shadow of the Throne to your hand instead of placing it in your discard pile..<br>" +
		"<i>Pit of Snakes.</i><br>"
	)
	SHADOW_OF_THE_THRONE_PoS ("13048"),
	@GraphQLEnumValue(description="" +
		"<h5>Chiswyck</h5>" +
		"House Lannister.<br>" +
		"<b><i>Ally.</i></b><br>" +
		"Pillage.<b>Reaction:</b> After you win a challenge in which Chiswyck is participating, discard the top card of your deck to draw 1 card..<br>" +
		"<i>Pit of Snakes.</i><br>"
	)
	CHISWYCK_PoS ("13049"),
	@GraphQLEnumValue(description="" +
		"<h5>\"Hands of Gold\"</h5>" +
		"House Lannister.<br>" +
		"<b><i>Song.</i></b><br>" +
		"<b>Reaction:</b> After you win an [intrigue] challenge by 5 or more STR as the attacking player, choose a character controlled by the losing opponent and return it to its owner's hand. (Max 1 per challenge.).<br>" +
		"<i>Pit of Snakes.</i><br>"
	)
	HANDS_OF_GOLD_PoS ("13050"),
	@GraphQLEnumValue(description="" +
		"<h5>King's Landing Proselyte</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Ally. Drowned God.</i></b><br>" +
		"Shadow (4).<b>Action:</b> Kill a standing [greyjoy] character to put King's Landing Proselyte into play from shadows..<br>" +
		"<i>Pit of Snakes.</i><br>"
	)
	KINGS_LANDING_PROSELYTE_PoS ("13051"),
	@GraphQLEnumValue(description="" +
		"<h5>Outfitted for War</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>Weapon.</i></b><br>" +
		"<i>Warship</i> location only.<b>Action:</b> During a [military] challenge, kneel attached location to give a participating [greyjoy] character +3 STR until the end of the challenge..<br>" +
		"<i>Pit of Snakes.</i><br>"
	)
	OUTFITTED_FOR_WAR_PoS ("13052"),
	@GraphQLEnumValue(description="" +
		"<h5>Jon Connington</h5>" +
		"House Targaryen.<br>" +
		"<b><i>House Connington. Lord.</i></b><br>" +
		"Shadow (5). Renown.<b>Reaction:</b> After Jon Connington comes out of shadows, choose and reveal a card you control in shadows. If it is a non-event card with printed cost 4 or lower, put it into play..<br>" +
		"<i>Pit of Snakes.</i><br>"
	)
	JON_CONNINGTON_PoS ("13053"),
	@GraphQLEnumValue(description="" +
		"<h5>The Dragonpit</h5>" +
		"House Targaryen.<br>" +
		"<b><i>King's Landing.</i></b><br>" +
		"Each character whose controller controls fewer cards in shadows than you gets -1 STR..<br>" +
		"<i>Pit of Snakes.</i><br>"
	)
	THE_DRAGONPIT_PoS ("13054"),
	@GraphQLEnumValue(description="" +
		"<h5>Arianne Martell (PoS)</h5>" +
		"House Martell.<br>" +
		"<b><i>Lady.</i></b><br>" +
		"Shadow (5). Stealth.<b>Reaction:</b> After a card comes out of shadows under your control, choose a character. Until the end of the phase, that character loses a challenge icon of your choice. (Limit 3 times per round.).<br>" +
		"<i>Pit of Snakes.</i><br>"
	)
	ARIANNE_MARTELL_PoS ("13055"),
	@GraphQLEnumValue(description="" +
		"<h5>A Pit of Snakes</h5>" +
		"House Martell.<br>" +
		"<b>Challenges Action:</b> Choose a character with no challenge icons and place a poison token on it. At the end of the phase, if that character still has that poison token, remove it and kill that character. (Max 1 per phase.).<br>" +
		"<i>Pit of Snakes.</i><br>"
	)
	A_PIT_OF_SNAKES_PoS ("13056"),
	@GraphQLEnumValue(description="" +
		"<h5>The Most Devout</h5>" +
		"Neutral.<br>" +
		"<b><i>The Seven.</i></b><br>" +
		"No attachments except <i>The Seven</i>.<b>Reaction:</b> After a character enters play under an opponent's control, if another character entered play under that player's control this phase, The Most Devout gains 1 power. (Limit once per phase.).<br>" +
		"<i>Pit of Snakes.</i><br>"
	)
	THE_MOST_DEVOUT_PoS ("13057"),
	@GraphQLEnumValue(description="" +
		"<h5>Statue of Baelor</h5>" +
		"Neutral.<br>" +
		"<b><i>King's Landing. The Seven.</i></b><br>" +
		"<b>Action:</b> Kneel Statue of Baelor and discard 1 power from another character or location you control to stand that character or location..<br>" +
		"<i>Pit of Snakes.</i><br>"
	)
	STATUE_OF_BAELOR_PoS ("13058"),
	@GraphQLEnumValue(description="" +
		"<h5>The Faith's Decree</h5>" +
		"Neutral.<br>" +
		"<b><i>The Seven.</i></b><br>" +
		"Play only if you control a <i>The Seven</i> character or location.<b>Action:</b> Name a non-agenda, non-plot card. Until the end of the phase, each opponent cannot trigger card abilities of cards with that name..<br>" +
		"<i>Pit of Snakes.</i><br>"
	)
	THE_FAITHS_DECREE_PoS ("13059"),
	@GraphQLEnumValue(description="" +
		"<h5>Manning the City Walls</h5>" +
		"Neutral.<br>" +
		"<b><i>City. War.</i></b><br>" +
		"<b>When Revealed:</b> Put a non-unique character with printed cost 3 or lower into play from your hand. (Printed cost 6 or lower instead if there is a <i>City</i> plot card in your used pile.).<br>" +
		"<i>Pit of Snakes.</i><br>"
	)
	MANNING_THE_CITY_WALLS_PoS ("13060"),
	@GraphQLEnumValue(description="" +
		"<h5>Tower of the Hand (BtRK)</h5>" +
		"House Stark.<br>" +
		"<b><i>King's Landing.</i></b><br>" +
		"<b>Reaction:</b> After a card you control comes out of shadows, if there is a <i>Winter</i> plot card revealed, choose and stand a [stark] character. (Limit once per phase.).<br>" +
		"<i>Beneath the Red Keep.</i><br>"
	)
	TOWER_OF_THE_HAND_BtRK ("13062"),
	@GraphQLEnumValue(description="" +
		"<h5>The Maidenvault</h5>" +
		"House Tyrell.<br>" +
		"<b><i>King's Landing.</i></b><br>" +
		"Shadow (1).<b>Reaction:</b> After The Maidenvault comes out of shadows, choose a participating <i>Lady</i> character. Stand it and remove it from the challenge.<b>Interrupt:</b> When the challenges phase ends, kneel The Maidenvault to return it to shadows..<br>" +
		"<i>Beneath the Red Keep.</i><br>"
	)
	THE_MAIDENVAULT_BtRK ("13064"),
	@GraphQLEnumValue(description="" +
		"<h5>Tunnels of the Red Keep</h5>" +
		"House Lannister.<br>" +
		"<b><i>King's Landing.</i></b><br>" +
		"Shadow (2).<b>Action:</b> Kneel Tunnels of the Red Keep to return it to shadows. Then, until the end of the phase, each character you control gets +1 STR for each card you control in shadows. (Max 1 per phase.).<br>" +
		"<i>Beneath the Red Keep.</i><br>"
	)
	TUNNELS_OF_THE_RED_KEEP_BtRK ("13070"),
	@GraphQLEnumValue(description="" +
		"<h5>Shadow of the Isles</h5>" +
		"House Greyjoy.<br>" +
		"Shadow (1).<b>Action:</b> Each player chooses a non-limited location he or she controls and discards it from play. If there is a <i>War</i> plot card revealed, return Shadow of the Isles to your hand instead of placing it in your discard pile..<br>" +
		"<i>Beneath the Red Keep.</i><br>"
	)
	SHADOW_OF_THE_ISLES_BtRK ("13072"),
	@GraphQLEnumValue(description="" +
		"<h5>Kingdom of Shadows</h5>" +
		"Neutral.<br>" +
		"You may include non-loyal characters with the printed shadow keyword from any faction in your deck.Increase the cost of each character you marshal by 1. Reduce the cost of the first character you bring out of shadows each round by 2..<br>" +
		"<i>Beneath the Red Keep.</i><br>"
	)
	KINGDOM_OF_SHADOWS_BtRK ("13079"),
	@GraphQLEnumValue(description="" +
		"<h5>Shadow of the North</h5>" +
		"House Stark.<br>" +
		"Shadow (1). Play only during a challenge.<b>Action:</b> Raise the claim value on your revealed plot card by 1 until the end of the challenge. If there is a <i>Winter</i> plot card revealed, return Shadow of the North to your hand instead of placing it in your discard pile. (Max 1 per challenge.).<br>" +
		"<i>The Blackwater.</i><br>"
	)
	SHADOW_OF_THE_NORTH_TB ("13082"),
	@GraphQLEnumValue(description="" +
		"<h5>Shadow of the Rose</h5>" +
		"House Tyrell.<br>" +
		"Shadow (2).<b>Action:</b> Search the top 10 cards of your deck for a card with shadow, reveal it, and put it into shadows. Shuffle your deck. If there is a <i>Summer</i> plot card revealed, return Shadow of the Rose to your hand instead of placing it in your discard pile..<br>" +
		"<i>The Blackwater.</i><br>"
	)
	SHADOW_OF_THE_ROSE_TB ("13084"),
	@GraphQLEnumValue(description="" +
		"<h5>Yoren (TB)</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Wandering Crow.</i></b><br>" +
		"<b>Reaction:</b> After Yoren enters play, choose a character with printed cost 5 or lower. Take control of that character until Yoren leaves play..<br>" +
		"<i>The Blackwater.</i><br>"
	)
	YOREN_TB ("13085"),
	@GraphQLEnumValue(description="" +
		"<h5>Blackwater Rush</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Westeros.</i></b><br>" +
		"Shadow (2).<b>Reaction:</b> After a card you control comes out of shadows, kneel Blackwater Rush to choose a [baratheon] character. That character gains 1 power..<br>" +
		"<i>The Blackwater.</i><br>"
	)
	BLACKWATER_RUSH_TB ("13088"),
	@GraphQLEnumValue(description="" +
		"<h5>Tyrion Lannister (TB)</h5>" +
		"House Lannister.<br>" +
		"<b><i>Lord. Small Council.</i></b><br>" +
		"Shadow (5). Insight.<b>Reaction:</b> After a non-event card you control comes out of shadows, place another card you control in shadows with a shadow token on it. While that card is in shadows, it gains shadow (X). X is its printed cost. (Limit once per round.).<br>" +
		"<i>The Blackwater.</i><br>"
	)
	TYRION_LANNISTER_TB ("13089"),
	@GraphQLEnumValue(description="" +
		"<h5>A Very Large Shadow</h5>" +
		"House Lannister.<br>" +
		"Shadow (0).<b>Action:</b> Reduce the cost of the next card you bring out of shadows this phase by 3. If there is a <i>Scheme</i> plot card revealed, return A Very Large Shadow to your hand instead of placing it in your discard pile. (Max 1 per phase.).<br>" +
		"<i>The Blackwater.</i><br>"
	)
	A_VERY_LARGE_SHADOW_TB ("13090"),
	@GraphQLEnumValue(description="" +
		"<h5>The Mountain's Skull</h5>" +
		"House Martell.<br>" +
		"<b><i>Item.</i></b><br>" +
		"Attached character gets +2 STR and gains renown.<b>Reaction:</b> After an opponent's character with printed STR 6 or higher is killed, put The Mountain's Skull into play from your hand or discard pile..<br>" +
		"<i>The Blackwater.</i><br>"
	)
	THE_MOUNTAINS_SKULL_TB ("13096"),
	@GraphQLEnumValue(description="" +
		"<h5>White Cloak</h5>" +
		"Neutral.<br>" +
		"<b><i>Item.</i></b><br>" +
		"<i>Knight</i> character you control only.Attached character gains the <i>Kingsguard</i> trait.<b>Interrupt:</b> When a <i>King</i> or <i>Queen</i> character would be killed, kneel attached character to save it..<br>" +
		"<i>The Blackwater.</i><br>"
	)
	WHITE_CLOAK_TB ("13098"),
	@GraphQLEnumValue(description="" +
		"<h5>Arya Stark (LMHR)</h5>" +
		"House Stark.<br>" +
		"<b><i>Lady.</i></b><br>" +
		"Shadow (4). Stealth.<b>Reaction:</b> After Arya Stark enters play, place a prayer token on up to 5 different characters you don't control. If Arya Stark leaves play, discard those tokens.<b>Reaction:</b> After a character with a prayer token is killed, stand Arya Stark and draw 1 card..<br>" +
		"<i>Long May He Reign.</i><br>"
	)
	ARYA_STARK_LMHR ("13101"),
	@GraphQLEnumValue(description="" +
		"<h5>Blood of the First Men</h5>" +
		"House Stark.<br>" +
		"<b><i>Legacy. Old Gods.</i></b><br>" +
		"Character you control only.Attached character gains the <i>Old Gods</i> trait.<b>Action:</b> During a challenge in which you control a participating [stark] character, kneel attached character to have it participate in the challenge on your side..<br>" +
		"<i>Long May He Reign.</i><br>"
	)
	BLOOD_OF_THE_FIRST_MEN_LMHR ("13102"),
	@GraphQLEnumValue(description="" +
		"<h5>Robert Baratheon (LMHR)</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Lord. King.</i></b><br>" +
		"Renown.<b>Reaction:</b> After Robert Baratheon gains power, gain 1 power for your faction. (Limit twice per round.).<br>" +
		"<i>Long May He Reign.</i><br>"
	)
	ROBERT_BARATHEON_LMHR ("13107"),
	@GraphQLEnumValue(description="" +
		"<h5>Long May He Reign</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Legacy.</i></b><br>" +
		"<i>King</i> character only.Attached character cannot be killed.<b>Forced Reaction:</b> After you lose a [power] challenge as the defending player, sacrifice Long May He Reign..<br>" +
		"<i>Long May He Reign.</i><br>"
	)
	LONG_MAY_HE_REIGN_LMHR ("13108"),
	@GraphQLEnumValue(description="" +
		"<h5>Ser Jorah Mormont (LMHR)</h5>" +
		"House Targaryen.<br>" +
		"<b><i>Companion. Knight.</i></b><br>" +
		"Shadow (4). No attachments except <i>Weapon</i>.<b>Interrupt:</b> When Ser Jorah Mormont is discarded from your hand, put him into shadows instead of placing him in your discard pile..<br>" +
		"<i>Long May He Reign.</i><br>"
	)
	SER_JORAH_MORMONT_LMHR ("13113"),
	@GraphQLEnumValue(description="" +
		"<h5>Mercenary Contract</h5>" +
		"House Targaryen.<br>" +
		"<b><i>Item.</i></b><br>" +
		"Attached character gains the <i>Mercenary</i> trait.<b>Reaction:</b> After you win a challenge in which attached character is attacking, pay 1 gold and kneel Mercenary Contract to stand attached character..<br>" +
		"<i>Long May He Reign.</i><br>"
	)
	MERCENARY_CONTRACT_LMHR ("13114"),
	@GraphQLEnumValue(description="" +
		"<h5>Robert Baratheon (FotS)</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Lord. King.</i></b><br>" +
		"Renown.<b>Reaction:</b> After the standing phase begins (choose one):- other characters with printed cost 5 or higher cannot stand this phase.- characters with printed cost 4 or lower cannot stand this phase.- locations cannot stand this phase..<br>" +
		"<i>Fury of the Storm.</i><br>"
	)
	ROBERT_BARATHEON_FotS ("14001"),
	@GraphQLEnumValue(description="" +
		"<h5>Stannis Baratheon (FotS)</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Lord. King. R'hllor.</i></b><br>" +
		"Immune to opponents' events.<b>Reaction:</b> After you win a [power] challenge, draw X cards. X is the claim value on the attacking player's revealed plot card..<br>" +
		"<i>Fury of the Storm.</i><br>"
	)
	STANNIS_BARATHEON_FotS ("14002"),
	@GraphQLEnumValue(description="" +
		"<h5>Melisandre (FotS)</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Lady. R'hllor.</i></b><br>" +
		"Stealth.<b>Reaction:</b> After you win an [intrigue] challenge in which Melisandre is attacking, move 1 power from a character controlled by the losing opponent to Melisandre. Then, if that character has no power, kill it..<br>" +
		"<i>Fury of the Storm.</i><br>"
	)
	MELISANDRE_FotS ("14003"),
	@GraphQLEnumValue(description="" +
		"<h5>Renly Baratheon (FotS)</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Lord. King.</i></b><br>" +
		"Renown.<b>Action:</b> Kneel your faction card to put a non-[baratheon] character with printed cost X or lower into play from your hand. X is Renly Baratheon's STR..<br>" +
		"<i>Fury of the Storm.</i><br>"
	)
	RENLY_BARATHEON_FotS ("14004"),
	@GraphQLEnumValue(description="" +
		"<h5>Salladhor Saan (FotS)</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Captain. Smuggler.</i></b><br>" +
		"<b>Reaction:</b> After you marshal a <i>Smuggler</i> character, choose and kneel a location. Then, gain gold equal to that location's printed cost. (Limit once per round.).<br>" +
		"<i>Fury of the Storm.</i><br>"
	)
	SALLADHOR_SAAN_FotS ("14005"),
	@GraphQLEnumValue(description="" +
		"<h5>Ser Davos Seaworth (FotS)</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Knight. Smuggler. The Seven.</i></b><br>" +
		"Stealth.<b>Reaction:</b> After you win a challenge in which Ser Davos Seaworth is participating, discard 1 power from the losing opponent's faction card. Then, you may have a <i>King</i> character you control gain 1 power..<br>" +
		"<i>Fury of the Storm.</i><br>"
	)
	SER_DAVOS_SEAWORTH_FotS ("14006"),
	@GraphQLEnumValue(description="" +
		"<h5>Alester Florent</h5>" +
		"House Baratheon.<br>" +
		"<b><i>House Florent. Lord. R'hllor.</i></b><br>" +
		"<b>Reaction:</b> After a <i>House Florent</i> character enters play, draw a card. (Limit once per round.)<b>Interrupt:</b> When Alester Florent leaves play, if you control another <i>R'hllor</i> character, choose and kneel a character an opponent controls..<br>" +
		"<i>Fury of the Storm.</i><br>"
	)
	ALESTER_FLORENT_FotS ("14007"),
	@GraphQLEnumValue(description="" +
		"<h5>Selyse Baratheon (FotS)</h5>" +
		"House Baratheon.<br>" +
		"<b><i>House Florent. Lady. Queen. R'hllor.</i></b><br>" +
		"Reduce the cost of each <i>R'hllor</i> attachment you marshal by 3..<br>" +
		"<i>Fury of the Storm.</i><br>"
	)
	SELYSE_BARATHEON_FotS ("14008"),
	@GraphQLEnumValue(description="" +
		"<h5>Griffin's Roost Knight</h5>" +
		"House Baratheon.<br>" +
		"<b><i>House Connington. Knight.</i></b><br>" +
		"<b>Interrupt:</b> When the challenges phase ends, if you have not lost a [power] challenge this phase, stand Griffin's Roost Knight..<br>" +
		"<i>Fury of the Storm.</i><br>"
	)
	GRIFFINS_ROOST_KNIGHT_FotS ("14009"),
	@GraphQLEnumValue(description="" +
		"<h5>Dale Seaworth</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Captain.</i></b><br>" +
		"<b>Reaction:</b> After you marshal Dale Seaworth, choose a [baratheon] location in your discard pile and return it to your hand..<br>" +
		"<i>Fury of the Storm.</i><br>"
	)
	DALE_SEAWORTH_FotS ("14010"),
	@GraphQLEnumValue(description="" +
		"<h5>Ser Imry Florent</h5>" +
		"House Baratheon.<br>" +
		"<b><i>House Florent. Knight.</i></b><br>" +
		"<b>Action:</b> Kill Ser Imry Florent to choose an opponent. You may sacrifice any number of locations. For each location sacrificed this way, that opponent must choose and kneel a standing character he or she controls..<br>" +
		"<i>Fury of the Storm.</i><br>"
	)
	SER_IMRY_FLORENT_FotS ("14011"),
	@GraphQLEnumValue(description="" +
		"<h5>Red Priest</h5>" +
		"House Baratheon.<br>" +
		"<b><i>R'hllor.</i></b><br>" +
		"<b>Reaction:</b> After Red Priest enters play, look at an opponent's hand. Then, choose 1 card in that hand and remove it from the game until Red Priest leaves play..<br>" +
		"<i>Fury of the Storm.</i><br>"
	)
	RED_PRIEST_FotS ("14012"),
	@GraphQLEnumValue(description="" +
		"<h5>Shyra Errol</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Lady.</i></b><br>" +
		"<b>Interrupt:</b> When a character is killed, sacrifice Shyra Errol to move each power from that character to its controller's faction card..<br>" +
		"<i>Fury of the Storm.</i><br>"
	)
	SHYRA_ERROL_FotS ("14013"),
	@GraphQLEnumValue(description="" +
		"<h5>Acolyte of the Flame</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Ally. R'hllor.</i></b><br>" +
		"<b>Reaction:</b> After the draw phase begins, kneel Acolyte of the Flame to look at the top 2 cards of an opponent's deck. You may put those cards on the bottom of that player's deck..<br>" +
		"<i>Fury of the Storm.</i><br>"
	)
	ACOLYTE_OF_THE_FLAME_FotS ("14014"),
	@GraphQLEnumValue(description="" +
		"<h5>Bastard of Robert</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Ally. Bastard.</i></b><br>" +
		"While you control Robert Baratheon, reduce the cost to marshal Bastard of Robert by 2.<b>Reaction:</b> After Bastard of Robert enters play, if you control a <i>King</i> character, draw a card..<br>" +
		"<i>Fury of the Storm.</i><br>"
	)
	BASTARD_OF_ROBERT_FotS ("14015"),
	@GraphQLEnumValue(description="" +
		"<h5>Wily Smuggler</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Smuggler.</i></b><br>" +
		"<b>Action:</b> Choose 1 card from your hand and place it on top of your deck. Then, at the end of the phase, draw 1 card. (Limit once per round.).<br>" +
		"<i>Fury of the Storm.</i><br>"
	)
	WILY_SMUGGLER_FotS ("14016"),
	@GraphQLEnumValue(description="" +
		"<h5>The Stormlands</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Westeros.</i></b><br>" +
		"You may initiate an additional [power] challenge during the challenges phase.<b>Reaction:</b> After you win a [power] challenge, kneel The Stormlands to choose and stand a participating <i>King</i> or <i>Queen</i> character..<br>" +
		"<i>Fury of the Storm.</i><br>"
	)
	THE_STORMLANDS_FotS ("14017"),
	@GraphQLEnumValue(description="" +
		"<h5>Cape Wrath</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Westeros.</i></b><br>" +
		"During [power] challenges in which you are the attacking or defending player, raise the claim value on the attacking player's revealed plot card by 1..<br>" +
		"<i>Fury of the Storm.</i><br>"
	)
	CAPE_WRATH_FotS ("14018"),
	@GraphQLEnumValue(description="" +
		"<h5>Lyseni Galley</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Warship.</i></b><br>" +
		"<b>Action:</b> Kneel Lyseni Galley to choose a character. Until the end of the phase, that character gets +1 STR. If that character is a <i>Captain</i> or <i>Smuggler</i>, it gains stealth until the end of the phase..<br>" +
		"<i>Fury of the Storm.</i><br>"
	)
	LYSENI_GALLEY_FotS ("14019"),
	@GraphQLEnumValue(description="" +
		"<h5>Azor Ahai Reborn</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Legacy. R'hllor.</i></b><br>" +
		"Unique character you control only. Terminal.Attached character is considered to be participating in each challenge in which you control an attacking <i>R'hllor</i> character..<br>" +
		"<i>Fury of the Storm.</i><br>"
	)
	AZOR_AHAI_REBORN_FotS ("14020"),
	@GraphQLEnumValue(description="" +
		"<h5>Hunting Accident</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Condition.</i></b><br>" +
		"Ambush (3). Terminal.Attached character cannot stand..<br>" +
		"<i>Fury of the Storm.</i><br>"
	)
	HUNTING_ACCIDENT_FotS ("14021"),
	@GraphQLEnumValue(description="" +
		"<h5>Warhammer</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Weapon.</i></b><br>" +
		"If attached character's printed STR is 4 or lower, it gets +2 STR.If attached character's printed STR is 5 or higher, it gains intimidate..<br>" +
		"<i>Fury of the Storm.</i><br>"
	)
	WARHAMMER_FotS ("14022"),
	@GraphQLEnumValue(description="" +
		"<h5>\"A Cask of Ale\"</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Song.</i></b><br>" +
		"<b>Reaction:</b> After you win a [power] challenge, choose 2 cards controlled by the same player. Move up to 2 power from one of those cards to the other..<br>" +
		"<i>Fury of the Storm.</i><br>"
	)
	A_CASK_OF_ALE_FotS ("14023"),
	@GraphQLEnumValue(description="" +
		"<h5>Nightfire Visions</h5>" +
		"House Baratheon.<br>" +
		"<b><i>R'hllor.</i></b><br>" +
		"Play only if you control a <i>R'hllor</i> character.<b>Taxation Action:</b> Name a <i>Trait</i>. If an opponent reveals a plot card with that <i>Trait</i> during the next plot phase, draw 3 cards..<br>" +
		"<i>Fury of the Storm.</i><br>"
	)
	NIGHTFIRE_VISIONS_FotS ("14024"),
	@GraphQLEnumValue(description="" +
		"<h5>Botley Crew</h5>" +
		"House Greyjoy.<br>" +
		"<b><i>House Botley. Raider.</i></b><br>" +
		"<b>Reaction:</b> After an opponent collects income, return 1 gold from that player's gold pool to the treasury..<br>" +
		"<i>Fury of the Storm.</i><br>"
	)
	BOTLEY_CREW_FotS ("14025"),
	@GraphQLEnumValue(description="" +
		"<h5>Every Captain is a King</h5>" +
		"House Greyjoy.<br>" +
		"<b>Action:</b> Until the end of the phase, each <i>Captain</i> character you control gains the <i>King</i> trait and does not kneel when declared as an attacker in [power] challenges..<br>" +
		"<i>Fury of the Storm.</i><br>"
	)
	EVERY_CAPTAIN_IS_A_KING_FotS ("14026"),
	@GraphQLEnumValue(description="" +
		"<h5>Ser Gregor Clegane (FotS)</h5>" +
		"House Lannister.<br>" +
		"<b><i>Knight. House Clegane.</i></b><br>" +
		"Intimidate. Pillage.<b>Forced Reaction:</b> After you win a challenge in which Ser Gregor Clegane is participating, choose and kill a character you control..<br>" +
		"<i>Fury of the Storm.</i><br>"
	)
	SER_GREGOR_CLEGANE_FotS ("14027"),
	@GraphQLEnumValue(description="" +
		"<h5>Lionstar</h5>" +
		"House Lannister.<br>" +
		"<b><i>Warship.</i></b><br>" +
		"<b>Action:</b> Kneel Lionstar to put a [lannister] character with printed cost 4 or lower into play from your hand. At the end of the phase, if that card is still in play, discard it from play..<br>" +
		"<i>Fury of the Storm.</i><br>"
	)
	LIONSTAR_FotS ("14028"),
	@GraphQLEnumValue(description="" +
		"<h5>Prince's Attendant</h5>" +
		"House Martell.<br>" +
		"<b><i>Ally.</i></b><br>" +
		"<b>Marshaling Action:</b> Kneel Prince's Attendant to reduce the cost of the next [martell] <i>Lord</i> or <i>Lady</i> character you marshal this phase by 2..<br>" +
		"<i>Fury of the Storm.</i><br>"
	)
	PRINCES_ATTENDANT_FotS ("14029"),
	@GraphQLEnumValue(description="" +
		"<h5>Kingsgrave</h5>" +
		"House Martell.<br>" +
		"<b><i>House Manwoody.</i></b><br>" +
		"<b>Reaction:</b> After you lose a [power] challenge by 5 or more STR, kneel and sacrifice Kingsgrave to choose a participating character and return it to its owner's hand. (You may kill that character instead if it has the <i>King</i> trait.)<em>Errata from FAQ v2.2</em>.<br>" +
		"<i>Fury of the Storm.</i><br>"
	)
	KINGSGRAVE_FotS ("14030"),
	@GraphQLEnumValue(description="" +
		"<h5>Protectors of the Realm (FotS)</h5>" +
		"The Night's Watch.<br>" +
		"<b><i>Army.</i></b><br>" +
		"No attachments.X is your reserve value..<br>" +
		"<i>Fury of the Storm.</i><br>"
	)
	PROTECTORS_OF_THE_REALM_FotS ("14031"),
	@GraphQLEnumValue(description="" +
		"<h5>The Horn that Wakes the Sleepers</h5>" +
		"The Night's Watch.<br>" +
		"<b>Reaction:</b> After an opponent initiates a challenge against you, choose and stand a <i>Builder</i> character, a <i>Ranger</i> character, and a <i>Steward</i> character..<br>" +
		"<i>Fury of the Storm.</i><br>"
	)
	THE_HORN_THAT_WAKES_THE_SLEEPERS_FotS ("14032"),
	@GraphQLEnumValue(description="" +
		"<h5>She-Bear</h5>" +
		"House Stark.<br>" +
		"<b><i>House Mormont.</i></b><br>" +
		"<b>Reaction:</b> After you marshal She-Bear, you may put a [stark] character or attachment with printed cost 3 or lower into play from your hand..<br>" +
		"<i>Fury of the Storm.</i><br>"
	)
	SHE_BEAR_FotS ("14033"),
	@GraphQLEnumValue(description="" +
		"<h5>Bearskin Cloak</h5>" +
		"House Stark.<br>" +
		"<b><i>Item.</i></b><br>" +
		"Attached character gets +1 STR.If attached character has the <i>House Mormont</i> trait, it gains stealth..<br>" +
		"<i>Fury of the Storm.</i><br>"
	)
	BEARSKIN_CLOAK_FotS ("14034"),
	@GraphQLEnumValue(description="" +
		"<h5>Haggo</h5>" +
		"House Targaryen.<br>" +
		"<b><i>Bloodrider. Dothraki.</i></b><br>" +
		"<b>Reaction:</b> After you win a challenge in which Haggo is participating, discard a card from your hand to choose a <i>Dothraki</i> card in your discard pile and return it to your hand..<br>" +
		"<i>Fury of the Storm.</i><br>"
	)
	HAGGO_FotS ("14035"),
	@GraphQLEnumValue(description="" +
		"<h5>Dothraki Steed</h5>" +
		"House Targaryen.<br>" +
		"<b><i>Warhorse.</i></b><br>" +
		"Limit 1 copy per character.While attached character is attacking, it gets +1 STR (+3 STR instead if it has the <i>Dothraki</i> trait).<em>Errata from FAQ v2.2</em>.<br>" +
		"<i>Fury of the Storm.</i><br>"
	)
	DOTHRAKI_STEED_FotS ("14036"),
	@GraphQLEnumValue(description="" +
		"<h5>Hightower Knight</h5>" +
		"House Tyrell.<br>" +
		"<b><i>House Hightower. Knight.</i></b><br>" +
		"<b>Action:</b> Kneel a non-[tyrell] <i>Knight</i> character to put Hightower Knight into play from your hand..<br>" +
		"<i>Fury of the Storm.</i><br>"
	)
	HIGHTOWER_KNIGHT_FotS ("14037"),
	@GraphQLEnumValue(description="" +
		"<h5>Fields of the Reach</h5>" +
		"House Tyrell.<br>" +
		"<b><i>The Reach.</i></b><br>" +
		"<b>Reaction:</b> After you win a [power] challenge, kneel 3 <i>The Reach</i> locations to raise the claim value on your revealed plot card by 1 until the end of the challenge..<br>" +
		"<i>Fury of the Storm.</i><br>"
	)
	FIELDS_OF_THE_REACH_FotS ("14038"),
	@GraphQLEnumValue(description="" +
		"<h5>Lyn Corbray (FotS)</h5>" +
		"Neutral.<br>" +
		"<b><i>House Arryn. Knight.</i></b><br>" +
		"Stealth.<b>Reaction:</b> After an opponent initiates a [power] challenge against you, stand Lyn Corbray..<br>" +
		"<i>Fury of the Storm.</i><br>"
	)
	LYN_CORBRAY_FotS ("14039"),
	@GraphQLEnumValue(description="" +
		"<h5>Unlikely Champion</h5>" +
		"Neutral.<br>" +
		"<b><i>Knight.</i></b><br>" +
		"While you control a <i>Lord</i> or <i>Lady</i> character,  Unlikely Champion gains a [power] icon..<br>" +
		"<i>Fury of the Storm.</i><br>"
	)
	UNLIKELY_CHAMPION_FotS ("14040"),
	@GraphQLEnumValue(description="" +
		"<h5>Anguy the Archer</h5>" +
		"Neutral.<br>" +
		"<b><i>Brotherhood. R'hllor.</i></b><br>" +
		"While you control no loyal characters, Anguy the Archer does not kneel when declared as an attacker or defender in a [military] challenge..<br>" +
		"<i>Fury of the Storm.</i><br>"
	)
	ANGUY_THE_ARCHER_FotS ("14041"),
	@GraphQLEnumValue(description="" +
		"<h5>The Hollow Hill</h5>" +
		"Neutral.<br>" +
		"<b><i>Brotherhood. Westeros.</i></b><br>" +
		"<b>Dominance Action:</b> If you control no loyal characters, kneel The Hollow Hill to search the top 10 cards of your deck for a non-loyal character, reveal it, and add it to your hand. Shuffle your deck..<br>" +
		"<i>Fury of the Storm.</i><br>"
	)
	THE_HOLLOW_HILL_FotS ("14042"),
	@GraphQLEnumValue(description="" +
		"<h5>Lady Forlorn</h5>" +
		"Neutral.<br>" +
		"<b><i>Valyrian Steel. Weapon.</i></b><br>" +
		"Attached character gets +1 STR for each neutral location you control.If attached character is Lyn Corbray, he gains a [power] icon..<br>" +
		"<i>Fury of the Storm.</i><br>"
	)
	LADY_FORLORN_FotS ("14043"),
	@GraphQLEnumValue(description="" +
		"<h5>Defiance</h5>" +
		"Neutral.<br>" +
		"<b>Challenges Action:</b> Choose and stand a character that has not participated in a challenge this phase. (Max 1 per phase.).<br>" +
		"<i>Fury of the Storm.</i><br>"
	)
	DEFIANCE_FotS ("14044"),
	@GraphQLEnumValue(description="" +
		"<h5>The Prince that was Promised</h5>" +
		"Neutral.<br>" +
		"<b><i>Prophecy.</i></b><br>" +
		"After all agendas are announced, name a unique character.Other characters you control cannot gain power.<b>Reaction:</b> After you win a [power] challenge by 5 or more STR, kneel your faction card to, either: stand the named character and draw a card; or, search your deck, discard pile,  and dead pile for the named character, reveal it, add it to your hand, and shuffle your deck..<br>" +
		"<i>Fury of the Storm.</i><br>"
	)
	THE_PRINCE_THAT_WAS_PROMISED_FotS ("14045"),
	@GraphQLEnumValue(description="" +
		"<h5>Parley at Storm's End</h5>" +
		"House Baratheon.<br>" +
		"<b><i>Siege. War.</i></b><br>" +
		"<b>When Revealed:</b> Name a challenge type. Until you reveal a new plot card, challenges of that type cannot be initiated..<br>" +
		"<i>Fury of the Storm.</i><br>"
	)
	PARLEY_AT_STORMS_END_FotS ("14046"),
	@GraphQLEnumValue(description="" +
		"<h5>Outwit</h5>" +
		"Neutral.<br>" +
		"<b><i>Scheme.</i></b><br>" +
		"<b>Interrupt:</b> When the effects of a when revealed ability would initiate, kneel your faction card and a unique <i>Maester</i> character to cancel those effects..<br>" +
		"<i>Fury of the Storm.</i><br>"
	)
	OUTWIT_FotS ("14047"),
	@GraphQLEnumValue(description="" +
		"<h5>Siege Preparations</h5>" +
		"Neutral.<br>" +
		"<b><i>Siege.</i></b><br>" +
		"<b>Dominance Action:</b> Draw cards until your hand size is equal to your reserve value. (Limit once per phase.).<br>" +
		"<i>Fury of the Storm.</i><br>"
	)
	SIEGE_PREPARATIONS_FotS ("14048"),
	@GraphQLEnumValue(description="" +
		"<h5>Rationing</h5>" +
		"Neutral.<br>" +
		"<b><i>Edict. Winter.</i></b><br>" +
		"Players cannot trigger reactions to winning or losing challenges..<br>" +
		"<i>Fury of the Storm.</i><br>"
	)
	RATIONING_FotS ("14049"),
	@GraphQLEnumValue(description="" +
		"<h5>Desperate Attack</h5>" +
		"Neutral.<br>" +
		"<b><i>War.</i></b><br>" +
		"While you are the defending player, raise the claim value on the attacking player's revealed plot card by 1..<br>" +
		"<i>Fury of the Storm.</i><br>"
	)
	DESPERATE_ATTACK_FotS ("14050"),
	@GraphQLEnumValue(description="" +
		"<h5>The Hand's Tourney</h5>" +
		"Neutral.<br>" +
		"<b><i>Kingdom. Summer.</i></b><br>" +
		"<b>Forced Interrupt:</b> When claim is applied for a [military] challenge, apply [power] claim instead..<br>" +
		"<i>Fury of the Storm.</i><br>"
	)
	THE_HANDS_TOURNEY_FotS ("14051"),
	@GraphQLEnumValue(description="" +
		"<h5>The New Gods</h5>" +
		"Neutral.<br>" +
		"<b><i>The Seven.</i></b><br>" +
		"Each <i>The Seven</i> character you control does not kneel when declared as an attacker in the first challenge you initiate during the challenges phase..<br>" +
		"<i>Fury of the Storm.</i><br>"
	)
	THE_NEW_GODS_FotS ("14052");

	@Getter
	private String cardCode;

	private AgotCardSeed(String cardCode) {
		this.cardCode = cardCode;
	}

}
