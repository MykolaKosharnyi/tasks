package notebook;

/**
 * The main class.
 * @version 1.0
 * @author Mykola Kosharny
 */
public class Main {

    /**
     * Main method
     * @param args console arguments
     */
    public static void main(String[] args) {
        Note model = new Note();
        View view = new View();
        Controller controller = new Controller(model, view);
        controller.processUser();
    }

}
