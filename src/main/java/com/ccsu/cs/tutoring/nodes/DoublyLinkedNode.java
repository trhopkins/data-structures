package com.ccsu.cs.tutoring.nodes;

/**
 * Doubly Linked Node ADT using integers.
 * @author Travis Hopkins
 * @version 1.0.0
 */
public class DoublyLinkedNode<T> {
	private T data;
	private DoublyLinkedNode<T> next, prev;

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

	/**
	 * Access data associated with this Node.
	 * @return the data stored in this Node
	 */
	public T getData() {
		return data;
	}

	/**
	 * Access the following Node
	 * @return the Node following this Node
	 */
	public DoublyLinkedNode<T> getNext() {
		return next;
	}

	/**
	 * Access the preceding Node
	 * @return the Node preceding this Node
	 */
	public DoublyLinkedNode<T> getPrev() {
		return prev;
	}

	/**
	 * Change the data in this this Node.
	 * @param data to store
	 */
	public void setData(T data) {
		this.data = data;
	}

	/**
	 * Change the Node following this Node.
	 * @param next Node to follow this one
	 */
	public void setNext(DoublyLinkedNode<T> next) {
		this.next = next;
	}

	/**
	 * Change the Node preceding this Node.
	 * @param prev Node to precede this one
	 */
	public void setPrev(DoublyLinkedNode<T> prev) {
		this.prev = prev;
	}

	/**
	 * @return String representation of the data stored in this Node
	 */
	public String toString() {
		return String.valueOf(data);
	}
}
