package exercise.sentence;

import java.util.Map;

import exercise.GalacticValueToNumberConverter;
import exercise.Mineral;
import exercise.util.Messages;

public class UnknownQuestion extends Sentence implements Question {

	public UnknownQuestion(String text) {
		super(text);
	}

	@Override
	public SentenceType getType() {
		return SentenceType.QUESTION;
	}

	@Override
	public String getAnswer(GalacticValueToNumberConverter converter, Map<String, Mineral> mineralsMap) {
		return Messages.UNKNOWN_ANSWER_MESSAGE;
	}

	@Override
	public SentenceType getType() {
		return SentenceType.QUESTION;
	}

}
