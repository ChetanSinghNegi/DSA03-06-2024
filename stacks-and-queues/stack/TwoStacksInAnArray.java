import java.io.*;
import java.util.*;

public class TwoStacksInAnArray {

  public static class TwoStack {
    int[] data;
    int tos1;
    int tos2;

    public TwoStack(int cap) {
      // O(1)
      data = new int[cap];
      tos1 = -1;
      tos2 = cap;
    }

    int size1() {
      // O(1)
      return tos1 + 1;
    }

    int size2() {
      // O(1)
      return data.length - tos2;
    }

    void push1(int val) {
      // O(1)
      if (tos1 + 1 >= tos2) {
        System.out.println("Stack Overflow");
        return;
      }
      data[++tos1] = val;
    }

    void push2(int val) {
      // O(1)
      if (tos1 >= tos2 - 1) {
        System.out.println("Stack Overflow");
        return;
      }
      data[--tos2] = val;

    }

    int pop1() {
      // O(1)
      if (tos1 < 0) {
        System.out.println("Stack Underflow");
        return -1;
      }
      int removedEle = data[tos1];
      data[tos1--] = 0;
      return removedEle;
    }

    int pop2() {
      // O(1)
      if (tos2 >= data.length) {
        System.out.println("Stack Underflow");
        return -1;
      }
      int removedEle = data[tos2];
      data[tos2++] = 0;
      return removedEle;
    }

    int top1() {
      // O(1)
      if (tos1 < 0) {
        System.out.println("Stack Underflow");
        return -1;
      }
      int topEle = data[tos1];
      return topEle;
    }

    int top2() {
      // O(1)
      if (tos2 >= data.length) {
        System.out.println("Stack Underflow");
        return -1;
      }
      int topEle = data[tos2];
      return topEle;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    TwoStack st = new TwoStack(n);

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("push1")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        st.push1(val);
      } else if (str.startsWith("pop1")) {
        int val = st.pop1();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("top1")) {
        int val = st.top1();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size1")) {
        System.out.println(st.size1());
      } else if (str.startsWith("push2")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        st.push2(val);
      } else if (str.startsWith("pop2")) {
        int val = st.pop2();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("top2")) {
        int val = st.top2();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size2")) {
        System.out.println(st.size2());
      }
      str = br.readLine();
    }
  }
}
