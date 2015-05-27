package sabatino.esercizio13.AVLTree.test;

import static org.junit.Assert.*;

import org.junit.Test;

import sabatino.esercizio13.AVLTree.AVLTree;
import sabatino.esercizio13.AVLTree.Elem;

public class AVLTreeTest {
	private static AVLTree  avl = new AVLTree();
	
	@Test
	public void testAVL() {
		assertTrue(avl.isEmpty());
		avl.put(new Elem("primo", 1));
		avl.put(new Elem("secondo", 2));
		avl.put(new Elem("terzo", 3));
		assertTrue(avl.contains(2));
		avl.remove(2);
		assertFalse(avl.contains(2));
		assertTrue(avl.checkBalanceBoolean());
		assertTrue(avl.contains(1));
		avl.remove(1);
		assertFalse(avl.contains(1));
		assertTrue(avl.checkBalanceBoolean());
		assertTrue(avl.contains(3));
		avl.remove(3);
		assertFalse(avl.contains(3));
		assertTrue(avl.isEmpty());
	}

}
