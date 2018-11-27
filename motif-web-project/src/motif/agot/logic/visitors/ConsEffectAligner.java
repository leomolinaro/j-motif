package motif.agot.logic.visitors;

import motif.agot.ang.text.conseffects.AngConsEffects.AngEachCardCannotBeBypassedByStealth;
import motif.agot.ang.text.conseffects.AngConsEffects.AngEachCardGainsAKeyword;
import motif.agot.ang.text.conseffects.AngConsEffects.AngEachCardGetsStrength;
import motif.agot.ang.text.conseffects.AngConsEffects.AngTreatEachCardAsIfItsPrintedTextBoxWereBlackExceptForTrait;
import motif.agot.ang.text.conseffects.AngConsEffects.AngTreatTheBaseGoldValueOfEachCardAsIfItWereN;
import motif.agot.ang.text.conseffects.IAngConsAlignEffectVisitor;
import motif.agot.logic.other.FilterMatcher;
import motif.agot.state.AgotGame;
import motif.agot.state.ConsAlignAbility;
import motif.agot.state.AgotPlayer;
import motif.agot.state.cards.CharacterCard;
import motif.agot.state.cards.MarshallCard;

public class ConsEffectAligner implements IAngConsAlignEffectVisitor {
	
	public static void apply (ConsAlignAbility ca, MarshallCard<?> playedCard, AgotPlayer abilityController, AgotGame game) {
		ConsEffectAligner aligner = new ConsEffectAligner (playedCard, abilityController, game, true);
		ca.getConsEffect ().accept (aligner);
	} // submit
	
	public static void unapply (ConsAlignAbility ca, MarshallCard<?> unplayedCard, AgotPlayer abilityController, AgotGame game) {
		ConsEffectAligner aligner = new ConsEffectAligner (unplayedCard, abilityController, game, false);
		ca.getConsEffect ().accept (aligner);
	} // unsubmit
	
	private boolean submit;
	private MarshallCard<?> submittedCard;
	@SuppressWarnings("unused")
	private AgotGame game;
	private AgotPlayer you;
	
	public ConsEffectAligner (MarshallCard<?> submittedCard, AgotPlayer you, AgotGame game, boolean submit) {
		this.submittedCard = submittedCard;
		this.you = you;
		this.game = game;
		this.submit = submit;
	} // ConsEffectAligner
	
	@Override
	public boolean visit (AngEachCardGainsAKeyword consEffect) {
		if (FilterMatcher.doesMatch (submittedCard, you, consEffect.getFilter ())) {
			ConsEffectApplier.applyGainsAKeyword (consEffect.getKeyword (), (CharacterCard) submittedCard, submit);
		} // if
		return true;
	} // visit

	@Override
	public boolean visit (AngEachCardGetsStrength consEffect) {
		if (FilterMatcher.doesMatch (submittedCard, you, consEffect.getFilter ())) {
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
		if (FilterMatcher.doesMatch (submittedCard, you, consEffect.getCardFilter ())) {
			ConsEffectApplier.applyCannotBeBypassedByStealth ((CharacterCard) submittedCard, submit);
		} // if
		return true;
	} // visit
	
} // ConsEffectAlignChecker
