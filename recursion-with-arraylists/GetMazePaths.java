import java.io.*;
import java.util.*;

public class GetMazePaths {

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int tr = scn.nextInt();
    int tc = scn.nextInt();
    ArrayList<String> allMazePaths = getMazePaths(0, 0, tr - 1, tc - 1);
    System.out.println(allMazePaths);
    scn.close();
  }

  // sr - source row
  // sc - source column
  // dr - destination row
  // dc - destination column
  public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
    if (sr > dr || sc > dc)
      return new ArrayList<>();

    if (sr == dr && sc == dc) {
      ArrayList<String> base = new ArrayList<>();
      base.add("");
      return base;
    }

    ArrayList<String> allPaths = new ArrayList<>();
    ArrayList<String> horizontalMazePath = getMazePaths(sr, sc + 1, dr, dc);
    for (String str : horizontalMazePath) {
      allPaths.add("h" + str);
    }
    ArrayList<String> verticalMazePath = getMazePaths(sr + 1, sc, dr, dc);
    for (String str : verticalMazePath) {
      allPaths.add("v" + str);
    }
    return allPaths;
  }

}