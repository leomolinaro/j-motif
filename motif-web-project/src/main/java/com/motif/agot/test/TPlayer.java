package com.motif.agot.test;

import com.motif.agot.ang.enums.AngIcon;
import com.motif.agot.state.AgotPlayer;
import com.motif.agot.state.cards.AttachmentCard;
import com.motif.agot.state.cards.CharacterCard;
import com.motif.agot.state.cards.MarshallCard;
import com.motif.agot.state.cards.PlotCard;
import com.motif.agot.state.cards.TextCard;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TPlayer {

	private final AgotPlayer player;
	private final Test test;
	
	public void selectPlot(PlotCard plot) { this.test.selectPlot(plot, this.player); }
	public void selectFirstPlayer(TPlayer player) { this.test.selectFirstPlayer(player.player, this.player); }
	public void marshall(MarshallCard<?> toMarshall) { this.test.marshall(toMarshall, this.player); }
	public void initiateChallenge(AngIcon icon, TPlayer defender, CharacterCard...attackers) { this.test.initiateChallenge(icon, defender.player, attackers, this.player); }
	public void endChallenge() { this.test.endChallenge(this.player); }
	//public void attack(CharacterCard attacker) { this.test.attack(attacker, this.player); }
	public void defend(CharacterCard defender) { this.test.defend(defender, this.player); }
	public void reaction(TextCard<?> reactingCard) { this.test.reaction(reactingCard, this.player); }
	public void attach(AttachmentCard attachment, CharacterCard attachTo) { this.test.attach(attachment, attachTo, player); }
	
}
