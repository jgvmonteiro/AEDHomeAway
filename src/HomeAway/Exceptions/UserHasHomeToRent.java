package HomeAway.Exceptions;
/**
 *
 * @author Joao Monteiro
 */
public class UserHasHomeToRent extends RuntimeException{

    public UserHasHomeToRent() {
    }

    public UserHasHomeToRent(String message) {
        super(message);
    }

    
    
}
