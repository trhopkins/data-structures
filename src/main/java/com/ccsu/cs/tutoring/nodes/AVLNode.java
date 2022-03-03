package com.ccsu.cs.tutoring.nodes;

public class AVLNode<T extends Comparable<T>> {
	private T data;
	private AVLNode<T> left;
	private AVLNode<T> right;
	private int height;

	public AVLNode(T data, AVLNode<T> left, AVLNode<T> right) {
		this.setData(data);
		this.setLeft(left);
		this.setRight(right);
		this.setHeight(1);
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public AVLNode<T> getRight() {
		return right;
	}

	public void setRight(AVLNode<T> right) {
		this.right = right;
	}

	public AVLNode<T> getLeft() {
		return left;
	}

	public void setLeft(AVLNode<T> left) {
		this.left = left;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String toString() {
		return String.valueOf(data);
	}
}
