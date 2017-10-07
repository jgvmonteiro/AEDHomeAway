package HomeAway.Exceptions;
/**
 * Thrown whenever there is an attempt to use a negative value for a home capacity or price, or when 
 * the capacity is over 20
 * @author Joao Monteiro
 */
public class InvalidDataException extends RuntimeException{

	public InvalidDataException() {
	}

	public InvalidDataException(String message) {
		super(message);
	}

	
	
}
