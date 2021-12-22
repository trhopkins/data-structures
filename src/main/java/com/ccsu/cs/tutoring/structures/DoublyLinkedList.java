package com.ccsu.cs.tutoring.structures;

import com.ccsu.cs.tutoring.interfaces.DoublyLinkedListInterface;
import com.ccsu.cs.tutoring.nodes.DoublyLinkedNode;

/**
 * Doubly Linked List ADT using Doubly Linked integer Nodes.
 * @author Travis Hopkins
 * @author Roland Van Duine
 * @version 1.0.1
 * @see {@link https://www.baeldung.com/cs/linked-list-data-structure}
 */
public class DoublyLinkedList<T extends Comparable<T>> implements DoublyLinkedListInterface<T> {
	private DoublyLinkedNode<T> head, tail;
	private int size;

	/**
	 * DoublyLinkedList Constructor. Starts empty. Size = 0.
	 */
	public DoublyLinkedList() {
		head = new DoublyLinkedNode<>(null, tail, null);
		tail = new DoublyLinkedNode<>(null, null, head);
		size = 0;
	}

	/**
	 * Checks if this DoublyLinkedList contains any Nodes.
	 * @return false if size is zero
	 */
	public boolean empty() { // O(1)
		return size == 0;
	}

	/**
	 * @return size the DoublyLinkedList
	 */
	public int size() { // 0(1)
		return size;
	}

	/**
	 * Adds a new Node to the front of the list.
	 * Updates the next node's previous node
	 * @param data to add, replacing previous head
	 */
	public void insertFirst(T data) { // O(1)
		DoublyLinkedNode<T> oldFirst = head.getNext();
		DoublyLinkedNode<T> newFirst = new DoublyLinkedNode<>(data, oldFirst, head);
		oldFirst.setPrev(newFirst);
		head.setNext(newFirst);
		size++;
	}
	/**
	 * Adds a new Node to the end of the list.
	 * Updates the previous node's next node
	 * @param data to add, replacing previous tail
	 */
	public void insertLast(T data) { // 0(1)
		DoublyLinkedNode<T> oldLast = tail.getPrev();
		DoublyLinkedNode<T> newLast = new DoublyLinkedNode<>(data, tail, oldLast);
		oldLast.setNext(newLast);
		tail.setPrev(newLast);
		size++;
	}

	/**
	 * Removes/reassigns head Node.
	 * Decrements size
	 * Updates the next node's previous node
	 */
	public void deleteFirst() { // O(1)
		DoublyLinkedNode<T> oldFirst = head.getNext();
		DoublyLinkedNode<T> newFirst = oldFirst.getNext();
		newFirst.setPrev(head);
		head.setNext(newFirst);
		size--;
	}

	/**
	 * Removes/reassigns tail Node.
	 * Decrements size
	 * Updates the previous node's next node
	 */
	public void deleteLast() { // O(1)
		DoublyLinkedNode<T> oldLast = tail.getPrev();
		DoublyLinkedNode<T> newLast = oldLast.getPrev();
		tail.setPrev(newLast);
		newLast.setNext(tail);
		size--;
	}

	/**
	 * Return int of first node
	 * @return int the first node
	 */
	public T first() { // O(1)
		if(head == null) {
			//System.out.println("Trying to access empty node");
			return null;
		}
		return head.getNext().getData();
	}

	/**
	 * Return int of last node
	 * @return int the last node
	 */
	public T last() { // O(1)
		if(tail==null) {
			//System.out.println("Trying to access empty node");
			return null;
		}
		return tail.getPrev().getData();
	}

	/**
	 * Returns true if this data exists in this DoublyLinkedList.
	 * @param key data to find
	 * @return true if key data is found
	 */
	public boolean search(T key) { // 0(n)
		DoublyLinkedNode<T> current = head.getNext();
		while (current != tail) {
			if (current.getData().compareTo(key) == 0) {
				return true;
			} else {
				current = current.getNext();
			}
		}
		return false;
	}

	/**
	 * Prints each Node on its own line. Similar to toString().
	 */
	public void traverse() { // O(n)
		DoublyLinkedNode<T> current = head.getNext();
		while (current != tail) {
			System.out.println(current);
			current = current.getNext();
		}
	}

	/**
	 * @return info about each Node on its own line.
	 */
	public String toString() { // O(n)
		DoublyLinkedNode<T> current = head.getNext();
		String info = "";
		while (current != tail) {
			info += current.toString() + "\n";
			current = current.getNext();
		}
		return info;
	}
}
