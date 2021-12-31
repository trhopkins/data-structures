package com.ccsu.cs.tutoring.sorts;

/**
 * Insertion Sort for integers.
 * @author Roland Van Duine
 * @version 1.0.0
 */

public class InsertionSort { // O(n^2)

  // The insertion sort is a simple sorting algorithm that repeatedly steps through the list,
  // compares adjacent elements and swaps them if they are in the wrong order.

  public static void insertionSort(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
      int j = i;
      while (j > 0 && arr[j] < arr[j - 1]) {
        int temp = arr[j];
        arr[j] = arr[j - 1];
        arr[j - 1] = temp;
        j--;
      }
    }
  }
}
