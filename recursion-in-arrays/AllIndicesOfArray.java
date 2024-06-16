import java.io.*;
import java.util.*;

public class AllIndicesOfArray {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }
    int x = Integer.parseInt(br.readLine());
    int[] iarr = allIndices(arr, x, 0, 0);

    if (iarr.length == 0) {
      System.out.println();
      return;
    }

    System.out.println("Results");

    for (int i = 0; i < iarr.length; i++) {
      System.out.println(iarr[i]);
    }
  }

  public static int[] allIndices(int[] arr, int x, int idx, int fsf) {
    // write ur code here
    if (idx == arr.length) {
      return new int[fsf];
    }

    boolean currentIdxValid = false;
    int fsfClone = fsf;
    if (arr[idx] == x) {
      currentIdxValid = true;
      fsfClone++;
    }
    int[] foundIdxs = allIndices(arr, x, idx + 1, fsfClone);
    if (currentIdxValid) {
      foundIdxs[fsf] = idx;
    }
    return foundIdxs;

  }

}