package com.ccsu.cs.tutoring.structures;

import java.util.ArrayList;

import com.ccsu.cs.tutoring.interfaces.LinkedListInterface;
import com.ccsu.cs.tutoring.nodes.Node;

/**
 * CircularLinkedList ADT using linked integer Nodes.
 * @author Travis Hopkins
 * @version 1.0.0
 * @see {@link https://www.baeldung.com/java-circular-linked-list}
 */
public class CircularLinkedList<T extends Comparable<T>> implements LinkedListInterface<T> {
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
			Node<T> newNode = new Node<>(data, null);
			tail = newNode;
			newNode.setNext(newNode);
		} else {
			Node<T> newNode = new Node<>(data, tail.getNext());
			tail.setNext(newNode);
		}
	}

	/**
	 * Append another item to the CLL.
	 * @param data to add
	 */
	public void insertLast(T data) {
		if (empty()) {
			Node<T> newNode = new Node<>(data, null);
			tail = newNode;
			newNode.setNext(newNode);
		} else {
			Node<T> newNode = new Node<>(data, tail.getNext());
			tail.setNext(newNode);
			tail = newNode;
		}
	}

	/** Remove the first element. 'Cdr' operation. */
	public void deleteFirst() {
		if (!empty()) {
			if (size() == 1) {
				tail = null;
			} else {
				tail.setNext(tail.getNext().getNext());
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
			Node<T> current = tail.getNext();
			do {
				if (current.getData().compareTo(key) == 0) {
					return true;
				}
				current.setNext(current.getNext());
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
				current = current.getNext();
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

	/** Print each item in this CLL. */
	public void traverse() {
		if (!empty()) {
			Node<T> current = tail;
			do {
				current = current.getNext();
				System.out.println(current);
			} while (current != tail);
		}
	}

	/**
	 * Turn data elements from a Linked List to an array for debugging.
	 * @return array of CLL contents
	 */
	@SuppressWarnings("unchecked")
	public T[] getKeys() {
		ArrayList<T> keys = new ArrayList<>();
		Node<T> current = tail.getNext();
		while (current.getNext() != tail) {
			keys.add(current.getData());
			current = current.getNext();
		}
		return (T[]) keys.toArray(); // TODO: Type safety?
	}

	/**
	 * @return String representation of each element.
	 */
	public String toString() {
		String info = "";
		if (!empty()) {
			Node<T> current = tail;
			do {
				current = current.getNext();
				if (current != tail) {
					info += String.valueOf(current) + "\n";
				} else {
					info += String.valueOf(current);
				}
			} while (current != tail);
		} else {
			info += "empty Circular Linked List.";
		}
		return info;
	}
}
