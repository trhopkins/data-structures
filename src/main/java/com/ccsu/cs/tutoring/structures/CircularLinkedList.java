package com.ccsu.cs.tutoring.structures;

import com.ccsu.cs.tutoring.interfaces.LinkedListInterface;
import com.ccsu.cs.tutoring.nodes.Node;

/**
 * CircularLinkedList ADT using linked integer Nodes.
 * @author Travis Hopkins
 * @version 1.0.1
 * @see <a href="https://www.baeldung.com/java-circular-linked-list">Circular Linked List ADT tutorial</a>
 */
public class CircularLinkedList<T> implements LinkedListInterface<T> {
	private Node<T> tail;

	/**
	 * Empty CLL constructor.
	 */
	public CircularLinkedList() {
		tail = null;
	}

	/**
	 * Add another element to the CLL.
	 * @param data to add the the CLL
	 */
	public void insertFirst(T data) {
		if (empty()) {
			Node<T> newNode = new Node<T>(data, null);
			tail = newNode;
			newNode.next = newNode;
		} else if (!full()) {
			Node<T> newNode = new Node<T>(data, tail.next);
			tail.next = newNode;
		} // else throw error for being too large?
	}

	/**
	 * Append another item to the CLL.
	 * @param data to add
	 */
	public void insertLast(T data) {
		if (empty()) {
			Node<T> newNode = new Node<T>(data, null);
			tail = newNode;
			newNode.next = newNode;
		} else {
			Node<T> newNode = new Node<T>(data, tail.next);
			tail.next = newNode;
			tail = newNode;
		}
	}

	/** Remove the first element. 'Cdr' operation. */
	public void deleteFirst() {
		if (!empty()) {
			if (size() == 1) {
				tail = null;
			} else {
				tail.next = tail.next.next;
			}
		}
	}

	/**
	 * Iterate through each element to see if key is in CLL.
	 * @param key to search for
	 * @return true if item is found in CLL.
	 */
	public boolean search(T key) {
		if (tail == null) {
			return false;
		} else {
			Node<T> current = tail.next;
			do {
				if (current.data == key) {
					return true;
				}
				current.next = current.next;
			} while (current != tail);
			return false;
		}
	}

	/**
	 * Return the number of Nodes in this CLL.
	 * @return number of elements in CLL
	 */
	public int size() {
		if (tail == null) {
			return 0;
		} else {
			Node<T> current = tail;
			int size = 0;
			do {
				current = current.next;
				size++;
			} while (current != tail);
			return size;
		}
	}

	/**
	 * Check if there are any elements in this CLL.
	 * @return true if there are no elements
	 */
	public boolean empty() {
		return tail == null;
	}

	/**
	 * Check if this CLL is too large to accept more Nodes.
	 * @return false if can accept more Nodes
	 */
	public boolean full() {
		return size() >= Integer.MAX_VALUE;
	}

	/** Print each item in this CLL. */
	public void traverse() {
		System.out.print(this);
	}

	/**
	 * @return String representation of each element.
	 */
	public String toString() {
		String info = "";
		if (!empty()) {
			Node<T> current = tail;
			do {
				current = current.next;
				info += String.valueOf(current) + "\n";
			} while (current != tail);
		} else {
			info += "empty Circular Linked List.";
		}
		return info;
	}
}
