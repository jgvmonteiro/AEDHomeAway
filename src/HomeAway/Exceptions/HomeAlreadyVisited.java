package HomeAway.Exceptions;
/**
 * Thrown when there is an attempt to remove a home that has already been visited from the system
 * @author Joao Monteiro
 */
public class HomeAlreadyVisited extends RuntimeException{

	public HomeAlreadyVisited() {
	}

	public HomeAlreadyVisited(String message) {
		super(message);
	}

	
	
}
