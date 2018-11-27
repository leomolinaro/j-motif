package motif.test.taskV3.task;

import motif.test.taskV3.ITestAutoIO;
import motif.test.taskV3.ITestIO;

public class TestTask11 {

	public static abstract class ATestTask11IO implements ITestAutoIO {
		@Override public ITestIO start () { return new TestTask11 ().start (this); }
	} // ATestTask11IO
	
	public ITestIO start (ATestTask11IO IO) { return null; }
	
} // TestTask11
