public class DifferenceOfTwoArrays {
  public static void main(String[] args) {
    int[] a1 = new int[] { 2, 6, 7 };
    int[] a2 = new int[] { 1, 0, 0, 0, 0, 0 };
    int[] ans = new int[Math.max(a1.length, a2.length)];
    int r1 = a1.length - 1;
    // int r2 = a2.length - 1;
    int i = ans.length - 1;
    boolean c = false;
    while (i >= 0) {
      ans[i] = a2[i];
      if (c)
        ans[i]--;
      if (r1 >= 0)
        ans[i] -= a1[r1--];
      if (ans[i] < 0) {
        ans[i] += 10;
        c = true;
      } else {
        c = false;
      }
      i--;
    }
    for (int itr = 0; itr < ans.length; itr++) {
      if (itr == 0 && ans[itr] == 0)
        continue;
      System.out.println(ans[itr]);
    }
  }
}
