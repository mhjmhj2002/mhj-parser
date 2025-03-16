package mhj.com.parser.exception;

public class ServerErrorException extends Exception {

	private static final long serialVersionUID = -1552529442161669308L;

	public ServerErrorException() {
	}

	public ServerErrorException(String message) {
		super(message);
	}

	public ServerErrorException(Throwable cause) {
		super(cause);
	}

	public ServerErrorException(String message, Throwable cause) {
		super(message, cause);
	}

	public ServerErrorException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
