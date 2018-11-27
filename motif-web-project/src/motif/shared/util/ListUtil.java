package motif.shared.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ListUtil {

	public static <T> T getRandom (List<T> list) {
		int i = (int) (Math.random () * list.size ());
		return list.get (i);
	} // getRandom
	
	public static <T> ArrayList<T> getCopy (Stream<T> stream) {
		ArrayList<T> toReturn = new ArrayList<T> ();
		stream.forEach (t -> toReturn.add (t));
		return toReturn;
	} // getCopy
	
} // ListUtil
