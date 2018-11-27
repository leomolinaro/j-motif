package motif.shared.flow.task;

import motif.shared.endpoint.MotifContext;
import motif.shared.flow.request.MotifClientRequest;
import motif.shared.flow.request.MotifClientResponse;

public interface IMotifTask<Ctx extends MotifContext, Req extends MotifClientRequest<Res>, Res extends MotifClientResponse> {
	
	public void accept (IMotifTaskVisitor<Ctx, Req, Res> visitor);

} // ITask
