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
    // write your code here
    int n = a.length;
    for (int i = 0; i < n; i++) {
      int right = n - 1 - i;
      if (i >= right)
        break;
      int temp = a[i];
      a[i] = a[right];
      a[right] = temp;
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