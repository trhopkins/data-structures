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

	/**
	 * Access data associated with this Node.
	 * @return the data stored in this Node
	 */
	public int getData() {
		return data;
	}

	/**
	 * Get the left child (whose data is 'less than' this Node).
	 * @return the left child Node
	 */
	public BinaryTreeNode getLeft() {
		return left;
	}

	/**
	 * Get the left child (whose data is 'greater than or equal to'
	 * this Node).
	 * @return the right child Node
	 */
	public BinaryTreeNode getRight() {
		return right;
	}

	/**
	 * Change data associated with this Node.
	 * @param data to set this Node to contain
	 */
	public void setData(int data) {
		this.data = data;
	}

	/**
	 * Change left child of this Node.
	 * @param left child to set
	 */
	public void setLeft(BinaryTreeNode left) {
		this.left = left;
	}

	/**
	 * Change right child of this Node.
	 * @param right child to set
	 */
	public void setRight(BinaryTreeNode right) {
		this.right = right;
	}

	/**
	 * @return String representation of the data stored in this Node
	 */
	public String toString() {
		return String.valueOf(data);
	}
}
