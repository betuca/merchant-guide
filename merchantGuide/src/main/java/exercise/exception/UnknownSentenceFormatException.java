package exercise.exception;

public class UnknownSentenceFormatException extends Exception {

	private static final long serialVersionUID = -7335146795664820091L;

	public UnknownSentenceFormatException(String message) {
		super(message);
	}

}
