import java.io.*;
import java.util.*;

public class InfixConversions {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    // code
    InfixToPostFixConversionFunc(exp);
  }

  public static void InfixToPostFixConversionFunc(String str) {
    Stack<String> operatorPostfixSt = new Stack<>();
    Stack<String> operatorPrefixSt = new Stack<>();
    Stack<Character> operandSt = new Stack<>();
    for (char ch : str.toCharArray()) {
      if (ch >= 'a' && ch <= 'z') {
        operatorPostfixSt.push(ch + "");
        operatorPrefixSt.push(ch + "");
      } else if (ch == '(')
        operandSt.push(ch);
      else if (ch == ')') {
        while (operandSt.peek() != '(') {
          calculate(operatorPrefixSt, operatorPostfixSt, operandSt);
        }

        // removing '('
        operandSt.pop();
      } else if (ch == ' ') {
        continue;
      } else {
        if (operandSt.size() == 0) {
          operandSt.push(ch);
        } else {
          while (operandSt.size() > 0 && operandSt.peek() != '(' && precedence(ch) <= precedence(operandSt.peek())) {
            calculate(operatorPrefixSt, operatorPostfixSt, operandSt);
          }
          operandSt.push(ch);
        }
      }

    }
    while (operandSt.size() > 0) {
      calculate(operatorPrefixSt, operatorPostfixSt, operandSt);
    }
    System.out.println(operatorPrefixSt.pop());
    System.out.println(operatorPostfixSt.pop());
    return;
  }

  public static String SolvePostfix(String a, String b, char operand) {
    if (operand == '+')
      return "+" + b + a + "";
    else if (operand == '-')
      return "-" + b + a + "";
    else if (operand == '*')
      return "*" + b + a + "";
    return "/" + b + a + "";
  }

  public static String SolvePrefix(String a, String b, char operand) {
    if (operand == '+')
      return b + a + "+";
    else if (operand == '-')
      return b + a + "-";
    else if (operand == '*')
      return b + a + "*";
    return b + a + "/";
  }

  public static int precedence(char operator) {
    if (operator == '+' || operator == '-')
      return 1;
    return 2;
  }

  public static void calculate(Stack<String> operatorPrefixSt, Stack<String> operatorPostfixSt,
      Stack<Character> operandSt) {
    String a = operatorPostfixSt.pop();
    String b = operatorPostfixSt.pop();
    String c = operatorPrefixSt.pop();
    String d = operatorPrefixSt.pop();
    char operand = operandSt.pop();
    String currRes = SolvePostfix(a, b, operand);
    String currRes2 = SolvePrefix(c, d, operand);
    operatorPostfixSt.push(currRes);
    operatorPrefixSt.push(currRes2);
  }
}