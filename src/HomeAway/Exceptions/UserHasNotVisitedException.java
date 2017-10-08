package HomeAway.Exceptions;
/**
 * Thrown when there is an attempt to list user's visits but user hasn't visited any property.
 * 
 * @author Diogo Tavares (50309) dc.tavares@campus.fct.unl.pt
 * @author Joao Monteiro (51105) jg.monteiro@campus.fct.unl.pt
 */
public class UserHasNotVisitedException extends RuntimeException{

	public UserHasNotVisitedException() {
	}

	public UserHasNotVisitedException(String message) {
		super(message);
	}

	
	
}
