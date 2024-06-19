import java.io.*;
import java.util.*;

public class GetMazePathWithJumps {

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
    for (int i = 1; i <= dc - sc; i++) {
      ArrayList<String> horizontalMazePath = getMazePaths(sr, sc + i, dr, dc);
      for (String str : horizontalMazePath) {
        allPaths.add("h" + i + str);
      }
    }
    for (int i = 1; i <= dr - sr; i++) {
      ArrayList<String> verticalMazePath = getMazePaths(sr + i, sc, dr, dc);
      for (String str : verticalMazePath) {
        allPaths.add("v" + i + str);
      }
    }
    for (int i = 1; i <= Math.min(dr - sr, dc - sc); i++) {
      ArrayList<String> diagonalMazePath = getMazePaths(sr + i, sc + i, dr, dc);
      for (String str : diagonalMazePath) {
        allPaths.add("d" + i + str);
      }
    }
    return allPaths;
  }

}