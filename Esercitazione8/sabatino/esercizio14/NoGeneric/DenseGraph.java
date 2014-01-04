package sabatino.esercizio14.NoGeneric;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


public class DenseGraph implements Graph{
	
	ArrayList<Integer> nodi;	//vertex
	HashMap archi;
	int n; // numero nodi
	int m; // numero archi
	

	DenseGraph(){
		nodi = new ArrayList<Integer>();
		archi = new HashMap();
		n = 0;
		m = 0;
	}
	@Override
	public boolean addVertex(int vertex) {
		if(!nodi.contains(vertex)){
			nodi.add(vertex);
			n++;
			ArrayList neighbors = new ArrayList();
			archi.put(vertex,neighbors);
			return true;
		}
		
		return false;
	}
	@Override
	public boolean addEdge(int v1, int v2, String info) {
		if(!nodi.contains(v1)) addVertex(v1);
		if(!nodi.contains(v2)) addVertex(v2);
		Arco a = new Arco(info,v1,v2);
		ArrayList neighbors = (ArrayList)archi.get(v1);
		neighbors.add(a);
		
		return false;
	}
	@Override
	public boolean addEdge(int v1, int v2, double weight, String info) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean addUndirectedEdge(int v1, int v2, String info) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean addUndirectedEdge(int v1, int v2, double weight, String info) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean hasVertex(int vertex) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean hasEdge(int v1, int v2) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public double getWeight(int source, int dest) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public ArrayList<Integer> vertices() {
		return nodi;
		
	}
	@Override
	public ArrayList<Integer> neighbors(int vertex) {
		return (ArrayList)archi.get(vertex);
	}
	public void printVertex(){
		for(Integer i : nodi)
			System.out.println(i);
	}
	public void printNeighbors(int vertex){
		ArrayList<Arco> neighbors = (ArrayList)archi.get(vertex);
		for(Arco a : neighbors)
			System.out.println("iniziale: "+a.in+" finale: "+a.fin+" info: "+a.info);
	}
	
}
	