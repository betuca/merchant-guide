package exercise.sentence;

public abstract class Sentence {

	private String sentenceText;

	public Sentence() {
	}

	public Sentence(String text) {
		this.sentenceText = text;
	}

	public String getSentenceText() {
		return sentenceText;
	}

	@Override
	public String toString() {
		return sentenceText;
	}

	abstract public SentenceType getType();

}
