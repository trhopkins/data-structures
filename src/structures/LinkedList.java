package structures;

import interfaces.LinkedListInterface;

/**
 * LinkedList ADT using integer Nodes.
 * @author Travis Hopkins
 * @version 0.0.1
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
	public void insert(int data) {
		head = new Node(data, head);
	}

	/**
	 * Removes Node wih data matching a given key.
	 * @param key Node data to search for and remove if found
	 */
	public void delete(int key) {
		Node current = head;
		Node previous = null;
		while (current != null && current.getData() != key) {
			previous = current;
			current = current.getNext();
		}
		previous.setNext(current.getNext()); // garbage collected later
	}

	/**
	 * Returns true if this data exists in this LinkedList.
	 * @param key data to find
	 * @return true if key data is found
	 */
	public boolean search(int key) {
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
	 * Transforms this LinkedList into an array.
	 * @return array of data corresponding to this LinkedList
	 */
	public int[] getKeys() {
		int[] keys = new int[this.size()];
		Node current = head;
		for (int i=0; i<keys.length; i++) {
			keys[i] = current.getData();
			current = current.getNext();
		}
		return keys;
	}

	/**
	 * Counts the Nodes in this LinkedList.
	 * @implNote O(n) due to manual size calculation instead of storing as an instance attribute
	 * @return number of Nodes in this LinkedList
	 */
	public int size() {
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
	public boolean empty() {
		return head == null; // this.size() == 0 is O(n)
	}

	/**
	 * Prints each Node on its own line. Similar to toString().
	 */
	public void traverse() {
		Node current = head;
		while (current != null) {
			System.out.println(current);
			current = current.getNext();
		}
	}

	/**
	 * @return info about each Node on its own line.
	 */
	public String toString() {
		Node current = head;
		String info = "";
		while (current != null) {
			info += current.toString() + "\n";
			current = current.getNext();
		}
		return info;
	}
}
