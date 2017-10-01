package HomeAway;

/**
 *
 * @author Joao Monteiro
 */
public interface Home {
    
    String getOwnerID();
    String getHomeID();
    String getLocal();
    int getCapacity();
    int getPrice();
    User getVisitors();
    int getScore();
    
}
