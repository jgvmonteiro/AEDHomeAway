package dataStructures;

public class IteratorStackInList<E> extends StackInList<E> implements IteratorStack<E>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public IteratorStackInList() {
		super();
	}
	
	public Iterator<E> iterator(){
		return list.iterator();
	}
}
