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

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;  //Phase 1 no need for lists since the system will only have one user and one property.
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
			getHome(homeID);
			return true;
		} catch (HomeDoesNotExistsException e) {
			return false;
		}
	}
	
	private Home getHome(String homeID) throws HomeDoesNotExistsException{
		if(home==null || !home.getHomeID().equalsIgnoreCase(homeID))
			throw new HomeDoesNotExistsException("Given property ID not found in the system.");
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
		if(getUser(userID).hasPropertyToRent())
			throw new UserHasHomeToRent("Attempt to remove a user who has properties available for rent.");
		this.user = null;
	}

	@Override
	public UserInfo getUserInfo(String userID) throws UserDoesNotExistsException {
		return getUser(userID);
	}

	@Override
	public void addHome(String homeID, String userID, int price, int people, String address, String local, String description) throws HomeAlreadyExistsException, InvalidDataException, UserDoesNotExistsException {
	   User user = getUser(userID);
	   if(hasHome(homeID))
		   throw new HomeAlreadyExistsException("Attempt to add an home that already exists.");
	   if(price < 1 || people < 1 || people > MAX_PEOPLE_PEER_PROPERTY)
		   throw new InvalidDataException("Invalid price or capacity.");
	   Home h = new HomeClass(homeID, user, local, address, description, price, people);
	   user.newPropertyToRent(h);
	   this.home = h;
	}

	@Override
	public void removeHome(String homeID) throws HomeDoesNotExistsException, HomeAlreadyVisitedException {
		getHome(homeID);	//checking if home exists
		if(user.getPropertyToRent().hasBeenVisited())
			throw new HomeAlreadyVisitedException("Attempt to remove an home that has already a visit.");
		user.newPropertyToRent(null);
		this.home = null;
	}

	@Override
	public HomeInfo getHomeInfo(String homeID) throws HomeDoesNotExistsException {
		return getHome(homeID);
	}

	@Override
	public void rentHome(String userID, String homeID, int feedback) throws UserDoesNotExistsException, HomeDoesNotExistsException, InvalidDataException, UserIsOwnerException {
		if(feedback < 1)
			throw new InvalidDataException("Invalid feedback value, must be greater than 0.");
		getUser(userID); //Phase 1 there's only one user and one home so
		getHome(homeID);   //this method should never be called. Anyway this lines are here just to make sure the exception 
		throw new UserIsOwnerException("User attempted to evaluate his own home."); //are correctly throw if the method is called
		//user.newVisit(home);
		//home.newVisit(feedback);
	}

	@Override
	public void rentOwnHome(String userID, String homeID) throws UserDoesNotExistsException, HomeDoesNotExistsException, UserIsNotOwnerException {
		User user = getUser(userID); //Verifies if ids are valid first, if not throwns exception
		Home home = getHome(homeID);
	   if(!home.getOwnerID().equalsIgnoreCase(user.getID()))	 //Phase 1 this exception shloud never be thrown....
		   throw new UserIsNotOwnerException("Property does is not owned by the user, must supply feedback."); 
	    user.newVisit(home);
		home.newVisit();	  
	}

	@Override
	public HomeInfo getUserProperties(String userID) throws UserDoesNotExistsException, UserIsNotOwnerException {
		return getUser(userID).getPropertyToRent();
	}

	@Override
	public UserVisits getUserVisits(String userID) throws UserDoesNotExistsException, UserHasNotVisitedException{
		return getUser(userID).getUserVisits();
	}

	@Override
	public HomeInfo searchHome(int capacity, String local) throws InvalidDataException, NoResultsException {
		if(capacity < 1 || capacity > 20) throw new InvalidDataException("Property capacity must be a value between 1 and 20.");
		if(home !=null && home.getCapacity() >= capacity && this.home.getLocal().toUpperCase().contains(local.toUpperCase()))
			return this.home;
		else throw new NoResultsException("Local or people don't match an home in the system.");
	}

	@Override
	public HomeInfo topHomes(String local) throws NoResultsException {
		if(home != null && this.home.getLocal().toUpperCase().contains(local.toUpperCase()))
			return this.home;
		else throw new NoResultsException("No homes exist in the given local.");
	}
	
	

}
