import java.io.*;
import java.util.*;

public class LargestAreaHistogram {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = Integer.parseInt(br.readLine());
    }

    // code
    LAHFunc(a);
  }

  public static void LAHFunc(int[] arr) {
    int n = arr.length;
    int[] prevSmaller = new int[n];
    Stack<Integer> st = new Stack<>();
    for (int i = 0; i < n; i++) {
      if (i == 0) {
        prevSmaller[i] = 1;
        st.push(i);
        continue;
      }
      while (st.size() > 0 && arr[st.peek()] > arr[i]) {
        st.pop();
      }
      if (st.size() == 0) {
        prevSmaller[i] = i + 1;
      } else {
        prevSmaller[i] = i - st.peek();
      }
      st.push(i);
    }
    st = new Stack<>();
    int[] nextSmaller = new int[n];
    for (int i = n - 1; i >= 0; i--) {
      if (i == n - 1) {
        st.push(i);
        nextSmaller[i] = 1;
        continue;
      }
      while (st.size() > 0 && arr[st.peek()] > arr[i]) {
        st.pop();
      }
      if (st.size() == 0) {
        nextSmaller[i] = n - i;
      } else {
        nextSmaller[i] = st.peek() - i;
      }
      st.push(i);
    }
    int[] area = new int[n];
    int maxArea = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      area[i] = (prevSmaller[i] + nextSmaller[i] - 1) * arr[i];
      maxArea = Math.max(maxArea, area[i]);
    }
    System.out.println("Answer => " + maxArea);
    return;
  }
}
