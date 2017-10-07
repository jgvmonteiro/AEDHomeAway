package HomeAway;

import java.io.Serializable;

/**
 * In the current phase, as you can only have one User and one Home, instead of a home array to store the 
 * user's visits, you can simply store the home that was visited and the amount of visitations.
 * This class stores that information.
 * @author chaos_
 */
public class Visits implements Serializable{

	private Home home;
	private int timesVisited;
	
	public Visits(Home home) {
		this.home = home;
		this.timesVisited = 0;
	}
	
	/**
	 * @return the home which was visited
	 */
	public Home getHome(){
		return home;
	}
	
	/**
	 * @return the amount of visits to home
	 */
	public int getVisitations(){
		return timesVisited;
	}
	
	/**
	 * Increments the visit counter
	 */
	protected void newVisit(){
		timesVisited++;
	}
}
