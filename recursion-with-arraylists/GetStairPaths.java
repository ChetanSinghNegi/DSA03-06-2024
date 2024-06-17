
import java.io.*;
import java.util.*;

public class GetStairPaths {

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    scn.close();
    ArrayList<String> allSubsequence = getStairPaths(n);
    System.out.println(allSubsequence);
  }

  public static ArrayList<String> getStairPaths(int n) {
    if (n == 0) {
      ArrayList<String> base = new ArrayList<>();
      base.add("");
      return base;
    } else if (n < 0)
      return new ArrayList<>();

    ArrayList<String> tillStairPaths1 = getStairPaths(n - 1);
    ArrayList<String> tillStairPaths2 = getStairPaths(n - 2);
    ArrayList<String> tillStairPaths3 = getStairPaths(n - 3);
    ArrayList<String> stairsPathRes = new ArrayList<>();
    for (String stairPath : tillStairPaths1) {
      stairsPathRes.add(1 + "" + stairPath);
    }
    for (String stairPath : tillStairPaths2) {
      stairsPathRes.add(2 + "" + stairPath);
    }
    for (String stairPath : tillStairPaths3) {
      stairsPathRes.add(3 + "" + stairPath);
    }
    return stairsPathRes;
  }

}