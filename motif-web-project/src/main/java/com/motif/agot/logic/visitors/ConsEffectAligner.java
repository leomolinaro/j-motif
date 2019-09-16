package com.motif.agot.logic.visitors;

import com.motif.agot.ang.text.conseffects.AngConsEffects.AngEachCardCannotBeBypassedByStealth;
import com.motif.agot.ang.text.conseffects.AngConsEffects.AngEachCardGainsAKeyword;
import com.motif.agot.ang.text.conseffects.AngConsEffects.AngEachCardGetsStrength;
import com.motif.agot.ang.text.conseffects.AngConsEffects.AngTreatEachCardAsIfItsPrintedTextBoxWereBlackExceptForTrait;
import com.motif.agot.ang.text.conseffects.AngConsEffects.AngTreatTheBaseGoldValueOfEachCardAsIfItWereN;
import com.motif.agot.ang.text.conseffects.IAngConsAlignEffectVisitor;
import com.motif.agot.logic.other.AbilityContext;
import com.motif.agot.logic.other.FilterMatcher;
import com.motif.agot.state.AgotGame;
import com.motif.agot.state.abilities.ConsAlignAbility;
import com.motif.agot.state.cards.CharacterCard;
import com.motif.agot.state.cards.MarshallCard;

public class ConsEffectAligner implements IAngConsAlignEffectVisitor {
	
	public static void apply (ConsAlignAbility ca, MarshallCard<?> playedCard, AbilityContext ac, AgotGame game) {
		ConsEffectAligner aligner = new ConsEffectAligner (playedCard, ac, game, true);
		ca.getConsEffect ().accept (aligner);
	} // submit
	
	public static void unapply (ConsAlignAbility ca, MarshallCard<?> unplayedCard, AbilityContext ac, AgotGame game) {
		ConsEffectAligner aligner = new ConsEffectAligner (unplayedCard, ac, game, false);
		ca.getConsEffect ().accept (aligner);
	} // unsubmit
	
	private boolean submit;
	private MarshallCard<?> submittedCard;
	@SuppressWarnings("unused")
	private AgotGame game;
	private AbilityContext ac;
	
	public ConsEffectAligner (MarshallCard<?> submittedCard, AbilityContext ac, AgotGame game, boolean submit) {
		this.submittedCard = submittedCard;
		this.ac = ac;
		this.game = game;
		this.submit = submit;
	} // ConsEffectAligner
	
	@Override
	public boolean visit (AngEachCardGainsAKeyword consEffect) {
		if (FilterMatcher.doesMatch (submittedCard, ac, consEffect.getFilter ())) {
			ConsEffectApplier.applyGainsAKeyword (consEffect.getKeyword (), (CharacterCard) submittedCard, submit);
		} // if
		return true;
	} // visit

	@Override
	public boolean visit (AngEachCardGetsStrength consEffect) {
		if (FilterMatcher.doesMatch (submittedCard, ac, consEffect.getFilter ())) {
			ConsEffectApplier.applyGetsStrength (consEffect.getStrength (),	(CharacterCard) submittedCard, submit);
		} // if
		return true;
	} // visit
	
	@Override
	public boolean visit (AngTreatEachCardAsIfItsPrintedTextBoxWereBlackExceptForTrait consEffect) {
		// TODO
		return false;
	} // visit
	
	@Override
	public boolean visit (AngTreatTheBaseGoldValueOfEachCardAsIfItWereN consEffect) {// TODO
		return false;
	} // visit
	
	@Override
	public boolean visit (AngEachCardCannotBeBypassedByStealth consEffect) {
		if (FilterMatcher.doesMatch (submittedCard, ac, consEffect.getCardFilter ())) {
			ConsEffectApplier.applyCannotBeBypassedByStealth ((CharacterCard) submittedCard, submit);
		} // if
		return true;
	} // visit
	
} // ConsEffectAlignChecker
