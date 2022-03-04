package com.ccsu.cs.tutoring.algorithms;

public class BubbleSort<T extends Comparable<T>> {
    public int comparisons;
    public int exchanges;

    public T[] sort(T[] a) {
        boolean swapped = true; // shortcut to speed up bubble
        T tmp; // for swaps
        for (int i = 1; i < a.length; i++) {
            if (swapped) {
                swapped = false;
                for (int j = 0; j < a.length - i; j++) { // bubble up
                    comparisons++;
                    if (a[j].compareTo(a[j+1]) > 0) {
                        exchanges++;
                        tmp = a[j];
                        a[j] = a[j+1];
                        a[j+1] = tmp;
                        swapped = true;
                    }
                }
            } else { // skip redundant comparisons
                break;
            }
        }
        return a;
    }
}
