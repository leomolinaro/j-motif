package com.motif.shared.util;

import java.util.LinkedList;

public class ModelPile<T> extends LinkedList<T> {

	private static final long serialVersionUID = 6840375733914455201L;

	public void putTop (T e) { addLast (e); }
	public void removeTop () { removeLast (); }
	public boolean hasElements () { return !isEmpty (); }

} // ModelPile
