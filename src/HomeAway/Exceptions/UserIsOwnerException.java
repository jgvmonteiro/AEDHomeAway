package HomeAway.Exceptions;
/**
 * Thrown when a user tries to rent and rate their own property.
 * @author Joao Monteiro
 */
public class UserIsOwnerException extends RuntimeException{

	public UserIsOwnerException() {
	}

	public UserIsOwnerException(String message) {
		super(message);
	}
	
	

	
	
}
