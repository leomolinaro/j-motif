package motif.brit.flow;

public interface IBritIO {

	public IBritAutoIO getParent();
	
	// public IBritIO getNext(BritContext context);
	
	public abstract void accept(IBritIOVisitor visitor);
	
}
