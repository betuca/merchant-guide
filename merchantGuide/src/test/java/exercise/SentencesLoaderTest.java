package exercise;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import exercise.exception.LoaderException;
import exercise.exception.RuleException;
import exercise.sentence.SentencesLoader;

public class SentencesLoaderTest {

	private SentencesLoader loader;

	public SentencesLoaderTest() {
		this.loader = new SentencesLoader();
	}

	@Test(expected = RuleException.class)
	public void testThrowExceptionWithEmptyFile() throws LoaderException, RuleException {
		loader.loadFile(TestConstants.EMPTY_FILE);
	}

	@Test(expected = RuleException.class)
	public void testThrowExceptionWithFileMissingAttributions() throws LoaderException, RuleException {
		loader.loadFile(TestConstants.EXTRA_TEST_NO_ATTRIBUTIONS);
	}

	@Test(expected = RuleException.class)
	public void testThrowExceptionWithFileMissingConversions() throws LoaderException, RuleException {
		loader.loadFile(TestConstants.EXTRA_TEST_NO_CONVERSIONS);
	}

	@Test(expected = RuleException.class)
	public void testThrowExceptionWithFileMissingQuestions() throws LoaderException, RuleException {
		loader.loadFile(TestConstants.EXTRA_TEST_NO_QUESTIONS);
	}

	@Test
	public void testLoadFourAttributionsInSugestedTest() throws LoaderException, RuleException {
		loader.loadFile(TestConstants.SUGESTED_TEST_FILE);
		assertEquals(4, loader.getAttributions().size());
	}

	@Test
	public void testLoadSevenAttributionsInExtraTest1() throws LoaderException, RuleException {
		loader.loadFile(TestConstants.EXTRA_TEST);
		assertEquals(7, loader.getAttributions().size());
	}

	@Test
	public void testLoadThreeCreditsCoversionsInSugestedTest() throws LoaderException, RuleException {
		loader.loadFile(TestConstants.SUGESTED_TEST_FILE);
		assertEquals(3, loader.getCreditsConversions().size());
	}

	@Test
	public void testLoadFourCreditsCoversionsInExtraTest1() throws LoaderException, RuleException {
		loader.loadFile(TestConstants.EXTRA_TEST);
		assertEquals(4, loader.getCreditsConversions().size());
	}

	@Test
	public void testLoadFiveQuestionsInSugestedTest() throws LoaderException, RuleException {
		loader.loadFile(TestConstants.SUGESTED_TEST_FILE);
		assertEquals(5, loader.getQuestions().size());
	}

	@Test
	public void testLoadSevenQuestionsInExtraTest1() throws LoaderException, RuleException {
		loader.loadFile(TestConstants.EXTRA_TEST);
		assertEquals(7, loader.getQuestions().size());
	}

}
