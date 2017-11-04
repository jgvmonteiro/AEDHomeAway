package homeAway;

import dataStructures.Iterator;
import homeAway.exceptions.*;

/**
 * HomeAway interface.
 * Contains all methods necessary to control the HomeAway application. 
 * Stores and manages users and properties.
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
	 * Returns information about an user in the system.
	 * 
	 * @param userID Identification(ID) of the user in the system.
	 * @return UserInfo object, contains information about the user.
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
	 * @throws HomeAlreadyVisitedException The property has been already visited and cannot be removed.
	 */
	void removeHome(String homeID) throws HomeDoesNotExistsException, HomeAlreadyVisitedException;
	
	/**
	 * Returns information about a property in the system.
	 * 
	 * @param homeID Property Identification in the system.
	 * @return HomeInfo object, contains information about the property.
	 * @see HomeInfo for more details.
	 * @throws HomeDoesNotExistsException Property with the supplied ID was not found in the system.
	 */
	HomeInfo getHomeInfo(String homeID) throws HomeDoesNotExistsException;
	
	/**
	 * Registers the visit of a user to a another user property and the feedback on the property.
	 * 
	 * @param userID Identification of the user who is going to stay in the property.
	 * @param homeID Identification of the property.
	 * @param feedback The evaluation the users gives to this property. 
	 * @throws UserDoesNotExistsException User with the supplied ID was not found in the system.
	 * @throws HomeDoesNotExistsException Property with the supplied ID was not found in the system.
	 * @throws InvalidDataException Score must be a positive value grater than zero.
	 * @throws UserIsOwnerException User cannot evaluate his own house.
	 */
	void rentHome(String userID, String homeID, int feedback) throws UserDoesNotExistsException, UserIsOwnerException, InvalidDataException, UserIsOwnerException;
	
	/**
	 * Registers the visit of a user to his own property.
	 * 
	 * @param userID Identification of the user.
	 * @param homeID Identification of the property.
	 * @throws UserDoesNotExistsException User with the supplied ID was not found in the system.
	 * @throws HomeDoesNotExistsException Property with the supplied ID was not found in the system.
	 * @throws UserIsNotOwnerException The property ID does not belong to the given user ID.
	 */
	void rentOwnHome(String userID, String homeID) throws UserDoesNotExistsException, HomeDoesNotExistsException, UserIsNotOwnerException;
	
	/**
	 * Returns all properties owner by a specified user.
	 * 
	 * @param userID User's identification in the system.
	 * @return HomeInfo object, contains information about the property. (Phase 1 only one property exists in the system)
	 * @see HomeInfo for more details.
	 * @throws UserDoesNotExistsException User with the supplied ID was not found in the system.
	 * @throws UserIsNotOwnerException User does not own any property.
	 */
	HomeInfo getUserProperties(String userID) throws UserDoesNotExistsException, UserIsNotOwnerException;
	
	/**
	 * Returns all the properties visited by a specified user.
	 * 
	 * @param userID User's identification in the system
	 * @return HomeInfo iterator, contains information about the properties the user has visited. 
	 * @see UserVisits for more details.
	 * @throws UserDoesNotExistsException User with the supplied ID was not found in the system.
	 * @throws UserHasNotVisitedException User hasn't stayed in any property.
	 */
	Iterator<HomeInfo> getUserVisits(String userID) throws UserDoesNotExistsException, UserHasNotVisitedException;
	 
	/**
	 * Searches a property on a given local that can host certain amount of people.
	 * 
	 * @param people Number of people property has to be able to host.
	 * @param local Local of the property.
	 * @return HomeInfo object, contains information about the property. (Phase 1 only one property exists in the system)
	 * @see HomeInfo for more details.
	 * @throws InvalidDataException Number of people must be a number between 1 and 20.
	 * @throws NoResultsException No property in the system matched for the given arguments.
	 */
	HomeInfo searchHome(int people, String local) throws InvalidDataException, NoResultsException;
	
	/**
	 * Searches properties in a given local ordered by the visitor's feedback on the property, highest to lower.
	 * 
	 * @param local Local of the property.
	 * @return HomeInfo object, contains information about the property. (Phase 1 only one property exists in the system)
	 * @throws NoResultsException No property in the system matched for the given arguments.
	 */
	HomeInfo topHomes(String local) throws NoResultsException;
			

	
}
