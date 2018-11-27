package motif.test.taskV2;

import motif.test.TestRequest;
import motif.test.TestResponse;

public abstract class A11 extends TestHumanTask {

	@Override public TestRequest getRequest () { return null; }
	@Override public void receiveResponse (TestResponse response) {}
	@Override public boolean validResponse (TestRequest request, TestResponse response) { return true; }

}
