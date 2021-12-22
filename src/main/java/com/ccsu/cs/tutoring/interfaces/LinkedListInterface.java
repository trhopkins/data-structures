package com.ccsu.cs.tutoring.interfaces;

public interface LinkedListInterface<T extends Comparable<T>> {
	void insertFirst(T data);
	void deleteFirst();
	boolean search(T data);
	int size();
	boolean empty();
	void traverse();
}
