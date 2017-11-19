package homeAway;

import dataStructures.Iterator;
import dataStructures.Stack;
import dataStructures.IteratorStackInList;
import dataStructures.OrderedList;
import dataStructures.OrderedTreeList;
import homeAway.exceptions.UserHasNotVisitedException;
import homeAway.exceptions.UserIsNotOwnerException;

/**
 * User implementation class.
 * The description of the methods is provided in the interface implemented.
 * @see User for more information.
 * 
 * @author Diogo Tavares (50309) dc.tavares@campus.fct.unl.pt
 * @author Joao Monteiro (51105) jg.monteiro@campus.fct.unl.pt
 */
class UserClass implements User{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userID, email, phone, name, nationality, address;
	//private SortedList<HomeInfo> homesToRent;
	private OrderedList<String, HomeInfo> homesToRent;
	private Stack<HomeInfo> visits;
	
	public UserClass(String userID, String name, String email, String phone, String nationality, String address) {
		this.userID = userID;
		this.email = email;
		this.phone = phone;
		this.name = name;
		this.nationality = nationality;
		this.address = address;
		this.homesToRent = new OrderedTreeList<String, HomeInfo>();
		this.visits = new IteratorStackInList<HomeInfo>();
	}

	@Override
	public String getID() {
		return userID;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public String getPhone() {
		return phone;
	}

	@Override
	public String getNationality() {
		return nationality;
	}

	@Override
	public String getAddress() {
		return address;
	}

	@Override
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public void setPhone(String phone) {
		this.phone = phone;
	}
   
	@Override
	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public void newPropertyToRent(Home home){
		homesToRent.insert(home.getHomeID(), home);
	}
	
	@Override
	public boolean removeProperty(Home home) {
		return homesToRent.remove(home.getHomeID())==null?false:true;
	}
	
	@Override
	public boolean hasPropertyToRent() {
		return !homesToRent.isEmpty();
	}
	
	@Override
	public Iterator<HomeInfo> getPropertiesToRent() throws UserIsNotOwnerException{
		if(!hasPropertyToRent())
			throw new UserIsNotOwnerException();
		return homesToRent.iteratorValues();
	}
	
	@Override
	public void newVisit(Home home){
		if(visits == null)
			visits = new IteratorStackInList<HomeInfo>();
		
		visits.push(home);
	}

	@Override
	public boolean hasVisited() {
		return !visits.isEmpty();
	}

	@Override
	public Iterator<HomeInfo> getUserVisits() throws UserHasNotVisitedException{
		if(visits.isEmpty())
			throw new UserHasNotVisitedException();
		IteratorStackInList<HomeInfo> v = (IteratorStackInList<HomeInfo>) visits;
		return v.iterator();
	}

	
}
