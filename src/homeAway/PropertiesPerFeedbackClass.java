package homeAway;

import dataStructures.AVLTree;
import dataStructures.ChainedHashTable;
import dataStructures.Dictionary;
import dataStructures.Iterator;
import dataStructures.OrderedDictionary;
import homeAway.exceptions.NoResultsException;

class PropertiesPerFeedbackClass implements PropertiesPerFeedback {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Dictionary<String, OrderedDictionary<FeedbackKey, OrderedDictionary<String, Home>>> propertiesLocal;
	
	public PropertiesPerFeedbackClass() {
		// TODO Auto-generated constructor stub
		this.propertiesLocal = new ChainedHashTable<String, OrderedDictionary<FeedbackKey, OrderedDictionary<String, Home>>>(10);
	}
	
	@Override
	public Home add(Home home) {
		// TODO Auto-generated method stub
		if(home==null)
			return null;
		OrderedDictionary<FeedbackKey, OrderedDictionary<String, Home>> propertiesFeedback = propertiesLocal.find(home.getLocal().toUpperCase());
		if(propertiesFeedback==null){
			propertiesFeedback = new AVLTree<FeedbackKey, OrderedDictionary<String,Home>>();
			OrderedDictionary<String,Home> propertiesIds = new AVLTree<String, Home>();
			propertiesIds.insert(home.getHomeID(), home);
			propertiesFeedback.insert(new FeedbackKey(home.getFeedback()), propertiesIds);
			propertiesLocal.insert(home.getLocal().toUpperCase(), propertiesFeedback);
			return null;
		}
		int a = 0;
		if(home.getFeedback()==14 || home.getHomeID().equalsIgnoreCase("lisboa"))
			a=234;
		OrderedDictionary<String,Home> propertiesIds = propertiesFeedback.find(new FeedbackKey(home.getFeedback()));
		if(propertiesIds==null){
			propertiesIds = new AVLTree<String, Home>();
			propertiesIds.insert(home.getHomeID(), home);
			propertiesFeedback.insert(new FeedbackKey(home.getFeedback()), propertiesIds);
			return null;
		}
		
		return propertiesIds.insert(home.getHomeID(), home);
		
	}

	@Override
	public Home remove(Home home) {
		// TODO Auto-generated method stub
		if(home==null)
			return null;
		OrderedDictionary<FeedbackKey, OrderedDictionary<String, Home>> propertiesFeedback = propertiesLocal.find(home.getLocal().toUpperCase());
		if(propertiesFeedback==null)
			return null;
		OrderedDictionary<String, Home> propertiesIds = propertiesFeedback.find(new FeedbackKey(home.getFeedback()));
		if(propertiesIds==null)
			return null;
		Home removed =  propertiesIds.remove(home.getHomeID());
		if(propertiesIds.isEmpty())
			propertiesFeedback.remove(new FeedbackKey(home.getFeedback()));
		if(propertiesFeedback.isEmpty())
			propertiesLocal.remove(home.getLocal().toUpperCase());
	
		return removed;
	}
	
	
	@Override
	public void update(Home home, int feedback) {
		// TODO Auto-generated method stub
		int a = 2;
		if(home.getFeedback()+feedback==14 && home.getHomeID().equalsIgnoreCase("casag"))
			a = 234;
		Home h = remove(home);
		if(h!=null){
			h.newVisit(feedback);
			add(h);
		}
	}

	
	@Override
	public Iterator<HomeInfo> iterator(String local) throws NoResultsException{
		// TODO Auto-generated method stub
		OrderedDictionary<FeedbackKey, OrderedDictionary<String, Home>> propertiesFeedback = propertiesLocal.find(local.toUpperCase());
		if(propertiesFeedback==null || propertiesFeedback.isEmpty())
			throw new NoResultsException();
		return new PropertiesPerFeedBackIterator(propertiesFeedback);
	}



}
