package structures;

import interfaces.LinkedListInterface;
import nodes.Node;

/**
 * LinkedList ADT using integer Nodes.
 * @author Travis Hopkins
 * @version 1.0.0
 * @see {@link https://www.baeldung.com/java-linkedlist}
 */
public class LinkedList implements LinkedListInterface {
	// car = head, cdr = head.getNext() for you LISPers out there
	private Node head;

	/**
	 * LinkedList Constructor. Starts empty.
	 */
	public LinkedList() {
		head = null;
	}

	/**
	 * 'cons' operation. Adds a new Node to the front of the list.
	 * @param data to add, replacing previous head
	 */
	public void insertFirst(int data) { // O(1)
		head = new Node(data, head);
	}

	/**
	 * Removes/reassigns head Node.
	 */
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
	public boolean search(int key) { // O(n)
		Node current = head;
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
		Node current = head;
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
	 * Prints each Node on its own line. Similar to toString().
	 */
	public void traverse() { // O(n)
		Node current = head;
		while (current != null) {
			System.out.println(current);
			current = current.getNext();
		}
	}

	/**
	 * Transforms this LinkedList into an array.
	 * @return array of data corresponding to this LinkedList
	 */
  public int[] getKeys() { // for debugging
		int[] keys = new int[size()];
		Node current = head;
		for (int index=0; index<keys.length; index++) {
			keys[index] = current.getData();
			current = current.getNext();
		}
		return keys;
	}

	/**
	 * @return info about each Node on its own line.
	 */
	public String toString() { // O(n)
		Node current = head;
		String info = "";
		while (current != null) {
			info += current.toString() + "\n";
			current = current.getNext();
		}
		return info;
	}
}
