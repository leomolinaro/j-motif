package motif.test.taskV3.task;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import motif.test.taskV3.ITestAutoIO;
import motif.test.taskV3.ITestIO;
import motif.test.taskV3.task.TestTask1.ATestTask1IO;
import motif.test.taskV3.task.TestTask2.ATestTask2IO;
import motif.test.taskV3.task.TestTask3.ATestTask3IO;

public class TestTaskRoot {

	public static abstract class ATestTaskRootIO implements ITestAutoIO {
		@Override public ITestIO start () { return new TestTaskRoot ().start (this); }
	} // ATestTaskRootIO
	
	@RequiredArgsConstructor
	private class TestTask1IO extends ATestTask1IO {
		@Override public ITestIO getNext () { return TestTaskRoot.this.next (this); }
		@Getter private final ATestTaskRootIO parent;
	}
	
	@RequiredArgsConstructor
	private class TestTask2IO extends ATestTask2IO {
		@Getter private final ATestTaskRootIO parent;
		@Override public ITestIO getNext () { return TestTaskRoot.this.next (this); }
	}
	
	@RequiredArgsConstructor
	private class TestTask3IO extends ATestTask3IO {
		@Override public ITestIO getNext () { return TestTaskRoot.this.next (this); }
		@Getter private final ATestTaskRootIO parent;
	}
	
	public ITestIO start (ATestTaskRootIO io) { return new TestTask1IO (io); }
	
	public ITestIO next (TestTask1IO prevIO) { return new TestTask2IO (prevIO.getParent ()); }

	public ITestIO next (TestTask2IO prevIO) { return new TestTask3IO (prevIO.getParent ()); }
	
	public ITestIO next (TestTask3IO prevIO) { return null; }
	
}
