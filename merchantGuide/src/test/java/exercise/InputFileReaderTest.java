package exercise;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import exercise.util.InputFileReader;

public class InputFileReaderTest {

	private InputFileReader fileReader;

	public InputFileReaderTest() {
		this.fileReader = new InputFileReader();
	}

	@Test
	public void testReadEmptyFile() throws IOException {
		List<String> allLines = fileReader.readFromFilePath(TestConstants.EMPTY_FILE);
		assertEquals(0, allLines.size());
	}

	@Test
	public void testRead12LinesFromFile() throws IOException {
		List<String> allLines = fileReader.readFromFilePath(TestConstants.SUGESTED_TEST_FILE);
		assertEquals(12, allLines.size());
	}

	@Test
	public void testReadFirstLineFromFile() throws IOException {
		List<String> allLines = fileReader.readFromFilePath(TestConstants.SUGESTED_TEST_FILE);
		assertEquals("glob is I", allLines.get(0));
	}

	@Test
	public void testReadLastLineFromFile() throws IOException {
		List<String> allLines = fileReader.readFromFilePath(TestConstants.SUGESTED_TEST_FILE);
		assertEquals("how much wood could a woodchuck chuck if a woodchuck could chuck wood ?", allLines.get(11));
	}

	@Test
	public void testReadFifthLineFromFile() throws IOException {
		List<String> allLines = fileReader.readFromFilePath(TestConstants.SUGESTED_TEST_FILE);
		assertEquals("glob glob Silver is 34 Credits", allLines.get(4));
	}

}
