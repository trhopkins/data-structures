package structures;

import interfaces.NodeInterface;

public class Node implements NodeInterface {
	int data;
	Node next;

	public Node(int data, Node next) {
		this.data = data;
		this.next = next;
	}

	public int getData() {
		return data;
	}

	public Node getNext() {
		return next;
	}

	public void setData(int data) {
		this.data = data;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public String toString() {
		return String.valueOf(data);
	}
}