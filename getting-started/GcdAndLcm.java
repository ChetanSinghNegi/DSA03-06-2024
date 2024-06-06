public class GcdAndLcm {
  public static void main(String[] args) {
    int n1 = 30;
    int n2 = 42;
    int n1C = n1;
    int n2C = n2;
    while (n2 != 0) {
      int rem = n1 % n2;
      n1 = n2;
      n2 = rem;
    }
    System.out.println("GCD=> " + n1);
    System.out.println("LCM=> " + (n1C * n2C / n1));

  }
}
