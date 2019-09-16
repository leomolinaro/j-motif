package com.motif.agot.ang.text;

import com.motif.agot.ang.text.effects.IAngEffect;
import com.motif.agot.ang.text.limit.AngTrigLimit;

import lombok.Getter;

public class AngWhenRevealed extends AngTrigAbility {

	@Getter private final boolean implicit;

	public AngWhenRevealed (IAngEffect effect, AngTrigLimit limit, boolean implicit) {
		super (null, effect, limit);
		this.implicit = implicit;
	} // AngAction
	
	public String getLabel () { return "When revealed"; }
	
	public static class WRB extends TAB<WRB> {
		
		private boolean implicit = false;
		
		@Override protected WRB getThis () { return this; }
		
		public static EB i () {
			WRB wrb = new WRB ();
			return wrb.new EB ();
		} // i
		
		public WRB implicit () {
			this.implicit = true;
			return this;
		} // implicit
		
		public AngWhenRevealed build () {
			AngWhenRevealed whenRevealed = new AngWhenRevealed (effect, limit, implicit);
			return whenRevealed;
		} // build
		
	} // WRB

} // AngAction
