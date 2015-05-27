package sabatino.esercizio16;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import sabatino.esercizio14.Graph;

public class minPathBellmanFord<V,E> {
	HashMap<V,Double> dist;
	Map<V,V> padri;
	ArrayList<V> path;
	int n;
	public ArrayList<V> minPath(Graph<V,E> g,V s,V d){
		
		dist = new HashMap<V,Double>();
		padri = new HashMap<V,V>();
		path = new ArrayList<V>();
		n = g.vertices().size();
		
		ArrayList<V> vertex = g.vertices();
		for(V x:vertex){
			dist.put(x,Double.POSITIVE_INFINITY);
			padri.put(x,null);
		}
		padri.put(s, s);
		dist.put(s, 0.0);
		
		for(int i=0;i<=n;i++){
			for(V u :vertex){
				for(V v: g.neighbors(u)){
					double weight = g.getWeight(u, v);
					double distanceThrought = dist.get(u)+weight;
					if(distanceThrought<dist.get(v)){
						dist.put(v, distanceThrought);
						padri.put(v, u);
					}
				}
			}
		}
		V step;
		step = d;
		if(padri.get(d)==null)
			return null;
		path.add(step);
		while(padri.get(step)!=null){
			if(step.equals(s)) break;
			step = padri.get(step);
			path.add(step);
		}
		Collections.reverse(path);
		
		
		return path;
	}
}
