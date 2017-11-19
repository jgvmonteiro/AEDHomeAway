package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import dataStructures.BinarySearchTree;
import dataStructures.Entry;
import dataStructures.Iterator;
import dataStructures.OrderedDictionary;

public class BinarySearchTree_OrderTest {

	@Test
	public void test() {
		
		OrderedDictionary<String, String> tree = new BinarySearchTree<String, String>();
		
		for (int i = 10; i < 20; i++) {
			tree.insert("key"+i, "value"+i);
		}
		
		for (int i = 5; i >= 0; i--) {
			tree.insert("key"+i, "value"+i);
		}
		
		
		
		
		Iterator<Entry<String,String>> it  = tree.iterator();
		
		while (it.hasNext()) {
			Entry<String, String> entry = (Entry<String, String>) it.next();
			System.out.println(entry.getKey()+"="+entry.getValue());
		}
		
	}

}
