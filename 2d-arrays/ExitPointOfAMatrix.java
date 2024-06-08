import java.util.Scanner;

public class ExitPointOfAMatrix {
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
    int resultRow = 0;
    int resultCol = 0;
    int[][] dir = new int[][] {
        { 0, 1 },
        { 1, 0 },
        { 0, -1 },
        { -1, 0 }
    };
    int currDir = 0;
    while (sr >= 0 && sr < tr && sc >= 0 && sc < tc) {
      // saving till result coordinates
      resultRow = sr;
      resultCol = sc;

      // direction change if required
      if (arr[sr][sc] == 1)
        currDir++;
      currDir %= 4;

      // moving to direction
      sr += dir[currDir][0];
      sc += dir[currDir][1];
    }

    System.out.println(resultRow + "  " + resultCol);
    scn.close();
  }
}

// 4 4 0 0 1 0 1 0 0 0 0 0 0 0 1 0 1 0