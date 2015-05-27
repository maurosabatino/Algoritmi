package sabatino.esercizio14;

/**
 * interfaccia per la visita di un grafo, sono rese implementabili due tipologie principali (quelle studiate all'interno del corso):
 *  - visita in ampiezza -> breadthFirst che visita il grafo per "livelli"
 *  - visita in profondità -> depthFirst 
 *  
 * @author Mauro
 *
 * @param <V> tipo generico utilizzato per rappresentare i vertici (vertex) del grafo.
 * @param <E> tipo generico utilizzato per rappresentare le informazioni degli archi (edges) del grafo.
 */
public interface GraphVisit<V, E> {
	/**
	 * effettua una visita completa di un grafo in ampiezza
	 * il grafo verrà vistato a partire da un nodo s e man mano verrano visitati tutti i nodi adiacenti.
	 * @param graph grafo che si vuole visitare
	 * @param s nodo da quale si vuole far partire la visita
	 * @param va oggetto che implementa una possibile visita del grafo
	 * @return ritorna il grafo visitato in ampiezza
	 */
	Graph<V,E> breadthFirst(Graph<V,E> graph,V s,VertexAnalyser<V> va);
	/**
	 * effettua una visita completa in profondità del grafo fornito come parametro
	 * @param graph grafo che deve essere visitato in profondità
	 * @param s nodo di partenza da cui si cuole cominciare la visita in profondità.
	 * @param va classe che implementa un operazione di analisi nella visita del grafo (può anche essere una semplice stampa su console del valore del nodo) 
	 * @return grafo visitato in profondità
	 */
	Graph<V,E> depthFirst(Graph<V,E> graph, V s,VertexAnalyser<V> va);
}
