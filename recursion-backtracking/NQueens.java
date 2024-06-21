import java.io.*;
import java.util.*;

public class NQueens {

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    scn.close();
    int[][] chess = new int[n][n];
    printNQueens(chess, "", 0);
  }

  public static boolean isSafeFunc(int[][] chess, int sr, int sc) {

    // left diagonal
    for (int i = sr - 1, j = sc - 1; i >= 0 && j >= 0; i--, j--) {
      if (chess[i][j] == 1)
        return false;
    }

    // up column
    for (int i = sr - 1; i >= 0; i--) {
      if (chess[i][sc] == 1)
        return false;
    }

    // right diagonal
    for (int i = sr - 1, j = sc + 1; i >= 0 && j < chess.length; i--, j++) {
      if (chess[i][j] == 1)
        return false;
    }
    return true;
  }

  public static void printNQueens(int[][] chess, String qsf, int row) {
    if (row == chess.length) {
      System.out.println(qsf + ".");
      return;
    }

    for (int i = 0; i < chess.length; i++) {
      boolean isSafe = isSafeFunc(chess, row, i);

      // not safe for queen
      if (!isSafe)
        continue;

      // safe for queen
      chess[row][i] = 1;
      printNQueens(chess, qsf + row + "-" + i + ", ", row + 1);
      chess[row][i] = 0;
    }
  }
}