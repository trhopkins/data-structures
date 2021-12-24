package com.ccsu.cs.tutoring;

import com.ccsu.cs.tutoring.structures.BinaryTree;

public class Main {
	public static void main(String[] args) {
		BinaryTree<Integer> tree = new BinaryTree<>();
		tree.insert(20);
		tree.insert(10);
		tree.insert(30);
		tree.insert(5);
		tree.insert(15);
		System.out.println("Before deleting 10:");
		System.out.println(tree);
		System.out.println("Deleted 10.");
		tree.delete(10);
		System.out.println("in order traversal after deletion:");
		tree.inOrderTraverse();
		System.out.println("pre order traversal after deletion:");
		tree.preOrderTraverse();
		System.out.println("post order traversal after deletion:");
		tree.postOrderTraverse();
		System.out.println("level order traversal after deletion:");
		tree.levelOrderTraverse();
	}
}
