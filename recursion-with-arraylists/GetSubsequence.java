import java.io.*;
import java.util.*;

public class GetSubsequence {

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    String str = scn.next();
    ArrayList<String> allSubsequence = gss(str);
    System.out.println(allSubsequence);

  }

  public static ArrayList<String> gss(String str) {
    if (str.length() == 0) {
      ArrayList<String> base = new ArrayList<>();
      base.add("");
      return base;
    }
    ArrayList<String> tillSubsequences = gss(str.substring(1));
    char ch = str.charAt(0);
    ArrayList<String> currentResult = new ArrayList<>();
    for (String subsequence : tillSubsequences) {
      currentResult.add(subsequence);
    }
    for (String subsequence : tillSubsequences) {
      currentResult.add(ch + "" + subsequence);
    }
    return currentResult;
  }

}