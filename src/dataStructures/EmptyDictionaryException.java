package dataStructures;

public class EmptyDictionaryException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public EmptyDictionaryException(){
		super();
	}

	public EmptyDictionaryException(String message){
		super(message);
	}
	
}
