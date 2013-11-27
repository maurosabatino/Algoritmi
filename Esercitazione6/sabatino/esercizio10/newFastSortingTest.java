package sabatino.esercizio10;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class newFastSortingTest {
	private static PrintWriter out;
	
	 static Cronometro c = new Cronometro();
 static final int N = 2000001, STEP = 50000;
 static int[] array;
	 private static enum Algorithm{
		 MergeSortNoMergeOnSorted, 	
		QuickSortHoare,
		HeapSort
	 }
	public static void main(String[] args) throws IOException {
		String test = "tempiFast.csv";
	  FileWriter outFile = new FileWriter(test, false);
	  out = new PrintWriter(outFile);
	  out.println("arraySize;MergeSortWithSingleAuxiliaryArray;MergeSortNoMergeOnSorted;MergeSortJavaAPIVersion;QuickSortMidToExamine;QuickSortHoare;QuickSortCrescenzi");
	
	  for(int n = STEP; n < N; n += STEP) {
	  	array = RandomArrays.randomIntArray(n);
	  
	  	out.print(n+";");
	  	System.out.println(n+";");
	  	for(Algorithm algo : Algorithm.values()){
	  	out.print(time(algo,array)+";");
	  	System.out.println(algo.name()+" tempo:"+time(algo,array));
	  	}
	  	out.println();
	  	System.out.println();
	  	
	  	
	  }
	  out.close();

	}
	public static long time(Algorithm algo,int[]array){
		c.reset();
		int[] a = new int[array.length];
		copyArray(array,a);
		c.start();
		sort(algo,a);
		c.stop();
		return c.getElapsedTime() ;
	}
	public static void sort(Algorithm algo,int[]array){
		switch(algo) {
		case MergeSortNoMergeOnSorted:newFastSorting.MergeSortNoMergeOnSorted(array);break;
		case QuickSortHoare:newFastSorting.QuickSortHoare(array);break;	
		case HeapSort:newFastSorting.hSort(array);break;
		}
	}
	static boolean ordinato(int a[],int n) {
 	for(int i = 1; i < n-1; i++) if(a[i-1] > a[i]) return false;
	return true;
 }
	static void copyArray(int[] orig,int[] dest){
		for(int i = 0;i<dest.length;i++) dest[i] = orig[i];
	}
}
