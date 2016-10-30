package game;

public class OutOfRangeException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8063487519754894637L;

	public OutOfRangeException(String message) {
        super(message);
    }
	
	public OutOfRangeException() {
    }
}
