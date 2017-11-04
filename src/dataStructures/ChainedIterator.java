package dataStructures;

public class ChainedIterator<K, V> implements Iterator<Entry<K, V>>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Dictionary<K, V>[] table;
	private Iterator<Entry<K, V>> currentIt;
	private int current;
	private int size;
	private int iterations;
	
	public ChainedIterator(Dictionary<K, V>[] table, int size){
		//this.current = 0; done in rewind
		this.table = table;
		this.currentIt = null;
		this.size = size;
		this.iterations = 0;
		this.rewind();
	}
	
	
	@Override
	public boolean hasNext() {
		return this.current != this.table.length && this.iterations < this.size;
		
		//return this.currentIt.hasNext();
	}

	@Override
	/**
	 * Final iteration always returns null
	 */
	public Entry<K, V> next() throws NoSuchElementException {
		if (!this.hasNext())
            throw new NoSuchElementException();
		
		if(this.currentIt.hasNext()) {
			this.iterations++;
			return currentIt.next();
		}
		
		else findNext();
		
		if(this.currentIt == null || !this.currentIt.hasNext()) {
			return null;
		}
		else {
			this.iterations++;
			return this.currentIt.next();
		}
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
		this.current++;
		if(this.current >= this.table.length)
			return;
		while((this.table[current] == null || this.table[current].isEmpty())) {
			this.current++;
			if(this.current >= this.table.length)
				return;
		}
		this.currentIt = this.table[this.current].iterator();
	}
	
	
}
