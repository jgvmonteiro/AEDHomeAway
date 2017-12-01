package dataStructures;

public class BSTKeyOrderIteratorTEST<K,V> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BSTNode<K, V> root;
	private Stack<BSTNode<K, V>> path;
	
	public BSTKeyOrderIteratorTEST(BSTNode<K, V> root) {
		// TODO Auto-generated constructor stub
		
		this.root = root;
		rewind();
	}
	
	
	private void fullLeft(BSTNode<K, V> startNode){
		BSTNode<K, V> node = startNode;
		while(node!=null){
			path.push(node);
			node = node.getLeft();
		}
	}
	
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return !path.isEmpty();
	}

	public BSTNode<K, V> next() throws NoSuchElementException {
		// TODO Auto-generated method stub
		if(!hasNext())
			throw new NoSuchElementException();
		
		BSTNode<K, V> node = path.pop();
		fullLeft(node.getRight());
		
		return node;
	}

	public void rewind() {
		// TODO Auto-generated method stub
		path = new StackInList<BSTNode<K, V>>();
		fullLeft(root);
	}

}
