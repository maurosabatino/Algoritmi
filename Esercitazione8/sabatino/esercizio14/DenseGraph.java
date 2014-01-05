package sabatino.esercizio14;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class DenseGraph<V,E> implements Graph<V,E>{
	
	ArrayList<V> nodi;	//vertex
	HashMap<V,ArrayList<E>> archi;
	int n;
	int m;
	
	DenseGraph(){
		nodi = new ArrayList<V>();
		archi = new HashMap<V,ArrayList<E>>();
		n = 0;
		m = 0;
	}
	
	@Override
	public boolean addVertex(V vertex) {
		if(!nodi.contains(vertex)){
			nodi.add(vertex);
			n++;
			ArrayList<E> neighbors = new ArrayList<E>();
			archi.put(vertex,(ArrayList<E>) neighbors);
			return true;
		}
		
		return false;
	}

	@Override
	public boolean addEdge(V v1, V v2, E info) {
		if(nodi.contains(v1)){
			if(!nodi.contains(v1)) addVertex(v1);
			if(!nodi.contains(v2)) addVertex(v2);
			Arco<V,E> a = new Arco<V, E>(info,v1,v2);
			ArrayList<Arco> neighbors = (ArrayList<Arco>)archi.get(v1);
			neighbors.add(a);
			m++;
			return true;
		}
		return false;
	}

	@Override
	public boolean addEdge(V v1, V v2, double weight, E info) {
		if(nodi.contains(v1)){
			if(!nodi.contains(v1)) addVertex(v1);
			if(!nodi.contains(v2)) addVertex(v2);
			Arco<V,E> a = new Arco<V, E>(info,v1,v2,weight);
			ArrayList<Arco> neighbors = (ArrayList<Arco>)archi.get(v1);
			neighbors.add(a);
			m++;
			return true;
		}
		return false;
	}

	@Override
	public boolean addUndirectedEdge(V v1, V v2, E info) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addUndirectedEdge(V v1, V v2, double weight, E info) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasVertex(V vertex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasEdge(V v1, V v2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double getWeight(V source, V dest) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<V> vertices() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<V> neighbors(V vertex) {
		// TODO Auto-generated method stub
		return null;
	}

	public void printVertex(){
		for(V i : nodi)
			System.out.println(i);
	}
	public void printNeighbors(int vertex){
		ArrayList<Arco> neighbors = (ArrayList<Arco>)archi.get(vertex);
		for(Arco<V,E> a : neighbors)
			System.out.println("iniziale: "+a.in+" finale: "+a.fin+" info: "+a.info);
	}
	public void ToDot(String GraphName) throws IOException{
		String Graph = GraphName+".dot";
	  FileWriter outFile = new FileWriter(Graph, false);
	  PrintWriter out = new PrintWriter(outFile);
	  out.println("digraph "+GraphName+"{");
	  for(V i : nodi){
	  	ArrayList<Arco> neighbors = (ArrayList<Arco>)archi.get(i);
			for(Arco<V,E> a : neighbors){
				out.println(a.in+" -> "+a.fin+";");
			}
	  }
	  out.println("}");
	  out.close();
	}
}
