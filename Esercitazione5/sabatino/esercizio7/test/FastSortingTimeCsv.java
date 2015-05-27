package sabatino.esercizio7.test;

import java.io.*;
import java.util.Arrays;
import java.util.Random;

import sabatino.esercizio7.FastSorting;

public class FastSortingTimeCsv {
	private static PrintWriter out;
	private static Random generatore = new Random();
	 static Cronometro c = new Cronometro();
  static final int N = 2000001, STEP = 100000;
  
  static int[] random = new int[N];
  static int[] inverse = new int[N];
  static int[] yetSorted = new int[N];
  static int[] partiallyOrdered = new int[N];
	 private static enum Algorithm{
		 MergeSortWithSingleAuxiliaryArray,
		 MergeSortNoMergeOnSorted,
		 MergeSortJavaAPIVersion, 	
		 QuickSortMidToExamine, 	
		 QuickSortHoare,	
		 QuickSortCrescenzi
	 }
	 
	 public static void main(String[] args) throws IOException{
		 filledRandom();
		 filledRandomWhithLittleRepetition();
		 filledRandomWhitLotRepetition();
		 partiallyOrdered();
		 reverseOrdere();
		 yetSorted();
	 }
	 
	public static void filledRandom() throws IOException {
		String test = "tempiRandomFast.csv";
	  FileWriter outFile = new FileWriter(test, false);
	  out = new PrintWriter(outFile);
	  out.println("arraySize;MergeSortWithSingleAuxiliaryArray;MergeSortNoMergeOnSorted;MergeSortJavaAPIVersion;QuickSortMidToExamine;QuickSortHoare;QuickSortCrescenzi");
	  for(int n = STEP; n < N; n += STEP) {
	  	fillRandomNatArray(random, n, 9*n/10);
	  	out.print(n+";");
	  	System.out.println(n+";");
	  	for(Algorithm algo : Algorithm.values()){
	  	out.print(time(algo,random,n)+";");
	  	System.out.println(algo.name()+" tempo:"+time(algo,random,n));
	  	}
	  	out.println();
	  	System.out.println();
	  	
	  	
	  }
	  out.close();
	}
	public static void filledRandomWhithLittleRepetition() throws IOException {
		String test = "tempiRandomWhithLittleRepetition.csv";
	  FileWriter outFile = new FileWriter(test, false);
	  out = new PrintWriter(outFile);
	  out.println("arraySize;MergeSortWithSingleAuxiliaryArray;MergeSortNoMergeOnSorted;MergeSortJavaAPIVersion;QuickSortMidToExamine;QuickSortHoare;QuickSortCrescenzi");
	  for(int n = STEP; n < N; n += STEP) {
	  	fillRandomNatArray(random, n,10);
	  	out.print(n+";");
	  	System.out.println(n+";");
	  	for(Algorithm algo : Algorithm.values()){
	  	out.print(time(algo,random,n)+";");
	  	System.out.println(algo.name()+" tempo:"+time(algo,random,n));
	  	}
	  	out.println();
	  	System.out.println();
	  	
	  	
	  }
	  out.close();
	}
	public static void filledRandomWhitLotRepetition() throws IOException {
		String test = "tempiRandomFast.csv";
	  FileWriter outFile = new FileWriter(test, false);
	  out = new PrintWriter(outFile);
	  out.println("arraySize;MergeSortWithSingleAuxiliaryArray;MergeSortNoMergeOnSorted;MergeSortJavaAPIVersion;QuickSortMidToExamine;QuickSortHoare;QuickSortCrescenzi");
	  for(int n = STEP; n < N; n += STEP) {
	  	fillRandomNatArray(random, n, 1000);
	  	out.print(n+";");
	  	System.out.println(n+";");
	  	for(Algorithm algo : Algorithm.values()){
	  	out.print(time(algo,random,n)+";");
	  	System.out.println(algo.name()+" tempo:"+time(algo,random,n));
	  	}
	  	out.println();
	  	System.out.println();
	  }
	  out.close();
	}
	
	public static void reverseOrdere() throws IOException {
		String test = "tempireverseOrderedFast.csv";
	  FileWriter outFile = new FileWriter(test, false);
	  out = new PrintWriter(outFile);
	  out.println("arraySize;MergeSortWithSingleAuxiliaryArray;MergeSortNoMergeOnSorted;MergeSortJavaAPIVersion;QuickSortMidToExamine;QuickSortHoare;QuickSortCrescenzi");
	  for(int n = STEP; n < N; n += STEP) {
	  	reverse(inverse, n);
	  	out.print(n+";");
	  	System.out.println(n+";");
	  	for(Algorithm algo : Algorithm.values()){
	  	out.print(time(algo,inverse,n)+";");
	  	System.out.println(algo.name()+" tempo:"+time(algo,inverse,n));
	  	}
	  	out.println();
	  	System.out.println();
	  }
	  out.close();
	}
	
	public static void yetSorted() throws IOException {
		String test = "tempiSortedFast.csv";
	  FileWriter outFile = new FileWriter(test, false);
	  out = new PrintWriter(outFile);
	  out.println("arraySize;MergeSortWithSingleAuxiliaryArray;MergeSortNoMergeOnSorted;MergeSortJavaAPIVersion;QuickSortMidToExamine;QuickSortHoare;QuickSortCrescenzi");
	  for(int n = STEP; n < N; n += STEP) {
	  	ordinato(yetSorted,n);
	  	out.print(n+";");
	  	System.out.println(n+";");
	  	for(Algorithm algo : Algorithm.values()){
	  	out.print(time(algo,yetSorted,n)+";");
	  	System.out.println(algo.name()+" tempo:"+time(algo,yetSorted,n));
	  	}
	  	out.println();
	  	System.out.println();
	  }
	  out.close();
	}
	
	public static void partiallyOrdered() throws IOException {
		String test = "tempiPartiallyOrderedFast.csv";
	  FileWriter outFile = new FileWriter(test, false);
	  out = new PrintWriter(outFile);
	  out.println("arraySize;MergeSortWithSingleAuxiliaryArray;MergeSortNoMergeOnSorted;MergeSortJavaAPIVersion;QuickSortMidToExamine;QuickSortHoare;QuickSortCrescenzi");
	  for(int n = STEP; n < N; n += STEP) {
	  	partiallyOrdered(partiallyOrdered, n);
	  	out.print(n+";");
	  	System.out.println(n+";");
	  	for(Algorithm algo : Algorithm.values()){
	  	out.print(time(algo,partiallyOrdered,n)+";");
	  	System.out.println(algo.name()+" tempo:"+time(algo,partiallyOrdered,n));
	  	}
	  	out.println();
	  	System.out.println();
	  	
	  	
	  }
	  out.close();
	}
	
	
	/*        utility      */
	/**
	 * 
	 * @param algo
	 * @param array
	 * @return
	 */
	public static long time(Algorithm algo,int[]array,int n){
		c.reset();
		int[] a = Arrays.copyOf(array,n);
		c.start();
		sort(algo,a);
		c.stop();
		return c.getElapsedTime() ;
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
	static boolean ordinato(int a[],int n) {
  	for(int i = 1; i < n-1; i++) if(a[i-1] > a[i]) return false;
	return true;
  }
	static void copyArray(int[] orig,int[] dest){
		for(int i = 0;i<dest.length;i++) dest[i] = orig[i];
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
	public static void fillRandomNatArray(int[] a, int n, int max) {
    if(n > a.length) throw new IllegalArgumentException();
    int sup = max+1;
    for(int i = 0; i < n; i++) {
      a[i] = generatore.nextInt(sup);
    }
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
