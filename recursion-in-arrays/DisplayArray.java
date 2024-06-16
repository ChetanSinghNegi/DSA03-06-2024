
import java.io.*;
import java.util.*;

public class DisplayArray {

  public static void main(String[] args) throws Exception {
    // write your code here
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = Integer.parseInt(br.readLine());
    }
    displayArr(a, 0);

  }

  public static void displayArr(int[] arr, int idx) {
    if (idx == arr.length) {
      return;
    }
    System.out.println(arr[idx]);
    displayArr(arr, idx + 1);
    return;
  }

}