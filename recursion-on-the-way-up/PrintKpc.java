
import java.io.*;
import java.util.*;

public class PrintKpc {

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    String str = scn.next();
    scn.close();
    printKPC(str, "");
  }

  static String[] keypad = { ".;", "abc", "def",
      "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz" };

  public static void printKPC(String str, String asf) {
    if (str.length() == 0) {
      System.out.println(asf);
      return;
    }

    int codeIdx = str.charAt(0) - '0';
    String keypadCodes = keypad[codeIdx];
    String substring = str.substring(1);
    for (char alphabet : keypadCodes.toCharArray()) {
      printKPC(substring, asf + alphabet + "");
    }
  }

}