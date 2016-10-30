package game;

public class OutOfRangeException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8704942786551382327L;

	public OutOfRangeException(String message) {
        super(message);
    }
	
	public OutOfRangeException() {
    }
}
