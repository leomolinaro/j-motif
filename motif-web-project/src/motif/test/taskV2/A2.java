package motif.test.taskV2;

import motif.shared.endpoint.MotifContext;
import motif.test.TestRequest;
import motif.test.TestResponse;

public class A2 extends TestHumanTask implements ISubA {

	@Override public ISubA proceed (A father, MotifContext context) { return father.next (this); }

	@Override public TestRequest getRequest () { return null; }
	@Override public void receiveResponse (TestResponse response) {}
	@Override public boolean validResponse (TestRequest request, TestResponse response) { return true; }

}
