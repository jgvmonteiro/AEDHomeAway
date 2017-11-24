package homeAway;

import dataStructures.Iterator;

public interface PropertiesPerFeedback {

	 Home add(Home home);
	 
	 Home remove(Home home);
	 
	 void update(Home home, int feedback);
	 
	 Iterator<HomeInfo> iterator(String local);
	 
}
