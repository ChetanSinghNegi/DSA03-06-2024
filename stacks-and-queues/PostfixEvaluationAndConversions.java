import java.io.*;
import java.util.*;

public class PostfixEvaluationAndConversions {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    // code
    multisolver(exp);
  }

  public static void multisolver(String str) {
    Stack<Integer> evalSt = new Stack<>();
    Stack<String> infixSt = new Stack<>();
    Stack<String> prefixSt = new Stack<>();
    for (char ch : str.toCharArray()) {
      if (ch >= '0' && ch <= '9') {
        evalSt.push(ch - '0');
        prefixSt.push(ch + "");
        infixSt.push(ch + "");
      } else {
        int fNum = evalSt.pop();
        int sNum = evalSt.pop();
        int currRes = Solve(fNum, sNum, ch);
        evalSt.push(currRes);

        // prefix
        String preFNum = prefixSt.pop();
        String preSNum = prefixSt.pop();
        prefixSt.push(ch + "" + preSNum + "" + preFNum);

        // Infix
        String infixFNum = infixSt.pop();
        String infixSNum = infixSt.pop();
        infixSt.push("(" + infixSNum + "" + ch + "" + infixFNum + ")");

      }
    }
    System.out.println(evalSt.pop());
    System.out.println(infixSt.pop());
    System.out.println(prefixSt.pop());
  }

  public static int Solve(int a, int b, char operand) {
    if (operand == '+')
      return b + a;
    else if (operand == '-')
      return b - a;
    else if (operand == '*')
      return b * a;
    return b / a;
  }
}