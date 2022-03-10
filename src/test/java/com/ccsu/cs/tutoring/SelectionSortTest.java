package com.ccsu.cs.tutoring;

import com.ccsu.cs.tutoring.algorithms.SelectionSort;
import org.junit.jupiter.api.Test; // for test annotations
import org.junit.jupiter.api.Assertions; // for tests themselves

public class SelectionSortTest {
	@Test
	void sortActuallyWorks() {
		SelectionSort<Integer> sort = new SelectionSort<>();
		Integer[] a = {10, 8, 5, 3, 6, 9, 1, 7, 2, 4}; // seq 10 | shuf
		sort.sort(a);
		for (int i = 1; i < a.length; i++) {
			Assertions.assertTrue(a[i - 1] < a[i]); // all elements are ascending
		}
	}

	@Test
	void inOrderIsQuadratic() { // O(n^2)
		SelectionSort<Integer> sort = new SelectionSort<>();
		Integer[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		sort.sort(a);
		Assertions.assertEquals(a.length * (a.length + 1) / 2 - 1, sort.comparisons); // 54
		Assertions.assertEquals(a.length - 1, sort.exchanges); // 9
	}

	@Test
	void reverseOrderIsQuadratic() { // O(n^2)
		SelectionSort<Integer> sort = new SelectionSort<>();
		Integer[] a = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		sort.sort(a);
		Assertions.assertEquals(a.length * (a.length + 1) / 2 - 1, sort.comparisons); // 54
		Assertions.assertEquals(a.length - 1, sort.exchanges); // 9
	}

	@Test
	void allCasesHaveSameComplexity() { // O(n^2)
		SelectionSort<Integer> sort1 = new SelectionSort<>();
		SelectionSort<Integer> sort2 = new SelectionSort<>();
		Integer[] a1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		Integer[] a2 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		sort1.sort(a1);
		sort2.sort(a2);
		Assertions.assertEquals(sort1.comparisons, sort2.comparisons); // 54
		Assertions.assertEquals(sort1.exchanges, sort2.exchanges); // 9
	}
}
