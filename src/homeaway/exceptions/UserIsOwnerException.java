package homeAway.exceptions;
/**
 * Thrown when a user tries to rent and give feedback to his own property.
 * 
 * @author Diogo Tavares (50309) dc.tavares@campus.fct.unl.pt
 * @author Joao Monteiro (51105) jg.monteiro@campus.fct.unl.pt
 */
public class UserIsOwnerException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserIsOwnerException() {
	}

	public UserIsOwnerException(String message) {
		super(message);
	}
	
	

	
	
}
