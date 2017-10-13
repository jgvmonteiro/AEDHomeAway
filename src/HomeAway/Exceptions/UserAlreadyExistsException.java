package homeAway.exceptions;
/**
 * Thrown when there is an attempt to add a user with the same id as one that already exists in system.
 * 
 * @author Diogo Tavares (50309) dc.tavares@campus.fct.unl.pt
 * @author Joao Monteiro (51105) jg.monteiro@campus.fct.unl.pt
 */
public class UserAlreadyExistsException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserAlreadyExistsException() {
		
	}

	public UserAlreadyExistsException(String message) {
		super(message);
	}

	
	
}
