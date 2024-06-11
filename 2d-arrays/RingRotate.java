import java.io.*;
import java.util.*;

public class RingRotate {

  public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    int tr = scn.nextInt();
    int tc = scn.nextInt();
    int[][] arr = new int[tr][tc];
    for (int i = 0; i < tr; i++) {
      for (int j = 0; j < tc; j++) {
        arr[i][j] = scn.nextInt();
      }
    }
    int s = scn.nextInt();
    int r = scn.nextInt();
    scn.close();
    int sr = s - 1;
    int sc = s - 1;
    int dr = tr - s;
    int dc = tc - s;
    int totalEle = 2 * (dr + dc - sr - sc);
    int[] ringElements = new int[totalEle];
    fillRingElements(sr, sc, dr, dc, ringElements, arr);
    rotate(ringElements, r);
    fillBackOriginalArray(sr, sc, dr, dc, ringElements, arr);
    display(arr);
  }

  public static void rotate(int[] a, int k) {
    // write your code here
    int n = a.length;
    int mid = n - k;
    reverse(a, 0, mid - 1);
    reverse(a, mid, n - 1);
    reverse(a, 0, n - 1);
  }

  public static void reverse(int[] a, int li, int ri) {
    while (li < ri) {
      int temp = a[li];
      a[li] = a[ri];
      a[ri] = temp;
      ri--;
      li++;
    }
  }

  public static void fillRingElements(int sr, int sc, int dr, int dc, int[] ringElements, int[][] arr) {
    int itr = 0;
    for (int r = sr; r <= dr; r++) {
      ringElements[itr++] = arr[r][sc];
    }
    sc++;
    for (int c = sc; c <= dc; c++) {
      ringElements[itr++] = arr[dr][c];
    }
    dr--;
    for (int r = dr; r >= sr; r--) {
      ringElements[itr++] = arr[r][dc];
    }
    dc--;
    for (int c = dc; c >= sc; c--) {
      ringElements[itr++] = arr[sr][c];
    }
    sr++;
  }

  public static void fillBackOriginalArray(int sr, int sc, int dr, int dc, int[] ringElements, int[][] arr) {
    int itr = 0;
    for (int r = sr; r <= dr; r++) {
      arr[r][sc] = ringElements[itr++];
    }
    sc++;
    for (int c = sc; c <= dc; c++) {
      arr[dr][c] = ringElements[itr++];
    }
    dr--;
    for (int r = dr; r >= sr; r--) {
      arr[r][dc] = ringElements[itr++];
    }
    dc--;
    for (int c = dc; c >= sc; c--) {
      arr[sr][c] = ringElements[itr++];
    }
    sr++;
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
