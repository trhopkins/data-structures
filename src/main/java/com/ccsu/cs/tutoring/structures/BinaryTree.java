package com.ccsu.cs.tutoring.structures;

import java.util.Queue;
import java.util.LinkedList;
import com.ccsu.cs.tutoring.nodes.BinaryTreeNode;
import com.ccsu.cs.tutoring.interfaces.BinaryTreeInterface;

/**
 * Binary tree containing integer nodes.
 * @author Travis Hopkins
 * @version 1.0.0
 * @see {@link https://www.baeldung.com/java-binary-tree}
 */
public class BinaryTree implements BinaryTreeInterface {
	private BinaryTreeNode root;
	private int size;

	/** Empty Binary Tree constructor. */
	public BinaryTree() {
		root = null;
		size = 0;
	}

	/**
	 * Get the root of the Binary Tree.
	 * @return root of the Binary Tree
	 */
	public BinaryTreeNode root() {
		return root;
	}

	/**
	 * Add a new Node to the Binary Tree. This operation does not restructure
	 * the tree, only adds leaves.
	 * @param data to add to the Binary Tree
	 */
	public void insert(int data) {
		recursiveInsert(root, data);
		size++;
	}

	/**
	 * Find the location to insert a new leaf Node, then place it there.
	 * @param root current Node to compare against inserted data
	 * @param data information to add to the tree
	 * @return Node to try inserting into next
	 */
	private BinaryTreeNode recursiveInsert(BinaryTreeNode root, int data) {
		if (root == null) { // empty space to insert into
			return new BinaryTreeNode(data, null, null);
		} else { // walk further down
			if (data < root.getData()) { // go left
				root.setLeft(recursiveInsert(root.getLeft(), data));
			} else { // go right (allows duplicates)
				root.setRight(recursiveInsert(root.getRight(), data));
			}
		}
		return root; // new subtree
	}

	/**
	 * Find a Node matching a given input and remove it, possibly
	 * replacing it with an ancestor.
	 * @param key data to search for
	 */
	public void delete(int key) {
		recursiveDelete(root, key);
		size--;
	}

	/**
	 * Walk down the tree until the correct data value is located, then
	 * replace it with an ancestor Node if necessary.
	 * @param root current Node to compare against key
	 * @param key value to search for. If found, replace or delete
	 * @return subtree starting with current Node's L/R child to replace current one
	 */
	private BinaryTreeNode recursiveDelete(BinaryTreeNode root, int key) {
		if (root == null) { // empty
			return null;
		}
		if (key == root.getData()) { // found it!
			replaceNodeWithAncestor(root);
		} else if (key < root.getData()) { // try left
			root.setLeft(recursiveDelete(root.getLeft(), key));
		} else { // try right
			root.setRight(recursiveDelete(root.getRight(), key));
		}
		return root; // new subtree
	}

	/**
	 * When deleting a Node with children, determine which ancestor
	 * Node should replace this.
	 * @param root deleted Node to replace
	 * @return new subtree in deleted Node's place
	 */
	private BinaryTreeNode replaceNodeWithAncestor(BinaryTreeNode root) {
		if (root.getLeft() == null && root.getRight() == null) { // no children (leaf)
			return null;
		} else if (root.getLeft() == null) { // one right child
			return root.getRight();
		} else if (root.getRight() == null) { // one left child
			return root.getLeft();
		} else { // two children
			int smallestValue = findSmallestAncestor(root.getRight()); // mutual recursion!
			root.setData(smallestValue);
			root.setRight(recursiveDelete(root.getRight(), smallestValue));
			return root;
		}
	}

	/**
	 * Search for current Node's smallest ancestor and return its value.
	 * @param root current Node to search below
	 * @return value of the smallest ancestor Node
	 */
	private int findSmallestAncestor(BinaryTreeNode root) {
		return root.getLeft() == null ? root.getData() : findSmallestAncestor(root.getRight());
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
	public boolean search(int key) {
		return recursiveSearch(root, key);
	}

	/**
	 * Walk recursively down until the value is null or matches.
	 * @param root current Node to compare
	 * @param key value to compare against
	 * @return true if searched data is found
	 */
	private boolean recursiveSearch(BinaryTreeNode root, int key) {
		if (root == null) { // leaf
			return false;
		} else if (root.getData() == key) { // match!
			return true;
		} else { // try children
			if (key < root.getData()) { // left?
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
	public BinaryTreeNode find(int key) {
		return recursiveFind(root, key);
	}

	/**
	 * Walk recursively down until the value is null or matches and
	 * return found Node, or null if not found.
	 * @param root current Node to compare
	 * @param key value to compare against
	 * @return true if searched data is found
	 */
	private BinaryTreeNode recursiveFind(BinaryTreeNode root, int key) { // identical to search
		if (root == null) { // leaf
			return null;
		} else if (root.getData() == key) { // match!
			return root;
		} else { // try children
			if (key < root.getData()) { // left?
				return recursiveFind(root.getLeft(), key);
			} else { // right?
				return recursiveFind(root.getRight(), key);
			}
		}
	}

	/** Print all Nodes. Defaults to in-order traversal. */
	public void traverse() {
		inOrderTraverse();
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
			Queue<BinaryTreeNode> toVisit = new LinkedList<BinaryTreeNode>(); // TODO: replace with own generic version(s)?
			toVisit.add(root);
			while (!toVisit.isEmpty()) {
				BinaryTreeNode current = toVisit.remove();
				System.out.println(current);
				if (current.getLeft() != null) {
					toVisit.add(current.getLeft());
				}
				if (current.getRight() != null) {
					toVisit.add(current.getRight());
				}
			}
		}
	}

	/** Print all Nodes in left-root-right order. */
	private void recursiveInOrderTraverse(BinaryTreeNode root) {
		if (root != null) {
			recursiveInOrderTraverse(root.getLeft());
			System.out.println(root);
			recursiveInOrderTraverse(root.getRight());
		} // else {System.out.println("null");}
	}

	/** Print all Nodes in root-left-right order. */
	private void recursivePreOrderTraverse(BinaryTreeNode root) {
		if (root != null) {
			System.out.println(root);
			recursiveInOrderTraverse(root.getLeft());
			recursiveInOrderTraverse(root.getRight());
		} // else {System.out.println("null");}
	}

	/** Print all Nodes in left-right-root order. */
	private void recursivePostOrderTraverse(BinaryTreeNode root) {
		if (root != null) {
			recursiveInOrderTraverse(root.getLeft());
			recursiveInOrderTraverse(root.getRight());
			System.out.println(root);
		} // else {System.out.println("null");}
	}
}
