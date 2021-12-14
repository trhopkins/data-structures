package structures;

import nodes.BinaryTreeNode;
import interfaces.BinaryTreeInterface;

public class BinaryTree implements BinaryTreeInterface {
	private BinaryTreeNode root;

	public BinaryTree() {
		root = null;
	}

	public BinaryTreeNode getRoot() {
		return root;
	}

	public void setRoot(BinaryTreeNode root) {
		this.root = root;
	}

	public void clear() {
		root = null;
	}

	public void inOrderTraverse() {
		;
	}
}