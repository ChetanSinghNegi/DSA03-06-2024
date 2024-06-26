import java.io.*;
import java.util.*;

public class PrintSubsequence {

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    String str = scn.next();
    printSS(str, "");
    scn.close();
  }

  public static void printSS(String str, String ans) {
    if (str.length() == 0) {
      System.out.println(ans);
      return;
    }

    char ch = str.charAt(0);
    printSS(str.substring(1), ans + ch);
    printSS(str.substring(1), ans);
  }

}