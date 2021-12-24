package com.ccsu.cs.tutoring;

import com.ccsu.cs.tutoring.structures.BinaryTree;
import org.junit.jupiter.api.Test; // for Test annotations
import org.junit.jupiter.api.Assertions; // for tests themselves

public class BinaryTreeTest {
	@Test
	void binaryTreeStartsEmpty() {
		BinaryTree<Integer> tree = new BinaryTree<>();
		Assertions.assertTrue(tree.empty());
	}

	@Test
	void addingFiveElementsMakesSizeFive() {
		BinaryTree<Integer> tree = new BinaryTree<>();
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
		BinaryTree<Integer> tree = new BinaryTree<>();
		tree.insert(5);
		tree.insert(2);
		tree.insert(9);
		oldSize = tree.size(); // 3
		tree.delete(2);
		newSize = tree.size(); // 2
		Assertions.assertTrue(oldSize > newSize);
	}

	@Test
	void toStringWorksForIntegers() { // preOrder
		BinaryTree<Integer> tree = new BinaryTree<>();
		tree.insert(5);
		tree.insert(7);
		tree.insert(9);
		tree.insert(1);
		tree.insert(3);
		Assertions.assertEquals("1\n3\n5\n7\n9\n", tree.toString()); // in-order result
	}
}