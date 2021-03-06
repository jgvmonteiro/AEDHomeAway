package homeAway;

import homeAway.exceptions.UserHasNotVisitedException;
import homeAway.exceptions.UserIsNotOwnerException;
import java.io.Serializable;

import dataStructures.Iterator;

/**
 * UserInfo interface.
 * Represents a property in the system.
 * Stores and gives information about the user.
 * Does NOT allow to makes changes to the user information.
 * 
 * @author Diogo Tavares (50309) dc.tavares@campus.fct.unl.pt
 * @author Joao Monteiro (51105) jg.monteiro@campus.fct.unl.pt
 */
public interface UserInfo extends Serializable{

	/**
	 * 
	 * @return User's ID in the system.
	 */
	String getID();
	
	/**
	 * 
	 * @return USer's name.
	 */
	String getName();
	
	/**
	 * 
	 * @return User's email.
	 */
	String getEmail();
	
	/**
	 * 
	 * @return User's phone number.
	 */
	String getPhone();
	
	/**
	 * 
	 * @return User's nationality.
	 */
	String getNationality();
	
	/**
	 * 
	 * @return User's street address.
	 */
	String getAddress();
	
	/**
	 * 
	 * @return True if user owner a property available for rent.
	 */
	boolean hasPropertyToRent();
	
	/**
	 * 
	 * @return Properties owned by the user available for other users(or himself) to rent. Ordered by the properties IDzs.
	 * @throws UserIsNotOwnerException User doesn't have any property available to rent.
	 */
	Iterator<HomeInfo> getPropertiesToRent() throws UserIsNotOwnerException;
	
	/**
	 * 
	 * @return True if user has visited a property.
	 */
	boolean hasVisited();
	
	/**
	 * 
	 * @return UserVists iterator, contains information about all properties the user has visited.
	 * @throws UserHasNotVisitedException User hasn't stayed in any property.
	 */
	Iterator<HomeInfo> getUserVisits() throws UserHasNotVisitedException; 
	

	
}
