package homeAway.exceptions;
/**
 * Thrown when there is an attempt to remove a property that has already been visited.
 * 
 * @author Diogo Tavares (50309) dc.tavares@campus.fct.unl.pt
 * @author Joao Monteiro (51105) jg.monteiro@campus.fct.unl.pt
 */
public class HomeAlreadyVisitedException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HomeAlreadyVisitedException() {
	}

	public HomeAlreadyVisitedException(String message) {
		super(message);
	}

	
	
}
