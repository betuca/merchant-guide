package exercise.sentence;

import java.util.List;

public class UnknownQuestion extends Sentence implements Question {

	public UnknownQuestion(String text) {
		super(text);
	}

	@Override
	public String getMetalName() {
		return null;
	}

	@Override
	public List<String> getGalacticValues() {
		return null;
	}

	@Override
	public String getGalactitcValueText() {
		return null;
	}

	@Override
	public SentenceType getType() {
		return SentenceType.QUESTION;
	}

}
