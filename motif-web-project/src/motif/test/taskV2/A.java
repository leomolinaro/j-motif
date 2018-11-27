package motif.test.taskV2;

import motif.shared.endpoint.MotifContext;

public class A extends TestAutoTask<A, ISubA> {

	@Override protected A getThis () { return this; }
	@Override public ISubA start (MotifContext context) { return new A1 (); }
	public ISubA next (A1 a1) { return new A2 (); }
	public ISubA next (A2 a2) { return new A11b (); }
	public ISubA next (A11 a1) { return new A3 (); }
	public ISubA next (A3 a3) { return new A4 (); }
	public ISubA next (A4 a4) { return null; }

}
