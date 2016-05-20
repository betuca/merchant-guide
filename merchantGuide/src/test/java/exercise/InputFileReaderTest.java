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
	public void shouldReadEmptyFile() throws IOException {
		List<String> allLines = fileReader.readFromResource(TestConstants.EMPTY_FILE);
		assertEquals(0, allLines.size());
		assertEquals(0, allLines.size());
	}

	@Test
	public void shouldRead12LinesFromResource() throws IOException {
		List<String> allLines = fileReader.readFromResource(TestConstants.SUGESTED_TEST_FILE);
		assertEquals(12, allLines.size());
	}

	@Test
	public void shouldReadFirstLineFromResourceAppropriatly() throws IOException {
		List<String> allLines = fileReader.readFromResource(TestConstants.SUGESTED_TEST_FILE);
		assertEquals("glob is I", allLines.get(0));
	}

	@Test
	public void shouldReadLastLineFromResourceAppropriatly() throws IOException {
		List<String> allLines = fileReader.readFromResource(TestConstants.SUGESTED_TEST_FILE);
		assertEquals("how much wood could a woodchuck chuck if a woodchuck could chuck wood ?", allLines.get(11));
	}

	@Test
	public void shouldReadFifthLineFromResourceAppropriatly() throws IOException {
		List<String> allLines = fileReader.readFromResource(TestConstants.SUGESTED_TEST_FILE);
		assertEquals("glob glob Silver is 34 Credits", allLines.get(4));
	}

}
