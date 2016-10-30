package game;

import java.util.HashMap;
import java.util.Map;

public class View {
	// Text's constants    
    public final String ENTER_NUMBER = "Enter number";
    public final String PREVIOUSLY_ENTERED = "Previously entered numbers:";
    public final String WRONG = "Wrong, you must enter the number!";
    public final String CONGRATULATION = "Congratulation! ";
    public final String NUMBER_OF_PREVIOUS_ATTEMPTS = "Number of previous attempts: ";
    
    /**
     * print message
     * */
    public void printMessage(String message){
        System.out.println(message);
    }
    
    /**
     * show error messages
     * */    
    public void printErrMessage(String message){
        System.err.println(message);
    }
    
    /**
     * print message to show range permissible numbers
     * */
    public void printMessage(String message, int min, int max){
        System.out.println(message + " in range" + " [" + min + "," + max + "]");
    }

    /**
     * show previous entered numbers
     * */
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
     * message with congratulation
     * */
    public void congratulationMessage(){
    	System.err.println(CONGRATULATION);
    	System.out.println();
    }
       
}
