package com.ccsu.cs.tutoring.nodes;

/**
 * Doubly Linked Node ADT using integers.
 * @author Travis Hopkins
 * @version 1.0.0
 */
public class DoublyLinkedNode<T> {
	public T data;
	public DoublyLinkedNode<T> next, prev;

	/**
	 * Constructor of DLNode objects. For empty Nodes, try DLNode(0, null, null).
	 * @param data to store in this Node
	 * @param next Node to precede this Node
	 * @param prev Node to follow this Node
	 */
	public DoublyLinkedNode(T data, DoublyLinkedNode<T> next, DoublyLinkedNode<T> prev) {
		this.data = data;
		this.next = next;
		this.prev = prev;
	}

	/** @return String representation of the data stored in this Node */
	public String toString() {
		return String.valueOf(data);
	}
}
