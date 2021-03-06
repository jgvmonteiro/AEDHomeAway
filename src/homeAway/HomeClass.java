package homeAway;

/**
 * Home implementation class.
 * The description of the methods is provided in the interface implemented.
 * @see Home for more information.
 * 
 * @author Diogo Tavares (50309) dc.tavares@campus.fct.unl.pt
 * @author Joao Monteiro (51105) jg.monteiro@campus.fct.unl.pt
 */
class HomeClass implements Home{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String homeID, local, address, description;
	private User owner;
	private int price, capacity, feedback;
	private boolean visited;

	public HomeClass(String homeID, User owner, String local, String address, String description, int price, int capacity) {
		this.address = address;
		this.homeID = homeID;
		this.owner = owner;
		this.local = local;
		this.description = description;
		this.price = price;
		this.capacity = capacity;
		this.feedback = 0;
		this.visited = false;
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
	public void newVisit(){
		this.visited = true;
	}

	@Override
	public void newVisit(int feedback) {
		this.visited = true;
		this.feedback += feedback;
	}

	@Override
	public User getOwner() {
		return owner;
	}

	@Override
	public int getFeedback() {
		return this.feedback;
	}
	
	
	
}
