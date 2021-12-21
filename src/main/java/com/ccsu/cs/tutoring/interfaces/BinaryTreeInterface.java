package com.ccsu.cs.tutoring.interfaces;

public interface BinaryTreeInterface {
	void insert(int data);
	void delete(int data);
	boolean search(int key);
	int size();
	boolean empty();
	boolean full();
	void traverse();
}
