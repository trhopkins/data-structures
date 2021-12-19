package structures;

import interfaces.DoublyLinkedListInterface;
import nodes.DoublyLinkedNode;

/**
 * Doubly Linked List ADT using Doubly Linked integer Nodes.
 * @author Travis Hopkins
 * @version 1.0.0
 * @see {@link https://www.baeldung.com/cs/linked-list-data-structure}
 */
public class DoublyLinkedList implements DoublyLinkedListInterface {
	private DoublyLinkedNode head;
	private DoublyLinkedNode tail;
	private int size;

	/** Empty DLL constructor. */
	public DoublyLinkedList() {
		head = new DoublyLinkedNode(0, tail, null);
		tail = new DoublyLinkedNode(0, null, head);
		size = 0;
	}

	/**
	 * Check if zero items to operate on. Certain operations fail when
	 * DLL is empty.
	 * @return true if no Nodes are present.
	 */
	public boolean empty() {
		return size == 0;
	}

	/**
	 * Count the elements in this DLL.
	 * @return number of Nodes in this DLL.
	 */
	public int size() {
		return size;
	}

	/**
	 * Add another DLNode before your 'first' item.
	 * @param data to cons onto the DLL.
	 */
	public void insertFirst(int data) {
		DoublyLinkedNode oldFirst = head.getNext();
		DoublyLinkedNode newFirst = new DoublyLinkedNode(data, oldFirst, head);
		oldFirst.setPrev(newFirst);
		head.setNext(newFirst);
		size++;
	}

	/**
	 * Add another DLNode after your 'last' item.
	 * @param data to append onto the DLL.
	 */
	public void insertLast(int data) {
		DoublyLinkedNode oldLast = tail.getPrev();
		DoublyLinkedNode newLast = new DoublyLinkedNode(data, tail, oldLast);
		oldLast.setNext(newLast);
		tail.setPrev(newLast);
		size++;
	}

	/** Remove the first element of the DLL. */
	public void deleteFirst() {
		DoublyLinkedNode oldFirst = head.getNext();
		DoublyLinkedNode newFirst = oldFirst.getNext();
		newFirst.setPrev(head);
		head.setNext(newFirst);
		size--;
	}

	/** Remove the last element of the DLL. */
	public void deleteLast() {
		DoublyLinkedNode oldLast = tail.getPrev();
		DoublyLinkedNode newLast = oldLast.getPrev();
		tail.setPrev(newLast);
		newLast.setNext(tail);
		size--;
	}

	/** Return the last element of the DLL. */
	public int first() {
		return head.getNext().getData();
	}

	/** Return the last element of the DLL. */
	public int last() {
		return tail.getPrev().getData();
	}

	/** Check if an item exists in this Node.
	 * @param key to search for
	 * @return true if exists, false otherwise
	*/
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

	/** Print all DLNodes. */
	public void traverse() {
		DoublyLinkedNode current = head.getNext();
		while (current != tail) {
			System.out.println(current);
			current = current.getNext();
		}
	}

	/**
	 * @return String containing all toStrings of elements
	 */
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
