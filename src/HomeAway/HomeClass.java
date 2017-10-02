package HomeAway;

import java.io.Serializable;

/**
 *
 * @author Joao Monteiro
 */
public class HomeClass implements Home, Serializable{

    private String homeID, ownerID, local;
    private int price, capacity, score;
    private boolean visited;

    public HomeClass(String homeID, String ownerID, String local, int price, int capacity) {
        this.homeID = homeID;
        this.ownerID = ownerID;
        this.local = local;
        this.price = price;
        this.capacity = capacity;
        this.score = 0;
        this.visited = false;
    }

    @Override
    public String getOwnerID() {
        return ownerID;
    }

    @Override
    public String getHomeID() {
        return homeID;
    }

    @Override
    public String getLocal() {
        return local;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public boolean visited() {
        return visited;
    }

    @Override
    public int getScore() {
        return score;
    }
    
    
    protected void newRent(){
        this.visited = true;
    }
    
    
    
    
    
    
    
}
