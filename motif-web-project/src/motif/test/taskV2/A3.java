package motif.test.taskV2;

import motif.shared.endpoint.MotifContext;

public class A3 extends B<A3, ISubA3> implements ISubA {

	@Override public ISubA proceed (A father, MotifContext context) { return father.next (this); }
	@Override protected A3 getThis () { return this; }
	@Override public ISubA3 start (MotifContext context) { return null; }

}
