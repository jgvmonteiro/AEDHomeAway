package HomeAway;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Joao Monteiro
 */
public class UserClass implements User, Serializable{
    
    private String userID, email, phone, name, nationality, address;
    private Home homeToRent;
    private List<Home> visited;
    
    public UserClass(String userID, String name, String email, String phone, String nationality, String address) {
        this.userID = userID;
        this.email = email;
        this.phone = phone;
        this.name = name;
        this.nationality = nationality;
        this.address = address;
        this.visited = new ArrayList<Home>();
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

    protected void setEmail(String email) {
        this.email = email;
    }

    
    protected void setPhone(String phone) {
        this.phone = phone;
    }

    
    protected void setAddress(String address) {
        this.address = address;
    }

    @Override
    public Home getHomeToRent() {
        return homeToRent;
    }

    @Override
    public Iterator<Home> getVisitedHomes() {
        return visited.iterator();
    }

    @Override
    public int visitedHomesCount() {
        return visited.size();
    }

    @Override
    public boolean hasHomeToRent() {
        return homeToRent!=null;
    }
 
    
    protected void setHomeToRent(Home home){
        this.homeToRent = home;
    }
    
    protected void newRent(Home home){
        visited.add(home);
    }
    
    
    

}
