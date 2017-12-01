package dataStructures;

public class BSTBreadthFirstIteratorTEST<K,V>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected Queue<BSTNode<K, V>> q;
	private BSTNode<K, V> root;

	public BSTBreadthFirstIteratorTEST(BSTNode<K, V> root) {
		// TODO Auto-generated constructor stub
		this.root = root;
		rewind();
	}
	
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return !q.isEmpty();
	}

	public BSTNode next() throws NoSuchElementException {
		// TODO Auto-generated method stub
		if(!hasNext())
			throw new NoSuchElementException();
		BSTNode<K, V> node = q.dequeue();
		if(node.getLeft()!=null)	
			q.enqueue(node.getLeft());
		if(node.getRight()!=null)
			q.enqueue(node.getRight());
	
		return node;
	}

	public void rewind() {
		// TODO Auto-generated method stub
		q = new QueueInArray<BSTNode<K,V>>();
		q.enqueue(root);
	}

}
