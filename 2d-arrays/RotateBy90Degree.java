import java.util.Scanner;

public class RotateBy90Degree {
  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[][] arr = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        arr[i][j] = scn.nextInt();
      }
    }
    transponse(arr);
    reverseRow(arr);
    display(arr);
    scn.close();
  }

  // finding transpose
  public static void transponse(int[][] arr) {
    int n = arr.length;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        int temp = arr[i][j];
        arr[i][j] = arr[j][i];
        arr[j][i] = temp;
      }
    }
  }

  // reversing every row
  public static void reverseRow(int[][] arr) {
    int n = arr.length;
    for (int r = 0; r < n; r++) {
      int li = 0;
      int ri = n - 1;
      while (li < ri) {
        int temp = arr[r][li];
        arr[r][li] = arr[r][ri];
        arr[r][ri] = temp;
        li++;
        ri--;
      }

    }
  }

  public static void display(int[][] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[0].length; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }
  }
}
