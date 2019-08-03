package com.motif.shared.util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Stream;

public class ComparatorUtil {

	public static <T> ArrayList<T> getMax (Stream<T> elements, Comparator<T> comparator) {
		var maxElements = new ArrayList<T> ();
		var it = elements.iterator ();
		if (it.hasNext ()) {
			var maxRepr = it.next ();
			maxElements.add (maxRepr);
			while (it.hasNext ()) {
				var e = it.next ();
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
