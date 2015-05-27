package sabatino.esercizio5;

public class SelectionSort implements SortingAlgorithm{
	
	/**
	 * il metodo realizza l'algoritmo di ordinamento per selezione (selection sort).
	 * Si cerca l'elemento con il valore minimo all'interno dell'array, lo si mette al primo posto per mezzo di uno scambio e si procede così per tutti gli elementi dell'array.
	 * Passo generico
	 * - a[0...i-1] parte già ordinata
	 * - a[i...n-1] parte da ordinare 
	 * Condizione di uscita dal ciclo while
	 * si itera l'array fino al penultimo elemento perchè sarà di sicuro al posto giusto essendo ci solo più lui.
	 * @param a array di interi che si vuole ordinare
	 */
	public void sort(int[] a) {
		int n = a.length;
		for(int i = 0;i<n-1;i++){
			int iMin = i;
			for(int j=i+1;j<n;j++)
				if(a[j] < a[iMin])iMin=j;
				scambia(a,i,iMin);
		}
	}
	/**
	 * metodo che scambia di posto due elementi in un array attraverso i loro indici.
	 * @param a array nel quale si effettua lo scambio.
	 * @param i indice del primo elemento da scambiare.
	 * @param j indice del secondo elemento da scambiare.
	 */
	private void scambia(int[]a,int i,int j){
		int x=a[i];
		a[i]=a[j];
		a[j]=x;
	}

}
