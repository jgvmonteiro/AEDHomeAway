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
     * @throws HomeDoesNotExistsException
     * @throws HomeAlreadyVisited 
     */
    void removeHome(String homeId) throws HomeDoesNotExistsException, HomeAlreadyVisited;
    
    /**
     * 
     * @param homeId
     * @return
     * @throws HomeDoesNotExistsException 
     */
    Home getHomeInfo(String homeId) throws HomeDoesNotExistsException;
    
    /**
     * 
     * @param userId
     * @param homeId
     * @param score
     * @throws UserDoesNotExistsException
     * @throws HomeDoesNotExistsException
     * @throws InvalidDataException
     * @throws UserHasNoHomesException 
     */
    void rentHome(String userId, String homeId, int score) throws UserDoesNotExistsException, HomeDoesNotExistsException, InvalidDataException, UserIsOwnerException;
    
    /**
     * 
     * @param userId
     * @param homeId
     * @throws UserDoesNotExistsException
     * @throws HomeDoesNotExistsException
     * @throws UserIsNotOwnerException 
     */
    void rentOwnHome(String userId, String homeId) throws UserDoesNotExistsException, HomeDoesNotExistsException, UserIsNotOwnerException;
    
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
