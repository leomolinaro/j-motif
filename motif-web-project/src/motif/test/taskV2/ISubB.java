package motif.test.taskV2;

public interface ISubB<P extends B<P, C>, C extends ISubB<P, C>> extends ITestSubTask<P, C> {

}
