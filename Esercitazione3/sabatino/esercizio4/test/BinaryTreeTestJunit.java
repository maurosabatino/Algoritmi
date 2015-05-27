package sabatino.esercizio4.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Test;

import sabatino.esercizio4.BinaryTree;

public class BinaryTreeTestJunit {
	private static BinaryTree bt = new BinaryTree();
	private static BinaryTree copy = new BinaryTree();
	private static BinaryTree mirror = new BinaryTree();
	
	@Test
	public void test(){
		//appena creato l'albero è vuoto
		assertTrue(bt.isEmpty());
		//aggiungo un elemento e testo se è presente
		bt.add(3,"");
		assertTrue(bt.search(3));
		//aggiungo un elemento ad un albero che sarà la copia e testo se i due alberi sono uguali
		copy.add(3, "");
		assertTrue(bt.equalTo(copy));
		//testo se l'albero con un solo nodo ha altezza 0
		assertEquals(0, bt.height());
		//aggiungo altri due nodi e testo se l'altezza è uguale a 2
		bt.add(4, "L");
		bt.add(5, "LR");
		assertEquals(2, bt.height());
		//testo se la somma dei valori dei nodi è corretta
		assertEquals(12, bt.sum());
		//testo se il numero dei nodi è 3
		assertEquals(3, bt.size());
		//testo se il numero di foglie è 1
		assertEquals(1, bt.numberOfLeaves());
		//creo un albero speculare e confronto questo con l'albero generato dal metodo mirror
		mirror.add(3, "");
		mirror.add(4, "R");
		mirror.add(5, "RL");
		assertTrue(bt.mirror().equalTo(mirror));
		//taglio l'albero per riportarlo uguale alla copia e testo se dopo il taglio sono uguali
		assertTrue(bt.trimmed(1).equalTo(copy.trimmed(1)));
		assertFalse(bt.trimmed(1).search(5));
		assertTrue(bt.trimmed(1).search(3));
		//testo se l'albero è 1 bilanciato
		assertTrue(bt.is1Balanced());
		bt.add(6,"LRR" );
		assertFalse(bt.is1Balanced());
		assertEquals(15, bt.sommaDiscendenti(4));
		
		//assertTrue(bt.equalTo(bt.copy()));
		assertEquals(1, bt.numNodesAtLevel(1));
		bt.add(3,"");
		bt.add(4, "L");
		bt.add(5, "LR");
		bt.add(6,"LRR" );
		
	}
	


}
