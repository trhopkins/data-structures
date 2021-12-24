package com.ccsu.cs.tutoring;

import com.ccsu.cs.tutoring.structures.Queue;
import org.junit.jupiter.api.Test; // for Test annotations
import org.junit.jupiter.api.Assertions; // for tests themselves

public class QueueTest {
	@Test
	void queueStartsEmpty() {
		Queue<Integer> numbers = new Queue<>();
		Assertions.assertTrue(numbers.empty());
	}

	@Test
	void addingFiveElementsMakesSizeFive() {
		Queue<String> queue = new Queue<>();
		queue.enqueue("data"); // 1
		queue.enqueue("data"); // 2
		queue.enqueue("data"); // 3
		queue.enqueue("data"); // 4
		queue.enqueue("data"); // 5
		Assertions.assertEquals(5, queue.size());
	}

	@Test
	void deletingElementsReducesSize() {
		Queue<Character> queue = new Queue<>();
		int oldSize, newSize;
		queue.enqueue('a');
		queue.enqueue('b');
		queue.enqueue('c');
		queue.enqueue('d');
		queue.enqueue('e');
		oldSize = queue.size();
		queue.dequeue(); // should return 'a' due to FIFO order
		newSize = queue.size();
		Assertions.assertTrue(oldSize > newSize);
	}

	@Test
	void toStringWorksForIntegers() {
		Queue<Integer> queue = new Queue<>();
		queue.enqueue(5);
		queue.enqueue(3);
		queue.enqueue(10);
		Assertions.assertEquals(queue.toString(), "5\n3\n10\n");
	}

	@Test
	void addingElementsMakesEmptyFalse() {
		Queue<Integer> queue = new Queue<>();
		queue.enqueue(5);
		Assertions.assertFalse(queue.empty());
	}
}
