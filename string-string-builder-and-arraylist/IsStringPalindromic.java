
public class IsStringPalindromic {
  public static void main(String[] args) {
    String s1 = "aavxcaa";
    boolean ans = isPalindromicFunc(s1);
    System.out.println(ans);
  }

  public static boolean isPalindromicFunc(String str) {
    int li = 0;
    int hi = str.length() - 1;
    while (li <= hi) {
      if (str.charAt(li) != str.charAt(hi))
        return false;
      li++;
      hi--;
    }
    return true;
  }
}
