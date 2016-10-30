package game;

import java.util.HashMap;
import java.util.Map;

public class View {
	// Text's constants    
    public final String ENTER_NUMBER = "Enter number";
    public final String PREVIOUSLY_ENTERED = "Previously entered numbers:";
    public final String WRONG = "Wrong, you must enter the number!";
    public final String WRONG_NUMBER = "Wrong number, you must enter the number in";
    public final String CONGRATULATION = "Congratulation! ";
    public final String NUMBER_OF_PREVIOUS_ATTEMPTS = "Number of previous attempts: ";

    public void printMessage(String message){
        System.out.println(message);
    }
    
    public void printMessage(String message, int min, int max){
        System.out.println(message + " in range" + " [" + min + "," + max + "]");
    }

    public void previousEnteredNumbers(HashMap<Integer, String> previousResult){
    	System.out.println(PREVIOUSLY_ENTERED);
    	for (Map.Entry<Integer, String> entry : previousResult.entrySet()) {
    		Integer key = entry.getKey();
    		String value = entry.getValue();
    		System.out.println(key + " in " + value);
    	}
    	
    	System.out.println(NUMBER_OF_PREVIOUS_ATTEMPTS + previousResult.size());
    	System.out.println();
    }
    
    public void congratulationMessage(){
    	System.out.println(CONGRATULATION);
    	System.out.println();
    }
       
}
