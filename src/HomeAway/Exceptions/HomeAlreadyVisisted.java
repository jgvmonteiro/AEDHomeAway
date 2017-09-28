package HomeAway.Exceptions;
/**
 *
 * @author Joao Monteiro
 */
public class HomeAlreadyVisisted extends RuntimeException{

    public HomeAlreadyVisisted() {
    }

    public HomeAlreadyVisisted(String message) {
        super(message);
    }

    
    
}
