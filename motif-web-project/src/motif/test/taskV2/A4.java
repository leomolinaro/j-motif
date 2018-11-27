package motif.test.taskV2;

import motif.shared.endpoint.MotifContext;

public class A4 extends TestAutoTask<A4, ISubA4> implements ISubA {

	@Override public ISubA proceed (A father, MotifContext context) { return father.next (this); }
	
	@Override protected A4 getThis () { return this; }
	@Override public ISubA4 start (MotifContext context) { return null; }

}
