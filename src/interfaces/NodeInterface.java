package interfaces;

import nodes.Node;

public interface NodeInterface {
	public int getData();
	public Node getNext();
	public void setData(int data);
	public void setNext(Node next);
}
