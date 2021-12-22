package com.ccsu.cs.tutoring.interfaces;

public interface QueueInterface<T> {
	void enqueue(T data);
	T dequeue();
	T front();
	int size();
	boolean empty();
	void traverse();
}
