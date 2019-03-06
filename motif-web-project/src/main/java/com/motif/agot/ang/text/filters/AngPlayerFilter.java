package com.motif.agot.ang.text.filters;

public class AngPlayerFilter {

	private boolean duringChallenge = false;
	public boolean duringChallenge () { return duringChallenge; }
	
	private boolean you = false;
	public boolean you () { return you; }

	private boolean opponent = false;
	public boolean opponent () { return opponent; }
	
	private boolean theLoosingOpponent = false;
	public boolean theLoosingOpponent () { return theLoosingOpponent; }

	private boolean theDefendingPlayer = false;
	public boolean theDefendingPlayer () { return theDefendingPlayer; }
	
	private AngPlayerFilter () {
	} // AngCardFilter
	
	public static class PFB {
		
		private AngPlayerFilter pf = new AngPlayerFilter ();
		
		private PFB () {}
		
		public PFB you () { pf.you = true; return this; }
		public PFB anOpponent () { pf.opponent = true; return this; }
		public PFB eachOpponents () { return anOpponent (); }
		public PFB theLoosingOpponent () { pf.duringChallenge = true; pf.theLoosingOpponent = true; return this; }
		public PFB theDefendingPlayer () { pf.duringChallenge = true; pf.theDefendingPlayer = true; return this; }
		
		public AngPlayerFilter build () { return pf; }

		public static PFB i () {
			return new PFB ();
		} // i

		
	} // PFB
	
} // AngPlayerFilter
