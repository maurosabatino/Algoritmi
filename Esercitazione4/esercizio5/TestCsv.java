package esercizio5;

import java.io.*;
import java.util.*;
import static java.lang.System.*;

public class TestCsv {
	private static PrintWriter out;
	private static Random generatore = new Random();
  static final int N = 1001, STEP = 50;
  static int[] array = new int[N];
	
  static SortingAlgorithm isort = new InsertionSort(); 
  static SortingAlgorithm ssort = new SelectionSort(); 
  static SortingAlgorithm msort = new MergeSort(); 
  static SortingAlgorithm qsort = new QuickSort(); 
	
	
	public static void main(String[] args) throws IOException{
		String test = "tempi.csv";
	  FileWriter outFile = new FileWriter(test, false);
	  out = new PrintWriter(outFile);
	  out.println("arraySize;tInsSort;tSelSort;tMergeSort;tQuickSort");
	  for(int n = STEP; n < N; n += STEP) {
	  	out.println(""+n+";"+time(isort,n)+";"+time(ssort,n)+";"+time(msort,n)+"");
	  }
	  out.close();
	}
	public static double time(SortingAlgorithm sorter,int n){
		long  t0,t1;
		double diff;
		fillRandomNatArray(array, n, 9*n/10);
		t0 = nanoTime();
		sorter.sort(array);
		t1 = nanoTime();
		diff = (t1-t0)/1000000.0;
		return diff;
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
}
