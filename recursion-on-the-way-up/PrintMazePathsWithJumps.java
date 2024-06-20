import java.io.*;
import java.util.*;

public class PrintMazePathsWithJumps {

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int tr = scn.nextInt();
    int tc = scn.nextInt();
    getMazePaths(0, 0, tr - 1, tc - 1, "");
    scn.close();
  }

  // sr - source row
  // sc - source column
  // dr - destination row
  // dc - destination column
  public static void getMazePaths(int sr, int sc, int dr, int dc, String psf) {
    if (sr > dr || sc > dc)
      return;

    if (sr == dr && sc == dc) {
      System.out.println(psf);
      return;
    }

    for (int i = 1; i <= dc - sc; i++) {
      getMazePaths(sr, sc + i, dr, dc, psf + "h" + i);
    }

    for (int i = 1; i <= dr - sr; i++) {
      getMazePaths(sr + i, sc, dr, dc, psf + "v" + i);
    }
    for (int i = 1; i <= Math.min(dr - sr, dc - sc); i++) {
      getMazePaths(sr + i, sc + i, dr, dc, psf + "d" + i);
    }
  }

}