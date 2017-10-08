package HomeAway;

import java.io.Serializable;

/**
 * User interface.
 * Represents a user in the system.
 * Stores and gives information about the user.
 * Allows to change information about the user.
 * @see UserInfo interface for information.
 * 
 * @author Diogo Tavares (50309) dc.tavares@campus.fct.unl.pt
 * @author Joao Monteiro (51105) jg.monteiro@campus.fct.unl.pt
 */
public interface User extends UserInfo, Serializable{

	/**
	 * @param email User's new email.
	 */
	void setEmail(String email);
	
	/**
	 * 
	 * @param phone User's new phone number.
	 */
	void setPhone(String phone);  
	
	/**
	 * 
	 * @param address User's new address.
	 */
	void setAddress(String address);
	
	/**
	 * 
	 * @param home User's property for other to rent.
	 */
	void newPropertyToRent(Home home);
	
	/**
	 * 
	 * @param home Property user has made a visit to.
	 */
	void newVisit(Home home);
	
}
