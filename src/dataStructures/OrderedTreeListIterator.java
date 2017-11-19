package dataStructures;

class OrderedTreeListIterator<K,V> implements Iterator<V>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Iterator<Entry<K,V>> it;
	
	public OrderedTreeListIterator(BSTNode<K, V> root) {
		// TODO Auto-generated constructor stub
		this.it = new BSTKeyOrderIterator<K, V>(root);
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return it.hasNext();
	}

	@Override
	public V next() throws NoSuchElementException {
		// TODO Auto-generated method stub
		return it.next().getValue(); //Exception thrown here...
	}

	@Override
	public void rewind() {
		// TODO Auto-generated method stub
		it.rewind();
	}

}
