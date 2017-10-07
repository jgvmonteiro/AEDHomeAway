package HomeAway.Exceptions;
/**
 * Thrown when there is an attempt to search for a user but it cannot be found.
 * @author Joao Monteiro
 */
public class UserDoesNotExistsException extends RuntimeException{

	public UserDoesNotExistsException() {
	}

	public UserDoesNotExistsException(String message) {
		super(message);
	}

	
	
}
