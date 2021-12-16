package structures;

import java.util.Queue;
import java.util.LinkedList;
import nodes.BinaryTreeNode;
import interfaces.BinaryTreeInterface;

/**
 * Binary tree containing integer nodes.
 * @author Travis Hopkins
 * @version 1.0.0
 * @see {@link https://www.baeldung.com/java-binary-tree}
 */
public class BinaryTree implements BinaryTreeInterface {
	private BinaryTreeNode root;
	private int size;

	public BinaryTree() {
		root = null;
	}

	public BinaryTreeNode root() {
		return root;
	}

	public void insert(int data) {
		recursiveInsert(root, data);
		size++;
	}

	private BinaryTreeNode recursiveInsert(BinaryTreeNode root, int data) {
		if (root == null) {
			return new BinaryTreeNode(data, null, null);
		} else {
			if (data < root.getData()) {
				root.setLeft(recursiveInsert(root.getLeft(), data));
			} else { // >= allows duplicates
				root.setRight(recursiveInsert(root.getRight(), data));
			}
		}
		return root;
	}

	public void delete(int key) {
		recursiveDelete(root, key);
		size--;
	}

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
		return root;
	}

	private BinaryTreeNode replaceNodeWithAncestor(BinaryTreeNode root) {
		if (root.getLeft() == null && root.getRight() == null) { // no children
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

	private int findSmallestAncestor(BinaryTreeNode root) {
		return root.getLeft() == null ? root.getData() : findSmallestAncestor(root.getRight());
	}

	public void clear() {
		root = null;
		size = 0;
	}

	public boolean empty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public boolean search(int key) {
		return recursiveSearch(root, key);
	}

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

	public BinaryTreeNode find(int key) {
		return recursiveFind(root, key);
	}

	private BinaryTreeNode recursiveFind(BinaryTreeNode root, int key) { // basically identical to search. Once iterators are added, consider using that instead?
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

	public void traverse() {
		inOrderTraverse();
	}

	public void inOrderTraverse() {
		recursiveInOrderTraverse(root);
	}

	public void preOrderTraverse() {
		recursivePreOrderTraverse(root);
	}

	public void postOrderTraverse() {
		recursivePostOrderTraverse(root);
	}

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

	private void recursiveInOrderTraverse(BinaryTreeNode root) {
		BinaryTreeNode current = root;
		if (current != null) {
			recursiveInOrderTraverse(root.getLeft());
			System.out.println(root);
			recursiveInOrderTraverse(root.getRight());
		} // else {System.out.println("null");}
	}

	private void recursivePreOrderTraverse(BinaryTreeNode root) {
		BinaryTreeNode current = root;
		if (current != null) {
			System.out.println(root);
			recursiveInOrderTraverse(root.getLeft());
			recursiveInOrderTraverse(root.getRight());
		} // else {System.out.println("null");}
	}

	private void recursivePostOrderTraverse(BinaryTreeNode root) {
		BinaryTreeNode current = root;
		if (current != null) {
			recursiveInOrderTraverse(root.getLeft());
			recursiveInOrderTraverse(root.getRight());
			System.out.println(root);
		} // else {System.out.println("null");}
	}
}
