import java.io.*;
import java.util.*;

public class SmallestNumberFollowingPattern {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();

    // code
    patternSolver(str);
  }

  public static void patternSolver(String str) {
    if (str.length() == 0)
      return;
    Stack<Integer> st = new Stack<>();
    StringBuilder sb = new StringBuilder("");
    st.push(1);
    int currDigit = 2;
    for (char ch : str.toCharArray()) {
      if (ch == 'i') {
        while (st.size() > 0) {
          sb.append(st.pop());
        }
      }
      st.push(currDigit++);
    }
    while (st.size() > 0) {
      sb.append(st.pop());
    }
    System.out.println("Answer => " + sb.toString());
  }
}