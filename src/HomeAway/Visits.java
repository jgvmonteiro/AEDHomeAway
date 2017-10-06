package HomeAway;

import java.io.Serializable;

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
	
	public void visit(){
		this.timesVisited++;
	}
}
