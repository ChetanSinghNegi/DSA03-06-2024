import java.io.*;
import java.util.*;

public class MinimumStackConstantSpace {

  public static class MinStack {
    Stack<Integer> data;
    int min;

    public MinStack() {
      data = new Stack<>();
      min = Integer.MAX_VALUE;
    }

    int size() {
      // write your code here
      return data.size();
    }

    void push(int val) {
      // write your code here
      if (val <= min) {
        data.push(min);
        min = val;
      }
      data.push(val);
    }

    int pop() {
      // write your code here
      if (data.size() == 0) {
        System.out.println("Stack Underflow");
        return -1;
      }
      int topData = data.pop();
      if (topData == min) {
        min = data.pop();
      }
      return topData;
    }

    int top() {
      // write your code here
      if (data.size() == 0) {
        System.out.println("Stack Underflow");
        return -1;
      }
      return data.peek();
    }

    int min() {
      // write your code here
      if (data.size() == 0) {
        System.out.println("Stack Underflow");
        return -1;
      }
      return min;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    MinStack st = new MinStack();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("push")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        st.push(val);
      } else if (str.startsWith("pop")) {
        int val = st.pop();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("top")) {
        int val = st.top();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size")) {
        System.out.println(st.size());
      } else if (str.startsWith("min")) {
        int val = st.min();
        if (val != -1) {
          System.out.println(val);
        }
      }
      str = br.readLine();
    }
  }
}