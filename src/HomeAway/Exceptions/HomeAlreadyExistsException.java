package HomeAway.Exceptions;
/**
 * Thrown when there is an attempt to add a property with the same id as one that already exists in system.

 * @author Diogo Tavares (50309) dc.tavares@campus.fct.unl.pt
 * @author Joao Monteiro (51105) jg.monteiro@campus.fct.unl.pt
 */
public class HomeAlreadyExistsException extends RuntimeException{

	public HomeAlreadyExistsException() {
	}

	public HomeAlreadyExistsException(String message) {
		super(message);
	}
	
	

}
