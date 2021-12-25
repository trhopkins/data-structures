package com.ccsu.cs.tutoring.structures;

import com.ccsu.cs.tutoring.nodes.BinaryTreeNode;
import com.ccsu.cs.tutoring.interfaces.BinaryTreeInterface;

/**
 * Binary tree containing integer nodes.
 * @author Travis Hopkins
 * @version 1.0.1
 * @see {@link https://www.baeldung.com/java-binary-tree}
 */
public class BinaryTree<T extends Comparable<T>> implements BinaryTreeInterface<T> {
	private BinaryTreeNode<T> root;
	private int size;
	private String info = ""; // required for recursiveToString. Should find a way which doesn't require global variables

	/** Empty Binary Tree constructor. */
	public BinaryTree() {
		root = null;
		size = 0;
	}

	/**
	 * Get the root of the Binary Tree.
	 * @return root of the Binary Tree
	 */
	public BinaryTreeNode<T> root() {
		return root;
	}

	/**
	 * Add a new Node to the Binary Tree. This operation does not restructure
	 * the tree, only adds leaves.
	 * @param data to add to the Binary Tree
	 */
	public void insert(T data) {
		root = recursiveInsert(root, data);
		size++;
	}

	/**
	 * Find the location to insert a new leaf Node, then place it there.
	 * @param root current Node to compare against inserted data
	 * @param data information to add to the tree
	 * @return Node to try inserting into next
	 */
	private BinaryTreeNode<T> recursiveInsert(BinaryTreeNode<T> root, T data) {
		if (root == null) { // add leaf
			return new BinaryTreeNode<T>(data, null, null);
		} else { // walk further down
			if (data.compareTo(root.getData()) < 0) { // go left
				root.setLeft(recursiveInsert(root.getLeft(), data));
			} else { // go right (allows duplicates)
				root.setRight(recursiveInsert(root.getRight(), data));
			}
		}
		return root; // new subtree
	}

	/**
	 * Find a Node matching a given input and remove it, possibly
	 * replacing it with a descendant.
	 * @param key data to search for
	 */
	public void delete(T key) {
		recursiveDelete(root, key);
		size--;
	}

	/**
	 * Walk down the tree until the correct data value is located, then
	 * replace it with an descendant Node if necessary.
	 * @param root current Node to compare against key
	 * @param key value to search for. If found, replace or delete
	 * @return subtree starting with current Node's L/R child to replace current one
	 */
	private BinaryTreeNode<T> recursiveDelete(BinaryTreeNode<T> root, T key) {
        if (root == null) { // went past leaf
            return null;
        } else if (key.compareTo(root.getData()) == 0) { // found it
            return replaceWithDescendent(root);
        } else if (key.compareTo(root.getData()) < 0) { // try left
			root.setLeft(recursiveDelete(root.getLeft(), key));
        } else { // try right
			root.setRight(recursiveDelete(root.getRight(), key));
		}
		return root;
    }

	/**
	 * Once a node has been located, walk down the tree until a replacement is found.
	 * @param root current node to search along
	 * @return subtree to replace the current one
	 */
	private BinaryTreeNode<T> replaceWithDescendent(BinaryTreeNode<T> root) {
		// Case 1: no children
		if (root.getLeft() == null && root.getRight() == null) {
		    return null;
		} else if (root.getRight() == null) { // Case 2: 1 child
		    return root.getLeft();
		} else if (root.getLeft() == null) {
		    return root.getRight();
		} else { // Case 3: 2 children
			T smallestValue = findSmallestDescendent(root.getRight());
			root.setData(smallestValue);
			root.setRight(recursiveDelete(root.getRight(), smallestValue));
			return root;
		}
	}

	/**
	 * Search for current Node's smallest descendent and return its value.
	 * @param root current Node to search below
	 * @return value of the smallest descendent Node
	 */
	private T findSmallestDescendent(BinaryTreeNode<T> root) {
		return root.getLeft() == null ? root.getData() : findSmallestDescendent(root.getRight());
	}

	/** Empty the tree. */
	public void clear() {
		root = null;
		size = 0;
	}

	/**
	 * Check if the tree is empty.
	 * @return true if no Nodes are found (root is null)
	 */
	public boolean empty() {
		return size == 0;
	}

	/**
	 * Check if this Binary Tree can still accept more Nodes.
	 * @return false if still has space for more BTNodes
	 */
	public boolean full() {
		return size >= Integer.MAX_VALUE;
	}

	/**
	 * Return the number of elements.
	 * @return count of Nodes
	 */
	public int size() {
		return size;
	}

	/**
	 * See if the requested data exists in tree.
	 * @param key data value to search for
	 * @return true if searched data is found
	 */
	public boolean search(T key) {
		return recursiveSearch(root, key);
	}

	/**
	 * Walk recursively down until the value is null or matches.
	 * @param root current Node to compare
	 * @param key value to compare against
	 * @return true if searched data is found
	 */
	private boolean recursiveSearch(BinaryTreeNode<T> root, T key) {
		if (root == null) { // leaf
			return false;
		} else if (root.getData() == key) { // match!
			return true;
		} else { // try children
			if (key.compareTo(root.getData()) < 0) { // left?
				return recursiveSearch(root.getLeft(), key);
			} else { // right?
				return recursiveSearch(root.getRight(), key);
			}
		}
	}

	/**
	 * See if the requested data exists in tree.
	 * @param key data value to search for
	 * @return Node matching given data
	 */
	public BinaryTreeNode<T> find(T key) {
		return recursiveFind(root, key);
	}

	/**
	 * Walk recursively down until the value is null or matches and
	 * return found Node, or null if not found.
	 * @param root current Node to compare
	 * @param key value to compare against
	 * @return true if searched data is found
	 */
	private BinaryTreeNode<T> recursiveFind(BinaryTreeNode<T> root, T key) { // identical to search
		if (root == null) { // leaf
			return null;
		} else if (root.getData() == key) { // match!
			return root;
		} else { // try children
			if (key.compareTo(root.getData()) < 0) { // left?
				return recursiveFind(root.getLeft(), key);
			} else { // right?
				return recursiveFind(root.getRight(), key);
			}
		}
	}

	/**
	 * Traverse from root to leaves, then count the jumps on the way up.
	 * @return number of levels in this tree
	 */
	public int height() {
		return recursiveHeight(root);
	}

	/**
	 * Get height of a given Node by querying its children.
	 * @param root Node to check height of
	 * @return number of levels in this tree
	 */
	public int recursiveHeight(BinaryTreeNode<T> root) {
		if (root.getLeft() == null && root.getRight() == null) { // leaf
			return 1;
		} else if (root.getLeft() == null) { // one child
			return 1 + recursiveHeight(root.getRight());
		} else if (root.getRight() == null) { // one child
			return 1 + recursiveHeight(root.getLeft());
		} else { // choose larger of two children
			int leftHeight = recursiveHeight(root.getLeft());
			int rightHeight = recursiveHeight(root.getRight());
			return leftHeight > rightHeight ? 1 + leftHeight : 1 + rightHeight; // feelin' cute, might delete later
		}
	}

	/** Print all Nodes. Defaults to in-order traversal. */
	public void traverse() {
		System.out.print(this);
	}

	/** Print all Nodes in left-root-right order. */
	public void inOrderTraverse() {
		recursiveInOrderTraverse(root);
	}

	/** Print all Nodes in root-left-right order. */
	public void preOrderTraverse() {
		recursivePreOrderTraverse(root);
	}

	/** Print all Nodes in left-right-root order. */
	public void postOrderTraverse() {
		recursivePostOrderTraverse(root);
	}

	/** Print all Nodes in top-down, left-to-right order. */
	public void levelOrderTraverse() {
		if (root != null) {
			Queue<BinaryTreeNode<T>> toVisit = new Queue<>();
			toVisit.enqueue(root);
			while (!toVisit.empty()) {
				BinaryTreeNode<T> current = toVisit.dequeue();
				System.out.println(current);
				if (current.getLeft() != null) {
					toVisit.enqueue(current.getLeft());
				}
				if (current.getRight() != null) {
					toVisit.enqueue(current.getRight());
				}
			}
		}
	}

	/** Print all Nodes in left-root-right order. */
	private void recursiveInOrderTraverse(BinaryTreeNode<T> root) {
		if (root != null) {
			recursiveInOrderTraverse(root.getLeft());
			System.out.println(root);
			recursiveInOrderTraverse(root.getRight());
		} // else {System.out.println("null");}
	}

	/** Print all Nodes in root-left-right order. */
	private void recursivePreOrderTraverse(BinaryTreeNode<T> root) {
		if (root != null) {
			System.out.println(root);
			recursivePreOrderTraverse(root.getLeft());
			recursivePreOrderTraverse(root.getRight());
		} // else {System.out.println("null");}
	}

	/** Print all Nodes in left-right-root order. */
	private void recursivePostOrderTraverse(BinaryTreeNode<T> root) {
		if (root != null) {
			recursivePostOrderTraverse(root.getLeft());
			recursivePostOrderTraverse(root.getRight());
			System.out.println(root);
		} // else {System.out.println("null");}
	}

	/** @return String representation of this Binary Tree. */
	public String toString() {
		return recursiveToString(root);
	}

	/**
	 * Gradually build up a String representation of the tree. Follows left-root-right order.
	 * @param root current Node to build with
	 * @param info current String to build into
	 * @return info String with subtree toStrings appended
	 */
	private String recursiveToString(BinaryTreeNode<T> root) { // find a way that doesn't require global variables?
		if (root != null) {
			recursiveToString(root.getLeft()); // in-order traversal
			info += root.toString() + "\n";
			recursiveToString(root.getRight());
		}
		return info;
	}
}
