package sabatino.esercizio14.NoGeneric;

public class Test {
	public static void main(String[] args){
		DenseGraph grafo = new DenseGraph();
		grafo.addVertex(4);
		grafo.addVertex(8);
		grafo.printVertex();
		grafo.addEdge(4, 8, "4-8");
		grafo.printNeighbors(4);
	}
}
