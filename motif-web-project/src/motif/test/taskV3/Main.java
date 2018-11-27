package motif.test.taskV3;

import motif.test.taskV3.task.TestTaskRoot.ATestTaskRootIO;

public class Main {

	private static class TestTaskRoot extends ATestTaskRootIO {
		@Override public ITestIO getNext () { return null; }
		@Override public ITestAutoIO getParent () { return null; }
	} // TestTaskRoot

	public static TestTrigger trigger;
	
	public static TestSender sender = new TestSender () {

		@Override
		public void send (TestRequest request) {
			trigger.receive (null);
		}
		
	};
	
	public static void main (String[] args) {
		
		trigger = new TestTrigger (sender);
		
		trigger.start (new TestTaskRoot ());

	}

}
