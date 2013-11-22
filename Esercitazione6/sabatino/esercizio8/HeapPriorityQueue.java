package sabatino.esercizio8;

import java.util.*;

public class HeapPriorityQueue implements PriorityQueueString {
	private class ElemConPrior{
		String element;
		double priority;
		ElemConPrior(String el,double p){
			element=el;
			priority=p;
		}
	}//
	ElemConPrior[]heap;
	int indiceUltimo;
	HashMap<String,Integer> position;
	
	public HeapPriorityQueue(int n){
		heap = new ElemConPrior[n+1];
		indiceUltimo = 0;
		position = new HashMap<String,Integer>(); 
	}
	
	private void moveUp(int i){
		if(i > indiceUltimo) throw new IllegalArgumentException();
		ElemConPrior ep = heap[i];
		while(i>=0){
			if(ep.priority>=heap[(i-1)/2].priority) break;
			heap[i] = heap[(i-1)/2];
			position.put(heap[i].element,i);
			i=(i-1)/2;
		}
		heap[i]=ep;
		position.put(ep.element, i);
	}
	
	private void moveDown(int i){
		if(i > indiceUltimo) throw new IllegalArgumentException();
		ElemConPrior el = heap[i];
		int j;
		while((j=2*i+1)<= indiceUltimo){
			if(j+1<=indiceUltimo && heap[j+1].priority<heap[j].priority) j++;
			if(el.priority<=heap[j].priority) break;
			heap[i]=heap[j];
			position.put(heap[i].element, i);
			i=j;
		}
		heap[i]=el;
		position.put(el.element, i);
	}
	
	@Override
	public boolean isEmpty() {
		if(indiceUltimo==0)return true;
		return false;
	}

	@Override
	public void insert(String element, double priority) {
		if(indiceUltimo==heap.length-1) throw new IllegalArgumentException();
		if(position.get(element)==null){	
			heap[indiceUltimo] = new ElemConPrior(element,priority);
			indiceUltimo++;
			moveUp(indiceUltimo-1);
		}
	}

	@Override
	public String extractfirst() {
		if(indiceUltimo==0) throw new IllegalArgumentException();
		String first = heap[0].element;
		ElemConPrior last = heap[indiceUltimo];
		position.put(null, indiceUltimo);
		heap[indiceUltimo--] = null;
		if(indiceUltimo>=0){
			heap[0]=last;
			moveDown(0);
		}
		return first;
	}

	@Override
	public String getFirst() {
		return heap[0].element;
	}

	@Override
	public boolean decreasePriority(String element, double newPriority) {
		if(position.get(element)!=null);{
		int i = position.get(element);
		if(i>indiceUltimo || i<0) throw new IllegalArgumentException();
		if(heap[i].priority<newPriority) return false;
		heap[i].priority = newPriority;
		moveDown(i);
		moveUp(i);
		return true;
		}
	}

	@Override
	public void remove(String element) {
		if(position.get(element)!=null){
			int i = position.get(element);
			heap[i] = heap[indiceUltimo--];
			moveDown(i);
			
		}
	}

}
