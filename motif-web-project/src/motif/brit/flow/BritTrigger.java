package motif.brit.flow;

import lombok.Getter;
import motif.brit.endpoint.BritContext;
import motif.brit.endpoint.IBritSender;

public class BritTrigger {

	private IBritSender sender;
	
	public BritTrigger(IBritSender sender) {
		this.sender = sender;
	}

	@Getter private BritRequest<?> pendingRequest;
	private IBritHumanIO pendingIO;
	public boolean hasPendingRequest () { return pendingRequest != null; }
	
	private void request(IBritHumanIO IO, BritContext context) {
		BritRequest<?> request = IO.request(context);
		this.pendingRequest = request;
		this.pendingIO = IO;
		sender.send(request, context);
	}
	
	public void receive(BritResponse response, BritContext context) {
		if (pendingRequest.isValidResponse(response)) {
			IBritHumanIO IO = this.pendingIO;
			IO.response(response, context);
			this.pendingRequest = null;
			this.pendingIO = null;
			IBritIO nextIO = BritIONexter.next(IO, context);
			execute(nextIO, IO.getParent(), context);
		} else {
			sender.send(pendingRequest, context);
		}
	}
	
	public void start(IBritAutoIO IO, BritContext context) {
		IBritIO subIO = BritAutoIOStarter.start(IO, context);
		execute(subIO, IO, context);
	}

	private void end(IBritAutoIO IO, BritContext context) {
		IBritIO nextIO = BritIONexter.next(IO, context);
		IBritAutoIO parentIO = IO.getParent ();
		if (parentIO != null) {
			execute (nextIO, parentIO, context);
		} // if
	} // end
	
	private void execute(IBritIO IO, IBritAutoIO parentIO, BritContext context) {
		if (IO == null) {
			end(parentIO, context);
		} else {
			if (IO instanceof IBritAutoIO) {
				start ((IBritAutoIO) IO, context);
			} else {
				request ((IBritHumanIO) IO, context);
			} // if - else
		} // if - else
	} // execute

} // BritTrigger
