package by.rdtc.library.dao.exception;

public class ConnectionPoolException extends Exception {

	private static final long serialVersionUID = 1L;

	public ConnectionPoolException() {
		super();
	}

	public ConnectionPoolException(String message, Exception e) {
		super(message, e);
	}

	public ConnectionPoolException(String message) {
		super(message);
	}

	public ConnectionPoolException(Exception e) {
		super(e);
	}
	
	
}
