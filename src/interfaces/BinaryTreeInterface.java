package interfaces;

import nodes.BinaryTreeNode;

public interface BinaryTreeInterface {
	BinaryTreeNode root();
	void insert(int data);
	void delete(int data);
	void clear();
	boolean empty();
	int size();
	boolean search(int key);
	BinaryTreeNode find(int key);
	void traverse();
	void inOrderTraverse();
	void preOrderTraverse();
	void postOrderTraverse();
	void levelOrderTraverse();
}
