package sabatino.esercizio11;



public class IntrospectiveSortTest {
	public static void main(String[]args){
		Cronometro c = new Cronometro();
		int[] array = RandomArrays.randomIntArray(200000);
		c.start();
		IntrospectiveSort.introSort(array);
		c.stop();
		System.out.println("lunghezza: "+array.length+" tempo: "+c.getElapsedTime()+" ordinato: "+ordinato(array,array.length));
	}
	
	static boolean ordinato(int a[],int n) {
  	for(int i = 1; i < n-1; i++) if(a[i-1] > a[i]) return false;
	return true;
  }
}
