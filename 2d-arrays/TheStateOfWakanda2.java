import java.util.Scanner;

public class TheStateOfWakanda2 {
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[][] arr = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        arr[i][j] = scn.nextInt();
      }
    }
    int diff = 0;
    while (diff < n) {
      int sr = 0;
      int sc = diff;
      while (sc < n) {
        System.out.print(arr[sr][sc] + "=>");
        sr++;
        sc++;
      }
      diff++;
    }
    scn.close();
  }
}
