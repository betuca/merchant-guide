package exercise.sentence;

import java.text.MessageFormat;

import exercise.exception.UnknownSentenceFormatException;
import exercise.romanNumbers.RomanSymbol;
import exercise.util.Messages;

public class SentencesFactory {

	private static final String attributionPattern = "\\S+ is [" + RomanSymbol.getValuesAsString() + "]";
	private static final String mineralsTocreditsPattern = ".* is \\d+ Credits";

	public static Sentence createSentence(String line) throws UnknownSentenceFormatException {

		Sentence sentence = null;

		if (line.matches(attributionPattern)) {
			sentence = new AttributionSentence(line);
		} else if (line.matches(mineralsTocreditsPattern)) {
			sentence = new CreditsConversionSentence(line);
		} else if (line.endsWith("?")) {
			sentence = QuestionFactory.create(line);
		} else {
			throw new UnknownSentenceFormatException(MessageFormat.format(Messages.UNKNOWN_SENTENCE_EXCEPTION_MESSAGE, line));
		}

		return sentence;

	}

}
