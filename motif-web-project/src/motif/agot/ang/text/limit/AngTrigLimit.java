package motif.agot.ang.text.limit;

import motif.agot.ang.enums.AngTime;

public class AngTrigLimit {

	private int times;
	public int getTimes () { return times; }
	
	private AngTime per;
	public AngTime getPer () { return per; }
	
	public AngTrigLimit (int times, AngTime per) {
		this.times = times;
		this.per = per;
	} // AngTrigLimit
	
} // AngTrigLimit
