package sabatino.esercizio16.test;

import java.util.ArrayList;

import sabatino.esercizio14.Graph;
import sabatino.esercizio14.SparseGraph;
import sabatino.esercizio16.minPathBellmanFord;


public class minPathBellmanFordTest {
	public static void main(String[]args){
		Graph<Integer,String> grafo = new SparseGraph<Integer,String>();
		minPathBellmanFord<Integer,String> bellmanFord = new minPathBellmanFord<Integer,String>();
	
		grafo.addVertex(4);
		grafo.addVertex(8);
		grafo.addVertex(11);
		grafo.addVertex(3);
		grafo.addVertex(9);
	

		grafo.addEdge(4, 8,2,"4->8");
		grafo.addEdge(4, 11,3,"4->11");
		grafo.addEdge(8, 3,11,"8->3");
		grafo.addEdge(3, 9,21,"3->9");
		grafo.addEdge(11, 9,2,"11->9");
		
		ArrayList<Integer> result =bellmanFord.minPath(grafo, 4, 9);
		if(result!=null){
			System.out.println("cammino trovato");
			for(Object i: result) System.out.println(i);
		}else System.out.println("non esiste un cammino valido");
	}
}
