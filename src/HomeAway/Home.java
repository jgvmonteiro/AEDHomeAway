package HomeAway;

import java.io.Serializable;

/**
 * Home interface, extends HomeInfo
 * Represents a property in the system.
 * Stores and gives information about the property.
 * Allows to update information about the property.
 * @see HomeInfo interface for more details.
 * 
 * @author Diogo Tavares (50309) dc.tavares@campus.fct.unl.pt
 * @author Joao Monteiro (51105) jg.monteiro@campus.fct.unl.pt
 */
public interface Home extends HomeInfo, Serializable{
	
	/**
	 * Use this method when the property is visited by an user.
	 * Sets the property has visited.
	 * @see hasBeenVisited in HouseInfo interface for more information.
	 */
	void newVisit();
}
