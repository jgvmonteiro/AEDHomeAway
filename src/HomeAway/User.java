package HomeAway;

import java.util.Iterator;

/**
 *
 * @author Joao Monteiro
 */
public interface User {

    
    String getID();
    String getName();
    String getEmail();
    String getPhone();
    String getNationality();
    String getAddress();
    Home getHomeToRent();
    Iterator<Home> getVisitedHomes();
    int visitedHomesCount();
}
