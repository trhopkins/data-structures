package com.ccsu.cs.tutoring;

import com.ccsu.cs.tutoring.structures.LinkedList;
import org.junit.jupiter.api.Test; // for Test annotations
import org.junit.jupiter.api.Assertions; // for tests themselves

public class LinkedListTest {
	@Test
	void linkedListStartsEmpty() {
		LinkedList<Object> list = new LinkedList<Object>();
		Assertions.assertTrue(list.empty());
	}

	@Test
	void addingFiveElementsMakesSizeFive() {
		LinkedList<Integer> list = new LinkedList<>();
		list.insertFirst(0);
		list.insertFirst(8);
		list.insertFirst(9);
		list.insertFirst(2);
		list.insertFirst(1);
		Assertions.assertEquals(5, list.size());
	}

	@Test
	void deletingElementsReducesSize() {
		LinkedList<Character> list = new LinkedList<>();
		int oldSize, newSize;
		list.insertFirst('a');
		list.insertFirst('b');
		list.insertFirst('c');
		list.insertFirst('d');
		list.insertFirst('e');
		oldSize = list.size();
		list.deleteFirst();
		newSize = list.size();
		Assertions.assertTrue(oldSize > newSize);
	}

	@Test
	void toStringWorksForIntegers() {
		LinkedList<Integer> list = new LinkedList<>();
		list.insertFirst(5);
		list.insertFirst(3);
		list.insertFirst(10);
		Assertions.assertEquals(list.toString(), "10\n3\n5\n");
	}

	@Test
	void addingElementsMakesEmptyFalse() {
		LinkedList<Integer> list = new LinkedList<>();
		list.insertFirst(5);
		Assertions.assertFalse(list.empty());
	}
}
