package notebook;

import java.util.Date;
import java.util.Scanner;

/**
 * The controller of note model. Reads user's data and validate it.
 * @version 1.0
 * @author Mykola Kosharny
 */
public class Controller {

    /** 
     * Model 
     */
    private Note model;

    /** 
     * View
     */
    private View view;

    /** 
     * Regular expression to validate string
     */
    private static final String REGEX_STRING = "[a-zA-Zа-яА-Я]+";

    /** 
     * Regular expression to validate username 
     */
    private static final String REGEX_USERNAME = "^(?=.{4,20}$)(?![_.])" +
            "(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$";

    /** 
     * Regular expression to validate comment 
     */
    private static final String REGEX_COMMENT = "^.{0,200}$";

    /** 
     * Regular expression to validate group 
     */
    private static final String REGEX_GROUP = "[Rr]elatives|[Ff]riends|[Cc]olleagues|[Oo]thers";

    /** 
     * Regular expression to validate home phone number 
     */
    private static final String REGEX_HOME_PHONE_NUMBER = "^0-\\d{3}-\\d{6}$";

    /** 
     * Regular expression to validate cell phone number 
     */
    private static final String REGEX_CELL_PHONE_NUMBER = "^0\\d{2}-\\d{3}-\\d{2}-\\d{2}$";

    /** 
     * Regular expression to validate email 
     */
    private static final String REGEX_EMAIL = "^([a-z0-9_-]+\\.)*[a-z0-9_-]+" +
            "@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$";

    /** 
     * Regular expression to validate skype 
     */
    private static final String REGEX_SKYPE = "^[a-zA-Z][a-zA-Z0-9\\.,\\-_]{5,31}$";

    /** 
     * Regular expression to validate postal code 
     */
    private static final String REGEX_POSTAL_CODE = "^\\d{5}$";

    /** 
     * Regular expression to validate house number 
     */
    private static final String REGEX_HOUSE_NUMBER = "^\\d{1,3}[а-яА-Я]?$";

    /** 
     * Regular expression to validate flat number 
     */
    private static final String REGEX_FLAT_NUMBER = "^\\d{1,5}$";

    public Controller(Note model, View view) {
        this.model = model;
        this.view = view;
    }

    /**
     * Method sets fields to model
     */
    public void processUser() {
        Scanner scanner = new Scanner(System.in);
        view.showMessage(View.WELCOME_MESSAGE);

        view.showMessage(View.LAST_NAME_MESSAGE);
        model.setLastName(readUserInput(scanner, REGEX_STRING));

        view.showMessage(View.FIRST_NAME_MESSAGE);
        model.setFirstName(readUserInput(scanner, REGEX_STRING));

        view.showMessage(View.MIDDLE_NAME_MESSAGE);
        model.setMiddleName(readUserInput(scanner, REGEX_STRING));

        model.createFullName();

        view.showMessage(View.USERNAME_MESSAGE);
        model.setUsername(readUserInput(scanner, REGEX_USERNAME));

        view.showMessage(View.COMMENT_MESSAGE);
        model.setComment(readUserInput(scanner, REGEX_COMMENT));

        view.showMessage(View.GROUP_MESSAGE);
        model.setGroup(Group.valueOf(readUserInput(scanner, REGEX_GROUP).toUpperCase()));

        view.showMessage(View.HOME_PHONE_MESSAGE);
        model.setHomePhone(readUserInput(scanner, REGEX_HOME_PHONE_NUMBER));

        view.showMessage(View.CELL_PHONE_MESSAGE);
        model.setCellPhone(readUserInput(scanner, REGEX_CELL_PHONE_NUMBER));

        view.showMessage(View.ASK_OPTIONAL_CELL_PHONE_MESSAGE);
        if (isUserInputYesOrNo(scanner)) {
            view.showMessage(View.OPTIONAL_CELL_PHONE_MESSAGE);
            model.setCellPhoneOptional(readUserInput(scanner, REGEX_CELL_PHONE_NUMBER));
        } else {
            model.setCellPhoneOptional("");
        }

        view.showMessage(View.EMAIL_MESSAGE);
        model.setEmail(readUserInput(scanner, REGEX_EMAIL));

        view.showMessage(View.SKYPE_MESSAGE);
        model.setSkype(readUserInput(scanner, REGEX_SKYPE));

        view.showMessage(View.ADDRESS_MESSAGE);
        Address address = new Address();

        view.showMessage(View.POSTAL_CODE_MESSAGE);
        address.setPostalCode(readUserInput(scanner, REGEX_POSTAL_CODE));

        view.showMessage(View.CITY_MESSAGE);
        address.setCity(readUserInput(scanner, REGEX_STRING));

        view.showMessage(View.STREET_MESSAGE);
        address.setStreet(readUserInput(scanner, REGEX_STRING));

        view.showMessage(View.HOUSE_NUMBER_MESSAGE);
        address.setHouseNumber(readUserInput(scanner, REGEX_HOUSE_NUMBER));

        view.showMessage(View.FLAT_NUMBER_MESSAGE);
        address.setFlatNumber(readUserInput(scanner, REGEX_FLAT_NUMBER));

        model.setAddress(address);
        model.createFullAddress();

        model.setInitialDate(new Date());
        model.setLastChangeDate(new Date());

    }

    /**
     * Method reads users' input data and validates it using regular expression.
     * @param scanner scanner that reads
     * @param pattern regular expression pattern
     * @return valid user's input
     */
    public String readUserInput(Scanner scanner, String pattern) {
        String userInput = scanner.next();
        if (userInput.matches(pattern)) {
            return userInput;
        } else {
            view.showMessage(View.ERROR_MESSAGE);
            return readUserInput(scanner, pattern);
        }
    }

    /**
     * Method reads user's data and checks it for string 'y'
     * @param scanner
     * @return true, if user inputs 'y', and false, if user inputs any other data
     */
    public boolean isUserInputYesOrNo(Scanner scanner) {
        String userInput = scanner.next();
        if (userInput.equals("y")) {
            return true;
        } else {
            return false;
        }
    }
}