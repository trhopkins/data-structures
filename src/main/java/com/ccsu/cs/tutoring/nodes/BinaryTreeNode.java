package com.ccsu.cs.tutoring.nodes;

/**
 * Element of a binary tree. Can be root, branch, or leaf.
 * @author Travis Hopkins
 * @version 1.0.0
 */
public class BinaryTreeNode {
	private int data;
	private BinaryTreeNode left, right;

	/**
	 * Constructor for BinaryTreeNodes. Can set as empty with BinaryTreeNode(0, null, null)
	 * @param data to insert into the Node
	 * @param left child, < this Node
	 * @param right child, >= this Node
	 */
	public BinaryTreeNode(int data, BinaryTreeNode left, BinaryTreeNode right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public int getData() {
		return data;
	}

	public BinaryTreeNode getLeft() {
		return left;
	}

	public BinaryTreeNode getRight() {
		return right;
	}

	public void setData(int data) {
		this.data = data;
	}

	public void setLeft(BinaryTreeNode left) {
		this.left = left;
	}

	public void setRight(BinaryTreeNode right) {
		this.right = right;
	}

	public String toString() {
		return String.valueOf(data);
	}
}
