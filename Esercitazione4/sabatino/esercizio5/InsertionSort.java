package sabatino.esercizio5;

public class InsertionSort implements SortingAlgorithm{	
	/**
	 * algoritmo di ordinamento per inserimento
	 * (Pre-Condizione) l'array che viene inserito in input viene considerato da ordinare (anche se è già ordinato)
	 * (Post-condizione) l'array è ordinato per l'algoritmo insertion sort.
	 *  i indice del primo elemento della parte non ordinata, inizialmente viene inizializzato ad 1,
	 *  perchè l'array formato da un solo elemnto è banalmente ordinato, quindi la parte da ordinare parte da 1
	 *  x è l'elemento da inserire, minore di tutti gli altri elemnti già spostati
	 * @param a array di interi dato in input, da ordinare.
	 */
	public void sort(int[] a) {
		int n=a.length;
		for(int i=1;i<n;i++){
			int x = a[i];
			insertV1(x,i,a);
		}
	}
/**
 * versione uno dell'inserion sort
 * metodo che effettua i confronti e l'inserimento nel posto corretto dell'elemento x
 * Passo Generico
 * - a[0...i-1] parte ordinata
 * - a[i...n-1] parte da ordinare
 * devo quindi percorrere all'indietro l'array a partire dall'indice i, trovare la posizione in cui va inserito x,
 * nel frattempo facendo slittare in avanti di una posizione gli elementi della parte ordinata.
 * Inizializzazione
 * inizialmente la parte da ordinare è a[0...0], quindi la parte da ordinare non è tutto l'array ma a[1...n-1].
 * j indice del posto in cui l'elemento posto in a[i] va inserito
 * @param x elemento da inserire nella posizione corretta all'interno dell'array a
 * @param i indice del primo elemento della parte non ordinata.
 * @param a array in cui inserire l'elemento x. 
 */
	private void insertV1(int x,int i, int[]a){
		int j = i;
		for(j = i;j>0;j--){
			if(x>=a[j-1]) break;//x va inserito in a[i]
			a[j] = a[j-1];
		}
		a[j] = x;
	}

	/**
	 * versione due dell'insertion sort
	 * una versione differente dell'insertion sort
	 * Passo Generico
	 * a[0...j-1] parte da ordinare
	 * a[j+1...i-1] parte già spostata
	 * quindi devo percorrere l'array all'indietro però all'interno della porzione a[0...j-1] finchè non trovo un elemento che è maggiore di x,
	 * oppure ho finito gli elementi e va messo in prima posizione. infatti quando una delle due condizioni del while non è più valida si esce dal ciclo.
	 *j indice del posto libero in cu i inserire l'elemento x
	 * @param x elemento che deve essere inserito nel posto giusto
	 * @param i è l'indice dell'elemento che va spostato
	 * @param a array dato in input
	 */
	private void insertV2(int x,int i,int[]a){
		int j = i;
		while(j>0 && x<a[j-1]){
			a[j] = a[j-1];
			j--;
		}
		a[j]=x;
	}
	
}
