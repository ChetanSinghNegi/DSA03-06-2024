import java.io.*;
import java.util.*;

public class GetKpc {

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    String str = scn.next();
    scn.close();
    ArrayList<String> allSubsequence = getKPC(str);
    System.out.println(allSubsequence);
  }

  static String[] keypad = { ".;", "abc", "def",
      "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz" };

  public static ArrayList<String> getKPC(String str) {
    if (str.length() == 0) {
      ArrayList<String> base = new ArrayList<>();
      base.add("");
      return base;
    }
    ArrayList<String> tillSubsequences = getKPC(str.substring(1));
    int idx = str.charAt(0) - '0';
    String keysForIdx = keypad[idx];
    ArrayList<String> currentResult = new ArrayList<>();
    for (char ch : keysForIdx.toCharArray()) {
      for (String subsequence : tillSubsequences) {
        currentResult.add(ch + subsequence + "");
      }
    }
    return currentResult;
  }

}