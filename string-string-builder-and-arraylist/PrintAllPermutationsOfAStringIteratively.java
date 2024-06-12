import java.util.*;

public class PrintAllPermutationsOfAStringIteratively {

  public static void solution(String str) {
    int count = str.length();
    int factorialValue = factorialFunc(count);
    for (int i = 0; i < factorialValue; i++) {
      String permutation = getPermutation(i, str);
      System.out.println(permutation);
    }
  }

  public static String getPermutation(int i, String str) {
    int count = str.length();
    StringBuilder strSb = new StringBuilder(str);
    StringBuilder ans = new StringBuilder("");
    while (count != 0) {
      int rem = i % count;
      int quo = i / count;
      i = quo;
      ans.append(strSb.charAt(rem));
      strSb.deleteCharAt(rem);
      count--;
    }
    return ans.toString();
  }

  public static int factorialFunc(int count) {
    int res = 1;
    while (count != 1) {
      res *= count;
      count--;
    }
    return res;
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String str = scn.next();
    scn.close();
    solution(str);
  }

}