package tests;

import static org.junit.Assert.*;


import org.junit.Test;

import dataStructures.Iterator;
import dataStructures.OrderedDoublyLinkedList;
import dataStructures.SortedList;

public class SortedListAddTest {

	@Test
	public void test() {
		
		SortedList<String> l = new OrderedDoublyLinkedList<String>();

		
		/*l.add("test1");
		l.add("test4");
		l.add("test0");
		l.add("test3");
		l.add("test2");
		*/
		
		for (int i = 499; i >= 0; i--) {
			l.add("test"+i);	
		}
		
		Iterator<String> it = l.iterator();
		int c = 0;
		while(it.hasNext()){
			System.out.println(it.next());
			c++;
		}
		System.out.println("\nCounted "+c+" entries.");
		
	}

}
