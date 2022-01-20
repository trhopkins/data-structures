package com.ccsu.cs.tutoring;

import com.ccsu.cs.tutoring.structures.AVLTree;
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
}
