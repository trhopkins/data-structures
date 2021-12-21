package com.ccsu.cs.tutoring.structures;

import com.ccsu.cs.tutoring.interfaces.QueueInterface;
import com.ccsu.cs.tutoring.nodes.Node;

/**
 * Queue ADT using linked Node. Currently supports integers only.
 * @author Travis Hopkins
 * @version 1.0.0
 * @see {@link https://www.baeldung.com/java-queue}
 */
public class Queue<T> implements QueueInterface<T> {
	private Node<T> front;
	private Node<T> rear;
	private int size; // keeping internal count prevents O(n) size()

	/** Constructor. Starts empty */
	public Queue() {
		size = 0;
		front = rear = null;
	}

	/**
	 * Inserts a Node as the new rear of this Queue.
	 * @param data to add to Queue
	 */
	public void enqueue(T data) { // O(1)
		Node<T> newNode = new Node<T>(data, null);

		if (empty()) {
			front = newNode;
		} else {
			rear.setNext(newNode);
		}
		rear = newNode;
		size++;
	}

	/**
	 * Removes/returns/reassigns the front.
	 * @return front Node's data
	 */
	public T dequeue() { // O(1)
		T frontValue = front.getData();
		front = front.getNext();
		size--; // placed before empty() due to size check
		if (empty()) {
			rear = null;
		}
		return frontValue;
	}

	/**
	 * Like dequeue() but without modifying the Queue.
	 * @return front Node's data
	 */
	public T front() { // O(1)
		return front.getData();
	}

	/**
	 * Node count.
	 * @return the Number of Nodes in the Queue
	 */
	public int size() { // O(1)
		return size;
	}

	/**
	 * Check if this Queue has any Nodes.
	 * @return true if no Nodes
	 */
	public boolean empty() { // O(1)
		return size == 0; // front == null also works
	}

	/**
	 * Check if this Queue can still add more Nodes.
	 * @return true if cannot accept more Nodes
	 */
	public boolean full() {
		return size >= Integer.MAX_VALUE;
	}

	/** Prints each Node on its own line. */
	public void traverse() { // O(n)
		Node<T> current = front;
		while (current != null) {
			System.out.println(current);
			current = current.getNext();
		}
	}

	/**
	 * @return info about each Node on its own line.
	 */
	public String toString() { // O(n)
		Node<T> current = front;
		String info = "";
		while (current != null) {
			info += current.toString() + "\n";
			current = current.getNext();
		}
		return info;
	}
}
