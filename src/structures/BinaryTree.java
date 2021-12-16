package structures;

import nodes.BinaryTreeNode;
import interfaces.BinaryTreeInterface;

public class BinaryTree implements BinaryTreeInterface {
	private BinaryTreeNode root;
	private int size; // TODO: fix insert/delete to work properly with size

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

	public boolean search(int key) { // TODO: finish
		return false;
	}

	public BinaryTreeNode find(int key) { // TODO: finish
		return null;
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
		recursiveLevelOrderTraverse(root);
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

	private void recursiveLevelOrderTraverse(BinaryTreeNode root) {
		; // requires Queue<BinaryTreeNode>
	}
}