package com.ccsu.cs.tutoring.algorithms;

public class SelectionSort<T extends Comparable<T>> {
	public int comparisons;
	public int exchanges;

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
			tmp = a[min];
			a[min] = a[i];
			a[i] = tmp;
			exchanges++;
		}
		return a;
	}
}
