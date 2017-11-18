package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import dataStructures.ChainedHashTable;
import dataStructures.Dictionary;
import dataStructures.Entry;
import dataStructures.Iterator;

public class RehashTableTest {

	@Test
	public void test() {


		Dictionary<String, String> d = new ChainedHashTable<String, String>(50);
		
		//for (int i = 0; i < 5; i++) {
		//	d.insert("key"+i, "value"+i);
		//}
		

		
		//d.insert("key"+8, "value"+8);
		
		for (int i = 0; i < 100; i++) {
			d.insert("key"+i, "value"+i);
		}
		
		//for (int i = 99; i > -1; i--) {
		//	d.insert("key"+i, "value"+i);
		//}
		
		Iterator<Entry<String, String>> it = d.iterator();
		int c = 0;
		while(it.hasNext()){
			Entry<String,String> e = it.next();
			System.out.println(e.getKey()+" => "+e.getValue());
			c++;
		}
		System.out.println("\nCounted "+c+" entries.");
		
	}

}
