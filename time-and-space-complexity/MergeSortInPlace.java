import java.io.*;
import java.util.*;

public class MergeSortInPlace {

  public static void mergeSort(int[] arr, int lo, int hi) {
    // write your code here

    if (lo == hi)
      return;

    int mid = (lo + hi) / 2;
    mergeSort(arr, lo, mid);
    mergeSort(arr, mid + 1, hi);

    // getting sorted array between indexes
    int[] mergedArray = mergeTwoSortedArrays(lo, mid, hi, arr);

    // putting back elements in original array from mergedSortedArray
    int currIdx = lo;
    for (int i = 0; i < mergedArray.length; i++) {
      arr[currIdx++] = mergedArray[i];
    }

  }

  public static int[] mergeTwoSortedArrays(int lo1, int mid, int hi2, int[] a) {
    int hi1 = mid;
    int lo2 = mid + 1;
    int itr = 0;
    int[] res = new int[hi2 - lo1 + 1];
    while (lo1 <= hi1 && lo2 <= hi2) {
      if (a[lo1] <= a[lo2]) {
        res[itr++] = a[lo1++];
      } else {
        res[itr++] = a[lo2++];
      }
    }
    while (lo1 <= hi1) {
      res[itr++] = a[lo1++];
    }
    while (lo2 <= hi2) {
      res[itr++] = a[lo2++];
    }
    return res;
  }

  public static void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    scn.close();
    mergeSort(arr, 0, arr.length - 1);
    System.out.print("Sorted Array -> ");
    print(arr);
  }

}