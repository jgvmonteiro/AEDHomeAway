package dataStructures;

public interface OrderedTreeList<K extends Comparable<K>, V> extends OrderedDictionary<K, V> {

	/**
	 * 
	 * @return
	 */
	Iterator<V> iteratorValues();
	
	
}
