package com.ccsu.cs.tutoring.structures;

import com.ccsu.cs.tutoring.interfaces.LinkedListInterface;
import com.ccsu.cs.tutoring.nodes.Node;

/**
 * LinkedList ADT using integer Nodes.
 * @author Travis Hopkins
 * @version 1.0.0
 * @see {@link https://www.baeldung.com/java-linkedlist}
 */
public class LinkedList<T> implements LinkedListInterface<T> {
	// car = head, cdr = head.getNext() for you LISPers out there ;)
	private Node<T> head;

	/** Empty LinkedList Constructor. */
	public LinkedList() {
		head = null;
	}

	/**
	 * Adds a new Node to the front of the list. 'Cons' operation. 
	 * @param data to add, replacing previous head
	 */
	public void insertFirst(T data) { // O(1)
		if (!full()) {
			head = new Node<T>(data, head);
		} // else: throw error for being too large?
	}

	/** Removes/reassigns head Node. */
	public void deleteFirst() { // O(1)
		if (!empty()) {
			head = head.getNext();
		}
	}

	/**
	 * Returns true if this data exists in this LinkedList.
	 * @param key data to find
	 * @return true if key data is found
	 */
	public boolean search(T key) { // O(n)
		Node<T> current = head;
		while (current != null) {
			if (current.getData() == key) {
				return true;
			} else {
				current = current.getNext();
			}
		}
		return false; // reached end of LinkedList
	}

	/**
	 * Counts the Nodes in this LinkedList.
	 * @return number of Nodes in this LinkedList
	 */
	public int size() { // O(n) since size is not stored locally
		int size = 0;
		Node<T> current = head;
		while (current != null) {
			current = current.getNext();
			size++;
		}
		return size;
	}

	/**
	 * Checks if this LinkedList contains any Nodes.
	 * @return false if size is zero
	 */
	public boolean empty() { // O(1)
		return head == null; // this.size() == 0 is O(n)
	}

	/**
	 * Checks if this LL is full and cannot accept more Nodes.
	 * @return false if has space to store more Nodes
	 */
	public boolean full() {
		return size() >= Integer.MAX_VALUE;
	}

	/** Prints each Node on its own line. Similar to toString(). */
	public void traverse() {
		System.out.print(this);
	}

	/** @return info about each Node on its own line. */
	public String toString() { // O(n)
		Node<T> current = head;
		String info = "";
		while (current != null) {
			info += current.toString() + "\n";
			current = current.getNext();
		}
		return info;
	}
}
