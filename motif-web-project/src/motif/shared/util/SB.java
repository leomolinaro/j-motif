package motif.shared.util;

public class SB {

	private StringBuilder sb = new StringBuilder ();
	public SB a (Object...s) { for (Object o : s) { sb.append (o); } return this; }
	public SB n () { return a ("\n"); }
	public SB t (int indent) { for (int i = 0; i < indent; i++) { a ("\t"); } return this; }
	public SB t () { return t (1); }
	@Override public String toString () { return sb.toString (); }	
	
} // SB
