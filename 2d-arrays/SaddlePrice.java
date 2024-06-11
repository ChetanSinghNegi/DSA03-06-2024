import java.util.Scanner;

public class SaddlePrice {
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[][] arr = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        arr[i][j] = scn.nextInt();
      }
    }
    scn.close();
    for (int i = 0; i < n; i++) {
      int rowMinCol = findMinInRow(arr[i]);
      boolean isMaxInRow = isMaxInRowFunc(rowMinCol, arr[i][rowMinCol], arr);
      if (isMaxInRow) {
        System.out.println(arr[i][rowMinCol]);
        return;
      }
    }
    System.out.println("Invalid input");
  }

  public static boolean isMaxInRowFunc(int rowMinCol, int tillMin, int[][] arr) {
    for (int i = 0; i < arr.length; i++) {
      if (tillMin < arr[i][rowMinCol])
        return false;
    }
    return true;
  }

  public static int findMinInRow(int[] arr) {
    int ans = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] < arr[ans])
        ans = i;
    }
    return ans;
  }
}
