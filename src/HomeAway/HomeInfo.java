package HomeAway;

import java.io.Serializable;

/**
 *
 * @author Joao Monteiro
 */
public interface HomeInfo extends Serializable{
	
	String getOwnerName();
	String getOwnerID();
	String getHomeID();
	String getLocal();
	String getAddress();
	int getCapacity();
	int getPrice();
	int getScore();
	boolean visited();
	String getDescription();
}
