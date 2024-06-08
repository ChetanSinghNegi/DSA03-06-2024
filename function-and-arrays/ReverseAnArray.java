import java.io.*;
import java.util.*;

public class ReverseAnArray {
  public static void display(int[] a) {
    StringBuilder sb = new StringBuilder();

    for (int val : a) {
      sb.append(val + " ");
    }
    System.out.println(sb);
  }

  public static void reverse(int[] a) {
    int n = a.length;
    int li = 0;
    int ri = n - 1;
    while (li < ri) {
      int temp = a[li];
      a[li] = a[ri];
      a[ri] = temp;
      li++;
      ri--;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Enter size of array");
    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      System.out.println("Enter element of array");
      a[i] = Integer.parseInt(br.readLine());
    }

    reverse(a);
    display(a);
  }

}