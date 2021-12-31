package com.ccsu.cs.tutoring.sorts;

/**
 * Counting Sort for integers.
 * @author Roland Van Duine
 * @version 1.0.0
 */

public class CountingSort { // O(n + k)

  // The counting sort is a simple sorting algorithm that repeatedly steps through the list,
  // counts the number of items that have each value, and stores these counts in a second list.
  // After this, the second list is used to rearrange the original list.

  // One thing to note is that the Counting Sort is not comparison-based.

  public static void countingSort(int[] arr) {
    int max = arr[0];
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] > max) {
        max = arr[i];
      }
    }

    int[] count = new int[max + 1];
    for (int i = 0; i < arr.length; i++) {
      count[arr[i]]++;
    }

    int index = 0;
    for (int i = 0; i < count.length; i++) {
      while (count[i] > 0) {
        arr[index++] = i;
        count[i]--;
      }
    }
  }
}
