package HomeAway;

import java.io.Serializable;

/**
 * Home interface, extends HomeInfo
 * Represents an house in the system.
 * Stores and gives information about the house.
 * Allows to update information about the house.
 * @see HomeInfo interface for more details.
 * 
 * @author Joao Monteiro (51105) jg.monteiro@campus.fct.unl.pt
 * @author Diogo Tavares (50309) dc.tavares@campus.fct.unl.pt
 */
public interface Home extends HomeInfo, Serializable{
	
	/**
	 * Use this method when an home is visited by an user
	 * Sets the house has visited
	 * @see hasBeenVisited in HouseInfo interface for more information.
	 */
	void newVisit();
}
