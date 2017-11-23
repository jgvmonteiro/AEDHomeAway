package dataStructures;

public class BSTReverseKeyOrderIterator<K,V> implements Iterator<Entry<K,V>> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BSTNode<K, V> root;
	private Stack<BSTNode<K, V>> path;
	
	public BSTReverseKeyOrderIterator(BSTNode<K, V> root) {
		// TODO Auto-generated constructor stub
		
		this.root = root;
		rewind();
	}
	
	
	private void fullRight(BSTNode<K, V> startNode){
		BSTNode<K, V> node = startNode;
		while(node!=null){
			path.push(node);
			node = node.getRight();
		}
	}
	
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return !path.isEmpty();
	}

	@Override
	public Entry<K, V> next() throws NoSuchElementException {
		// TODO Auto-generated method stub
		if(!hasNext())
			throw new NoSuchElementException();
		
		BSTNode<K, V> node = path.pop();
		fullRight(node.getLeft());
		
		return node.getEntry();
	}

	@Override
	public void rewind() {
		// TODO Auto-generated method stub
		path = new StackInList<BSTNode<K, V>>();
		fullRight(root);
	}

}
