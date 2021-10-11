public interface StackInterface {
	public void push(int data);
	public int pop() throws EmptyStackException;
	public int ontop() throws EmptyStackException;
	public int size();
	public boolean empty();
}
