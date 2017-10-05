package HomeAway;

import java.io.Serializable;

/**
 * HomeInfo interface.
 * Represents a property in the system.
 * Stores and gives information about the property.
 * Does NOT allow to makes changes to the property information.
 * 
 * @author Diogo Tavares (50309) dc.tavares@campus.fct.unl.pt
 * @author Joao Monteiro (51105) jg.monteiro@campus.fct.unl.pt
 */
public interface HomeInfo extends Serializable{
	
	/**
	 * Information.
	 * @return Name of this property owner.
	 */
	String getOwnerName();
	
	/**
	 * Information.
	 * @return System identification of owner of the property.
	 */
	String getOwnerID();
	
	/**
	 * Information.
	 * @return System identification of the property.
	 */
	String getHomeID();
	
	/**
	 * Information.
	 * @return Property's location.
	 */
	String getLocal();
	
	/**
	 * Information.
	 * @return Property's address.
	 */
	String getAddress();
	
	/**
	 * Information.
	 * @return Property description.
	 */
	String getDescription();
	
	/**
	 * Information.
	 * @return Maximum number of people that can stay in the property.
	 */
	int getCapacity();
	
	/**
	 * Information.
	 * @return Cost(price) to stay in the property.
	 */
	int getPrice();
	
	/**
	 * Information.
	 * When an Property is visited, the user who makes the visit (unless it's his own property) leaves feedback on the property, the higher the better.
	 * @return Property's score given by the visitors.
	 */
	int getScore();
	
	/**
	 * Information.
	 * @return True if someone have already stayed in the property, false otherwise.
	 */
	boolean hasBeenVisited();
	
}
