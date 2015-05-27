package sabatino.esercizio9.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import sabatino.esercizio9.HeapSort;

public class HeapSortTest {
	
	/*tipi di array testati
	 * -random
	 * -ordinato al contrario
	 * -elementi ripetuti
	 * -vuoto
	 * -riempito con Integer.MAX_VALUE
	 * -array già ordinato
	 * -array parzialmente ordinato
	 * */
	private static Random generatore = new Random();
	
	static final int N = 99999;
	
	static int[] random = new int[N];
  static int[] inverse = new int[N];
  static int[] repeated = new int[N];
  static int[] empty = new int[N];
  static int[] maxInt = new int[N];
  static int[] yetSorted = new int[N];
  static int[] partiallyOrdered = new int[N];
  
	@Before
	public void setUp(){
		fillRandomNatArray(random, N, 9*N/10);
		reverse(inverse,N);
		repeatedElements(repeated, N, 34);
		maxInt(maxInt, N);
		yetOrdered(yetSorted, N);
		partiallyOrdered(partiallyOrdered, N);
	}
	@Test
	public void testRandom() {
		assertFalse(Ordinato(random, N));
		HeapSort.hSort(random);
		assertTrue(Ordinato(random, N));
	}
	@Test
	public void testReverse(){
		assertFalse(Ordinato(inverse, N));
		HeapSort.hSort(inverse);
		assertTrue(Ordinato(inverse, N));
	}
	@Test
	public void testRepeated(){
		assertTrue(Ordinato(repeated, N));
		HeapSort.hSort(repeated);
		assertTrue(Ordinato(repeated, N));
	}
	@Test
	public void testEmpty(){
		assertTrue(Ordinato(empty, N));
		HeapSort.hSort(empty);
		assertTrue(Ordinato(empty, N));
	}
	@Test
	public void testIntegerMaxValue(){
		assertTrue(Ordinato(maxInt, N));
		HeapSort.hSort(maxInt);
		assertTrue(Ordinato(maxInt, N));
	}
	@Test
	public void testSorted(){
		assertTrue(Ordinato(yetSorted, N));
		HeapSort.hSort(yetSorted);
		assertTrue(Ordinato(yetSorted, N));
	}
	@Test
	public void testPartiallyOrdered(){
		assertFalse(Ordinato(partiallyOrdered, N));
		HeapSort.hSort(partiallyOrdered);
		assertTrue(Ordinato(partiallyOrdered, N));
	}
	
	public static void fillRandomNatArray(int[] a, int n, int max) {
    if(n > a.length) throw new IllegalArgumentException();
    int sup = max+1;
    for(int i = 0; i < n; i++) {
      a[i] = generatore.nextInt(sup);
    }
  }
	
	static boolean Ordinato(int a[],int n) {
  	for(int i = 1; i < n-1; i++) if(a[i-1] > a[i]) return false;
	return true;
  }
	public static void reverse(int[] array,int n) {
		fillRandomNatArray(array, n, 9*n/10);
    Arrays.sort(array);
    for(int i=0;i<array.length/2;i++){
    	int temp=array[i];
    	array[i]=array[(array.length-1)-i];
    	array[(array.length-1)-i]=temp;
    }
    
	}
	public static void repeatedElements(int[]repeated, int n,int value){
		for(int i = 0;i<n;i++)
			repeated[i]=value;	
	}
	
	public static void maxInt(int[]array,int n){
		for(int i = 0;i<n;i++)
			array[i]=Integer.MAX_VALUE;	
	}
	public static void partiallyOrdered(int[]array,int n){
		fillRandomNatArray(array, n, 9*n/10);
		Arrays.sort(array,0,n/2);
	}
	public static void yetOrdered(int[]array,int n){
		fillRandomNatArray(array, n, 9*n/10);
		Arrays.sort(array,0,n);
		
	}


}
