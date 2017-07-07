package by.rdtc.library.service.exception;

public class ServiceInvalidParamException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public ServiceInvalidParamException() {
		super();
	}

	public ServiceInvalidParamException(String message, Exception e) {
		super(message, e);
	}

	public ServiceInvalidParamException(String message) {
		super(message);
	}

	public ServiceInvalidParamException(Exception e) {
		super(e);
	}

}
