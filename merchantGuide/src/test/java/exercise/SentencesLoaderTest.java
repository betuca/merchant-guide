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
	public void shouldThrowExceptionWithEmptyFile() throws LoaderException, RuleException {
		loader.loadResource(TestConstants.EMPTY_FILE);
	}

	@Test(expected = RuleException.class)
	public void shouldThrowExceptionWithFileMissingAttributions() throws LoaderException, RuleException {
		loader.loadResource(TestConstants.EXTRA_TEST_NO_ATTRIBUTIONS);
	}

	@Test(expected = RuleException.class)
	public void shouldThrowExceptionWithFileMissingConversions() throws LoaderException, RuleException {
		loader.loadResource(TestConstants.EXTRA_TEST_NO_CONVERSIONS);
	}

	@Test(expected = RuleException.class)
	public void shouldThrowExceptionWithFileMissingQuestions() throws LoaderException, RuleException {
		loader.loadResource(TestConstants.EXTRA_TEST_NO_QUESTIONS);
	}

	@Test
	public void shouldHaveFourAttributionsInSugestedTest() throws LoaderException, RuleException {
		loader.loadResource(TestConstants.SUGESTED_TEST_FILE);
		assertEquals(4, loader.getAttributions().size());
	}

	@Test
	public void shouldHaveSevenAttributionsInEstraTest1() throws LoaderException, RuleException {
		loader.loadResource(TestConstants.EXTRA_TEST);
		assertEquals(7, loader.getAttributions().size());
	}

	@Test
	public void shouldHaveThreeCreditsCoversionsInSugestedTest() throws LoaderException, RuleException {
		loader.loadResource(TestConstants.SUGESTED_TEST_FILE);
		assertEquals(3, loader.getCreditsConversions().size());
	}

	@Test
	public void shouldHaveFourCreditsCoversionsInExtraTest1() throws LoaderException, RuleException {
		loader.loadResource(TestConstants.EXTRA_TEST);
		assertEquals(4, loader.getCreditsConversions().size());
	}

	@Test
	public void shouldHaveFiveQuestionsInSugestedTest() throws LoaderException, RuleException {
		loader.loadResource(TestConstants.SUGESTED_TEST_FILE);
		assertEquals(5, loader.getQuestions().size());
	}

	@Test
	public void shouldHaveSevenQuestionsInExtraTest1() throws LoaderException, RuleException {
		loader.loadResource(TestConstants.EXTRA_TEST);
		assertEquals(7, loader.getQuestions().size());
	}

}
