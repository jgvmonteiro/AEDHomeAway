package HomeAway.Exceptions;
/**
 * Thrown when there is an attempt to have a user rent their own home but they do not own any or
 * when there is an attempt to get a user's list of properties but they do not own any.
 * @author Joao Monteiro
 */
public class UserIsNotOwnerException extends RuntimeException{

	public UserIsNotOwnerException() {
	}

	public UserIsNotOwnerException(String message) {
		super(message);
	}

	
	
}
