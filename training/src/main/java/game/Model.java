package game;

import java.util.LinkedHashMap;
import java.util.Map;
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
	private Map<Integer, String> previousResult = new LinkedHashMap<Integer, String>();
	
	/**
	 * The number that we have to guess.
	 */
	private int unknownNumber;
	
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
		return min + rnd.nextInt(max - min);
	}
	
	/**
	 * Overload int rand(int min, int max) method
	 * @return number which user will be guess
	 */
	public int rand(){
		return rand(GlobalConstant.RAND_MIN, GlobalConstant.RAND_MAX);
	}
	
	/**
	 * Make number that we need to guess call method rand(int min, int max)
	 */
	public void makeNumber(int min, int max){
		setMin(min);
		setMax(max);
		unknownNumber = rand(min, max);
	}
	
	/**
	 * Make number that we need to guess call method rand()
	 */
	public void makeNumber(){
		unknownNumber = rand();
	}
	
	/**
	 * Make number that we need to guess. This method fot tests.
	 */
	public void makeNumberTest(int unknownNumber){
		this.unknownNumber = unknownNumber;
	}
	
	/**
	 * Heart of this program. In this method we check if user guessed number.
	 * @param checkedNumber that user enter to check
	 * @param unknownNumber number which user need to guess
	 * @return if number that type user is less or bigger that number which he need to guess
	 * @throws OutOfRangeException throws if user enter number out of range
	 * @throws WinnerException throws if user enter right number
	 */
	public boolean checkNumber(int checkedNumber) throws OutOfRangeException,WinnerException{
		//in case if number not from range		
		if( checkedNumber < min || checkedNumber >= max) throw new OutOfRangeException(OUT_OF_RANGE + String.format(" [%-2d,%-3d) \n", min, max));
		
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
		previousResult.put(current, String.format("range from %-2d to %-3d", min, max));
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
	public Map<Integer, String> getPreviousResult() {
		return previousResult;
	}
	public void setPreviousResult(Map<Integer, String> previousResult) {
		this.previousResult = previousResult;
	}

}
