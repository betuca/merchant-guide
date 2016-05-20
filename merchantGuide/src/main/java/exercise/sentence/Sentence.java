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

	public void setSentenceText(String text) {
		this.sentenceText = text;
	}

	@Override
	public String toString() {
		return sentenceText;
	}

	abstract public SentenceType getType();

}
