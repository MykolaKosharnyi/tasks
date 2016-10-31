package game;

import java.util.HashMap;
import java.util.Map;

public class View {
	// Text's constants 
    public static final String ENTER_NUMBER = "Enter number";
    public static final String PREVIOUSLY_ENTERED = "Previously entered numbers:";
    public static final String WRONG = "Wrong, you must enter the number!";
    public static final String CONGRATULATION = "Congratulation! ";
    public static final String NUMBER_OF_PREVIOUS_ATTEMPTS = "Number of previous attempts: ";
    
    /**
     * Print message
     * @param message - text that need to output
     */
    public void printMessage(String message){
        System.out.println(message);
    }
     
    /**
     * Show error messages
     * @param message
     */
    public void printErrMessage(String message){
        System.err.println(message);
    }
    
    /**
     * Print message to show range permissible numbers
     * @param message - text that need to output
     * @param min - minimum number in range
     * @param max - maximun number in range
     */
    public void printMessage(String message, int min, int max){
        System.out.println(message + " in range" + " [" + min + "," + max + "]");
    }

    /**
     * Show previous entered numbers
     * @param previousResult
     */
    public void previousEnteredNumbers(HashMap<Integer, String> previousResult){
    	if(previousResult.size() > 0){
    		System.out.println(PREVIOUSLY_ENTERED);
        	int numberInQueue = 0;
    		for (Map.Entry<Integer, String> entry : previousResult.entrySet()) {
        		Integer key = entry.getKey();
        		String value = entry.getValue();
        		System.out.println(++numberInQueue + ". " + key + " in " + value);
        	}
        	
        	System.out.println(NUMBER_OF_PREVIOUS_ATTEMPTS + previousResult.size());
        	System.out.println();
    	}
    }
    
    /**
     * Message with congratulation
     */
    public void congratulationMessage(){
    	System.err.println(CONGRATULATION);
    	System.out.println();
    }
       
}
