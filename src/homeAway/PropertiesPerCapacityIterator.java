package homeAway;

import dataStructures.Iterator;
import dataStructures.NoSuchElementException;
import dataStructures.OrderedList;

/**
 * 
 * @author Diogo Tavares (50309) dc.tavares@campus.fct.unl.pt
 * @author Joao Monteiro (51105) jg.monteiro@campus.fct.unl.pt
 */
public class PropertiesPerCapacityIterator<E> implements Iterator<HomeInfo>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int minCapacity, maxCapacity;
	private int currentCapacity;
	private Iterator<HomeInfo> currentIterator;
	private OrderedList<String, HomeInfo>[] propertiesArray;
	
	public PropertiesPerCapacityIterator(int minCapacity, int maxCapacity, OrderedList<String, HomeInfo>[] propertiesArray){
		// TODO Auto-generated constructor stub

		this.minCapacity = minCapacity;
		this.maxCapacity = maxCapacity;
		this.propertiesArray = propertiesArray;
		rewind();
	}
	
	private void findNext(){
		while(currentCapacity-1<maxCapacity){
			if(!propertiesArray[currentCapacity-1].isEmpty()){
				currentIterator = propertiesArray[currentCapacity-1].iteratorValues();
				currentCapacity++;
				break;
			}		
			currentCapacity++;
		}
	}
	
	
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return currentIterator!=null && currentIterator.hasNext();
	}

	@Override
	public HomeInfo next() throws NoSuchElementException {
		// TODO Auto-generated method stub
		
		if(!hasNext())
			throw new NoSuchElementException();
		
		HomeInfo next = currentIterator.next();
		
		if(!currentIterator.hasNext())
			findNext();
			
		
		return next;
	}

	@Override
	public void rewind() {
		// TODO Auto-generated method stub
		currentCapacity = minCapacity;
		findNext();
	}

}
