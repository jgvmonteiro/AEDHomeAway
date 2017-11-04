package dataStructures;

public class StackIterator<E> implements Iterator<E>{

	private DListNode<E> first;
	private DListNode<E> last;
	private DListNode<E> next;
	
	public StackIterator(DListNode<E> head, DListNode<E> tail) {
		this.first = head;
		this.last = tail;
		rewind();
	}

	@Override
	public boolean hasNext() {
		return this.next != null;
	}

	@Override
	public E next() throws NoSuchElementException {
		if(!hasNext())
			throw new NoSuchElementException();
		
		E n = next.getElement();
		next = next.getNext();
		return n;
	}

	@Override
	public void rewind() {
		next = first;
	}

}
