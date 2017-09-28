package HomeAway.Exceptions;
/**
 *
 * @author Joao Monteiro
 */
public class UserIsOwnerException extends RuntimeException{

    public UserIsOwnerException() {
    }

    public UserIsOwnerException(String message) {
        super(message);
    }

    
    
}
