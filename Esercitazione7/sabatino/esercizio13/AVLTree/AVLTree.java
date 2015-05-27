package sabatino.esercizio13.AVLTree;

/**
 * Classe che implementa il dizionario di elementi con chiavi intere sotto forma di AVL
 * i metodi responsabili del bilanciamento dell'albero sono quelli che implementano le rotazione:
 *  - SS rotazione sinistra semplice
 *  - SD rotazione sinistra doppia
 *  - DD rotazione destra semplice
 *  - DS rotazione destra doppia
 *  grazie a queste rotazioni l'albero si riesce e mantenere sempre al più 1-bilanciato(in ogni nodo l’altezza del figlio sinistro e quello destro differiscono al più di 1).
 *  le operazioni classiche dell'interfaccia dizionario in questo tipo di implementazione sono molto convenienti in quanto permettono di avere le tre operazioni caratteristiche:
 *  - inserimento
 *  - ricerca
 *  - rimozione
 *  tutte complessità O(log n) a livello asintotico.
 *  
 * @author Mauro Sabatino Matricola: 736724
 *
 */

public class AVLTree implements Dictionary{
	Node root;
	int numElem;
	
	/**
	 * cerca all'interno dell'AVL un elemento con la chiave key e ne restituisce l'elemento,
	 * in caso non fosse presente restituisce NULL
	 * @param key chiave dell'elemento che si vuole prendere all'interno dell'AVL
	 * @return elemento di chive key
	 */
	@Override
	public ObjectWhitKey get(int key) {
		return get(key,root);
	}
	
	/**
	 *testa se l'AVL è vuoto
	 * @return booleano, true se l'AVL è vuoto altrimenti false.
	 */
	@Override
	public boolean isEmpty() {
		if(root==null) return true;
		return false;
	}
	
	/**
	 * inserisce l'elemento element all'interno dell'AVL, se un elemento con la stessa chiave è già presente,
	 *  lo sovrascrive e resituisce l'elemento precedente altrimenti null.
	 * @param element elemnto che si vuole inserire all'interno dell'AVL.
	 * @return null se l'elemento è stato inserito e non ha sovrascritto un elemento con la stessa chiave, altrimenti restituisce l'elemento che ha sovrascritto
	 */
	@Override
	public ObjectWhitKey put(ObjectWhitKey element) {
		root = put(element,root);
		return root.value;
	}
	
	/**
	 * rimuove un elemento con la chiave key all'interno dell'AVL. Se l'elemento con quella chiave non è presente restitusce null.
	 * @param key chiave dell'elemento che si vuole rimuovere
	 * @return se l'elemento viene trovato e rimosso ritorna l'elemento, altrimenti ritorna null
	 */
	@Override
	public ObjectWhitKey remove(int key) {
		root = remove(key, root);
		if(root!=null)
		return root.value;
		else return null;
	}
	/**
	 * restituisce il numero di elementi contenuti nell'AVL
	 * @return numero di elementi presenti nella struttura dati
	 */
	@Override
	public int size() {
		return numElem;
	}
	/**
	 * cerca  e restituisce l'elemento con la chiave massima
	 * @return elemento che ha la chiave con il massimo valore all'interno del dizionario
	 */
	@Override
	public ObjectWhitKey max() {
		return max(root);
	}
	
	/**
	 * cerca  e restituisce l'elemento con la chiave minima
	 * @return elemento che ha la chiave con il minimo valore all'interno del dizionario
	 */
	@Override
	public ObjectWhitKey min() {
		return min(root);
	}
	
	/**
	 * la ricerca viene eseguita nel seguente modo:
	 * - se la chiave key è < della chiave del nodo node si chiama ricorsivamente la procedura nel figlio sinistro
	 * - se la chiave key è > della chiave del nodo node si chiama ricorsivamente la procedura nel figlio destro
	 * - altrimenti la chiave sarà = a quella del nodo node, il nodo è stato trovate e viene resituito
	 * se non ci si trova in nessuno dei tre casi viene restituito null. 
	 * @param key chiave dell'elemento che si vuole ottenere
	 * @param node nodo con il quale si va ad effettuare il confronto
	 * @return  se è presente un nodo con la chiave key viene restituito l'elemento altrimenti null 
	 */
	private ObjectWhitKey get(int key,Node node){
		if(node ==null) return null;
		if(key<node.value.key()) return get(key,node.left);
		else if(key>node.value.key()) return get(key,node.right);
		else return node.value;
	}
	
	/**
	 * inserisce nella posizione corretta il nodo node, la procedura esamina l'albero:
	 * - se la chiave di element è < di quella del nodo node si prova ad inserire nel figlio sinistro
	 * - se la chiave di element è > di quella del nodo node si prova ad inserire nel figlio destro
	 * - se la chiave di element è = a quella del nodo node si sovrascrive il nodo node
	 * - se il nodo è una foglia, si inserisce il nodo in una foglia
	 * alla fine di tale procedura l'albero verrà bilanciato seguendo le opportune rotazioni
	 * @param element elemento che si vuole inserire all'interno dell'AVL
	 * @param node nodo attuale nel quale vengono effettuati i confronti
	 * @return restituisce il nodo che viene inserito dopo esser stao opportunamente bilanciato.
	 */
	private Node put(ObjectWhitKey element,Node node) {
		if(node==null)
			node = new Node(element);
			numElem++;
		if(element.key()<node.value.key())
			node.left=put(element,node.left);
		if(element.key() > node.value.key()) 
			node.right=put(element,node.right);
		if(element.key()==node.value.key())
			node = new Node(element);
		return balance(node);
	}
	
	/**
	 * Rimuove un elemento di chiave key dall'AVL.
	 * il metodo percorre l'albero come nel caso dell'inserimento seguendo le direttive di un albero di ricerca, però nel caso in cui trova l'elemento da eliminare si presentano 3 casi:
	 * - i due sttoalberi sono entrambi pieni: si va e cercare il minimo nel sottoalbero destro e si mette il suo valore nella posizione dell'elelemnto da cancellare e poi si elimina definitivamente il minimo nel sottoalbero destro
	 * - il sottoalbero sinistro è pieno e il destro è vuoto: come nell'eleiminazione classica di un elemnto da un albero binario, si fa puntare il nodo all'elemento successivo
	 * - caso opposto, destro pieno e sinistro vuoto: si procede in maniera opposta al caso precedente.
	 * alla fine di tale procedura se l'albero viene sbilanciato viene opportunamente bilanciato.
	 * @param key chiave dell'elemento da cancellare
	 * @param node nodo sul quale viene eseguita la procedura di rimozione
	 * @return nodo che è stato cancellato, se non viene trovato ritorna null, altrimenti restituisce l'elemento.
	 */
	private Node remove(int key,Node node){
		if(node==null)
			return null;
		if(key<node.value.key())
			node.left=remove(key,node.left);
		if(key> node.value.key()) 
			node.right=remove(key,node.right);
		if(key==node.value.key()){
			if(node.left != null && node.right != null){//qui testiamo se ci troviamo nel sottocaso 2 in cui si va a rimuovere un nodo da un livello completo
				node.value = min(node.right);
				node.right = deleteMin(node.right);
			}else{
				if (node.left != null && node.right == null)//altrimenti come nella classica eliminazione di un albero faccio puntare il genitore invece che a node al suo successivo
					node = node.left;
				else if(node.left == null && node.right != null)
					node = node.right;
				else if(node.left == null && node.right == null)
					node = null;
			}
		}
		return balance(node);
	}
	/**
	 * trova e cancella l'elemento con chiave minima all'interno dell'albero.
	 * @param node nodo dal quale si vuole andare a cancellare il minimo tra i suoi figli
	 * @return viene restituito il nodo di chiave minima che viene cancellato
	 */
	private Node deleteMin(Node node) {
		if(node.left == null) return node.right;
		node.left = deleteMin(node.left);
		return balance(node); 
	}

	/**
	 * Restituisce l'elemento con chiave massima all'interno dell'AVL, cioè percorre il ramo destro dell'albero fino all'ultima foglia più a destra.
	 * @param node nodo sul quale viene eseguita la procedura di ricerca del massimo
	 * @return elemento di chiave massima
	 */
	private ObjectWhitKey max(Node node) {
		if(node==null) return null;
		else if(node.right!=null) return max(node.right);
		return node.value;
	}

	/**
	 * ricerca il minimo all'interno dell'AVL, percorre l'albero nel ramo sinistro restituendo la foglia più a sinistra. 
	 * @param node nodo sul quale viene eseguita la procedura
	 * @return restituisce l'elemento di chiave minima, se invece l'albero è vuoto restituisce null.
	 */
	private ObjectWhitKey min(Node node) {	
		if(node==null) return null;
		while(node.left!=null)
			node = node.left;
		return node.value;
	}
	
	/**
	 * 	 * ribilancia un sottoalbero che è sbilanciato.
	 *  - un albero pende a sinistra (oppure sbilanciato a sinistra), quando l'altezza del sottoalbero sinistro - altezza del sottoalbero destro è > 1.
	 *  - un albero pende a destra (oppure sbilanciato a destra), quando l'altezza del sottoalbero destro - altezza del sottoalbero sinistro è > 1.
	 * il metodo prende come parametro un nodo che è la radice di un sottoalbero e va a controllare i seguenti casi:
	 *  - se l'albero pende a sinistra controlliamo quale dei figli causa lo sbilanciamento: se il sottoalbero sinistro pende a sinistra si esegue la rotazione SS, altrimentise pende a destra la rotazione SD.
	 *  - se l'albero pende a destra controlliamo quale dei figli causa lo sbilanciamento:se il sottoalbero destro pende a sinistra si esegue la rotazione DS, altrimentise pende a destra la rotazione DD.
	 *  infine si va ad aggiornare l'altezza del nodo che è stato ribilanciato e si ritorna la radice del sottoalbero che è ora bilanciato.
	 * @param node radice del sottoalbero che si vuole bilanciare
	 * @return restituisce la radice del nuovo sottoalbero bilanciato.
	 */
	private Node balance(Node node){
		if(node ==null)	return node;
		if(height(node.left)-height(node.right)>1)
			if(height(node.left.left) >= height(node.left.right))
				node = SS(node);
			else
				node = SD(node);
		else
			if(height(node.right) - height(node.left) > 1)
				if(height(node.right.right) >= height(node.right.left))
					node = DD(node);
				else
					node = DS(node);	
		node.height = Math.max(height(node.left),height(node.right)) + 1;
		return node;
	}
	
	/**
	 * esegue una rotazione sinistra, che ribilancia l'albero AVL a seguito di una pendenza sbilanciante a sinistra.
	 * Esempio di un caso (1) di sbilanciamento sinistro con successiva rotazione bilanciante:
	 * 			b								 a
	 * 		 / \						  /  \
	 * 	  a		D  =>  			 SS   b
	 * 	 / \	            / \   /\	
	 * SS	 SD						 *	 * SD D
	 * / \
	 * *  *
	 * (gli asterischi, nel primo albero rappresentano i nodi che causano lo sbilanciamento)
	 * dopo aver eseguito le opportune rotazioni, le altezze vengo aggiornate correttamente.
	 * @param b radice del sottoalbero che è sbilanciato
	 * @return nodo rappresentante la radice del nuovo albero bilanciato
	 */
	private Node SS(Node b){
		Node a = b.left;
		b.left=a.right;//SD rimane al livello dove era prima
		a.right=b;//b scende di un livello e a è salito di un livello
		b.height=max(height(b.left),height(b.right))+1;
		a.height=max(height(a.left),height(a.right))+1;
		return a;
	}
	
	/**
	 * ribilancia l'albero eseguendo una rotazione doppia, prima sul sottoalbero sinistro.
	 * 				 c										  SD
	 * 			 /  \										 / \
	 * 			a	   D									a   c
	 * 		 / \  / \     =>     		 /\  / \
	 * 		SS SD *  *						 SS T1 T2 D
	 * 	 /\  / \    						/ \ / \	 / \
	 * 	*	* T1 T2							 *  * *  * *  *
	 * 		  / \
	 * 		 *   *
	 * (i due nodi, raffigurati con *, figli di T1 sono responsabili dello sbilanciamento)
	 * anche in questo caso dopo aver bilanciato l'albero le altezze sono state correttamente aggiornate.
	 * @param c radice del sottoalbero che necessita di una rotazione SD per essere bilanciato a seguito di una pendenza sinistra in un sottoalbero destro
	 * @return radice del sottoalbero bialnciato con una rotazione SD.
	 */
	private Node SD(Node c){
		c.left = DD(c.left);//eseguo prima una rotazione sul nodo a come radice
		return SS(c);//eseguo una rotazione destra su c		
	}
	
	/**
	 * Rotazione che bilancia un sottoalbero a causa di una pendenza destra, il metodo si comporta come SS, solo che viene eseguito sulla parte destra dell'albero.
	  * 		b									D 
	 * 		 / \						   / \
	 * 	  a		D  =>  			  b   DD
	 * 	     / \	         / \  / \
	 *      DS	DD				a  DS	*	 *
	 *          / \
	 *         *  *
	 * @param s radice del sottoalbero che pende a destra e deve essere ribilanciato con la rotazione DD
	 * @return radice del sottoalbero che è stato rotaato e bilanciato.
	 */
	private Node DD(Node s){
		Node d = s.right;
		s.right=d.left;
		d.left=s;
		s.height=max(height(s.left),height(s.right))+1;
		d.height=max(height(d.left),height(d.right))+1;
		return d;
	}
		
	/**
	 * ribilancia l'albero (sottoalbero) eseguendo la rotazione doppia DS.
	 * 					c													c												DS
	 * 				 / \											 / \										 / \
	 * 				a   D											a   DS									c   D
	 * 					 / \         SS   					/ \			DD  			 / \ / \
	 * 					DS  DD       ==> 					 *   D		==>				a  * *  DD
	 * 				 / \														/ \
	 * 				*   *													 *   DD
	 * viene eseguita prima una rotazione SS ("sinistra") sul figlio destro e in seguito una rotazione DD sulla radice. 
	 * @param s nodo radice dell'albero (sottoalbero) che necessita della rotazione doppia DS.
	 * @return radice dell'albero a seguito di una rotazione DS.
	 */
	private Node DS(Node s){
		s.right = SS(s.right);
		return DD(s);
	}
	
	/**
	 * controlla se un albero AVL è correttamente bilanciato ovvero:
	 * la differenza tra l'altezza del sottoalbero sinistro e qualla del destro in modulo è <=1 e >=0.
	 * (questa seconda condizione è ovvio perchè viene rappresentato in modulo)
	 */
	public void checkBalance(){
		checkBalance( root );
	}
   
	/**
	 * (metodo ausiliario)
	 * controlla se il sottoalbero con radice node è bilanciato (1-bilanciato).
	 * se l'altezza del sottoalbero sinistro - altezza sottoalbero destro in modulo è <=1, in caso contrario ne effettua la stampa del nodo che è sbilanciato
	 * @param node radice dell'albero che se ne controlla il bilanciamento.
	 * @return intero rappresentante il valore dell'altezza del nodo node.
	 */
	private int checkBalance(Node node){
		if(node == null)
			return -1;
		if(node != null){
			int hl = checkBalance(node.left);
			int hr = checkBalance(node.right);
			if(Math.abs(height(node.left) - height(node.right )) > 1 || height(node.left) != hl || height(node.right) != hr)
				System.out.println( "l'AVL non è bilanciato, nodo: "+node.value+" con chiave: "+node.value.key());
			else System.out.println("l'AVL è bilanciato");
		}  
		return height( node );
	}
	
	/**
	 * controlla il bilanciamento di un albero restituendo un valore booleano.
	 * (se il dizionario è stato implementato correttamente il metodo dovrebbe sempre restituire true).
	 * @return se true l'albero è correttamente bilanciato secondo le regole di un AVL, altrimenti l'albero è sbilanciato.
	 */
	public boolean checkBalanceBoolean(){
		return checkBalanceBoolean(root);
	}
	/**
	 * (metodo ausiliario)
	 * controlla se un sottoalbero con radice node, fornito come parametro, è correttamente bilanciato retituendone il valore booleano.
	 * @param node radice del sottoalbero che si vuole controllare il bilanciamento.
	 * @return valore booleano se true bilanciato, altrimenti sbilanciato.
	 */
	private boolean checkBalanceBoolean(Node node){
		if(node == null)
			return false;
		if(Math.abs(height(node.left) - height(node.right )) > 1)
			return false;
		else return true;
	}
	
	/**
	 * restituisce il valore dell'altezza, contenuta all'interno del nodo.
	 * per scelta implementativa, si è deciso di conservare all'interno del nodo una variabile che memorizza il valore dell'altezza e con questo metodo ne restituisce il valore.
	 * inoltre se un nodo è nullo, non possiede un campo altezza quindi la procedura ne resituisce il valore -1.
	 * @param node nodo del quale si vuole conoscere il valore della sua altezza nell'albero.
	 * @return valore intero rappresentante l'altezza del nodo all'interno dell'albero, se il nodo è nullo il valore della sua altezza è -1.
	 */
	private int height(Node node){
		if(node==null) return -1;
		else return node.height;
	}

	/**
	 * calcola il massimo tra due elementi interi forniti come parametri.
	 * (nel caso in questa classe i due valori saranno le altezze dei figli destro e sinistro, in caso in cui si voglia conoscere quale tra i due ha l'altezza maggiore)
	 * @param lhs primo elemento da confrontare 
	 * @param rhs secondo elemento da confrontare
	 * @return restituisce il valore che è maggiore tra i due
	 */
	private static int max (int lhs, int rhs) {
		return lhs > rhs ? lhs : rhs;
	}
	
	/**
	 * controlla se un elemento con chiave key è contenuto all'interno dell'albero.
	 * (questo metodo viene implementato e utilizzato a fini di test)
	 * @param key chiave dell'elemento che si vuole sapere se è contenuta all'interno dell'albero.
	 * @return true in caso di elemento contenuto nell'AVl, false altrimenti.
	 */
	public boolean contains(int key){
		if(get(key)!=null) return true;
		else return false;
	}

}
