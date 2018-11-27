package motif.test.taskV3.task;

import motif.test.taskV3.ITestAutoIO;
import motif.test.taskV3.ITestIO;

public class TestTask3 {

	public static abstract class ATestTask3IO implements ITestAutoIO {
		@Override public ITestIO start () { return new TestTask3 ().start (this); }
	} // ATestTask1IO
	
	public ITestIO start (ATestTask3IO IO) { return null; }
	
} // TestTask3
