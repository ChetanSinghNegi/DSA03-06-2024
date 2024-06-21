import java.io.*;
import java.util.*;

public class KnightsTour {

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int sr = scn.nextInt();
    int sc = scn.nextInt();
    scn.close();
    int[][] chess = new int[n][n];
    printKnightsTour(chess, sr, sc, 1);
  }

  public static int[][] direction = new int[][] { { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 },
      { -1, -2 }, { -2, -1 } };

  public static void printKnightsTour(int[][] chess, int sr, int sc, int upcomingMove) {
    int n = chess.length;
    if (sr < 0 || sc < 0 || sr >= n || sc >= n || chess[sr][sc] != 0)
      return;
    if (upcomingMove == n * n) {
      chess[sr][sc] = upcomingMove;
      displayBoard(chess);
      chess[sr][sc] = 0;
      return;
    }

    chess[sr][sc] = upcomingMove;
    for (int i = 0; i < direction.length; i++) {
      printKnightsTour(chess, sr + direction[i][0], sc + direction[i][1], upcomingMove + 1);
    }
    chess[sr][sc] = 0;

  }

  public static void displayBoard(int[][] chess) {
    for (int i = 0; i < chess.length; i++) {
      for (int j = 0; j < chess[0].length; j++) {
        System.out.print(chess[i][j] + " ");
      }
      System.out.println();
    }

    System.out.println();
  }
}