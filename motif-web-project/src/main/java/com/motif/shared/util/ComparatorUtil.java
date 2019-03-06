package com.motif.shared.util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.stream.Stream;

public class ComparatorUtil {

	public static <T> ArrayList<T> getMax (Stream<T> elements, Comparator<T> comparator) {
		ArrayList<T> maxElements = new ArrayList<T> ();
		Iterator<T> it = elements.iterator ();
		if (it.hasNext ()) {
			T maxRepr = it.next ();
			maxElements.add (maxRepr);
			while (it.hasNext ()) {
				T e = it.next ();
				int comparison = comparator.compare (maxRepr, e);
				if (comparison < 0) {
					maxElements.clear ();
					maxRepr = e;
					maxElements.add (maxRepr);
				} else if (comparison == 0) {
					maxElements.add (e);
				} // if - else
			} // while
		} // if
		return maxElements;
	} // getMax
	
} // ComparatorUtil
