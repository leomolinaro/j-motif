package com.motif.agot.ang.text;

import com.motif.agot.ang.enums.AngKeyword;
import com.motif.agot.ang.enums.AngTrait;

public class AngTextKeyword {

	private AngKeyword keyword;
	public AngKeyword getKeyword () { return keyword; }

	private Integer value;
	public Integer getValue () { return value; }

	private AngTrait exceptTrait;
	public AngTrait getExceptTrait () { return exceptTrait; }
	
	public AngTextKeyword (AngKeyword keyword, Integer value, AngTrait exceptTrait) {
		this.keyword = keyword;
		this.value = value;
		this.exceptTrait = exceptTrait;
	} // AngTextKeyword

	public static AngTextKeyword ambush (Integer value) { return new AngTextKeyword (AngKeyword.AMBUSH, value, null); }
	public static AngTextKeyword insight () { return new AngTextKeyword (AngKeyword.INSIGHT, null, null); }
	public static AngTextKeyword intimidate () { return new AngTextKeyword (AngKeyword.INTIMIDATE, null, null); }
	public static AngTextKeyword limited () { return new AngTextKeyword (AngKeyword.LIMITED, null, null); }
	public static AngTextKeyword noAttachments (AngTrait exceptTrait) { return new AngTextKeyword (AngKeyword.NO_ATTACHMENTS, null, exceptTrait); }
	public static AngTextKeyword pillage () { return new AngTextKeyword (AngKeyword.PILLAGE, null, null); }
	public static AngTextKeyword renown () { return new AngTextKeyword (AngKeyword.RENOWN, null, null); }
	public static AngTextKeyword stealth () { return new AngTextKeyword (AngKeyword.STEALTH, null, null); }
	public static AngTextKeyword terminal () { return new AngTextKeyword (AngKeyword.TERMINAL, null, null); }
	
} // AngTextKeyword
