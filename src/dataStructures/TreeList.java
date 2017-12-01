package dataStructures;

public class TreeList<K extends Comparable<K>, V> extends AVLTree<K, V> implements OrderedTreeList<K, V>{

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
