package structures;

import interfaces.LinkedListInterface;

/**
 * CircularLinkedList ADT using linked integer Nodes.
 * @author Travis Hopkins
 * @version 1.0.0
 * @see {@link https://www.baeldung.com/java-circular-linked-list}
 */
public class CircularLinkedList implements LinkedListInterface {
	private Node tail;

	public CircularLinkedList() {
		tail = null;
	}

	public void insertFirst(int data) {
		if (empty()) {
			Node newNode = new Node(data, null);
			tail = newNode;
			newNode.setNext(newNode);
		} else {
			Node newNode = new Node(data, tail.getNext());
			tail.setNext(newNode);
		}
	}

	public void insertLast(int data) {
		if (empty()) {
			Node newNode = new Node(data, null);
			tail = newNode;
			newNode.setNext(newNode);
		} else {
			Node newNode = new Node(data, tail.getNext());
			tail.setNext(newNode);
			tail = newNode;
		}
	}

	public void deleteFirst() {
		if (!empty()) {
			if (size() == 1) {
				tail = null;
			} else {
				tail.setNext(tail.getNext().getNext());
			}
		}
	}

	public boolean search(int key) {
		if (tail == null) {
			return false;
		} else {
			Node current = tail.getNext();
			do {
				if (current.getData() == key) {
					return true;
				}
				current.setNext(current.getNext());
			} while (current != tail);
			return false;
		}
	}

	public int size() {
		if (tail == null) {
			return 0;
		} else {
			Node current = tail;
			int size = 0;
			do {
				current = current.getNext();
				size++;
			} while (current != tail);
			return size;
		}
	}

	public boolean empty() {
		return tail == null;
	}

	public void traverse() {
		if (!empty()) {
			Node current = tail;
			do {
				current = current.getNext();
				System.out.println(current);
			} while (current != tail);
		}
	}

	public int[] getKeys() { // for debugging
		int[] keys = new int[size()];
		if (!empty()) {
			Node current = tail;
			int index = 0;
			do {
				current = current.getNext();
				keys[index] = current.getData();
				index++;
			} while (current != tail);
		}
		return keys;
	}

	public String toString() {
		String info = "";
		if (!empty()) {
			Node current = tail;
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
