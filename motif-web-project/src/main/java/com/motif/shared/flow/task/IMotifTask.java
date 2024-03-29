package com.motif.shared.flow.task;

import com.motif.shared.endpoint.MotifContext;
import com.motif.shared.flow.request.MotifClientRequest;
import com.motif.shared.flow.request.MotifClientResponse;

public interface IMotifTask<Ctx extends MotifContext, Req extends MotifClientRequest<Res>, Res extends MotifClientResponse> {
	
	public void accept (IMotifTaskVisitor<Ctx, Req, Res> visitor);

} // ITask
