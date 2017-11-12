package dataStructures;

public class OrderedDoublyLinkedList<E extends Comparable<E>> extends DoublyLinkedList<E> implements SortedList<E>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public OrderedDoublyLinkedList() {
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	public void add(E element) {
		// TODO Auto-generated method stub
		
		if(isEmpty()){
			addFirst(element);return;
		}
		
		if(head.getElement().compareTo(element)>0){
			addFirst(element);return;
		}
		
		if(head.getElement().compareTo(element)<0){
			addLast(element);return;
		}
		
		DListNode<E> currentNode = head;
		int pos = 0;
		
		while(currentNode!=null){
			
			if(currentNode.getElement().compareTo(element)==0){
				addMiddle(pos+1, element);return;//???
			}
			
			if(currentNode.getElement().compareTo(element)>0){
				addMiddle(pos, element);
			}
			
			currentNode = currentNode.getNext();
			pos++;
			
		}
		
	
	}
	
	
	
	
	
	
 
}
