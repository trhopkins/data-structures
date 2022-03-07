package com.ccsu.cs.tutoring;

import com.ccsu.cs.tutoring.algorithms.QuickSort;
import org.junit.jupiter.api.Test; // for test annotations
import org.junit.jupiter.api.Assertions; // for tests themselves

public class QuickSortTest {
	@Test
	void sortActuallyWorks() {
		QuickSort<Integer> sort = new QuickSort<>();
		Integer[] a = {10, 8, 5, 3, 6, 9, 1, 7, 2, 4}; // seq 10 | shuf
		sort.sort(a);
		for (int i = 1; i < a.length; i++) {
			Assertions.assertTrue(a[i - 1] < a[i]); // all elements are ascending
		}
	}
}
