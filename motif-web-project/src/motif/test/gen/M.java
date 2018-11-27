package motif.test.gen;

import java.util.ArrayList;
import java.util.List;

public class M {

	public static void main (String[] args) {
		List<M> mList = new ArrayList<M> ();
		aaaa (mList);

	}
	
	public static <T extends M> List<T> aaaa (List<T> list) {
		return list;
	}

}
