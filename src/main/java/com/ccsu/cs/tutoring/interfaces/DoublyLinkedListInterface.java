package com.ccsu.cs.tutoring.interfaces;

public interface DoublyLinkedListInterface {
	void insertFirst(int item);
	void insertLast(int item);
	void deleteFirst();
	void deleteLast();
	int first();
	int last();
	int size();
	boolean empty();
	boolean full();
	void traverse();
}
