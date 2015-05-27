package sabatino.esercizio1.test;

import java.util.Random;

import sabatino.esercizio1.IntSortedArray;

public class IntSortedArrayTest {
	static int  N = 9000;
	static Random generatore = new Random();
	public static void main(String[] args) {
		IntSortedArray ia = new IntSortedArray(3);
		ia.insert(7);
		ia.insert(3);
		ia.insert(5);
		ia.insert(8);
		ia.print();
		System.out.println();
		System.out.println("indice dell'elemnto 5? "+ia.binarySearch(5));
		for(int i = 0;i<N;i++){
			ia.insert(generatore.nextInt(N));
		}
		System.out.println("è ordinato? "+ordinato(ia,ia.size()));
		int random = generatore.nextInt(N);
		System.out.println("indice del numero random? "+ia.binarySearch(random));
		
	}
	/**
	 * metodo che testa se un oggetto IntSortedArray è ordinato correttamente
	 * @param a
	 * @param n
	 * @return
	 */
	static boolean ordinato(IntSortedArray ia,int n) {
  	for(int i = 1; i < n; i++) if(ia.get(i-1)>ia.get(i)) return false;
	return true;
  }

}
