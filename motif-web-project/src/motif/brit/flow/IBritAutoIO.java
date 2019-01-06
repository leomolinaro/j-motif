package motif.brit.flow;

public interface IBritAutoIO extends IBritIO {

	// public abstract IBritIO start(BritContext context);

	public abstract void accept(IBritAutoIOVisitor visitor);
	
}
