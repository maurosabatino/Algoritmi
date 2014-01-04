package sabatino.esercizio14.NoGeneric;

public interface GraphVisit<V, E> {
	Graph<V,E> breadthFirst(Graph<V,E> graph,V s,VertexAnalyser<V> va);
	Graph<V,E> depthFirst(Graph<V,E> graph, V s,VertexAnalyser<V> va);
}
