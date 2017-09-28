package HomeAway.Exceptions;
/**
 *
 * @author Joao Monteiro
 */
public class UserAlreadyExistsException extends RuntimeException{

    
    
    public UserAlreadyExistsException() {
        
    }

    public UserAlreadyExistsException(String message) {
        super(message);
    }

    
    
}
