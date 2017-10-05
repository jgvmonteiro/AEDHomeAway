package HomeAway;

/**
 * Home class.
 * Used to create a new Home object in the system.
 * The description of the methods is provided in the interface implemented.
 * @see HomeInfo for more information.
 * 
 * @author Joao Monteiro (51105) jg.monteiro@campus.fct.unl.pt
 * @author Diogo Tavares (50309) dc.tavares@campus.fct.unl.pt
 */
public class HomeClass implements Home{

	private String homeID, local, address, description;
	private User owner;
	private int price, capacity, score;
	private boolean visited;

	public HomeClass(String homeID, User owner, String local, String address, String description, int price, int capacity) {
		this.address = address;
		this.homeID = homeID;
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
		return owner.getID();
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
	public String getDescription() {
		return this.description;
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
	public boolean hasBeenVisited() {
		return visited;
	}

	@Override
	public int getScore() {
		return score;
	}
	
	@Override
	public void newVisit(){
		this.visited = true;
	}
	
}
