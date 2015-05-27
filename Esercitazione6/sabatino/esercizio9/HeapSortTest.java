package sabatino.esercizio9;



public class HeapSortTest {
	public static void main(String[]args){
		//int[] array = RandomArrays.randomIntArray(6);
		int[] array = {2,6,4,7,3,5};
		Cronometro.start();
		HeapSort.hSort(array);
		Cronometro.stop();
		System.out.println("lunghezza: "+array.length+" tempo: "+Cronometro.getElapsedTime()+" ordinato: "+ordinato(array,array.length));
	}
	
	static boolean ordinato(int a[],int n) {
  	for(int i = 1; i < n-1; i++) if(a[i-1] > a[i]) return false;
	return true;
  }
}
