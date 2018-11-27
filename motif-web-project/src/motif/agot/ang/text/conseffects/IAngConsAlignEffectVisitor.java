package motif.agot.ang.text.conseffects;

import motif.agot.ang.text.conseffects.AngConsEffects.AngEachCardCannotBeBypassedByStealth;
import motif.agot.ang.text.conseffects.AngConsEffects.AngEachCardGainsAKeyword;
import motif.agot.ang.text.conseffects.AngConsEffects.AngEachCardGetsStrength;
import motif.agot.ang.text.conseffects.AngConsEffects.AngTreatEachCardAsIfItsPrintedTextBoxWereBlackExceptForTrait;
import motif.agot.ang.text.conseffects.AngConsEffects.AngTreatTheBaseGoldValueOfEachCardAsIfItWereN;

public interface IAngConsAlignEffectVisitor {

	public boolean visit (AngEachCardGainsAKeyword consEffect);
	public boolean visit (AngEachCardGetsStrength consEffect);
	public boolean visit (AngTreatEachCardAsIfItsPrintedTextBoxWereBlackExceptForTrait consEffect);
	public boolean visit (AngTreatTheBaseGoldValueOfEachCardAsIfItWereN consEffect);
	public boolean visit (AngEachCardCannotBeBypassedByStealth consEffect);

} // IAngConsEffectVisitor
