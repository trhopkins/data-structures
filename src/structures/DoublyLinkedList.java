package structures;

import interfaces.DoublyLinkedListInterface;

public class DoublyLinkedList implements DoublyLinkedListInterface {
	private DoublyLinkedNode head;
	private DoublyLinkedNode tail;
	private int size;

	public DoublyLinkedList() {
		head = new DoublyLinkedNode(0, tail, null);
		tail = new DoublyLinkedNode(0, null, head);
		size = 0;
	}

	public boolean empty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public void insertFirst(int data) {
		DoublyLinkedNode oldFirst = head.getNext();
		DoublyLinkedNode newFirst = new DoublyLinkedNode(data, oldFirst, head);
		oldFirst.setPrev(newFirst);
		head.setNext(newFirst);
		size++;
	}

	public void insertLast(int data) {
		DoublyLinkedNode oldLast = tail.getPrev();
		DoublyLinkedNode newLast = new DoublyLinkedNode(data, tail, oldLast);
		oldLast.setNext(newLast);
		tail.setPrev(newLast);
		size++;
	}

	public DoublyLinkedNode deleteFirst() {
		DoublyLinkedNode oldFirst = head.getNext();
		DoublyLinkedNode newFirst = oldFirst.getNext();
		newFirst.setPrev(head);
		head.setNext(newFirst);
		size--;
		return oldFirst;
	}

	public DoublyLinkedNode deleteLast() {
		DoublyLinkedNode oldLast = tail.getPrev();
		DoublyLinkedNode newLast = oldLast.getPrev();
		tail.setPrev(newLast);
		newLast.setNext(tail);
		size--;
		return oldLast;
	}

	public int first() {
		return head.getNext().getData();
	}

	public int last() {
		return tail.getPrev().getData();
	}

	public boolean search(int key) {
		DoublyLinkedNode current = head.getNext();
		while (current != tail) {
			if (current.getData() == key) {
				return true;
			} else {
				current = current.getNext();
			}
		}
		return false;
	}

	public void traverse() {
		DoublyLinkedNode current = head.getNext();
		while (current != tail) {
			System.out.println(current);
			current = current.getNext();
		}
	}

	public String toString() {
		DoublyLinkedNode current = head.getNext();
		String info = "";
		while (current != tail) {
			info += current.toString() + "\n";
			current = current.getNext();
		}
		return info;
	}
}
