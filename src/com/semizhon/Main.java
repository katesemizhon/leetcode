package com.semizhon;

import java.util.HashSet;
import java.util.Set;

public class Main {

  public static void main(String[] args) {

    Set<Integer> set = new HashSet<Integer>();

    int[] sortedArray = twoSum(new int[] {3, 2, 4}, 6);
    for (int i : sortedArray) {
      System.out.print(i);
    }
  }

  public static void testBitOps() {
    int i = 1 & 3;
    System.out.println("1&2 = " + i);
    int i1 = 1 | 3;

    System.out.println("1 | 3 = " + i1);
    int i2 = 1 ^ 3;
    System.out.println("1 ^ 3 = " + i2);

    int number = 212;

    System.out.println(number << 1);
    System.out.println(number << 0);
    System.out.println(number << 4);
  }

  public static int[] twoSum(int[] nums, int target) {
    int sum = 0;
    int index1 = -1;
    int index2 = -1;
    int[] result = new int[2];

    boolean found = false;
    for (int i = 0; i < nums.length && !found; i++) {
      if (nums[i] < target) {
        for (int j = i + 1; j < nums.length && !found; j++) {
          if (nums[i] + nums[j] == target) {
            index1 = i;
            index2 = j;
            found = true;
          }
        }
      } else {
        break;
      }
    }
    if (index1 > -1) {

      result = new int[] {index1, index2};
    }

    return result;
  }

  public static int[] sort(int[] nums, int i1, int i2) {
    if (i2 > i1) {
      int p = partition(nums, i1, i2);
      sort(nums, i1, p - 1);
      sort(nums, p + 1, i2);
    }
    return nums;
  }

  public static int partition(int[] nums, int i1, int i2) {
    int pivot = nums[i2];
    int pivotIndex = i2;

    for (int j = i1; j < i2; j++) {
      if (nums[j] < pivot) {
        if (j > pivotIndex) {
          pivotIndex = swap(nums, pivot, pivotIndex, j);
        }
      } else if (nums[j] > pivot) {
        if (j < pivotIndex) {
          pivotIndex = swap(nums, pivot, pivotIndex, j);
        }
      }
    }
    return pivotIndex;
  }

  private static int swap(int[] nums, int pivot, int pivotIndex, int j) {
    nums[pivotIndex] = nums[j];
    nums[j] = pivot;
    pivotIndex = j;
    return pivotIndex;
  }
}
