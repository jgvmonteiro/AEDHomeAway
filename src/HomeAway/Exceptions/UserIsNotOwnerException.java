package HomeAway.Exceptions;
/**
 * Thrown when a user attempts rent his own home but he does not own it, or,
 * when there is an attempt to list the properties owned by the user but he does not own any property.
 * 
 * @author Diogo Tavares (50309) dc.tavares@campus.fct.unl.pt
 * @author Joao Monteiro (51105) jg.monteiro@campus.fct.unl.pt
 */
public class UserIsNotOwnerException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserIsNotOwnerException() {
	}

	public UserIsNotOwnerException(String message) {
		super(message);
	}

	
	
}
