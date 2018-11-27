package motif.test.taskV2;

import motif.shared.endpoint.MotifContext;

public class A11a extends A11 implements ISubA1 {

	@Override public ISubA1 proceed (A1 father, MotifContext context) { return father.next (this); }

}
