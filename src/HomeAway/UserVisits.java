package HomeAway;

import java.io.Serializable;

/**
 * In this phase, you can only have one User and one Home so we can simply store the home that has been visited and how many visits the user has made.
 * This class stores that information.
 * 
 * @author Diogo Tavares (50309) dc.tavares@campus.fct.unl.pt
 * @author Joao Monteiro (51105) jg.monteiro@campus.fct.unl.pt
 */
public class UserVisits implements Serializable{

	private Home home;
	private int timesVisited;
	
	/**
	 * 
	 * @param home Property the user visits.
	 */
	public UserVisits(Home home) {
		this.home = home;
		this.timesVisited = 0;
	}
	
	/**
	 * @return the home which user has visited
	 */
	public Home getHome(){
		return home;
	}
	
	/**
	 * @return the amount of visits to the property
	 */
	public int getVisitations(){
		return timesVisited;
	}
	
	/**
	 * Increments the counter to register new visit
	 */
	protected void newVisit(){
		timesVisited++;
	}
}
