package sabatino.esercizio2;

import java.util.Random;

public class TestThreeColoredFlag {
	private static Random generatore = new Random();
	static final int n = 10;
	static int[] array = new int[n];
	
	public static void main(String[] args){
		System.out.println("array con solo verdi");
		fillRandomMultiple3(array,9*n/10);
		for(int i = 0;i<array.length;i++) System.out.print(array[i]+",");
		System.out.println();
		ThreeColoredFlag.separateColors(array);
		System.out.println();
		for(int i = 0;i<array.length;i++) System.out.print(array[i]+",");
		System.out.println("la bandiera è ordinata correttamente? "+ThreeColoredFlag.checkColors(array));
		System.out.print("array riempito casualmente");
		fillRandomNatArray(array,9*n/10);
		ThreeColoredFlag.separateColors(array);
		System.out.println("la bandiera è ordinata correttamente? "+ThreeColoredFlag.checkColors(array));
		
	}
	
	public static void fillRandomNatArray(int[]array,int max) {
		int sup = max+1;
    for(int i = 0; i < array.length; i++) {
      array[i] = generatore.nextInt(sup);
    }
  }
	public static void fillRandomMultiple3(int[]array,int max) {
		int sup = max+1;
    for(int i = 0; i < array.length; i++) {
      array[i] = generatore.nextInt(sup)*3; 
    }
  }
}
