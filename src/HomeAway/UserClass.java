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
	private Visits visited_;
	
	
	public UserClass(String userID, String name, String email, String phone, String nationality, String address) {
		this.userID = userID;
		this.email = email;
		this.phone = phone;
		this.name = name;
		this.nationality = nationality;
		this.address = address;
		this.visited_ = null;
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
	public Visits getVisitedHomes() {
		return visited_;
	}

	@Override
	public int visitedHomesCount() {
		return visited_ == null? 0 : 1;
	}

	@Override
	public boolean hasHomeToRent() {
		return homeToRent != null;
	}

	public void setHomeToRent(Home home){
		this.homeToRent = home;
	}
	
	public void newRent(Home home){
		if(visited_ == null)
			visited_ = new Visits(home);
		incVisitedAmount();
		
	}
	
	public void incVisitedAmount() {
		visited_.visit();
	}

	public int getVisitedAmount() {
		return visited_.getVisitations();
	}
	
}
