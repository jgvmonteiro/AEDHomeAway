package HomeAway;

import HomeAway.Exceptions.*;
import java.util.Iterator;

/**
 *
 * @author Joao Monteiro
 */
public interface HomeAway {
    
    /**
     * 
     * @param userId user's id
     * @param name user's name
     * @param email user's email
     * @param phone user's phone
     * @param address user's address
     * @param nationality  user's nationality
     * @throws UserAlreadyExistsException 
     */
    void addUser(String userId, String name, String email, String phone, String address, String nationality) throws  UserAlreadyExistsException; 
    
    /**
     * 
     * @param userId
     * @param email
     * @param phone
     * @param address
     * @throws UserDoesNotExistsException 
     */
    void editUser(String userId, String email, String phone, String address) throws UserDoesNotExistsException;
    
    /**
     * 
     * @param userId
     * @throws UserDoesNotExistsException
     * @throws UserHasHomeToRent 
     */
    void removeUser(String userId) throws UserDoesNotExistsException, UserHasHomeToRent;

    /**
     * 
     * @param userId
     * @return
     * @throws UserDoesNotExistsException 
     */
    User getUserInfo(String userId) throws UserDoesNotExistsException;
    
    /**
     * 
     * @param homeId
     * @param userId
     * @param price
     * @param people
     * @param adress
     * @param local
     * @param description
     * @throws HomeAlreadyExistsException
     * @throws InvalidDataException
     * @throws UserDoesNotExistsException 
     */
    void addHome(String homeId, String userId, int price, int people, String adress, String local, String description) throws HomeAlreadyExistsException, InvalidDataException, UserDoesNotExistsException;
    
    /**
     * 
     * @param homeId
     * @throws HomeDoesNotExists
     * @throws HomeAlreadyVisited 
     */
    void removeHome(String homeId) throws HomeDoesNotExists, HomeAlreadyVisited;
    
    /**
     * 
     * @param homeId
     * @return
     * @throws HomeDoesNotExists 
     */
    Home getHomeInfo(String homeId) throws HomeDoesNotExists;
    
    /**
     * 
     * @param userId
     * @param homeId
     * @param score
     * @throws UserDoesNotExistsException
     * @throws HomeDoesNotExists
     * @throws InvalidDataException
     * @throws UserHasNoHomesException 
     */
    void rentHome(String userId, String homeId, int score) throws UserDoesNotExistsException, HomeDoesNotExists, InvalidDataException, UserIsOwnerException;
    
    /**
     * 
     * @param userId
     * @param homeId
     * @throws UserDoesNotExistsException
     * @throws HomeDoesNotExists
     * @throws UserIsNotOwnerException 
     */
    void rentOwnHome(String userId, String homeId) throws UserDoesNotExistsException, HomeDoesNotExists, UserIsNotOwnerException;
    
    /**
     * 
     * @param userId
     * @return
     * @throws UserDoesNotExistsException 
     */
    Home getOwnerHomes(String userId) throws UserDoesNotExistsException, UserIsNotOwnerException;
    
    /**
     * 
     * @param userId
     * @return
     * @throws UserDoesNotExistsException
     * @throws UserHasNotRentsException 
     */
    Home[] getUserRents(String userId) throws UserDoesNotExistsException, UserHasNotRentsException;
    
    /**
     * 
     * @param people
     * @param local
     * @return
     * @throws InvalidDataException
     * @throws NoResultsException 
     */
    Home searchHome(int people, String local) throws InvalidDataException, NoResultsException;
    
    /**
     * 
     * @param local
     * @return
     * @throws NoResultsException 
     */
    Home topHomes(String local) throws NoResultsException;
            

    
}
