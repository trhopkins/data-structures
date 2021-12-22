package com.ccsu.cs.tutoring.interfaces;

public interface BinaryTreeInterface<T extends Comparable<T>> {
	void insert(T data);
	void delete(T data);
	boolean search(T key);
	int size();
	boolean empty();
	void traverse();
}
