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
    	//the number that we have to guess
    	model.makeNumber();

    	Scanner sc = new Scanner(System.in);
    	
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
     * @return number with enter user
     */
    public int inputIntValueWithScanner(Scanner sc) {
        view.printMessage(View.ENTER_NUMBER, model.getMin(), model.getMax());
        while( ! sc.hasNextInt()) {
            view.printMessage(View.WRONG);
            sc.next();
        }
        return sc.nextInt();
    }
}
