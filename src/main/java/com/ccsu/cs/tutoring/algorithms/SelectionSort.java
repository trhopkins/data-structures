package com.ccsu.cs.tutoring.algorithms;

/**
 * Selection Sort algorithm.
 * @author Travis Reid Hopkins
 * @version 1.0.1
 */
public class SelectionSort<T extends Comparable<T>> {
	public int comparisons = 0;
	public int exchanges = 0;

	/**
	 * For each element, find the smallest unsorted element and swap
	 * them.
	 * @param a array to be sorted
	 * @return sorted array
	 */
	public T[] sort(T[] a) {
		T tmp;
		int min;
		for (int i = 0; i < a.length - 1; i++) {
			min = i;
			for (int j = i; j < a.length; j++) { // search for smallest element to swap with current
				if (a[j].compareTo(a[min]) < 0) {
					min = j;
				}
				comparisons++;
			}
			exchanges++;
			tmp = a[min];
			a[min] = a[i];
			a[i] = tmp;
		}
		return a;
	}
}
