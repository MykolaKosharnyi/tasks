package game;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Random;

public class Model {
	//min and max defaul value in rand
	public static final int RAND_MIN = 0;
	public static final int RAND_MAX = 100;
	public static final String OUT_OF_RANGE = "Wrong! Out of range!";
	public final String CONGRATULATION = "Congratulation! ";
	
	private int min = RAND_MIN;
	private int max = RAND_MAX;
	
	private HashMap<Integer, String> previousResult = new LinkedHashMap<Integer, String>();
	
	public int rand(int min, int max) throws Exception{
		return generateNumber(min, max);
	}
	
	public int rand(){
		return generateNumber(RAND_MIN, RAND_MAX);
	}

	private int generateNumber(int min, int max) {
		// Initialize the generator
		Random rnd = new Random(System.currentTimeMillis());
		// We obtain a random number from min to max (inclusive)
		return min + rnd.nextInt(max - min + 1);
	}
	
	public boolean checkNumber(int checkedNumber, int unknownNumber) throws WinnerException, OutOfRangeException{
		if( checkedNumber < min && checkedNumber > max){ 
			throw new OutOfRangeException(OUT_OF_RANGE + " [" + min + "," + max + "]");
		} 
		
		addNewResult(checkedNumber);
		if(checkedNumber < unknownNumber){			
			min = checkedNumber;
			return false;
		} else if(checkedNumber > unknownNumber){
			max = checkedNumber;
			return true;
		} else {
			throw new WinnerException();
		}
		
	}
	
	public void addNewResult(int current){
		previousResult.put(current, "range from " + min + " to " + max);
	}
	
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
