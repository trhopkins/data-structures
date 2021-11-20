package structures;

import interfaces.StackInterface;

/**
 * Stack ADT using linked integer Nodes.
 * @author Travis Hopkins
 * @version 0.0.1
 */
public class Stack implements StackInterface {
	private Node top; // reference to only accessible value
	private int size; // prevents O(n) size()

	/**
	 * Constructor. Starts empty.
	 */
	public Stack() {
		top = null;
		size = 0;
	}

	/**
	 * Add a new Node to the top of the Stack, covering Nodes below.
	 * @param data to add
	 */
	public void push(int data) {
		top = new Node(data, top);
		size++;
	}

	/**
	 * Removes/returns the top Node's value.
	 * @return data of top
	 */
	public int pop() {
		int topValue = top.getData();
		top = top.getNext();
		size--; // consider throwing an error for an empty stack?
		return topValue;
	}

	/**
	 * Like pop(), but doesn't remove the top Node.
	 * @return data of top
	 */
	public int ontop() {
		return top.getData();
	}

	/**
	 * Count of Nodes.
	 * @return size
	 */
	public int size() {
		return size;
	}

	/**
	 * Check if the Stack has any Nodes.
	 * @return true if empty
	 */
	public boolean empty() {
		return top == null; // size == 0 also works
	}

	/**
	 * Prints each Node on its own line. Similar to toString().
	 */
	public void traverse() {
		Stack tmp = new Stack();
		while (!empty()) {
			System.out.println(top.toString());
			tmp.push(this.pop());
		}
		while (!tmp.empty()) {
			this.push(tmp.pop());
		}
	}

	/**
	 * @return each Node's information on its own line.
	 */
	public String toString() {
		Stack tmp = new Stack();
		String info = "";
		while (!empty()) {
			info += top.toString() + "\n";
			tmp.push(this.pop());
		}
		while (!tmp.empty()) {
			this.push(tmp.pop());
		}
		return info;
	}
}
