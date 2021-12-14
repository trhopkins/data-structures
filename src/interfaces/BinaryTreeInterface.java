package interfaces;

import nodes.BinaryTreeNode;

public interface BinaryTreeInterface {
	public BinaryTreeNode root();
	public void setLeft(BinaryTreeNode target, BinaryTreeNode left);
	public void setRight(BinaryTreeNode target, BinaryTreeNode right);
	//public void setLeft(BinaryTreeNode left);
	//public void setRight(BinaryTreeNode right);
	public void removeLeft(BinaryTreeNode target);
	public void removeRight(BinaryTreeNode target);
	public void clear(); // removeAll()?
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
