package HomeAway;

import java.io.Serializable;
import java.util.Iterator;

/**
 *
 * @author Joao Monteiro
 */
public interface User extends UserInfo, Serializable{

	void setHomeToRent(Home home);
	void newRent(Home home);
	
}
