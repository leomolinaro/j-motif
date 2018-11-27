package motif.shared.flow.taskV2;

import motif.shared.endpoint.MotifContext;

public interface IMotifSubTaskV2<
	Ctx extends MotifContext,
	P extends MotifAutoTaskV2<Ctx, P, C>,
	C extends IMotifSubTaskV2<Ctx, P, C>
> {
	
	public C proceed (P father, Ctx context);
	
}
