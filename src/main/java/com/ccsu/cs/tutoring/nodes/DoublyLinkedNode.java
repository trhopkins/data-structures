package com.ccsu.cs.tutoring.nodes;

/**
 * Doubly Linked Node ADT using integers.
 * @author Travis Hopkins
 * @version 1.0.0
 */
public class DoublyLinkedNode<T extends Comparable<T>> {
	private T data;
	private DoublyLinkedNode<T> next, prev;

	public DoublyLinkedNode(T data, DoublyLinkedNode<T> next, DoublyLinkedNode<T> prev) {
		this.data = data;
		this.next = next;
		this.prev = prev;
	}

	public void setData(T data) {
		this.data = data;
	}

	public void setNext(DoublyLinkedNode<T> next) {
		this.next = next;
	}

	public void setPrev(DoublyLinkedNode<T> prev) {
		this.prev = prev;
	}

	public T getData() {
		return data;
	}

	public DoublyLinkedNode<T> getNext() {
		return next;
	}

	public DoublyLinkedNode<T> getPrev() {
		return prev;
	}

	public String toString() {
		return String.valueOf(data);
	}
}
