package HomeAway;

import HomeAway.Exceptions.*;
import HomeAway.*;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.Writer;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Joao Monteiro
 */
public class HomeAwayClass implements HomeAway, Serializable{

	private User user;
	private Home home;
	private static final int MAX_PEOPLE_IN_HOME = 20;
	
	public HomeAwayClass() {
		
	}
	
	private boolean hasUser(String userID){
		try {
			getUser(userID);
			return true;
		} catch (Exception e) {
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
		} catch (Exception e) {
			return false;
		}
	}
	
	private Home getHome(String homeID) throws HomeDoesNotExistsException{
		if(home==null || !home.getHomeID().equalsIgnoreCase(homeID))
			throw new HomeDoesNotExistsException("Given home ID not found in the system.");
		return home;
	}
	
	

	@Override
	public void addUser(String userId, String email, String phone, String name, String nationality, String address) throws UserAlreadyExistsException {
		if(hasUser(userId))
			throw new UserAlreadyExistsException("Insert user ID already existed in the system.");
		User user = new UserClass(userId, name, email, phone, nationality, address);
		this.user = user;
	}
	
	@Override
	public void editUser(String userId, String email, String phone, String address) throws UserDoesNotExistsException {
		User user = getUser(userId);
		user.setAddress(address);
		user.setEmail(email);
		user.setPhone(phone);
	}

	@Override
	public void removeUser(String userId) throws UserDoesNotExistsException, UserHasHomeToRent {
		User user = getUser(userId);
		if(user.hasHomeToRent())
			throw  new UserHasHomeToRent("Attempt to remove a user who has homes to rent.");
		this.user = null;
	}

	@Override
	public UserInfo getUserInfo(String userId) throws UserDoesNotExistsException {
		User user = getUser(userId);
		return user;
	}

	@Override
	public void addHome(String homeId, String userId, int price, int people, String address, String local, String description) throws HomeAlreadyExistsException, InvalidDataException, UserDoesNotExistsException {
	   User user = getUser(userId);
	   if(hasHome(homeId))
		   throw new HomeAlreadyExistsException("Attempt to add an home that already exists.");
	   if(price <= 0 || people <= 0 || people > MAX_PEOPLE_IN_HOME)
		   throw new InvalidDataException("Invalid price or capacity.");
	   Home h = new HomeClass(homeId, user, local, address, description, price, people);
	   user.setHomeToRent(h);
	   this.home = h;
	}

	@Override
	public void removeHome(String homeId) throws HomeDoesNotExistsException, HomeAlreadyVisited {
		Home home = getHome(homeId);
		if(user.getHomeToRent().hasBeenVisited())
			throw new HomeAlreadyVisited("Attempt to remove an home that has already a visit.");
		user.setHomeToRent(null);
		this.home = null;
	}

	@Override
	public HomeInfo getHomeInfo(String homeId) throws HomeDoesNotExistsException {
		Home home = getHome(homeId);
		return home;
	}

	@Override
	public void rentHome(String userId, String homeId, int score) throws UserDoesNotExistsException, HomeDoesNotExistsException, InvalidDataException, UserIsOwnerException {
		if(score <= 0)
			throw new InvalidDataException("Invalid input data.");
		User user = getUser(userId);
		Home home = getHome(homeId);
		throw new UserIsOwnerException("User attempted to evaluate his own home.");
	   //((HomeClass)home).newRent();
	}

	@Override
	public void rentOwnHome(String userId, String homeId) throws UserDoesNotExistsException, HomeDoesNotExistsException, UserIsNotOwnerException {
		User user = getUser(userId);
		Home home = getHome(homeId);
	   //O QUE FAZER À EXCEPTCAO????
	   if(!home.getOwnerID().equalsIgnoreCase(user.getID()))
		   throw new UserIsNotOwnerException("Cannot rent this home without a avaluation.");
	   home.newVisit();
	   user.newRent(home);
	}

	@Override
	public HomeInfo getOwnerHomes(String userId) throws UserDoesNotExistsException, UserIsNotOwnerException {
		User user = getUser(userId);
		if(!user.hasHomeToRent())
			throw new UserIsNotOwnerException("Utilizador nao e proprietario.");
		return home;
	}

	@Override
	public HomeInfo[] getUserRents(String userId) throws UserDoesNotExistsException, UserIsNotOwnerException {
		User user = getUser(userId);;
		if(user.visitedHomesCount()==0)
			throw new UserIsNotOwnerException("Utilizador nao e proprietario.");
		return user.getVisitedHomes();
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
