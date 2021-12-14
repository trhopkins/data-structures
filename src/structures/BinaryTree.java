package structures;

import nodes.BinaryTreeNode;
import interfaces.BinaryTreeInterface;

public class BinaryTree implements BinaryTreeInterface {
	private BinaryTreeNode root;
	private int size;

	public BinaryTree() {
		root = null;
	}

	public BinaryTreeNode getRoot() {
		return root;
	}

	public void setRoot(BinaryTreeNode root) {
		this.root = root;
	}

	public void insert(int data) {
		insert(root, data);
	}

	public BinaryTreeNode insert(BinaryTreeNode root, int data) {
		if (root == null) {
			return new BinaryTreeNode(data, null, null);
		} else {
			if (data < root.getData()) {
				root.setLeft(insert(root.getLeft(), data));
			} else {
				root.setRight(insert(root.getRight(), data));
			}
		}
	}

	public void delete(int data) {
		;
	}

	public void clear() {
		root = null;
		size = 0;
	}

	public boolean empty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public boolean search(int key) {
		;
	}

	public BinaryTreeNode find(int key) {
		;
	}

	public void traverse() {
		inOrderTraverse();
	}

	public void inOrderTraverse() {
		inOrderTraverse(root);
	}

	public void preOrderTraverse() {
		preOrderTraverse(root);
	}

	public void postOrderTraverse() {
		postOrderTraverse(root);
	}

	public void inOrderTraverse(BinaryTreeNode root) {
		BinaryTreeNode current = root;
		if (current != null) {
			inOrderTraverse(root.getLeft());
			System.out.println(root);
			inOrderTraverse(root.getRight());
		} // else {System.out.println("null");}
	}

	public void preOrderTraverse(BinaryTreeNode root) {
		BinaryTreeNode current = root;
		if (current != null) {
			System.out.println(root);
			inOrderTraverse(root.getLeft());
			inOrderTraverse(root.getRight());
		} // else {System.out.println("null");}
	}

	public void postOrderTraverse(BinaryTreeNode root) {
		BinaryTreeNode current = root;
		if (current != null) {
			inOrderTraverse(root.getLeft());
			inOrderTraverse(root.getRight());
			System.out.println(root);
		} // else {System.out.println("null");}
	}
}