package dataStructures;

public class OrderedTreeList<K extends Comparable<K>, V> extends BinarySearchTree<K, V> implements OrderedList<K, V>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public Iterator<V> iteratorValues() {
		// TODO Auto-generated method stub
		return new OrderedTreeListIterator<K, V>(root);
	}

}
