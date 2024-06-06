public class SumOfTwoArrays {
  public static void main(String[] args) {
    int[] a1 = new int[] { 3, 1, 0, 7, 5 };
    int[] a2 = new int[] { 1, 1, 1, 1, 1, 1 };
    int[] ans = new int[Math.max(a1.length, a2.length) + 1];
    int r1 = a1.length - 1;
    int r2 = a2.length - 1;
    int i = ans.length - 1;
    int c = 0;
    while (r1 >= 0 || r2 >= 0) {
      if (r1 >= 0)
        ans[i] += a1[r1--];
      if (r2 >= 0)
        ans[i] += a2[r2--];
      ans[i] += c;
      c = ans[i] / 10;
      ans[i] = ans[i] % 10;
      i--;
    }
    for (int itr = 0; itr < ans.length; itr++) {
      if (itr == 0 && ans[itr] == 0)
        continue;
      System.out.println(ans[itr]);
    }
  }
}
