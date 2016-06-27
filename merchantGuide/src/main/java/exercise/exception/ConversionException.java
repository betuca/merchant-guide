package exercise.exception;

public class ConversionException extends Exception {

	private static final long serialVersionUID = 4758364945982798340L;

	public ConversionException(String message) {
		super(message);
	}

	public ConversionException(String message, Throwable cause) {
		super(message, cause);
	}

}
