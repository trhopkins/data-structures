package com.ccsu.cs.tutoring.algorithms;

public class InsertionSort<T extends Comparable<T>> {
	public int comparisons;
	public int exchanges;

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
