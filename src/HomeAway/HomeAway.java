package HomeAway;

import HomeAway.Exceptions.*;

/**
 *
 * @author Diogo Tavares (50309) dc.tavares@campus.fct.unl.pt
 * @author Joao Monteiro (51105) jg.monteiro@campus.fct.unl.pt
 */
public interface HomeAway {
	
	/**
	 * Adds a new user to the system.
	 * 
	 * @param userID Identification(ID) of the user to store in the system.
	 * @param name User's name.
	 * @param email User's email address.
	 * @param phone User's phone number.
	 * @param address User's address.
	 * @param nationality User's nationality.
	 * @throws UserAlreadyExistsException User with the same ID already exists in the system.
	 */
	void addUser(String userID, String name, String email, String phone, String address, String nationality) throws  UserAlreadyExistsException; 
	
	/**
	 * Edits information of a specific user in the system.
	 * 
	 * @param userID Identification(ID) of the user to be edited.
	 * @param email User's new email address.
	 * @param phone User's new phone number.
	 * @param address User's new address.
	 * @throws UserDoesNotExistsException User with the supplied ID was not found in the system.
	 */
	void editUser(String userID, String email, String phone, String address) throws UserDoesNotExistsException;
	
	/**
	 * Removes a specific user out of the system.
	 * 
	 * @param userID Identification(ID) of the user who's to be removed.
	 * @throws UserDoesNotExistsException User with the supplied ID was not found in the system.
	 * @throws UserHasHomeToRent Cannot remove this use because the user has an home in the system available for rent.
	 */
	void removeUser(String userID) throws UserDoesNotExistsException, UserHasHomeToRent;

	/**
	 * Gives information about an user in the system.
	 * 
	 * @param userID Identification(ID) of the user in the system.
	 * @return UserInfo object, containing information about the user.
	 * @see UserInfo for more details.
	 * @throws UserDoesNotExistsException User with the supplied ID was not found in the system.
	 */
	UserInfo getUserInfo(String userID) throws UserDoesNotExistsException;
	
	/**
	 * Adds a new property to the system.
	 * 
	 * @param homeID Identification(ID) of the property to store in the system.
	 * @param userID User's ID who's this property bellows to.
	 * @param price Price visitors have to pay to stay in property.
	 * @param people Maximum number of people that can stay in the property.
	 * @param adress Property address.
	 * @param local Property local.
	 * @param description Description of the property.
	 * @throws HomeAlreadyExistsException A property with the same ID already exists in the system.
	 * @throws InvalidDataException Price must be greater than 0 and people must be a number between 1 and 20.
	 * @throws UserDoesNotExistsException User with the supplied ID was not found in the system.
	 */
	void addHome(String homeID, String userID, int price, int people, String adress, String local, String description) throws HomeAlreadyExistsException, InvalidDataException, UserDoesNotExistsException;
	
	/**
	 * Removes a property from the system.
	 * 
	 * @param homeID Property Identification in the system.
	 * @throws HomeDoesNotExistsException Property with the supplied ID was not found in the system.
	 * @throws HomeAlreadyVisited The property has been already visited and cannot be removed.
	 */
	void removeHome(String homeID) throws HomeDoesNotExistsException, HomeAlreadyVisited;
	
	/**
	 * Gives information about a property in the system.
	 * 
	 * @param homeID Property Identification in the system.
	 * @return HomeInfo object, containing information about the property.
	 * @see HomeInfo for more details.
	 * @throws HomeDoesNotExistsException Property with the supplied ID was not found in the system.
	 */
	HomeInfo getHomeInfo(String homeID) throws HomeDoesNotExistsException;
	
	/**
	 * Registers the visit of a user to a another user property and the feedback on the property.
	 * 
	 * @param userID Identification of the user who is going to stay in the property.
	 * @param homeID Identification of the property.
	 * @param score The evaluation the users gives to this property. 
	 * @throws UserDoesNotExistsException User with the supplied ID was not found in the system.
	 * @throws HomeDoesNotExistsException Property with the supplied ID was not found in the system.
	 * @throws InvalidDataException Score must be a positive value grater than zero.
	 * @throws UserIsOwnerException User cannot evaluate his own house.
	 */
	void rentHome(String userID, String homeID, int score) throws UserDoesNotExistsException, UserIsOwnerException, InvalidDataException, UserIsOwnerException;
	
	/**
	 * Registers the visit of a user to his own property.
	 * 
	 * @param userID Identification of the user.
	 * @param homeID Identification of the property.
	 * @throws UserDoesNotExistsException User with the supplied ID was not found in the system.
	 * @throws HomeDoesNotExistsException Property with the supplied ID was not found in the system.
	 * @throws UserIsNotOwnerException The property ID does not bellow to the given user ID.
	 */
	void rentOwnHome(String userID, String homeID) throws UserDoesNotExistsException, HomeDoesNotExistsException, UserIsNotOwnerException;
	
	/**
	 * 
	 * 
	 * @param userID
	 * @return
	 * @throws UserDoesNotExistsException 
	 * @throws UserIsNotOwnerException
	 */
	HomeInfo getUserProperties(String userID) throws UserDoesNotExistsException, UserIsNotOwnerException;
	
	/**
	 * 
	 * @param userId
	 * @return
	 * @throws UserDoesNotExistsException
	 * @throws UserHasNotRentsException 
	 */
	HomeInfo[] getUserRents(String userId) throws UserDoesNotExistsException, UserHasNotRentsException;
	
	/**
	 * 
	 * @param people
	 * @param local
	 * @return
	 * @throws InvalidDataException
	 * @throws NoResultsException 
	 */
	HomeInfo searchHome(int people, String local) throws InvalidDataException, NoResultsException;
	
	/**
	 * 
	 * @param local
	 * @return
	 * @throws NoResultsException 
	 */
	HomeInfo topHomes(String local) throws NoResultsException;
			

	
}
