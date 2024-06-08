import java.util.Scanner;

public class TheStateOfWakanda1 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tr = sc.nextInt();
    int tc = sc.nextInt();
    int[][] arr = new int[tr][tc];
    for (int i = 0; i < tr; i++) {
      for (int j = 0; j < tc; j++) {
        arr[i][j] = sc.nextInt();
      }
    }
    for (int c = 0; c < tc; c++) {
      if (c % 2 == 0) {
        for (int r = 0; r < tr; r++) {
          System.out.print(arr[r][c] + "=>");
        }
      } else {
        for (int r = tr - 1; r >= 0; r--) {
          System.out.print(arr[r][c] + "=>");
        }
      }
      System.out.println();
    }
    sc.close();
  }
}

// 3 4 11 12 13 14 21 22 23 24 31 32 33 34

// 11 21 31 32 22 12 13 23 33 34 24 14