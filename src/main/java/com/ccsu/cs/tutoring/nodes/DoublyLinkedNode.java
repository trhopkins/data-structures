package com.ccsu.cs.tutoring.nodes;

/**
 * Doubly Linked Node ADT using integers.
 * @author Travis Hopkins
 * @version 1.0.0
 */
public class DoublyLinkedNode {
	private int data;
	private DoublyLinkedNode next, prev;

	/**
	 * Constructor of DLNode objects. For empty Nodes, try DLNode(0, null, null).
	 * @param data to store in this Node
	 * @param next Node to precede this Node
	 * @param prev Node to follow this Node
	 */
	public DoublyLinkedNode(int data, DoublyLinkedNode next, DoublyLinkedNode prev) {
		this.data = data;
		this.next = next;
		this.prev = prev;
	}

	/**
	 * Access data associated with this Node.
	 * @return the data stored in this Node
	 */
	public int getData() {
		return data;
	}

	/**
	 * Access the following Node
	 * @return the Node following this Node
	 */
	public DoublyLinkedNode getNext() {
		return next;
	}

	/**
	 * Access the preceding Node
	 * @return the Node preceding this Node
	 */
	public DoublyLinkedNode getPrev() {
		return prev;
	}

	/**
	 * Change the data in this this Node.
	 * @param data to store
	 */
	public void setData(int data) {
		this.data = data;
	}

	/**
	 * Change the Node following this Node.
	 * @param next Node to follow this one
	 */
	public void setNext(DoublyLinkedNode next) {
		this.next = next;
	}

	/**
	 * Change the Node preceding this Node.
	 * @param next Node to precede this one
	 */
	public void setPrev(DoublyLinkedNode prev) {
		this.prev = prev;
	}

	/**
	 * @return String representation of the data stored in this Node
	 */
	public String toString() {
		return String.valueOf(data);
	}
}
