package com.ccsu.cs.tutoring.interfaces;

public interface QueueInterface {
	void enqueue(int data);
	int dequeue();
	int front();
	int size();
	boolean empty();
	boolean full();
	void traverse();
}
