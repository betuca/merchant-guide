package exercise.util;

import java.util.Locale;

public class Util {

	public static final double EPSILON = 0.0001;

	public static String formatDoulbe(double d) {
		String formmated = "";
		if (compareDouble(d, (long) d)) {
			formmated = String.format("%d", (long) d);
		} else {
			formmated = String.format("%s", d);
		}
		return formmated;
	}

	private static boolean compareDouble(double d, long l) {
		return Math.abs(d - l) < EPSILON;
	}

	public static String capitalizeFirstLetter(String name) {
		return name.substring(0, 1).toUpperCase(Locale.getDefault()) + name.substring(1);
	}

}
