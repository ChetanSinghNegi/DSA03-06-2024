import java.io.*;
import java.util.*;

public class PrintMazePaths {

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int tr = scn.nextInt();
    int tc = scn.nextInt();
    printMazePaths(0, 0, tr - 1, tc - 1, "");
    scn.close();
  }

  // sr - source row
  // sc - source column
  // dr - destination row
  // dc - destination column
  public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {
    if (sr == dr && sc == dc) {
      System.out.println(psf);
      return;
    } else if (sr > dr || sc > dc)
      return;

    printMazePaths(sr, sc + 1, dr, dc, psf + "h");
    printMazePaths(sr + 1, sc, dr, dc, psf + "v");

  }

}
