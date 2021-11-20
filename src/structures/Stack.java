package structures;

import interfaces.StackInterface;

public class Stack implements StackInterface {
	private Node top;
	private int size;

	public Stack() {
		top = null;
		size = 0;
	}

	public void push(int data) {
		top = new Node(data, top);
		size++;
	}

	public int pop() {
		int topValue = top.getData();
		top = top.getNext();
		size--;
		return topValue;
	}

	public int ontop() {
		return top.getData();
	}

	public int size() {
		return size;
	}

	public boolean empty() {
		return top == null;
	}

	public void traverse() {
		Stack tmp = new Stack();
		while (!empty()) {
			System.out.println(top);
			tmp.push(this.pop());
		}
		while (!tmp.empty()) {
			this.push(tmp.pop());
		}
	}
}
