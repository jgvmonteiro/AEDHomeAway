package HomeAway;

import java.io.Serializable;
import java.util.Iterator;

/**
 *
 * @author Joao Monteiro
 */
public interface User extends UserInfo, Serializable{

	
	void setEmail(String email);
	void setPhone(String phone);  
	void setAddress(String address);
	void incVisitedAmount();
	void setHomeToRent(Home home);
	void newRent(Home home);
	
}
