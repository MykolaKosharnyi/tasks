package notebook;

/**
 * The view outputs strings in console and has got set of final strings.
 * @version 1.0
 * @author Mykola Kosharny
 */
public class View {

    /**
     *  Welcome message 
     */
    public static final String WELCOME_MESSAGE = "Hello, please, enter information about subscriber";

    /** 
     * First name message 
     */
    public static final String FIRST_NAME_MESSAGE = "Please, enter first name:";

    /** 
     * Last name message 
     */
    public static final String LAST_NAME_MESSAGE = "Please, enter last name:";

    /**
     *  Middle name message 
     */
    public static final String MIDDLE_NAME_MESSAGE = "Please, enter middle name:";

    /** 
     * Username message 
     */
    public static final String USERNAME_MESSAGE = "Please, enter" +
            " username(4-20 characters):";

    /** 
     * Comment message 
     */
    public static final String COMMENT_MESSAGE = "Please, enter" +
            " comment(max 200 characters):";

    /**
     *  Group message 
     */
    public static final String GROUP_MESSAGE = "Please, choose group from" +
            " following: Relatives, Friends, Colleagues, Others:";

    /** 
     * Home phone message
     */
    public static final String HOME_PHONE_MESSAGE = "Please, enter" +
            " home phone number in format 0-yyy-xxxxxx:";

    /** 
     * Cell phone message
     */
    public static final String CELL_PHONE_MESSAGE = "Please, enter" +
            " cell phone number in format 0yy-xxx-xx-xx:";

    /** 
     * Asking optional cell phone message
     */
    public static final String ASK_OPTIONAL_CELL_PHONE_MESSAGE = "Do you" +
            " want to enter additional cell phone number? Write 'y'," +
            " if you want, or anything else, if you don't want.";

    /** 
     * Additional cell phone message
     */
    public static final String OPTIONAL_CELL_PHONE_MESSAGE = "Please, enter" +
            " second cell phone number in format 0yy-xxx-xx-xx::";

    /** 
     * Email message 
     */
    public static final String EMAIL_MESSAGE = "Please, enter email:";

    /** 
     * Skype message 
     */
    public static final String SKYPE_MESSAGE = "Please, enter " +
            "skype(5-31 characters):";

    /** 
     * Address message 
     */
    public static final String ADDRESS_MESSAGE = "Please, enter address";

    /** 
     * Postal code message 
     */
    public static final String POSTAL_CODE_MESSAGE = "Postal code(xxxxx):";

    /** 
     * City message 
     */
    public static final String CITY_MESSAGE = "City:";

    /** 
     * Street message 
     */
    public static final String STREET_MESSAGE = "Street:";

    /** 
     * House number message 
     */
    public static final String HOUSE_NUMBER_MESSAGE = "House number:";

    /** 
     * Flat number message 
     */
    public static final String FLAT_NUMBER_MESSAGE = "Flat number:";

    /** 
     * Error message 
     * */
    public static final String ERROR_MESSAGE = "Wrong input data, please, enter again:";

    /**
     * Method outputs string in console
     * @param string string to output
     */
    public void showMessage(String string) {
        System.out.println(string);
    }

}
