package motif.test.taskV2;

import motif.shared.endpoint.MotifContext;

public class A1 extends B<A1, ISubA1> implements ISubA {

	@Override public ISubA proceed (A father, MotifContext context) { return father.next (this); }

	@Override protected A1 getThis () { return this; }
	@Override public ISubA1 start (MotifContext context) { return new A11a (); }
	public ISubA1 next (A11 a11) { return null; }

}
