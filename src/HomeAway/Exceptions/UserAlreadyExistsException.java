package HomeAway.Exceptions;
/**
 * Thrown when there is an attempt to add a user to the system but there already is one.
 * @author Joao Monteiro
 */
public class UserAlreadyExistsException extends RuntimeException{

	
	
	public UserAlreadyExistsException() {
		
	}

	public UserAlreadyExistsException(String message) {
		super(message);
	}

	
	
}
