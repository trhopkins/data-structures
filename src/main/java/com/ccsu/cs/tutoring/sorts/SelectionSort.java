package com.ccsu.cs.tutoring.sorts;

/**
 * Selection Sort for integers.
 * @author Roland Van Duine
 * @version 1.0.0
 */

public class SelectionSort { // O(n^2)

  // The selection sort is a simple sorting algorithm that repeatedly steps through the list,
  // compares adjacent elements and swaps them if they are in the wrong order.
  // The pass through the list is repeated until the list is sorted.

  public static void selectionSort(int[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
      int min = i;
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[j] < arr[min]) {
          min = j;
        }
      }
      int temp = arr[i];
      arr[i] = arr[min];
      arr[min] = temp;
    }
  }
}
