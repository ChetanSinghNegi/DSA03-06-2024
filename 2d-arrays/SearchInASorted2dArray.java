import java.util.Scanner;

public class SearchInASorted2dArray {
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[][] arr = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        arr[i][j] = scn.nextInt();
      }
    }
    int target = scn.nextInt();
    scn.close();
    int sr = 0;
    int sc = n - 1;
    while (sc >= 0 && sr < n) {
      if (arr[sr][sc] > target) {
        sc--;
      } else if (arr[sr][sc] < target) {
        sr++;
      } else {
        System.out.println(sr + " " + sc);
        return;
      }
    }
    System.out.println("Not Found");
  }
}
