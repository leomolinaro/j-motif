package motif.shared.flow.task;

import motif.shared.endpoint.MotifContext;
import motif.shared.flow.request.MotifClientRequest;
import motif.shared.flow.request.MotifClientResponse;

public abstract class MotifComplexTask<Ctx extends MotifContext, Req extends MotifClientRequest<Res>, Res extends MotifClientResponse> implements IMotifTask<Ctx, Req, Res> {

	@Override public void accept (IMotifTaskVisitor<Ctx, Req, Res> visitor) { visitor.visit (this); }

	public abstract IMotifTask<Ctx, Req, Res> getStart (Ctx context);

	public abstract IMotifTask<Ctx, Req, Res> getNextTask (Ctx context);
		
} // Flux
