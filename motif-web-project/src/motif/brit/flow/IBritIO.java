package motif.brit.flow;

import motif.brit.endpoint.BritContext;

public interface IBritIO {

	public IBritAutoIO getParent ();
	
	public IBritIO getNext (BritContext context);
	
} // IBritIO
