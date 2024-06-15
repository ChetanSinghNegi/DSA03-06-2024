
import java.io.*;
import java.util.*;

public class Sort01 {

  public static void sort01(int[] arr) {
    // write your code here
    int startingIdx1 = 0;
    int n = arr.length;
    for (int i = 0; i < n; i++) {
      if (arr[i] == 0) {
        swap(arr, i, startingIdx1);

        // increasing 1's area
        startingIdx1++;
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
    sort01(arr);
    print(arr);
  }

}