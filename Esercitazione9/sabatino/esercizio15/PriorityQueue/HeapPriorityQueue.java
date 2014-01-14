package sabatino.esercizio15.PriorityQueue;

import java.util.*;

public class HeapPriorityQueue<V> implements PriorityQueue<V> {
	

	
	ElemConPrior<V>[]heap;
	int indiceUltimo;
	HashMap<V,Integer> position;
	
	public HeapPriorityQueue(int n){
		heap = new ElemConPrior[n+1];
		indiceUltimo = 0;
		position = new HashMap<V,Integer>(); 
	}
	
	private void moveUp(int i){
		if(i > indiceUltimo) throw new IllegalArgumentException();
		ElemConPrior<V> ep = heap[i];
		while(i>0){
			if(ep.priority>=heap[(i-1)/2].priority) break;
			heap[i] = heap[(i-1)/2];
			position.put(heap[i].element,i);
			i=(i-1)/2;
		}
		heap[i]=ep;
	}
	
	private void moveDown(int i){
		if(i > indiceUltimo) throw new IllegalArgumentException();
			ElemConPrior el = heap[i];
			int j;
			while((j=(2*i)+1)<=indiceUltimo){
				if(j+1<=indiceUltimo && heap[j+1].priority<heap[j].priority) 
					j++;
				if(el.priority<=heap[j].priority) break;
				heap[i]=heap[j];
				position.put(heap[i].element, i);
				i=j;
			}
			heap[i]=el;
	}
	
	@Override
	public boolean isEmpty() {
		if(indiceUltimo==0)return true;
		return false;
	}

	@Override
	public void insert(V element, double priority) {
		if(indiceUltimo==heap.length-1) throw new IllegalArgumentException();
		if(position.get(element)==null){	
			heap[indiceUltimo] = new ElemConPrior(element,priority);
			moveUp(indiceUltimo++);
		}
	}

	@Override
	public V extractfirst() {
		if(indiceUltimo<=0) throw new IllegalArgumentException();
		V first = heap[0].element;
		ElemConPrior last = heap[indiceUltimo-1];
		position.put(null, indiceUltimo);
		heap[indiceUltimo--] = null;
		if(indiceUltimo>=0){
			heap[0]=last;
			moveDown(0);
		}
		return first;
	}

	@Override
	public V getFirst() {
		return heap[0].element;
	}

	@Override
	public boolean decreasePriority(V element, double newPriority) {
		if(position.get(element)!=null){
			int i = position.get(element);
			if(i>indiceUltimo || i<0) throw new IllegalArgumentException();
			if(heap[i].priority<newPriority) return false;
			heap[i].priority = newPriority;
			moveDown(i);
			moveUp(i);
			return true;
		}
		return false;
	}

	@Override
	public void remove(V element) {
		if(indiceUltimo<=0) throw new IllegalArgumentException();
		int i= position.get(element);
		System.out.println("inidce da eliminare: "+i);
		heap[i] = heap[indiceUltimo-1];
		indiceUltimo=indiceUltimo-1;
		moveDown(i);
		
		
	}
	
	public void printHeap(){
		for(int i = 0;i<indiceUltimo;i++)
			System.out.println("Elemento: "+heap[i].element+" , Priorità: "+heap[i].priority+" indice: "+i);
	}

}
