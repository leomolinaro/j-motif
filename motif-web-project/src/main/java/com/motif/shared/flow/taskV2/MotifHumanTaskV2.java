package com.motif.shared.flow.taskV2;

import com.motif.shared.endpoint.MotifContext;
import com.motif.shared.flow.request.MotifClientRequest;
import com.motif.shared.flow.request.MotifClientResponse;

public abstract class MotifHumanTaskV2<
	Ctx extends MotifContext,
	Req extends MotifClientRequest<Res>,
	Res extends MotifClientResponse
> {

	public abstract Req getRequest ();

	public abstract void receiveResponse (Res response);

	public abstract boolean validResponse (Req request, Res response);

} // MotifHumanTaskV2
