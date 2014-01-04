package sabatino.esercizio14.NoGeneric;

import java.util.ArrayList;

public interface Graph {
	boolean addVertex(int vertex);
	boolean addEdge(int v1,int v2,String info);
	boolean addEdge(int v1,int v2,double weight,String info);
	boolean addUndirectedEdge(int v1,int v2,String info);
	boolean addUndirectedEdge(int v1,int v2,double weight,String info);
	boolean hasVertex(int vertex);
	boolean hasEdge(int v1,int v2);
	double getWeight(int source, int dest);
	ArrayList<Integer> vertices();
	ArrayList<Arco> neighbors(int vertex);
}
