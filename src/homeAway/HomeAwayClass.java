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
	private PropertiesPerCapacity propertiesCapacitySearch;
	private static final int MAX_PEOPLE_PEER_PROPERTY = 20;
	private static final int MAX_FEEDBACK_SCORE = 20;
	private static final int MAX_EXPECTED_USERS = 10000;
	private static final int MAX_EXPECTED_PROPERTY = 5000;
	
	public HomeAwayClass() {
		this.users = new ChainedHashTable<String, User>(MAX_EXPECTED_USERS);
		this.properties = new ChainedHashTable<String, Home>(MAX_EXPECTED_PROPERTY);
		this.propertiesLocal = new ChainedHashTable<String, Home>(MAX_EXPECTED_PROPERTY);
		this.propertiesCapacitySearch = new PropertiesPerCapacityClass(MAX_PEOPLE_PEER_PROPERTY);
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
		User user = users.find(userID.toUpperCase());
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
		Home home = properties.find(homeID.toUpperCase());
		if(home==null)
			throw new HomeDoesNotExistsException();
		return home;
	}	

	@Override
	public void addUser(String userID, String email, String phone, String name, String nationality, String address) throws UserAlreadyExistsException {
		if(hasUser(userID))
			throw new UserAlreadyExistsException();
		User user = new UserClass(userID, name, email, phone, nationality, address);
		this.users.insert(userID.toUpperCase(), user);
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
		users.remove(userID.toUpperCase());
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
	   properties.insert(homeID.toUpperCase(), home);
	   propertiesLocal.insert(local.toUpperCase(), home);
	   propertiesCapacitySearch.add(home);
	}

	@Override
	public void removeHome(String homeID) throws HomeDoesNotExistsException, HomeAlreadyVisitedException {
		Home home = getHome(homeID);
		if(home.hasBeenVisited())
			throw new HomeAlreadyVisitedException();
		properties.remove(homeID.toUpperCase());	//checking if home exists
		propertiesLocal.remove(home.getLocal().toUpperCase());
		home.getOwner().removeProperty(home);
		propertiesCapacitySearch.remove(home);
	}

	@Override
	public HomeInfo getHomeInfo(String homeID) throws HomeDoesNotExistsException {
		return getHome(homeID);
	}

	@Override
	public void rentHome(String userID, String homeID, int feedback) throws UserDoesNotExistsException, HomeDoesNotExistsException, InvalidDataException, UserIsOwnerException {
		if(feedback < 1 )//|| feedback > MAX_FEEDBACK_SCORE) //maximum feedback is 20 points??
			throw new InvalidDataException();
		User user = getUser(userID); 
		Home home = getHome(homeID);  
		if(home.getOwner() == user) 
			throw new UserIsOwnerException(); //
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
	public Iterator<HomeInfo> getUserProperties(String userID) throws UserDoesNotExistsException, UserIsNotOwnerException {
		return getUser(userID).getPropertiesToRent();
	}

	@Override 
	public Iterator<HomeInfo> getUserVisits(String userID) throws UserDoesNotExistsException, UserHasNotVisitedException{
		return getUser(userID).getUserVisits(); 
	}

	@Override
	public Iterator<HomeInfo> searchHome(int capacity, String local) throws InvalidDataException, NoResultsException {
		if(capacity < 1 || capacity > MAX_PEOPLE_PEER_PROPERTY) throw new InvalidDataException();
		return propertiesCapacitySearch.iterator(capacity, local);
	}

	@Override
	public HomeInfo topHomes(String local) throws NoResultsException {
		Home h = propertiesLocal.find(local.toUpperCase());
		if(h == null)
			throw new NoResultsException();
		
		return h;
	}
	
	

}
