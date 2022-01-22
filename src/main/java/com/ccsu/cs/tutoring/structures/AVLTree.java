package com.ccsu.cs.tutoring.structures;

import com.ccsu.cs.tutoring.nodes.AVLNode;

/**
 * @author Travis Hopkins
 * @version 0.0.2
 * @see <a href="https://www.baeldung.com/java-avl-trees"> AVL Tree ADT tutorial</a>
 */
public class AVLTree<T extends Comparable<T>> {
	private AVLNode<T> root;
	private int size;

	public AVLTree() {
		root = null;
		size = 0;
	}

	public void insert(T key) {
		root = insert(root, key);
		size++;
	}

	private AVLNode<T> insert(AVLNode<T> node, T key) {
		if (node == null) {
			return new AVLNode<T>(key, null, null);
		} else if (node.getData().compareTo(key) > 0) {
			node.setLeft(insert(node.getLeft(), key));
		} else if (node.getData().compareTo(key) < 0) {
			node.setRight(insert(node.getRight(), key));
		} else {
			throw new RuntimeException("duplicate Key!");
		}
		return rebalance(node);
	}

	public void delete(T key) {
		root = delete(root, key);
		size--;
	}

	private AVLNode<T> delete(AVLNode<T> node, T key) {
		if (node == null) {
			return node;
		} else if (node.getData().compareTo(key) > 0) {
			node.setLeft(delete(node.getLeft(), key));
		} else if (node.getData().compareTo(key) < 0) {
			node.setRight(delete(node.getRight(), key));
		} else {
			if (node.getLeft() == null || node.getRight() == null) {
				node = (node.getLeft() == null) ? node.getRight() : node.getLeft();
			} else {
				AVLNode<T> mostLeftChild = mostLeftChild(node.getRight());
				node.setData(mostLeftChild.getData());
				node.setRight(delete(node.getRight(), node.getData()));
			}
		}
		if (node != null) {
			node = rebalance(node);
		}
		return node;
	}

	private AVLNode<T> mostLeftChild(AVLNode<T> node) {
		AVLNode<T> current = node;
		while (current.getLeft() != null) {
			current = current.getLeft();
		}
		return current;
	}

	public int size() {
		return size;
	}

	public boolean empty() {
		return size == 0;
	}

	public boolean full() {
		return size == Integer.MAX_VALUE;
	}

	public int height() {
		return root == null ? 0 : root.getHeight();
	}

	private AVLNode<T> rebalance(AVLNode<T> z) {
		updateHeight(z);
		int balance = getBalance(z);
		if (balance > 1) {
			if (height(z.getRight().getRight()) > height(z.getRight().getLeft())) {
				z = rotateLeft(z);
			} else {
				z.setRight(rotateRight(z.getRight()));
				z = rotateLeft(z);
			}
		} else if (balance < -1) {
			if (height(z.getLeft().getLeft()) > height(z.getLeft().getRight())) {
				z = rotateRight(z);
			} else {
				z.setLeft(rotateLeft(z.getLeft()));
				z = rotateRight(z);
			}
		}
		return z;
	}

	private AVLNode<T> rotateRight(AVLNode<T> y) {
		AVLNode<T> x = y.getLeft();
		AVLNode<T> z = x.getRight();
		x.setRight(y);
		y.setLeft(z);
		updateHeight(y);
		updateHeight(x);
		return x;
	}

	private AVLNode<T> rotateLeft(AVLNode<T> y) {
		AVLNode<T> x = y.getRight();
		AVLNode<T> z = x.getLeft();
		x.setLeft(y);
		y.setRight(z);
		updateHeight(y);
		updateHeight(x);
		return x;
	}

	private void updateHeight(AVLNode<T> n) {
		n.setHeight(1 + Math.max(height(n.getLeft()), height(n.getRight())));
	}

	private int height(AVLNode<T> n) {
		return n == null ? 0 : n.getHeight();
	}

	public int getBalance(AVLNode<T> n) {
		return (n == null) ? 0 : height(n.getRight()) - height(n.getLeft());
	}

	public AVLNode<T> find(T key) {
		AVLNode<T> current = root;
		while (current != null) {
			if (current.getData() == key) {
			   break;
			}
			current = current.getData().compareTo(key) < 0 ? current.getRight() : current.getLeft();
		}
		return current;
	}

	public void traverse() {
		System.out.println(this);
	}

	public String toString() {
		recursiveToString(root, "");
		return info;
	}

	private String info = "";

	/**
	 * Gradually build up a String representation of the tree. Follows left-root-right order.
	 * @param root current Node to build with
	 * @param info current String to build into
	 * @return info String with subtree toStrings appended
	 */
	private String recursiveToString(AVLNode<T> root, String info) { // accumulator-passing style
		if (root != null) {
			recursiveToString(root.getLeft(), info); // in-order traversal
			this.info += root.toString() + "\n";
			recursiveToString(root.getRight(), "");
		}
		return info;
	}
}
