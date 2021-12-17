package interfaces;

import nodes.Node;

public interface NodeInterface {
	int getData();
	Node getNext();
	void setData(int data);
	void setNext(Node next);
}
