import java.io.*;
import java.util.*;

public class PoweLinear {

  public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    int x = scn.nextInt();
    int n = scn.nextInt();
    int powerValue = power(x, n);
    System.out.println(powerValue);
    scn.close();
  }

  public static int power(int x, int n) {
    if (n == 0)
      return 1;

    return x * power(x, n - 1);
  }

}