package tests;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

import dataStructures.ChainedHashTable;
import dataStructures.Dictionary;
import dataStructures.Entry;
import dataStructures.Iterator;

public class CHTRehashTest {

	
	@Test
	public void insertRandomTest() {
		int elems = 11;
		
		
		
		
		Dictionary<Integer, Integer> cht = new ChainedHashTable<Integer, Integer>(1);
		Dictionary<Integer, Integer> mcht = new ChainedHashTable<Integer, Integer>(elems);
		insertRandy(cht, mcht, elems);
		
		Iterator<Entry<Integer, Integer>> it = cht.iterator();
		Iterator<Entry<Integer, Integer>> mit = mcht.iterator();
		
		int counter = 0;
		while (it.hasNext()) {
			it.next().getKey();
			counter++;
		}
		assertEquals(cht.size(),counter);	
		assertEquals(cht.size(), mcht.size());
		
		it = cht.iterator();
		assertTrue(it.hasNext());/*
		while(it.hasNext()) {
			assertEquals(it.next(), mit.next());
		}*/
		assertTrue(cht.remove(3) == 3);
		assertTrue(cht.remove(4) == 4);
		assertTrue(cht.remove(7) == 7);
		assertTrue(cht.remove(11) == 11);

		
		
	}

	private static void insertRandy(Dictionary<Integer, Integer> cht, Dictionary<Integer, Integer> mcht, int elems) {
		for(int i = 0; i <= elems; i++) {
			cht.insert(i, i);
			mcht.insert(i, i);
		}
	}
	
	private static void insertRandomElemsInBoth(Dictionary<Integer, Integer> cht, Dictionary<Integer, Integer> mcht, int elems) {
		Random rand = new Random();
		int i = 0;
		while (i < elems) {
			int e = rand.nextInt();
			mcht.insert(e, e);
			cht.insert(e, e);
			i = cht.size();
		}
	}
	
}
