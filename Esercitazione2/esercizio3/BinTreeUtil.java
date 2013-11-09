package esercizio3;
import static java.lang.Math.*;
import static java.lang.System.out;

public class BinTreeUtil {

  private BinTreeUtil() {
  }

  /* 
   inserisce elem nell'albero t nel punto specificato dalla stringa path
    e restituisce l'albero t modificato. Se la stringa path conduce a un nodo
    (anzichÃ© a un figlio vuoto di un nodo), elem sostituisce il valore del nodo
    che Ã¨ stato raggiunto.
  */
  public static BinTree add(int elem, BinTree t, String path) {
    if(t==null) return new BinTree(elem);
    else {
    	if(path.length()==0) t.element=elem;
    	else{
    		char go = path.charAt(0);
    		String nextPath = path.substring(1);
    		if(go=='L') t.left= add(elem,t.left,nextPath);
    		else if(go=='R') t.right=add(elem,t.right,nextPath);
    		else throw new IllegalArgumentException("stringa non corretta");
    	}
      return t;
    }
  }


  /* NON FA PARTE DELL'ESERCIZIO. Potete usare questo metodo
    per visualizzare in modo semplice l'albero t sulla consolle,
    (ruotato di 90 gradi).
  */
  public static void display(BinTree t) {
    display(t, 0);
  }

  /* NON FA PARTE DELL'ESERCIZIO. Usato da display(BinTree t) */
  private static void display(BinTree t, int k) {
    if(t != null) {
      display(t.right, k+1);
      for(int i = 0; i < k; i++) out.print("   ");
      out.println(t.element);
      display(t.left, k+1);
    }
  }

  /*
    PRE-condizione: t non e' nullo;
    da' come risultato true se t e' una foglia, false altrimenti
  */
  public static boolean isLeaf(BinTree t) {
    return t.left == null && t.right == null;
  }

  /*
    Stampa t sulla consolle. L'ordine dei valori deve corrispondere
    ai valori che vengono incontrati durante una visita anticipata (preorder).
  */
  public static void preorderPrint(BinTree t) {
  	System.out.println(t.element);
  	preorderPrint(t.left);
  	preorderPrint(t.right);
  
  }

  /*
    Stampa t sulla consolle. L'ordine dei valori deve corrispondere
    ai valori che vengono incontrati durante una visita simmetrica (inorder).
  */
  public static void inorderPrint(BinTree t) {
  	inorderPrint(t.left);
  	System.out.println(t.element);
  	inorderPrint(t.right);
  }

  /*
  Stampa i valori nei nodi in t sulla consolle. L'ordine dei valori deve corrispondere
  ai valori che vengono incontrati durante una visita posticipata (postorder).
  */
  public static void postorderPrint(BinTree t) {
  	if(t!=null){
  	postorderPrint(t.left);
  	postorderPrint(t.right);
  	System.out.println(t.element);
  	}
  }

  /* restituisce il numero dei nodi in t*/
  public static int size(BinTree t) {
    /*if(t==null) return 0;
    else return size(t.left)+size(t.right)+1;*/
  	return t==null ? 0 :size(t.left)+size(t.right)+1;
  }

  /*
     restituisce la somma dei valori di tutti gli elementi.
    Restituisce Integer.MIN_VALUE se l'albero Ã¨ vuoto
  */
  public static int sum(BinTree t) {
    return t==null ? 0: t.element+sum(t.left)+sum(t.right);
  	

  }

  /* restituisce l'altezza dell'albero */
  public static int height(BinTree t) {
    return t==null?-1:1+max(height(t.left),height(t.right));
  }

  /*
    restituisce il massimo degli elementi;
    se l'albero e' vuoto da' come risultato Integer.MIN_VALUE
   */
  public static int maxElem(BinTree t) {
    if(t==null) return Integer.MIN_VALUE;
    else return max(t.element, max(maxElem(t.left),maxElem(t.right)));
  }

  /*
    PRECOND: gli elementi contenuti nei nodi sono tutti >= 0;

    Restituisce il massimo dei pesi dei cammini
    dalla radice a una foglia (non nulla)
    dove il peso del cammino e' la somma dei valori
    degli elementi dei nodi lungo il cammino,
    e dove maxPath(null) vale 0
   */
  public static int maxPositivePath(BinTree t) {
    if(t==null)return 0;
    else return t.element+max(maxPositivePath(t.left),maxPositivePath(t.right));
  }

  /*
  Restituisce il massimo dei pesi dei cammini
  dalla radice a una foglia (non nulla)
  (ci possono essere elementi negativi),
  dove il peso del cammino e' la somma dei valori
  degli elementi dei nodi lungo il cammino,
  e dove maxPath(null) vale Integer.MIN_VALUE
  */
  public static int maxPath(BinTree t) {
  	 if(t==null)return Integer.MIN_VALUE;
     else return t.element+max(maxPositivePath(t.left),maxPositivePath(t.right));
  }

  /*
   * Restituisce il numero delle foglie
  */
  public static int numberOfLeaves(BinTree t) {
    if(t==null) return 0;
    else if (isLeaf(t)) return 1;
    else return numberOfLeaves(t.left)+numberOfLeaves(t.right);
    //return (t == null) ? 0 : !isLeaf(t) ? numOfLeaves(t.left) + numOfLeaves(t.right) : +1;
  }

  /*
    modifica l'albero incrementando di 1 i valori
    di tutti gli elementi
  */
  public static void increment(BinTree t) {
    if(t!=null){
    	t.element++;
    	increment(t.left);
    	increment(t.right);
    }
  }

  /*
    modifica l'albero incrementando di 1 i valori
    di tutte le foglie
  */
  public static void incrementLeaves(BinTree t) {
    if(t!=null ){
    	if(isLeaf(t)){
    		t.element++;
    	}
    	incrementLeaves(t.left);
    	incrementLeaves(t.right);
    }
  }

  /*
    restituisce come risultato true se l'elemento x e' presente in t,
    false altrimenti
  */
  public static boolean search(int x, BinTree t) {
  	return (t==null) ? false : (t.element==x) ? true :  (search(x,t.left)|| search(x,t.right)); 
  }

  /*
    restituisce il (o un) sottoalbero di t avente come radice x, se esiste
    (senza creare nuovi nodi o un nuovo albero);
    se invece x non e' presente in t, da' come risultato null
  */
  public static BinTree find(int x, BinTree t) {
  	if(t.element==x) return t;
		if(t.left!=null && search(x, t.left)) return find(x, t.left);
		if(t.right!=null && search(x, t.right)) return find(x, t.right);
		return null;
  }

 /*
    restituisce true se t1 e t2 hanno la stessa struttura e gli stessi valori. false altrimenti.
  */
  public static boolean areEqual(BinTree t1, BinTree t2) {
    return t1 == t2 || (t1!=null && t2!=null && t1.element==t2.element && areEqual(t1.left,t2.left) && areEqual(t1.right,t2.right));
  }

  /*
    crea e restituisce un nuovo albero copia di t
  */
  public static BinTree copy(BinTree t) {
    if(t==null) return null;
    else return new BinTree(t.element,copy(t.left),copy(t.right));
  }

  /*
    costruisce e restituisce un nuovo albero speculare di t
  */
  public static BinTree mirrorCopy(BinTree t) {
  	return (t == null) ? null : new BinTree(t.element, (t.right != null ? mirrorCopy(t.right) : null), (t.left != null ? mirrorCopy(t.left) : null));
  }

  /* 
    modifica l'albero t, senza creare nuovi nodi,
    facendolo diventare il suo speculare
  */
  public static void mirrorInPlace(BinTree t) {
  	if(t!=null){
  		BinTree temp=t.left;
  		t.left=t.right;
  		t.right=temp;
  		mirrorInPlace(t.left);
  		mirrorInPlace(t.right);
  	}
  }

  /*
    restituisce la somma dei valori di tutti i nodi
    di un sottoalbero di t di radice x,
    includendo x stesso nella somma.
    Se esistono piu' elementi di valore x,
    restituisce il risultato relativo al primo elemento x che trova.
    Se il valore x non compare nell'albero, restituisce Integer.MIN_VALUE.
    Nota: puo' richiamare altri metodi di questa classe.
   */
  public static int sumDescendants(int x, BinTree t) {
    
  	if(t.element==x)return sum(t);
  	if(t.left!=null && search(x,t.left))return sumDescendants(x,t.left);
  	if(t.right!=null && search(x,t.right))return sumDescendants(x,t.right);
  	return Integer.MIN_VALUE;
  }

  /*
   * costruisce e restituisce un nuovo albero
   * uguale a t fino al livello h-1 incluso,
   * ma privo di tutti i nodi che si trovano
   * a un livello maggiore o uguale ad h,
   * senza modificare l'albero di partenza t.
   */
  public static BinTree trimmed(int h, BinTree t){
    if(t==null || h==0) return null;
    else return new BinTree(t.element,trimmed(h-1,t.left),trimmed(h-1,t.right));
  }

  /*
   * modifica l'albero t eliminando tutti i nodi
   * di livello >= h, e restituisce l'albero stesso, modificato
   */
  static BinTree trim(int h, BinTree t){
    if(t==null || h==0)return null;
    else{
    	t.left=trim(h-1,t.left);
    	t.right=trim(h-1,t.right);
    	return t;
    }
  }

  /* nodi cardine
      scrive sulla console i nodi-cardine dell'albero
      (vedi libro di testo pag. 95):
      chiamiamo cardine un nodo tale che il suo livello nell'albero sia uguale
      all'altezza del sottoalbero di cui esso e' radice, assumendo che
      un (sotto)albero costituito da un solo nodo abbia altezza 0
      (e quindi un sottoalbero vuoto abbia altezza -1).
   */
  public static void printCentralNodes(BinTree t) {
  	cardine(t,0);
  }
  public static int cardine(BinTree t,int p){
  	if(t==null) return -1;
  	else{
  		int hl = cardine(t.left,p+1);
  		int hr = cardine(t.right,p+1);
  		int h = max(hl,hr)+1;
  		if(p==h) {
  			System.out.println("cardine : "+t.element);
  		}
  		return h;
  	}
  }
  /*
    classe ausiliaria per l'esercizio successivo
   */
  private static class BoolIntPair {
    boolean isCB;
    int height;

    BoolIntPair(boolean isCB, int height) {
      this.isCB = isCB; height = this.height;
    }
  }

  /*TODO balanced text book
   * restituisce true se l'albero t Ã¨ "completamente bilanciato"
   * secondo la definizione del libro di testo,
   * altrimenti false: realizzazione come sul libro di testo
   * (vedi pag. 92-93)
   */
  public static boolean isCompletelyBalancedFromTextbook(BinTree t) {
   return isCBHeight(t).isCB;
  }

  private static BoolIntPair isCBHeight(BinTree t) {
  	if(t==null) return new BoolIntPair(true,-1);
  	else{
  		BoolIntPair l=isCBHeight(t.left);
  		BoolIntPair r=isCBHeight(t.right);
  		int h=(max(l.height,r.height)+1);
  		boolean completamenteBil;
  		if(l.isCB && r.isCB && (l.height==r.height))completamenteBil=true;
  			else completamenteBil= false;
  		System.out.println("al nodo: "+t.element+" il booleano da come risultato: "+completamenteBil+" e altezza:"+h);
  		
  		return new BoolIntPair(completamenteBil,h);
  	}
  }

  /*
   * restituisce true se l'albero t Ã¨ "completamente bilanciato"
   * secondo la definizione del libro di testo,
   * altrimenti false: realizzazione "snella"
   */
  public static boolean isCompletelyBalanced(BinTree t) {
  	if(t==null)return true;
    else if(heightCB(t)>0)return true;
    return false;
  }

  private static int heightCB(BinTree t) {
  	if(t==null)return -1;
  	else{
  	int l = heightCB(t.left);
  	int r = heightCB(t.right);
  	if(l==r) return l+1;
  	else return -(max(l,r)+1);
  	}
  }

  /*
    classe ausiliaria per l'esercizio successivo
   */
  protected static class IntPair {
    int height;
    int maxUnbal;

    IntPair(int h, int u) {
      height = h; maxUnbal = u;
    }
  }

  /*sbilanciamento
   * nello stile del libro di testo:
   * restituisce il massimo sbilanciamento
   * dei nodi di un albero
   */
  public static int maxUnbalance(BinTree t) {
    return heightUnbalance(t).maxUnbal;
  }

  /*
   * nello stile del libro di testo:
   * restituisce una coppia di interi di cui il primo
   * Ã¨ l'altezza di t, il secondo Ã¨ il massimo sbilanciamento
   * dei sottoalberi di t, dove si definisce:
   * sbilanciamento di un albero = valore assoluto della differenza fra
   * l'altezza del sottoalbero sinistro e l'altezza del sottoalbero destro
   */
  private static IntPair heightUnbalance(BinTree t) {
    if(t == null) return new IntPair(-1,0);
    else {
    	IntPair l = heightUnbalance(t.left);
    	IntPair r = heightUnbalance(t.right);
    	if(l.height==r.height){
    		return new IntPair(l.height+1,abs(l.height-r.height));
    	}
    	else{
    				return new IntPair(-(max(l.height,r.height)+1),abs(l.height-r.height));
    	}
    }
  }

  /* TODO  vedi pag 119 del libro
   * un nodo è 1-bilanciato se l'altezza dei suoi figli differiscono per al più di un'unità
   * |h(t.left-h(t.right)|<=1
   * restituisce true se l'albero t è "1-bilanciato",
   * altrimenti false
   */
  public static boolean is1Balanced(BinTree t) {
    int x = OneBalanced(t);
    if(x>=0)return true;
    else return false;
  }
  private static int  OneBalanced(BinTree t){
  	if(t==null) return -1;
  	else{
  	 	int l= OneBalanced(t.left);
  		int r= OneBalanced(t.right); 
  		if(l==r || abs(l-r)<=1) return max(l,r)+1;
  		else return -max(l,r)+1;
  	}
  }
}

