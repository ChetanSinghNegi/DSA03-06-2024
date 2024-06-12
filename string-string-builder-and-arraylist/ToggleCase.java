import java.io.*;
import java.util.*;

public class ToggleCase {

  public static String toggleCase(String str) {
    StringBuilder res = new StringBuilder("");
    for (char ch : str.toCharArray()) {
      if (ch > 96) {
        res.append((char) (ch - ('a' - 'A')));
      } else {
        res.append((char) (ch + ('a' - 'A')));
      }
    }
    return res.toString();
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String str = scn.next();
    scn.close();
    System.out.println(toggleCase(str));
  }

}
