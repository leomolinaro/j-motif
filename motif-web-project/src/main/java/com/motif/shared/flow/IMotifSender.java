package com.motif.shared.flow;

import com.motif.shared.endpoint.MotifContext;
import com.motif.shared.flow.request.MotifClientRequest;

public interface IMotifSender<
	Ctx extends MotifContext,
	Req extends MotifClientRequest<?>
> {

	public void send (Req request, Ctx context);
	
} // IMotifSender
