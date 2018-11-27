package motif.shared.flow;

import motif.shared.endpoint.MotifContext;
import motif.shared.flow.request.MotifClientRequest;

public interface IMotifSender<
	Ctx extends MotifContext,
	Req extends MotifClientRequest<?>
> {

	public void send (Req request, Ctx context);
	
} // IMotifSender
