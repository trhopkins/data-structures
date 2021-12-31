package com.ccsu.cs.tutoring.sorts;

/**
 * Bubble Sort for integers.
 * @author Roland Van Duine
 * @version 1.0.0
 */
public class BubbleSort { // O(n^2)

  // THe bubble sort is a simple sorting algorithm that repeatedly steps through the list,
  // compares adjacent elements and swaps them if they are in the wrong order.
  // The pass through the list is repeated until the list is sorted.

  public static void bubbleSort(int[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
      for (int j = 0; j < arr.length - 1 - i; j++) {
        if (arr[j] > arr[j + 1]) {
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
        }
      }
    }
  }
}
