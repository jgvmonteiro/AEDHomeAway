package HomeAway.Exceptions;
/**
 * Thrown when there is an attempt to add a user with the same id as one that already exists in system.
 * 
 * @author Diogo Tavares (50309) dc.tavares@campus.fct.unl.pt
 * @author Joao Monteiro (51105) jg.monteiro@campus.fct.unl.pt
 */
public class UserAlreadyExistsException extends RuntimeException{

	public UserAlreadyExistsException() {
		
	}

	public UserAlreadyExistsException(String message) {
		super(message);
	}

	
	
}
