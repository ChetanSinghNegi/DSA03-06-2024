import java.io.*;
import java.util.*;

public class DynamicStack {

  public static class CustomStack {

    int[] stack;
    int capacityOfStack;
    int tosIdx;

    public CustomStack(int n) {
      stack = new int[n];
      tosIdx = -1;
      capacityOfStack = n;
    }

    // O(1)
    int size() {
      return tosIdx + 1;
    }

    // O(1)
    void push(int data) {
      tosIdx++;
      if (tosIdx == capacityOfStack) {
        int[] bigStack = new int[(int) Math.floor(capacityOfStack * 1.5)];
        for (int i = 0; i < capacityOfStack; i++) {
          bigStack[i] = stack[i];
        }
        stack = bigStack;
      }
      stack[tosIdx] = data;
    }

    // O(1)
    int pop() {
      if (tosIdx == -1) {
        System.out.println("Stack underflow");
        return -1;
      }
      int tosValue = stack[tosIdx];
      stack[tosIdx--] = 0;

      // if(stack size has fallen to the point that capacity / 4 == noOfElements then
      // stack reduce to half of its capacity)
      if ((int) Math.floor(capacityOfStack / 4) == tosIdx) {
        int[] smallStack = new int[(int) Math.floor(capacityOfStack / 2)];
        for (int i = 0; i < capacityOfStack; i++) {
          smallStack[i] = stack[i];
        }
        stack = smallStack;
      }
      return tosValue;
    }

    // O(1)
    int peek() {
      if (tosIdx == -1) {
        System.out.println("Stack underflow");
        return -1;
      }
      int tosValue = stack[tosIdx];
      return tosValue;
    }

    void display() {
      for (int i = tosIdx; i >= 0; i--) {
        System.out.print(stack[i] + " ");
      }
      System.out.println();
    }

  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    CustomStack st = new CustomStack(n);

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
        int val = st.peek();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size")) {
        System.out.println(st.size());
      } else if (str.startsWith("display")) {
        st.display();
      }
      str = br.readLine();
    }
  }
}
