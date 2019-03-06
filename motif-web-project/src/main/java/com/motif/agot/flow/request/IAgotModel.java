package com.motif.agot.flow.request;

public interface IAgotModel {
	
	public String getLabel ();
	
	public void accept (IAgotModelVisitor visitor);
	
} // IAgotModel
