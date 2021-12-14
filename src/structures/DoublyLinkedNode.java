package structures;

public class DoublyLinkedNode {
	private int data;
	private DoublyLinkedNode next, prev;

	public DoublyLinkedNode(int data, DoublyLinkedNode next, DoublyLinkedNode prev) {
		this.data = data;
		this.next = next;
		this.prev = prev;
	}

	public void setData(int data) {
		this.data = data;
	}

	public void setNext(DoublyLinkedNode next) {
		this.next = next;
	}

	public void setPrev(DoublyLinkedNode prev) {
		this.prev = prev;
	}

	public int getData() {
		return data;
	}

	public DoublyLinkedNode getNext() {
		return next;
	}

	public DoublyLinkedNode getPrev() {
		return prev;
	}

	public String toString() {
		return String.valueOf(data);
	}
}
