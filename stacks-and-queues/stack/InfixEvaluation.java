import java.io.*;
import java.util.*;

public class InfixEvaluation {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    // code
    int result = InfixEvaluationFunc(exp);
    System.out.println("Result => " + result);
  }

  public static int InfixEvaluationFunc(String str) {
    Stack<Integer> operatorSt = new Stack<>();
    Stack<Character> operandSt = new Stack<>();
    for (char ch : str.toCharArray()) {
      if (ch >= '0' && ch <= '9') {
        operatorSt.push(ch - '0');
      } else if (ch == '(')
        operandSt.push(ch);
      else if (ch == ')') {
        while (operandSt.peek() != '(') {
          calculate(operatorSt, operandSt);
        }

        // removing '('
        operandSt.pop();
      } else if (ch == ' ') {
        continue;
      } else {
        if (operandSt.size() == 0)
          operandSt.push(ch);
        else {
          while (operandSt.size() > 0 && operandSt.peek() != '(' && precedence(ch) <= precedence(operandSt.peek())) {
            calculate(operatorSt, operandSt);
          }
          operandSt.push(ch);
        }
      }
    }
    while (operandSt.size() > 0) {
      calculate(operatorSt, operandSt);
    }
    return operatorSt.pop();

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

  public static int precedence(char operator) {
    if (operator == '+' || operator == '-')
      return 1;
    return 2;
  }

  public static void calculate(Stack<Integer> operatorSt, Stack<Character> operandSt) {
    int a = operatorSt.pop();
    int b = operatorSt.pop();
    char operand = operandSt.pop();
    int currRes = Solve(a, b, operand);
    operatorSt.push(currRes);
  }
}