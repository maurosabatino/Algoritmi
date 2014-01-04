package sabatino.esercizio14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class DenseGraph<V,E extends Arco<V>> implements Graph<V,E>{
	Set<V,Set<V>> st;
	ArrayList<V> nodi;	//vertex
	int nArchi;
	HashMap<V,E> hash;
	DenseGraph(){
		nodi = new ArrayList<V>();
		hash = new HashMap<V,E>();
		nArchi = 0;
	}
	
	@Override
	public boolean addVertex(V vertex) {
		if (!nodi.contains(vertex)) {
      List<E> lista = new ArrayList<E>();
      nodi.add(vertex);
      hash.put(vertex, (E)lista);
      
      return true;
    }
		return false;
	}

	@Override
	public boolean addEdge(V v1, V v2, E info) {
		if(nodi.contains(v1)){
			hash.
		}
		return false;
	}

	@Override
	public boolean addEdge(V v1, V v2, double weight, E info) {
		// TODO Auto-generated method stub
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

	
}
