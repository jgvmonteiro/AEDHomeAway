package HomeAway.Exceptions;
/**
 * Thrown when there is an attempt to remove a user but they have a property in the system available for rent.
 * 
 * @author Diogo Tavares (50309) dc.tavares@campus.fct.unl.pt
 * @author Joao Monteiro (51105) jg.monteiro@campus.fct.unl.pt
 */
public class UserHasHomeToRent extends RuntimeException{

	public UserHasHomeToRent() {
	}

	public UserHasHomeToRent(String message) {
		super(message);
	}

	
	
}
