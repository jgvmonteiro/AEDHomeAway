package homeAway;

import homeAway.exceptions.*;
import java.io.Serializable;

import dataStructures.*;

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
	private Dictionary<String, User> users;
	private Dictionary<String, Home> properties;
	private Dictionary<String, Home> propertiesLocal;
	private static final int MAX_PEOPLE_PEER_PROPERTY = 20;
	
	public HomeAwayClass() {
		this.users = new ChainedHashTable<String, User>(10000);
		this.properties = new ChainedHashTable<String, Home>(5000);
		this.propertiesLocal = new ChainedHashTable<String, Home>(5000);
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
		User user = users.find(userID);
		if(user == null)
			throw new UserDoesNotExistsException();
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
		Home home = properties.find(homeID);
		if(home==null)
			throw new HomeDoesNotExistsException();
		return home;
	}	

	@Override
	public void addUser(String userID, String email, String phone, String name, String nationality, String address) throws UserAlreadyExistsException {
		if(hasUser(userID))
			throw new UserAlreadyExistsException();
		User user = new UserClass(userID, name, email, phone, nationality, address);
		users.insert(userID, user);
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
			throw new UserHasHomeToRent();
		users.remove(userID);
	}

	@Override
	public UserInfo getUserInfo(String userID) throws UserDoesNotExistsException {
		return getUser(userID);
	}

	@Override
	public void addHome(String homeID, String userID, int price, int people, String address, String local, String description) throws HomeAlreadyExistsException, InvalidDataException, UserDoesNotExistsException {
	   User user = getUser(userID);
	   if(hasHome(homeID))
		   throw new HomeAlreadyExistsException();
	   if(price < 1 || people < 1 || people > MAX_PEOPLE_PEER_PROPERTY)
		   throw new InvalidDataException();
	   Home home = new HomeClass(homeID, user, local, address, description, price, people);
	   user.newPropertyToRent(home);
	   properties.insert(homeID, home);
	   propertiesLocal.insert(local, home);
	}

	@Override
	public void removeHome(String homeID) throws HomeDoesNotExistsException, HomeAlreadyVisitedException {
		Home home = properties.remove(homeID);	//checking if home exists
		if(home == null)
			throw new HomeDoesNotExistsException();
		
		propertiesLocal.remove(home.getLocal());
		if(home.hasBeenVisited())
			throw new HomeAlreadyVisitedException();
		
		home.getOwner().newPropertyToRent(null);
	}

	@Override
	public HomeInfo getHomeInfo(String homeID) throws HomeDoesNotExistsException {
		return getHome(homeID);
	}

	@Override
	public void rentHome(String userID, String homeID, int feedback) throws UserDoesNotExistsException, HomeDoesNotExistsException, InvalidDataException, UserIsOwnerException {
		if(feedback < 1)
			throw new InvalidDataException();
		User user = getUser(userID); 
		Home home = getHome(homeID);  
		if(home.getOwner() == user) //Posso comparar as referencias???
			throw new UserIsOwnerException(); //are correctly throw if the method is called
		user.newVisit(home);
		home.newVisit(feedback);
	}

	@Override
	public void rentOwnHome(String userID, String homeID) throws UserDoesNotExistsException, HomeDoesNotExistsException, UserIsNotOwnerException {
		User user = getUser(userID); //Verifies if ids are valid first, if not throwns exception
		Home home = getHome(homeID); 
	   if(home.getOwner() != user)	 //
		   throw new UserIsNotOwnerException(); 
	    user.newVisit(home);
		home.newVisit();	  
	}

	@Override
	public HomeInfo getUserProperties(String userID) throws UserDoesNotExistsException, UserIsNotOwnerException {
		return getUser(userID).getPropertyToRent();
	}

	@Override 
	public Iterator<HomeInfo> getUserVisits(String userID) throws UserDoesNotExistsException, UserHasNotVisitedException{
		return getUser(userID).getUserVisits(); 
	}

	@Override
	public HomeInfo searchHome(int capacity, String local) throws InvalidDataException, NoResultsException {
		if(capacity < 1 || capacity > 20) throw new InvalidDataException();
		Home home = propertiesLocal.find(local);
		if(home !=null && home.getCapacity() >= capacity && home.getLocal().toUpperCase().contains(local.toUpperCase()))
			return home;
		else throw new NoResultsException();
	}

	@Override
	public HomeInfo topHomes(String local) throws NoResultsException {
		Home h = propertiesLocal.find(local);
		if(h == null)
			throw new NoResultsException();
		
		return h;
	}
	
	

}
