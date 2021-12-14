package interfaces;

import structures.DoublyLinkedNode;

public interface DoublyLinkedListInterface {
	public void insertFirst(int item);
	public void insertLast(int item);
	public DoublyLinkedNode deleteFirst();
	public DoublyLinkedNode deleteLast();
	public int size();
	public int last();
	public int first();
	public boolean empty();
	public void traverse();
}
