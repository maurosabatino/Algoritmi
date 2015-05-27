package sabatino.esercizio15.PriorityQueue.test;

import static org.junit.Assert.*;

import org.junit.Test;

import sabatino.esercizio15.PriorityQueue.HeapPriorityQueue;
import sabatino.esercizio15.PriorityQueue.PriorityQueue;

public class HeapPriorityQueueJUnitTest {
	
	static PriorityQueue<Integer> q;
	
	@Test
	public void testExtractFirst() {
		q = new HeapPriorityQueue<Integer>(10);
		q.insert(10, 10);
		q.insert(7, 3);
		q.insert(3, 30);
		q.insert(1, 1);
		q.insert(12, 12);
		assertEquals(new Integer(1), q.extractfirst());
		assertEquals(new Integer(7), q.extractfirst());
		assertEquals(new Integer(10), q.extractfirst());
		assertEquals(new Integer(12), q.extractfirst());
		assertFalse(q.isEmpty());
		assertEquals(new Integer(3), q.extractfirst());
		assertTrue(q.isEmpty());
	}
	@Test
	public void testRemove(){
		q = new HeapPriorityQueue<Integer>(10);
		q.insert(10, 10);
		q.insert(7, 3);
		q.insert(3, 30);
		q.insert(1, 1);
		q.insert(12, 12);
		q.insert(8,11);
		assertEquals(new Integer(1), q.getFirst());
		q.remove(1);
		assertEquals(new Integer(7),q.getFirst());		
	}
	@Test
	public void testDecreasePriority(){
		q = new HeapPriorityQueue<Integer>(1);
		q.insert(10, 10);
		q.insert(7, 3);
		q.insert(3, 30);
		q.insert(12, 12);
		q.decreasePriority(10,1);
		assertEquals(new Integer(10),q.extractfirst());
		q.decreasePriority(3, 2);
		assertEquals(new Integer(3),q.extractfirst());
		
	}
}

