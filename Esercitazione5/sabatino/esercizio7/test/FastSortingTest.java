package sabatino.esercizio7.test;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import sabatino.esercizio5.utility.RandomArrays;
import sabatino.esercizio7.FastSorting;


public class FastSortingTest {

	private static enum Algorithm{
		 MergeSortWithSingleAuxiliaryArray,
		 MergeSortNoMergeOnSorted,
		 MergeSortJavaAPIVersion, 	
		 QuickSortMidToExamine, 	
		 QuickSortHoare,	
		 QuickSortCrescenzi
	 }
	static int N = 100000;//soglia dovuta alla dimensione dello heap, altrimenti solleva l'eccezione stack overflow
	static int[] array;
  static int[] inverse;
  static int[] repeated;
  static int[] empty;
  static int[] maxInt;
  static int[] yetSorted;
  static int[] partiallyOrdered;
	
  @Test
	public void randomTest() {
		for(Algorithm algo : Algorithm.values()){	
			array = RandomArrays.randomIntArray(N);
			sort(algo, array);
			assertTrue(""+algo+"sort random",sorted(array,N));
		}
	}
	
	@Test
	public void inverseTest() {
		for(Algorithm algo : Algorithm.values()){	
			inverse = reverse(inverse,N);
			assertFalse(sorted(inverse,N));
			sort(algo, inverse);
			assertTrue(""+algo+"sort inverse",sorted(inverse,N));inverse = reverse(inverse,N);
		}
	}
	
	@Test
	public void repeatedTest() {
		for(Algorithm algo : Algorithm.values()){	
			repeated = repeatedElements(N, 8);
			sort(algo, repeated);
			assertTrue("selection sort repeated",sorted(repeated,N));
		}		
	}
	
	@Test
	public void emptyTest() {
		for(Algorithm algo : Algorithm.values()){	
			empty = new int[N];
			sort(algo, empty);
			assertTrue("array null",sorted(empty,N));
		}
	}
	
	@Test
	public void maxIntTest() {
		for(Algorithm algo : Algorithm.values()){	
			maxInt = maxInt(N);
			sort(algo, maxInt);
			assertTrue("array di Integer.MAX_VALUE", sorted(maxInt,N));
		}
	}
	
	@Test
	public void yetSortedTest() {
		for(Algorithm algo : Algorithm.values()){	
		yetSorted = RandomArrays.randomIntArray(N);
		Arrays.sort(yetSorted);
		sort(algo, yetSorted);
		assertTrue("array già ordinato", sorted(yetSorted,N));
		}
		
	}
	
	@Test
	public void partiallyOrderedTest() {
		for(Algorithm algo : Algorithm.values()){	
		partiallyOrdered = partiallyOrdered(N);
		assertFalse("array parzialmente ordinato", sorted(partiallyOrdered,N));
		sort(algo, partiallyOrdered);
		assertTrue("array parzialmente ordinato", sorted(partiallyOrdered,N));
		}
	}
	
	
	
	public static void sort(Algorithm algo,int[]array){
		switch(algo) {
		case MergeSortWithSingleAuxiliaryArray:FastSorting.MergeSortWithSingleAuxiliaryArray(array); break;
		case MergeSortNoMergeOnSorted:FastSorting.MergeSortNoMergeOnSorted(array); break;
		case MergeSortJavaAPIVersion:FastSorting.MergeSortJavaAPIVersion(array);break;
		case QuickSortMidToExamine:FastSorting.QuickSortMidToExamine(array); break;
		case QuickSortHoare:FastSorting.QuickSortHoare(array);break;	
		case QuickSortCrescenzi:FastSorting.QuickSortCrescenzi(array);break;
		}
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
