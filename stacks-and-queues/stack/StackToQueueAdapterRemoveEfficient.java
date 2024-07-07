import java.io.*;
import java.util.*;

public class StackToQueueAdapterRemoveEfficient {

  public static class StackToQueueAdapter {
    Stack<Integer> mainS;
    Stack<Integer> helperS;

    public StackToQueueAdapter() {
      mainS = new Stack<>();
      helperS = new Stack<>();
    }

    int size() {
      // O(1)
      return mainS.size();
    }

    void add(int val) {
      // O(n)
      while (mainS.size() > 0) {
        int removedEle = mainS.pop();
        helperS.push(removedEle);
      }
      mainS.push(val);
      while (helperS.size() > 0) {
        int removedEle = helperS.pop();
        mainS.push(removedEle);
      }
    }

    int remove() {
      // O(1)
      if (mainS.size() == 0) {
        System.out.println("Queue Underflow");
        return -1;
      }
      return mainS.pop();
    }

    int peek() {
      // O(1)
      if (mainS.size() == 0) {
        System.out.println("Queue Underflow");
        return -1;
      }
      return mainS.peek();
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StackToQueueAdapter qu = new StackToQueueAdapter();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("add")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        qu.add(val);
      } else if (str.startsWith("remove")) {
        int val = qu.remove();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("peek")) {
        int val = qu.peek();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size")) {
        System.out.println(qu.size());
      }
      str = br.readLine();
    }
  }
}