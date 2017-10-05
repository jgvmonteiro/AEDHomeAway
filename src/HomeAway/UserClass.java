package HomeAway;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Joao Monteiro
 */
public class UserClass implements User{
	
	private String userID, email, phone, name, nationality, address;
	private Home homeToRent;
	private Home visited;
	
	private int visitedAmount;
	
	public UserClass(String userID, String name, String email, String phone, String nationality, String address) {
		this.userID = userID;
		this.email = email;
		this.phone = phone;
		this.name = name;
		this.nationality = nationality;
		this.address = address;
		this.visited = null;
		
		this.visitedAmount = 0;
	}

	@Override
	public String getID() {
		return userID;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public String getPhone() {
		return phone;
	}

	@Override
	public String getNationality() {
		return nationality;
	}

	@Override
	public String getAddress() {
		return address;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
   
	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public Home getHomeToRent() {
		return homeToRent;
	}

	@Override
	public Home[] getVisitedHomes() {
		Home[] homeList = new Home[visitedAmount];
		homeList[0] = visited;
		return homeList;
	}

	@Override
	public int visitedHomesCount() {
		return visited == null? 0 : 1;
	}

	@Override
	public boolean hasHomeToRent() {
		return homeToRent != null;
	}

	public void setHomeToRent(Home home){
		this.homeToRent = home;
	}
	
	public void newRent(Home home){
		incVisitedAmount();
		visited = home;
	}
	
	public void incVisitedAmount() {
		visitedAmount++;
	}

	public int getVisitedAmount() {
		return visitedAmount;
	}
	
}
