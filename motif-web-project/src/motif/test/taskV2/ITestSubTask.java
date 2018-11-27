package motif.test.taskV2;

import motif.shared.endpoint.MotifContext;
import motif.shared.flow.taskV2.IMotifSubTaskV2;

public interface ITestSubTask<
	P extends TestAutoTask<P, C>,
	C extends ITestSubTask<P, C>
> extends IMotifSubTaskV2<MotifContext, P, C> {

}
