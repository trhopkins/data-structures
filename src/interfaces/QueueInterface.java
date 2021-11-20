package interfaces;

public interface QueueInterface {
	public void enqueue(int data);
	public int dequeue();
	public int front();
	public int size();
	public boolean empty();
	public void traverse();
}
