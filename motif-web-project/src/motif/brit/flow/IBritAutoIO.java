package motif.brit.flow;

import motif.brit.endpoint.BritContext;

public interface IBritAutoIO extends IBritIO {

	public abstract IBritIO start(BritContext context);

	// public abstract void accept(IBritAutoIOVisitor visitor);
	
}
