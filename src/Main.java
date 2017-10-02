
/**
 *
 * @author Joao Monteiro
 */

import java.util.Scanner;

import HomeAway.HomeAway;
import HomeAway.HomeAwayClass;
import HomeAway.Exceptions.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
	
	//system messages
	private static final String USER_INSERT_SUCCESS = "Insercao de utilizador com sucesso.";
	private static final String USER_UPDATE_SUCCESS = "Utilizador atualizado com sucesso.";
	private static final String USER_REMOVE_SUCCESS = "Utilizador removido com sucesso.";
	private static final String CHECK_USER_DATA_SUCCESS = "%s: %s, %s, %s, %s"; //name, address, nationality, email, phone number
	private static final String HOME_ADD_SUCCESS = "Propriedade adicionada com sucesso.";
	private static final String HOME_REMOVE_SUCCESS = "Propriedade removida com sucesso.";
	private static final String CHECK_HOME_DATA_SUCCESS = "%s: %s, %s, %d, %d, %d, %s"; //description, address, local, price, capacity, score, name
	private static final String STAY_INSERT_SUCCESS = "Estadia adicionada com sucesso.";
	
	private static final String SAVE_AND_QUIT = "Gravando e terminando.";
	
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
	

    public static void main(String[] args) {
        HomeAway a = new HomeAwayClass();
        interpreter(a);
    }
    
    private static void interpreter(HomeAway a) {
    	Scanner in = new Scanner(System.in);
    	String option = in.next(); in.nextLine();
    	
    	while(!option.equals(CMD_EXIT_SAVE)) {
    		switch(option) {
    			case CMD_INSERT_USER:
    				addUser(a, in);
    				break;
    			case CMD_UPDATE_USER:
    				editUser(a, in);
    				break;
    			case CMD_REMOVE_USER:
    				removeUser(a, in);
    				break;
    			case CMD_GET_USER:
    				checkData(a, in);
    				break;
    			case CMD_ADD_HOME:
    				addHome(a, in);
    			default:
    				System.out.println("wrong command");
    		}
    		option = in.next(); in.nextLine();
    	}
    	
    }
    
    private static void addUser(HomeAway a, Scanner in) {
    	String idUser = in.next();
    	String email = in.next();
    	String phone = in.next();
    	String name = in.next();
    	in.nextLine();
    	
    	String nationality = in.nextLine();
    	String address = in.nextLine();
    	
    	try {
    		a.addUser(idUser, email, phone, name, nationality, address);
    		System.out.println(USER_INSERT_SUCCESS);
    	} 
    	catch(UserAlreadyExistsException e) {
    		System.out.println(ERR_USER_EXIST);
    	}
    }
    
    private static void editUser(HomeAway a, Scanner in) {
    	String userId = in.next();
    	String email = in.next();
    	String phone = in.next();
    	in.nextLine();
    	
    	String address = in.nextLine();
    	
    	try {
    		a.editUser(userId, email, phone, address);
    		System.out.println(USER_UPDATE_SUCCESS);
    	}
    	catch(UserDoesNotExistsException e) {
    		System.out.println(ERR_USER_NOT_EXIST);
    	}
    }
    
    private static void removeUser(HomeAway a, Scanner in) {
    	String userId = in.next();
    	in.nextLine();
    	
    	try {
    		a.removeUser(userId);
    		System.out.println(USER_REMOVE_SUCCESS);
    	}
    	catch(UserDoesNotExistsException e) {
    		System.out.println(ERR_USER_NOT_EXIST);
    	}
    	catch(UserHasHomeToRent e) {
    		System.out.println(ERR_USER_IS_OWNER);
    	}
    }
    
    private static void checkData(HomeAway a, Scanner in) {
    	String userId = in.next();
    	in.nextLine();
    	
    	try {
    		a.getUserInfo(userId);
    	}
    	catch(UserDoesNotExistsException e) {
    		System.out.println(ERR_USER_NOT_EXIST);
    	}
    }
    
    private static void addHome(HomeAway a, Scanner in) {
    	String homeId = in.next();
    	String userId = in.next();
    	int price = in.nextInt();
    	int capacity = in.nextInt();
    	String location = in.next();
    	in.nextLine();
    	
    	String description = in.nextLine();
    	String address = in.nextLine();
    	
    	try {
    		a.addHome(homeId, userId, price, capacity, address, location, description);
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
    
    private static void removeHome(HomeAway a, Scanner in) {
    	String homeId = in.next();
    	in.nextLine();
    	
    	try {
    		a.removeHome(homeId);
    		System.out.println(HOME_REMOVE_SUCCESS);
    	}
    	catch(HomeDoesNotExists e) {
    		System.out.println(ERR_PROPERTY_NOT_EXIST);
    	}
    	catch(HomeAlreadyVisited e) {
    		System.out.println(ERR_PROPERTY_ALREADY_VISITED);
    	}
    }
    
    
    
    
    
    private static void save(Object o) throws FileNotFoundException, IOException{
        String desktop = System.getProperty("user.home") + "/Desktop"; 
        ObjectOutputStream  outStream = new ObjectOutputStream(new FileOutputStream(desktop+"/homeAway.o"));
        outStream.writeObject(o);
        outStream.close();
    }
    
    private static Object load() throws FileNotFoundException, IOException, ClassNotFoundException{
        String desktop = System.getProperty("user.home") + "/Desktop"; 
        ObjectInputStream  inStream = new ObjectInputStream(new FileInputStream(desktop+"/homeAway.o"));
        Object o = inStream.readObject();
        inStream.close();
        return o;
    }
    
    
    
    
}
