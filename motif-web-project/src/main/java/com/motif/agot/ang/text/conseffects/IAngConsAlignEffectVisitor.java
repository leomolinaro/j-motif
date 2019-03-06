package com.motif.agot.ang.text.conseffects;

import com.motif.agot.ang.text.conseffects.AngConsEffects.AngEachCardCannotBeBypassedByStealth;
import com.motif.agot.ang.text.conseffects.AngConsEffects.AngEachCardGainsAKeyword;
import com.motif.agot.ang.text.conseffects.AngConsEffects.AngEachCardGetsStrength;
import com.motif.agot.ang.text.conseffects.AngConsEffects.AngTreatEachCardAsIfItsPrintedTextBoxWereBlackExceptForTrait;
import com.motif.agot.ang.text.conseffects.AngConsEffects.AngTreatTheBaseGoldValueOfEachCardAsIfItWereN;

public interface IAngConsAlignEffectVisitor {

	public boolean visit (AngEachCardGainsAKeyword consEffect);
	public boolean visit (AngEachCardGetsStrength consEffect);
	public boolean visit (AngTreatEachCardAsIfItsPrintedTextBoxWereBlackExceptForTrait consEffect);
	public boolean visit (AngTreatTheBaseGoldValueOfEachCardAsIfItWereN consEffect);
	public boolean visit (AngEachCardCannotBeBypassedByStealth consEffect);

} // IAngConsEffectVisitor
