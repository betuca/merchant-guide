package exercise.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

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

	public static List<String> readFile(String fileFullPath) throws IOException {
		File inputFile = new File(fileFullPath);
		List<String> sentences = new ArrayList<>();
		try (Stream<String> lines = Files.lines(inputFile.toPath())) {
			lines.forEach(line -> sentences.add(line.trim()));
		}
		return sentences;
	}

	public static void writeFile(String filePath, List<String> lines) throws IOException {

		File file = new File(filePath);
		try (OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file))) {
			for (String line : lines) {
				outputStreamWriter.write(line);
			}
		}
	}

}
