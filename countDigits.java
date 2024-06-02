public class countDigits {
  public static void main(String[] args) {
    // write your code here
    int a = 5431234;
    int count = 0;
    while (a != 0) {
      a /= 10;
      count++;
    }
    System.out.println(count);
  }
}
