package dataStructures;

public class ReverseIteratorBST<K extends Comparable<K>, V> extends BinarySearchTree<K, V> implements ReverseIteratorOrderedDictionary<K, V> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Iterator<Entry<K, V>> reverseIterator() {
		// TODO Auto-generated method stub
		return new BSTReverseKeyOrderIterator<K,V>(root);
	}

	
	
}
