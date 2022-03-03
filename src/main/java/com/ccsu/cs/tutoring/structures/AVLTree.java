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

	/** Empty AVL Tree constructor. */
	public AVLTree() {
		root = null;
		size = 0;
	}

	/** Insert a new element into the tree. */
	public void insert(T key) {
		root = recursiveInsert(root, key);
		size++;
	}

	/**
	 * Recursively traverse to a leaf Node to insert this element underneath.
	 * @param node root of current subtree to recursively search
	 * @param key element to search for before inserting
	 * @return subtree with the key Node added
	 */
	private AVLNode<T> recursiveInsert(AVLNode<T> node, T key) {
		if (node == null) {
			return new AVLNode<T>(key, null, null);
		} else if (node.getData().compareTo(key) > 0) {
			node.setLeft(recursiveInsert(node.getLeft(), key));
		} else if (node.getData().compareTo(key) < 0) {
			node.setRight(recursiveInsert(node.getRight(), key));
		} else {
			throw new RuntimeException("duplicate Key!"); // write own exception?
		}
		return rebalance(node);
	}

	/**
	 * Search for an element and delete it from the tree.
	 * @param key thing to search for and remove
	 */
	public void delete(T key) {
		root = recursiveDelete(root, key);
		size--;
	}

	/**
	 * Recursively search down the AVL tree until the key is found, and delete that Node. 
	 * @param node current subtree root to search down
	 * @param key element to search for and delete
	 * @return subtree with the key Node removed
	 */
	private AVLNode<T> recursiveDelete(AVLNode<T> node, T key) {
		if (node == null) {
			return node;
		} else if (node.getData().compareTo(key) > 0) {
			node.setLeft(recursiveDelete(node.getLeft(), key));
		} else if (node.getData().compareTo(key) < 0) {
			node.setRight(recursiveDelete(node.getRight(), key));
		} else {
			if (node.getLeft() == null || node.getRight() == null) {
				node = (node.getLeft() == null) ? node.getRight() : node.getLeft();
			} else {
				AVLNode<T> mostLeftChild = mostLeftChild(node.getRight());
				node.setData(mostLeftChild.getData());
				node.setRight(recursiveDelete(node.getRight(), node.getData()));
			}
		}
		if (node != null) {
			node = rebalance(node);
		}
		return node;
	}

	/**
	 * Search for the smallest element below the current Node.
	 * @param node current subtree to search down
	 * @return smallest element (furthest to the left)
	 */
	private AVLNode<T> mostLeftChild(AVLNode<T> node) {
		AVLNode<T> current = node;
		while (current.getLeft() != null) {
			current = current.getLeft();
		}
		return current;
	}

	/**
	 * Return the number of Nodes in the AVL Tree.
	 * @return count of elements in Tree
	 */
	public int size() {
		return size;
	}

	/**
	 * Check if the tree is empty or not.
	 * @return true if size is zero, false is greater
	 */
	public boolean empty() {
		return size == 0;
	}

	/**
	 * Check if the tree has reached its maximum size.
	 * @return true if the number of Nodes is 2^32 - 1
	 */
	public boolean full() {
		return size == Integer.MAX_VALUE;
	}

	/**
	 * @return number of levels in the tree
	 */
	public int height() {
		return root == null ? 0 : root.getHeight();
	}

	/**
	 * reorganize the elements of the AVL subtree to reduce the overall
	 * height. May recursively do this operation on subtrees.
	 * @param z root of subtree to rebalance. Ends up lower down
	 * @return subtree with elements restructured
	 */
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

	/**
	 * Shift elements right so left subtree height is reduced.
	 * @param y root of subtree to rebalance
	 * @return restructured subtree
	 */
	private AVLNode<T> rotateRight(AVLNode<T> y) {
		AVLNode<T> x = y.getLeft();
		AVLNode<T> z = x.getRight();
		x.setRight(y);
		y.setLeft(z);
		updateHeight(y);
		updateHeight(x);
		return x;
	}

	/**
	 * Shift elements left so right subtree height is reduced.
	 * @param y root of subtree to rebalance
	 * @return restructured subtree
	 */
	private AVLNode<T> rotateLeft(AVLNode<T> y) {
		AVLNode<T> x = y.getRight();
		AVLNode<T> z = x.getLeft();
		x.setLeft(y);
		y.setRight(z);
		updateHeight(y);
		updateHeight(x);
		return x;
	}

	/**
	 * Change the height of a subtree to reflect rebalances.
	 * @param n Node to recount height of
	 */
	private void updateHeight(AVLNode<T> n) {
		n.setHeight(1 + Math.max(height(n.getLeft()), height(n.getRight())));
	}

	/**
	 * Get the height of a Node. Returns zero for null elements.
	 * @param n Node to check height of
	 * @return Node's height
	 */
	private int height(AVLNode<T> n) {
		return n == null ? 0 : n.getHeight();
	}

	/**
	 * Check if the current subtree needs to be rebalanced
	 * @param n Node to check
	 * @return <-1 for left imbalance, -1/0/1 for balanced, >1 for right imbalance
	 */
	public int getBalance(AVLNode<T> n) {
		return (n == null) ? 0 : height(n.getRight()) - height(n.getLeft());
	}

	/**
	 * Search for the given key and return a reference to its Node.
	 * @param key data to search for
	 * @return Node containing the key
	 */
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

	/**
	 * Print a String representation of this AVL Tree.
	 */
	public void traverse() {
		System.out.println(this);
	}

	/**
	 * @return String representation of the AVL Tree
	 */
	public String toString() {
		recursiveToString(root, "");
		return info;
	}

	private String info = ""; // only needed for recursiveToString. Find a way to remove?

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
