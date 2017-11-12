package dataStructures;

public interface SortedList<E extends Comparable<E>> extends List<E>{

	/**
	 * Adds new element to the collection in specified order
	 * @param element
	 */
	void add(E element);
	
}
