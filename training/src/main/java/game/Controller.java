package game;

import java.util.Scanner;

public class Controller {

    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model  = model;
        this.view = view;
    }
    
    // The Work method
    public void processUser(){
    	//the number that we have to guess
    	int unknownNumber = model.rand();
    	
    	Scanner sc = new Scanner(System.in);
    	
    	while(true){
	    	try {
				model.checkNumber(inputIntValueWithScanner(sc), unknownNumber);
			} catch (WinnerException e) {
				view.congratulationMessage();
				break;
			} catch (OutOfRangeException e) {
				view.printMessage(e.getMessage());
			} finally{
				//show previous entered numbers
		    	view.previousEnteredNumbers(model.getPreviousResult());
			}
	    		
    	}
 
    }
    
 // Ability to enter number from user
    public int inputIntValueWithScanner(Scanner sc) {
        view.printMessage(view.ENTER_NUMBER, model.getMin(), model.getMax());
        while( ! sc.hasNextInt()) {
            view.printMessage(view.WRONG);
            sc.next();
        }
        return sc.nextInt();
    }
}
