package dataStructures;

public class BSTBreadthFirstIterator<K,V> implements Iterator<Entry<K,V>>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected Queue<BSTNode<K, V>> q;
	private BSTNode<K, V> root;

	public BSTBreadthFirstIterator(BSTNode<K, V> root) {
		// TODO Auto-generated constructor stub
		this.root = root;
		rewind();
	}
	
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return !q.isEmpty();
	}

	@Override
	public Entry<K, V> next() throws NoSuchElementException {
		// TODO Auto-generated method stub
		if(!hasNext())
			throw new NoSuchElementException();
		BSTNode<K, V> node = q.dequeue();
		if(node.getLeft()!=null)	
			q.enqueue(node.getLeft());
		if(node.getRight()!=null)
			q.enqueue(node.getRight());
	
		return node.getEntry();
	}

	@Override
	public void rewind() {
		// TODO Auto-generated method stub
		q = new QueueInArray<BSTNode<K,V>>();
		q.enqueue(root);
	}

}
