
/**MAIN
 * @author Diogo Tavares (50309) dc.tavares@campus.fct.unl.pt
 * @author Joao Monteiro (51105) jg.monteiro@campus.fct.unl.pt
 */


import java.util.Scanner;

import dataStructures.Iterator;
import homeAway.exceptions.*;
import homeAway.HomeAway;
import homeAway.HomeAwayClass;
import homeAway.HomeInfo;
import homeAway.UserInfo;

import java.io.*;

public class Main {
	
	//system messages
	private static final String USER_INSERT_SUCCESS = "Insercao de utilizador com sucesso.";
	private static final String USER_UPDATE_SUCCESS = "Utilizador atualizado com sucesso.";
	private static final String USER_REMOVE_SUCCESS = "Utilizador removido com sucesso.";
	private static final String GET_USER_DATA_SUCCESS = "%s: %s, %s, %s, %s\n"; //name, address, nationality, email, phone number
	private static final String HOME_ADD_SUCCESS = "Propriedade adicionada com sucesso.";
	private static final String HOME_REMOVE_SUCCESS = "Propriedade removida com sucesso.";
	private static final String CHECK_HOME_DATA_SUCCESS = "%s: %s, %s, %d, %d, %d, %s\n"; //description, address, local, price, capacity, score, name
	private static final String STAY_INSERT_SUCCESS = "Estadia adicionada com sucesso.";
	private static final String HOME_INFO = "%s %s %s %s %d %d %d\n"; //idHome descricao morada local preco pessoas pontos
	
	private static final String SAVE_AND_QUIT = "Gravando e terminando...\n";
	
	private static final String ERR_USER_EXIST = "Utilizador existente.";
	private static final String ERR_USER_NOT_EXIST = "Utilizador inexistente.";
	private static final String ERR_USER_IS_OWNER = "Utilizador e proprietario.";
	private static final String ERR_USER_NOT_OWNER = "Utilizador nao e proprietario.";
	private static final String ERR_INVALID_DATA = "Dados invalidos.";
	private static final String ERR_PROPERTY_EXIST = "Propriedade existente.";
	private static final String ERR_PROPERTY_ALREADY_VISITED = "Propriedade ja foi visitada.";
	private static final String ERR_PROPERTY_NOT_EXIST = "Propriedade inexistente.";
	private static final String ERR_TRAVELLER_IS_OWNER = "Viajante e o proprietario.";
	private static final String ERR_TRAVELLER_NOT_OWNER = "Viajante nao e o proprietario.";
	private static final String ERR_USER_DID_NOT_TRAVEL = "Utilizador nao viajou.";
	private static final String ERR_SEARCH_NO_RESULTS = "Pesquisa nao devolveu resultados.";
	
	//commands
	private static final String CMD_INSERT_USER = "IU";
	private static final String CMD_UPDATE_USER = "UU";
	private static final String CMD_REMOVE_USER = "RU";
	private static final String CMD_GET_USER = "GU";
	private static final String CMD_ADD_HOME = "AH";
	private static final String CMD_REMOVE_HOME = "RH";
	private static final String CMD_GET_HOME = "GH";
	private static final String CMD_ADD_TRAVEL = "AT";
	private static final String CMD_LIST_HOST_PROPERTIES = "LH";
	private static final String CMD_LIST_TRAVELLER_STAYS = "LT";
	private static final String CMD_SEARCH_PROPERTIES = "PH";
	private static final String CMD_LIST_BEST_PROPERTIES = "LB";
	private static final String CMD_EXIT_SAVE = "XS";
	
	private static final String SAVE_FILE_NAME = "data.o";
	

	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {
		HomeAway hw = load(); 
		//HomeAway hw = new HomeAwayClass();
		interpreter(hw);
		System.out.println(SAVE_AND_QUIT);
		save(hw);
	}
	
	private static void interpreter(HomeAway hw) {
		Scanner in = new Scanner(System.in);
		String option = in.next().toUpperCase();
		
		while(!option.equals(CMD_EXIT_SAVE)) {
			switch(option) {
				case CMD_INSERT_USER:
					addUser(hw, in);
					break;
				case CMD_UPDATE_USER:
					editUser(hw, in);
					break;
				case CMD_REMOVE_USER:
					removeUser(hw, in);
					break;
				case CMD_GET_USER:
					getUserInfo(hw, in);
					break;
				case CMD_ADD_HOME:
					addHome(hw, in);
					break;
				case CMD_REMOVE_HOME:
					removeHome(hw, in);
					break;
				case CMD_GET_HOME:
					getHomeInfo(hw, in);
					break;
				case CMD_ADD_TRAVEL:
					newVisit(hw, in);
					break;
				case CMD_LIST_TRAVELLER_STAYS:
					listUserVisits(hw, in);
					break;
				case CMD_LIST_HOST_PROPERTIES:
					listUserProperties(hw, in);
					break;
				case CMD_SEARCH_PROPERTIES:
					searchHome(hw, in);
					break;
				case CMD_LIST_BEST_PROPERTIES:
					listTopHome(hw, in);
					break;
				default:
					System.out.println("Invalid command");
			}
			System.out.println();
			option = in.next().toUpperCase();
		}
		
	}
	
	private static void addUser(HomeAway hw, Scanner in) {
		String idUser = in.next();
		String email = in.next();
		String phone = in.next();
		String name = in.nextLine().trim();
		String nationality = in.nextLine();
		String address = in.nextLine();		
		try {
			hw.addUser(idUser, email, phone, name, nationality, address);
			System.out.println(USER_INSERT_SUCCESS);
		} 
		catch(UserAlreadyExistsException e) {
			System.out.println(ERR_USER_EXIST);
		}
	}
	
	private static void editUser(HomeAway hw, Scanner in) {
		String userId = in.next();
		String email = in.next();
		String phone = in.next();
		in.nextLine();
		String address = in.nextLine();
		try {
			hw.editUser(userId, email, phone, address);
			System.out.println(USER_UPDATE_SUCCESS);
		}
		catch(UserDoesNotExistsException e) {
			System.out.println(ERR_USER_NOT_EXIST);
		}
	}
	
	private static void removeUser(HomeAway hw, Scanner in) {
		String userId = in.next();
		in.nextLine();
		try {
			hw.removeUser(userId);
			System.out.println(USER_REMOVE_SUCCESS);
		}
		catch(UserDoesNotExistsException e) {
			System.out.println(ERR_USER_NOT_EXIST);
		}
		catch(UserHasHomeToRent e) {
			System.out.println(ERR_USER_IS_OWNER);
		}
	}
	
	private static void getUserInfo(HomeAway hw, Scanner in) {
		String userId = in.next();
		in.nextLine();
		try {
			UserInfo u = hw.getUserInfo(userId);
			System.out.printf(GET_USER_DATA_SUCCESS, u.getName(), u.getAddress(), u.getNationality(),u.getEmail(), u.getPhone());
		}
		catch(UserDoesNotExistsException e) {
			System.out.println(ERR_USER_NOT_EXIST);
		}
	}
	
	private static void addHome(HomeAway hw, Scanner in) {
		String homeId = in.next();
		String userId = in.next();
		int price = in.nextInt();
		int capacity = in.nextInt();
		String location = in.nextLine().trim();	
		String description = in.nextLine();
		String address = in.nextLine();	
		try {
			hw.addHome(homeId, userId, price, capacity, address, location, description);
			System.out.println(HOME_ADD_SUCCESS);
		}
		catch(HomeAlreadyExistsException e) {
			System.out.println(ERR_PROPERTY_EXIST);
		}
		catch(UserDoesNotExistsException e) {
			System.out.println(ERR_USER_NOT_EXIST);
		}
		catch(InvalidDataException e) {
			System.out.println(ERR_INVALID_DATA);
		}
	}
	
	private static void removeHome(HomeAway hw, Scanner in) {
		String homeId = in.next();
		in.nextLine();		
		try {
			hw.removeHome(homeId);
			System.out.println(HOME_REMOVE_SUCCESS);
		}
		catch(HomeDoesNotExistsException e) {
			System.out.println(ERR_PROPERTY_NOT_EXIST);
		}
		catch(HomeAlreadyVisitedException e) {
			System.out.println(ERR_PROPERTY_ALREADY_VISITED);
		}
	}
	
	private static void getHomeInfo(HomeAway hw, Scanner in){
		String homeID = in.next();
		in.nextLine();
		try {
			HomeInfo home = hw.getHomeInfo(homeID);//description, address, local, price, capacity, score, name
			System.out.printf(CHECK_HOME_DATA_SUCCESS, home.getDescription(), home.getAddress(), home.getLocal(), home.getPrice(), home.getCapacity(), home.getFeedback(), home.getOwnerName());
		} catch (HomeDoesNotExistsException e) {
			System.out.println(ERR_PROPERTY_NOT_EXIST);
		}		
	}	
	
	private static void newVisit(HomeAway hw, Scanner in) {
		String args = in.nextLine().trim();
		String[] arr = args.split(" ");
		if(arr.length == 2)
			ownerVisit(hw, arr[0], arr[1]);
		else userVisit(hw, arr[0], arr[1], arr[2]);	//nao utilizado na fase 1
	}
	
	private static void ownerVisit(HomeAway hw, String userId, String homeId) {
		try {
			hw.rentOwnHome(userId, homeId);
			System.out.println(STAY_INSERT_SUCCESS);
		}
		catch(UserDoesNotExistsException e) {
			System.out.println(ERR_USER_NOT_EXIST);
		}
		catch(HomeDoesNotExistsException e) {
			System.out.println(ERR_PROPERTY_NOT_EXIST);
		}
		catch(UserIsNotOwnerException e) {
			System.out.println(ERR_TRAVELLER_NOT_OWNER);
		}
	}
	
	private static void userVisit(HomeAway hw, String userID, String homeID, String score){
		try {
			int scoreAmount = Integer.parseInt(score);
			hw.rentHome(userID, homeID, scoreAmount);
			System.out.println(STAY_INSERT_SUCCESS);
		} catch (UserDoesNotExistsException e) {
			System.out.println(ERR_USER_NOT_EXIST);
		} catch (InvalidDataException|NumberFormatException e){ 
			System.out.println(ERR_INVALID_DATA);
		} catch (HomeDoesNotExistsException e){
			System.out.println(ERR_PROPERTY_NOT_EXIST);
		} catch (UserIsOwnerException e){
			System.out.println(ERR_TRAVELLER_IS_OWNER);
		}
	}
	
	private static void listUserVisits(HomeAway hw, Scanner in) {
		String userId = in.next();
		in.nextLine();		
		try {
			Iterator<HomeInfo> it = hw.getUserVisits(userId);
			
			while(it.hasNext()) {
				HomeInfo h = it.next();
				printHomeInfo(h.getHomeID(), h.getDescription(), h.getAddress(), h.getLocal(), h.getPrice(), h.getCapacity(), h.getFeedback());
			}
		}
		catch(UserDoesNotExistsException e) {
			System.out.println(ERR_USER_NOT_EXIST);
		}
		catch(UserHasNotVisitedException e) {
			System.out.println(ERR_USER_DID_NOT_TRAVEL);
		}
	}
	
	//idHome descricao morada local preco pessoas pontos 
	private static void listUserProperties(HomeAway hw, Scanner in){
		String userID = in.next();
		in.nextLine();	
		try {
			Iterator<HomeInfo> it = hw.getUserProperties(userID);
			while(it.hasNext()){
				HomeInfo home = it.next();
				printHomeInfo(home.getHomeID(), home.getDescription(), home.getAddress(), home.getLocal(), home.getPrice(), home.getCapacity(), home.getFeedback());
			}
		} catch (UserDoesNotExistsException e) {
			System.out.println(ERR_USER_NOT_EXIST);
		} catch (UserIsNotOwnerException e){
			System.out.println(ERR_USER_NOT_OWNER);
		}
	}
	
	private static void searchHome(HomeAway hw, Scanner in) {
		int capacity = in.nextInt();
		String local = in.nextLine().trim();
		try {
			Iterator<HomeInfo> it = hw.searchHome(capacity, local);
			
			while(it.hasNext()){
				HomeInfo h = it.next();
				printHomeInfo(h.getHomeID(), h.getDescription(), h.getAddress(), h.getLocal(), h.getPrice(), h.getCapacity(), h.getFeedback());
			}
		}
		catch(InvalidDataException e) {
			System.out.println(ERR_INVALID_DATA);
		}
		catch(NoResultsException e) {
			System.out.println(ERR_SEARCH_NO_RESULTS);
		}
	}
	
	private static void listTopHome(HomeAway hw, Scanner in){
		String local = in.nextLine().trim();
		try {
			Iterator<HomeInfo> it = hw.topHomes(local);
			while(it.hasNext()){
				HomeInfo home = it.next();
				printHomeInfo(home.getHomeID(), home.getDescription(), home.getAddress(), home.getLocal(), home.getPrice(), home.getCapacity(), home.getFeedback());
			}
		} catch (NoResultsException e) {
			System.out.println(ERR_SEARCH_NO_RESULTS);
		}
	}
	
	private static void save(Object o){
		try {
			ObjectOutputStream  outStream = new ObjectOutputStream(new FileOutputStream(SAVE_FILE_NAME));
			outStream.writeObject(o);
			outStream.close();
		} catch (Exception e) {
			//something went wrong...
		}
	}
	
	private static void printHomeInfo(String id, String description, String address, String local, int price, int capacity, int feedback) {
		System.out.printf(HOME_INFO, id, description, address, local, price, capacity, feedback);
	}
	
	
	
	
	
	private static HomeAway load() throws FileNotFoundException, IOException, ClassNotFoundException{
		try {
			ObjectInputStream  inStream = new ObjectInputStream(new FileInputStream(SAVE_FILE_NAME));
			Object o = inStream.readObject();
			inStream.close();
			return (HomeAway)o;
		} catch(ClassNotFoundException e) {
			System.out.println("Error loading file.");
			System.exit(1);
			return null;
		} catch(FileNotFoundException e) {
			return new HomeAwayClass();
		}
	}
	
	
	
	
}
