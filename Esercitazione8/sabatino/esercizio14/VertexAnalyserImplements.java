package sabatino.esercizio14;
/**
 * classe che implementa l'interfaccia VertexAnalyser, contenente un metodo che analizza il vertice passato come paramentro, 
 * in questa implementazione si � deciso che il metodo stamper� a console il valore del verice.
 * @author Mauro
 *
 * @param <V> tipo generico che rappresenta i nodi del grafo
 */
public class VertexAnalyserImplements<V> implements VertexAnalyser<V>{

	/**
	 * analizza il vertice vertex fornito come parametro,
	 * in questa implementazione verr� stampato il contenuto di vertex a console.
	 * @param vertex vertiche verr� analizzato dal metodo
	 */
	@Override
	public void analyse(V vertex) {
		System.out.println(vertex);
	}

}
