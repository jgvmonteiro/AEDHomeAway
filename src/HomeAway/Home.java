package HomeAway;

import java.io.Serializable;

/**
 *
 * @author Joao Monteiro
 */
public interface Home extends HomeInfo, Serializable{
	
	void newRent();
}
