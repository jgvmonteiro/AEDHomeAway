package dataStructures;

import static org.junit.Assert.*;

import org.junit.Test;

public class AVLRemoveTest {
	
	private AVLTree<Integer, String> tree;
	
	@Test
	public void createAVL() {
		System.out.println("\n\n#### createAVL ####");
		_createAVL(10);
		
		Iterator<Entry<Integer, String>> it = tree.iterator();
		int c = 0;
		while (it.hasNext()) {
			Entry<Integer, String> entry = it.next();
			//assertEquals((int)entry.getKey(), c++); 
			System.out.println("key"+entry.getKey()+" == "+entry.getValue());
			c++;
		}
		assertEquals(10, c);
		
	}
	
	private void _createAVL(int nElements){
		tree = new AVLTree<Integer, String>();
		
		for (int i = 0; i < nElements; i++) {
			tree.insert(i, "value"+i);
		}
	}
	
	
	private void print() {
		System.out.println("\n");
		Iterator<Entry<Integer, String>> it = tree.iterator();
		while (it.hasNext()) {
			Entry<Integer, String> entry = it.next();
			System.out.println("key"+entry.getKey()+" == "+entry.getValue());
			
		}
		System.out.println();
	}
	
	private void printTree() {
		System.out.println();
		BTreePrinter.printNode(tree.root);
		BSTKeyOrderIteratorTEST<Integer, String> it = new  BSTKeyOrderIteratorTEST<Integer, String>(tree.root);
		int c=1;
		while (it.hasNext()) {
			AVLNode<Integer, String> node = (AVLNode<Integer, String>) it.next();
			System.out.print("key"+node.getKey()+"=>"+node.getBalance()+"  ");
			if(c==5){
				System.out.println();
				c=0;
			}
			c++;
		}
		
		System.out.println();
	}
	
	
	@Test
	public void simpleRemove() {
		System.out.println("\n\n#### simpleRemove ####");
		_createAVL(4);
		tree.remove(2);
		printTree();
	}

	@Test
	public void removeRotate() {
		System.out.println("\n\n#### removeRotate ####");
		_createAVL(10); //10
		System.out.println("Original:");
		printTree();
		int originalSize = tree.size();
		System.out.println("Removed 8:");
		tree.remove(8);
		printTree();
		System.out.println("Removed 2:");
		tree.remove(2);
		printTree();
				
		assertEquals(tree.size(), originalSize - 2);
		tree.remove(1);
		assertEquals(tree.size(), originalSize - 3);
		System.out.println("Removed 1");
		printTree();
	}
	
	@Test
	public void removeRoot() {
		
		System.out.println("\n\n#### removeROOT ####");
		
		_createAVL(10);
		int originalSize = tree.size();
		tree.remove(3);		//three is the root
		printTree();
	}
	
	
	@Test
	public void removeTest2(){
		System.out.println("\n\n#### removeTest2 ####");
		_createAVL(1500);
		tree.remove(100);
		tree.remove(203);
		tree.remove(202);
		tree.remove(652);
		tree.remove(701);
		tree.remove(1499);
		tree.remove(0);
		Iterator<Entry<Integer, String>> it = tree.iterator();
		int last = -1;
		while (it.hasNext()) {
			Entry<Integer, String> entry = it.next();
			assertTrue(last<entry.getKey());
			last = entry.getKey();
			//System.out.println("key"+entry.getKey()+" == "+entry.getValue());
		}
		//printTree();
		
	}
	
	
	@Test
	public void normalAVL() {
		_createAVL(10);
		printTree();
	}
	
	@Test
	public void nodeEmptySubtree() {
		System.out.println("\n\n#### nodeEmptySubtree ####");

		tree = new AVLTree();
		tree.insert(15, "15");
		tree.insert(8, null);		
		tree.insert(28, null);
		tree.insert(4, null);
		tree.insert(16, null);
		tree.insert(32, null);
		tree.insert(45, null);
		
		printTree();
		
		tree.remove(8);
		
		printTree();
		System.out.println("\n\n#### end ####");

	}

	@Test
	public void removedoubleChild(){
		tree = new AVLTree();
		System.out.println("\n\n#### removedoublechild ####");

		
		tree.insert(15, null);
		tree.insert(8, null);
		tree.insert(28, null);
		tree.insert(4, null);
		tree.insert(16, null);
		tree.insert(32, null);
		tree.insert(30, null);
		tree.insert(45, null);
		printTree();
		
		tree.remove(28);
		
		printTree();
		
		System.out.println("\n\n#### end ####");

	}
	
	@Test
	public void removeRootClassExample(){
		tree = new AVLTree();
				
		tree.insert(10, null);
		tree.insert(2, null);
		tree.insert(17, null);
		tree.insert(1, null);
		tree.insert(15, null);
		tree.insert(7, null);
		tree.insert(5, null);
		printTree();
		tree.remove(10);
		printTree();
	}
	
	@Test
	public void simpleRemoveClassExample(){
		tree = new AVLTree();
				
		tree.insert(15, null);
		tree.insert(6, null);
		tree.insert(17, null);
		tree.insert(2, null);
		tree.insert(8, null);
		printTree();
		tree.remove(17);
		printTree();
	}
	

}
