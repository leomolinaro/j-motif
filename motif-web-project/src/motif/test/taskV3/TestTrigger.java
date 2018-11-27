package motif.test.taskV3;

public class TestTrigger {

	private TestSender sender;
	
	public TestTrigger (TestSender sender) {
		this.sender = sender;
	}

	private void request (ITestHumanIO IO) {
		System.out.println ("request " + IO.getClass ().getSimpleName ());
		TestRequest request = IO.getRequest ();
		this.pendingRequest = request;
		this.pendingIO = IO;
		sender.send (request);
	} // send
	
	private TestRequest pendingRequest;
	private ITestHumanIO pendingIO;
	
	public void receive (TestResponse response) {
		System.out.println ("receive");
		if (pendingRequest.validResponse (response)) {
			ITestHumanIO IO = this.pendingIO;
			IO.receive (response);
			this.pendingRequest = null;
			this.pendingIO = null;
			ITestIO nextIO = IO.getNext ();
			execute (nextIO, IO.getParent ());
		} else {
			sender.send (pendingRequest);
		} // if - else
	}
	
	public void start (ITestAutoIO IO) {
		System.out.println ("start " + IO.getClass ().getSimpleName ());
		ITestIO subContext = IO.start ();
		execute (subContext, IO);
	} // start

	public void end (ITestAutoIO IO) {
		System.out.println ("end " + IO.getClass ().getSimpleName ());
		ITestIO nextIO = IO.getNext ();
		ITestAutoIO parentIO = IO.getParent ();
		execute (nextIO, parentIO);
	} // end
	
	private void execute (ITestIO IO, ITestAutoIO parentIO) {
		if (IO == null) {
			if (parentIO != null) {
				end (parentIO);
			} // if
		} else {
			if (IO instanceof ITestAutoIO) {
				start ((ITestAutoIO) IO);
			} else {
				request ((ITestHumanIO) IO);
			} // if - else
		} // if - else
	} // execute
	
} // TaskTrigger
