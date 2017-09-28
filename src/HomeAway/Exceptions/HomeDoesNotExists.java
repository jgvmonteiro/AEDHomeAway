package HomeAway.Exceptions;
/**
 *
 * @author Joao Monteiro
 */
public class HomeDoesNotExists extends RuntimeException{

    public HomeDoesNotExists() {
    }

    public HomeDoesNotExists(String message) {
        super(message);
    }

    
    
}
