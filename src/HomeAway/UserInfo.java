package HomeAway;

import java.io.Serializable;
import java.util.Iterator;

/**
 *
 * @author Joao Monteiro
 */
public interface UserInfo extends Serializable{

	
	String getID();
	String getName();
	String getEmail();
	String getPhone();
	String getNationality();
	String getAddress();
	Home getHomeToRent();
	Home[] getVisitedHomes();
	boolean hasHomeToRent();
	int visitedHomesCount();
}
