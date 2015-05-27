package sabatino.esercizio15.PriorityQueue.test;

import sabatino.esercizio15.PriorityQueue.HeapPriorityQueue;
import sabatino.esercizio15.PriorityQueue.PriorityQueue;


public class MinPriorityQueueTest {
	static PriorityQueue<Integer> q;
	public static void main(String[] args){
		q = new HeapPriorityQueue<Integer>(10);
		q.insert(10, 10);
		q.insert(7, 7);
		q.insert(3, 13);
		q.insert(1, 1);
		q.insert(1, 10);
		q.insert(12, 15);
		System.out.println("estraggo il primo: "+q.extractfirst().toString());
		System.out.println("estraggo il primo: "+q.extractfirst().toString());
		System.out.println("estraggo il primo: "+q.extractfirst().toString());
		System.out.println("estraggo il primo: "+q.extractfirst().toString());
		System.out.println("estraggo il primo: "+q.extractfirst().toString());
		System.out.println("estraggo il primo: "+q.extractfirst().toString());
	}
	
}
