import java.io.*;
import java.util.*;

public class RotateAnArray {
  public static void display(int[] a) {
    StringBuilder sb = new StringBuilder();

    for (int val : a) {
      sb.append(val + " ");
    }
    System.out.println(sb);
  }

  public static void rotate(int[] a, int k) {
    // write your code here
    int n = a.length;
    int mid = n - k;
    reverse(a, 0, mid - 1);
    reverse(a, mid, n - 1);
    reverse(a, 0, n - 1);
  }

  public static void reverse(int[] a, int li, int ri) {
    while (li < ri) {
      int temp = a[li];
      a[li] = a[ri];
      a[ri] = temp;
      ri--;
      li++;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = Integer.parseInt(br.readLine());
    }
    int k = Integer.parseInt(br.readLine());

    rotate(a, k);
    display(a);
  }

}
