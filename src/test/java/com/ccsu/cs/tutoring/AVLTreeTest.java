package com.ccsu.cs.tutoring;

import com.ccsu.cs.tutoring.structures.AVLTree;
import com.ccsu.cs.tutoring.structures.BinaryTree;
import org.junit.jupiter.api.Test; // for Test annotations
import org.junit.jupiter.api.Assertions; // for tests themselves

public class AVLTreeTest {
	@Test
	void binaryTreeStartsEmpty() {
		AVLTree<Integer> tree = new AVLTree<>();
		Assertions.assertTrue(tree.empty());
	}

	@Test
	void addingFiveElementsMakesSizeFive() {
		AVLTree<Integer> tree = new AVLTree<>();
		tree.insert(5);
		tree.insert(2);
		tree.insert(9);
		tree.insert(1);
		tree.insert(0);
		Assertions.assertEquals(5, tree.size());
	}

	@Test
	void deletingElementsReducesSize() {
		int oldSize, newSize;
		AVLTree<Integer> tree = new AVLTree<>();
		tree.insert(5);
		tree.insert(2);
		tree.insert(9);
		oldSize = tree.size(); // 3
		tree.delete(2);
		newSize = tree.size(); // 2
		Assertions.assertTrue(oldSize > newSize);
	}

	@Test
	void rebalancePreventsHeightIncrease() {
		AVLTree<Integer> tree = new AVLTree<>();
		tree.insert(5); // height = 1
		tree.insert(7); // height = 2
		tree.insert(1); // height = 2
		tree.insert(9); // height = 3
		tree.insert(3); // height = 3
		Assertions.assertEquals(3, tree.height());
		tree.insert(4); // height = 3 after rebalance, 4 without
		Assertions.assertEquals(3, tree.height());
	}

	@Test
	void leftRebalancePreservesOrder() {
		AVLTree<Character> tree = new AVLTree<>();
		BinaryTree<Character> binTree = new BinaryTree<>();
		tree.insert('a');
		tree.insert('b');
		tree.insert('c'); // rebalance happens here
		binTree.insert('c');
		binTree.insert('b');
		binTree.insert('a'); // no rebalance occurs
		Assertions.assertEquals(2, tree.height());
		Assertions.assertEquals(3, binTree.height());
		Assertions.assertEquals(String.valueOf(tree), String.valueOf(binTree)); // default toStrings are in-order traversals
	}

	@Test
	void rightRebalancePreservesOrder() {
		AVLTree<Character> tree = new AVLTree<>();
		BinaryTree<Character> binTree = new BinaryTree<>();
		tree.insert('c');
		tree.insert('b');
		tree.insert('a'); // rebalance happens here
		binTree.insert('c');
		binTree.insert('b');
		binTree.insert('a'); // no rebalance occurs
		Assertions.assertEquals(2, tree.height());
		Assertions.assertEquals(3, binTree.height());
		Assertions.assertEquals(String.valueOf(tree), String.valueOf(binTree)); // default toStrings are in-order traversals
	}
}
