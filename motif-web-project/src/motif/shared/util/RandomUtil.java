package motif.shared.util;

import java.util.ArrayList;

public class RandomUtil {

	public static int getInt (int max) { return getInt (0, max); }
	
	public static int getInt (int min, int max) { return min + (int)(Math.random () * ((max - min) + 1)); }

	public static <T> T getFrom (ArrayList<T> array) { return array.get (getInt (array.size () - 1)); }
	
} // RandomUtil
