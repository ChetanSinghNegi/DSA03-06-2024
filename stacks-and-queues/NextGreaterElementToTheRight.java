import java.io.*;
import java.util.*;

public class NextGreaterElementToTheRight {
  public static void display(int[] a) {
    System.out.println("Answer => ");
    StringBuilder sb = new StringBuilder();

    for (int val : a) {
      sb.append(val + "\n");
    }
    System.out.println(sb);
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = Integer.parseInt(br.readLine());
    }

    int[] nge1 = solve1(a);
    int[] nge2 = solve2(a);
    display(nge1);
    display(nge2);
  }

  // Mera next greater kon hai Tarika
  public static int[] solve1(int[] arr) {
    // solve
    int n = arr.length;
    int[] ans = new int[n];
    Stack<Integer> st = new Stack<>();
    for (int i = n - 1; i >= 0; i--) {
      int num = arr[i];
      if (i == n - 1) {
        ans[i] = -1;
        st.push(num);
        continue;
      }

      // finding greater element in stack top
      while (st.size() > 0 && num > st.peek()) {
        st.pop();
      }
      if (st.size() == 0) {
        ans[i] = -1;
      } else {
        ans[i] = st.peek();
      }
      st.push(num);
    }
    return ans;
  }

  // mai kiska hu next greater Tarika
  public static int[] solve2(int[] arr) {

    int n = arr.length;
    int[] ans = new int[n];
    Stack<Integer> st = new Stack<>();
    for (int i = 0; i < n; i++) {
      int num = arr[i];
      while (st.size() > 0 && num > arr[st.peek()]) {
        int poppedIdx = st.pop();
        ans[poppedIdx] = num;
      }
      st.push(i);
    }
    while (st.size() > 0) {
      int idx = st.pop();
      ans[idx] = -1;
    }
    return ans;
  }

}