package com.ccsu.cs.tutoring.interfaces;

public interface StackInterface<T> {
	void push(T data);
	T pop();
	T ontop();
	int size();
	boolean empty();
	boolean full();
	void traverse();
}
