package exercise.exception;

public class ConvertionException extends Exception {

	private static final long serialVersionUID = 4758364945982798340L;

	public ConvertionException(String message) {
		super(message);
	}

	public ConvertionException(String message, Throwable cause) {
		super(message, cause);
	}

}
