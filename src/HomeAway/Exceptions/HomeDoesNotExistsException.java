package HomeAway.Exceptions;
/**
 * Thrown whenever there is an attempt to search for a home with an identifier that does not correspond with anything
 * @author Joao Monteiro
 */
public class HomeDoesNotExistsException extends RuntimeException{

	public HomeDoesNotExistsException() {
	}

	public HomeDoesNotExistsException(String message) {
		super(message);
	}

	
	
}
