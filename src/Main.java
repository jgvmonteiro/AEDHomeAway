
/**
 *
 * @author Joao Monteiro
 */


import java.util.Scanner;

import HomeAway.HomeAway;
import HomeAway.HomeAwayClass;
import HomeAway.User;
import HomeAway.Exceptions.*;
import java.io.File;
import HomeAway.Home;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;

public class Main {
	
	//system messages
	private static final String USER_INSERT_SUCCESS = "Insercao de utilizador com sucesso.";
	private static final String USER_UPDATE_SUCCESS = "Utilizador atualizado com sucesso.";
	private static final String USER_REMOVE_SUCCESS = "Utilizador removido com sucesso.";
	private static final String CHECK_USER_DATA_SUCCESS = "%s: %s, %s, %s, %s\n"; //name, address, nationality, email, phone number
	private static final String HOME_ADD_SUCCESS = "Propriedade adicionada com sucesso.";
	private static final String HOME_REMOVE_SUCCESS = "Propriedade removida com sucesso.";
	private static final String CHECK_HOME_DATA_SUCCESS = "%s: %s, %s, %d, %d, %d, %s\n"; //description, address, local, price, capacity, score, name
	private static final String STAY_INSERT_SUCCESS = "Estadia adicionada com sucesso.";
	private static final String CHECK_STAYS_SUCCESS = "%s %s %s %s %d %d %d\n"; //idHome descricao morada local preco pessoas pontos
	
	private static final String SAVE_AND_QUIT = "Gravando e terminando...\n";
	
	private static final String ERR_USER_EXIST = "Utilizador existente.";
	private static final String ERR_USER_NOT_EXIST = "Utilizador inexistente.";
	private static final String ERR_USER_IS_OWNER = "Utilizador e proprietario.";
	private static final String ERR_USER_NOT_OWNER = "Utilizador nao e proprietario.";
	private static final String ERR_INVALID_DATA = "Dados invalidos.";
	private static final String ERR_PROPERTY_EXIST = "Propriedade existente.";
	private static final String ERR_PROPERTY_ALREADY_VISITED = "Propriedade ja foi visitada";
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
	
	private static final String FILE_TO_SAVE = "data.txt";
	

	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {
		System.out.println("This is a test.");
		HomeAway a = (HomeAway) load();
		interpreter(a);
		System.out.println(SAVE_AND_QUIT);
		save(a);
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
					checkData(hw, in);
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
					addStay(hw, in);
					break;
				case CMD_LIST_TRAVELLER_STAYS:
					listStaysByUser(hw, in);
					break;
				case CMD_LIST_HOST_PROPERTIES:
					listUser(hw, in);
					break;
				case CMD_SEARCH_PROPERTIES:
					searchHomes(hw, in);
					break;
				case CMD_LIST_BEST_PROPERTIES:
					listTopHome(hw, in);
					break;
				default:
					System.out.println("wrong command");
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
	
	private static void checkData(HomeAway hw, Scanner in) {
		String userId = in.next();
		in.nextLine();
		
		try {
			User u = hw.getUserInfo(userId);
			System.out.printf(CHECK_USER_DATA_SUCCESS, u.getName(), u.getAddress(), u.getNationality(),
													   u.getEmail(), u.getPhone());
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
		catch(HomeAlreadyVisited e) {
			System.out.println(ERR_PROPERTY_ALREADY_VISITED);
		}
	}
	
	private static void getHomeInfo(HomeAway hw, Scanner in){
		String homeID = in.next();
		in.nextLine();
		
		try {
			Home home = hw.getHomeInfo(homeID);//description, address, local, price, capacity, score, name
			System.out.printf(CHECK_HOME_DATA_SUCCESS, home.getDescription(), home.getAddress(), home.getLocal(), home.getPrice(), home.getCapacity(), home.getScore(), home.getOwnerName());
		} catch (HomeDoesNotExistsException e) {
			System.out.println(ERR_PROPERTY_NOT_EXIST);
		}		
		
		
	}	
	
	private static void addOwnerStay(HomeAway hw, String userId, String homeId) {
		
		
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
	
	private static void addStay(HomeAway hw, Scanner in) {
		String args = in.nextLine().trim();
		String arr[];
		arr = args.split(" ");
		if(arr.length == 2)
			addOwnerStay(hw, arr[0], arr[1]);	//funciona na fase 1
		else rentHome(hw, arr[0], arr[1], arr[2]);	//nao funciona na fase 1
	}
	
	private static void rentHome(HomeAway hw, String userID, String homeID, String score){
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
	
	private static void listStaysByUser(HomeAway hw, Scanner in) {
		String userId = in.next();
		in.nextLine();
		
		try {
			Home homeList[] = hw.getUserRents(userId);
			Home h = homeList[0];
			for(int i = 0; i < homeList.length; i++)
				System.out.printf(CHECK_STAYS_SUCCESS, h.getHomeID(), h.getDescription(), h.getAddress(), h.getLocal(), h.getPrice(), h.getCapacity(), h.getScore());
		}
		catch(UserDoesNotExistsException e) {
			System.out.println(ERR_USER_NOT_EXIST);
		}
		catch(UserIsNotOwnerException e) {
			System.out.println(ERR_USER_DID_NOT_TRAVEL);
		}
	}
	
	//idHome descricao morada local preco pessoas pontos
	private static void listUser(HomeAway hw, Scanner in){
		String userID = in.next();
		in.nextLine();
		
		try {
			Home home = hw.getOwnerHomes(userID);
			System.out.printf(CHECK_STAYS_SUCCESS, home.getHomeID(), home.getDescription(), home.getAddress(), home.getLocal(), home.getPrice(), home.getCapacity(), home.getScore());
		} catch (UserDoesNotExistsException e) {
			System.out.println(ERR_USER_NOT_EXIST);
		} catch (UserIsNotOwnerException e){
			System.out.println(ERR_USER_NOT_OWNER);
		}
		
		
	}
	
	private static void searchHomes(HomeAway hw, Scanner in) {
		int capacity = in.nextInt();
		String local = in.next();
		in.nextLine();
		
		try {
			Home h = hw.searchHome(capacity, local);
			System.out.printf(CHECK_STAYS_SUCCESS, h.getHomeID(), h.getDescription(), 
							  h.getAddress(), h.getLocal(), h.getPrice(), h.getCapacity(), h.getScore());
		}
		catch(InvalidDataException e) {
			System.out.println(ERR_INVALID_DATA);
		}
		catch(NoResultsException e) {
			System.out.println(ERR_SEARCH_NO_RESULTS);
		}
	}
	
	private static void listTopHome(HomeAway hw, Scanner in){
		String local = in.next();
		in.nextLine();
		try {
			Home home = hw.topHomes(local);
			System.out.printf(CHECK_STAYS_SUCCESS, home.getHomeID(), home.getDescription(), home.getAddress(), home.getLocal(), home.getPrice(), home.getCapacity(), home.getScore());
		} catch (NoResultsException e) {
			System.out.println(ERR_SEARCH_NO_RESULTS);
		}
	}
	
	
	
	private static void save(Object o) throws FileNotFoundException, IOException{
		String desktop = System.getProperty("user.home") + "/Desktop"; 
		ObjectOutputStream  outStream = new ObjectOutputStream(new FileOutputStream(desktop+"/homeAway.o"));
		outStream.writeObject(o);
		outStream.close();
	}
	
	private static Object load() throws FileNotFoundException, IOException, ClassNotFoundException{
		try {
		String desktop = System.getProperty("user.home") + "/Desktop"; 
		//File file = new File(desktop + "/homeAway.o");
		ObjectInputStream  inStream = new ObjectInputStream(new FileInputStream(desktop+"/homeAway.o"));
		Object o = inStream.readObject();
		inStream.close();
		return o;
		} catch(ClassNotFoundException e) {
			System.out.println("error with the file");
			return null;
		} catch(FileNotFoundException e) {
			return new HomeAwayClass();
		}
	}
	
	
	
	
}
