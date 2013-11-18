package Esercizio7;

import static java.lang.System.nanoTime;



public class Test {
	static int[] array;
	static int n=2000000;
	 private static enum Algorithm{
		 MERGESORT,
		 MERGESORTECO,
		 MERGESORTALTERNATO,
		 //QUICKSORTBASE,
		 QUICKSORTBASEVAR,
		 QUICKSORTCRESCENZI,
	 }
	 
	public static void main(String[]args){
		array=new int[n];
		RandomArrays.fillRandomNatArray(array, n, 9*n/10);
		for(Algorithm algo : Algorithm.values()){
		 double t = time(algo,array);
		System.out.println(algo.name()+" ordinato? "+ordinato(array,n)+"in tempo: "+t);
		}
	}
	
	
	public static void printArray(int[]array){
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+";");
		}
		System.out.println();
	}
	static boolean ordinato(int a[],int n) {
  	for(int i = 1; i < n-1; i++) if(a[i-1] > a[i]) return false;
	return true;
	}
	public static double time(Algorithm algo,int[]array){
		long  t0,t1;
		double diff;
		int[] a = array; 
		t0 = nanoTime();
		sort(algo,a);
		t1 = nanoTime();
		diff = (t1-t0)/1000000.0;
		return diff;
	}
	public static void sort(Algorithm algo,int[]array){
		switch(algo) {
		case MERGESORT:FastSorting.MergeSortWithSingleAuxiliaryArray(array); break;
		case MERGESORTECO:FastSorting.MergeSortNoMergeOnSorted(array); break;
		case MERGESORTALTERNATO:FastSorting.MergeSortJavaAPIVersion(array);break;
		//case QUICKSORTBASE:FastSorting.qSort(array);break;
		case QUICKSORTBASEVAR:FastSorting.qSortVar(array);break;
		case QUICKSORTCRESCENZI:FastSorting.qSortCrescenzi(array);break;
		}
	}
}
