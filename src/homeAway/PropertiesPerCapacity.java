package homeAway;

import java.io.Serializable;

import dataStructures.Iterator;
import homeAway.exceptions.NoResultsException;

/**
 * PropertiesPerCapacity interface.
 * Data structure to store properties.
 * Stores the properties in such way to optimize a search given a minimum capacity and a local. 
 * (Used in implementation of the method searchHome in HomeAway interface)
 * 
 * @author Diogo Tavares (50309) dc.tavares@campus.fct.unl.pt
 * @author Joao Monteiro (51105) jg.monteiro@campus.fct.unl.pt
 */
interface PropertiesPerCapacity extends Serializable{

	/**
	 * Inserts a property to the structure.
	 * 
	 * @param home property to stored
	 */
	void add(HomeInfo home);
	
	/**
	 * Removes a property from the structure
	 * 
	 * @param home property to be removed
	 * @return true if the property exists and is removed, false otherwise
	 */
	boolean remove(HomeInfo home);
	
	/**
	 * 
	 * @param capacity minimum number of people the property must allow to stay
	 * @param local property's local
	 * @return Iterator with the properties given the specified restriction, elements are ordered from lower capacity to higher
	 * @throws NoResultsException No properties found that match the given restrictions
	 */
	Iterator<HomeInfo> iterator(int capacity, String local) throws NoResultsException;


	
	
	
}
