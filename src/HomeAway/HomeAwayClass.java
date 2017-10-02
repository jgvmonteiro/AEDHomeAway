package HomeAway;

import HomeAway.Exceptions.*;
import HomeAway.*;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Joao Monteiro
 */
public class HomeAwayClass implements HomeAway{

    private User user;
    private Home home;
    
    public HomeAwayClass() {
        
    }

    @Override
    public void addUser(String userId, String name, String email, String phone, String address, String nationality) throws UserAlreadyExistsException {
        if(user != null && user.getID().equals(userId))
            throw new UserAlreadyExistsException("Insert user ID already existed in the system.");
        User user = new UserClass(userId, name, email, phone, nationality, address);
        this.user = user;
    }

    @Override
    public void editUser(String userId, String email, String phone, String address) throws UserDoesNotExistsException {
        if(user == null || !user.getID().equals(userId))
            throw new UserDoesNotExistsException("Given user ID not found in the system.");
        UserClass u = (UserClass)user;
        u.setAddress(address);
        u.setEmail(email);
        u.setPhone(phone);
    }

    @Override
    public void removeUser(String userId) throws UserDoesNotExistsException, UserHasHomeToRent {
        if(user == null || !user.getID().equals(userId))
            throw new UserDoesNotExistsException("Given user ID not found in the system.");
        if(user.getHomeToRent()!=null)
            throw  new UserHasHomeToRent("Attempt to remove a user who has homes to rent.");
        user = null;
    }

    @Override
    public User getUserInfo(String userId) throws UserDoesNotExistsException {
        if(user == null || !user.getID().equals(userId))
            throw new UserDoesNotExistsException("Given user ID not found in the system.");
        return user;
    }

    @Override
    public void addHome(String homeId, String userId, int price, int people, String adress, String local, String description) throws HomeAlreadyExistsException, InvalidDataException, UserDoesNotExistsException {
       if(user == null || !user.getID().equals(userId))
            throw new UserDoesNotExistsException("Given user ID not found in the system.");
       if(user.getHomeToRent().getHomeID().equals(homeId))
           throw new HomeAlreadyExistsException("Attempt to add an home that already exists.");
       Home h = new HomeClass(homeId, userId, local, price, price);
       ((UserClass)user).setHomeToRent(h);
       this.home = h;
    }

    @Override
    public void removeHome(String homeId) throws HomeDoesNotExists, HomeAlreadyVisited {
        if(user.getHomeToRent()==null || !user.getHomeToRent().getHomeID().equals(homeId))
            throw new HomeDoesNotExists("Given home ID not found in the system.");
        if(user.getHomeToRent().visited())
            throw new HomeAlreadyVisited("Attempt to remove an home that has already a visit.");
        ((UserClass)user).setHomeToRent(null);
        this.home = null;
    }

    @Override
    public Home getHomeInfo(String homeId) throws HomeDoesNotExists {
        if(home==null || !home.getHomeID().equals(homeId))
            throw new HomeDoesNotExists("Given home ID not found in the system.");
        return home;
    }

    @Override
    public void rentHome(String userId, String homeId, int score) throws UserDoesNotExistsException, HomeDoesNotExists, InvalidDataException, UserIsOwnerException {
        if(user == null || !user.getID().equals(userId))
            throw new UserDoesNotExistsException("Given user ID not found in the system.");
       if(home==null || !home.getHomeID().equals(homeId))
            throw new HomeDoesNotExists("Given home ID not found in the system.");
       if(score < 0)
           throw new InvalidDataException("Invalid input data.");
       throw new UserIsOwnerException("User attempted to evaluate his own home.");
       //((HomeClass)home).newRent();
    }

    @Override
    public void rentOwnHome(String userId, String homeId) throws UserDoesNotExistsException, HomeDoesNotExists, UserIsNotOwnerException {
        if(user == null || !user.getID().equals(userId))
            throw new UserDoesNotExistsException("Given user ID not found in the system.");
       if(home==null || !home.getHomeID().equals(homeId))
            throw new HomeDoesNotExists("Given home ID not found in the system.");
       //O QUE FAZER À EXCEPTCAO????
       ((HomeClass)home).newRent();
    }

    @Override
    public Home getOwnerHomes(String userId) throws UserDoesNotExistsException, UserIsOwnerException {
        return home;
    }

    @Override
    public Home getUserRents(String userId) throws UserDoesNotExistsException, UserHasNotRentsException {
        return home;
    }

    @Override
    public Home searchHome(int capacity, String local) throws InvalidDataException, NoResultsException {
        if(capacity < 0) throw new InvalidDataException("capacity is negative");
    	if(this.home.getCapacity() == capacity && this.home.getLocal().equals(local))
        	return this.home;
        else throw new NoResultsException("Local or people don't match the home in our system");
    }

    @Override
    public Home topHomes(String local) throws NoResultsException {
        if(this.home.getLocal().equals(local))
        	return this.home;
        else throw new NoResultsException("Our home's local doesn't match the parameter local");
    }

    
    
    
     
}
