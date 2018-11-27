package motif.test.taskV2;

import motif.shared.endpoint.MotifContext;

public class A11b extends A11 implements ISubA {

	@Override public ISubA proceed (A father, MotifContext context) { return father.next (this); }
	
}
