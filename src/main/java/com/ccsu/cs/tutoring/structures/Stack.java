package com.ccsu.cs.tutoring.structures;

import com.ccsu.cs.tutoring.interfaces.StackInterface;
import com.ccsu.cs.tutoring.nodes.Node;

/**
 * Stack ADT using linked integer Nodes.
 * @author Travis Hopkins
 * @version 1.0.0
 * @see {@link https://www.baeldung.com/java-stack}
 */
public class Stack<T> implements StackInterface<T> {
	private Node<T> top; // reference to only accessible value
	private int size; // prevents O(n) size() operation

	/**
	 * Constructor. Starts empty.
	 */
	public Stack() {
		top = null;
		size = 0;
	}

	/**
	 * Add a new Node to the top of the Stack, covering Nodes below.
	 * @param data to add
	 */
	public void push(T data) { // O(1)
		top = new Node<T>(data, top);
		size++;
	}

	/**
	 * Removes/returns the top Node's value.
	 * @return data of top
	 */
	public T pop() { // O(1)
		T topValue = top.getData();
		top = top.getNext();
		size--; // consider throwing an error for an empty stack?
		return topValue;
	}

	/**
	 * Like pop(), but doesn't remove the top Node.
	 * @return data of top
	 */
	public T ontop() { // O(1)
		return top.getData();
	}

	/**
	 * Count of Nodes.
	 * @return size
	 */
	public int size() { // O(1)
		return size;
	}

	/**
	 * Check if the Stack has any Nodes.
	 * @return true if empty
	 */
	public boolean empty() { // O(1)
		return top == null; // size == 0 also works
	}

	/**
	 * Check if this Stack can still push more Nodes on.
	 * @return true if cannot accept more Nodes due to size
	 */
	public boolean full() {
		return size >= Integer.MAX_VALUE;
	}

	/** Prints each Node on its own line. */
	public void traverse() {
		System.out.println(this);
	}

	/** @return each Node's information on its own line */
	public String toString() { // O(n)
		Stack<T> tmp = new Stack<T>();
		String info = "";
		while (!empty()) {
			info += top.toString() + "\n";
			tmp.push(this.pop());
		}
		while (!tmp.empty()) {
			this.push(tmp.pop());
		}
		return info;
	}
}
