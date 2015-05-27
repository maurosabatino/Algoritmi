package sabatino.esercizio9;

/**
 * Implementazione dell'algoritmo di ordinamento per mezzo di un heap a massimo.
 * l'algoritmo risolve il problema dell'ordinamento nello stesso modo dell'algoritmo per selezione,
 * infatti l'array in input viene trasformato in un heap, che ha la particolarità di avere sempre l'lemento maggiore (o minore, dipende dall'implementazione)
 * in testa alla coda, e quindi attraverso una serie di estrazione del massimo si avrà un array ordinato al contrario, 
 * però se riempio l'array a partire dal fondo sarà ordinato in maniera usuale crescente.
 * questo è un esempio di come un algoritmo pessimo come il selection sort, possa essere migliorato utilzzando una struttura dati esterna.
 * @author Mauro
 *
 */
public class HeapSort {
	/**
	 * metodo top-level che esegue l'algoritmo heapsort
	 * (pre-condizione) come in tutti gli algoritmi di ordinamento viene fornito un array che viene considerato come non ordinato e può essere disposto in tutte le permutazioni possibili,
	 * 									infatti se l'algoritmo è corretto, la postcondizione sarà sempre rispettata
	 * (post-condizione) l'array a, dopo l'esecuzione dell'algoritmo, sarà ordinato, cioè ogni elemento sarà <= del suo successore. 
	 * @param a array di interi fornito in input
	 */
	public static void hSort(int[]a){
		printArray(a);
		trasformaInHeap(a);
		printArray(a);
		for(int i = a.length-1;i>0;i--)
		estraiMassimo(a,i);
		printArray(a);
	}
	/**
	 * metodo che effettua estrae l'elemnto massimo che si trova in a[0] e deve essere spostato in a[i], 
	 * dove si trova l'ultima foglia, la quale viene spostata in a[0] e fatta scendere al posto giusto tramite la moveDown.
	 *  
	 * @param a array di interi che si vuole ordinare
	 * @param i è l'indice del'ultima foglia, ma è anche l'indice dell'ultimo elemnto nella parte non ancora ordinata.
	 */
	private static void estraiMassimo(int[]a, int i){
		swap(a,i,0);
		moveDown(a,0,i);
	}
	/**
	 * il metodo trasformaInHeap è il metodo fondamentale dell'algoritmo, 
	 * dato un array, attraverso una "cascata" di moveDown va a trasformare l'array di input in un heap. 
	 * @param a array di interi che si vuole traformare in uno heap.
	 */
	private static void trasformaInHeap(int[]a){
		int n = a.length;
		for(int j = (n-2)/2;j>=0;j--){
			System.out.println("j = "+j);
			moveDown(a,j,n);
		
		}
	}
	
	/**
	 * Procedura di move down in un heap a massimo
	 * rispetto ad un heap a massimo i confronti vengono eseguiti nel verso opposto
	 * @param a array su cui operare la procedura
	 * @param i indice dell'elemnto da far scendere
	 * @param lun lunghezza della parte di array occupata dallo heap a[lun...n-1]
	 */
	private static void moveDown(int[] a,int i, int lun){
		int elem = a[i];
		int j;
		while((j=2*i+1)<lun){
			if(j+1<lun && a[j+1]>a[j])j++;
			if(elem>=a[j])break;
			a[i] = a[j];
			i=j;
		}
		a[i] = elem;
		printArray(a);
	}
	
	/**
	 * metodo che scambia la posizione di due elemnti in un array
	 * @param a array sul quale si vuole operare lo scambio
	 * @param i indice del primo elemnto da scambiare
	 * @param j indice del secondo elemnto da scambiare
	 */
	private static void swap(int[]a,int i,int j){
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
	public static void printArray(int []a){
		System.out.println("---------------------");
		for(int i = 0;i<a.length;i++){
			System.out.print("["+a[i]+"],");
		}
		System.out.println();
		System.out.println("---------------------");
	}
}
