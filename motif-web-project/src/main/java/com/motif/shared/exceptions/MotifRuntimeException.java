package com.motif.shared.exceptions;

public abstract class MotifRuntimeException extends RuntimeException {

	private static final long serialVersionUID = -4091999058867877906L;

	public MotifRuntimeException () {
		super ();
	}

	public MotifRuntimeException (String arg0) {
		super (arg0);
	}
	
} // MotifRuntimeException
