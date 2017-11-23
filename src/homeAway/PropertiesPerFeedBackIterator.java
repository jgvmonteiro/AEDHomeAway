package homeAway;

import dataStructures.Dictionary;
import dataStructures.Entry;
import dataStructures.Iterator;
import dataStructures.NoSuchElementException;
import dataStructures.OrderedDictionary;
import dataStructures.ReverseIteratorOrderedDictionary;

public class PropertiesPerFeedBackIterator implements Iterator<HomeInfo> {

	
	ReverseIteratorOrderedDictionary<Integer, OrderedDictionary<String, Home>> propertiesFeeback;
	Iterator<Entry<Integer, OrderedDictionary<String, Home>>> feedbackIt;
	Iterator<Entry<String, Home>> currentPropertiesIt;
	
	public PropertiesPerFeedBackIterator(ReverseIteratorOrderedDictionary<Integer, OrderedDictionary<String, Home>> propertiesFeeback) {
		// TODO Auto-generated constructor stub
		this.propertiesFeeback = propertiesFeeback;
		
		rewind();
	}
	
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return currentPropertiesIt!=null && currentPropertiesIt.hasNext();
	}

	@Override
	public HomeInfo next() throws NoSuchElementException {
		// TODO Auto-generated method stub
		if(!hasNext())
			throw new NoSuchElementException();
		
		Entry<String, Home> entry = currentPropertiesIt.next();
		if(!currentPropertiesIt.hasNext())
			if(feedbackIt.hasNext())
				currentPropertiesIt = feedbackIt.next().getValue().iterator();

		return entry.getValue();
	}

	@Override
	public void rewind() {
		// TODO Auto-generated method stub
		feedbackIt = propertiesFeeback.reverseIterator();
		if(feedbackIt.hasNext())
			currentPropertiesIt = feedbackIt.next().getValue().iterator();
	}

}
