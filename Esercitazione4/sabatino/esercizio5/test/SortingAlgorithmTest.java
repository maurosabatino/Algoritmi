package sabatino.esercizio5.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;

import sabatino.esercizio5.InsertionSort;
import sabatino.esercizio5.MergeSort;
import sabatino.esercizio5.QuickSort;
import sabatino.esercizio5.SelectionSort;
import sabatino.esercizio5.SortingAlgorithm;
import sabatino.esercizio5.utility.RandomArrays;

public class SortingAlgorithmTest {

	static RandomArrays arrays = new RandomArrays();
  static SortingAlgorithm isort = new InsertionSort(); 
  static SortingAlgorithm ssort = new SelectionSort(); 
  static SortingAlgorithm msort = new MergeSort(); 
  static SortingAlgorithm qsort = new QuickSort(); 
  static int N = 9999; //numero basso per eseguire prima il test
  static int [] array;
  static int[] inverse;
  static int[] repeated;
  static int[] empty;
  static int[] maxInt;
  static int[] yetSorted;
  static int[] partiallyOrdered;
	@Test
	public void randomTest() {
		array = RandomArrays.randomIntArray(N);
		isort.sort(array);
		assertTrue("isertion sort random",sorted(array,N));
		
		array = RandomArrays.randomIntArray(N);
		ssort.sort(array);
		assertTrue("selection sort random",sorted(array,N));
		
		array = RandomArrays.randomIntArray(N);
		msort.sort(array);
		assertTrue("merge sort random",sorted(array,N));
		
		array = RandomArrays.randomIntArray(N);
		qsort.sort(array);
		assertTrue("quick sort random",sorted(array,N));
	}
	@Test
	public void inverseTest() {
		inverse = reverse(inverse,N);
		assertFalse(sorted(inverse,N));
		isort.sort(inverse);
		assertTrue("insertion sort inverse",sorted(inverse,N));inverse = reverse(inverse,N);
		
		assertFalse(sorted(inverse,N));
		ssort.sort(inverse);
		assertTrue("selection sort inverse",sorted(inverse,N));inverse = reverse(inverse,N);
		
		assertFalse(sorted(inverse,N));
		msort.sort(inverse);
		assertTrue("merge sort inverse",sorted(inverse,N));inverse = reverse(inverse,N);
		
		assertFalse(sorted(inverse,N));
		qsort.sort(inverse);
		assertTrue("quick sort inverse",sorted(inverse,N));
	}
	@Test
	public void repeatedTest() {
		repeated = repeatedElements(N, 8);
		ssort.sort(repeated);
		assertTrue("selection sort repeated",sorted(repeated,N));
		
		repeated = repeatedElements(N, 8);
		isort.sort(repeated);
		assertTrue("insertion sort repeated",sorted(repeated,N));
		
		repeated = repeatedElements(N, 8);
		msort.sort(repeated);
		assertTrue("merge sort repeated",sorted(repeated,N));
		
		repeated = repeatedElements(N, 8);
		qsort.sort(repeated);
		assertTrue("quick sort repeated",sorted(repeated,N));
		
	
		
		
		
	}
	
	@Test
	public void emptyTest() {
		empty = new int[N];
		ssort.sort(empty);
		assertTrue("array null",sorted(empty,N));
		
		empty = new int[N];
		isort.sort(empty);
		assertTrue("array null",sorted(empty,N));
		
		empty = new int[N];
		msort.sort(empty);
		assertTrue("array null",sorted(empty,N));
		
		empty = new int[N];
		qsort.sort(empty);
		assertTrue("array null",sorted(empty,N));
	}
	@Test
	public void maxIntTest() {
		maxInt = maxInt(N);
		ssort.sort(maxInt);
		assertTrue("array di Integer.MAX_VALUE", sorted(maxInt,N));
		
		maxInt = maxInt(N);
		isort.sort(maxInt);
		assertTrue("array di Integer.MAX_VALUE", sorted(maxInt,N));
		
		maxInt = maxInt(N);
		msort.sort(maxInt);
		assertTrue("array di Integer.MAX_VALUE", sorted(maxInt,N));
		
		maxInt = maxInt(N);
		qsort.sort(maxInt);
		assertTrue("array di Integer.MAX_VALUE", sorted(maxInt,N));
	}
	@Test
	public void yetSortedTest() {
		yetSorted = RandomArrays.randomIntArray(N);
		Arrays.sort(yetSorted);
		ssort.sort(yetSorted);
		assertTrue("array già ordinato", sorted(yetSorted,N));
		
		yetSorted = RandomArrays.randomIntArray(N);
		Arrays.sort(yetSorted);
		isort.sort(yetSorted);
		assertTrue("array già ordinato", sorted(yetSorted,N));
		
		yetSorted = RandomArrays.randomIntArray(N);
		Arrays.sort(yetSorted);
		msort.sort(yetSorted);
		assertTrue("array già ordinato", sorted(yetSorted,N));
		
		yetSorted = RandomArrays.randomIntArray(N);
		Arrays.sort(yetSorted);
		qsort.sort(yetSorted);
		assertTrue("array già ordinato", sorted(yetSorted,N));
	}
	@Test
	public void partiallyOrderedTest() {
		partiallyOrdered = partiallyOrdered(N);
		assertFalse("array parzialmente ordinato", sorted(partiallyOrdered,N));
		ssort.sort(partiallyOrdered);
		assertTrue("array parzialmente ordinato", sorted(partiallyOrdered,N));
		
		partiallyOrdered = partiallyOrdered(N);
		assertFalse("array parzialmente ordinato", sorted(partiallyOrdered,N));
		isort.sort(partiallyOrdered);
		assertTrue("array parzialmente ordinato", sorted(partiallyOrdered,N));
		
		partiallyOrdered = partiallyOrdered(N);
		assertFalse("array parzialmente ordinato", sorted(partiallyOrdered,N));
		msort.sort(partiallyOrdered);
		assertTrue("array parzialmente ordinato", sorted(partiallyOrdered,N));
		
		partiallyOrdered = partiallyOrdered(N);
		assertFalse("array parzialmente ordinato", sorted(partiallyOrdered,N));
		qsort.sort(partiallyOrdered);
		assertTrue("array parzialmente ordinato", sorted(partiallyOrdered,N));
	}
	
	
	static boolean sorted(int a[],int n) {
  	for(int i = 1; i < n-1; i++) if(a[i-1] > a[i]) return false;
  	return true;
  }
	static void copyArray(int[] orig,int[] dest){	
		for(int i = 0;i<dest.length;i++) dest[i] = orig[i];
	}
	
    
	public static int[] reverse(int[] array,int n) {
		array = RandomArrays.randomIntArray(N);
		Arrays.sort(array);
		for(int i=0;i<array.length/2;i++){
			int temp=array[i];
			array[i]=array[(array.length-1)-i];
			array[(array.length-1)-i]=temp;
		}
		return array;
	}
	public static int[] repeatedElements(int n,int value){
		int[] repeated = new int[n];
		for(int i = 0;i<n;i++)
			repeated[i]=value;	
		return repeated;
	}
	
	public static int[] maxInt(int n){
		int[] repeated = new int[n];
		for(int i = 0;i<n;i++)
			repeated[i]=Integer.MAX_VALUE;	
		return repeated;
	}
	public static int[] partiallyOrdered(int n){
		int [] partiallyOrdered = RandomArrays.randomIntArray(N);
		Arrays.sort(partiallyOrdered,0,n/2);
		return partiallyOrdered;
	}
	public static void printArray(int[]a,int n){
		for(int i = 0;i<n;i++)
			System.out.print("["+a[i]+"]");
		System.out.println("");
	}
	
}
