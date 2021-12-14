package nodes;

/**
 * Element of a binary tree. Can be root, branch, or leaf.
 * @author Travis Hopkins
 * @version 1.0.0
 */
public class BinaryTreeNode {
	private int data;
	private BinaryTreeNode left, right;

	public BinaryTreeNode(int data, BinaryTreeNode left, BinaryTreeNode right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public int getData() {
		return data;
	}

	public BinaryTreeNode getLeft() {
		return left;
	}

	public BinaryTreeNode getRight() {
		return right;
	}

	public void setData(int data) {
		this.data = data;
	}

	public void setLeft(BinaryTreeNode left) {
		this.left = left;
	}

	public void setRight(BinaryTreeNode right) {
		this.right = right;
	}

	public String toString() {
		return String.valueOf(data);
	}
}
