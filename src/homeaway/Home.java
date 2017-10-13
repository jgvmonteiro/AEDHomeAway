package homeaway;

import java.io.Serializable;

/**
 * Home interface.
 * Represents a property in the system.
 * Stores and gives information about the property.
 * Allows to change information about the property.
 * @see HomeInfo interface for information.
 * 
 * @author Diogo Tavares (50309) dc.tavares@campus.fct.unl.pt
 * @author Joao Monteiro (51105) jg.monteiro@campus.fct.unl.pt
 */
public interface Home extends HomeInfo, Serializable{
	
	/**
	 * Use this method when the property is visited by the owner.
	 * Sets the property has visited.
	 * @see hasBeenVisited in HouseInfo interface for more information.
	 */
	void newVisit();
	
	/**
	 * Use this method when the property is visited by a user that doesn't own the property.
	 * Sets the property has visited.
	 * @param feedback The feedback of the user on the property.
	 * @see hasBeenVisited in HouseInfo interface for more information.
	 */
	void newVisit(int feedback);
}
