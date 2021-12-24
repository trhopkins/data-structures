package com.ccsu.cs.tutoring;

import com.ccsu.cs.tutoring.structures.DoublyLinkedList;
import org.junit.jupiter.api.Test; // for Test annotations
import org.junit.jupiter.api.Assertions; // for tests themselves

public class DoublyLinkedListTest {
	@Test
	void linkedListStartsEmpty() {
		DoublyLinkedList<Object> list = new DoublyLinkedList<Object>();
		Assertions.assertTrue(list.empty());
	}

	@Test
	void addingFiveElementsMakesSizeFive() {
		DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
		list.insertFirst(0);
		list.insertFirst(8);
		list.insertFirst(9);
		list.insertFirst(2);
		list.insertFirst(1);
		Assertions.assertEquals(5, list.size());
	}

	@Test
	void deletingElementsReducesSize() {
		DoublyLinkedList<Character> list = new DoublyLinkedList<>();
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
		DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
		list.insertFirst(5);
		list.insertFirst(3);
		list.insertFirst(10);
		Assertions.assertEquals(list.toString(), "10\n3\n5\n");
	}

	@Test
	void addingElementsMakesEmptyFalse() {
		DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
		list.insertFirst(5);
		Assertions.assertFalse(list.empty());
	}

	@Test
	void insertLastmakesElementLast() {
		DoublyLinkedList<Character> list = new DoublyLinkedList<>();
		list.insertFirst('a'); // a
		list.insertFirst('b'); // b a
		list.insertFirst('c'); // c b a
		list.insertFirst('d'); // d c b a
		list.insertLast('e');  // d c b a e
		Assertions.assertEquals(list.toString(), "d\nc\nb\na\ne\n");
	}

	@Test
	void deletingFirstPreservesOrder() {
		DoublyLinkedList<Character> list = new DoublyLinkedList<>();
		list.insertFirst('a'); // a
		list.insertFirst('b'); // b a
		list.insertFirst('c'); // c b a
		list.deleteFirst(); // b a
		list.insertFirst('d'); // d b a
		Assertions.assertEquals(list.toString(), "d\nb\na\n");
	}

	@Test
	void deletingLastPreservesOrder() {
		DoublyLinkedList<Character> list = new DoublyLinkedList<>();
		list.insertLast('a'); // a
		list.insertLast('b'); // a b
		list.insertLast('c'); // a b c
		list.deleteLast(); // a b
		list.insertLast('d'); // a b d
		Assertions.assertEquals(list.toString(), "a\nb\nd\n");
	}
}
