package HomeAway.Exceptions;
/**
 * Thrown when there is an attempt to add a second home to the system
 * @author Joao Monteiro
 */
public class HomeAlreadyExistsException extends RuntimeException{

	public HomeAlreadyExistsException() {
	}

	public HomeAlreadyExistsException(String message) {
		super(message);
	}
	
	

}
