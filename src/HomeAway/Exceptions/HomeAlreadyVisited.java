package HomeAway.Exceptions;
/**
 *
 * @author Joao Monteiro
 */
public class HomeAlreadyVisited extends RuntimeException{

	public HomeAlreadyVisited() {
	}

	public HomeAlreadyVisited(String message) {
		super(message);
	}

	
	
}
