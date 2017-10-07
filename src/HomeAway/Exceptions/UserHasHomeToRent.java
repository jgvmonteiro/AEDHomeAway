package HomeAway.Exceptions;
/**
 * Thrown when there is an attempt to remove a user but they have an home in the system available for rent.
 * @author Joao Monteiro
 */
public class UserHasHomeToRent extends RuntimeException{

	public UserHasHomeToRent() {
	}

	public UserHasHomeToRent(String message) {
		super(message);
	}

	
	
}
