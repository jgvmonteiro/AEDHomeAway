package HomeAway;
/**
 *
 * @author Joao Monteiro
 */
public class HomeClass implements Home{

    private String homeID, ownerID, local;
    private int price, capacity, score;
    private User visitor;

    public HomeClass(String homeID, String ownerID, String local, int price, int capacity) {
        this.homeID = homeID;
        this.ownerID = ownerID;
        this.local = local;
        this.price = price;
        this.capacity = capacity;
        this.score = 0;
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
    public User getVisitors() {
        return visitor;
    }

    @Override
    public int getScore() {
        return score;
    }
    
    
    protected void addVisitor(User visitor){
        this.visitor = visitor;
    }
    
    
    
    
    
    
    
}
