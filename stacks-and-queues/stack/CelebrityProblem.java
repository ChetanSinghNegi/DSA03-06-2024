import java.io.*;
import java.util.*;

public class CelebrityProblem {

  public static void main(String[] args) throws Exception {
    // write your code here
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[][] arr = new int[n][n];

    for (int j = 0; j < n; j++) {
      String line = br.readLine();
      for (int k = 0; k < n; k++) {
        arr[j][k] = line.charAt(k) - '0';
      }
    }

    findCelebrity(arr);

  }

  public static void findCelebrity(int[][] arr) {
    // if a celebrity is there print it's index (not position), if there is not then
    // print "none"

    int n = arr.length;
    Stack<Integer> st = new Stack<>();
    for (int i = 0; i < n; i++) {
      st.push(i);
    }
    while (st.size() > 1) {
      int f1 = st.pop();
      int f2 = st.pop();
      if (arr[f1][f2] == 1) {
        // if f1 knows f2 so f1 can't be celeb.
        st.push(f2);
      } else {
        // if f1 doesn't know f2 so f2 can't be celeb.
        st.push(f1);
      }
    }
    int potentialCeleb = st.pop();
    System.out.println(potentialCeleb);
    for (int i = 0; i < n; i++) {
      if (i != potentialCeleb && (arr[potentialCeleb][i] != 0 || arr[i][potentialCeleb] != 1)) {
        System.out.println("No Celebrity");
        return;
      }
    }
    System.out.println("Celebrity => " + potentialCeleb);
  }

}
