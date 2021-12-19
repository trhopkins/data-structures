package interfaces;

public interface DoublyLinkedListInterface {
	void insertFirst(int item);
	void insertLast(int item);
	void deleteFirst();
	void deleteLast();
	int size();
	int first();
	int last();
	boolean empty();
	void traverse();
}
