package game;

public class WinnerException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8704942786551382327L;

	public WinnerException(String message) {
        super(message);
    }
	
	public WinnerException() {
    }
}
