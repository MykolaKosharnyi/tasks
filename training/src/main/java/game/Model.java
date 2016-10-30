package game;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Random;

public class Model {
	//min and max defaul value in rand
	public static final int RAND_MIN = 0;
	public static final int RAND_MAX = 100;
	public static final String OUT_OF_RANGE = "Wrong! Out of range!";
	
	//new value of range
	private int min = RAND_MIN;
	private int max = RAND_MAX;
	
	//previous result of user
	private HashMap<Integer, String> previousResult = new LinkedHashMap<Integer, String>();
	
	/**
	 * method generate number which user will be guess
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
	 * overload int rand(int min, int max) method
	 * */
	public int rand(){
		return rand(RAND_MIN, RAND_MAX);
	}
	
	/**
	 * heart of this program. In this method we check if user guessed number.
	 * */
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
	 * save result of entered numbers
	 * */
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
