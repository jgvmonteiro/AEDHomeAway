package HomeAway.Exceptions;
/**
 * Thrown when there is an attempt to search for the list of user visits but 
 * the user hasn't stayed in any property.
 * @author Joao Monteiro
 */
public class UserHasNotRentsException extends RuntimeException{

	public UserHasNotRentsException() {
	}

	public UserHasNotRentsException(String message) {
		super(message);
	}

	
	
}
