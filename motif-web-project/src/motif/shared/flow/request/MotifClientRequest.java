package motif.shared.flow.request;

public abstract class MotifClientRequest<Res extends MotifClientResponse> {
	
	public abstract Res getAutoResponse ();
	
} // ClientRequest
