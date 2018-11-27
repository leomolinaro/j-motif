package motif.test.taskV3.task;

import motif.test.taskV3.ITestHumanIO;
import motif.test.taskV3.TestRequest;
import motif.test.taskV3.TestResponse;

public class TestTask2 {

	public static abstract class ATestTask2IO implements ITestHumanIO {
		@Override public TestRequest getRequest () { return new TestTask2 ().request (this); }
		@Override public void receive (TestResponse response) { new TestTask2 ().response (this, response); }
	} // ATestTask2IO
	
	public TestRequest request (ATestTask2IO context) { return new TestRequest (); }

	public void response (ATestTask2IO IO, TestResponse response) {}

} // TestTask2
