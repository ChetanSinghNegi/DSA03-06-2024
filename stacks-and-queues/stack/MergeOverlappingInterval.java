import java.io.*;
import java.util.*;

public class MergeOverlappingInterval {

  public static class Mover implements Comparable<Mover> {
    int st;
    int et;

    Mover(int st, int et) {
      this.st = st;
      this.et = et;
    }

    public int compareTo(Mover b) {
      if (this.st > b.st) {
        return 1;
      } else if (this.st < b.st) {
        return -1;
      } else {
        return this.et - b.et;
      }
    }
  }

  public static void main(String[] args) throws Exception {
    // write your code here
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[][] arr = new int[n][2];

    for (int j = 0; j < n; j++) {
      String line = br.readLine();
      arr[j][0] = Integer.parseInt(line.split(" ")[0]);
      arr[j][1] = Integer.parseInt(line.split(" ")[1]);
    }

    mergeOverlappingIntervals(arr);
  }

  public static void mergeOverlappingIntervals(int[][] arr) {
    // merge overlapping intervals and print in increasing order of start time
    int n = arr.length;
    ArrayList<Mover> al = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      Mover mover = new Mover(arr[i][0], arr[i][1]);
      al.add(mover);
    }
    Collections.sort(al);
    if (al.size() > 0) {
      Mover mb = al.get(0);
      for (int i = 1; i < al.size(); i++) {
        Mover currMover = al.get(i);
        if (mb.et >= currMover.et || (mb.et > currMover.st && mb.et < currMover.et)) {
          mb.et = Math.max(mb.et, currMover.et);
        } else {
          System.out.println(mb.st + "  " + mb.et);
          mb = currMover;
        }
      }
      System.out.println(mb.st + "  " + mb.et);
    }
  }

}