package HomeAway;

import HomeAway.Exceptions.*;
import HomeAway.*;

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
        if(user ==null || !user.getID().equals(userId))
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
    public void addHome(String homeId, String userId, int price, int people, String adress, String local, String description) throws HomeAlreadyExistsException, NotANumberException, UserDoesNotExistsException {
       if(user == null || !user.getID().equals(userId))
            throw new UserDoesNotExistsException("Given user ID not found in the system.");
       if(user.getHomeToRent().getHomeID().equals(homeId))
           throw new HomeAlreadyExistsException("Attempt to add an home that already exists.");
       Home h = new HomeClass(homeId, userId, local, price, price);
       ((UserClass)user).setHomeToRent(h);
       this.home = h;
    }

    @Override
    public void removeHome(String homeId) throws HomeDoesNotExists, HomeAlreadyVisisted {
        if(user.getHomeToRent()==null || !user.getHomeToRent().getHomeID().equals(homeId))
            throw new HomeDoesNotExists("Given home ID not found in the system.");
        if(user.getHomeToRent().getVisitors()!=null)
            throw new HomeAlreadyVisisted("Attempt to remove an home that has already a visit.");
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
    public void rentHome(String userId, String homeId, int score) throws UserDoesNotExistsException, HomeDoesNotExists, NotANumberException, UserIsOwnerException {
        if(user == null || !user.getID().equals(userId))
            throw new UserDoesNotExistsException("Given user ID not found in the system.");
       if(home.getHomeID().equals(homeId))
           throw new HomeAlreadyExistsException("Attempt to add an home that already exists.");
       
       ((UserClass)user).setHomeToRent(h);
    }

    @Override
    public void rentOwnHome(String userId, String homeId) throws UserDoesNotExistsException, HomeDoesNotExists, UserIsNotOwnerException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Home getOwnerHomes(String userId) throws UserDoesNotExistsException, UserIsOwnerException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Home getUserRents(String userId) throws UserDoesNotExistsException, UserHasNotRentsException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Home searchHome(int people, String local) throws NotANumberException, NoResultsException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Home topHomes(String local) throws NoResultsException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void load() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
    
     
}
