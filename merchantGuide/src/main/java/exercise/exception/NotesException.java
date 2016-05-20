package exercise.exception;

public class NotesException extends Exception {

	private static final long serialVersionUID = 295655702121867934L;

	public NotesException(String message, Throwable cause) {
		super(message, cause);
	}

	public NotesException(String message) {
		super(message);
	}

}
