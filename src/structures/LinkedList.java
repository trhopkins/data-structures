package structures;

import interfaces.LinkedListInterface;

public class LinkedList implements LinkedListInterface {
	private Node head;

	public LinkedList() {
		head = null;
	}

	public void insert(int data) {
		head = new Node(data, head);
	}

	public void delete(int data) {
		Node current = head;
		Node previous = null;
		while (current != null && current.getData() != data) {
			previous = current;
			current = current.getNext();
		}
		previous.setNext(current.getNext());
	}

	public boolean search(int data) {
		Node current = head;
		while (current != null) {
			if (current.getData() == data) {
				return true;
			} else {
				current = current.getNext();
			}
		}
		return false;
	}

	public int[] getKeys() {
		int[] keys = new int[this.size()];
		Node current = head;
		for (int i=0; i<keys.length; i++) {
			keys[i] = current.getData();
			current = current.getNext();
		}
		return keys;
	}

	public int size() {
		int size = 0;
		Node current = head;
		while (current != null) {
			current = current.getNext();
			size++;
		}
		return size;
	}

	public boolean empty() {
		return head == null;
	}

	public void traverse() {
		Node current = head;
		while (current != null) {
			System.out.println(current);
			current = current.getNext();
		}
	}
}
