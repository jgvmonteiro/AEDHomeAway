package homeAway;

import dataStructures.ChainedHashTable;
import dataStructures.Dictionary;
import dataStructures.Iterator;
import dataStructures.OrderedList;
import dataStructures.OrderedTreeList;
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

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Dictionary<String, OrderedList<String, HomeInfo>[]> propertiesLocal;
	private int maxCapacity;
	
	public PropertiesPerCapacityClass(int maxCapacity) {
		// TODO Auto-generated constructor stub
		this.maxCapacity = maxCapacity;
		propertiesLocal = new ChainedHashTable<String, OrderedList<String, HomeInfo>[]>(100);
	}
	
	//OrderedDoublyLinkedList
	@SuppressWarnings("unchecked")
	@Override
	public void add(HomeInfo home) {
		// TODO Auto-generated method stub 
		
		OrderedList<String, HomeInfo>[] capacityArray = propertiesLocal.find(home.getLocal().toUpperCase());
		if(capacityArray==null){
			OrderedList<String, HomeInfo>[] newcapacityArray = (OrderedList<String, HomeInfo>[]) new OrderedList[maxCapacity];
			for (int i = 0; i < newcapacityArray.length; i++)
				newcapacityArray[i] = new OrderedTreeList<String, HomeInfo>();
			
			newcapacityArray[home.getCapacity()-1].insert(home.getHomeID(), home);
			propertiesLocal.insert(home.getLocal().toUpperCase(), newcapacityArray);
			return;
		}
		capacityArray[home.getCapacity()-1].insert(home.getHomeID(), home);
	}

	@Override
	public boolean remove(HomeInfo home) {
		// TODO Auto-generated method stub
		OrderedList<String, HomeInfo>[] capacityArray = propertiesLocal.find(home.getLocal().toUpperCase());
		if(capacityArray==null)
			return false;
		return capacityArray[home.getCapacity()-1].remove(home.getHomeID())==null?false:true;
		
	}

	@Override
	public Iterator<HomeInfo> iterator(int capacity, String local) throws NoResultsException {
		// TODO Auto-generated method stub
		OrderedList<String, HomeInfo>[] capacityArray = propertiesLocal.find(local.toUpperCase());
		if(capacityArray==null)
			throw new NoResultsException();
		Iterator<HomeInfo>  it = new PropertiesPerCapacityIterator<HomeInfo>(capacity, maxCapacity, capacityArray);
		if(!it.hasNext())
			throw new NoResultsException();
		return it;
	}

}
