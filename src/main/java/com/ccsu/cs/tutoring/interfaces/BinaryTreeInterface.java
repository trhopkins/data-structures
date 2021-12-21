package com.ccsu.cs.tutoring.interfaces;

public interface BinaryTreeInterface {
	void insert(int data);
	void delete(int data);
	boolean empty();
	int size();
	boolean search(int key);
	void traverse();
}
