import java.io.*;
import java.util.*;

public class FloodFill {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int m = scn.nextInt();
    int[][] arr = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        arr[i][j] = scn.nextInt();
      }
    }
    floodfill(arr, 0, 0, "");
  }

  public static int dir[][] = new int[][] { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

  // asf -> answer so far
  public static void floodfill(int[][] maze, int sr, int sc, String asf) {
    if (sr < 0 || sc < 0 || sr == maze.length || sc == maze[0].length || maze[sr][sc] == 1)
      return;
    else if (sr == maze.length - 1 && sc == maze[0].length - 1) {
      System.out.println(asf);
      return;
    }

    maze[sr][sc] = 1;
    for (int i = 0; i < 4; i++) {
      char ch;
      if (i == 0)
        ch = 't';
      else if (i == 1)
        ch = 'l';
      else if (i == 2)
        ch = 'd';
      else
        ch = 'r';
      floodfill(maze, sr + dir[i][0], sc + dir[i][1], asf + ch);
    }
    maze[sr][sc] = 0;
  }
}
