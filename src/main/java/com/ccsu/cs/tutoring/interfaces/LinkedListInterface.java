package com.ccsu.cs.tutoring.interfaces;

public interface LinkedListInterface<T> {
	void insertFirst(T data);
	void deleteFirst();
	boolean search(T data);
	int size();
	boolean empty();
	boolean full();
	void traverse();
}
