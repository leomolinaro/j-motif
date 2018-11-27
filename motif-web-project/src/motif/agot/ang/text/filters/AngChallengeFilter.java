package motif.agot.ang.text.filters;

import motif.agot.ang.enums.AngIcon;
import motif.agot.ang.enums.AngSubject;
import motif.agot.ang.text.filters.AngCardFilter.CFB;

public class AngChallengeFilter {

	private boolean unopposed = false;
	public boolean unopposed () { return unopposed; }
	
	@SuppressWarnings("unused")
	private Integer byNOrMoreSTR = null;
	
	private AngIcon icon = null;
	public AngIcon getIcon () { return icon; }
	public boolean hasIcon () { return icon != null; }

//	private Boolean asAttackingPlayer = null;
//	public boolean asAttackingPlayer () { return asAttackingPlayer != null && asAttackingPlayer; }
//	public boolean asDefendingPlayer () { return asAttackingPlayer != null && !asAttackingPlayer; }

	private AngSubject partecipatingSubject;
	public AngSubject getPartecipatingSubject () { return partecipatingSubject; }
	public boolean hasPartecipatingCondition () { return partecipatingSubject != null; }
	
	private AngCardFilter partecipatingCardFilter;
	public AngCardFilter getPartecipatingCardFilter () { return partecipatingCardFilter; }
	
	private Boolean partecipatingAsAttacker;
	public boolean partecipatingAsAttacker () { return partecipatingAsAttacker != null && partecipatingAsAttacker; }
	public boolean partecipatingAsDefender () { return partecipatingAsAttacker != null && !partecipatingAsAttacker; }
	
	public static class ChFB {
		
		private ChFB () {}
		
		private AngChallengeFilter challengeFilter = new AngChallengeFilter ();
		
		public ChFB icon (AngIcon icon) { challengeFilter.icon = icon; return this; }
		public ChFB intrigue () { return icon (AngIcon.INTRIGUE); }
		public ChFB power () { return icon (AngIcon.POWER); }
		public ChFB military () { return icon (AngIcon.MILITARY); }

//		public ChFB asAttackingPlayer () { challengeFilter.asAttackingPlayer = true; return this; }
//		public ChFB asDefendingPlayer () { challengeFilter.asAttackingPlayer = false; return this; }
		public ChFB unopposed () { challengeFilter.unopposed = true; return this; }
		public ChFB byNOrMoreSTR (int n) { challengeFilter.byNOrMoreSTR = 5; return this; }
		
		public ChFB inWhichThisIsPartecipating () { return inWhichACharacterIsPartecipating (AngSubject.THIS, null, null); }
		public ChFB inWhichAttachedIsPartecipating () { return inWhichACharacterIsPartecipating (AngSubject.ATTACHED, null, null); }
		public ChFB inWhichAttachedIsPartecipatingAsAttacker () { return inWhichACharacterIsPartecipating (AngSubject.ATTACHED, null, true); }
//		
		public ChFB inWhichACharacterIsPartecipating (AngSubject subject, CFB cardFilterBuilder, Boolean asAttacker) {
			challengeFilter.partecipatingSubject = subject;
			if (cardFilterBuilder != null) { challengeFilter.partecipatingCardFilter = cardFilterBuilder.build (); }
			challengeFilter.partecipatingAsAttacker = asAttacker;
			return this;
		} // inWhichACharacterIsPartecipating
		
		public AngChallengeFilter build () { return challengeFilter; }
		
		public static ChFB i () { return new ChFB (); }
		
	} // ChFB
	
} // AngChallengeFilter
