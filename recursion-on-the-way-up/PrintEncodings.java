import java.io.*;
import java.util.*;

public class PrintEncodings {

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    String str = scn.next();
    printEncodings(str, "");
    scn.close();
  }

  public static void printEncodings(String str, String asf) {
    if (str.length() == 0) {
      System.out.println(asf);
      return;
    }

    int fDigit = str.charAt(0) - '0';
    if (fDigit == 0)
      return;
    char fChar = (char) ('a' + fDigit - 1);
    printEncodings(str.substring(1), asf + fChar);
    if (str.length() > 1) {
      int sDigit = str.charAt(1) - '0';
      sDigit = fDigit * 10 + sDigit;
      if (sDigit > 26)
        return;
      char sChar = (char) ('a' + sDigit - 1);
      printEncodings(str.substring(2), asf + sChar);
    }
  }

}