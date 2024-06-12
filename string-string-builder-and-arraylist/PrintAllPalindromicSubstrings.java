import java.util.Scanner;

public class PrintAllPalindromicSubstrings {

  public static void solution(String str) {
    // write your code here
    int n = str.length();
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j <= n; j++) {
        String subStr = str.substring(i, j);
        boolean isPalindromic = isPalindromicFunc(subStr);
        if (isPalindromic)
          System.out.println(subStr);
      }
    }
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String str = scn.next();
    solution(str);
    scn.close();
  }

  public static boolean isPalindromicFunc(String str) {
    int li = 0;
    int hi = str.length() - 1;
    while (li <= hi) {
      if (str.charAt(li) != str.charAt(hi))
        return false;
      li++;
      hi--;
    }
    return true;
  }

}
