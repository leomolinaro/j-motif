package motif.test.taskV2;

import motif.shared.endpoint.MotifContext;
import motif.shared.flow.IMotifSender;
import motif.shared.flow.TaskTriggerV2;
import motif.test.TestRequest;
import motif.test.TestResponse;

public class Main {

	public static TaskTriggerV2<MotifContext, TestRequest, TestResponse> trigger;
	
	public static IMotifSender<MotifContext, TestRequest> sender = new IMotifSender<MotifContext, TestRequest> () {

		@Override
		public void send (TestRequest request, MotifContext context) {
			trigger.receive (null, context);
		}
	};
	
	public static void main (String[] args) {
		trigger = new TaskTriggerV2<> (sender);
		A a = new A ();
		trigger.start (a, null);
	}
	
}
