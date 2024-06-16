
import java.io.*;
import java.util.*;

public class PrintZigzag {

  public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    String pzzString = pzz(n);
    System.out.println(pzzString);
    scn.close();
  }

  public static String pzz(int n) {
    if (n == 1)
      return "1 1 1";

    String tillString = pzz(n - 1);
    return n + " " + tillString + " " + n + " " + tillString + " " + n;
  }

}