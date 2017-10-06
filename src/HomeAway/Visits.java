package HomeAway;

import java.io.Serializable;

/**
 * 
 * @author chaos_
 */
public class Visits implements Serializable{

	private Home home;
	private int timesVisited;
	
	public Visits(Home home) {
		this.home = home;
		this.timesVisited = 0;
	}

	public Home getHome(){
		return this.home;
	}
	
	public int getVisitations(){
		return this.timesVisited;
	}
	
	protected void newVisit(){
		this.timesVisited++;
	}
}
