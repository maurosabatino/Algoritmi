package esercizio8;

public class HeapPriorityQueueTest {
	public static void main(String[]args){
		HeapPriorityQueue heapQ = new HeapPriorityQueue(10);
		heapQ.insert("ciao", 1);
		heapQ.insert("Pippo", 10);
		System.out.println(heapQ.getFirst());
		heapQ.extractfirst();
		System.out.println(heapQ.getFirst());
	}
}
