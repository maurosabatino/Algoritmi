package esercizio5;
import esercizio5.RandomArrays.*;

public class Test {
	static RandomArrays arrays = new RandomArrays();
  static SortingAlgorithm isort = new InsertionSort(); 
  static SortingAlgorithm ssort = new SelectionSort(); 
  static SortingAlgorithm msort = new MergeSort(); 
  static SortingAlgorithm qsort = new QuickSort(); 
	public static void main(String[] args){
		
		int [] array= arrays.randomNatArray(10, 100);
		System.out.println("originale");
		print(array);
		qsort.sort(array);
		System.out.println();
		System.out.println("ordinato");
		print(array);
	}
	public static void print(int[] a){
		for(int i=0; i<a.length;i++)
			System.out.print(a[i]+",");
		
	}
}
