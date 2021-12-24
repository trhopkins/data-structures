package com.ccsu.cs.tutoring;

import com.ccsu.cs.tutoring.structures.CircularLinkedList;
import org.junit.jupiter.api.Test; // for Test annotations
import org.junit.jupiter.api.Assertions; // for tests themselves

public class CircularLinkedListTest {
	@Test
	void linkedListStartsEmpty() {
		CircularLinkedList<Object> list = new CircularLinkedList<Object>();
		Assertions.assertTrue(list.empty());
	}

	@Test
	void addingFiveElementsMakesSizeFive() {
		CircularLinkedList<Integer> list = new CircularLinkedList<>();
		list.insertFirst(0);
		list.insertFirst(8);
		list.insertFirst(9);
		list.insertFirst(2);
		list.insertFirst(1);
		Assertions.assertEquals(5, list.size());
	}

	@Test
	void deletingElementsReducesSize() {
		CircularLinkedList<Character> list = new CircularLinkedList<>();
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
		CircularLinkedList<Integer> list = new CircularLinkedList<>();
		list.insertFirst(5);
		list.insertFirst(3);
		list.insertFirst(10);
		Assertions.assertEquals(list.toString(), "10\n3\n5\n");
	}

	@Test
	void addingElementsMakesEmptyFalse() {
		CircularLinkedList<Integer> list = new CircularLinkedList<>();
		list.insertFirst(5);
		Assertions.assertFalse(list.empty());
	}

	@Test
	void insertLastmakesElementLast() {
		CircularLinkedList<Character> list = new CircularLinkedList<>();
		list.insertFirst('a'); // a
		list.insertFirst('b'); // b a
		list.insertFirst('c'); // c b a
		list.insertFirst('d'); // d c b a
		list.insertLast('e'); // d c b a e
		Assertions.assertEquals(list.toString(), "d\nc\nb\na\ne\n");
	}
}
