package com.ccsu.cs.tutoring.nodes;

/**
 * Element of a binary tree. Can be root, branch, or leaf.
 * @author Travis Hopkins
 * @version 1.0.0
 */
public class BinaryTreeNode<T> {
	private T data;
	private BinaryTreeNode<T> left, right;

	public BinaryTreeNode(T data, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public T getData() {
		return data;
	}

	public BinaryTreeNode<T> getLeft() {
		return left;
	}

	public BinaryTreeNode<T> getRight() {
		return right;
	}

	public void setData(T data) {
		this.data = data;
	}

	public void setLeft(BinaryTreeNode<T> left) {
		this.left = left;
	}

	public void setRight(BinaryTreeNode<T> right) {
		this.right = right;
	}

	public String toString() {
		return String.valueOf(data);
	}
}
