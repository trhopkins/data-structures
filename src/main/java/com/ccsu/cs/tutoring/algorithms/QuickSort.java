package com.ccsu.cs.tutoring.algorithms;

public class QuickSort<T extends Comparable<T>> {
	public int comparisons = 0;
	public int exchanges = 0;

	public T[] sort(T[] a) {
		return quick(a, 0, a.length - 1);
	}

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



	private int partition(T[] a, int lo, int hi) {
		T pivot = a[lo];
		while (lo < hi) {
			while (pivot.compareTo(a[hi]) < 0 && lo < hi) {
				hi--;
				comparisons++;
			}
			if (hi != lo) {
				a[lo] = a[hi];
				lo++;
				exchanges++;
			}
			while (a[lo].compareTo(pivot) < 0 && lo < hi) {
				lo++;
				comparisons++;
			}
			if (hi != lo) {
				a[hi] = a[lo];
				hi--;
				exchanges++;
			}
		}
		a[hi] = pivot;
		return hi;
	}
}
