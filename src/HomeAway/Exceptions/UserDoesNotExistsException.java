package HomeAway.Exceptions;
/**
 * Thrown whenever there is an attempt to search for a user with an identifier(id) that does not match any user in the system.
 * 
 * @author Diogo Tavares (50309) dc.tavares@campus.fct.unl.pt
 * @author Joao Monteiro (51105) jg.monteiro@campus.fct.unl.pt
 */
public class UserDoesNotExistsException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserDoesNotExistsException() {
	}

	public UserDoesNotExistsException(String message) {
		super(message);
	}

	
	
}
