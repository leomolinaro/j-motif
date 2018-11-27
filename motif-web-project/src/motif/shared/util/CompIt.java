package motif.shared.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class CompIt<T> implements Iterable<T> {
	
	private ArrayList<Iterator<? extends T>> iterators = new ArrayList<Iterator<? extends T>> ();
	private ArrayList<FilterIt<? super T>> filters = null;
	
	public CompIt<T> concat (Iterable<? extends T> iterable) { concat (iterable.iterator ()); return this; }
	public CompIt<T> concat (Iterator<? extends T> iterator) { iterators.add (iterator); return this; }
	public CompIt<T> concat (T element) {
		if (element != null) {
			concat (new Iterator<T> () {
				boolean hasNext = true;
				@Override public boolean hasNext () { return hasNext; }
				@Override public T next () { hasNext = false; return element; }
			}); // concat			
		} // if
		return this;
	} // concat
	
	public CompIt<T> filter (FilterIt<? super T> filter) {
		if (filters == null) { filters = new ArrayList<FilterIt<? super T>> (); }
		filters.add (filter);
		return this;
	} // filter
	
	private Iterator<T> fullIterator () {
		Iterator<Iterator<? extends T>> itIt = iterators.iterator ();
		if (itIt.hasNext ()) {
			return new Iterator<T> () {
				
				private Iterator<? extends T> currIt = itIt.next ();
				
				@Override
				public boolean hasNext () {
					if (currIt.hasNext ()) {
						return true;
					} else if (itIt.hasNext ()) {
						currIt = itIt.next ();
						return hasNext ();
					} else {
						return false;
					} // if - else						
				} // hasNext
				
				@Override
				public T next () {
					if (currIt.hasNext ()) {
						return currIt.next ();
					} else {
						currIt = itIt.next ();
						return next ();
					} // if - else
				} // next
				
			}; // Iterator
		} else {
			return Collections.emptyIterator ();
		} // if - else
	} // fullIterator
	
	private Iterator<T> filteredIterator () {
		Iterator<T> fullIt = fullIterator ();
		if (fullIt.hasNext ()) {
			T firstEl = null;
			while (firstEl == null && fullIt.hasNext ()) {
				T el = fullIt.next ();
				if (checkFilters (el)) { firstEl = el; }
			} // while
			if (firstEl != null) {
				T first = firstEl;
				return new Iterator<T> () {
					
					private T next = first;
					private boolean hasNext = true;
					
					@Override
					public boolean hasNext () {
						return hasNext;						
					} // hasNext
					
					@Override
					public T next () {
						T curr = next;
						next = null;
						while (next == null && fullIt.hasNext ()) {
							T el = fullIt.next ();
							if (checkFilters (el)) { next = el; }
						} // while
						if (next == null) { hasNext = false; }
						return curr;
					} // next
					
				}; // Iterator
			} // if
		} // if
		return Collections.emptyIterator ();
	} // filteredIterator
	
	@Override public Iterator<T> iterator () {
		if (filters == null) {
			return fullIterator ();
		} else {
			return filteredIterator ();
		} // if - else
	} // iterator
	
	private boolean checkFilters (T element) {
		if (filters != null) {
			for (FilterIt<? super T> filter : filters) {
				if (!filter.filter (element)) { return false; }
			} // for
		} // if
		return true;
	} // checkFilters
	
	public interface FilterIt<T> {
		public boolean filter (T element);
	} // FilterIt
	
} // IterableBuilder
