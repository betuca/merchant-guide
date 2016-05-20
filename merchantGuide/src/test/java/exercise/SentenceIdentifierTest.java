package exercise;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import exercise.exception.UnknownSentenceFormatException;
import exercise.sentence.SentenceIdentifier;
import exercise.sentence.SentenceType;

public class SentenceIdentifierTest {

	private SentenceIdentifier identifier;

	public SentenceIdentifierTest() {
		this.identifier = new SentenceIdentifier();
	}

	@Test
	public void shouldIdentifyAttribution() throws UnknownSentenceFormatException {
		assertEquals(SentenceType.ATTRIBUTION, identifier.identify("pish is X"));
	}

	@Test(expected = UnknownSentenceFormatException.class)
	public void shouldThrowExceptionToAttributionWrongSymbol() throws UnknownSentenceFormatException {
		identifier.identify("pish is P");
	}

	@Test
	public void shouldIdentifyCreditsConversion() throws UnknownSentenceFormatException {
		assertEquals(SentenceType.CREDITS_CONVERSION, identifier.identify("glob glob Silver is 34 Credits"));
	}

	@Test
	public void shouldThrowExceptionToMalformedCreditsConversion() throws UnknownSentenceFormatException {

		boolean threwException = false;
		try {
			identifier.identify("glob glob Silver is XXXX Credits");
		} catch (UnknownSentenceFormatException e) {
			threwException = true;
		}
		assertEquals(true, threwException);
	}

	@Test
	public void shouldIdentifyQuestions() throws UnknownSentenceFormatException {
		assertEquals(SentenceType.QUESTION, identifier.identify("how many Credits is glob prok Silver ?"));
	}

	@Test
	public void shouldIdentifyStrangeQuestionsAsQuestions() throws UnknownSentenceFormatException {
		assertEquals(SentenceType.QUESTION,
				identifier.identify("how much wood could a woodchuck chuck if a woodchuck could chuck wood ?"));
	}

}
