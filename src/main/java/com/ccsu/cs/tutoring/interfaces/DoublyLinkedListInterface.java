package com.ccsu.cs.tutoring.interfaces;

public interface DoublyLinkedListInterface<T> {
	void insertFirst(T item);
	void insertLast(T item);
	void deleteFirst();
	void deleteLast();
	T first();
	T last();
	int size();
	boolean empty();
	boolean full();
	void traverse();
}
