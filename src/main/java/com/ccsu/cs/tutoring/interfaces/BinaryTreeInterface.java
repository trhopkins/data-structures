package com.ccsu.cs.tutoring.interfaces;

import java.lang.Comparable; // not certain if necessary

public interface BinaryTreeInterface<T extends Comparable<T>> {
	void insert(T data);
	void delete(T data);
	boolean search(T key);
	int size();
	boolean empty();
	boolean full();
	void traverse();
}
