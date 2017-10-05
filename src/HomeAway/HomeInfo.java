package HomeAway;

import java.io.Serializable;

/**
 * HomeInfo interface
 * Represents an house in the system.
 * Stores and gives information about this house
 * Does NOT allow to makes changes to this house information
 * 
 * @author Joao Monteiro
 */
public interface HomeInfo extends Serializable{
	
	/**
	 * Information
	 * @return Name of this house owner
	 */
	String getOwnerName();
	
	/**
	 * Information
	 * @return System identification of owner of this house
	 */
	String getOwnerID();
	
	/**
	 * Information
	 * @return System identification of this house
	 */
	String getHomeID();
	
	/**
	 * Information
	 * @return House's location
	 */
	String getLocal();
	
	/**
	 * Information
	 * @return House's address
	 */
	String getAddress();
	
	/**
	 * Information
	 * @return House description
	 */
	String getDescription();
	
	/**
	 * Information
	 * @return Maximum number of people that can stay in the house
	 */
	int getCapacity();
	
	/**
	 * Information
	 * @return Cost(price) to stay in this house
	 */
	int getPrice();
	
	/**
	 * Information
	 * When an house is visited, the user who makes the visit (unless it's his own house) leaves feedback on the house, the higher the better
	 * @return House's score given by the visitors
	 */
	int getScore();
	
	/**
	 * Information
	 * @return True if someone have already stayed in this house, false otherwise
	 */
	boolean hasBeenVisited();
	
}
