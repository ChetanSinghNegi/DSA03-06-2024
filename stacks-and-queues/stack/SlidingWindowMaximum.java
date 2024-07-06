import java.io.*;
import java.util.*;

public class SlidingWindowMaximum {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = Integer.parseInt(br.readLine());
    }
    int k = Integer.parseInt(br.readLine());

    // code
    int[] ans = slidingWindowFunc(a, k);
    System.out.println("Answer");
    System.out.println(Arrays.toString(ans));
  }

  public static int[] slidingWindowFunc(int[] arr, int k) {
    int[] nse = nextGreaterFunc(arr);
    int n = arr.length;
    int[] ans = new int[n - k + 1];
    int idx = 0;
    for (int i = 0; i <= n - k; i++) {
      if (idx < i)
        idx = i;
      while (nse[idx] < i + k) {
        idx = nse[idx];
      }
      ans[i] = arr[idx];
    }
    return ans;
  }

  public static int[] nextGreaterFunc(int[] arr) {
    int n = arr.length;
    int[] ans = new int[n];
    Stack<Integer> st = new Stack<>();
    for (int i = 0; i < n; i++) {
      int num = arr[i];
      while (st.size() > 0 && num > arr[st.peek()]) {
        int poppedIdx = st.pop();
        ans[poppedIdx] = i;
      }
      st.push(i);
    }
    while (st.size() > 0) {
      int idx = st.pop();
      ans[idx] = Integer.MAX_VALUE;
    }
    return ans;
  }
}
