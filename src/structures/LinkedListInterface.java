package structures;

public interface LinkedListInterface {
	public void insert(int data);
	public void delete(int data);
	public boolean search(int data);
	public int[] getKeys();
	public int size();
	public boolean empty();
	public void traverse();
}
