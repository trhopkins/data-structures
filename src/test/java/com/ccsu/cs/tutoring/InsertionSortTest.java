package com.ccsu.cs.tutoring;

import com.ccsu.cs.tutoring.algorithms.InsertionSort;
import org.junit.jupiter.api.Test; // for test annotations
import org.junit.jupiter.api.Assertions; // for tests themselves

public class InsertionSortTest {
	@Test
	void sortActuallyWorks() {
		InsertionSort<Integer> sort = new InsertionSort<>();
		Integer[] a = {10, 8, 5, 3, 6, 9, 1, 7, 2, 4}; // seq 10 | shuf
		sort.sort(a);
		for (int i = 1; i < a.length; i++) {
			Assertions.assertTrue(a[i - 1] < a[i]); // all elements are ascending
		}
	}

	@Test
	void inOrderIsLinear() { // \Omega(n) due to swap test optimization
		InsertionSort<Integer> sort = new InsertionSort<>();
		Integer[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		sort.sort(a);
		Assertions.assertEquals(a.length - 1, sort.comparisons);
		Assertions.assertEquals(0, sort.exchanges);
	}

	@Test
	void reverseOrderIsQuadratic() { // O(n^2)
		InsertionSort<Integer> sort = new InsertionSort<>();
		Integer[] a = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		sort.sort(a);
		Assertions.assertEquals(a.length * (a.length + 1) / 2 - 1, sort.comparisons); // 54
		Assertions.assertEquals(a.length * (a.length + 1) / 2 - 10, sort.exchanges); // 45
	}

}