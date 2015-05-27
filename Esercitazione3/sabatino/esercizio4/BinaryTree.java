package sabatino.esercizio4;

import static java.lang.Math.max;

import java.util.Stack;

/**
 * classe che implementa un albero binario in stile ad oggetti.
 * la classe BinaryTree è composta da un nodo, la cui struttura ricorsiva, in quanto ogni nodo ha due sottonodi (sottoalberi) sinistro e destro.
 * @author Mauro
 *
 */
public class BinaryTree {
/**
 * classe nodo composta da un elemento che è il valore del nodo e due nodi figli sinistro e destro.
 * @author Mauro
 *
 */
  protected class Node {
    protected Integer element;
    protected Node left, right;
/**
 * costruttore della classe nodo che crea un nodo con eleento element e i due figli vuoti (null).
 * @param element elemento intero del nodo che si va a creare
 */
    Node(int element) {
      this.element = element;
      left = right = null;
    }
/**
 * costruttore che prende come parametri un elemento intero che è il valore del nodo e due figli destro e sisitro
 * @param element intero che rappresenta il valore del nodo
 * @param left figlio sinistro del nodo creato
 * @param right figlio destro del nodo creato
 */
    Node(int element, Node left, Node right) {
      this.element = element;
      this.left = left;
      this.right = right;
    }
    /**
     * controlla se il nodo è una foglia
     * @return true se è una foglia, altrimenti false.
     */
    boolean isLeaf() {
      return left == null && right == null;
    }
  }
  
  /** abbozzo di classe, messa solo
   *  per poter realizzare il metodo find,
   *  non usata -- come si potrebbe --
   *  negli altri esercizi
   *  
   * @author elio
   *
   */
  public class NodeReference {
    private Node node;
    
    private NodeReference(Node node) {
      this.node = node;
    }
    
    public int getElement() {
      return node.element;
    }
    
    public void setElement(int e) {
      node.element = e;
    }
  }

  protected Node root;
  /**
   * costruttore di BinaryTree che crea un albero vuoto.
   */
  public BinaryTree() {
    root = null;
  }

  public void display() {
    display(root, 0);
  }

  protected void display(Node node, int k) {
    if(node != null) {
      display(node.right, k+1);
      for(int i = 0; i < k; i++) System.out.print("   ");
      System.out.println(node.element);
      display(node.left, k+1);
    }
  }
  /**
   * controlla se l'albero è vuoto
   * @return true se la radice dell'albero è == null, quindi vuoto altrimenti false.
   */
  public boolean isEmpty() {
    return root == null;
  }

  /**
   * inserisce un elemento nell'albero,
   * nella posizione indicata da path;
   * se il path termina su un nodo gia' esistente,
   * sovrascrive il valore dell'elemento;
   * se il path termina su un nodo nullo,
   * oppure se si raggiunge un nodo nullo
   * prima che il path sia finito,
   * l'elemento viene inserito creando un nuovo nodo
   * in quella posizione (vedi slides)
   * @param element elemento da aggiungere all'albero
   * @param path posizione in cui va inserito l'elemento all'interno dell'cammino gerarchico dell'albero
   */
  public void add(int element, String path) {
    root = add(element, path, root);
  }

  protected Node add(int elem, String path, Node nd) {
  	 if(nd==null) return new Node(elem);
     else {
     	if(path.length()==0) nd.element=elem;
     	else{
     		char go = path.charAt(0);
     		String nextPath = path.substring(1);
     		if(go=='L') nd.left= add(elem,nextPath,nd.left);
     		else if(go=='R') nd.right=add(elem,nextPath,nd.right);
     		else throw new IllegalArgumentException("stringa non corretta");
     	}
       return nd;
     }
  }

  /** 
   * Scrive gli elementi in preordine sulla consolle
   */
  public void printPreOrder() {
    if(root == null) System.out.println("albero vuoto");
    printPreOrder(root);
    System.out.println();
  }
/**
 * Metodo ausiliario della stampa in preordine
 * se il nodo passato come argomento è nullo, la procedura termina attraverso una return
 * @param node nodo da stampare
 * */
  protected void printPreOrder(Node node) {
    if(node==null) return;
    System.out.println(node.element);
    printPreOrder(node.left);
  	printPreOrder(node.right);
  	
    		
  }
/**
 * scrive gli elementi in ordine sulla consolle
 * */
  public void printInOrder() {
  	 if(root == null) System.out.println("albero vuoto");
     printInOrder(root);
     System.out.println();
  }
  /**
   * Metodo ausiliario della stampa in ordine
   * se il nodo passato come argomento è nullo, la procedura termina attraverso una return
   * @param node nodo da stampare
   * */
  protected void printInOrder(Node node) {
  	if(node==null) return;
    printInOrder(node.left);
    System.out.println(node.element);
    printInOrder(node.right);
  }
  /**
   * scrive gli elementi in postordine sulla consolle
   * */
  public void printPostOrder() {
  	if(root == null) System.out.println("albero vuoto");
    printPostOrder(root);
    System.out.println();
  }

  /**
   * Metodo ausiliario della stampa in postordine
   * se il nodo passato come argomento è nullo, la procedura termina attraverso una return
   * @param node nodo da stampare
   * */
  protected void printPostOrder(Node node) {
  	if(node==null) return;
    printPostOrder(node.left);
    printPostOrder(node.right);
    System.out.println(node.element);
  }

  /** altezza dell'albero
   *  (altezza dell'albero vuoto = -1) 
   * @return intero rappresentante il valore dell'altezza dell'albero
   */
  public int height() {
    return height(root);
  }
/**
 * altezza dell'albero(metodo ausiliario)
 * se il nodo è vuoto, ritorna -1,
 * altrimenti calcola il massimo tra l'altezza del figlio sinistro e destro
 * @param node nodo su cui effettuare il calcolo dell'altezza
 * @return intero, rappresentante l'altezza fino al nodo passato come paramento.
 * */
  protected int height(Node node) {
  	return node==null?-1:1+max(height(node.left),height(node.right));
  }
  
  /** somma dei valori degli elementi
   * (somma di un albero vuoto = 0,
   *  oppure IllegalStateException)
   * @return intero rappresentante la somma dei valori dei nodi dell'albero
   */
  public int sum() {
    return sum(root);
  }
  /**
   * metodo ausiliario della somma degli elementi di un albero, se il nodo è nullo ne restituisce il proprio elemento sommato al valore ricevuot dalle chiamate ricorsive sui figli.
   * @param nd nodo sul quale viene eseguito il  metodo
   * @return intero rappresentante il valore della somma dei nodi dei sottoalberi di nd.
   */
  private int sum(Node nd) {
  	return nd==null ? 0: nd.element+sum(nd.left)+sum(nd.right);
  }
  /**
   * somma i valori dei nodi che fanno parte del sottoalbero che ha come radice un nodo dal valore x
   * @param x valore del nodo, del quale si vuole conoscere la somma dei suoi discendenti
   * @return valore intero rappresentnate la somma dei discendneti del nodo col valore x.
   */
  public int sommaDiscendenti(int x){
  	return sommaDiscendenti(x,root);
  }
  /**
   * metodo ausiliario per il metodo che somma i valori discendenti il nodo con il valore x
   * @param x intero, valore del nodo di cui si vuole conoscere la somma dei discendenti
   * @param nd nodo sul quale viene eseguito il metodo
   * @return valore della somma dei discendenti dell'albero che ha come radice nd.
   */
  private int sommaDiscendenti(int x,Node nd){
  	if(nd==null) return 0;
  	if(nd.element==x) return nd.element+sum(nd.left)+sum(nd.right);
  	else if(nd.left!=null) return sommaDiscendenti(x, nd.left);
  	else return sommaDiscendenti(x, nd.right);
  }

  /** numero dei nodi
   * (numero dei nodi di un albero vuoto = 0)
   * @return numero di nodi all'interno di un albero binario, se è vuoto viene restituito 0.
   */
  public int size() {
    return size(root);
  }
  /**
   * metodo ausiliario del conteggio di nodi in un albero binario
   * @param nd nodo sul quale viene eseguito il metodo nella ricorsione
   * @return intero rappresentante il numero di nodi nel sottoalbero con radice nd.
   */
  private int size(Node nd) {
  	return nd==null ? 0 :size(nd.left)+size(nd.right)+1;
  }

  /** 
   * calcola il numero delle foglie presenti in un albero binario
   * @return numero di foglie all'inteno di un albero binario, se l'albero è vuoto il numero delle foglie sarà 0.
   * */
  public int numberOfLeaves() {
    return numberOfLeaves(root);
  }

  /**
   * metodo ausiliario di numberOfLeaves().
   * @param nd nodo sul quale viene attualmente effettuato il conteggio delle foglie
   * @return se nd è una foglia ritorna 1, altrimenti va a controllare nel figlio sinistro e destro.
   */
  private int numberOfLeaves(Node nd) {
  	if(nd==null) return 0;
    else if (nd.isLeaf()) return 1;
    else return numberOfLeaves(nd.left)+numberOfLeaves(nd.right);
  }

/** da' come risultato true se l'elemento x si trova in this,
    false altrimenti  */
  public boolean search(int x) {
    return search(x,root);
  }

  /** realizzare con una sola istruzione */
  protected boolean search(int x, Node nd) {
  	return (nd==null) ? false : (nd.element==x) ? true :  (search(x,nd.left)|| search(x,nd.right));
  }

  /**
   * riflette l'albero senza crearne uno nuovo, per questo motivo viene chiamato in place.
   */
 
  public void mirrorInPlace() {
    mirrorInPlace(root);
  }
  
  /**
   * metodo ausiliario di mirroInPlace(), in cui scambia i suoi sottoalberi destro e sinistro.
   * @param node
   */
  protected void mirrorInPlace(Node node) {
  	if(node!=null){
  	Node temp=node.left;
		node.left=node.right;
		node.right=temp;
		mirrorInPlace(node.left);
		mirrorInPlace(node.right);
  	}
  }

  /**
   * incrementa di uno il valore di tutti i nodo di un albero binario
   */
  public void increment() {
    increment(root);
  }
  /**
   * metodo ausiliario di increment(), aumenta di uno il valore del nodo passato come parametro e poi chiama la ricorsione sui suoi figli.
   * @param node
   */
  private void increment(Node node) {
  	if(node!=null){
    	node.element++;
    	increment(node.left);
    	increment(node.right);
    }
  }

  /**
   * crea un nuovo albero con i nodi tagliati da una certa altezza in poi, non andando a modificare l'originale
   * @param h altezza dalla quale l'almero deve essere potato.
   * @return nuovo albero con i nodi dal livello h in poi potati.
   */
  public BinaryTree trimmed(int h) {
    BinaryTree trimmedTree = new BinaryTree();
    trimmedTree.root=trimmed(h,root);
    return trimmedTree;
  }

  /**
   * metodo ausiliario di trimmed, controlla se il nodo attuale è al livello h, se lo è inizia la procedura di potatura su una copia dell'albero.
   * @param h livello di altezza h che vuole essere tagliato.
   * @param nd nodo sul quale viene esguito il metodo
   * @return ritorna un nuovo nodo uguale a quello dell'albero che lo invoca nel caso in cui non si sia ancora raggiunto il livello h desiderato, altrimenti null.
   */
  protected Node trimmed(int h, Node nd){
  	return (nd==null || h==0) ? null: new Node(nd.element,trimmed(h-1,nd.left),trimmed(h-1,nd.right));
  }


/**
  elimina dall'albero i nodi di livello >= h:
  realizzazione con la tecnica "naturale":
  il caso di h<=0 sulla radice viene
  trattato come caso particolare nella
  procedura "wrapper"
*/
  public void trim(int h) {
    trim(h, root);
  }
  
 /**
  * elimina i i sottoalberi al di sotto del livello h, questa è una tecnica più naturale della ricorsione su albero, però in java non è possibile tagliare l'intero albero,
  * perchè non è possibile il passaggio di parametri per riferimento come in c#, perciò non è possibile tagliare l'intero albero ma solo dal livello >=1.
  * (precondizione h>=1)
  * @param h livello dal quale si deve iniziare a potare
  * @param nd nodo sul quale viene eseguito il metodoo. 
  */
  protected void trim1(int h, Node nd) {
  	if(nd!=null){
  		if(h==1){
  			nd.left=nd.right=null;
  		}else{
  			trim(h-1,nd.left);
  			trim(h-1,nd.right);
  		}
  	}
  }


/** in alternativa:
  realizzazione con la tecnica usata nel libro di testo
  poichè non è possibile il passaggio di parametri per riferimento, facendo in modo che venga resituito sempre il nodo stesso finchè il livello non è stato raggiunto, quindi si va a sotituire sempre il nodo con se stesso,
  quando si raggiunge il livello h i nodi invece vengono impostati a null.
  @param h livello dal quale si vuole potare l'albero
  @param nd nodo sul quale viene eseguito il metodo
  @return nodo stesso in caso al di sopra del livello h, altrimenti null.
*/

  private Node trim(int h, Node nd) {
  	 if(nd==null || h==0)return null;
     else{
     	nd.left=trim(h-1,nd.left);
     	nd.right=trim(h-1,nd.right);
     	return nd;
     }
  }

 /** 
  * costruisce e restituisce un nuovo albero speculare di t, senza andare a modificare l'albero originale.
  * @return speculare di t
  */
  public BinaryTree mirror() {
  	BinaryTree mirror = new BinaryTree();
    mirror.root=mirror(root);
    return mirror;
  }
  /**
   * metodo ausiliario che riflette l'albero senza andare a modificare l'albero che lo invoca.
   * @param nd nodo sul quale viene eseguita l aprocedura.
   * @return nodo uguale al suo speculare.
   */
  protected Node mirror(Node nd){
  	return (nd == null) ? null : new Node(nd.element, (nd.right != null ? mirror(nd.right) : null), (nd.left != null ? mirror(nd.left) : null));
  }
/**
 * metodo che confronta due alberi binari e ne comunica l'uguaglianza.
 * @param t altro albero con cui si vuole effettuare il confronto
 * @return valore booleano, true se i due alberi sono identici altrimenti false.
 */
  public boolean equalTo(BinaryTree t) {
    return areEqual(root,t.root); // si richiami areEqual
  } 

  /**
   * confronta se l'albero è uguale ad un altro albero formato da oggetti Object
   * @param ob Object ob albero di oggetti Object che si vuole confrontare
   * @return valore booleano, true se i due alberi sono identici altrimenti false.
   */
	public boolean equals(Object ob) {
  	if(ob == null) return false;
    if(getClass() != ob.getClass())
    	return areEqual(root,(Node)ob);
    return false;
  }
	
	/**
	 * metodo ausiliario che confrota se due nodi sono identici
	 * @param node1 primo nodo del confronto
	 * @param node2 secondo nodo el confronto
	 * @return valore booleano, true se i due nodi sono identici altrimenti false.
	 */
  protected boolean areEqual(Node node1, Node node2) {
  	return node1 == node2 || (node1!=null && node2!=null && node1.element==node2.element && areEqual(node1.left,node2.left) && areEqual(node1.right,node2.right));
  }

 /**
  * crea una copia dell'albero this
  * @return albero copia di this
  */
  public BinaryTree copy() {
  	BinaryTree copy = new BinaryTree();
    copy.root=mirror(root);
    return copy;
  }
  
  protected Node copy(Node nd) {
  	return (nd==null)? null : new Node(nd.element,copy(nd.left),copy(nd.right));
  }  

  private Node find(int x, Node nd) {
    if(nd == null || nd.element == x) return nd;
    Node ris = find(x, nd.left);
    if(ris == null) ris = find(x, nd.right);
    return ris;
  }
  
  public NodeReference find(int x) {
    return new NodeReference(find(x, root));
  }

  /** restituisce true se l'albero è completamente bilanciato
   *  false altrimenti (vedi definizione su libro di testo)
   * @return true se l'albero è bilanciato completamente altrimenti false
   */
  public boolean isCompletelyBalanced() {
  	int x = isCB(root);
  	if(x>=0) return true;
  	else return false;
  }

  private int isCB(Node nd) {
  	if(nd==null)return -1;
  	else{
  	int l = isCB(nd.left);
  	int r = isCB(nd.right);
  	if(l==r) return l+1;
  	else return -(max(l,r)+1);
  	}
  }

  /**  restituisce true se l'albero è 1-bilanciato
   *  false altrimenti (vedi definizione su libro di testo);
   *  metodo da realizzare a novembre/dicembre
   * @return true se l'albero è bilanciato completamente altrimenti false.
   */  
  public boolean is1Balanced() {
  	 int x = is1Balanced(root);
     if(x>=0)return true;
     else return false;
  }  

  private int is1Balanced(Node node) {
  	if(node==null) return -1;
  	else{
  	 	int l= is1Balanced(node.left);
  		int r= is1Balanced(node.right); 
  		if(l==r || (l-r)<=1) return max(l,r)+1;
  		else return -max(l,r)+1;
  	}
  }
  

  /**  numero dei nodi a livello liv */
  public int numNodesAtLevel(int liv) {
    return numNodesAtLevel(root, liv);
  }

  protected int numNodesAtLevel(Node nd, int lev) {
  	if(nd!=null){
  		if(lev!=0){
  		int sumL = numNodesAtLevel(nd.left,lev-1);
  		int sumR = numNodesAtLevel(nd.right,lev-1);
  		return sumL+sumR;
  		}
  		else return 1;
  	}
  	else return 0;
  }


  private class BoolNode {
    boolean found;
    Node node;

    BoolNode(boolean found, Node node) {
      this.found = found;
      this.node = node;
    }
  }

/**Esercizio opzionale:
   elimina il sottoalbero di radice x;
   se l'elemento x e' presente piu' volte,
   elimina uno solo dei sottoalberi di radice x
   (il primo che trova);
   se l'eliminazione e' stata effettuata,
   restituisce true;
   se invece l'elemento x non e' presente,
   restituisce false
 */
  public boolean removeSubtree(int x) {
    BoolNode ris = removeSubtree(x, root);
    root = ris.node;
    return ris.found;
  }

  protected BoolNode removeSubtree(int x, Node nd) {
  	if(nd!=null){
  	if(nd.element == x) {
  		nd.left=nd.right=null;
  		return new BoolNode(true, root);
  	}
  	BoolNode ris = removeSubtree(x, nd.left);
  	if(ris.found==false) ris = removeSubtree(x, nd.right);
  	return ris;
  	}
  	return new BoolNode(false, root);
  }

  /**
   * stampa i nodi cardine dell'albero this, i nodi cardine sono i nodi che hanno l'altezza pari alla profondità.
   */
  public void printCentralNodes() {
    System.out.print("nodi centrali o nodi-cardine: ");
    central(root,0);
    System.out.println();
  }

  private int central(Node nd, int p) {
  	if(nd==null) return -1;
  	else{
  		int hl = central(nd.left,p+1);
  		int hr = central(nd.right,p+1);
  		int h = max(hl,hr)+1;
  		if(p==h) {
  			System.out.println("cardine : "+nd.element);
  		}
  		return h;
  	}
  }
  
/**
 * restituisce il valore massimo all'interno dell'albero
 * @exception IllegalStateException albero vuoto.
 * @return intero del valore massimo presente nell'array
 */
  public int maxElem() {
    if(root == null) throw new IllegalStateException("albero vuoto");
    return maxElem(root);
  }
  
  private static int max3(int x, int y, int z) {
    return max(x, max(y, z));
  }
  
  private int maxElem(Node nd) {
    return nd==null? Integer.MIN_VALUE: max3(nd.element,maxElem(nd.left),maxElem(nd.right));
  }
  
  /* TODO Esercizio 3.13 pag. 99 libro di testo
   * Restituisce il riferimento al nodo (o a uno dei nodi,
   * se ne esistono più d'uno) v tale che:
   * il rapporto fra il numero dei nodi del sottoalbero
   * di radice v (quindi incluso il nodo stesso) e l'altezza + 1
   * dello stesso sia massimo;
   * in questo esercizio si considera l'altezza incrementata di 1,
   * altrimenti per le foglie il rapporto sarebbe 1/0 = infinito,
   * e l'esercizio sarebbe banale: il risultato sarebbe
   * una qualunque foglia.
   * E' come se l'altezza fosse definita 0 per l'albero vuoto,
   * 1 per le foglie, ecc.
   *
   * Per ragioni di debugging,
   * il metodo può (e anzi, per ora deve), prima di restituire il riferimento al nodo,
   * scrivere sulla console il valore del rapporto per quel nodo.
   *
   * NOTA BENE: Si richiede che l'algoritmo sia lineare nel numero
   * dei nodi, visitando quindi l'albero una volta sola.
   *
   * Si puo' definire una classe privata ausiliaria,
   * analogamente a quanto proposto per qualche esercizio precedente
   *
   *
   * Naturalmente per fare "il vero lavoro"
   * occorre definire un metodo ricorsivo protected o private,
   * richiamato dal metodo pubblico
   */
  public NodeReference maxDescendantsHeightRatio() {
    return null;
  } 
  
  /**
   * Esercizio 3.14 libro di testo
   * scrive sulla consolle i valori dei nodi v che soddisfano
   * alla seguente condizione:
   * la somma dei valori degli antenati di v (v incluso)
   * è uguale alla somma dei valori dei discendenti di v (v incluso).
   * Nota: si definisca un opportuno metodo protetto o privato ...
   */
  
  public void printEquiNodes() {
    System.out.println("nodi equi");
    printEquiNodes(root,root.element);
    System.out.println();    
  }  
  private int printEquiNodes(Node nd,int sommaAntenati){
  	if(nd==null) return 0;
  	else{
  		int sumDicendat = sum(nd);
  		int sumAscndantL = printEquiNodes(nd.left,sommaAntenati+nd.element);
  		int sumaAscendantR = printEquiNodes(nd.right,sommaAntenati+nd.element);
  		int sommaAntenatiTot = sumAscndantL+sumaAscendantR;
  		if(sommaAntenati == sumDicendat) System.out.println("nodo equo: "+nd.element);
  		return sommaAntenatiTot;	
  	}
  }
  public void putSize(){
  	if(root!=null) putSize(root);
  }
  private void putSize(Node nd){
  	if(nd!=null && nd.left==null && nd.right==null) nd.element = 1;
  	else if(nd!=null){
  		putSize(nd.left);
  		putSize(nd.right);
  		if(nd.left !=null && nd.right!=null) nd.element= 1 +nd.left.element+nd.right.element;
  		else if(nd.left!=null && nd.right==null) nd.element = 1 + nd.left.element;
  		else if(nd.left==null && nd.right!=null) nd.element = 1 +nd.right.element;
  	}
  	/*
  	if(nd != null) { 
  		 nd.element = 1; 
  		 putSize(nd.left); 
  		 putSize(nd.right); 
  		 if(nd.left != null) nd.element += nd.left.element; 
  		 if(nd.right != null) nd.element += nd.right.element; 
  		 } 
  		 */

  }
  
  
}

