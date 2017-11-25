package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import dataStructures.Iterator;
import homeAway.HomeAway;
import homeAway.HomeAwayClass;
import homeAway.HomeInfo;

public class topHomesSearchTest {

	@Test
	public void test() {
		
		HomeAway hw = new HomeAwayClass();
		
		hw.addUser("user0", "name0", "email0", "phone0", "address0", "nationality0");
		hw.addUser("user1", "name0", "email0", "phone0", "address0", "nationality0");
		
		for (int i = 0; i < 10; i++) {
			hw.addHome("home"+i, "user0", 20, 10, "adress", "local0", "description");
		}
	
		hw.rentHome("user1", "home1", 10);
		hw.rentHome("user1", "home2", 20);
		hw.rentHome("user1", "home7", 10);
		hw.rentHome("user1", "home1", 11);
		
		Iterator<HomeInfo> it = hw.topHomes("local0");
		
		while(it.hasNext())
			System.out.println(it.next().getHomeID());
		
		
		
	}

}
