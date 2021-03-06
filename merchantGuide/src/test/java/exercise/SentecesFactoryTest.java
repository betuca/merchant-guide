package exercise;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import exercise.exception.UnknownSentenceFormatException;
import exercise.sentence.AttributionSentence;
import exercise.sentence.CreditsConversionSentence;
import exercise.sentence.MineralToMineralQuestion;
import exercise.sentence.Question;
import exercise.sentence.SentencesFactory;

public class SentecesFactoryTest {

	@Test
	public void testCreateAttributionSentences() throws UnknownSentenceFormatException {
		assertThat(SentencesFactory.createSentence("pish is X"), instanceOf(AttributionSentence.class));
	}

	@Test(expected = UnknownSentenceFormatException.class)
	public void testThrowExceptionToAttributionWrongSymbol() throws UnknownSentenceFormatException {
		SentencesFactory.createSentence("pish is P");
	}

	@Test(expected = UnknownSentenceFormatException.class)
	public void testThrowExceptionToAttributionWrongSymbolYYY() throws UnknownSentenceFormatException {
		SentencesFactory.createSentence("pish is YYY");
	}

	@Test(expected = UnknownSentenceFormatException.class)
	public void testThrowExceptionToAttributionWrongSymbolYYY111() throws UnknownSentenceFormatException {
		SentencesFactory.createSentence("pish is YYY111");
	}

	@Test
	public void testCreateCreditsConversionSentences() throws UnknownSentenceFormatException {
		assertThat(SentencesFactory.createSentence("glob glob Silver is 34 Credits"), instanceOf(CreditsConversionSentence.class));
	}

	@Test(expected = UnknownSentenceFormatException.class)
	public void testThrowExceptionToMalformedCreditsConversion() throws UnknownSentenceFormatException {
		SentencesFactory.createSentence("glob glob Silver is XXXX Credits");
	}

	@Test
	public void testCreateQuestionSentences() throws UnknownSentenceFormatException {
		assertThat(SentencesFactory.createSentence("how many Credits is glob prok Silver ?"), instanceOf(Question.class));
	}

	@Test
	public void testIdentifyStrangeQuestionsAsQuestions() throws UnknownSentenceFormatException {
		assertThat(SentencesFactory.createSentence("how much wood could a woodchuck chuck if a woodchuck could chuck wood ?"),
				instanceOf(Question.class));
	}

	@Test
	public void testIdentifyMineralToMineralQuestions() throws UnknownSentenceFormatException {
		assertThat(SentencesFactory.createSentence("how much Iron is in Gold ?"), instanceOf(MineralToMineralQuestion.class));

	}

}
