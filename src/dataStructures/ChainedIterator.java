package dataStructures;

public class ChainedIterator<K, V> implements Iterator<Entry<K, V>>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Dictionary<K, V>[] table;
	private Iterator<Entry<K, V>> currentIt;
	private int current;
	
	
	public ChainedIterator(Dictionary<K, V>[] table){
		//this.current = 0; done in rewind
		this.table = table;
		this.currentIt = null;
		this.rewind();
	}
	
	
	@Override
	public boolean hasNext() {
		return this.current != this.table.length;
		//return this.currentIt.hasNext();
	}

	@Override
	public Entry<K, V> next() throws NoSuchElementException {
		if (!this.hasNext())
            throw new NoSuchElementException();
		
		if(this.currentIt.hasNext()) {
			return currentIt.next();
		}
		
		else findNext();
		
		if(this.currentIt == null) {
			return null;
		}
		else return this.currentIt.next();
	}

	@Override
	public void rewind() {
		this.current = -1;
		findNext();
	}

	/**
	 * Moves current into the next position and updates currentIt
	 */
	private void findNext() {
		/*
		while(this.currentIt == null){	//will always be true on the first execution as currentIt is set to null right before
			this.current++;
			this.currentIt = this.table[this.current].iterator();
		}*/
		while(this.table[current] == null && this.current < this.table.length) {
			this.current++;
		}
		this.currentIt = this.table[this.current].iterator();
	}
	
	
}
