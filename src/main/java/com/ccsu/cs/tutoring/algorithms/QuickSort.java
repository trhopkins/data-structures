package com.ccsu.cs.tutoring.algorithms;

/**
 * Quick Sort algorithm. Pivot points start with the left and right
 * side, then go inwards.
 * @author Travis Reid Hopkins
 * @version 1.0.0
 */
public class QuickSort<T extends Comparable<T>> {
	public int comparisons = 0;
	public int exchanges = 0;

	/**
	 * Sort array using quickSort.
	 * @param a array to sort
	 * @return sorted array
	 */
	public T[] sort(T[] a) {
		return quick(a, 0, a.length - 1);
	}

	/**
	 * Partition the array, then partition the lo and hi sections if any
	 * remain.
	 * @param a array to be sorted
	 * @param lo boundary
	 * @param hi boundary
	 * @return sorted array
	 */
    private T[] quick(T[] a, int lo, int hi) {
        int pivotPoint = partition(a, lo, hi);
        if (lo < pivotPoint) {
            quick(a, lo, pivotPoint-1);
        }
        if (pivotPoint < hi) {
            quick(a, pivotPoint+1, hi);
        }
		return a;
    }

	/**
	 * Take an array or subarray, choose a pivot element (here it is lo)
	 * and move all lower elements left, and all higher elements right.
	 * @param a array to sort
	 * @param lo lowest element to include in sort
	 * @param hi highest element to include in sort
	 * @return location of highest element after shifting
	 */
	private int partition(T[] a, int lo, int hi) {
		T pivot = a[lo]; // lower elements left, all higher on right
		while (lo < hi) {
			while (pivot.compareTo(a[hi]) < 0 && lo < hi) { // get higher elements
				hi--;
				comparisons++;
			}
			if (hi != lo) { // move higher elements right
				a[lo] = a[hi];
				lo++;
				exchanges++;
			}
			while (a[lo].compareTo(pivot) < 0 && lo < hi) { // get lower elements
				lo++;
				comparisons++;
			}
			if (hi != lo) { // move lower elements left
				a[hi] = a[lo];
				hi--;
				exchanges++;
			}
		}
		a[hi] = pivot; // insert pivot back
		return hi;
	}
}
