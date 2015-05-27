package sabatino.esercizio4.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import sabatino.esercizio4.BinaryTree;

public class BinaryTreeTest {
	
	private static BinaryTree bt = new BinaryTree();
	
	public static void main(String[] args) {
		readFile("C:\\Users\\Mauro\\Desktop\\workspace\\Algoritmi\\AlgoritmiDaConsegnare\\src\\sabatino\\esercizio4\\tree.txt");
		bt.printPreOrder();
		bt.printEquiNodes();
		bt.putSize();
		bt.printPreOrder();
	}
	public static void readFile(String fileName) {
    try {
      Scanner input = new Scanner(new File(fileName));
      while(input.hasNextLine()) {
        String line = input.nextLine();
        Scanner lineScan = new Scanner(line);
        int elem = lineScan.nextInt();
        String path = lineScan.hasNext()? lineScan.next() : "";
        bt.add(elem, path);
        lineScan.close();
      }
      input.close();
    }
    catch(FileNotFoundException ex) {
      System.out.println("impossibile leggere il file " + fileName);
    }
    catch(Exception ex) {
      System.out.println("Bad input format - Eccezione: " + ex);
    }
  }

}
