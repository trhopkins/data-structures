package com.ccsu.cs.tutoring.interfaces;

public interface LinkedListInterface {
	void insertFirst(int data);
	void deleteFirst();
	boolean search(int data);
	int size();
	boolean empty();
	boolean full();
	void traverse();
}
