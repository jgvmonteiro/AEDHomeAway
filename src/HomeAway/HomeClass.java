package HomeAway;

import java.io.Serializable;

/**
 *
 * @author Joao Monteiro
 */
public class HomeClass implements Home{

	private String homeID, ownerID, local, address, description;
	private User owner;
	private int price, capacity, score;
	private boolean visited;

	public HomeClass(String homeID, String ownerID, User owner, String local, String address, int price, int capacity, String description) {
		this.address = address;
		this.homeID = homeID;
		this.ownerID = ownerID;
		this.owner = owner;
		this.local = local;
		this.price = price;
		this.capacity = capacity;
		this.score = 0;
		this.visited = false;
		this.description = description;
	}

	@Override
	public String getOwnerName() {
		return owner.getName();
	}

	
	
	@Override
	public String getOwnerID() {
		return ownerID;
	}

	@Override
	public String getHomeID() {
		return homeID;
	}

	@Override
	public String getLocal() {
		return local;
	}

	@Override
	public String getAddress() {
		return address;
	}
	

	@Override
	public int getCapacity() {
		return capacity;
	}

	@Override
	public int getPrice() {
		return price;
	}

	@Override
	public boolean visited() {
		return visited;
	}

	@Override
	public int getScore() {
		return score;
	}
	
	
	protected void newRent(){
		this.visited = true;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	
	
	
	
}
