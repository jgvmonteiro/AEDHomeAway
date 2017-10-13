package homeaway;

import homeAway.exceptions.UserHasNotVisitedException;
import homeAway.exceptions.UserIsNotOwnerException;
import java.io.Serializable;

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
	 * @return Property owner by the user available for other users(or himself) to rent.
	 * @throws UserIsNotOwnerException User doesn't have any property available for rent.
	 */
	Home getPropertyToRent() throws UserIsNotOwnerException;
	
	/**
	 * 
	 * @return True if user has visited a property.
	 */
	boolean hasVisited();
	
	/**
	 * 
	 * @return UserVists object, contains information about all properties the user has visited.
	 * @throws UserHasNotVisitedException User hasn't stayed in any property.
	 */
	UserVisits getUserVisits() throws UserHasNotVisitedException;
	

	
}
