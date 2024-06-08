import java.util.Scanner;

public class SpiralDisplay {
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int tr = scn.nextInt();
    int tc = scn.nextInt();
    int[][] arr = new int[tr][tc];
    for (int i = 0; i < tr; i++) {
      for (int j = 0; j < tc; j++) {
        arr[i][j] = scn.nextInt();
      }
    }
    int sr = 0;
    int sc = 0;
    int dr = tr - 1;
    int dc = tc - 1;
    int count = tr * tc;
    while (sr <= dr && sc <= dc) {
      for (int r = sr; r <= dr && count > 0; r++) {
        System.out.print(arr[r][sc] + "  ");
        count--;
      }
      sc++;
      for (int c = sc; c <= dc && count > 0; c++) {
        System.out.print(arr[dr][c] + "  ");
        count--;
      }
      dr--;
      for (int r = dr; r >= sr && count > 0; r--) {
        System.out.print(arr[r][dc] + "  ");
        count--;
      }
      dc--;
      for (int c = dc; c >= sc && count > 0; c--) {
        System.out.print(arr[sr][c] + "  ");
        count--;
      }
      sr++;
      System.out.println();
    }
    scn.close();
  }
}

// 6
// 5
// 11 12 13 14 15
// 21 22 23 24 25
// 31 32 33 34 35
// 41 42 43 44 45
// 51 52 53 54 55
// 61 62 63 64 65