package com.ccsu.cs.tutoring.algorithms;

public class BubbleSort<T extends Comparable<T>> {
	public int comparisons;
	public int exchanges;

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
}
