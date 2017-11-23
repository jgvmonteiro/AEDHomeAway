package dataStructures;

public interface ReverseIteratorOrderedDictionary<K extends Comparable<K>, V> extends OrderedDictionary<K, V>{

	Iterator<Entry<K, V>> reverseIterator();
	
}
