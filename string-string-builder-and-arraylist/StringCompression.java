import java.io.*;
import java.util.*;

public class StringCompression {

  public static String compression1(String str) {
    StringBuilder sb = new StringBuilder("");
    for (int i = 0; i < str.length(); i++) {
      char ch1 = str.charAt(i);
      if (i == 0 || ch1 != str.charAt(i - 1)) {
        sb.append(ch1);
      }

    }

    return sb.toString();
  }

  public static String compression2(String str) {
    StringBuilder sb = new StringBuilder("");
    int count = 1;
    for (int i = 0; i < str.length(); i++) {
      char ch1 = str.charAt(i);
      if (i == 0) {
        sb.append(ch1);
        continue;
      }
      if (ch1 == str.charAt(i - 1)) {
        count++;
      } else {
        if (count != 1)
          sb.append(count);
        sb.append(ch1);
        count = 1;
      }
    }
    if (count != 1)
      sb.append(count);
    return sb.toString();
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String str = scn.next();
    scn.close();
    System.out.println(compression1(str));
    System.out.println(compression2(str));
  }

}
