package com.ccsu.cs.tutoring.nodes;

/**
 * AVL Tree Node which tracks height as well as other BST Node data.
 * @author Travis Reid Hopkins
 * @version 2.0.1
 */
public class AVLNode<T extends Comparable<T>> {
	public T data;
	public AVLNode<T> left;
	public AVLNode<T> right;
	public int height;

	/**
	 * Constructor for the AVLNode datatype. All data can be initialized
	 * as null to begin if needed.
	 * @param data
	 * @param left
	 * @param right
	 */
	public AVLNode(T data, AVLNode<T> left, AVLNode<T> right) {
		this.data = data;
		this.left = left;
		this.right = right;
		height = 1; // nulls are zero, leaves are one, etc.
	}

	/**
	 * Overloaded constructor which changes the height as well.
	 * @param data
	 * @param left
	 * @param right
	 */
	public AVLNode(T data, AVLNode<T> left, AVLNode<T> right, int height) {
		this.data = data;
		this.left = left;
		this.right = right;
		this.height = height; // nulls are zero, leaves are one, etc.
	}

	public String toString() {
		return String.valueOf(data);
	}
}
