package dataStructures;  

/**
 * Chained Hash table implementation
 * @author AED  Team
 * @version 1.0
 * @param <K> Generic Key, must extend comparable
 * @param <V> Generic Value 
 */

public class ChainedHashTable<K extends Comparable<K>, V> 
    extends HashTable<K,V> 
{ 
	
	//currentsize, maxsize
	
	/**
	 * Serial Version UID of the Class.
	 */
    static final long serialVersionUID = 0L;

	/**
	 * The array of dictionaries.
	 */
    protected Dictionary<K,V>[] table;


    /**
     * Constructor of an empty chained hash table,
     * with the specified initial capacity.
     * Each position of the array is initialized to a new ordered list
     * maxSize is initialized to the capacity.
     * @param capacity defines the table capacity.
     */
    @SuppressWarnings("unchecked")
    public ChainedHashTable( int capacity )
    {
        int arraySize = HashTable.nextPrime((int) (1.1 * capacity));
        // Compiler gives a warning.
        table = (Dictionary<K,V>[]) new Dictionary[arraySize];
        for ( int i = 0; i < arraySize; i++ ){
            table[i] = new OrderedDoubleList<K,V>();
        }
        maxSize = capacity;
        currentSize = 0;
    }                                      


    public ChainedHashTable( )
    {
        this(DEFAULT_CAPACITY);
    }                                                                

    /**
     * Returns the hash value of the specified key.
     * @param key to be encoded
     * @return hash value of the specified key
     */
    protected int hash( K key )
    {
        return Math.abs( key.hashCode() ) % table.length;
    }
    
    /**
     * Creates a new table, then goes through every item in the previous one and reads it
     */
    @SuppressWarnings("unchecked")
	private void rehash(){
    	int newMaxSize = HashTable.nextPrime((int) this.maxSize * 2);
        Dictionary<K, V>[] newTable = (Dictionary<K, V>[]) new Dictionary[newMaxSize];
        
        for(int i = 0; i < newTable.length; i++){
        	newTable[i] = new OrderedDoubleList<K, V>();
        }
        
        Dictionary<K, V>[] tempTable = table;
        this.table = newTable;
        this.maxSize = newMaxSize;
        this.currentSize = 0;
        
        for(int i = 0; i < tempTable.length; i++){
        //	if(this.table[i] != null){
        		Iterator<Entry<K, V>> it = tempTable[i].iterator();
        		while(it.hasNext()){
        			Entry<K, V> e = it.next();
        			insert(e.getKey(), e.getValue());
        		}
        //	}
        }   
    }
    
    
    @Override
    public V find( K key )
    {	
    	int hash = this.hash(key);
    	if(table[hash].isEmpty()) {
    		return null;
    	}
        
    	return table[ hash ].find(key);
    }

    @Override
    public V insert( K key, V value )
    {
        if ( this.isFull() )
            this.rehash();
        V found = this.table[this.hash(key)].insert(key, value);
        if(found == null) {
        	this.currentSize++;
        }
        return found;
    }

    @Override
    public V remove( K key )
    {
        if(this.find(key) == null)
        	return null;	//item to remove does not exist
        else{
        	this.currentSize--;
        	return this.table[this.hash(key)].remove(key);
        }
    }

    @Override
    public Iterator<Entry<K,V>> iterator( )
    {
        return new ChainedIterator<K,V>(this.table, this.currentSize);
    } 
}
































