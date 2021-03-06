package dataStructures;

public class OrderedDoubleList<K extends Comparable<K>, V> implements OrderedDictionary<K, V>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DListNode<Entry<K, V>> head;
	private DListNode<Entry<K, V>> tail;
	private int currentSize;
	
	public OrderedDoubleList(){
		this.head = null;
		this.tail = null;
		this.currentSize = 0;
	}
	
	@Override
	public boolean isEmpty() {
		return this.currentSize == 0;
	}

	@Override
	public int size() {
		return this.currentSize;
	}



	@Override
	public V find(K key) {
		if(isEmpty())	return null;
		if(this.tail.getElement().getKey().compareTo(key) < 0
		|| this.head.getElement().getKey().compareTo(key) > 0 || this.isEmpty())
			return null;
		DListNode<Entry<K, V>> current = this.head;	//inside the range
		while(current != null){
			Entry<K,V> elemToCompare = current.getElement();
			if(elemToCompare.getKey().compareTo(key) > 0){
				return null;
			}
			if(elemToCompare.getKey().compareTo(key) == 0){
				return elemToCompare.getValue();
			}
			current = current.getNext();
		}
		return null;
	}

	private void addFirst(DListNode<Entry<K, V>> ourEntry){
		ourEntry.setNext(head);
		head.setPrevious(ourEntry);
		this.head = ourEntry;
		this.currentSize++;
	}
	
	private void addLast(DListNode<Entry<K, V>> ourEntry){
		tail.setNext(ourEntry);
		ourEntry.setPrevious(tail);
		this.tail = ourEntry;
		this.currentSize++;
	}
	
	private void addMiddle(DListNode<Entry<K, V>> ourEntry, DListNode<Entry<K, V>> entryAfter) {
		ourEntry.setNext(entryAfter);
		ourEntry.setPrevious(entryAfter.getPrevious());
		entryAfter.setPrevious(ourEntry);
		ourEntry.getPrevious().setNext(ourEntry);
		currentSize++;
	}
	
	private V replaceEntry(DListNode<Entry<K, V>> ourEntry, DListNode<Entry<K, V>> ret) {
		V valueToReturn = ret.getElement().getValue();
		ret.setElement(ourEntry.getElement());
		return valueToReturn;
	}
	
	@Override
	public V insert(K key, V value) {
		if(key == null || value == null)
			return null;
		
		DListNode<Entry<K, V>> ourEntry = new DListNode<Entry<K, V>>(new EntryClass<K, V>(key, value));
		DListNode<Entry<K, V>> current = this.head;
		if(isEmpty()){
			head = ourEntry;
			tail = head;
			currentSize++;
			return null;
		}
		if(tail.getElement().getKey().compareTo(key) < 0){
			addLast(ourEntry);
			return null;
		}
		if(head.getElement().getKey().compareTo(key) > 0){
			addFirst(ourEntry);
			return null;
		}
		while(current != null){		
			Entry<K, V> elemToCompare = current.getElement();
			
			if(elemToCompare.getKey().compareTo(key) > 0){
				addMiddle(ourEntry, current);
				return null;
			}
			if(elemToCompare.getKey().compareTo(key) == 0){
				return replaceEntry(ourEntry, current);
			}
			current = current.getNext();
		}
		//addLast(ourEntry);
		return null;
	}

	@Override
	public V remove(K key) {
		if(isEmpty() || tail.getElement().getKey().compareTo(key) < 0 || head.getElement().getKey().compareTo(key) > 0)
			return null;
		
		DListNode<Entry<K, V>> current = this.head;
		while(current != null){
			if(current.getElement().getKey().compareTo(key) == 0){
				if(current == tail){
					tail = current.getPrevious();
				}
				else if(current == head){
					head = current.getNext();
				}
				else{
					current.getPrevious().setNext(current.getNext());
					current.getNext().setPrevious(current.getPrevious());
				}
				currentSize--;
				return current.getElement().getValue();
			}
			if(current.getElement().getKey().compareTo(key) > 0){
				return null;
			}
		current = current.getNext();
		}
		return null;
	}

	@Override
	public Iterator<Entry<K, V>> iterator() {
		return new DoublyLLIterator<Entry<K, V>>(head, tail);
	}

	@Override
	public Entry<K, V> minEntry() throws EmptyDictionaryException {
		if(isEmpty())
			throw new EmptyDictionaryException();
		return head.getElement();
	}

	@Override
	public Entry<K, V> maxEntry() throws EmptyDictionaryException {
		if(isEmpty())
			throw new EmptyDictionaryException();
		return tail.getElement();
	}

	

}
