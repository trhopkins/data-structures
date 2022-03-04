package com.ccsu.cs.tutoring.nodes;

/**
 * Element of a binary tree. Can be root, branch, or leaf.
 * @author Travis Hopkins
 * @version 1.0.0
 */
public class BinaryTreeNode<T extends Comparable<T>> {
	public T data;
	public BinaryTreeNode<T> left, right;

	/**
	 * Constructor for BinaryTreeNodes. Can set as empty with BinaryTreeNode(0, null, null)
	 * @param data to insert into the Node
	 * @param left child, < this Node
	 * @param right child, >= this Node
	 */
	public BinaryTreeNode(T data, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

	/**
	 * @return String representation of the data stored in this Node
	 */
	public String toString() {
		return String.valueOf(data);
	}
}
