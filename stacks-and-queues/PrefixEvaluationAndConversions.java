import java.io.*;
import java.util.*;

public class PrefixEvaluationAndConversions {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();
    infixEval(exp);
    infixConversion(exp);
    postfixConversion(exp);
    // code
  }

  public static void infixEval(String str) {
    Stack<Integer> operand = new Stack<>();
    for (int i = str.length() - 1; i >= 0; i--) {
      char ch = str.charAt(i);
      if (ch == ' ')
        continue;
      else if (ch >= '0' && ch <= '9') {
        operand.push(ch - '0');
      } else {
        int a = operand.pop();
        int b = operand.pop();
        int currRes = infixEvalSolver(a, b, ch);
        operand.push(currRes);
      }
    }
    System.out.println("result => " + operand.pop());
  }

  public static void infixConversion(String str) {
    Stack<String> operand = new Stack<>();
    for (int i = str.length() - 1; i >= 0; i--) {
      char ch = str.charAt(i);
      if (ch == ' ')
        continue;
      else if (ch >= '0' && ch <= '9') {
        operand.push(ch + "");
      } else {
        String a = operand.pop();
        String b = operand.pop();
        String currRes = infixConvSolver(a, b, ch);
        operand.push(currRes);
      }
    }
    System.out.println("result => " + operand.pop());
  }

  public static void postfixConversion(String str) {
    Stack<String> operand = new Stack<>();
    for (int i = str.length() - 1; i >= 0; i--) {
      char ch = str.charAt(i);
      if (ch == ' ')
        continue;
      else if (ch >= '0' && ch <= '9') {
        operand.push(ch + "");
      } else {
        String a = operand.pop();
        String b = operand.pop();
        String currRes = postfixConvSolver(a, b, ch);
        operand.push(currRes);
      }
    }
    System.out.println("result => " + operand.pop());
  }

  public static int infixEvalSolver(int a, int b, char operand) {
    if (operand == '+')
      return a + b;
    else if (operand == '-')
      return a - b;
    else if (operand == '*')
      return a * b;
    return a / b;
  }

  public static String infixConvSolver(String a, String b, char operand) {
    if (operand == '+')
      return "(" + a + "+" + b + ")";
    else if (operand == '-')
      return "(" + a + "-" + b + ")";
    else if (operand == '*')
      return "(" + a + "*" + b + ")";
    return "(" + a + "/" + b + ")";
  }

  public static String postfixConvSolver(String a, String b, char operand) {
    if (operand == '+')
      return a + "" + b + "+";
    else if (operand == '-')
      return a + "" + b + "-";
    else if (operand == '*')
      return a + "" + b + "*";
    return a + "" + b + "/";
  }
}