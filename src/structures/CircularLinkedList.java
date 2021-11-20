package structures;

import interfaces.LinkedListInterface;

public class CircularLinkedList implements LinkedListInterface {
	private Node tail;

	public CircularLinkedList() {
		tail = null;
	}

	public void insert(int data) {
		if (empty()) {
			Node newNode = new Node(data, null);
			tail = newNode;
			newNode.setNext(newNode);
		} else {
			Node newNode = new Node(data, tail.getNext());
			tail.setNext(newNode);
		}
	}

	public void delete(int key) {
		;
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

	public int[] getKeys() {
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

	public void traverse() {
		if (!empty()) {
			Node current = tail;
			do {
				current = current.getNext();
				System.out.println(current);
			} while (current != tail);
		}
	}

	public String toString() {
		String info = "";
		if (!empty()) {
			Node current = tail;
			do {
				current = current.getNext();
				info += String.valueOf(current) + "\n";
			} while (current != tail);
		} else {
			info += "empty Circular Linked List.";
		}
		return info;
	}
}
