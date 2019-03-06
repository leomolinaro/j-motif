package com.motif.shared.flow.taskV2;

import com.motif.shared.endpoint.MotifContext;

public abstract class MotifAutoTaskV2<
	Ctx extends MotifContext,
	T extends MotifAutoTaskV2<Ctx, T, C>,
	C extends IMotifSubTaskV2<Ctx, T, C>
> {

	public abstract C start (Ctx context);

	@SuppressWarnings("unchecked")
	public C drive (MotifAutoTaskV2<Ctx, ?, ?> task, Ctx context) { return ((C) task).proceed (getThis (), context); }
	@SuppressWarnings("unchecked")
	public C drive (MotifHumanTaskV2<?, ?, ?> task, Ctx context) { return ((C) task).proceed (getThis (), context); }

	protected abstract T getThis ();

}
