import java.io.*;
import java.util.*;

public class QuickSort {

  public static void quickSort(int[] arr, int lo, int hi) {
    // write your code here
    if (lo >= hi)
      return;
    int sortedIdx = partition(arr, arr[hi], lo, hi);
    quickSort(arr, lo, sortedIdx - 1);
    quickSort(arr, sortedIdx + 1, hi);
  }

  public static int partition(int[] arr, int pivot, int lo, int hi) {
    System.out.println("pivot -> " + pivot);
    int firstGreaterIdx = lo;
    for (int i = lo; i <= hi; i++) {
      if (arr[i] <= pivot) {
        swap(arr, i, firstGreaterIdx);
        firstGreaterIdx++;
      }
    }
    System.out.println("pivot index -> " + (firstGreaterIdx - 1));
    return firstGreaterIdx - 1;
  }

  // used for swapping ith and jth elements of array
  public static void swap(int[] arr, int i, int j) {
    System.out.println("Swapping " + arr[i] + " and " + arr[j]);
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
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
    quickSort(arr, 0, arr.length - 1);
    print(arr);
  }

}
