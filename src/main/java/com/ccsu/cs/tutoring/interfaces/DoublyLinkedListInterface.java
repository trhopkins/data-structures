package com.ccsu.cs.tutoring.interfaces;

public interface DoublyLinkedListInterface<T extends Comparable<T>> {
	void insertFirst(T item);
	void insertLast(T item);
	void deleteFirst();
	void deleteLast();
	T first();
	T last();
	boolean search(T key);
	int size();
	boolean empty();
	void traverse();
}
