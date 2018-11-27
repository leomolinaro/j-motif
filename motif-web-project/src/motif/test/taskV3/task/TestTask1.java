package motif.test.taskV3.task;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import motif.test.taskV3.ITestAutoIO;
import motif.test.taskV3.ITestIO;
import motif.test.taskV3.task.TestTask11.ATestTask11IO;

public class TestTask1 {

	public static abstract class ATestTask1IO implements ITestAutoIO {
		@Override public ITestIO start () { return new TestTask1 ().start (this); }
	} // ATestTask1IO
	
	@RequiredArgsConstructor
	private class TestTask11IO extends ATestTask11IO {
		@Override public ITestIO getNext () { return TestTask1.this.next (this); }
		@Getter private final ATestTask1IO parent;
	} // TestTask11IO
	
	public ITestIO start (ATestTask1IO IO) { return new TestTask11IO (IO); }
	
	public ITestIO next (TestTask11IO IO) { return null; }
	
} // TestTask1
