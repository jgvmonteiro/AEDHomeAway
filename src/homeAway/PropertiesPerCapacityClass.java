package homeAway;

import dataStructures.ChainedHashTable;
import dataStructures.Dictionary;
import dataStructures.Iterator;
import dataStructures.OrderedDoublyLinkedList;
import dataStructures.SortedList;
import homeAway.exceptions.NoResultsException;

/**
 * PropertiesPerCapacity implementation class.
 * The description of the methods is provided in the interface implemented.
 * @see PropertiesPerCapacity for more information.
 * 
 * @author Diogo Tavares (50309) dc.tavares@campus.fct.unl.pt
 * @author Joao Monteiro (51105) jg.monteiro@campus.fct.unl.pt
 */
public class PropertiesPerCapacityClass implements PropertiesPerCapacity {

	
	private Dictionary<String, SortedList<HomeInfo>[]> propertiesLocal;
	private int maxCapacity;
	
	public PropertiesPerCapacityClass(int maxCapacity) {
		// TODO Auto-generated constructor stub
		this.maxCapacity = maxCapacity;
		propertiesLocal = new ChainedHashTable<String, SortedList<HomeInfo>[]>(100);
	}
	
	//OrderedDoublyLinkedList
	@SuppressWarnings("unchecked")
	@Override
	public void insert(Home home) {
		// TODO Auto-generated method stub 
		
		SortedList<HomeInfo>[] capacityArray = propertiesLocal.find(home.getLocal().toUpperCase());
		if(capacityArray==null){
			SortedList<HomeInfo>[] newcapacityArray = (SortedList<HomeInfo>[]) new SortedList[maxCapacity];
			for (int i = 0; i < newcapacityArray.length; i++)
				newcapacityArray[i] = new OrderedDoublyLinkedList<HomeInfo>();
			
			newcapacityArray[home.getCapacity()-1].add(home);
			propertiesLocal.insert(home.getLocal().toUpperCase(), newcapacityArray);
			return;
		}
		capacityArray[home.getCapacity()-1].add(home);
	}

	@Override
	public boolean remove(Home home) {
		// TODO Auto-generated method stub
		SortedList<HomeInfo>[] capacityArray = propertiesLocal.find(home.getLocal().toUpperCase());
		if(capacityArray==null)
			return false;
		return capacityArray[home.getCapacity()-1].remove(home);
		
	}

	@Override
	public Iterator<HomeInfo> iterator(int capacity, String local) throws NoResultsException {
		// TODO Auto-generated method stub
		SortedList<HomeInfo>[] capacityArray = propertiesLocal.find(local.toUpperCase());
		if(capacityArray==null)
			throw new NoResultsException();
		Iterator<HomeInfo>  it = new PropertiesPerCapacityIterator<HomeInfo>(capacity, maxCapacity, capacityArray);
		if(!it.hasNext())
			throw new NoResultsException();
		return it;
	}

}
