import java.io.*;
import java.util.*;

public class FirstIndex {

  public static void main(String[] args) throws Exception {
    // write your code here
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = Integer.parseInt(br.readLine());
    }
    int x = Integer.parseInt(br.readLine());
    if (a.length == 0)
      return;
    int firstIdxFound = firstIndex(a, 0, x);
    System.out.println(firstIdxFound + " <=  ");
  }

  public static int firstIndex(int[] arr, int idx, int x) {
    if (idx == arr.length)
      return -1;
    if (arr[idx] == x)
      return idx;
    return firstIndex(arr, idx + 1, x);
  }

}
