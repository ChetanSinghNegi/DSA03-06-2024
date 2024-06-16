import java.io.*;
import java.util.*;

public class Sort012 {

  public static void sort012(int[] arr) {
    // write your code here
    int stOf1 = 0;
    int stOf2 = 0;
    int n = arr.length;
    for (int i = 0; i < n; i++) {
      if (arr[i] == 1) {
        swap(arr, i, stOf2);
        stOf2++;
      } else if (arr[i] == 0) {
        swap(arr, i, stOf2);
        swap(arr, stOf2, stOf1);
        stOf1++;
        stOf2++;
      }
    }

  }

  // used for swapping ith and jth elements of array
  public static void swap(int[] arr, int i, int j) {
    System.out.println("Swapping index " + i + " and index " + j);
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    sort012(arr);
    print(arr);
  }

}