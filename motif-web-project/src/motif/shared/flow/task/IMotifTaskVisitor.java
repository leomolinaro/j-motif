package motif.shared.flow.task;

import motif.shared.endpoint.MotifContext;
import motif.shared.flow.request.MotifClientRequest;
import motif.shared.flow.request.MotifClientResponse;

public interface IMotifTaskVisitor<Ctx extends MotifContext, Req extends MotifClientRequest<Res>, Res extends MotifClientResponse> {
	
	public void visit (MotifAutoTask<Ctx, Req, Res> task);
	public void visit (MotifHumanTask<Ctx, Req, Res> task);
	public void visit (MotifComplexTask<Ctx, Req, Res> task);

} // ITaskVisitor
