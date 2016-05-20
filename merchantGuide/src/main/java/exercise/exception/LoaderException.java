package exercise.exception;

public class LoaderException extends Exception {
	private static final long serialVersionUID = 5474111902750762730L;

	public LoaderException(String message, Throwable cause) {
		super(message, cause);
	}

	public LoaderException(String message) {
		super(message);
	}

}
