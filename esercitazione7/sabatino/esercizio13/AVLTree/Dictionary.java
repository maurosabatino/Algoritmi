package sabatino.esercizio13.AVLTree;

public interface Dictionary{

	ObjectWhitKey get(int key);
	
	boolean isEmpty();
	
	/*
	 * inserisce nel dizionario l 'elemnto
	 */
	ObjectWhitKey put(ObjectWhitKey element);
	
	/*
	 * rimuove un elemnto di chiave key dal dizionario 
	 */
	ObjectWhitKey remove(int key);
	
	/*
	 * restituisce il numero di elementi presenti nel dizionario
	 */
	int size();
	
	/*
	 * restituisce l'elemento di chiave massima
	 */
	ObjectWhitKey max();
	
	ObjectWhitKey min();
}
