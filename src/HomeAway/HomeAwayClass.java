package HomeAway;

import HomeAway.Exceptions.*;
import java.io.Serializable;

/**
 * HomeAway implementation class.
 * The description of the methods is provided in the interface implemented.
 * @see HomeAway for more information.
 * 
 * @author Diogo Tavares (50309) dc.tavares@campus.fct.unl.pt
 * @author Joao Monteiro (51105) jg.monteiro@campus.fct.unl.pt
 */
public class HomeAwayClass implements HomeAway, Serializable{

	private User user;  
	private Home home;
	private static final int MAX_PEOPLE_PEER_PROPERTY = 20;
	
	public HomeAwayClass() {
		
	}
	
	private boolean hasUser(String userID){
		try {
			getUser(userID);
			return true;
		} catch (UserDoesNotExistsException e) {
			return false;
		}
	}
	
	private User getUser(String userID) throws UserDoesNotExistsException{
		if(user == null || !user.getID().equalsIgnoreCase(userID))
			throw new UserDoesNotExistsException("Given user ID not found in the system.");
		return user;
	}
	
	private boolean hasHome(String homeID){
		try {
			getProperty(homeID);
			return true;
		} catch (HomeDoesNotExistsException e) {
			return false;
		}
	}
	
	private Home getProperty(String homeID) throws HomeDoesNotExistsException{
		if(home==null || !home.getHomeID().equalsIgnoreCase(homeID))
			throw new HomeDoesNotExistsException("Given home ID not found in the system.");
		return home;
	}
	
	

	@Override
	public void addUser(String userID, String email, String phone, String name, String nationality, String address) throws UserAlreadyExistsException {
		if(hasUser(userID))
			throw new UserAlreadyExistsException("Insert user ID already existed in the system.");
		User user = new UserClass(userID, name, email, phone, nationality, address);
		this.user = user;
	}
	
	@Override
	public void editUser(String userID, String email, String phone, String address) throws UserDoesNotExistsException {
		User user = getUser(userID);
		user.setAddress(address);
		user.setEmail(email);
		user.setPhone(phone);
	}

	@Override
	public void removeUser(String userID) throws UserDoesNotExistsException, UserHasHomeToRent {
		User user = getUser(userID);
		if(user.hasPropertyToRent())
			throw  new UserHasHomeToRent("Attempt to remove a user who has homes to rent.");
		this.user = null;
	}

	@Override
	public UserInfo getUserInfo(String userID) throws UserDoesNotExistsException {
		User user = getUser(userID);
		return user;
	}

	@Override
	public void addHome(String homeID, String userID, int price, int people, String address, String local, String description) throws HomeAlreadyExistsException, InvalidDataException, UserDoesNotExistsException {
	   User user = getUser(userID);
	   if(hasHome(homeID))
		   throw new HomeAlreadyExistsException("Attempt to add an home that already exists.");
	   if(price <= 0 || people <= 0 || people > MAX_PEOPLE_PEER_PROPERTY)
		   throw new InvalidDataException("Invalid price or capacity.");
	   Home h = new HomeClass(homeID, user, local, address, description, price, people);
	   user.newPropertyToRent(h);
	   this.home = h;
	}

	@Override
	public void removeHome(String homeID) throws HomeDoesNotExistsException, HomeAlreadyVisited {
		Home home = getProperty(homeID);
		if(user.getPropertyToRent().hasBeenVisited())
			throw new HomeAlreadyVisited("Attempt to remove an home that has already a visit.");
		user.newPropertyToRent(null);
		this.home = null;
	}

	@Override
	public HomeInfo getHomeInfo(String homeID) throws HomeDoesNotExistsException {
		Home home = getProperty(homeID);
		return home;
	}

	@Override
	public void rentHome(String userID, String homeID, int feedback) throws UserDoesNotExistsException, HomeDoesNotExistsException, InvalidDataException, UserIsOwnerException {
		if(feedback <= 0)
			throw new InvalidDataException("Invalid input data.");
		User user = getUser(userID);
		Home home = getProperty(homeID);
		throw new UserIsOwnerException("User attempted to evaluate his own home.");
	   //((HomeClass)home).newRent();
	}

	@Override
	public void rentOwnHome(String userID, String homeID) throws UserDoesNotExistsException, HomeDoesNotExistsException, UserIsNotOwnerException {
		User user = getUser(userID);
		Home home = getProperty(homeID);
	   //O QUE FAZER À EXCEPTCAO????
	   if(!home.getOwnerID().equalsIgnoreCase(user.getID()))
		   throw new UserIsNotOwnerException("Cannot rent this home without a avaluation.");
	   home.newVisit();
	   user.newVisit(home);
	}

	@Override
	public HomeInfo getUserProperties(String userID) throws UserDoesNotExistsException, UserIsNotOwnerException {
		User user = getUser(userID);
		if(!user.hasPropertyToRent())
			throw new UserIsNotOwnerException("Utilizador nao e proprietario.");
		return home;
	}

	@Override
	public UserVisits getUserVisits(String userID) throws UserDoesNotExistsException, UserIsNotOwnerException {
		User user = getUser(userID);;
		if(user.getUserVisits()==null)
			throw new UserIsNotOwnerException("Utilizador nao e proprietario.");
		return user.getUserVisits();
	}

	@Override
	public HomeInfo searchHome(int capacity, String local) throws InvalidDataException, NoResultsException {
		if(capacity < 1 || capacity > 20) throw new InvalidDataException("capacity is negative");
		if(home !=null && home.getCapacity() >= capacity && this.home.getLocal().toUpperCase().contains(local.toUpperCase()))
			return this.home;
		else throw new NoResultsException("Local or people don't match the home in our system");
	}

	@Override
	public HomeInfo topHomes(String local) throws NoResultsException {
		if(home != null && this.home.getLocal().toUpperCase().contains(local.toUpperCase()))
			return this.home;
		else throw new NoResultsException("Our home's local doesn't match the parameter local");
	}
	
	

}
