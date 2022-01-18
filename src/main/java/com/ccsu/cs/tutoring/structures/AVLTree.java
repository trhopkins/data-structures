package com.ccsu.cs.tutoring.structures;

import com.ccsu.cs.tutoring.nodes.AVLNode;

/**
 * @author Travis Hopkins
 * @version 0.0.1
 * @see {@link https://www.baeldung.com/java-avl-trees}
 */
public class AVLTree<T extends Comparable<T>> {
	private AVLNode<T> root;
	private int size;

	public AVLTree() {
		this.root = null;
		this.size = 0;
	}

	public int size() {
		return size;
	}

	private void updateNodeHeight(AVLNode<T> node) {
		node.setHeight(1 + Math.max(node.getLeft().getHeight(), node.getRight().getHeight()));
	}

	private int getNodeBalance(AVLNode<T> node) {
		return node == null ? 0 : node.getLeft().getHeight() - node.getRight().getHeight();
	}

	private int getNodeHeight(AVLNode<T> node) {
		return node == null ? 0 : node.getHeight();
	}

	private AVLNode<T> rotateRight(AVLNode<T> y) {
		AVLNode<T> x = y.getLeft();
		AVLNode<T> z = x.getRight();
		x.setRight(y);
		y.setLeft(z);
		updateNodeHeight(y);
		updateNodeHeight(x);
		return x;
	}

	private AVLNode<T> rotateLeft(AVLNode<T> y) {
		AVLNode<T> x = y.getRight();
		AVLNode<T> z = x.getLeft();
		x.setLeft(y);
		y.setRight(z);
		updateNodeHeight(y);
		updateNodeHeight(x);
		return x;
	}

	private AVLNode<T> rebalanceNode(AVLNode<T> z) {
		updateNodeHeight(z);
		int balance = getNodeBalance(z);
		if (balance > 1) {
			if (getNodeHeight(z.getRight().getRight()) > getNodeHeight(z.getRight().getLeft())) {
				z = rotateLeft(z);
			} else {
				z.setRight(rotateRight(z.getRight()));
				z = rotateLeft(z);
			}
		} else if (balance < -1) {
			if (getNodeHeight(z.getLeft().getLeft()) > getNodeHeight(z.getLeft().getRight())) {
				z = rotateRight(z);
			} else {
				z.setLeft(rotateLeft(z.getLeft()));
				z = rotateRight(z);
			}
		}
		return z;
	}

	public AVLNode<T> insert(T data) {
		return recursiveInsert(root, data);
	}

	public AVLNode<T> recursiveInsert(AVLNode<T> node, T data) {
		if (node == null) {
			return new AVLNode<T>(data, null, null);
		} else if (node.getData().compareTo(data) > 0) {
			node.setLeft(recursiveInsert(node.getLeft(), data));			
		} else if (node.getData().compareTo(data) < 0) {
			node.setRight(recursiveInsert(node.getRight(), data));
		}
		return rebalanceNode(node);
	}

	public AVLNode<T> delete(T data) {
		return recursiveDelete(root, data);
	}

	private AVLNode<T> recursiveDelete(AVLNode<T> node, T data) {
		if (node == null) {
			return null;
		} else if (node.getData().compareTo(data) > 0) {
			node.setLeft(recursiveDelete(node.getLeft(), data));
		} else if (node.getData().compareTo(data) < 0) {
			node.setRight(recursiveDelete(node.getRight(), data));
		} else {
			if (node.getLeft() == null) {
				node = node.getRight();
			} else if (node.getLeft() == null) {
				node = node.getLeft();
			} else {
				node.setData(leastDescendant(node.getRight()).getData());
				node.setRight(recursiveDelete(node.getRight(), node.getData()));
			}
		}
		if (node != null) {
			node = rebalanceNode(node);
		}
		return node;
	}

	private AVLNode<T> leastDescendant(AVLNode<T> node) {
		if (node.getLeft() != null) {
			return leastDescendant(node.getLeft());
		} else {
			return node;
		}
	}
}
