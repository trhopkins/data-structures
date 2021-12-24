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
		System.out.println("toString:");
		System.out.print(tree);
		System.out.println("in order traversal:");
		tree.inOrderTraverse();
		System.out.println("pre order traversal:");
		tree.preOrderTraverse();
		System.out.println("post order traversal:");
		tree.postOrderTraverse();
		System.out.println("level order traversal:");
		tree.levelOrderTraverse();
	}
}
