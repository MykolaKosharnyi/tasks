package game;

import java.util.Scanner;

public class Controller {

    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model  = model;
        this.view = view;
    }
     
    /**
     * The Work method
     */
    public void processUser(){
    	//say user opportunity to quit
    	view.printMessage(View.EXIT);
    	
    	Scanner sc = new Scanner(System.in);
    	
    	//the number that we have to guess
    	int[] range = userInputRangeToGuessedNumber(sc);
    	model.makeNumber(range[0], range[1]);

    	while(true){
	    	try {
				model.checkNumber(inputIntValueWithScanner(sc));
			} catch (WinnerException ex) {
				//it means that user guessed number
				view.congratulationMessage();
				break;
			} catch (OutOfRangeException e) {
				//user entered number out of range
				view.printErrMessage(e.getMessage());
			} finally{
				//show previous entered numbers
		    	view.previousEnteredNumbers(model.getPreviousResult());
			}
	    		
    	}
 
    }
    
    /**
     * Ability to enter number from user
     * @param sc Scanner helps to enter new date
     * @return number which will enter user
     */
    public int inputIntValueWithScanner(Scanner sc) {
        view.printMessage(View.ENTER_NUMBER, model.getMin(), model.getMax());
        return inputNumber(sc);
    }
    
    /**
     * This method helps user enter range for generating number which need to guess.
     * @param sc Scanner helps to enter new date
     * @return array which has on 0 index lover range, on 1 index higher range
     */
    public int[] userInputRangeToGuessedNumber(Scanner sc){
 
    	int lover = 0;
    	int higher = 0;
    	
    	do {
    		view.printMessage(View.ENTER_LOVER_RANGE);
        	lover = inputNumber(sc);
        	
        	view.printMessage(View.ENTER_HIGHER_RANGE);
        	higher = inputNumber(sc);
        	
        	if(lover >= higher)
        		view.printMessage(View.ERROT_SET_RANGE);
        	
    	} while (lover >= higher);
    	
    	return new int[]{lover, higher};
    }
    
    /**
     * 
     * @param sc Scanner helps to enter new date
     * @return number which will enter user
     */
    public int inputNumber(Scanner sc){
    	while( ! sc.hasNextInt()) {
    		if(sc.next().equals("exit")){	
    			view.printMessage(View.COMPLETE_PROGRAM);
    			System.exit(0);
    		}
            view.printMessage(View.WRONG);
            sc.next();
        }
    	return sc.nextInt();
    }
}