package exercise.sentence;

import java.text.MessageFormat;

import exercise.exception.UnknownSentenceFormatException;
import exercise.romanNumbers.RomanSymbol;
import exercise.util.Messages;

public class SentenceIdentifier {

	String allRomanSymbolsAsString;

	public SentenceIdentifier() {

		this.allRomanSymbolsAsString = "";
		for (RomanSymbol symbol : RomanSymbol.values()) {
			this.allRomanSymbolsAsString += symbol;

		}
	}

	public SentenceType identify(String line) throws UnknownSentenceFormatException {

		SentenceType sentenceType = null;

		final String attributionPattern = "\\S+ is [" + this.allRomanSymbolsAsString + "]";
		final String mineralsTocreditsPattern = ".* is \\d+ Credits";

		if (line.matches(attributionPattern)) {
			sentenceType = SentenceType.ATTRIBUTION;
		} else if (line.matches(mineralsTocreditsPattern)) {
			sentenceType = SentenceType.CREDITS_CONVERSION;
		} else if (line.endsWith("?")) {
			sentenceType = SentenceType.QUESTION;
		} else {
			throw new UnknownSentenceFormatException(MessageFormat.format(Messages.UNKNOWN_SENTENCE_EXCEPTION_MESSAGE, line));
		}

		return sentenceType;
	}

}
