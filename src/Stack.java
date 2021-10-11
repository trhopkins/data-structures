class Stack implements StackInterface {
	private Node top;
	private int size;

	public Stack() {
		top = null;
		size = 0;
	}

	public void push(int data) {
		Node newNode = new Node(data, top);
		top = newNode;
		size++;
	}

	public int pop() {
		int i = top.getData();
		top = top.getNext();
		size--;
		return i;
	}

	public int ontop() {
		return top.getData();
	}

	public int size() {
		return size;
	}

	public boolean empty() {
		return (top == null);
	}
}
