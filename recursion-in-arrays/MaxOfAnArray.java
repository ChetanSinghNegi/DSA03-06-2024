import java.io.*;
import java.util.*;

public class MaxOfAnArray {

  public static void main(String[] args) throws Exception {
    // write your code here
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = Integer.parseInt(br.readLine());
    }
    if (a.length == 0)
      return;
    int maxOfArray = maxOfArray(a, 0);
    System.out.println(maxOfArray + " <=  ");
  }

  public static int maxOfArray(int[] arr, int idx) {
    if (idx == arr.length)
      return Integer.MIN_VALUE;
    int tillMax = maxOfArray(arr, idx + 1);
    return Math.max(arr[idx], tillMax);
  }

}