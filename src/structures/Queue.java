package structures;

public class Queue implements QueueInterface {
	private Node front;
	private Node rear;
	private int size;

	public Queue() {
		size = 0;
		front = rear = null;
	}

	public void enqueue(int data) {
		Node newNode = new Node(data, null);
		if (this.empty()) {
			front = newNode;
		} else {
			rear.setNext(newNode);
		}
		rear = newNode;
		size++;
	}

	public int dequeue() {
		int frontValue = front.getData();
		front = front.getNext();
		if (this.empty()) {
			rear = null;
		}
		size--;
		return frontValue;
	}

	public int front() {
		return front.getData();
	}

	public int size() {
		return size;
	}

	public boolean empty() {
		return size == 0;
	}

	public void traverse() {
		Node current = front;
		while (current != null) {
			System.out.println(current);
			current = current.getNext();
		}
	}
}
