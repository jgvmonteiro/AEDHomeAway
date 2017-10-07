package HomeAway.Exceptions;
/**
 * Thrown when there is an attempt to search for a home in the system but none can be found
 * @author Joao Monteiro
 */
public class NoResultsException extends RuntimeException{

	public NoResultsException() {
	}

	public NoResultsException(String message) {
		super(message);
	}

	
	
}
