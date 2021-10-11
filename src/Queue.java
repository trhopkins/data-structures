public class Queue implements QueueInterface {
	private Node front;
	private Node rear;
	private int size;

	public Queue() {
		size = 0;
		front = rear = null;
	}

	public void enqueue(int data) {
		if (this.empty()) {
			front = rear = new Node(data, rear);
		} else {
			front = new Node(data, rear);
		}
		size++;
	}

	public int dequeue() {
		int frontValue = front.getData();
		front = front.getNext();
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
}