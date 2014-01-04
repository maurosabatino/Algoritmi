package sabatino.esercizio14.NoGeneric;

import java.util.ArrayList;
import java.util.HashMap;



public class DenseGraph implements Graph{
	
	ArrayList<Integer> nodi;	//vertex
	HashMap<Integer, ArrayList<Arco>> archi;
	int n; // numero nodi
	int m; // numero archi
	

	DenseGraph(){
		nodi = new ArrayList<Integer>();
		archi = new HashMap<Integer, ArrayList<Arco>>();
		n = 0;
		m = 0;
	}
	@Override
	public boolean addVertex(int vertex) {
		if(!nodi.contains(vertex)){
			nodi.add(vertex);
			n++;
			ArrayList<Arco> neighbors = new ArrayList<Arco>();
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
		ArrayList<Arco> neighbors = (ArrayList<Arco>)archi.get(v1);
		neighbors.add(a);
		m++;
		return true;
	}
	@Override
	public boolean addEdge(int v1, int v2, double weight, String info) {
		if(!nodi.contains(v1)) addVertex(v1);
		if(!nodi.contains(v2)) addVertex(v2);
		Arco a = new Arco(info,v1,v2,weight);
		ArrayList<Arco> neighbors = (ArrayList<Arco>)archi.get(v1);
		neighbors.add(a);
		m++;
		return true;
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
	public ArrayList<Arco> neighbors(int vertex) {
		return (ArrayList<Arco>)archi.get(vertex);
	}
	public void printVertex(){
		for(Integer i : nodi)
			System.out.println(i);
	}
	public void printNeighbors(int vertex){
		ArrayList<Arco> neighbors = (ArrayList<Arco>)archi.get(vertex);
		for(Arco a : neighbors)
			System.out.println("iniziale: "+a.in+" finale: "+a.fin+" info: "+a.info);
	}
	
}
	