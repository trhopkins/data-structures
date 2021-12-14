package interfaces;

import nodes.BinaryTreeNode;

public interface BinaryTreeInterface {
	public BinaryTreeNode getRoot();
	public void setRoot(BinaryTreeNode root); // not certain if necessary
	public void insert(int data);
	public void delete(int data);
	public void clear();
	public boolean empty();
	public int size();
	public boolean search(int key);
	public BinaryTreeNode find(int key);
	public void traverse();
	public void inOrderTraverse();
	public void preOrderTraverse();
	public void postOrderTraverse();
	public void levelOrderTraverse();
}
