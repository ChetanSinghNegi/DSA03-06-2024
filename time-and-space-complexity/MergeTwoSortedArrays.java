import java.io.*;
import java.util.*;

public class MergeTwoSortedArrays {

  public static int[] mergeTwoSortedArrays(int[] a, int[] b) {
    // write your code here
    int n1 = a.length;
    int n2 = b.length;
    int itr = 0;
    int itr1 = 0;
    int itr2 = 0;
    int[] mergedArray = new int[n1 + n2];
    while (itr1 < n1 && itr2 < n2) {
      int min = Math.min(a[itr1], b[itr2]);
      if (min == a[itr1])
        itr1++;
      else if (min == b[itr2])
        itr2++;
      mergedArray[itr++] = min;
    }
    if (itr1 != n1) {
      for (int i = itr1; i < n1; i++) {
        mergedArray[itr++] = a[i];
      }
    } else if (itr2 != n2) {
      for (int i = itr2; i < n2; i++) {
        mergedArray[itr++] = b[i];
      }
    }

    return mergedArray;
  }

  public static void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = scn.nextInt();
    }
    int m = scn.nextInt();
    int[] b = new int[m];
    for (int i = 0; i < m; i++) {
      b[i] = scn.nextInt();
    }
    int[] mergedArray = mergeTwoSortedArrays(a, b);
    System.out.println();
    System.out.println();
    System.out.println();
    print(mergedArray);
  }

}