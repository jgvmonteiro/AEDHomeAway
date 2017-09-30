package HomeAway;

import HomeAway.Exceptions.*;
import HomeAway.*;

/**
 *
 * @author Joao Monteiro
 */
public class HomeAwayClass implements HomeAway{

    private User user;
    
    public HomeAwayClass() {
        
    }

    @Override
    public void addUser(String userId, String name, String email, String phone, String address, String nationality) throws UserAlreadyExistsException {
        if(user.getID().equals(userId))
            throw new UserAlreadyExistsException("Insert user ID already existed in the system.");
        User user = new UserClass(userId, name, email, phone, nationality, address);
        this.user = user;
    }

    @Override
    public void editUser(String userId, String email, String phone, String address) throws UserDoesNotExistsException {
        if(!user.getID().equals(userId))
            throw new UserDoesNotExistsException("Given user ID not found in the system.");
        UserClass u = (UserClass)user;
        u.setAddress(address);
        u.setEmail(email);
        u.setPhone(phone);
    }

    @Override
    public void removeUser(String userId) throws UserDoesNotExistsException, UserHasHomeToRent {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User getUserInfo(String userId) throws UserDoesNotExistsException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addHome(String homeId, String userId, int price, int people, String adress, String local, String description) throws HomeAlreadyExistsException, NotANumberException, UserDoesNotExistsException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeHome(String homeId) throws HomeDoesNotExists, HomeAlreadyVisisted {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Home getHomeInfo(String homeId) throws HomeDoesNotExists {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void rentHome(String userId, String homeId, int score) throws UserDoesNotExistsException, HomeDoesNotExists, NotANumberException, UserIsOwnerException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
