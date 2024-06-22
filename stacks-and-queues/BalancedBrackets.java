import java.io.*;
import java.util.*;

public class BalancedBrackets {

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    String str = scn.nextLine();
    scn.close();
    Stack<Character> st = new Stack<>();
    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      if (ch == ')' || ch == '}' || ch == ']') {
        if ((ch == ')' && (st.size() == 0 || st.peek() != '(')) || (ch == '}' && (st.size() == 0 || st.peek() != '{'))
            || (ch == ']' && (st.size() == 0 || st.peek() != '['))) {
          System.out.println("Not Balanced");
          return;
        }
        st.pop();
      } else if (ch == '(' || ch == '{' || ch == '[') {
        st.push(ch);
      } else {
        continue;
      }
    }
    if (st.size() > 0) {
      System.out.println("Not Balanced");
      return;
    }
    System.out.println("Balanced");
  }

}