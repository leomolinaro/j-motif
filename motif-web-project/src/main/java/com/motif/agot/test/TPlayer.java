package com.motif.agot.test;

import com.motif.agot.ang.enums.AngIcon;
import com.motif.agot.state.AgotPlayer;
import com.motif.agot.state.cards.AttachmentCard;
import com.motif.agot.state.cards.CharacterCard;
import com.motif.agot.state.cards.MarshallCard;
import com.motif.agot.state.cards.PlotCard;
import com.motif.agot.state.cards.TextCard;
import com.motif.shared.exceptions.MotifException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TPlayer {

	private final AgotPlayer player;
	private final Test test;
	
	public void selectPlot(PlotCard plot) throws MotifException { this.test.selectPlot(plot, this.player); }
	public void selectFirstPlayer(TPlayer player) throws MotifException { this.test.selectFirstPlayer(player.player, this.player); }
	public void marshall(MarshallCard<?> toMarshall) throws MotifException { this.test.marshall(toMarshall, this.player); }
	public void initiateChallenge(AngIcon icon, TPlayer defender, CharacterCard...attackers) throws MotifException { this.test.initiateChallenge(icon, defender.player, attackers, this.player); }
	public void endChallenge() throws MotifException { this.test.endChallenge(this.player); }
	//public void attack(CharacterCard attacker) { this.test.attack(attacker, this.player); }
	public void defend(CharacterCard defender) throws MotifException { this.test.defend(defender, this.player); }
	public void reaction(TextCard<?> reactingCard) throws MotifException { this.test.reaction(reactingCard, this.player); }
	public void attach(AttachmentCard attachment, CharacterCard attachTo) throws MotifException { this.test.attach(attachment, attachTo, player); }
	public void noMulligan () throws MotifException { this.test.noMulligan (player); }
	public void draw () throws MotifException { this.test.draw (this.player); }
	
} // TPlayer
