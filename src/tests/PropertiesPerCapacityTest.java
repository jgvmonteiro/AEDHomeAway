package tests;


import static org.junit.Assert.*;

import org.junit.Test;

import dataStructures.Iterator;
import homeAway.*;

public class PropertiesPerCapacityTest {

	@Test
	public void test() {
		
		HomeAway hw = new HomeAwayClass();
		
		
		hw.addUser("user", "name", "email", "phone", "address", "nationality");
		
		int id = 0;
		
		for (int k = 0; k < 15; k++) {
			for (int j = 1; j <= 20; j++) {
				for (int i = 0; i < 50; i++) {
					hw.addHome("id"+id++, "user", 222, j, "address", "local"+k, "description");
				}
			}
		}
		long start = System.currentTimeMillis();
		//execute logic in between

		Iterator<HomeInfo> it = hw.searchHome(19, "local4");
		
		while(it.hasNext()){
			HomeInfo h = it.next();
			System.out.println("id="+h.getHomeID()+", local="+h.getLocal()+", max people="+h.getCapacity());
		}
		
		long end = System.currentTimeMillis();
		System.out.println("\n\nDEBUG: Search took " + (end - start) + " MilliSeconds");
		
	}
	
	
	@Test
	public void RemoveTest(){
		
		HomeAway hw = new HomeAwayClass();
		hw.addUser("user", "name", "email", "phone", "address", "nationality");
	
		hw.addHome("id0", "user", 222, 1, "address", "local0", "description");
		hw.addHome("id1", "user", 222, 2, "address", "local0", "description");
		hw.addHome("id2", "user", 222, 2, "address", "local0", "description");
		hw.addHome("id3", "user", 222, 4, "address", "local0", "description");
		
		hw.removeHome("id1");
		hw.removeHome("id2");
		
		Iterator<HomeInfo> it = hw.searchHome(1, "local0");
		
		while(it.hasNext()){
			HomeInfo h = it.next();
			System.out.println("id="+h.getHomeID()+", local="+h.getLocal()+", max people="+h.getCapacity());
		}
		
		
	}
	

}
