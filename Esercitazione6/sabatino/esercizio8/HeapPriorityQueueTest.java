package sabatino.esercizio8;

public class HeapPriorityQueueTest {
	
	public static void main(String[]args){
		HeapPriorityQueue heap = new HeapPriorityQueue(1);
		
		heap.insert("uno",1);
		heap.insert("due",2);
		heap.insert("tre",3);
		heap.insert("sei",6);
		heap.insert("quattro",4);
		heap.insert("otto",8);
		heap.insert("cinque",5);
		heap.insert("sette",7);
	
		System.out.println("ho estratto: "+heap.extractfirst());
		System.out.println("ho estratto: "+heap.extractfirst());
		System.out.println("ho estratto: "+heap.extractfirst());
		System.out.println("ho estratto: "+heap.extractfirst());
		System.out.println("ho estratto: "+heap.extractfirst());
		System.out.println("ho estratto: "+heap.extractfirst());
		System.out.println("ho estratto: "+heap.extractfirst());
		System.out.println("ho estratto: "+heap.extractfirst());
		
		heap.insert("uno",10);
		System.out.println(heap.extractfirst());
		heap.decreasePriority("uno", -20);
		heap.insert("due",2);
		heap.insert("tre",3);
		heap.insert("sei",6);
		heap.insert("quattro",4);
		heap.insert("otto",8);
		heap.insert("cinque",5);
		heap.insert("meno sette",-7);
		heap.insert("zero", 0);
		heap.decreasePriority("cinque", 3);
		heap.remove("sei");
		System.out.println("primo elemento "+heap.getFirst());
		System.out.println(heap.isEmpty());
		System.out.println(heap.extractfirst());
		System.out.println(heap.extractfirst());
		System.out.println(heap.extractfirst());
		System.out.println(heap.extractfirst());
		System.out.println(heap.extractfirst());
		System.out.println(heap.extractfirst());
		System.out.println(heap.extractfirst());
		System.out.println(heap.isEmpty());
	}
}
