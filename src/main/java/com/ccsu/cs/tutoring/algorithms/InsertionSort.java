package com.ccsu.cs.tutoring.algorithms;

/**
 * Insertion Sort algorithm.
 * @author Travis Reid Hopkins
 * @version 1.0.1
 */
public class InsertionSort<T extends Comparable<T>> {
	public int comparisons = 0;
	public int exchanges = 0;

	/**
	 * For each unsorted element, place it into the sorted area in the
	 * correct location, starting from the bottom.
	 * @param a array to be sorted
	 * @return sorted array
	 */
	public T[] sort(T[] a) {
		T tmp; // for swapping
		int j; // for shifting sorted elements upward
		for (int i = 1; i < a.length; i++) { // for all elements
			tmp = a[i];
			j = i - 1;
			comparisons++; // j >= 0
			while (j >= 0 && a[j].compareTo(tmp) > 0) { // shift upwards
				a[j + 1] = a[j];
				j--;
				comparisons++; // a[j] > tmp (short-circuiting &&)
				exchanges++; // depends on input
			}
			a[j + 1] = tmp; // swap operation completes here
		}
		return a;
	}
}
