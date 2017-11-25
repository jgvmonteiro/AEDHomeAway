package homeAway;

import java.io.Serializable;

import dataStructures.Iterator;

interface PropertiesPerFeedback extends Serializable {

	 Home add(Home home);
	 
	 Home remove(Home home);
	 
	 void update(Home home, int feedback);
	 
	 Iterator<HomeInfo> iterator(String local);
	 
}
