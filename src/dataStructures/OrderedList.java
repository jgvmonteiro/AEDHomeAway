package dataStructures;

public interface OrderedList<K extends Comparable<K>, V> extends OrderedDictionary<K, V> {

	/**
	 * 
	 * @return
	 */
	Iterator<V> iteratorValues();
	
	
}
