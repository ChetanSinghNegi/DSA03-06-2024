import java.io.*;
import java.util.*;

public class QueueToStackAdapterPopEfficient {

  public static class QueueToStackAdapter {
    Queue<Integer> mainQ;
    Queue<Integer> helperQ;

    public QueueToStackAdapter() {
      mainQ = new ArrayDeque<>();
      helperQ = new ArrayDeque<>();
    }

    int size() {
      // O(1)
      return mainQ.size();
    }

    void push(int val) {
      // O(n)
      helperQ = mainQ;
      mainQ = new ArrayDeque<>();
      mainQ.add(val);
      while (helperQ.size() > 0) {
        int removedEle = helperQ.remove();
        mainQ.add(removedEle);
      }
    }

    int pop() {
      // O(1)
      if (mainQ.size() == 0) {
        System.out.println("Queue Underflow");
        return -1;
      }
      return mainQ.remove();
    }

    int top() {
      // O(1)

      if (mainQ.size() == 0) {
        System.out.println("Queue Underflow");
        return -1;
      }
      return mainQ.peek();
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    QueueToStackAdapter st = new QueueToStackAdapter();

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
      }
      str = br.readLine();
    }
  }
}
