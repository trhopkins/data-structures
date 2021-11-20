package structures;

import interfaces.QueueInterface;

/**
 * Queue ADT using linked Node. Currently supports integers only.
 * @author Travis Hopkins
 * @version 0.0.1
 * @see {@link https://www.baeldung.com/java-queue}
 */
public class Queue implements QueueInterface {
	private Node front;
	private Node rear;
	private int size; // keeping internal count prevents O(n) size()

	/**
	 * Constructor. Starts empty.
	 */
	public Queue() {
		size = 0;
		front = rear = null;
	}

	/**
	 * Inserts a Node as the new rear of this Queue.
	 * @param data to add to Queue
	 */
	public void enqueue(int data) { // O(1)
		Node newNode = new Node(data, null);

		if (empty()) {
			front = newNode;
		} else {
			rear.setNext(newNode);
		}
		rear = newNode;
		size++;
	}

	/**
	 * Removes/returns/reassigns the front.
	 * @return front Node's data
	 */
	public int dequeue() { // O(1)
		int frontValue = front.getData();
		front = front.getNext();
		size--; // placed before empty() due to size check
		if (empty()) {
			rear = null;
		}
		return frontValue;
	}

	/**
	 * Like dequeue() but without modifying the Queue.
	 * @return front Node's data
	 */
	public int front() { // O(1)
		return front.getData();
	}

	/**
	 * Node count.
	 * @return the Number of Nodes in the Queue
	 */
	public int size() { // O(1)
		return size;
	}

	/**
	 * Check if this Queue has any Nodes.
	 * @return true if no Nodes
	 */
	public boolean empty() { // O(1)
		return size == 0; // front == null also works
	}

	/**
	 * Prints each Node on their own line. Simiar to toString().
	 */
	public void traverse() { // O(n)
		Node current = front;
		while (current != null) {
			System.out.println(current);
			current = current.getNext();
		}
	}

	/**
	 * @return info about each Node on its own line.
	 */
	public String toString() { // O(n)
		Node current = front;
		String info = "";
		while (current != null) {
			info += current.toString() + "\n";
			current = current.getNext();
		}
		return info;
	}
}
