package com.ccsu.cs.tutoring.algorithms;

/**
 * Bubble Sort algorithm.
 * @author Travis Reid Hopkins
 * @version 1.0.1
 */
public class BubbleSort<T extends Comparable<T>> {
	public int comparisons = 0;
	public int exchanges = 0;

	/**
	 * Swap each element upward until it reaches the top of the unsorted
	 * elements, like bubbles.
	 * @param a array to be sorted
	 * @return sorted array
	 */
	public T[] sort(T[] a) {
		boolean swapped = true; // shortcut to speed up bubble
		T tmp; // for swaps
		for (int i = 1; i < a.length; i++) {
			if (swapped) { // avoid redundancy
				swapped = false;
				for (int j = 0; j < a.length - i; j++) {
					comparisons++;
					if (a[j].compareTo(a[j+1]) > 0) { // bubble up
						exchanges++;
						//swap(a[j], a[j + 1]);
						tmp = a[j];
						a[j] = a[j+1];
						a[j+1] = tmp;
						swapped = true; // new place to swap up to
					}
				}
			} else { // redundant, we've been here before
				break;
			}
		}
		return a;
	}

	private void swap(T l, T r) {
		T tmp = l;
		l = r;
		r = tmp;
	}
}
