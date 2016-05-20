package exercise.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class InputFileReader {

	public List<String> readFromFilePath(String fileFullPath) throws IOException {

		File inputFile = new File(fileFullPath);
		return readFile(inputFile);
	}

	private List<String> readFile(File inputFile) throws IOException {
		List<String> sentences = new ArrayList<>();
		try (Stream<String> lines = Files.lines(inputFile.toPath())) {
			lines.forEach(line -> sentences.add(line.trim()));
		}
		return sentences;
	}

}
