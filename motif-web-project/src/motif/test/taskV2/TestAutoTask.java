package motif.test.taskV2;

import motif.shared.endpoint.MotifContext;
import motif.shared.flow.taskV2.MotifAutoTaskV2;

public abstract class TestAutoTask<
	T extends TestAutoTask<T, C>,
	C extends ITestSubTask<T, C>>
extends MotifAutoTaskV2<MotifContext, T, C> {

}
