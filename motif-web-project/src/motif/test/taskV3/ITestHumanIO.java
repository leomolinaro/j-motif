package motif.test.taskV3;

public interface ITestHumanIO extends ITestIO {

	public TestRequest getRequest ();

	public void receive (TestResponse response);

}
