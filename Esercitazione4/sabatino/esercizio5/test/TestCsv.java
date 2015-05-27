package sabatino.esercizio5.test;

import java.io.*;
import java.util.*;

import sabatino.esercizio5.InsertionSort;
import sabatino.esercizio5.MergeSort;
import sabatino.esercizio5.QuickSort;
import sabatino.esercizio5.SelectionSort;
import sabatino.esercizio5.SortingAlgorithm;


/**
 * classe che cronometra i tempi degli algoritmi di ordinamento implementati nell'esercizio 5 nei seguenti casi:
 * tipi di array testati
 * -random
 * -ordinato al contrario
 * -elementi ripetuti
 * -vuoto
 * -riempito con Integer.MAX_VALUE
 * -array già ordinato
 * -array parzialmente ordinato
 * 
 * @author Mauro
 *
 */
public class TestCsv {
	private static PrintWriter out;
	private static Random generatore = new Random();
  static final int N = 10001, STEP = 500;
  static int[] random = new int[N];
  static int[] inverse = new int[N];
  static int[] repeated = new int[N];
  static int[] empty = new int[N];
  static int[] maxInt = new int[N];
  static int[] yetSorted = new int[N];
  static int[] partiallyOrdered = new int[N];
  static SortingAlgorithm isort = new InsertionSort(); 
  static SortingAlgorithm ssort = new SelectionSort(); 
  static SortingAlgorithm msort = new MergeSort(); 
  static SortingAlgorithm qsort = new QuickSort(); 
	
	
	public static void main(String[] args) throws IOException{
	System.out.println("random");
	filledRandom();
	System.out.println("ordinato al contrario");
	reverseOrdered();
	System.out.println("elementi ripetuti");
	repeatedElements();
	System.out.println("array vuoto");
	empty();
	System.out.println("riempito con Integer.MAX_VALUE");
	maxInteger();
	System.out.println("array già ordinato");
	yetOrdered();
	System.out.println("array parzialmente ordinato");
	partiallyOrdered();
	}
	
	
	public static void filledRandom() throws IOException{
		String test = "filledRandom.csv";
	  FileWriter outFile = new FileWriter(test, false);
	  out = new PrintWriter(outFile);
	  out.println("arraySize;tInsSort;tSelSort;tMergeSort;tQuickSort");
	  System.out.println("arraySize | tInsSort | tSelSort | tMergeSort | tQuickSort");
	  for(int n = STEP; n < N; n += STEP) {
	  	fillRandomNatArray(random, n, 9*n/10);
	  	out.println(""+n+";"+time(isort,random,n)+";"+time(ssort,random,n)+";"+time(msort,random,n)+";"+time(qsort,random,n));
	  	System.out.println(""+n+"| "+time(isort,random,n)+"| "+time(ssort,random,n)+"| "+time(msort,random,n)+"");
	  }
	  out.close();
	}
	public static void reverseOrdered() throws IOException{
		String test = "reverseOrdered.csv";
	  FileWriter outFile = new FileWriter(test, false);
	  out = new PrintWriter(outFile);
	  out.println("arraySize;tInsSort;tSelSort;tMergeSort;tQuickSort");
	  //System.out.println("arraySize | tInsSort | tSelSort | tMergeSort | tQuickSort");
	  for(int n = STEP; n < N; n += STEP) {
	  	reverse(inverse,n);
	  	out.println(""+n+";"+time(isort,inverse,n)+";"+time(ssort,inverse,n)+";"+time(msort,inverse,n)+";"+time(qsort,inverse,n));
	  	//System.out.println(""+n+"| "+time(isort,inverse,n)+"| "+time(ssort,inverse,n)+"| "+time(msort,inverse,n)+"|"+time(qsort,inverse,n));
	  }
	  out.close();
	}
	public static void repeatedElements() throws IOException{
		String test = "repeatedElements.csv";
	  FileWriter outFile = new FileWriter(test, false);
	  out = new PrintWriter(outFile);
	  out.println("arraySize;tInsSort;tSelSort;tMergeSort;tQuickSort");
	  //System.out.println("arraySize | tInsSort | tSelSort | tMergeSort | tQuickSort");
	  for(int n = STEP; n < N; n += STEP) {
	  	repeatedElements(repeated, n, 100);
	  	out.println(""+n+";"+time(isort,repeated,n)+";"+time(ssort,repeated,n)+";"+time(msort,repeated,n)+";"+time(qsort,repeated,n));
	  	//System.out.println(""+n+"| "+time(isort,repeated,n)+"| "+time(ssort,repeated,n)+"| "+time(msort,repeated,n)+"");
	  }
	  out.close();
	}
	public static void empty() throws IOException{
		String test = "empty.csv";
	  FileWriter outFile = new FileWriter(test, false);
	  out = new PrintWriter(outFile);
	  out.println("arraySize;tInsSort;tSelSort;tMergeSort;tQuickSort");
	  //System.out.println("arraySize | tInsSort | tSelSort | tMergeSort | tQuickSort");
	  for(int n = STEP; n < N; n += STEP) {
	  	
	  	out.println(""+n+";"+time(isort,empty,n)+";"+time(ssort,empty,n)+";"+time(msort,empty,n)+";"+time(qsort,empty,n));
	  	//System.out.println(""+n+"| "+time(isort,empty,n)+"| "+time(ssort,empty,n)+"| "+time(msort,empty,n)+"");
	  }
	  out.close();
	}
	public static void maxInteger() throws IOException{
		String test = "maxInteger.csv";
	  FileWriter outFile = new FileWriter(test, false);
	  out = new PrintWriter(outFile);
	  out.println("arraySize;tInsSort;tSelSort;tMergeSort;tQuickSort");
	  //System.out.println("arraySize | tInsSort | tSelSort | tMergeSort | tQuickSort");
	  for(int n = STEP; n < N; n += STEP) {
	  	maxInt(maxInt,n);
	  	out.println(""+n+";"+time(isort,maxInt,n)+";"+time(ssort,maxInt,n)+";"+time(msort,maxInt,n)+";"+time(qsort,maxInt,n));
	  	//System.out.println(""+n+"| "+time(isort,maxInt,n)+"| "+time(ssort,maxInt,n)+"| "+time(msort,maxInt,n)+"");
	  }
	  out.close();
	}
	public static void yetOrdered() throws IOException{
		String test = "yetOrdered.csv";
	  FileWriter outFile = new FileWriter(test, false);
	  out = new PrintWriter(outFile);
	  out.println("arraySize;tInsSort;tSelSort;tMergeSort;tQuickSort");
	  //System.out.println("arraySize | tInsSort | tSelSort | tMergeSort | tQuickSort");
	  for(int n = STEP; n < N; n += STEP) {
	  	yetOrdered(yetSorted,n);
	  	out.println(""+n+";"+time(isort,yetSorted,n)+";"+time(ssort,yetSorted,n)+";"+time(msort,yetSorted,n)+";"+time(qsort,yetSorted,n));
	  	//System.out.println(""+n+"| "+time(isort,yetSorted,n)+"| "+time(ssort,yetSorted,n)+"| "+time(msort,yetSorted,n)+"");
	  }
	  out.close();
	}
	public static void partiallyOrdered() throws IOException{
		String test = "partiallyOrdered.csv";
	  FileWriter outFile = new FileWriter(test, false);
	  out = new PrintWriter(outFile);
	  out.println("arraySize;tInsSort;tSelSort;tMergeSort;tQuickSort");
	  System.out.println("arraySize | tInsSort | tSelSort | tMergeSort | tQuickSort");
	  for(int n = STEP; n < N; n += STEP) {
	  	partiallyOrdered(partiallyOrdered, n);
	  	out.println(""+n+";"+time(isort,partiallyOrdered,n)+";"+time(ssort,partiallyOrdered,n)+";"+time(msort,partiallyOrdered,n)+";"+time(qsort,partiallyOrdered,n));
	  	System.out.println(""+n+"| "+time(isort,partiallyOrdered,n)+"| "+time(ssort,partiallyOrdered,n)+"| "+time(msort,partiallyOrdered,n)+"");
	  }
	  out.close();
	}
	
	
	/*utility*/
	public static String time(SortingAlgorithm sorter,int[]array,int n){
		double startTime;
		double stopTime;
		double elapsedTime;
		int[] a = Arrays.copyOf(array,n);
		startTime = System.nanoTime();
		sorter.sort(a);
		stopTime = System.nanoTime();
		elapsedTime = (stopTime-startTime)/1000000.0;
		elapsedTime = Math.floor(elapsedTime*100.0)/100.0;
		
		return String.format("%,6.2f",elapsedTime);
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
