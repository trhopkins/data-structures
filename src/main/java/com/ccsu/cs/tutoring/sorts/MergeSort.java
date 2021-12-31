package com.ccsu.cs.tutoring.sorts;

/**
 * Merge Sort for integers.
 * @author Roland Van Duine
 * @version 1.0.0
 */

public class MergeSort { //O(nlogn)

  // The merge sort is a divide and conquer algorithm that recursively splits the list into
  // smaller sublists until each sublist contains a single element.
  // Then, the merge sort combines the sublists back into a sorted list.

  public static void mergeSort(int[] arr) {
    if (arr.length > 1) {
      int mid = arr.length / 2;
      int[] left = new int[mid];
      int[] right = new int[arr.length - mid];

      for (int i = 0; i < mid; i++) {
        left[i] = arr[i];
      }

      for (int i = mid; i < arr.length; i++) {
        right[i - mid] = arr[i];
      }

      mergeSort(left);
      mergeSort(right);
      merge(left, right, arr);
    }
  }

  private static void merge(int[] left, int[] right, int[] arr) {
    int i = 0;
    int j = 0;
    int k = 0;

    while (i < left.length && j < right.length) {
      if (left[i] < right[j]) {
        arr[k++] = left[i++];
      } else {
        arr[k++] = right[j++];
      }
    }

    while (i < left.length) {
      arr[k++] = left[i++];
    }

    while (j < right.length) {
      arr[k++] = right[j++];
    }
  }
}
