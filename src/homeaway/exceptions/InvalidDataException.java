package homeAway.exceptions;
/**
 * Thrown whenever there is an attempt to use a negative value for a property capacity or price, or when 
 * the capacity is over 20
 * 
 * @author Diogo Tavares (50309) dc.tavares@campus.fct.unl.pt
 * @author Joao Monteiro (51105) jg.monteiro@campus.fct.unl.pt
 */
public class InvalidDataException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidDataException() {
	}

	public InvalidDataException(String message) {
		super(message);
	}

	
	
}
