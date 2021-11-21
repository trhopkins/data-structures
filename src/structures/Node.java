package structures;

import interfaces.NodeInterface;

/**
 * Node ADT containing integer data.
 * @author Travis Hopkins
 * @version 1.0.0
 */
public class Node implements NodeInterface {
	int data; // consider Generics here
	Node next;

	/**
	 * Constructor. Currently not overloaded by anything.
	 * @param data contained in this Node
	 * @param next Node to point to. May be assigned null
	 */
	public Node(int data, Node next) {
		this.data = data;
		this.next = next;
	}

	/**
	 * @return Node data
	 */
	public int getData() { // O(1)
		return data;
	}

	/**
	 * @return following Node
	 */
	public Node getNext() { // O(1)
		return next;
	}

	/**
	 * @param data to assign this Node
	 */
	public void setData(int data) { // O(1)
		this.data = data;
	}

	/**
	 * @param next Node to point to
	 */
	public void setNext(Node next) { // O(1)
		this.next = next;
	}

	/**
	 * @return data stored in this Node, type agnostic
	 */
	public String toString() { // O(1)
		return String.valueOf(data);
	}
}
