package homeAway.exceptions;
/**
 * Thrown when there is an attempt to search for a property in the system but nothing matches the given parameters. 
 * 
 * @author Diogo Tavares (50309) dc.tavares@campus.fct.unl.pt
 * @author Joao Monteiro (51105) jg.monteiro@campus.fct.unl.pt
 */
public class NoResultsException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoResultsException() {
	}

	public NoResultsException(String message) {
		super(message);
	}

	
	
}
