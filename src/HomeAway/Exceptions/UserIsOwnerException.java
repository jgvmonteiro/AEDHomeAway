package HomeAway.Exceptions;
/**
 * Thrown when a user tries to rent and rate their own property.
 * 
 * @author Diogo Tavares (50309) dc.tavares@campus.fct.unl.pt
 * @author Joao Monteiro (51105) jg.monteiro@campus.fct.unl.pt
 */
public class UserIsOwnerException extends RuntimeException{

	public UserIsOwnerException() {
	}

	public UserIsOwnerException(String message) {
		super(message);
	}
	
	

	
	
}
