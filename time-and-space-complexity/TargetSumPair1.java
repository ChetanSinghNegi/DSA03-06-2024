
import java.io.*;
import java.util.*;

public class TargetSumPair1 {

  public static void targetSumPair(int[] arr, int target) {
    // write your code here
    int n = arr.length;
    int li = 0;
    Arrays.sort(arr);
    int ri = n - 1;
    while (li < ri) {
      int sum = arr[li] + arr[ri];
      if (sum == target) {
        System.out.println(arr[li] + "  " + arr[ri]);
        li++;
        ri--;
      } else if (sum < target) {
        li++;
      } else {
        ri--;
      }
    }
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    int target = scn.nextInt();
    targetSumPair(arr, target);
  }

}