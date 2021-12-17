package interfaces;

public interface QueueInterface {
	void enqueue(int data);
	int dequeue();
	int front();
	int size();
	boolean empty();
	void traverse();
}
