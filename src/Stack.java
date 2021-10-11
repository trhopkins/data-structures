class Stack implements StackInterface {
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

	public int pop() throws EmptyStackException {
		if (this.empty()) {
			throw new EmptyStackException("No Nodes remaining.");
		} else {
			int topValue = top.getData();
			top = top.getNext();
			size--;
			return topValue;
		}
	}

	public int ontop() throws EmptyStackException {
		if (this.empty()) {
			throw new EmptyStackException("No Nodes remaining.");
		} else {
			return top.getData();
		}
	}

	public int size() {
		return size;
	}

	public boolean empty() {
		return top == null;
	}
}
