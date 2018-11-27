package motif.shared.flow.task;

import motif.shared.endpoint.MotifContext;
import motif.shared.flow.request.MotifClientRequest;
import motif.shared.flow.request.MotifClientResponse;

public abstract class MotifHumanTask<Ctx extends MotifContext, Req extends MotifClientRequest<Res>, Res extends MotifClientResponse> implements IMotifTask<Ctx, Req, Res> {

	public abstract Req getRequest (Ctx context);
	
	public abstract IMotifTask<Ctx, Req, Res> receiveResponse (Res response, Ctx context);
	
	public abstract boolean validResponse (Req request, Res response);
	
	@Override public void accept (IMotifTaskVisitor<Ctx, Req, Res> visitor) { visitor.visit (this); }
		
} // HumanTask
