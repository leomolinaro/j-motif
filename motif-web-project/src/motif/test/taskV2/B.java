package motif.test.taskV2;

public abstract class B<
	T extends B<T, C>,
	C extends ISubB<T, C>
> extends TestAutoTask<T, C> implements ISubA {

}
