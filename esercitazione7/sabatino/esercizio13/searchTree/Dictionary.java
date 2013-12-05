package sabatino.esercizio13.searchTree;

public interface Dictionary<K extends Comparable<K>>{
	ObjectWhitKey<K> get(K key);
	boolean isEmpty();
	
	/*
	 * inserisce nel dizionario l 'elemnto
	 */
	ObjectWhitKey<K> put(ObjectWhitKey<K> element);
	
	/*
	 * rimuove un elemnto di chiave key dal dizionario 
	 */
	ObjectWhitKey<K> remove(K key);
	
	/*
	 * restituisce il numero di elementi presenti nel dizionario
	 */
	int size();
	
	/*
	 * restituisce l'elemento di chiave massima
	 */
	ObjectWhitKey<K> max();
}
