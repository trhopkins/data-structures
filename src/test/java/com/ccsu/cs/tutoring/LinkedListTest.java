package com.ccsu.cs.tutoring;

import com.ccsu.cs.tutoring.structures.LinkedList;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LinkedListTest {
	@Test
	void linkedListStartsEmpty() {
		LinkedList<Integer> numbers = new LinkedList<Integer>();
		assertTrue(numbers.empty());
	}

	@Test
	void addingFiveElementsMakesSizeFive() {
		LinkedList<Integer> numbers = new LinkedList<Integer>();
		numbers.insertFirst(0);
		numbers.insertFirst(8);
		numbers.insertFirst(9);
		numbers.insertFirst(2);
		numbers.insertFirst(1);
		assertEquals(numbers.size(), 5);
	}

	@Test
	void deletingElementsReducesSize() {
		LinkedList<Integer> numbers = new LinkedList<Integer>();
		int oldSize, newSize;
		numbers.insertFirst(0);
		numbers.insertFirst(8);
		numbers.insertFirst(9);
		numbers.insertFirst(2);
		numbers.insertFirst(1);
		oldSize = numbers.size();
		numbers.deleteFirst();
		newSize = numbers.size();
		assertTrue(oldSize > newSize);
	}
}
