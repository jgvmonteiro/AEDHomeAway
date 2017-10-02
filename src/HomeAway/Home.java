package HomeAway;

/**
 *
 * @author Joao Monteiro
 */
public interface Home {
    
    String getOwnerID();
    String getHomeID();
    String getLocal();
    String getAddress();
    int getCapacity();
    int getPrice();
    int getScore();
    boolean visited();
    String getDescription();
}
