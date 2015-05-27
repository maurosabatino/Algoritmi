package sabatino.esercizio1;

/**
 * classe che implementa la ricerca binaria all'interno di un array ordinato
 * @author Mauro
 */
public class BinarySearch {
  /**
	 * cerca un elemento in un array ordinato, con restituzione della posizione 
	 * (Pre-condizione: array a deve essere ordinato)
	 * la ricerca viene eseguita all'interno dell'array inizialmente da a[0...n-1], 
	 * si prende l'elemnto centrale e si confronta con x:
	 *  - se è minore si cerca nella porzione a[0...i-1]
	 *  - altrimenti se è maggiore nella porzione a[i+1...n-1]
	 *  si porcede a dimezzare la porzione in cui effettuare la ricerca man mano che si procede con i confronti(ci si aiuta con gli indici inf e sup per delimitare le porzioni di array in cu cercare)
	 *  la procedura termina in caso di ritrovamento dell'elemento x, oppure per avere esaurito la porzione in cui cercare l'elemento (inf e sup si sono incrociati).
	 *  situazione del momento iniziale;
	 *  |__________|__|________________|
	 *  inf=0   i = (inf+sup)/2				sup = n-1
	 *  
	 * @param x intero da cercare
	 * @param a array di interi, ordinato, in cui eseguire la ricerca
	 * @return posizione dell'elemento cercato, se non presente viene restituito l'inverso della posizione in cui potrebbe essere inserito
	 * */
	public static int find(int x,int[]a){
		int inf = 0;
		int sup = a.length-1;
		while(inf<=sup){
			int i = (inf+sup)/2;
			if(x<a[i])sup=i-1;
			else if(x>a[i])inf=i+1;
			else return i;
		}
		return -1;	
	}
		/**
		 * cerca un elemento in un array ordinato, con restituzione di un booleano(true: presente, false: non presente) 
	 * (Pre-condizione: array a deve essere ordinato)
	 * @param x intero da cercare
	 * @param a array di interi, ordinato, in cui eseguire la ricerca
	 * @return valore booleano che indica o meno la presenza dell'elemento all'interno dell'array
		 */
	public static boolean isPresent(int x, int[]a){
		int inf = 0;
		int sup = a.length-1;
		while(inf<=sup){
			int i = (inf+sup)/2;
			if(x<a[i])sup=i-1;
			else if(x>a[i])inf=i+1;
			else return true;
		}
		return false;
	}
		/**
		 * Ricerca binaria ricorsiva: procedura top-level
		 * (Pre-condizione: array a deve essere ordinato)
		 * (Post-condizione: se l'elemento trovato è all'interno dell'array viene trovato, altrimenti non è presente nell'array)
		 * @param x intero da cercare
		 * @param a array di interi, su cui eseguire la ricerca
		 * @return restituisce la posizione in cui si trova l'elemento all'interno dell'array se presente, se non presente restituisce un valore negativo. 
		 */
	public static int findRecursively(int x, int[]a){
		return findRecursively(x,a,0,a.length-1);
	}
	static int findRecursively(int x, int[]a, int inf, int sup){
		if(inf<=sup){
			int i = (inf+sup)/2;
			if(x<a[i])return findRecursively(x,a,inf,i-1);
			else if(x>a[i])return  findRecursively(x,a,i+1,sup);
			else return i;
		}
		return -1;
	}
}
