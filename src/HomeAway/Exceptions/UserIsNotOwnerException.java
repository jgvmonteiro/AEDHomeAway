package HomeAway.Exceptions;
/**
 *
 * @author Joao Monteiro
 */
public class UserIsNotOwnerException extends RuntimeException{

    public UserIsNotOwnerException() {
    }

    public UserIsNotOwnerException(String message) {
        super(message);
    }

    
    
}
