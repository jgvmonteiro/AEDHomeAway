package homeAway;

import dataStructures.BinarySearchTree;
import dataStructures.ChainedHashTable;
import dataStructures.Dictionary;
import dataStructures.Iterator;
import dataStructures.OrderedDictionary;
import dataStructures.ReverseIteratorBST;
import dataStructures.ReverseIteratorOrderedDictionary;
import homeAway.exceptions.NoResultsException;

class PropertiesPerFeedbackClass implements PropertiesPerFeedback {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Dictionary<String, ReverseIteratorOrderedDictionary<Integer, OrderedDictionary<String, Home>>> propertiesLocal;
	
	public PropertiesPerFeedbackClass() {
		// TODO Auto-generated constructor stub
		this.propertiesLocal = new ChainedHashTable<String, ReverseIteratorOrderedDictionary<Integer, OrderedDictionary<String, Home>>>(10);
	}
	
	@Override
	public Home add(Home home) {
		// TODO Auto-generated method stub
		if(home==null)
			return null;
		ReverseIteratorOrderedDictionary<Integer, OrderedDictionary<String, Home>> propertiesFeedback = propertiesLocal.find(home.getLocal().toUpperCase());
		if(propertiesFeedback==null){
			propertiesFeedback = new ReverseIteratorBST<Integer, OrderedDictionary<String,Home>>();
			OrderedDictionary<String,Home> propertiesIds = new BinarySearchTree<String, Home>();
			propertiesIds.insert(home.getHomeID(), home);
			propertiesFeedback.insert(home.getFeedback(), propertiesIds);
			propertiesLocal.insert(home.getLocal().toUpperCase(), propertiesFeedback);
			return null;
		}
		
		OrderedDictionary<String,Home> propertiesIds = propertiesFeedback.find(home.getFeedback());
		if(propertiesIds==null){
			propertiesIds = new BinarySearchTree<String, Home>();
			propertiesIds.insert(home.getHomeID(), home);
			propertiesFeedback.insert(home.getFeedback(), propertiesIds);
			return null;
		}
		
		return propertiesIds.insert(home.getHomeID(), home);
		
	}

	@Override
	public Home remove(Home home) {
		// TODO Auto-generated method stub
		if(home==null)
			return null;
		ReverseIteratorOrderedDictionary<Integer, OrderedDictionary<String, Home>> propertiesFeedback = propertiesLocal.find(home.getLocal().toUpperCase());
		if(propertiesFeedback==null)
			return null;
		OrderedDictionary<String, Home> propertiesIds = propertiesFeedback.find(home.getFeedback());
		if(propertiesIds==null)
			return null;
		Home removed =  propertiesIds.remove(home.getHomeID());
		if(propertiesIds.isEmpty())
			propertiesFeedback.remove(home.getFeedback());
		if(propertiesFeedback.isEmpty())
			propertiesLocal.remove(home.getLocal().toUpperCase());
	
		return removed;
	}
	
	
	@Override
	public void update(Home home, int feedback) {
		// TODO Auto-generated method stub
		Home h = remove(home);
		if(h!=null){
		h.newVisit(feedback);
		add(h);
		}
	}

	
	@Override
	public Iterator<HomeInfo> iterator(String local) throws NoResultsException{
		// TODO Auto-generated method stub
		ReverseIteratorOrderedDictionary<Integer, OrderedDictionary<String, Home>> propertiesFeedback = propertiesLocal.find(local.toUpperCase());
		if(propertiesFeedback==null || propertiesFeedback.isEmpty())
			throw new NoResultsException();
		return new PropertiesPerFeedBackIterator(propertiesFeedback);
	}



}
