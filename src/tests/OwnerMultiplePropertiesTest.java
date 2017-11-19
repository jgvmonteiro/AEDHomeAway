package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import dataStructures.Iterator;
import homeAway.HomeAway;
import homeAway.HomeAwayClass;
import homeAway.HomeInfo;

public class OwnerMultiplePropertiesTest {

	@Test
	public void test() {
		
		HomeAway hw = new HomeAwayClass();
		hw.addUser("user0", "name0", "email0", "phone0", "adress0", "nationalty0");
		hw.addUser("user1", "name1", "email1", "phone1", "adress1", "nationalty1");
		hw.addUser("user2", "name2", "email2", "phone2", "adress2", "nationalty2");
		
		hw.addHome("home4", "user0", 22, 5, "address", "local", "desc");
		hw.addHome("home2", "user0", 22, 5, "address", "local", "desc");
		hw.addHome("home6", "user0", 22, 5, "address", "local", "desc");
		hw.addHome("home0", "user0", 22, 5, "address", "local", "desc");
		hw.addHome("home5", "user0", 22, 5, "address", "local", "desc");
		hw.addHome("home1", "user0", 22, 5, "address", "local", "desc");
		hw.addHome("home10", "user0", 22, 5, "address", "local", "desc");
		hw.addHome("home32", "user0", 22, 5, "address", "local", "desc");
		hw.addHome("home30", "user0", 22, 5, "address", "local", "desc");
		hw.addHome("home11", "user0", 22, 5, "address", "local", "desc");
		
		hw.removeHome("home5");
		
		Iterator<HomeInfo> it = hw.getUserProperties("user0");
		while(it.hasNext()){
			HomeInfo h = it.next();
			System.out.println(h.getHomeID());
		}
		
		
	}

}
