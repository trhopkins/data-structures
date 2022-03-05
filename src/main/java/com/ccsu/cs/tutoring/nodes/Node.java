package com.ccsu.cs.tutoring.nodes;


/**
 * Node ADT containing integer data.
 * @author Travis Hopkins
 * @version 1.0.0
 */
public class Node<T> {
	public T data; // consider Generics here
	public Node<T> next;

	/**
	 * Constructor. Currently not overloaded by anything.
	 * @param data contained in this Node
	 * @param next Node to point to. May be assigned null
	 */
	public Node(T data, Node<T> next) {
		this.data = data;
		this.next = next;
	}

	/**
	 * @return data stored in this Node, type agnostic
	 */
	public String toString() { // O(1)
		return String.valueOf(data);
	}
}
