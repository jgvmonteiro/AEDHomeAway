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

		
		l.add("test1");
		l.add("test4");
		l.add("test0");
		l.add("test3");
		l.add("test2");
		
		Iterator<String> it = l.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
		
	}

}
