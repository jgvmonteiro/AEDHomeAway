package homeAway.exceptions;
/**
 * Thrown whenever there is an attempt to search for a property with an identifier(id) that does not match any property in the system.

 * @author Diogo Tavares (50309) dc.tavares@campus.fct.unl.pt
 * @author Joao Monteiro (51105) jg.monteiro@campus.fct.unl.pt
 */
public class HomeDoesNotExistsException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HomeDoesNotExistsException() {
	}

	public HomeDoesNotExistsException(String message) {
		super(message);
	}

	
	
}
