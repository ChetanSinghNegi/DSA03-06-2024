import java.io.*;
import java.util.*;

public class StringWithDifferenceOfEveryTwoConsecutiveCharacters {

  public static String solution(String str) {
    StringBuilder sb = new StringBuilder("");
    for (int i = 0; i < str.length(); i++) {
      char ch1 = str.charAt(i);
      sb.append(ch1);
      if (i + 1 == str.length())
        break;
      char ch2 = str.charAt(i + 1);
      int diff = ch2 - ch1;
      sb.append(diff);
    }

    return sb.toString();
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String str = scn.next();
    scn.close();
    System.out.println(solution(str));
  }

}