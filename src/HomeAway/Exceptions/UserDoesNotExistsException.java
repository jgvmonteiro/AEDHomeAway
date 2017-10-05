package HomeAway.Exceptions;
/**
 *
 * @author Joao Monteiro
 */
public class UserDoesNotExistsException extends RuntimeException{

	public UserDoesNotExistsException() {
	}

	public UserDoesNotExistsException(String message) {
		super(message);
	}

	
	
}
