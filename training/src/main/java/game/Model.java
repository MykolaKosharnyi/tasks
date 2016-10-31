package game;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Random;

public class Model {

	/**
	 * Constant. Warning if out of range.
	 */
	public static final String OUT_OF_RANGE = "Wrong! Out of range!";
	
	/**
	 * minimum value in current range
	 */
	private int min = GlobalConstant.RAND_MIN;
	
	/**
	 * maximum value in current range
	 */
	private int max = GlobalConstant.RAND_MAX;

	/**
	 * previous result of user
	 */
	private HashMap<Integer, String> previousResult = new LinkedHashMap<Integer, String>();
	
	/**
	 * Method generate number which user will be guess
	 * 
	 * @param min and max - parameters from which we will create number
	 * 
	 * @return number which user will be guess
	 * 
	 * */
	public int rand(int min, int max){
		// Initialize the generator
		Random rnd = new Random(System.currentTimeMillis());
		// We obtain a random number from min to max (inclusive)
		return min + rnd.nextInt(max - min + 1);
	}
	
	/**
	 * Overload int rand(int min, int max) method
	 * @return number which user will be guess
	 */
	public int rand(){
		return rand(GlobalConstant.RAND_MIN, GlobalConstant.RAND_MAX);
	}
	
	/**
	 * Heart of this program. In this method we check if user guessed number.
	 * @param checkedNumber that user enter to check
	 * @param unknownNumber number which user need to guess
	 * @return if number that type user is less or bigger that number which he need to guess
	 * @throws OutOfRangeException throws if user enter number out of range
	 * @throws WinnerException throws if user enter right number
	 */
	public boolean checkNumber(int checkedNumber, int unknownNumber) throws OutOfRangeException,WinnerException{
		//in case if number not from range
		if( checkedNumber < min || checkedNumber > max) throw new OutOfRangeException(OUT_OF_RANGE + " [" + min + "," + max + "] \n");
		
			//save previous entered result
			addNewResult(checkedNumber);
			
			//check if last entered number corresponds number in range
			if(checkedNumber < unknownNumber){			
				min = checkedNumber;
				return false;
			} else if(checkedNumber > unknownNumber){
				max = checkedNumber;
				return true;
			} else {
				throw new WinnerException();//Congratulation for user!
			}
		
	}
	
	/**
	 * Save result of entered numbers
	 * @param current - number which user entered
	 */
	private void addNewResult(int current){
		previousResult.put(current, "range from " + min + " to " + max);
	}
	
	// getters and setters
	
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public HashMap<Integer, String> getPreviousResult() {
		return previousResult;
	}
	public void setPreviousResult(HashMap<Integer, String> previousResult) {
		this.previousResult = previousResult;
	}

}
