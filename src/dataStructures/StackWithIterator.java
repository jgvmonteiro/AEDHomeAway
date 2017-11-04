package dataStructures;

public class StackWithIterator<E> extends StackInList<E>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public Iterator<E> iterator(){
		DoublyLinkedList<E> list = (DoublyLinkedList<E>)this.list;
		return new StackIterator<E>(list.head, list.tail);
	}
}
