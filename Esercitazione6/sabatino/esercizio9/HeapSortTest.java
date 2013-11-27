package sabatino.esercizio9;

import sabatino.testVari.Cronometro;
import sabatino.testVari.RandomArrays;

public class HeapSortTest {
	public static void main(String[]args){
		Cronometro c = new Cronometro();
		int[] array = RandomArrays.randomIntArray(20000000);
		c.start();
		HeapSort.hSort(array);
		c.stop();
		System.out.println("lunghezza: "+array.length+" tempo: "+c.getElapsedTime()+" ordinato: "+ordinato(array,array.length));
	}
	
	static boolean ordinato(int a[],int n) {
  	for(int i = 1; i < n-1; i++) if(a[i-1] > a[i]) return false;
	return true;
  }
}
